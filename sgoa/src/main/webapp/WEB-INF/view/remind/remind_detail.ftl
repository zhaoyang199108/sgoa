<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>消息中心详细页面</title>  
     <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="sow">
			<h3 class="title01">消息中心详细</h3>
			<form class="f0" action="${appDomain}/remind/remind_detail.htm" method="POST">
			<input class="text" type="hidden" name="id" value="${remind.id}"/>
			<table class="ftb">
				<tr>
				    <th>标题:</th>
					<td>						
						${remind.title}
					</td>
					<th>状态:</th>
					<td>	
						<#if remind.status == '1'>提醒
						<#elseif remind.status == '2'>暂不提醒
						<#elseif remind.status == '3'>不提醒
						</#if>					
					</td>
				</tr>	
				<tr>
					<th>用户名称:</th>
					<td>						
						${remind.userName}
					</td>
					<th>模块名称:</th>
					<td>						
						<#if remind.modeName == '1'>通知管理
						<#elseif remind.modeName == '2'>公告管理
						<#elseif remind.modeName == '3'>发文管理
						<#elseif remind.modeName == '4'>收文管理
						<#elseif remind.modeName == '5'>工作日程
						<#elseif remind.modeName == '6'>个人日程
						<#elseif remind.modeName == '7'>会议室预约
						<#elseif remind.modeName == '8'>站内信
						<#elseif remind.modeName == '9'>局领导重大活动安排
						<#elseif remind.modeName == '10'>文稿拟定
						<#elseif remind.modeName == '11'>收文流转
						</#if>
					</td>
				</tr>			
				<tr class="act">
				   <td colspan="4">				
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>	
				   </td>
			    </tr>	
			</table>								
			</form>
	</div>
</body>
</html>
