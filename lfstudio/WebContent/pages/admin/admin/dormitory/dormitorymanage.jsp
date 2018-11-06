<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿舍楼管理</title>
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
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

header {
	margin-top: 50px;
}

.dormitory {
	margin-top: 30px;
}

.dormitory-box {
	border: 1px solid #999;
	padding: 10px;
	text-align: center;
	cursor: pointer;
	background: #efefef;
	position: relative;
}

.dormitory-box h3 {
	color: #666;
}

.dormitory-box a {
	text-decoration: none;
}

.dormitory-box a:hover h3 {
	color: #ff9900;
}

.remove {
	display: none;
	position: absolute;
	right: 3px;
	top: 0px;
	color: red;
}

.dormitory-outbox {
	margin-top: 10px;
	margin-bottom: 10px;
}

span {
	font-size: 12px;
}

#dormitoryname {
	height: 30px;
	width: 100%;
	padding: 5px 20px;
	background: #efefef;
	color: #666;
	outline: none;
	border: 0;
	border-radius: 5px;
}
</style>
</head>
<body>
	<% 
		if(request.getAttribute("message")!=null&&!request.getAttribute("message").equals("")){
			out.print("<script>alert('"+request.getAttribute("message")+"');</script>");
		}
	%>
	<header></header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<button type="button" class="btn btn-default btn-block btn-success"
						data-toggle="modal" data-target="#myModal">新增宿舍楼</button>
				</div>
			</div>
			<div class="row clearfix dormitory">
				<c:forEach items="${dormitorylist }" var="dormitory">
					<div class="col-md-3 column dormitory-outbox">
						<div class="dormitory-box">
							<a
								href="<%= request.getContextPath() %>/admin/dormitoryroom.shtml?pid=${dormitory.id }"><h3>${dormitory.name }</h3></a><i
								class="fa fa-close remove" domitoryname="${dormitory.name }"
								domitoryid="${dormitory.id }"></i>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- 模态框头部 -->
					<div class="modal-header">
						<h4 class="modal-title">
							请输入新增宿舍楼名字！<span>(格式为：第1栋宿舍楼)</span>
						</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- 模态框主体 -->
					<div class="modal-body">
						<input type="text" id="dormitoryname" />
					</div>

					<!-- 模态框底部 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" id="addbtn">新增</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
	(function(){
		$(".dormitory-box").hover(function(){
			$(this).find("i").css("display","inline-block");
			$(this).css("background","#ddd");
		},function(){
			$(this).find("i").css("display","none");
			$(this).css("background","#efefef");
		});
		$(".remove").click(function(){
			if(confirm("确定删除名字为“"+$(this).attr("domitoryname")+"”的宿舍楼？")){
				window.location.href="<%= request.getContextPath() %>/admin/optiondormitory.shtml?act=delete&id="+$(this).attr("domitoryid");
			}
		});
		$("#addbtn").click(function(){
			if($.trim($("#dormitoryname").val()) ==""){
				alert("输入不能为空！");
				return;
			}
			window.location.href="<%= request.getContextPath() %>/admin/optiondormitory.shtml?act=insert&name="+$("#dormitoryname").val();
		});
	}(jQuery));
	</script>
	<footer></footer>
</body>
</html>