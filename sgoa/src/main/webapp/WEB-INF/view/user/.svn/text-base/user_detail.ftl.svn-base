<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改用户</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>  
</head>
<body>
<div id="main">
	<div class="main_nav">
	<#include "user/menu.ftl">
	<div id="content"> 
			<h3 class="title"><font size="3"><strong>用户详细</strong></font></h3>
			<form class="f0" action="${appDomain}/user/user_detail.htm" method="POST">
				<input type="hidden" name="id"  value="${user.id}"/>
				<table class="ftb">
				<tr>
				    <th>登录ID:</th>
					<td>						
						<input class="text" type="text" name="loginId" value="${user.loginId}" readonly="readonly"/>
					</td>
					<th>用户密码:</th>
					<td>						
						<input class="text" type="password" name="password" value="${user.password}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
				    <th>姓名:</th>
					<td>						
						<input class="text" type="text" name="userName" value="${user.userName}" readonly="readonly"/>
					</td>
					<th>性别:</th>
					<td>						
                		<#if user.gender == 1><input class="text" type="text" value="男" readonly="readonly"/></#if>
	                    <#if user.gender == 0><input class="text" type="text" value="女" readonly="readonly"/></#if>
                                
					</td>
				</tr>
				<tr>
				    <th>部门:</th>
					<td>						
						<input class="text" type="text" id="deptName" name="deptName" value="${user.deptName}"/>
						<input class="text" type="hidden" id="deptId" name="deptId" value="${user.deptId}"/>		
					</td>
					<th>职务:</th>
					<td>
                    <input class="text" type="text" name="levelName" value="${user.levelName}" readonly="readonly"/>		
					</td>
				</tr>
				<tr>
				    <th>职责:</th>
					<td>						
						<input class="text" type="text" id="grpoName" name="grpoName" value="${user.grpoName}"/>
						<input class="text" type="hidden" id="positionId" name="positionId" value="${user.positionId}"/>	
					</td>
					<th>办公室电话:</th>
					<td>						
						<input class="text" type="text" name="officeTell" value="${user.officeTell}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<th>个人电话:</th>
					<td>
						<input class="text" type="text" name="phoneNo" value="${user.phoneNo}" readonly="readonly"/>
					</td>
					<th>家庭住址:</th>
					<td>						
						<input class="text" type="text" name="homeAddress" value="${user.homeAddress}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
				    <th>电子邮箱:</th>
					<td>
						<input class="text" type="text" name="email" value="${user.email}" readonly="readonly"/>
					</td>
					<th>紧急联系人:</th>
					<td>						
						<input class="text" type="text" name="urgentUserName" value="${user.urgentUserName}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
				    <th>紧急联系电话:</th>
					<td>						
						<input class="text" type="text" name="urgentUserTell" value="${user.urgentUserTell}" readonly="readonly"/>
					</td>
					<th>出生日期:</th>
					<td>
						<input class="text" type="text" name="birthday" value="${user.birthday}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
				    <th>身份证号:</th>
					<td>						
						<input class="text" type="text" name="idNumber" value="${user.idNumber}" readonly="readonly"/>
					</td>
					<th>卡号:</th>
					<td>						
						<input class="text" type="text" name="cardNo" value="${user.cardNo}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
				    <th>排序号:</th>
					<td>						
						<input class="text" type="text" name="sorting" value="${user.sorting}" readonly="readonly"/>
					</td>
					 <th>昵称:</th>
					<td>						
						<input class="text" type="text" name="ncName" value="${user.ncName}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
				    <th>备注信息:</th>
					<td colspan="3">						
						<textarea name="remark" rows="4" cols="59" readonly="readonly">${user.remark}</textarea>
					</td>
				</tr>
				
				</table>				
				</ul>
			</form>
	</div>
	</div>
	</div>
</body>
</html>
