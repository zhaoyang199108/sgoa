<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>消息中心更新页面</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/GooCalendar/GooFunc.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/GooCalendar/GooCalendar.js"></script>	
	<script type="text/javascript">
		$(document).ready( function() {		
			$("#saveBtn").click( function() {
				$('form').submit();
			});
		});
	</script>
</head>
<body>
	<div class="sow">
			<h3 class="title01">消息中心更新</h3>
			<form class="f0" action="${appDomain}/remind/remind_edit.htm" method="POST">
			<input class="text" type="hidden" name="id" value="${remind.id}"/>
			<input class="text" type="hidden" name="busId" value="${remind.busId}"/>
			<input class="text" type="hidden" name="loginId" value="${remind.loginId}"/>
			<table class="ftb">
				<tr>
					<th>状态:</th>
					<td>						
						<select class="sel-txt" name="status">
						      <option value="1" <#if remind.status == 1>selected="selected"</#if>>提醒</option>
						      <option value="2" <#if remind.status == 2>selected="selected"</#if>>暂不提醒</option>
						      <option value="3" <#if remind.status == 3>selected="selected"</#if>>不提醒</option>
                         </select>
					</td>
				</tr>
				<tr class="act">
				   <td colspan="2">				
						<input type="button" id="saveBtn" class="btn" value="提 交"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>	
				   </td>
			    </tr>	
			</table>								
			</form>
	</div>
</body>
</html>
