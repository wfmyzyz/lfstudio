<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员用户</title>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
 
<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
 
<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdn.staticfile.org/foundation/5.5.3/css/foundation.min.css">

<script src="https://cdn.staticfile.org/foundation/5.5.3/js/foundation.min.js"></script>
<script src="https://cdn.staticfile.org/foundation/5.5.3/js/vendor/modernizr.js"></script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	th,td{
		text-align: center;
	}
	table tr{
		line-height: 1;
	}
	.addadminbtn a{
		display: block;
		height: 100%;
		width: 100%;
		color: #fff;
		text-decoration: none;
	}
	table a{
		color: #000;
		text-decoration: underline;
		font-size: 14px;
	}
	table a:hover{
		color:#ff9900;
	}
	.addadminbtn{
		margin: 10px 0;
	}
	.breadcrumb li{
		margin: 0 5px;
	}
	.jumpbtn{
		display: inline-block;
		height:24px;
		width:36px;
		font-size: 12px;
		background: #efefef;
		cursor: pointer;
		color: #999;
		font-style: normal;
		border-radius: 5px;
		line-height: 24px;
		text-align: center;
	}
	.jumpbtn:hover{
		background: #ddd;
	}
	span{
		font-size: 12px;
		color: #999;
	}
	footer{
		margin-top: 10px;
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
					 <a href="#">主页</a>
				</li>/
				<li class="active">管理员列表</li>
			</ul>
	    </div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<a href="<%= request.getContextPath()+"/admin/actionadminuser.shtml?act=insert" %>" class="btn btn-default btn-block btn-success addadminbtn">新增管理员</a>
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>编号</th>
								<th>管理员账号</th>
								<th>管理员密码</th>
								<th>管理员等级</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userlist }" var="user">
							<tr>
								<td>${user.id }</td>
								<td>${user.adminuser }</td>
								<td>${user.adminpass }</td>
								<td>${user.authority }</td>
								<td><a href="<%= request.getContextPath() %>/admin/actionadminuser.shtml?act=update&id=${user.id }">修改</a>&nbsp;|&nbsp;<a class="delectadminbtn"  adminid="${user.id }" href="javascript:void(0)">删除</a></td>
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
				if(confirm("确定删除编号为"+$(this).attr("adminid")+"的管理员？")){
					window.location.href="<%= request.getContextPath() %>/admin/actionadminuser.shtml?act=delete&id="+$(this).attr("adminid");
				}
			});
		}(jQuery))
	</script>
	<footer>
		<%@ include file="/pages/admin/admin/cutpage/cut.jsp" %>
	</footer> 
	<script type="text/javascript">
		(function(){
			$("#jumppid").val("${nowpage}");
		}(jQuery))
		function jump() {
			if(isNaN(parseInt($("#jumppid").val()))){
				alert("请输入页数！");
				return false;
			}
			if(parseInt($("#jumppid").val())>${pages}||parseInt($("#jumppid").val())<1){
				alert("请输入应有的页数！");
				return false;
			}
			window.location.href="<%= request.getContextPath()+"/admin/adminuser.shtml?pageid=" %>"+parseInt($("#jumppid").val());
			
		}
	</script>
</body>
</html>