<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生个人信息</title>
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
	padding: 0;
	margin: 0;
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
				<li><a
					href="<%= request.getContextPath()+"/admin/student/college.shtml" %>">学院列表</a>
				</li>/
				<li><a
					href="<%= request.getContextPath()+"/admin/student/college/class.shtml?college=" %>
					${college.id}&major=${major.id}&majorclass=${majorclass.id}">班级学生列表</a>
				</li>/
				<li class="active">班级学生列表</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-8 column">
					<div class="row clearfix">
						<div class="col-md-6 column">
							<div class="form-group">
								<label>姓名：</label>
								<input class="form-control" readonly="readonly" value="${student.name }" />
							</div>
							<div class="form-group">
								<label>籍贯：</label>
								<input class="form-control" readonly="readonly" value="${student.birthpath }" />
							</div>
							<div class="form-group">
								<label>学院：</label>
								<input class="form-control" readonly="readonly" value="${college.name }" />
							</div>
							<div class="form-group">
								<label>专业：</label>
								<input class="form-control" readonly="readonly" value="${major.name }" />
							</div>
							<div class="form-group">
								<label>班别：</label>
								<input class="form-control" readonly="readonly" value="${majorclass.name }" />
							</div>
							<div class="form-group">
								<label>宿舍楼：</label>
								<input class="form-control" readonly="readonly" value="${dormitory }" />
							</div>
							<div class="form-group">
								<label>宿舍号：</label>
								<input class="form-control" readonly="readonly" value="${room }" />
							</div>
						</div>
						<div class="col-md-6 column">
							<div class="form-group">
								<label>学号：</label>
								<input class="form-control" readonly="readonly" value="${student.studentid }" />
							</div>
							<div class="form-group">
								<label>民族：</label>
								<input class="form-control" readonly="readonly" value="${student.nation }" />
							</div>
							<div class="form-group">
								<label>性别：</label>
								<c:if test="${student.sex == 0 }">
									<input class="form-control" readonly="readonly" value="男" />
								</c:if>
								<c:if test="${student.sex != 0 }">
									<input class="form-control" readonly="readonly" value="女" />
								</c:if>
							</div>
							<div class="form-group">
								<label>出生日期：</label>
								<input class="form-control" readonly="readonly" value="${date }" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label>家庭住址：</label>
						<input class="form-control" readonly="readonly" value="${student.homepath }" />
					</div>
				</div>
				<div class="col-md-4 column">
					<div class="headimgbox">
						<img id="headimg" alt="头像"
							src="<%= request.getContextPath() %>${student.headimg}"
							class="img-thumbnail" />
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
</body>
</html>