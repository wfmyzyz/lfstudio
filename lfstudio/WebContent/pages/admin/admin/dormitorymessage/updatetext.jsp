<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改资讯</title>
<!-- 新 Bootstrap4 核心 CSS 文件 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- 新 Bootstrap4 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>

<!-- popper.min.js 用于弹窗、提示、下拉菜单 -->
<script
	src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>

<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
<script type="text/javascript" src="//unpkg.com/wangeditor/release/wangEditor.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<linl rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/sweetalert.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
	}
	section{
		margin-top: 50px;
		margin-bottom: 50px;
	}
	#form{
		margin-top: 50px;
	}
	.put_text{
		display: inline-block;
		height: 40px;
		width: 120px;
		background: #ff9900;
		color:#fff;
		float: right;
		text-align: center;
		border-radius: 10px;
		margin-top: 10px;
		margin-right: 20px;
		line-height: 40px;
		cursor: pointer;
	}
	.put_text:hover{
		background: #ff8800;
	}
	.breadcrumb li {
		margin: 0 5px;
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
				<li><a href="<%= request.getContextPath() %>/admin/dormitorytestlist.shtml">文章列表</a></li>/
				<li class="active">修改文章</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<h3 class="text-center">
						文章修改
					</h3>
					<% String path = request.getContextPath()+"/admin/uploadtext.shtml?act=update";%>
					<form id="form" role="form" action="<%= path %>" method="post">
						<input type="hidden" name="textid" value="${text.id }" />
						<div class="form-group">
							 <label for="title">文章题目:</label>
							 <input type="text" class="form-control" id="title" name="title" value="${text.title }" />
						</div>
						<div class="form-group">
							 <label for="text">文章内容:</label>
							 <input type="hidden" id="text" name="text" />
							 <div id="editor">
							 	<p>${text.text }</p>
							 </div>
						</div>
						<input style="display: none" type="submit" id="putok" />
					</form>
					<span class="put_text">修改</span>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		var E = window.wangEditor;
	    var editor = new E('#editor');
	    editor.customConfig.menus = [
	        'head',  // 标题
	        'bold',  // 粗体
	        'fontSize',  // 字号
	        'fontName',  // 字体
	        'italic',  // 斜体
	        'underline',  // 下划线
	        'strikeThrough',  // 删除线
	        'foreColor',  // 文字颜色
	        'backColor',  // 背景颜色
	        'link',  // 插入链接
	        'list',  // 列表
	        'justify',  // 对齐方式
	        'quote',  // 引用
	        'emoticon',  // 表情
	        'image',  // 插入图片
	        'table',  // 表格
	        //'video',  // 插入视频
	        //'code',  // 插入代码
	        'undo',  // 撤销
	        'redo'  // 重复
	    ];
	    editor.customConfig.zIndex = 1;
	    editor.customConfig.uploadImgServer = '<%= request.getContextPath() %>/admin/textuploadimg.shtml';
	    editor.customConfig.uploadFileName = 'fileimg';	    	
	    editor.create();
	    $(".put_text").click(function(){
	    	if($.trim($("#title").val())==""){
	    		swal("标题不能为空！");
	    		return;
	    	}
	    	if(editor.txt.text()==""){
	    		swal("内容不能为空！");
	    		return;
	    	}
	    	$("#text").val(editor.txt.html());
	    	$("#putok").click();
	    });
	</script>
	<footer></footer>
</body>
</html>