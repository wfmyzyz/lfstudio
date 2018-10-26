<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="pagination-centered">
		  <ul class="pagination">
		  	<li><span>共${pages }页</span></li>
		  	<!-- 页面上转 -->
		  	<c:if test="${nowpage == 1 }">
		  		<li class="arrow unavailable"><a href="${url}?pageid=${nowpage-1  }">«</a></li>
		  	</c:if>
		  	<c:if test="${nowpage != 1 }">
		  		<li class="arrow"><a href="${url}?pageid=${nowpage-1  }">«</a></li>
		  	</c:if>
		  	<c:if test="${pages <= 5 }">
			  	<c:forEach begin="1" end="${pages }" var="page">
			  		<c:if test="${page==nowpage }">
			  			<li class="current"><a href="${url}?pageid=${page  }">${page }</a></li>
			  		</c:if>
			  		<c:if test="${page!=nowpage }">
			  			<li><a href="${url}?pageid=${page  }">${page }</a></li>
			  		</c:if>
			  	</c:forEach>
		  	</c:if>
		  	<c:if test="${pages > 5 }">
			  	<c:if test="${nowpage <= 4 }">
			  		<c:forEach begin="1" end="5" var="page">
			  			<c:if test="${page==nowpage }">
				  			<li class="current"><a href="${url}?pageid=${page  }">${page }</a></li>
				  		</c:if>
				  		<c:if test="${page!=nowpage }">
				  			<li><a href="${url}?pageid=${page  }">${page }</a></li>
				  		</c:if>
			  		</c:forEach>
			  		<li class="unavailable"><a href="javasript:void(0)">…</a></li>
			  		<li class=""><a href="${url}?pageid=${pages }">${pages }</a></li>
			  	</c:if>
			  	<c:if test="${nowpage > 4 && nowpage < pages-3 }">
			  		<li class=""><a href="${url}?pageid=1">1</a></li>
			  		<li class="unavailable"><a href="javasript:void(0)">…</a></li>
			  		<c:forEach begin="${nowpage-2 }" end="${nowpage+2 }" var="page">
			  			<c:if test="${page==nowpage }">
				  			<li class="current"><a href="${url}?pageid=${page  }">${page }</a></li>
				  		</c:if>
				  		<c:if test="${page!=nowpage }">
				  			<li><a href="${url}?pageid=${page  }">${page }</a></li>
				  		</c:if>
			  		</c:forEach>
			  		<li class="unavailable"><a href="javasript:void(0)">…</a></li>
			  		<li class=""><a href="${url}?pageid=${pages }">${pages }</a></li>
			  	</c:if>
			  	<c:if test="${nowpage >= pages-3 }">
			  		<li class=""><a href="${url}?pageid=1">1</a></li>
			  		<li class="unavailable"><a href="javasript:void(0)">…</a></li>
			  		<c:forEach begin="${pages-4 }" end="${pages }" var="page">
			  			<c:if test="${page==nowpage }">
				  			<li class="current"><a href="${url}?pageid=${page  }">${page }</a></li>
				  		</c:if>
				  		<c:if test="${page!=nowpage }">
				  			<li><a href="${url}?pageid=${page  }">${page }</a></li>
				  		</c:if>
			  		</c:forEach>
			  	</c:if>
		  	</c:if>
		  	<!-- 页面下转 -->
		  	<c:if test="${nowpage == pages }">
		  		<li class="arrow unavailable"><a href="${url}?pageid=${nowpage+1  }">»</a></li>
		  	</c:if>
		  	<c:if test="${nowpage != pages }">
		  		<li class="arrow"><a href="${url}?pageid=${nowpage+1  }">»</a></li>
		  	</c:if>
		  	<li><span>跳转到</span></li>
		  	<li><input id="jumppid" style="width:50px;height:25px;padding: 0px 0px 0px 5px;margin-top: 5px;" type="number" max="${pages }"  min="1" /></li>
		  	<li><span>页</span></li>
		  	<li><i class="jumpbtn" onclick="jump()">确定</i></li>
		  </ul>
		</div>
</body>
</html>