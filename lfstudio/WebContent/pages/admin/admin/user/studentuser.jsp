<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生用户</title>
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
* {
	margin: 0;
	padding: 0;
}

.search {
	width: 130px;
	height: 25px;
	float: right;
	margin-top: 10px;
	margin-right: 100px;
}

.search input {
	width: 75%;
	height: 100%;
	float: left;
	border: 0;
	background: #efefef;
	border-radius: 5px;
	font-size: 12px;
	padding: 0 10px;
}

.search i {
	display: inline-block;
	width: 25%;
	height: 100%;
	text-align: center;
	color: #000;
	cursor: pointer;
}

th, td {
	text-align: center;
}

table tr {
	line-height: 1;
}

.addadminbtn a {
	display: block;
	height: 100%;
	width: 100%;
	color: #fff;
	text-decoration: none;
}

table a {
	color: #000;
	text-decoration: underline;
	font-size: 14px;
}

table a:hover {
	color: #ff9900;
}

.addadminbtn {
	margin: 10px 0;
}

.breadcrumb li {
	margin: 0 5px;
}

.jumpbtn {
	display: inline-block;
	height: 24px;
	width: 36px;
	font-size: 12px;
	background: #efefef;
	cursor: pointer;
	color: #999;
	font-style: normal;
	border-radius: 5px;
	line-height: 24px;
	text-align: center;
}

.jumpbtn:hover {
	background: #ddd;
}

span {
	font-size: 12px;
	color: #999;
}

footer {
	margin-top: 10px;
}
</style>
</head>
<body>
	<% 
		if(request.getAttribute("message")!=null&&!request.getAttribute("message").equals("")){
			out.print("<script>	swal('"+request.getAttribute("message")+"');</script>");
		}
	%>
	<header>
		<div>
			<ul class="breadcrumb">
				<li><a href="<%= request.getContextPath() %>/admin/studentuser.shtml">学生用户列表</a></li>
			</ul>
		</div>
		<div class="search">
			<input id="searchtext" type="text" placeholder="按学号搜索…" /><i
				id="searchbtn" class="fa fa-search"></i>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<a
						href="<%= request.getContextPath()+"/admin/actionstudentuser.shtml?act=insert" %>"
						class="btn btn-default btn-block btn-success addadminbtn">新增学生用户</a>
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>编号</th>
								<th>学生用户账号</th>
								<th>学生用户密码</th>
								<th>操作</th>
								<th>新增修改学生信息</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userlist }" var="user">
								<tr>
									<td>${user.id }</td>
									<td>${user.user }</td>
									<td>${user.pass }</td>
									<td><a
										href="<%= request.getContextPath() %>/admin/actionstudentuser.shtml?act=update&id=${user.id }">修改</a>&nbsp;|&nbsp;<a
										class="delectadminbtn" userpid="${user.user }"
										userid="${user.id }" href="javascript:void(0)">删除</a></td>
									<td><a
										href="<%= request.getContextPath() %>/admin/studentmessage/${user.user}.shtml">新增/修改</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		(function() {
			$(".delectadminbtn").click(function() {
				if(confirm("确定删除编号为"+$(this).attr("userid")+"的学生用户？")){
					window.location.href="<%= request.getContextPath() %>/admin/actionstudentuser.shtml?act=delete&id="+$(this).attr("userid")+"&pid="+$(this).attr("userpid");
				}
			});
		}(jQuery))
	</script>
	<footer>
		<%@ include file="/pages/admin/admin/cutpage/cut.jsp"%>
	</footer>
	<script type="text/javascript">
		(function(){
			$("#jumppid").val("${nowpage}");
			$("#searchbtn").click(function(){
				if($.trim($("#searchtext").val())==""){
					return;
				}else{
					window.location.href="<%= request.getContextPath()+"/admin/studentuser.shtml?act=search&pid=" %>"+$("#searchtext").val();	
				}
			});
		}(jQuery))
	</script>
</body>
</html>