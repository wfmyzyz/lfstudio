<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿舍电量管理</title>
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
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	section{
		margin-top: 150px;
	}
	.entrance{
		width: 200px;
		height: 150px;
		border-radius: 20px;
		margin: 0 auto;
		text-align: center;
		cursor: pointer;
	}
	a{
		display:block;
		height:100%;
		width:100%;
		font-size:28px;
		color:#fff;
		line-height: 150px;
	}
	a:hover{
		text-decoration:none;
		font-size:28px;
		color:#fff;
		line-height: 150px;
	}
	.entrance h3{
		line-height: 150px;
	}
	.add{
		background: #ff9900;
	}
	.add:hover{
		background: #ff8800;
	}
	.add h3{
		color: #fff;
	}
	.surp{
		background: #aaa;
	}
	.surp:hover{
		background: #999;
	}
	.surp h3{
		color:#fff;
	}
</style>
</head>
<body>
	<header></header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-6 column">
					<div class="entrance add">
						<a class="miaodian" href="<%= request.getContextPath() %>/admin/addelectric.shtml">充电费
						</a>
					</div>
				</div>
				<div class="col-md-6 column">
					<div class="entrance surp">
					<a class="miaodian" href="<%= request.getContextPath() %>/admin/reduceelectric.shtml">扣电费
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
</body>
</html>