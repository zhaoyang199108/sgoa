<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>编写站内信</title>  
    <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
		
			//初始化xhEditor编辑器插件
			$("#ct").xheditor({
				tools:'full',
				skin:'default',
				upMultiple:false,
				upImgUrl: "${homeDomain}/upload_image.htm?dir=msg",
				upImgExt: "jpg,jpeg,gif,bmp,png"
			});
		
		      /**
                 * 收件人选择按钮事件,弹出对话框选择收件人
                 */
                $("#receiverSelect").click(function(){
                    var url = "${appDomain}/common/choose_all_user.htm" + "?ids=" + $("#receiverIds").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#receiver").val(value[1]);
                        $("#receiverIds").val(value[0]);
                    }
                });
                
			$("#saveBtn").click( function() {
			   var title=$('#title').val();
				// 标题非空校验
				if(!isEmpty($("input[name=receiverIds]"),"收件人不能为空！")){
					return;
				}
				if(!isEmpty($("input[name=title]"),"标题不能为空！")){
					return;
				}	
				if(!isEmpty($("textarea[name=msgText]"),"内容不能为空！")){
					return;
				}				
				$("input[name=msgStatus]").val("Y");		
				 if(!confirm("确定发送?")){
                    	return false;
                  }
   	 			if($("#isSendMsg").is(":checked")) {
		         $.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/common/send_msg.htm',
		            dataType: 'json',
		            data: 'userLoginId=' + $("#receiverIds").val() + '&memo=' + encodeURI(encodeURI($("#phoneText").val())) + '&r=' + Math.random(),
		            success: function(data){
		             // 成功
		            },
		            error: function(){
		             // 失败
		            }
		        });
		        }
					
				$('form').submit(); 	   
			});
			
			 $("#draftBtn").click( function() {
			  var title=$('#title').val();
				// 标题非空校验
				if(!isEmpty($("input[name=receiverIds]"),"收件人不能为空！")){
					return;
				}
				if(!isEmpty($("input[name=title]"),"标题不能为空！")){
					return;
				}	
				$("input[name=msgStatus]").val("N");
				if(!confirm("确定保存为草稿?")){
                    	return false;
                  }
                $('form').attr("action", "${appDomain}/msg/draft_add.htm");
				$('form').submit();				
				});
				
		    $("#cancelBtn").click( function() {
                $('form').attr("action", "${appDomain}/msg/msgInbox_list.htm");
				$('form').submit();				
				});
		});
	</script>
</head>
<body>
	<div id="main">
	<div class="main_nav">
	 <#include "msg/menu.ftl">
		<div id="content">
			<form class="f0" action="${appDomain}/msg/write_add.htm" enctype="multipart/form-data" method="POST">   
				<div class="ct">
				<table class="ftb">
					<tr>					    
						 <th>收件人:</th>
						 <td>
		                 <input class="txt title" type="hidden" id="receiverIds" name="receiverIds" value="" />
		                 <input class="txt title" id="receiver" name="receiver" type="text" value="" readonly="readonly" />
		                 <input id="receiverSelect" type="button" class="btn" value="选择" />
		                 <input class="text" type="hidden" name="msgStatus"/>
		                 </td>
					</tr>
					<tr>					 
						<th>标题:</th>
						<td>
						<input class="txt title" type="text" id="title" name="title" maxlength="50"/>
						</td>
					</tr>
					
					<tr>					 
						<th>附件:</th>
						<td>
						<input type="file" class="txt title" name="srcUploadFile" id="srcUploadFile">
						</td>
					</tr>							
					<tr>					    
					<th>内容:</th>
						<td>
							<textarea id="ct"  class="woe" style="width:95%;height:200px;" name="msgText" maxlength="500"></textarea>
						</td>
					</tr>
					<#if loginId=="ybgs">
					<tr>					 
						<th>短信通知:</th>
						<td>
						<input class="txt title" type="text" id="phoneText" name="phoneText" maxlength="70"/>
						<input type="checkbox" id="isSendMsg" checked="true" />是否发送短信
						</td>
					</tr>
					</#if>	
					<tr class="act">
				       <td colspan="2">	
				       
						<input type="button" id="saveBtn" class="btn" value="发送"/>
						<input type="button" id="draftBtn" class="btn" value="保存草稿"/>						
						<input type="reset" id="cancelBtn" class="btn" value="取 消" />
						</td>
					</tr>
					</table>
				</div>
			</form>
		</div>
	  </div>
	</div>
</body>
</html>
