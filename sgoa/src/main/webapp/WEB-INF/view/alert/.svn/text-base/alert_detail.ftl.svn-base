<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>审批流程详细页面</title>  
     <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div class="sow">
			<h3 class="title01">消息提醒更新</h3>
			<form class="f0" action="${appDomain}/alert/alert_detail.htm" method="POST">
			<input class="text" type="hidden" name="id" value="${alert.id}"/>
			<table class="ftb">
				<tr>
				    <th>标题:</th>
					<td colspan="3">						
						<input class="text" type="text" name="title" value="${alert.title}" readonly="readonly"/>
					</td>
				</tr>	
				<tr>
				    <th>用户名称:</th>
					<td>						
						<input class="text" type="text" name="userName" value="${alert.userName}" readonly="readonly"/>
					</td>
					<th>模块名称:</th>
					<td>						
						<input class="text" type="text" name="modeName" value="${alert.modeName}" readonly="readonly"/>
					</td>
				</tr>			
				<tr>
				    <th>提醒时间:</th>
					<td>						
						<input class="text" type="text" name="alertTime" value="${alert.alertTime}" readonly="readonly"/>
					</td>
					<th>提醒状态:</th>
					<td>						
						<select class="sel-txt" name="status">
						      <option value="1" <#if alert.status == 1>selected="selected"</#if>>未办理</option>
						      <option value="2" <#if alert.status == 2>selected="selected"</#if>>已办理</option>
                         </select>
					</td>
				</tr>
				<tr>
				    <th>内容:</th>
					<td colspan="3">						
						<textarea name="remark" rows="4" cols="65" maxlength="400">${alert.remark}</textarea>
					</td>
				</tr>
				<tr class="act">
				   <td colspan="6">				
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>	
				   </td>
			    </tr>	
			</table>								
			</form>
	</div>
</body>
</html>
