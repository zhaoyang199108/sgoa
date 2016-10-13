<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>修改密码</title>  
	<link href="${cssDomain}/css/login.css" type="text/css" rel="stylesheet">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript">
		$(document).ready( function() {		
			$("#saveBtn").click( function() {
			    // 旧密码非空校验
				if(!isEmpty($("input[name=oldPassword]"),"旧密码不允许为空！")){
					return;
				}				
				// 新密码非空校验
				if(!isEmpty($("input[name=password]"),"新密码不允许为空！")){
					return;
				}				
				$('form').submit();
			});
		});
	</script>
</head>
<body>

	<div class="sow">
	<div class="calog">
	</br>
			<h3 class="title"><font size="3"><strong>修改密码</strong></font></h3>
			<form class="f0" action="${appDomain}/user/edit_password.htm" method="POST">
				<table class="ftb">
				<tr>
					<th>原密码:</th>
					<td>
						<input class="text" type="password" name="oldPassword"/>
					</td>
				</tr>
				<tr>
					<th>新密码:</th>
					<td>						
						<input class="text" type="password" name="password"/>
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
	</div>
</body>
</html>
