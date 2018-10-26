<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改学生用户</title>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

 <link rel="stylesheet" href="/lfstudio/resources/frame/layui/css/layui.css">
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
 
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
header{
	width: 100%;
}
section{
	margin-top: 20px;
}
.breadcrumb li{
	margin: 0 5px;
}
.control-label i{
	font-size: 12px;
}
.error{
	color:red;
}
</style>
</head>
<body>
	<header>
		<div>
			<ul class="breadcrumb">
				<li>
					 <a href="#">主页</a>
				</li>/
				<li>
					 <a href="<%= request.getContextPath()+"/admin/studentuser.shtml" %>">学生用户列表</a>
				</li>/
				<li class="active">
					修改学生用户
				</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-6 column">
					<% String path = request.getContextPath()+"/admin/operationstudentuser.shtml?act=update"; %>
					<form:form class="form-horizontal" role="form" action="<%= path %>" method="post"  modelAttribute="student">
						<form:hidden path="id"/>
						<div class="form-group">
							 <label for="inputEmail3" class="col-sm-6 control-label">学生用户账号<i>(不可修改)</i></label>
							<div class="col-sm-10">
								<form:input path="user" class="form-control" required="required" readonly="true" />
								<form:errors path="user"  Class="error"></form:errors>
							</div>
						</div>
						<div class="form-group">
							 <label for="inputPassword3" class="col-sm-6 control-label">学生用户密码<i>(需输入6至16位密码)</i></label>
							<div class="col-sm-10">
								<form:input path="pass" class="form-control" required="required" />
								<form:errors path="pass"  Class="error"></form:errors>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <input type="submit" class="btn btn-default btn-info" value="修改" />
							</div>
						</div>
					</form:form>
				</div>
				<div class="col-md-6 column">
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
</body>
</html>