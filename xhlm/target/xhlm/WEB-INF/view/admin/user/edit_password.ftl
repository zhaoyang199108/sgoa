<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>修改密码</title>  
    <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>	
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
	<div id="main">
		<div id="content">
			<h3 class="title">修改密码</h3>
			<form class="f0" action="${appDomain}/admin/user/edit_password.htm" method="POST">
				<ul class="form-1c">
				<li>
						<label>旧密码:</label>
						<input class="text" type="password" name="oldPassword"/>
				</li>
				<li>
						<label>新密码:</label>
						<input class="text" type="password" name="password"/>
				</li>
				<li class="action">
						<input type="button" id="saveBtn" class="btn" value="提 交"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>
				</li>
			</ul>	
			</form>
		</div>
	</div>
</body>
</html>
