<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看文章</title>
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

<link rel="stylesheet"
	href="https://cdn.staticfile.org/foundation/5.5.3/css/foundation.min.css">

<script
	src="https://cdn.staticfile.org/foundation/5.5.3/js/foundation.min.js"></script>
<script
	src="https://cdn.staticfile.org/foundation/5.5.3/js/vendor/modernizr.js"></script>
<linl rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/sweetalert.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style>
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
</style>
</head>
<body>
	<header>
		<div>
			<ul class="breadcrumb">
				<li><a href="<%= request.getContextPath() %>/admin/dormitorytestlist.shtml">资讯列表</a></li>/
				<li class="active">资讯</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<h3 class="text-center">
						${text.title }
					</h3>
					<h6 class="text-center">
						${text.date }
					</h6>
					<p>
						${text.text }
					</p>
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
</body>
</html>