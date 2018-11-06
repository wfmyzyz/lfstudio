<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生宿舍管理--后台</title>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/lfstudio/resources/frame/layui/css/layui.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script
	src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

iframe {
	height: 99%;
	width: 100%;
	background: #666;
}
</style>
</head>
<body>
	<% 
		if(request.getAttribute("message")!=null&&!request.getAttribute("message").equals("")){
			out.print("<script>alert('"+request.getAttribute("message")+"');</script>");
		}
	%>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">大学生宿舍管理系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<!-- <ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul> -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> ${user }
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="<%= request.getContextPath() %>/admin/signout.shtml">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a
						href="javascript:void(0);">用户管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a
									href="<%= request.getContextPath()+"/admin/adminuser.shtml" %>"
									target="iframe_body">管理员</a>
							</dd>
							<dd>
								<a
									href="<%= request.getContextPath()+"/admin/studentuser.shtml" %>"
									target="iframe_body">学生用户</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a class="" href="javascript:;">学生管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a
									href="<%= request.getContextPath()+"/admin/student/college.shtml" %>"
									target="iframe_body">按学院查询学生</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">宿舍管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a
									href="<%= request.getContextPath()+"/admin/dormitory.shtml" %>"
									target="iframe_body">宿舍楼管理</a>
							</dd>
							<dd>
								<a href="<%= request.getContextPath() %>/admin/addelectricindex.shtml"
									target="iframe_body">电费管理</a>
							</dd>
							<dd>
								<a href="<%= request.getContextPath() %>/admin/hygiene.shtml"
									target="iframe_body">卫生管理</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">宿舍信息管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a
									href="<%= request.getContextPath()+"/admin/dormitortmess.shtml" %>"
									target="iframe_body">宿舍公告发布</a>
							</dd>
							<dd>
								<a href="<%= request.getContextPath()%>/admin/dormitorytestlist.shtml"
								target="iframe_body">宿舍资讯管理</a>
							</dd>
						</dl>
					</li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<iframe name="iframe_body"> </iframe>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© 本控制台归霸天所有 感谢layui
		</div>
	</div>
	<script src="/lfstudio/resources/frame/layui/layui.js"></script>
	<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>