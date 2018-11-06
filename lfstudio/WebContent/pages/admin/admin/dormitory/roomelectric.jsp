<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>电费详情</title>
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
table thead tr th{
	font-size: 14px;
	color: #ff9900;
	text-align: center;
}
table tr td{
	text-align: center;
}
.breadcrumb li {
	margin: 0 5px;
}
section{
	margin-top: 50px;
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
				<li><a
					href="<%= request.getContextPath()+"/admin/dormitoryroom.shtml?pid=" %>${dormitorys.id }">${dormitorys.name }</a>
				</li>/
				<li><a
					href="<%= request.getContextPath()+"/admin/dormitoryindex" %>/${dormitorys.id }/${dormitoryrooms.id}.shtml">${dormitoryrooms.name }宿舍</a>
				</li>/
				<li class="active">${dormitoryrooms.name }宿舍-宿舍相关查询</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-bordered table-hover">
					    <thead>
					      <tr>
					        <th>月份</th>
					        <th>剩余电量/°</th>
					        <th>总用电量/°</th>
					        <th>卫生评分</th>
					      </tr>
					    </thead>
					    <tbody>
					    	<c:forEach items="${dormitoryabouts }" var="dormitoryabout">
					    	  <tr>
						        <td><f:formatDate value="${dormitoryabout.month }" pattern="yyyy-MM-dd"/></td>
						        <td>${dormitoryabout.surpelectric }</td>
						        <td>${dormitoryabout.amountelectric }</td>
						        <td>${dormitoryabout.hygiene }</td>
						      </tr>
					    	</c:forEach>
					    </tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
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