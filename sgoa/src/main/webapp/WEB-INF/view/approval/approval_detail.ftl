<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>审批流程详细页面</title>  
	<base target="_self">
     <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/biz/approval.js"></script>	
	<script type="text/javascript">
		$(document).ready( function() {
			$("#cancelBtn").click( function() {
                $('form').attr("action", "${appDomain}/approval/approval_list.htm");
				$('form').submit();				
			});	  					
		});
	</script>
</head>
<body>
<div class="sow">
		<h3 class="title"><font size="3"><strong>审批流程详细</strong></font></h3>
			<form class="f0" action="#" method="POST">
				<table class="ftb">
				<tr>
				    <th>审批流程名称:</th>
					<td>						
						<input class="op" type="text" name="approvalName" value="${approval.approvalName}"/>
					</td>
				</tr>
				<tr>
					<th>审批流程类型:</th>
					<td>
						<select name="approvalType" disabled="disabled">	
							<option value='X' <#if approval.approvalType=='X'>selected="selected"</#if>>通知公告</option>
							<option value='Y' <#if approval.approvalType=='Y'>selected="selected"</#if>>收文</option>
							<option value='Z' <#if approval.approvalType=='Z'>selected="selected"</#if>>发文</option>
							<option value='W' <#if approval.approvalType=='W'>selected="selected"</#if>>发文办事</option>
							<option value='U' <#if approval.approvalType=='U'>selected="selected"</#if>>会议预约</option>
							<option value='J' <#if approval.approvalType=='J'>selected="selected"</#if>>要情简报</option>
						 </select>
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
