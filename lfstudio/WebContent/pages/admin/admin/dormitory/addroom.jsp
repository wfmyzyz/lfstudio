<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加房间</title>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

 <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
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
section{
	margin-top: 50px;
}
span{
	font-size:12px;
}
.breadcrumb li{
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
				<li>
					 <a href="<%= request.getContextPath()+"/admin/dormitory.shtml?" %>">宿舍楼管理</a>
				</li>/
				<li>
					 <a href="<%= request.getContextPath()+"/admin/dormitoryroom.shtml?pid=" %>${room.pid}">${dormitory.name }</a>
				</li>/
				<li class="active">
					添加房间
				</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-6 column">
					<% String path = request.getContextPath()+"/admin/actionroom.shtml?act=insert"; %>
					<form:form role="form" action="<%= path %>" modelAttribute="room">
						<form:hidden path="pid" />
						<div class="form-group">
							 <label for="exampleInputEmail1">宿舍名<span>（例如：101）</span></label><form:input class="form-control" path="name"/>
						</div>
						<div class="form-group">
							 <label for="exampleInputEmail1">楼层</label>
							 <form:select path="floor" class="form-control">
							 	<form:option value="1">1楼</form:option>
							 	<form:option value="2">2楼</form:option>
							 	<form:option value="3">3楼</form:option>
							 	<form:option value="4">4楼</form:option>
							 	<form:option value="5">5楼</form:option>
							 	<form:option value="6">6楼</form:option>
							 </form:select>
						</div>
						<input type="submit" class="btn btn-default btn-info" value="新增" />
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