<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>文稿拟订详细</title>  
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
				upImgUrl: "${homeDomain}/upload_image.htm?dir=msgone",
				upImgExt: "jpg,jpeg,gif,bmp,png"
			});	
			
			 // 增加按钮点击事件
			    $(".neirong").click(function(){
			        var url = "${appDomain}/msgone/content_detail.htm?dRecordid=" + $(this).attr("alt") + "&r=" + Math.random();
			        var param = 'dialogWidth=940px;dialogHeight=750px;status=no;center=yes;scroll=yes';
			        var val = window.showModalDialog(url, '', param);
			  	 if (val == 'refresh') {
			            alert("操作成功");
			        }
			    });
			
			$(".act-down").click(function(){
				$("#srcFileName").val($(this).attr("alt"));
				$('form').attr("action","${appDomain}/msgone/download_file.htm");
				$('form').submit();
			});		
			$("#cancelBtn").click( function() {
                $('form').attr("action", "${appDomain}/msgone/msgoneInbox_list.htm");
				$('form').submit();				
				});	  	
				
			$("#replayBtn").click( function() {
                $('form').attr("action", "${appDomain}/msgone/replay_msgoneInboxInfo.htm?id=${msgoneInbox.id}");
				$('form').submit();				
				});	  		
		});
	</script>
</head>
<body>	
	<div id="main">
	<div class="main_nav">
	  <#include "msgone/menu.ftl">
		<div id="content">
			<h3 class="title"><font size="3"><strong>文稿拟订详细</strong></font></h3>
			<form class="f0" action="${appDomain}/msgone/detail_msgoneInbox.htm" method="POST">
				<table class="ftb">
					<tr>
						<th>发件人:</th>
						<td>
		                 <input type="hidden" id="receiverIds" name="receiverIds" value="${msgoneInbox.senderId}" />
		                 <input class="txt title" id="receiver" name="receiver" type="text" value="${msgoneInbox.senderName}"  readonly="readonly" />		              
		                 </td>
					</tr>
					<tr>
						<th>标题:</th>
						<td>
						<input class="txt title" type="text" id="title" name="title"value="${msgoneInbox.title}" readonly="readonly"/>
						</td>
					</tr>	
					<tr>
						<th>附件名:</th>
						<input type="hidden" id="srcFileName" name="srcFileName" value="${msgoneInbox.srcFileName}"/>
						<td><a class="act-down" href="#" alt="${msgoneInbox.srcFileName}">${msgoneInbox.srcFileName}</a>
						</td>
					</tr>							
					<tr>
						<th>内容:</th>
						<td>
						<a style="color:red; text-decoration: underline;" class="neirong" href="#" title="点击查看详细内容" alt="${msgoneInbox.dRecordid}">点击查看详细内容</a>
						</td>
					</tr>
					<#if loginId=="ybgs">
					<tr>					 
						<th>短信通知:</th>
						<td>
						<input class="txt title" type="text" id="phoneText" name="phoneText"  value="${msgoneInbox.phoneText}"maxlength="70"/>
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
