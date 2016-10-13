<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户KEY</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript"  src="${jsDomain}/js/userkey/mToken_K1Mgr.js" ></script>
  	<script type="text/javascript"  src="${jsDomain}/js/userkey/K1mTokenPluginMgr.js" ></script>
  	<script type="text/javascript"  src="${jsDomain}/js/userkey/base64.js" ></script>
  	<script type="text/javascript"  src="${jsDomain}/js/userkey/client/mToken_K1.js" ></script>
  	<script type="text/javascript"  src="${jsDomain}/js/userkey/client/K1mTokenPlugin.js" ></script>
	<script type="text/javascript">
		$(document).ready( function() {		
			$("#saveBtn").click( function() {
				K1MgrmTokenSetUserInfo();
		   		$('form').submit();
			});
		});
		
		//密钥随机数
		function mi(){
			document.getElementById("strPriKey").value = "${_3DES}";
		}
		//种子码随机数
		function zhongzi11(){
			document.getElementById("strSeed").value = "${_SHA1}";
		}
		//查找
		function  SeleFind (){
			K1mTokenMgrFindDevice();
		}
		
		//查找
		function getUserInfo(){
			alert();
			K1MgrmTokenGetUserInfo11();
		}
		
	</script>
</head>
<object id="mTokenPlugin" type="application/x-mtokenplugin" width="0" height="0">
	<param value="pluginLoaded" />
</object>
<body>
<div id="main">
	<div class="main_nav">
	<#include "user/menu.ftl">
	 <div id="content">     
			<h3 class="title"><font size="3"><strong>用户KEY</strong></font></h3>
			<form class="f0" action="${appDomain}/userkey/add_user_key.htm" method="POST">
			<input type="hidden" id="loginId" name="loginId" value="${loginId}"/>
				<table class="ftb">
				<tr>
				    <th>硬件ID:</th>
					<td>						
						<input class="text" id="hID" type="text" name="serverIaguid"/>
					</td>
					<th>超级密码:</th>
					<td>						
						<input class="text" type="text" name="strSuperPin" id="strSuperPin"/>
						<input type="button" value="登陆"  onClick="return K1mTokenMgrOpen()"/>
					</td>
				</tr>
				<tr>
				    <th>新超级密码:</th>
					<td>						
						<input class="text" type="text" name="strNewSuperPin" id="strNewSuperPin"/>
						<input type = "button" value = "修改" onClick = "K1mTokenMgrChangePwd();">
					</td>
					<th>用户密码:</th>
					<td>						
						<input type="text" name="strUserPin" id="strUserPin" style="width:350px" value="12345678">
					</td>
				</tr>
				<tr>
				    <th>种子码:</th>
					<td>		
						<input type="text" name="serverSeed" id="strSeed" style="width:350px" value="">
                        <input type="button" name="zhongzi" value="随机" onClick="zhongzi11();">
                        <input type="button" name="Submit2" value="设置" onClick="K1MgrmTokenSetSeedKey();">
					</td>
					<th>3DES密钥:</th>
					<td>
                    <input type="text" name="tridesKey" id="strPriKey" style="width:350px" value="">
                      	<input type="button" name="miyao" value="随机" onClick="mi();">
                        <input type="button" name="Submit22" value="设置" onClick="K1MgrmTokenSetMainKey();">	
					</td>
				</tr>
				<tr>
				    <th>USB Key别名:</th>
					<td>
					<input type="text" name="strKeyName" id="strKeyName" style="width:350px">		
					</td>				
					<th>公司名称:</th>
					<td>						
						<input type="text" name="strDescripion" id="strDescripion" style="width:350px">
					</td>
				</tr>
				<tr>
					<th>公司网址:</th>
					<td>
						<input type="text" name="strUrl" id="strUrl" style="width:350px" value="www.longmai.com.cn">
					</td>
					<th>备注信息:</th>
					<td>						
						<input type="text" name="strOther" id="strOther" style="width:350px">
					</td>
				</tr>
				<tr>
				    <th>选择浏览器:</th>
					<td>
						<input name="radiobutton" id="openType1" type="radio" value="0" checked>
                        使用默认浏览器进入网站&nbsp;
                        <input name="radiobutton" id="openType2" type="radio" value="1">
                        指定使用IE浏览器进入网站
					</td>
					<th>远程注册:</th>
					<td>						
						<input name="nEnableRemote" type="radio" value="1">
                        开启&nbsp;
                        <input name="nEnableRemote" type="radio" value="0" checked>
                        关闭
					</td>
				</tr>
				<tr class="act">
				   <td colspan="4">				
						<input type="button" name="button" value="查找USB Key" style="width:100px" onClick="SeleFind();">
						<input type="button" name="button" value="取得设备信息" style="width:100px" onClick="getUserInfo();">
						<input type="button" id="saveBtn" class="btn" value="提 交"/>
						<input type="reset" value="重 置" class="btn" />	
				   </td>
			    </tr>	
				</table>								
			</form>
	</div>
		</div>
			</div>
</body>
</html>
