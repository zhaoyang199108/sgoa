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
	<script type="text/javascript"  src="${jsDomain}/js/userkey/client/base64.js" ></script>
  	<script type="text/javascript"  src="${jsDomain}/js/userkey/client/mToken_K1.js" ></script>
  	<script type="text/javascript"  src="${jsDomain}/js/userkey/client/K1mTokenPlugin.js" ></script>
	<script type="text/javascript">
	$(document).ready( function() {
		//获取本Key的唯一硬件ID
		K1mTokenFindDevice();
		$.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: '${appDomain}/user_key_sel.htm',
            dataType: 'json',
			data: 'serverIaguid=' + $("#uid").val() +'&r=' + Math.random(),
			success: function(data){
				// 从Controller里取得对象数组
            	var userNameObj = data.userName;
            	if(userNameObj != null){
	            	$("#j_usernameZw").val(userNameObj);
            	} else {
            		$("#j_usernameZw").val("");
            	}
            },
            error: function(){
            	// 请求错误时,提示用户
                $("#j_username").val("");
            }
        });
		$("#submitBtn").click( function() {
			//打开加密锁
        	var userpin = $("#j_key").val();
        	if (userpin == "") {
				alert("安全码不能为空!");
				return false;
			}
			var keyUID = $("#uid").val();
			var nRet = K1mToken.K1_mTokenOpen(keyUID, userpin);
			if(nRet != 0)
			{
				alert("验证用户密码权限失败,错误码:" + K1mToken.K1_mTokenGetLastError());
				return false;
			}		
			//进行客户端摘要的计算
			var randomStr = $("#randomStr").val();
			var keyUID = $("#uid").val();
			var sha1Str = K1mToken.K1_mTokenSHA1WithSeed(keyUID, randomStr);
			if(sha1Str == null || sha1Str == "")
			{
				alert("SHA1摘要生成失败,错误码:" + K1mToken.K1_mTokenGetLastError());
				return;
			}
			$("#serverSeed").val(sha1Str);
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
                	<input type="hidden" id="_RndData" name="_RndData" value="${_RndData}"/>
                	<input type="hidden" id="randomStr" name="randomStr" value="${randomStr}"/>
                	<input type="hidden" id="uid" name="serverIaguid">
                	<input type="hidden" id="serverSeed" name="serverSeed">
                    <ul class="login-form">
                        <li>
                            <label>用户名:
                            </label>
                            <input id="j_usernameZw" type="text" name="j_usernameZw" value="" readonly="readonly"/>
                            <input id="j_username" type="hidden" name="j_username" value=""/>
                        </li>
                        <li>
                            <label>密&nbsp;&nbsp;&nbsp;码:
                            </label>
                            <input id="j_password" class="key" type="password" name="j_password"/>
                        </li>
                        <li>
                            <label>安全码:
                            </label>
                            <input id="j_key" class="key" type="password" name="j_key"/>
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
