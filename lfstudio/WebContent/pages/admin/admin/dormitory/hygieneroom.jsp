<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dormitory.name }</title>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script
	src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<linl rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/sweetalert.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	section{
		margin-top: 50px;
	}
	.breadcrumb li {
		margin: 0 5px;
	}
	.dormitory-outbox{
		padding: 0 3px;
		margin: 0;
	}
	.dormitory-box{
		height:80px;
		padding:0px;
	}
	.dormitory-box h4{
		display: inline-block;
		height: 38px;
		width: 100%;
		text-align: center;
		line-height: 38px;
		border:1px solid #999;
		margin: 0;
	}
	.shuru{
		height: 38px;
		width: 100%;
		border:1px solid #999;
		border-top: 0px;
		padding: 5px;
		text-align: center;
	}
	h2{
		text-align: center;
	}
	#btnok{
		margin-top: 50px;
	}
	#loading{
		height: 40px;
		width: 40px;
		position: fixed;
		top: 50%;
		left: 50%;
		margin-top: -20px;
		margin-left: -20px;
		z-index: 100;
	}
	.load{
		display:none;
		height: 100%;
		width: 100%;
		position: fixed;
		background: rgba(0,0,0,0.2);
		z-index: 50;
	}
</style>
</head>
<body>
	<% 
		if(request.getAttribute("message")!=null&&!request.getAttribute("message").equals("")){
			out.print("<script>swal('"+request.getAttribute("message")+"');</script>");
		}
	%>
	<header>
		<div class="load">
			<img alt="loadimg" id="loading" src="<%= request.getContextPath() %>/resources/images/admin/loading.gif" />
		</div>
		<div>
			<ul class="breadcrumb">
				<li><a
					href="<%= request.getContextPath()+"/admin/hygiene.shtml" %>">宿舍楼选择</a>
				</li>/
				<li class="active">${dormitory.name }</li>
			</ul>
		</div>
		<h2>${dormitory.name }卫生评分表</h2>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix dormitory">
				<c:set var="floor" value="1"></c:set>
				<c:forEach items="${rooms }" var="room">
					<c:if test="${room.floor != floor }">
			</div>
			<div class="row clearfix dormitory">
				<c:set var="floor" value="${room.floor }"></c:set>
				</c:if>
				<div class="col-md-1 column dormitory-outbox">
					<div class="dormitory-box">
						<h4>${room.floor}-${room.name }</h4><br />
						<input class="shuru" data-id="${room.aboutid }" value="${room.abouthygiene }" />
					</div>
				</div>
				</c:forEach>
			</div>
			<button id="btnok" type="button" class="btn btn-default btn-block btn-info" onclick="btnok()">修改</button>
		</div>
	</section>
	<script type="text/javascript">
		function btnok(){
			var time = setTimeout(function () {

		        $(".load").css("display","block");

		    }, 600);
			for(var i=0;i<$(".shuru").length;i++){
				if($.trim($(".shuru").val())==""){
					swal("您输入的分数有误！请您检查");
					return false;
				}
				if(isNaN($(".shuru").val())){
					swal("您输入的分数格式不正确！请您检查");
					return false;
				}
				if(parseFloat($(".shuru").val())<0){
					swal("最低分为0");
					return false;
				}
				if(parseFloat($(".shuru").val())>100){
					swal("最高分为100");
					return false;
				}
			}
			var JSONObject= [];
			for(var i=0;i<$(".shuru").length;i++){
				JSONObject[i] = {
					"aboutid":$(".shuru").eq(i).attr("data-id"),
					"abouthygiene":$(".shuru").eq(i).val()
				}
			}
			$.ajax({
	             type: "POST",
	             url: "<%= request.getContextPath() %>/admin/xiugaifenshu.shtml",
	             contentType:"application/json;charset=utf-8",
	             data: JSON.stringify(JSONObject),
	             dataType: "json",
	             success: function(data){
	            	 clearTimeout(time);
	            	 if(data.flag){
	            		 swal("修改成功！");
	            	 }else{
	            		 swal("修改失败，请重新修改");
	            	 }
	                      }
	         });
		}
	</script>
	<footer></footer>
</body>
</html>