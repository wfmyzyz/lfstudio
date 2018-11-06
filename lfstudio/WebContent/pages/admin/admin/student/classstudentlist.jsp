<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询学生-海师1班</title>
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
<linl rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/sweetalert.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	background: rgb(253, 253, 253);
}

.clear {
	clear: both;
}

.breadcrumb li {
	margin: 0 5px;
}

.college {
	border: 1px solid #efefef;
	padding: 20px;
	box-shadow: 1px 1px 1px 2px #efefef;
	border-radius: 15px;
	background: rgb(250, 250, 250);
	margin-bottom: 40px;
}

.major {
	border: 1px solid #ddd;
	margin: 20px 0;
	padding: 20px;
	box-shadow: 1px 1px 1px 1px #ddd;
	border-radius: 10px;
	background: rgb(245, 245, 245);
}

.majorclass {
	border: 1px solid #d5d5d5;
	margin: 20px 0;
	padding: 10px;
	border-radius: 5px;
	background: rgb(240, 240, 240);
}

.majorclass a {
	margin: 0 5px;
	float: left;
	color: #666;
}

.majorclass a:hover {
	color: #ff9900;
}
</style>
</head>
<body>
	<header>
		<div>
			<ul class="breadcrumb">
				<li><a
					href="<%= request.getContextPath()+"/admin/student/college.shtml" %>">学院列表</a>
				</li>/
				<li class="active">班级学生列表</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="container college">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<h3>${college.name }</h3>
					<div class="row clearfix major">
						<div class="col-md-12 column">
							<h3>${major.name }</h3>
							<div class="row clearfix majorclass">
								<div class="col-md-12 column">
									<h3>${majorclass.name }</h3>
									<div class="row clearfix">
										<div class="col-md-12 column">
											<c:if
												test="${studentlists == null || studentlists.size() ==0 }">
												暂时没学生
											</c:if>
											<c:forEach items="${studentlists }" var="studentlist">
												<a href="<%= request.getContextPath() %>/admin/student/message/${college.id}
												/${major.id}/${majorclass.id}/${studentlist.studentid}.shtml">${studentlist.name }</a>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
</body>
</html>