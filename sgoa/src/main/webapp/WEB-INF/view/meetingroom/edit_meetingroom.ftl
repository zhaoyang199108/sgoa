<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>更新会议室信息</title>  
	<link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript">
		$(document).ready( function() {
		$("#updateBtn").click( function() {
			if(!isEmpty($("input[name=roomName]"),"会议室名称不允许为空！")){
					return;
				}	
		    if(!isEmpty($("input[name=roomAddress]"),"会议室地址不允许为空！")){
					return;
				}	
				$('form').submit();
			});
		});
	</script>
</head>
<body>
 <div class="sow">
	<div id="main">
		<div id="content">
			
			<form action="${appDomain}/meetingRoom/edit.htm" method="POST">
			 <h3 class="title"><font size="3"><strong>更新会议室</strong></font></h3>
				<input type="hidden" name="id" value="${meetingRoom.id}" />
				<table class="ftb">
				    <tr>
						<th>会议室名称:</th>
						<td><input class="txt title0" type="text" name="roomName" value="${meetingRoom.roomName}" /></td>
						</tr>
						<tr>
						<th>会议室地址:</th>
						<td><input class="txt title0" type="text" name="roomAddress" value="${meetingRoom.roomAddress}" /></td>
					</tr>
					 <tr class="act">
						 <td colspan="2">
							<input class="btn" name="draftBtn" type="button" id="updateBtn" value="更 新" />
						    <input class="btn" name="draftBtn" type="button" value="取 消" onclick="window.close();" />	 
				         </td>
				     </tr>
				</table>
			</form>
		</div>
	</div>
	</div>
</body>
</html>
