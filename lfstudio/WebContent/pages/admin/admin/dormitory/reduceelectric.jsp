<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>扣电费</title>
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
		margin-top: 50px;
	}
	.breadcrumb li {
		margin: 0 5px;
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
				<li><a href="<%= request.getContextPath() %>/admin/addelectricindex.shtml">电量管理</a></li>/
				<li class="active">扣电费</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-6 column">
						<% String path = request.getContextPath()+"/admin/optionelectric.shtml"; %>
							<form role="form" action="<%= path %>" onsubmit="return checkform();">
								<input type="hidden" name="act" value="reduce" />
								<div class="form-group">
									 <label>选择宿舍楼：</label>
									 <select class="form-control" id="dormitory" name="dormitory">
									 	<c:forEach items="${dormitorys }" var="dormitory">
									 		<option value="${dormitory.id }">${dormitory.name }</option>
									 	</c:forEach>
									 </select>
								</div>
								<div class="form-group">
									 <label>选择宿舍号：</label>
									 <select class="form-control" id="room" name="room">
									 </select>
								</div>
								<div class="form-group">
									 <label>减少电度</label>
									 <input type="text" class="form-control" id="money" name="money" />
								</div>
								<input class="btn btn-default btn-info rounded" type="submit" value="确定" />
							</form>
						</div>
						<div class="col-md-6 column">
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		$.post("<%= request.getContextPath() %>/admin/selectroom.shtml",{domitory:$("#dormitory").val()},function(data){
			var html = "";
			for(var onedata in data){
				html += "<option value='"+data[onedata].id+"'>"+data[onedata].name+"</option>" 
			}
			$("#room").html(html);
		});
		function checkform(){
			if($.trim($("#dormitory").val())==""){
				swal("请选择宿舍楼！");
				return false;
			}
			if($.trim($("#room").val())==""){
				swal("请选择宿舍号！");
				return false;
			}
			if($.trim($("#money").val())==""||parseFloat($("#money").val())<=0||isNaN($("#money").val())){
				swal("请输入正确的电度！");
				return false;
			}
			if(confirm("是否为"+$("#dormitory option:selected").text()+"的"+$("#room option:selected").text()+"宿舍扣除"+$("#money").val()+"度电?")){
				return true;
			}
			return false;
		}
		$("#dormitory").change(function(){
			$.post("<%= request.getContextPath() %>/admin/selectroom.shtml",{domitory:$(this).val()},function(data){
				var html = "";
				for(var onedata in data){
					html += "<option value='"+data[onedata].id+"'>"+data[onedata].name+"</option>" 
				}
				$("#room").html(html);
			});
		});
	</script>
	<footer></footer>
</body>
</html>