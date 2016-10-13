<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>回执页面</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
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
			<h3 class="title"><font size="3"><strong>新增回执</strong></font></h3>
			<form class="f0" action="${appDomain}/sw/sw_receipt.htm" method="POST">
				<table class="ftb">
					<input type="hidden"  name="docinId" value="${docinId}" />
			
				<tr>
					<th style="width:20%;">办理结果:</th>
					<td>						
						<textarea class="text" type="text" name="bljg" style="width:90%;"></textarea>
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
