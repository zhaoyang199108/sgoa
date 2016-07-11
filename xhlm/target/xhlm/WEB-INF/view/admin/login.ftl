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
			// 登录ID非空校验
			//if(!isEmpty($("input[name=userId]"),"用户不允许为空！")){
			//	return;
			//}				
			// 用户密码非空
			//if(!isEmpty($("input[name=userPwd]"),"密码不允许为空！")){
			//	return;
			//}
			$('form').submit();
		});
	});
</script>
<body>
<#if Session.SPRING_SECURITY_LAST_EXCEPTION?exists>
	<div class="errors login_error">
		用户名不存在或密码错误,请重新输入
	</div>
</#if>
<form method="POST" name="loginForm" action="${appDomain}/admin/login" class="form_ct">
<div class="login_header"></div>
<div class="login_contant">
  <div class="lg_shaw">
  <div class="lg_form">
    <div class="lg_tite"><img src="${imageDomain}/images/lg_tte.jpg" width="429" height="58" /></div>
     <ul class="lg_dl">
     <li><span></span><input type="text" class="tet" placeholder="用户名输入" autofocus x-webkit-speech name="j_username" value="${Session.SPRING_SECURITY_LAST_USERNAME}"/></li>
     <li><span class="key"></span><input type="password" class="tet" placeholder="密码输入" name="j_password"/></li>
     <li class="btn">
     <input name="登 录" type="button" value="登 录" class="dl" id="loginBtn"/>
     <input name="重 置" type="reset" value="重 置" class="cz" />
     </li> 
    </ul>
  </div>
  </div>
</div>
<div class="login_bottom"><p>协会联盟后台管理系统</p></div>
</from>
</body>
</html>
