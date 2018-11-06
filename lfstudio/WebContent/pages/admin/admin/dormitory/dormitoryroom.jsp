<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿舍楼</title>
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

section {
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
.dormitory-box span{
	font-size: 12px;
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

.breadcrumb li {
	margin: 0 5px;
}
</style>
</head>
<body>
	<% 
		if(request.getAttribute("message")!=null&&!request.getAttribute("message").equals("")){
			out.print("<script>alert('"+request.getAttribute("message")+"');</script>");
		}
	%>
	<header>
		<div>
			<ul class="breadcrumb">
				<li><a
					href="<%= request.getContextPath()+"/admin/dormitory.shtml" %>">宿舍楼管理</a>
				</li>/
				<li class="active">${dormitory.name }</li>
			</ul>
		</div>
	</header>
	<section>

		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<a
						href="<%= request.getContextPath()+"/admin/optiondormitoryroom.shtml?act=insert&pid="+request.getParameter("pid") %>"
						class="btn btn-default btn-block btn-success">新增宿舍房间</a>
				</div>
			</div>
			<div class="row clearfix dormitory">
				<c:set var="floor" value="1"></c:set>
				<c:forEach items="${rooms }" var="room">
					<c:if test="${room.floor != floor }">
			</div>
			<div class="row clearfix dormitory">
				<c:set var="floor" value="${room.floor }"></c:set>
				</c:if>
				<div class="col-md-3 column dormitory-outbox">
					<div class="dormitory-box">
						<a href="<%= request.getContextPath() %>/admin/dormitoryindex/${dormitory.id }/${room.id }.shtml"><h3>${room.floor}-${room.name }<span>(${room.num }人)</span></h3></a>
						<i class="fa fa-close remove" domitoryname="${room.name }"
							domitoryid="${room.id }"></i>
					</div>
				</div>
				</c:forEach>
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
				window.location.href="<%= request.getContextPath() %>/admin/optiondormitoryroom.shtml?act=delete&pid=<%= request.getParameter("pid") %>&id="+$(this).attr("domitoryid");
			}
		});
	}(jQuery));
	</script>
	<footer></footer>

</body>
</html>