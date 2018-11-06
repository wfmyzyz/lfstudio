<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告</title>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script
	src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script type="text/javascript" src="//unpkg.com/wangeditor/release/wangEditor.min.js"></script>
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
	.news{
		border:1px solid #ddd;
		padding: 10px;
		border-radius: 5px;
	}
</style>
</head>
<body>
	<header>
		<div>
			<ul class="breadcrumb">
				<li><a href="<%= request.getContextPath() %>/admin/dormitortmess.shtml">公告主页</a></li>/
				<li><a href="<%= request.getContextPath() %>/admin/noticelist.shtml">公告列表</a></li>/
				<li class="active">公告</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="notice_box">
			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<h3 class="text-center">
							公告
						</h3>
						<div class="news">
							 ${dormitoryNotice.texthtml }
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
</body>
</html>