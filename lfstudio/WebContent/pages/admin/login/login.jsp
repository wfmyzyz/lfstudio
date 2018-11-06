<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LF工作室-登录</title>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">

<!-- font字体 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">

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

body {
	font-size: 12px;
}

.container-fluid-back img {
	height: 100%;
	width: 100%;
	position: absolute;
	top: 0;
	left: 0;
	background: url(/lfstudio/resources/images/admin/login/login-back.jpg);
	background-repeat: no-repeat;
	background-size: 100% 100%;
}

.container-form {
	width: 300px;
	background: rgba(0, 0, 0, 0.3);
	text-align: center;
	padding: 20px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-left: -150px;
	margin-top: -100px;
}

.title {
	font-size: 18px;
	color: #fff;
}

.form-input {
	position: relative;
}

.form-group {
	position: relative;
}

.form-input i {
	display: inline-block;
	height: 28px;
	width: 30px;
	color: #999;
	line-height: 28px;
	position: absolute;
	top: 0;
	left: 40px;
}

.form-input input {
	height: 28px;
	width: 178px;
	font-size: 14px;
	color: #666;
	border: 0;
	padding-left: 28px;
}

.verification input {
	height: 25px;
	width: 110px;
	border: 0px;
	margin-left: 5px;
	color: #666;
	font-size: 12px;
	padding: 0 5px;
}

.verification img {
	margin-right: 5px;
	vertical-align: middle;
	margin-top: -3px;
}

.btnok {
	height: 30px;
	width: 100px;
	line-height: 30px;
	background: #999;
	border: 0;
	border-radius: 5px;
	cursor: pointer;
	color: #fff;
}

.btnok:hover {
	background: #666;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<% 
		if(request.getAttribute("message")!=null){
			out.print("<script>alert('"+request.getAttribute("message")+"');</script>");
		}
	%>
	<div class="container-fluid-back">
		<img src="/lfstudio/resources/images/admin/login/login-back.jpg">
	</div>
	<div class="container-fluid">
		<div class="container-form">
			<form:form action="login.shtml" method="post" modelAttribute="admin">
				<label class="title">管理员登录</label>
				<div class="form-group">
					<div class="form-input">
						<i class="fa fa-user"></i>
						<form:input path="adminuser" placeholder="管理员账号"
							required="required" />
					</div>
				</div>
				<div class="form-group">
					<div class="form-input">
						<i class="fa fa-eye-slash"></i>
						<form:password path="adminpass" placeholder="管理员密码"
							required="required" />
					</div>
				</div>
				<div class="form-group verification">
					<input class="" type="text" required="required"
						name="Verification-Code" placeholder="请输入验证码…" />&nbsp;&nbsp;<img
						alt="验证码" src="/lfstudio/admin/VerificationCode.shtml">
				</div>
				<label class="error">${loginfail }</label>
				<br />
				<input type="submit" value="登录" class="btnok" />
			</form:form>
		</div>
	</div>
	<script type="text/javascript">
		(function(){
			$(".verification img").click(function(){
				$(this).attr("src","/lfstudio/admin/VerificationCode.shtml?rc="+Math.random());
			});
		}(jQuery));
	</script>
</body>
</html>