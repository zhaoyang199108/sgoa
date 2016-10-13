<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<link rel="shortcut icon" href="${imageDomain}/image/favicon.ico" type="image/x-icon" /> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>四川省新闻出版广电局政务系统</title>
	<link href="${cssDomain}/css/login.css" type="text/css" rel="stylesheet">
	<link href="${cssDomain}/css/base.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>
	<script type="text/javascript">
	$(document).ready( function() {
		$("#submitBtn").click( function() {
			$.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '${appDomain}/user_name_check.htm',
	            dataType: 'json',
				data: 'userName=' + encodeURI(encodeURI($("#j_usernameZw").val())) +'&r=' + Math.random(),
				success: function(data){
					// 从Controller里取得对象数组
	            	var userObj = data.user;
	            	if(userObj != null){
		            	$("#j_username").val(userObj.loginId);
	            	} else {
	            		$("#j_username").val("");
	            	}
	            	$('form').submit();
	            },
	            error: function(){
	            	// 请求错误时,提示用户
	                $("#j_username").val("");
	            	$('form').submit();
	            }
	        });
		});
		// 回车事件
		$(document).keyup(function(event){
		  if(event.keyCode ==13){
		    $("#submitBtn").trigger("click");
		  }
		});
	});
	</script>
</head>
<body>
<object id="mTokenPlugin" type="application/x-mtokenplugin" width="0" height="0">
		<param value="pluginLoaded" />
</object>
<div class="calog">
<div id="login_main">
  <div class="login_nav">
    <div class="nav01"></div>
            <div id="rt">
            	<#if Session.SPRING_SECURITY_LAST_EXCEPTION?exists>
					<p class="login-error">
						用户名不存在或密码错误,请重新输入
					</p>
				</#if>
                <form method="POST" name="loginForm" action="${appDomain}/login" class="form_ct">
                    <ul class="login-form">
                        <li>
                            <label>用户名:
                            </label>
                            <input id="j_usernameZw" type="text" name="j_usernameZw" value=""/>
                            <input id="j_username" type="hidden" name="j_username" value=""/>
                        </li>
                        <li>
                            <label>密&nbsp;&nbsp;&nbsp;码:
                            </label>
                            <input id="j_password" class="key" type="password" name="j_password"/>
                        </li>
                        <li class="login-sub">
                        	<input type="button" id="submitBtn" class="sub" value="" />
                        	
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
    </div>
	</body>  
</html>  
