<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>资讯首页</title>
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
	.search {
		width: 130px;
		height: 25px;
		float: right;
		margin-top: 10px;
		margin-right: 100px;
		margin-bottom: 20px;
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
	section{
		margin-top: 50px;
	}
	.breadcrumb li {
		margin: 0 5px;
	}
	#addtext{
		margin-bottom: 30px;
	}
	.option{
		font-size: 14px;
		color: #666;
	}
	.option:hover{
		color:#ff9900;
	}
	.optiona{
		font-size: 16px;
		color: #666;
	}
	.optiona:hover{
		color:#ff9900;
	}
	.table td, .table th{
		padding-top: 10px;
		padding-bottom: 10px;
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
	.title{
		display:inline-block;
		width:200px;
		overflow: hidden;
		text-overflow:ellipsis;
		white-space: nowrap;
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
			out.print("<script>swal('"+request.getAttribute("message")+"');</script>");
		}
	%>
	<header>
		<div>
			<ul class="breadcrumb">
				<li><a href="<%= request.getContextPath()%>/admin/dormitorytestlist.shtml">资讯列表</a></li>
			</ul>
		</div>
		<div class="search">
			<input id="searchtext" type="text" placeholder="按标题搜索…" />
			<i id="searchbtn" class="fa fa-search"></i>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					 <a href="<%= request.getContextPath() %>/admin/addtext.shtml" type="button" id="addtext" 
					 class="btn btn-default btn-block btn-success">添加资讯</a>
					<table class="table table-bordered table-hover">
					    <thead>
					      <tr>
					        <th>编号</th>
					        <th>标题</th>
					        <th>时间</th>
					        <th>操作</th>
					      </tr>
					    </thead>
					    <tbody>
					    	<c:forEach items="${textlists }" var="textlist">
						    	<tr>
							        <td>${textlist.id }</td>
							        <td><span  class="title"><a class="optiona" href="<%= request.getContextPath() %>/admin/viewtext.shtml?id=${textlist.id }">${textlist.title }</a></span></td>
							        <td>${textlist.date }</td>
							        <td><a class="option" href="<%= request.getContextPath()%>/admin/updatetext.shtml?id=${textlist.id }">修改</a>&nbsp;|&nbsp;
							        <a class="option delete" data-id="${textlist.id }" href="javascript:void(0);">删除</a></td>
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
					swal("输入为空！");
					return;
				}
				window.location.href = "<%= request.getContextPath() %>/admin/dormitorytestlist.shtml?act=select&title="+$("#searchtext").val();
			})
		}(jQuery))
		$(".delete").click(function(){
			if(confirm("是否删除编号为"+$(this).attr("data-id")+"的资讯？")){
				window.location.href = "<%= request.getContextPath() %>/admin/uploadtext.shtml?act=delete&id="+$(this).attr("data-id");
			}
		})
	</script>
</body>
</html>