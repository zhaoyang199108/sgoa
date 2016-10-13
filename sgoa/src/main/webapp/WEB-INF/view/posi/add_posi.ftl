<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>职责添加页面</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript">
		$(document).ready( function() {		
			$("#saveBtn").click( function() {
			 // 职责名称非空校验
				if(!isEmpty($("input[name=grpoName]"),"职责名称不允许为空！")){
					return;
				}
				$('form').submit();
			});
		});
	</script>
</head>
<body>
	<div class="sow">
			<h3 class="title"><font size="3"><strong>新增职责</strong></font></h3>
			<form class="f0" action="${appDomain}/posi/add_posi.htm" method="POST">
				<table class="ftb">
				<tr>
				    <th>职责名称:</th>
					<td>						
						<input class="text" type="text" name="grpoName" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<th>备注:</th>
					<td>						
						<input class="text" type="text" name="remark" maxlength="32"/>
					</td>
				</tr>
				<tr class="act">
				   <td colspan="6">				
						<input type="button" id="saveBtn" class="btn" value="提 交"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>	
				   </td>
			    </tr>	
			</table>								
			</form>
	</div>
</body>
</html>
