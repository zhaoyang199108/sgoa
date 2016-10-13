<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>站内信转发</title>  
	<link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>	
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
			$(".act-down").click(function(){
				$("#srcFileName").val($(this).attr("alt"));
				$('form').attr("action","${appDomain}/msg/download_file.htm");
				$('form').submit();
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
				$("input[name=msgStatus]").val("Y");
				if ($("#isSendMsg").attr("checked")==true) {
		         $.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/common/send_msg.htm',
		            dataType: 'json',
		            data: 'userLoginId=' + $("#nextOptId").val() + '&memo=' + encodeURI(encodeURI("您有新的物资申领需要审批！")) + '&r=' + Math.random(),
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
				$("input[name=msgStatus]").val("N");
				$('form').submit();
				});
		});
	</script>
</head>
<body>	
	<div id="main">
	<div class="main_nav">
		<div id="content">
			<h3 class="title"><font size="3"><strong>站内信转发</strong></font></h3>
			<form class="f0" action="${appDomain}/msg/update_add.htm" method="POST">
				<table class="ftb">
					<tr>
						<th>收件人:</th>
						<td>
		                 <input type="hidden" id="receiverIds" name="receiverIds" value="${msgInbox.senderId}" />
		                 <input class="txt title" id="receiver" name="receiver" type="text" value="${msgInbox.senderName}"  readonly="readonly" />
		                 <input id="receiverSelect" type="button" class="btn" value="选择" />
		                 </td>
					</tr>
					<tr>
						<th>标题:</th>
						<td>
						<input class="text" type="hidden" name="msgStatus"/>
						<input class="txt title" type="text" id="title" name="title" value="${msgInbox.title}" maxlength="50"/>
						</td>
					</tr>
					<tr>
						<th>附件名:</th>
						<input type="hidden" id="srcFileName" name="srcFileName" value="${msgInbox.srcFileName}"/>
						<td><a class="act-down" href="#" alt="${msgInbox.srcFileName}">${msgInbox.srcFileName}</a>
						</td>
					</tr>									
					<tr>
						<th>内容:</th>
						<td colspan="5">
						<textarea name="msgText" id="ct" class="woe" style="height:200px;" maxlength="500">${msgInbox.msgText}</textarea>
						</td>
					</tr>
					<#if loginId=="ybgs">
					<tr>					 
						<th>短信通知:</th>
						<td>
						<input class="txt" type="text" id="phoneText" name="phoneText"  value="${msgInbox.phoneText}"maxlength="70"/>
						<input class="check" type="checkbox" id="isSendMsg" checked="true" />是否发送短信
						</td>
					</tr>
					</#if>	
					<tr class="act">
					  <td colspan="6">
						<input type="button" id="saveBtn" class="btn" value="发送"/>
						<input type="button" id="draftBtn" class="btn" value="存草稿箱"/>						
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
		</div>
	</div>
</body>
</html>
