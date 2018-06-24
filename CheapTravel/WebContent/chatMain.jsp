<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
		<%@ include file="jspHeader.jsp" %>
        <title>聊天大厅</title>
        
        <style type="text/css">
            body{
            	font-size:12px;
            	text-align:center;
            }
            #divMain{
            	margin:0 auto;
            	margin-top:50px
            }
            .divShow{
            	text-align:left;
            	border:solid 1px #ccc;
            	height:200px;
            	padding:5px;
            	font-size:12px;
            	overflow-y:scroll
            }
            #divMain{
            	width:700px;
            	border:solid 5px #ccc
            }
            #divMain .divtip{
            	padding:10px;
            }
            #divMain .divtop{
            	width:600px;
            }
            #divMain .divtop .divL{
            	padding-left:20px;
            	float:left;
            	width:70%;
            	heihgt:300px;
            }
            #divMain .divtop .divR{
            	float:right;
            	width:20%;
            }
            #divMain .divBot{
            	clear:both;
            	padding:10px
            }
            #divFace{
            	text-align:left;
            }
            #spnMsg{position:absolute;border:solid 1px #cc3300;padding:2px;background-color:#ffe0a3;display:none}
        </style>

        <script language="javascript" type="text/javascript">
            $(function(){
            	//键盘监听
            	$(document).keypress(function(e){
            		if(e.which==13){
            			SendContent($("#txtContent").val());
            			goToBottom();
            		}
            	});
            	//读取消息
            	GetMessageList();
            	//读取在线用户
            	GetOnlineUsers();
            	//初始化表情
            	InitFaces();
            	//自动刷新
            	AutoRefresh();
            	//发送按钮事件响应
            	$("#Button1").click(function(){
            		var $content=$("#txtContent");
            		if($content.val()!=""){
            			SendContent($content.val());
            		}else{
            			alert("发送内容不能为空！");
            			return false;
            		}
            	});
            	$("#Button2").click(function(){
            		if(confirm("确认下线？")){
            			OffLine();
            		}
            	});
            	//发送消息
            	function SendContent(content){
            		$.ajax({
            			type:"POST",
            			url:"DealData.jsp",
            			data:"action=SendContent&d="+new Date()+"&content="+content,
            			success:function(data){
            				if(data.indexOf("True")){
            					//获取消息
            					GetMessageList();
            					//清空发送框
            					$("#txtContent").val("");
            					
            					goToBottom();
            					//alert('shit for SendMessage');
            				}else{
            					alert("发送失败");
            				}
            			}
            		});
            	}
            	//获取消息
            	function GetMessageList(){
            		$.ajax({
            			type:"POST",
            			url:"DealData.jsp",
            			data:"action=ChatList&d="+new Date(),
            			success:function(data){
            				if(data.indexOf("unLogin")>0){
            					alert("非法进入，请先登录！");
            					window.location="index.html";
            				}else{
            					$("#divContent").html(data);
            				}
            				//alert('shit for GetMessage');
            			}
            		});
            	}
            	//获取在线用户列表
            	function GetOnlineUsers(){
            		$.ajax({
            			type:"POST",
            			url:"DealData.jsp",
            			data:"action=onLineList&d="+new Date(),
            			success:function(data){
            				$("#divOnline").html(data);
            				//alert('shit for GetOnlineUsers');
            			}
            		});
            	}
            	//设置表情
            	function InitFaces(){
            		var strHTML="";
            		for(var i=1;i<=7;i++){
            			strHTML+="<img src='QQface/"+i+".gif' id='"+i+"'/>";
            		}
            		$("#divFace").html(strHTML);
            	}
            	//图片监听
            	$("table tbody tr td img").click(function(){
            		var $txtContent=$("#txtContent");
            		if($txtContent.val()!=undefined){
            			var strContent=$txtContent.val()+"<:"+this.id+":>";
            		}else{
            			var strContent="<:"+this.id+":>";
            		} 
                    $("#txtContent").val(strContent);
                });
            	//下线
            	function OffLine(){
            		$.ajax({
            			type:"POST",
            			url:"DealData.jsp",
            			data:"action=OffLine&d="+new Date(),
            			success:function(data){
            				if(data.indexOf("True")>0){
            					alert("成功下线！");
            					window.location="index.html";
            				}
            				//alert('shit for GetOnlineUsers');
            			}
            		});
            	}
            	//到底部去
            	function goToBottom(){
            		div=document.getElementById("divContent");
					div.scrollTop = div.scrollHeight;
            	}
            	//自动更新页面信息
            	function AutoRefresh(){
            		setInterval(GetMessageList,2000);
            		setInterval(GetOnlineUsers,4000);
            	}
            });
        </script>
    </head>
    <body>
        <div id="divMain">
        	<div class="divtop">
        		<div class="divL">
        			<h3>聊天大厅</h3>
        			<div class="divShow" id="divContent"></div>
        		</div>
        		<div class="divR">
        			<h3>当前在线人员</h3>
        			<div class="divShow" id="divOnline"></div>
        		</div>
        	</div>
        	
        	<div class="divBot">
        		<table>
        			<tr><td colspan="2" id="divFace" class="pb"></td></tr>
        			<tr>
        				<td>
        					<textarea id="txtContent" class="txt" rows="3" cols="64"></textarea>
        				</td>
        				<td>
        					<input id="Button1" type="button" value="发送" class="btn" />
        					<input id="Button2" type="button" value="下线" class="btn" />
        				</td>
        			</tr>
        		</table>
        	</div>
            

            <span id="spnMsg" class="clsTip">正在发送数据...</span>
        </div>
        
    </body>
</html>