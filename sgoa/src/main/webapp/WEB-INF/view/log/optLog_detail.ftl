<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>查看日志详细</title>  
	<link href="${cssDomain}/css/base.css" type="text/css" rel="stylesheet">
    <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>  
</head>
<body>
	<div id="main">
		<div id="content">
			<h3 class="title"><font size="3"><strong>操作日志详细</strong></font></h3>
			<form class="f0" action="${appDomain}/log/optLog_detail.htm" method="POST">
				<input type="hidden" name="id"  value="${optLog.id}"/>
				<table class="ftb">
				<tr>
				    <th>操作人ID:</th>
					<td>						
						<input class="text" type="text" name="optName" value="${optLog.optName}" readonly="readonly"/>
					</td>
					<th>操作模块:</th>
					<td>						
						<input class="text" type="text" name="optModule" value="${optLog.optModule}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
				    <th>操作动作:</th>
					<td>						
						<input class="text" type="text" name="optAction" value="${optLog.optAction}" readonly="readonly"/>
					</td>
				    <th>操作状态:</th>
					<td>												
                		<#if optLog.optStatus == 1><input class="text" type="text" value="成功" readonly="readonly"/></#if>
		                <#if optLog.optStatus == 2><input class="text" type="text" value="失败" readonly="readonly"/></#if>                           
					</td>	
				</tr>
				<tr>
					<th>操纵时间</th>
					<td colspan="3">
						<input class="text" type="text" name="creatDate" value="${optLog.createDate?datetime}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
				    <th>详细内容:</th>
					<td colspan="5">						
						<textarea name="optDesc" id="ct"  class="ctt" readonly="readonly">${optLog.optDesc}</textarea>
					</td>
				</tr>
				
				<tr class="act">
				   <td colspan="6">																		
						<input type="button" value="关闭" class="btn" onclick="window.close();"/>	
				   </td>
				</tr>
				</table>				
				</ul>
			</form>
		</div>
	</div>
</body>
</html>
