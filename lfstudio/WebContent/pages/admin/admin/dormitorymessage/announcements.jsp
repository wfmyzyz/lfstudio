<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告管理</title>
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
	}
	.news{
		border:1px solid #ddd;
		padding: 10px;
		border-radius: 5px;
	}
	.newstitle{
		color:#666;
		padding: 0 0 6px 10px;
		border-bottom: 2px solid #ddd; 
	}
	.history{
		margin-top:50px;
	}
	.history h3{
		padding:5px 0px 6px 10px;
		color:#666;
		border-bottom: 2px solid #ddd; 
	}
	.history h3 span{
		float: right;
		font-size: 12px;
		margin-top: 20px;
	}
	.history h3 span a{
		color:#999;
	}
	.history h3 span a:hover{
		color:#ff9900;
	}
	.historyol{
		padding-left: 20px;
		margin-top: 5px;
	}
	.historyol a{
		display:inline-block;
		width:220px;
		color:#666;
		overflow: hidden;
		text-overflow:ellipsis;
		white-space: nowrap;
		vertical-align: middle;
		margin-top: -5px;
	}
	.historyol a:hover{
		color:#ff9900;
	}
	.historyol .text_date{
		float: right;
		color:#999;
		font-size: 14px;
	}
	.write_box .editorput{
		display:inline-block;
		height: 30px;
		width: 90px;
		border-radius: 10px;
		background: #ff9900;
		color: #fff;
		text-align: center;
		line-height: 30px;
		margin-top: 5px;
		margin-left: 5px;
		cursor: pointer;
	}
	#editor{
		color:#666;
	}
	.write_box .editorput:hover{
		background: #ff8800;
	}
	.hidden_form{
		display: none;
	}
</style>

</head>
<body>
	<% 
		if(request.getAttribute("message")!=null&&!request.getAttribute("message").equals("")){
			out.print("<script>swal('"+request.getAttribute("message")+"');</script>");
		}
	%>
	<header></header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-6 column">
							<div class="write_box">
								<div id="editor"><p>在此编辑公告</p></div>
								<span class="editorput">发布</span>
							</div>
							<form class="hidden_form" action="<%= request.getContextPath() %>/admin/dormitortuploadmess.shtml" method="post">
								<input type="text" id="text" name="text" />
								<input type="text" id="texthtml" name="texthtml" />
								<input type="submit" id="form_btn" />
							</form>
						</div>
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
					            'foreColor',  // 文字颜色
					            'backColor',  // 背景颜色
					            'list',  // 列表
					            'justify',  // 对齐方式
					            'emoticon',  // 表情
					            'table',  // 表格
					        ]
					        editor.create();
					        $(".editorput").click(function(){
					        	if($.trim(editor.txt.text())==""){
					        		swal("您输入为空！");
					        		return;
					        	}
					        	$("#text").val(editor.txt.text());
				        		$("#texthtml").val(editor.txt.html());
				        		$("#form_btn").click();
				        	});
					    </script>
						<div class="col-md-6 column">
							<h3 class="newstitle">
								最新公告
							</h3>
							<div class="news">
								${firstNotice.texthtml }
							</div>
							<div class="history">
								<h3>
									历史公告<span><a href="<%= request.getContextPath() %>/admin/noticelist.shtml">查看更多&gt;&gt;</a></span>
								</h3>
								<ol class="historyol">
									<c:forEach items="${dormitorNotices }" var="dormitorNotice">
										<li>
											<a href="<%= request.getContextPath() %>/admin/dormitortnotice.shtml?id=${dormitorNotice.id}">${dormitorNotice.text }</a><span class="text_date">${dormitorNotice.date }</span>
										</li>
									</c:forEach>
								</ol>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer></footer>
</body>
</html>