<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.java.entity.SchoolCollege"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生宿舍管理-学院查询</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">

<!-- font字体 -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">

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

header {
	margin-top: 80px;
}

body {
	background: rgb(253, 253, 253);
}

.clear {
	clear: both;
}

.nav {
	border-radius: 10px;
	padding: 5px 0;
	position: fixed;
	top: -90px;
	z-index: 100;
	background: rgba(0, 0, 0, 0.7);
	transition: all 0.5s linear;
}

.nav ul {
	list-style: none;
}

.nav ul li {
	float: left;
	padding: 0 10px;
	line-height: 30px;
}

.nav ul li a {
	color: #fff;
}

.nav ul li a:hover {
	color: #ff9900;
}

.xiala {
	display: inline-block;
	height: 30px;
	width: 30px;
	background: rgba(0, 0, 0, 0.8);
	text-align: center;
	line-height: 30px;
	border-radius: 10px;
	color: #fff;
	position: fixed;
	top: 5px;
	left: 50%;
	margin-left: 15px;
	cursor: pointer;
	z-index: 90;
	opacity: 1;
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
	cursor: pointer;
}

section {
	margin-top: 10px;
}

.college {
	border: 1px solid #efefef;
	padding: 20px;
	box-shadow: 1px 1px 1px 2px #efefef;
	border-radius: 15px;
	background: rgb(250, 250, 250);
	margin-bottom: 40px;
}

.major {
	border: 1px solid #ddd;
	margin: 20px 0;
	padding: 20px;
	box-shadow: 1px 1px 1px 1px #ddd;
	border-radius: 10px;
	background: rgb(245, 245, 245);
}

.majorclass {
	border: 1px solid #d5d5d5;
	margin: 20px 0;
	padding: 10px;
	border-radius: 5px;
	background: rgb(240, 240, 240);
}

.majorclass a {
	margin: 0 5px;
	float: left;
	color: #666;
}

.majorclass a:hover {
	color: #ff9900;
}

.back i {
	display: inline-block;
	height: 36px;
	width: 36px;
	background: rgba(0, 0, 0, 0.9);
	text-align: center;
	line-height: 36px;
	color: #fff;
	font-size: 16px;
	cursor: pointer;
	position: fixed;
	right: 20px;
	bottom: 20px;
}

.back i:hover {
	background: rgba(0, 0, 0, 1);
}
</style>
</head>
<body>
	<header>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="nav">
						<ul>
							<c:forEach items="${college }" var="colleges">
								<li><a href="#college${colleges.id }"><c:out
											value="${colleges.name }"></c:out> </a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<i id="xiala" class="fa fa-angle-double-down xiala"></i>
		<div class="search" style="display: none">
			<input type="text" placeholder="搜索…" /><i class="fa fa-search"></i>
		</div>
		<div class="clear"></div>
	</header>
	<section>
		<c:forEach items="${college }" var="collegelist">
			<div class="container college" id='college${collegelist.id }'>
				<div class="row clearfix">
					<div class="col-md-12 column">
						<h3>
							<c:out value="${collegelist.name }"></c:out>
						</h3>
						<div class="row clearfix major">
							<c:forEach items="${major }" var="majors">
								<c:if test="${collegelist.id == majors.pid }">
									<div class="col-md-6 column">
										<h4>${majors.name }</h4>
										<div class="row clearfix majorclass">
											<div class="col-md-12 column">
												<c:forEach items="${classes }" var="class">
													<c:if test="${majors.id == class.pid }">
														<a
															href="<%= request.getContextPath()+"/admin/student/college/class.shtml?" %>
														college=${collegelist.id }&major=${majors.id }&majorclass=${class.id}">${class.name }</a>
													</c:if>
												</c:forEach>
											</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</section>
	<script type="text/javascript">
	(function(){
		var tid = 0;
		$( ".xiala" ).hover( function() {
		   tid = setTimeout( function() {
		        $(".nav").css("top","0");
				$(".xiala").animate({opacity:'0'},'500');
		    }, 300 );
		}, function() {
		    clearTimeout( tid );//当在1秒内退出了hover事件就取消计时代码
		} );
		$(".nav").mouseleave(function() {
			$(".nav").css("top","-90px");
			$(".xiala").animate({opacity:'1'});
		}); 
	}(jQuery));
	</script>
	<footer>
		<div class="back">
			<i class="fa fa-arrow-up"></i>
		</div>
	</footer>
	<script type="text/javascript">
	(function() {
		$(".back i").click(function(){
			$('body,html').animate({scrollTop:0},500);
		})
	}(jQuery))
	</script>
</body>
</html>