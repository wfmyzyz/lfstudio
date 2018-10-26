<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息</title>
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
<style type="text/css">
	section{
		margin-top: 50px;
	}
	.headimgbox{
		width: 145px;
		height: 145px;
		border:1px solid #efefef;
		padding: 2px;
		border-radius: 2px;
	}
	#headimg{
		height: 140px;
		width: 140px;
	}
	.head{
		padding: 20px;
	}
	.headimgbtn{
		width: 80px;
		height: 30px;
		background: #efefef;
		font-size: 12px;
		border:0;
		color:#666;
		margin-top: 5px;
		margin-left: 30px;
		border-radius: 5px;
		cursor: pointer;
	}
	.headimgbtn:hover{
		background: #ddd;
	}
	.breadcrumb li{
		margin: 0 5px;
	}
	.radio-inline{
		margin-left: 5px;
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
				<li>
					 <a href="<%= request.getContextPath() %>/admin/studentuser.shtml">学生用户列表</a>
				</li>/
				<li class="active">${id }</li>
			</ul>
	    </div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-8 column">
						<% String path = request.getContextPath()+"/admin/studentupload.shtml"; %>
							<form:form  role="form" action="<%= path %>" method="post" modelAttribute="person">
							<input type="hidden" id="headimgsrc" name="headimg" value="${person.headimg }" />
							<div class="row clearfix">
								<div class="col-md-6 column">
									<div class="form-group">
										<label>姓名:</label>
										<form:input path="name" class="form-control"/>
									</div>
									<div class="form-group">
										<label>籍贯:</label>
										<form:input path="birthpath" class="form-control"/>
									</div>
									<div class="form-group">
										<label>学院:</label>
										<form:select path="college" class="form-control">
											<c:forEach items="${colleges }" var="college">
												<form:option value="${college.id }">${college.name }</form:option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group">
										<label>专业:</label>
										<form:select path="major" class="form-control">
											<c:forEach items="${majors }" var="major">
												<form:option value="${major.id }">${major.name }</form:option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group">
										<label>班别:</label>
										<form:select path="majorclass" class="form-control">
											<c:forEach items="${majorclasss }" var="majorclass">
												<form:option value="${majorclass.id }">${majorclass.name }</form:option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group">
										<label>宿舍楼:</label>
										<form:select path="dormitory" class="form-control">
											<c:forEach items="${dormitorys }" var="dormitory">
												<form:option value="${dormitory.id }">${dormitory.name }</form:option>
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group">
										<label>宿舍号:</label>
										<form:select path="room" class="form-control">
											<c:forEach items="${rooms }" var="room">
												<form:option value="${room.id }">${room.name }</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="col-md-6 column">
									<div class="form-group">
										<label>学号:</label>
										<form:input path="studentid" class="form-control" value="${id }" readonly="true" />
									</div>
									<div class="form-group">
										<label>民族:</label>
										<form:input path="nation" class="form-control"/>
									</div>
									<div class="form-group">
										<label>性别:</label><br />
										<label class="radio-inline"><form:radiobutton path="sex"  value="0"/>男</label>
    									<label class="radio-inline"><form:radiobutton path="sex"  value="1"/>女</label>
									</div>
									<div class="form-group">
										<label>出生日期:</label>
										<input type="date" class="form-control" value="${birthday }" name="date" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="inputEmail3">家庭住址:</label>
								<form:input path="homepath" class="form-control"/>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									 <button type="submit" class="btn btn-default btn-success">修改</button>
								</div>
							</div>
							</form:form>
						</div>
						<div class="col-md-4 column">
							<div class="head">
								<div class="headimgbox">
								<img id="headimg" alt="请上传头像" src="<%= request.getContextPath() %>${person.headimg}" class="img-thumbnail" />
								</div>
								<br />
								<button class="headimgbtn">点击上传</button>
								<input type="file" id="headimginput" style="display:none"  />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		(function(){
			$("#college").change(function(){
				$.post("<%= request.getContextPath() %>/admin/selectmajor.shtml",{college:$(this).val()},function(data){
					var html = "";
					for(var onedata in data){
						html += "<option value='"+data[onedata].id+"'>"+data[onedata].name+"</option>" 
					}
					$("#major").html(html);
					$.post("<%= request.getContextPath() %>/admin/selectmajorclass.shtml",{major:$("#major").val()},function(data){
						var html = "";
						for(var onedata in data){
							html += "<option value='"+data[onedata].id+"'>"+data[onedata].name+"</option>" 
						}
						$("#majorclass").html(html);
					});
				});
			});
			$("#major").change(function(){
				$.post("<%= request.getContextPath() %>/admin/selectmajorclass.shtml",{major:$(this).val()},function(data){
					var html = "";
					for(var onedata in data){
						html += "<option value='"+data[onedata].id+"'>"+data[onedata].name+"</option>" 
					}
					$("#majorclass").html(html);
				});
			});
			$("#dormitory").change(function(){
				$.post("<%= request.getContextPath() %>/admin/selectroom.shtml",{domitory:$(this).val()},function(data){
					var html = "";
					for(var onedata in data){
						html += "<option value='"+data[onedata].id+"'>"+data[onedata].name+"</option>" 
					}
					$("#room").html(html);
				});
			});
			$(".headimgbtn").click(function(){
				$("#headimginput").click();
			});
			$("#headimginput").change(function(){
				var file = document.getElementById("headimginput").files[0];
				var FileController = "<%= request.getContextPath() %>/admin/uploadhead.shtml";
				var form = new FormData();
				form.append("file", file);
				$.ajax({
					url:FileController,
					type: 'POST',
					cache: false,
					data:form,
					processData: false,
					contentType: false,
					dataType:"json",
					success : function(result) {
			              console.log(result["1"]);
			              alert("上传成功！");
			              $("#headimg").attr("src","<%= request.getContextPath() %>"+result["1"]);
			              $("#headimgsrc").val(result["1"]);
			        }
				});
			});
		}(jQuery))
	</script>
	<footer></footer>
</body>
</html>