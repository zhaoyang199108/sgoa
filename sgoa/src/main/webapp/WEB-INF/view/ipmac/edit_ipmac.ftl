<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>更新IP/MAC信息</title>  
	<link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript">
		$(document).ready( function() {
		$("#updateBtn").click( function() {
			if(!isEmpty($("input[name=optIp]"),"IP名称不允许为空！")){
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
			
			<form action="${appDomain}/ipmac/edit.htm" method="POST">
			 <h3 class="title"><font size="3"><strong>更新IP/MAC</strong></font></h3>
				<input type="hidden" name="id" value="${ipmac.id}" />
				<table class="ftb">
				    <tr>
						<th>IP名称:</th>
						<td><input class="txt title0" type="text" name="optIp" value="${ipmac.optIp}" /></td>
						</tr>
						<tr>
						<th>MAC名称:</th>
						<td><input class="txt title0" type="text" name="optMac" value="${ipmac.optMac}" /></td>
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
