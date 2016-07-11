<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>企业</title>  
    <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>  
</head>
<body>
	<div id="main">
		<div id="content">
			<h3 class="title">企业</h3>
			<form class="f0" action="${appDomain}/admin/user/user_detail.htm" method="POST">
			 		<table class="list-info">
                        <tr>
							<th>用户名</th>
							<th>名称</th>
							<th>行业</th>
							<th>区域</th>
							<th>入驻</th>
							<th>注册时间</th>	
							<th>状态</th>	
                        </tr>
                        <#list userList as user>
							<tr>
								<td>${user.loginId}</td>
								<td>${user.userName}</td>
								<td>${user.name}</td>
								<td>${user.s_province},${user.s_city},${user.s_county}</td>
								<td>${user.userNamep}</td>
								<td>${user.createDate?date}</td>	
								<td><#if user.status == 1>正常</#if>
									<#if user.status == 2>待审</#if>
									<#if user.status == 3>禁用</#if>
								</td>																											
							</tr>
						</#list>
                    </table>
			</form>
	</div>
	</div>
</body>
</html>
