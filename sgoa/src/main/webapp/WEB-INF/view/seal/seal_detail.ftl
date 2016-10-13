<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>签章模块详细页面</title>
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>		
</head>
<body>
	<div class="sow">
			<h3 class="title"><font size="3"><strong>签章模块详细</strong></font></h3>
			<form class="f0" action="" method="POST">
				<table class="ftb">
				<tr>
				    <th>用户名称:</th>
					<td>						
						<input class="text" type="text" name="userName" maxlength="50"  value="${seal.userName}"/>
					</td>
				</tr>
				<tr>
					<th>用户密码:</th>
					<td>						
						<input class="text" type="text" name="passWord" maxlength="50"  value="${seal.passWord}"/>
					</td>
				</tr>
				<tr>
				    <th>签章名称:</th>
					<td>						
						<input class="text" type="text" name="sealName" maxlength="50"  value="${seal.sealName}"/>
					</td>
				</tr>
				<tr>
					<th>签章文件:</th>
					<td>						
						<img width="160px" name="markFile" src="${appDomain}/upload/seal/${seal.sealName}.${seal.fileType}"/> 
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
