<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="zh-CN">
<head>  
	<title>用户登录</title>  
	<link href="${cssDomain}/css/login.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>
</head>
<script type="text/javascript">
	$(document).ready( function() {
		$("#loginBtn").click( function() {
			var saveData = {loginId:"admin",password:"1"}; //发送给服务器的JSON
			$.post("${appDomain}/home/regist.htm",saveData,function(result){
		    	alert(result);
		  	});
		});
	});
</script>
<body class="login">
<form method="POST" name="loginForm" action="" class="form_ct">
<div class="header" >
  <div class="top">
   <div class="logo"></div>
   <span></span>
  </div>
</div>
<div class="login_contant">
  <div class="login_main">
   <div class="lg_left"></div>
   <div class="lg_form">
    <div class="lg_tit"> <img src="${imageDomain}/images/lgotit.jpg" width="343" height="68" /></div>
    <ul class="lg_dl">
    	<li class="btn"><input name="登录" id="loginBtn" type="button" value="登录" class="submit" /></li>
    </ul>
   </div>
  </div>
</div>
<div class="footer">
 <div class="xian"><span class="le"></span><span class="rig"></span></div>
 <div class="bot"><p>协会联盟后台管理系统</p></div>
</div>
</from>
</body>
</html>
