<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宿舍内部</title>
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
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
<linl rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/sweetalert.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
section {
	margin-top: 50px;
}
.breadcrumb li {
	margin: 0 5px;
}
.student{
	border: 1px solid #ccc;
	height: 120px;
	margin: 10px;
	border-radius: 3px;
	padding: 0;
	position: relative;
}
.student i{
	display: none;
	position: absolute;
	right: 5px;
	top:5px;
	color:red;
	cursor: pointer;
	transition: all 0.5s;
}
.student:hover i,.student:hover b{
	display: inline-block;
}
.student i:hover{
	transform: rotate(180deg);
	-ms-transform: rotate(180deg);		/* IE 9 */
	-webkit-transform: rotate(180deg);	/* Safari and Chrome */
	-o-transform: rotate(180deg);		/* Opera */
	-moz-transform: rotate(180deg);
}
.setroomgam{
	display: none;
	position: absolute;
	left: 5px;
	top:5px;
	color:red;
	cursor: pointer;
	transition: all 0.5s;
}
.setroomgam:hover{
	transform: rotate(180deg);
	-ms-transform: rotate(180deg);		/* IE 9 */
	-webkit-transform: rotate(180deg);	/* Safari and Chrome */
	-o-transform: rotate(180deg);		/* Opera */
	-moz-transform: rotate(180deg);
}
.student:hover{
	background: #efefef;
}
.student a{
	display: block;
	height: 100%;
	width: 100%;
	color:#666;
}
.student a:hover{
	background: #efefef;
	color:#ff9900;
}
.student img{
	height: 80px;
	width: 80px;
	border-radius: 50%;
	border: 1px solid #efefef; 
	float: left;
	margin-top: 20px;
	margin-left: 10px;
}
.addstudent{
	height: 100%;
	width: 100%;
	outline: none;
	border:0px;
}
.student-about{
	float: right;
	height: 100%;
	width: 80px;
	padding: 25px 0;
	margin-right: 5px;
}
.my_box{
	width: 100%;
	height: 270px;
	border:1px solid #efefef;
	margin-bottom: 20px;
	padding: 10px;
	box-shadow: 1px 2px 1px #efefef;
}
.electric{
	width: 100%;
	height: 220px;
}
.more{
	display:inline-block;
	font-size:12px;
	float: right;
	margin-top: 15px;
}
.more a{
	color:#999;
}
.more a:hover{
	color:#ff9900;
}
#loading{
	height: 40px;
	width: 40px;
	position: fixed;
	top: 50%;
	left: 50%;
	margin-top: -20px;
	margin-left: -20px;
	z-index: 100;
}
.load{
	display:none;
	height: 100%;
	width: 100%;
	position: fixed;
	background: rgba(0,0,0,0.2);
	z-index: 50;
}
.team{
	display:inline-block;
	height:10px;
	width:10px;
	color:#000;
	position: absolute;
	left: 50%;
	top:5px;
	margin-left: -5px;
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
		<div class="load">
			<img alt="loadimg" id="loading" src="<%= request.getContextPath() %>/resources/images/admin/loading.gif" />
		</div>
		<div>
			<ul class="breadcrumb">
				<li><a
					href="<%= request.getContextPath()+"/admin/dormitory.shtml" %>">宿舍楼管理</a>
				</li>/
				<li><a
					href="<%= request.getContextPath()+"/admin/dormitoryroom.shtml?pid=" %>${dormitory.id }">${dormitory.name }</a>
				</li>/
				<li class="active">${rooms.name }宿舍</li>
			</ul>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-6 column">
							<div class="row clearfix">
								<a href="#" class="btn btn-default btn-block btn-success" data-toggle="modal" data-target="#myModal">添加学生</a>
								<a id="removeall" href="javascript:void(0)" class="btn btn-default btn-block btn-danger">清空学生</a>
								<c:forEach items="${student }" var="onestudent">
									<div class="col-md-5 column student">
										<a href="<%= request.getContextPath() %>/admin/roomstudentmess/${dormitory.id}/${rooms.id}/${onestudent.studentid}.shtml">
										<img alt="" src="<%= request.getContextPath() %>${onestudent.headimg}" />
										<div class="student-about">
											<p><span class="student-name">${onestudent.name}</span></p>
											<p><span class="student-majorclass">
												<c:forEach items="${majorclassmap }" var="class">
													<c:if test="${class.key == onestudent.majorclass }">
														${class.value['name'] }
													</c:if>
												</c:forEach>
											</span></p>
										</div>
										</a>
										<c:if test="${rooms.roomgam==onestudent.studentid}">
											<em data-toggle="tooltip" data-placement="top" title="舍长"  class="team fa fa-bookmark-o"></em>
										</c:if>
										<i data-toggle="tooltip" data-placement="top" title="删除学生"  class="deletestudent fa fa-close" data-dormitory="${dormitory.id}" data-room="${rooms.id}" studentid="${onestudent.id }" 
										data-name="${onestudent.name }"></i>
										<b data-toggle="tooltip" data-placement="top" title="设为舍长" class="setroomgam fa fa-bookmark" data-room="${rooms.id}" studentid="${onestudent.studentid }" data-name="${onestudent.name }"></b>
									</div>
								</c:forEach>
							</div>
						</div>
						<div class="col-md-6 column">
							<div class="my_box">
								<h4 class="text-center">
									近六个月电费表<span class="more"><a href="<%= request.getContextPath() %>/admin/roomelectric/${dormitory.id }/${rooms.id }.shtml">查看更多>></a></span>
								</h4>
								<canvas id="electric"></canvas>
							</div>
							<div class="my_box">
								<h4 class="text-center">
									近六个月卫生表<span class="more"><a href="<%= request.getContextPath() %>/admin/roomelectric/${dormitory.id }/${rooms.id }.shtml">查看更多>></a></span>
								</h4>
								<canvas id="hygiene"></canvas>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			window.onload = function() {
                var ctx = document.getElementById("electric").getContext("2d");
                var ctx1 = $("#hygiene");
                //方式二：传入对象字面量去修改默认图标参数，自定义图表
                var MyNewChart = new Chart(ctx,{
               		type: 'line',
               		data:{
    					labels : [<c:forEach items="${date}" var="nowdate" varStatus="index">"${nowdate}"<c:if test="${index.last==false}">,</c:if></c:forEach>],
    					thisIds : [1,2,3,4,5,6],
    					datasets : [{
    						backgroundColor:'rgba(0,245,255,0.2)',
    	                    data: ${ele}
    					}]
    			},
       				options: {
    					//标题设置
       		            title:{
       		                display:true,
       		                text:'用电量 / 月',
       		            },
       		            //禁用动画
       		            animation:{
       		              duration:1000,
       		            },
       		            hover:{
       		                animationDuration:500,
       		            },
       		            responsiveAnimationDuration: 500,
       		            tooltips:{
         		              enable:false
         		            },
         		            //顶部的文字提示
         		            legend:{
         		              display:false
         		            },
       		            //设置x,y轴网格线显示,标题等
       		            scales :{
       		                xAxes:[{
       		                    //轴标题
       		                    scaleLabel:{
       		                        display:true,
       		                        labelString:'月份',
       		                        fontColor:'#666'
       		                    },
       		                    //网格显示
       		                    gridLines:{
       		                        display:false
       		                    },


       		                }],
       		                yAxes:[{
       		                    scaleLabel:{
       		                        display:true,
       		                        labelString:'电量/°',
       		                     	fontColor:'#666'
       		                    },
       		                    gridLines:{
       		                        display:false
       		                    },
       		                 	ticks:{
           		     				min:0,
           		    				max:100	
       		                 	}
       		                }],

       		            },

       		            //禁用赛尔曲线
       		            elements: {
       		                line: {
       		                    tension: 0,
       		                }
       		            }
    			 }
                });
                var MyNewChart1 = new Chart(ctx1,{
               		type: 'line',
               		data:{
    					labels :[<c:forEach items="${date}" var="nowdate" varStatus="index">"${nowdate}"<c:if test="${index.last==false}">,</c:if></c:forEach>],
    					thisIds : [1,2,3,4,5,6],
    					datasets : [{
    						backgroundColor:'rgba(0,0,0,0.2)',
    	                    data: ${hty}
    					}]
    			},
       				options: {
    					//标题设置
       		            title:{
       		                display:true,
       		                text:'卫生 / 月',
       		            },
       		            //禁用动画
       		            animation:{
       		              duration:1000,
       		            },
       		            hover:{
       		                animationDuration:500,
       		            },
       		            responsiveAnimationDuration: 500,
       		            tooltips:{
         		              enable:false
         		            },
         		            //顶部的文字提示
         		            legend:{
         		              display:false
         		            },
       		            //设置x,y轴网格线显示,标题等
       		            scales :{
       		                xAxes:[{
       		                    //轴标题
       		                    scaleLabel:{
       		                        display:true,
       		                        labelString:'月份',
       		                        fontColor:'#666'
       		                    },
       		                    //网格显示
       		                    gridLines:{
       		                        display:false
       		                    },


       		                }],
       		                yAxes:[{
       		                    scaleLabel:{
       		                        display:true,
       		                        labelString:'分数',
       		                     	fontColor:'#666'
       		                    },
       		                    gridLines:{
       		                        display:false
       		                    },
       		                 	ticks:{
           		     				min:0,
           		    				max:100	
       		                 	}

       		                }],

       		            },

       		            //禁用赛尔曲线
       		            elements: {
       		                line: {
       		                    tension: 0,
       		                }
       		            }
    			 }
                });
            }
		</script>
		<div class="modal fade" id="myModal">
		    <div class="modal-dialog">
		      <div class="modal-content">
		      	<% String path=request.getContextPath()+"/admin/actionroomstudent.shtml?act=insert"; %>
		   		<form action="<%= path %>" method="post">
		   			<input type="hidden" name="dormitory" value="${dormitory.id}" />
		   			<input type="hidden" name="room" value="${rooms.id}" />
			        <!-- 模态框头部 -->
			        <div class="modal-header">
			          <h4 class="modal-title">请输入学生学号：</h4>
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			        </div>
			   
			        <!-- 模态框主体 -->
			        <div class="modal-body">
			          	<input type="text" name="studentid" class="addstudent" placeholder="在此输入…" />
			        </div>
			   
			        <!-- 模态框底部 -->
			        <div class="modal-footer">
			          <input type="submit" class="btn btn-secondary" value="添加" />
			        </div>
		   		</form>
		      </div>
		    </div>
		  </div>
	</section>
	<script type="text/javascript">
	(function(){
		$(".deletestudent").click(function(){
			if(confirm('您确定移除名字为"'+$(this).attr("data-name")+'"的学生？')){
				window.location.href="<%= request.getContextPath() %>/admin/actionroomstudent.shtml?act=delete&id="+$(this).attr("studentid")+"&dormitory="+
				$(this).attr("data-dormitory")+"&room="+$(this).attr("data-room");
			}
		});
		$("#removeall").click(function(){
			if(confirm('您确定移除该宿舍的所有学生？')){
				window.location.href="<%= request.getContextPath() %>/admin/actionroomstudent.shtml?act=removeall&dormitory=${dormitory.id}&room=${rooms.id}";
			}
		});
		$(".setroomgam").click(function(){
			var time = setTimeout(function () {

		        $(".load").css("display","block");

		    }, 600);
			$.ajax({
				type:"POST",
				url:"<%= request.getContextPath() %>/admin/setroomgam.shtml",
				contentType:"application/json",
				dataType:"json",
				data:JSON.stringify({"id":$(this).attr("data-room"),"roomgam":$(this).attr("studentid")}),
				success:function(data){
	            	 clearTimeout(time);
					if(data.flag){
						swal("设置成功！");
						location.reload();
					}else{
						swal("设置失败！请重新设置");
					}
				}
			});
		});
	}(jQuery))
	</script>
	<footer></footer>
</body>
</html>