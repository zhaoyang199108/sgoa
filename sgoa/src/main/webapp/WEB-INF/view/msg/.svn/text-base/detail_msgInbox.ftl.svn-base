<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>站内信详细</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
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
			$(".act-down").click(function(){
				$("#srcFileName").val($(this).attr("alt"));
				$('form').attr("action","${appDomain}/msg/download_file.htm");
				$('form').submit();
			});		
			$("#cancelBtn").click( function() {
                $('form').attr("action", "${appDomain}/msg/msgInbox_list.htm");
				$('form').submit();				
				});	  	
				
			$("#replayBtn").click( function() {
                $('form').attr("action", "${appDomain}/msg/replay_msgInboxInfo.htm?id=${msgInbox.id}");
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
			<h3 class="title"><font size="3"><strong>站内信详细</strong></font></h3>
			<form class="f0" action="${appDomain}/msg/detail_msgInbox.htm" method="POST">
				<table class="ftb">
					<tr>
						<th>发件人:</th>
						<td>
		                 <input type="hidden" id="receiverIds" name="receiverIds" value="${msgInbox.senderId}" />
		                 <input class="txt title" id="receiver" name="receiver" type="text" value="${msgInbox.senderName}"  readonly="readonly" />		              
		                 </td>
					</tr>
					<tr>
						<th>标题:</th>
						<td>
						<input class="txt title" type="text" id="title" name="title"value="${msgInbox.title}" readonly="readonly"/>
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
						<td>
						<textarea name="msgText" class="woe" style="height:200px;" id="ct">${msgInbox.msgText}</textarea>
						</td>
					</tr>
					<#if loginId=="ybgs">
					<tr>					 
						<th>短信通知:</th>
						<td>
						<input class="txt title" type="text" id="phoneText" name="phoneText"  value="${msgInbox.phoneText}"maxlength="70"/>
						</td>
					</tr>	
					</#if>
					<tr class="act">
					  <td colspan="2">				
					 <input type="button" id="replayBtn" value="回复" class="btn" />			
					 <input type="button" id="cancelBtn" value="返回" class="btn" />
						</td>
					</tr>
				</table>
			</form>
		</div>
		</div>
		</div>
	</div>
</body>
</html>
