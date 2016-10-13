<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>按钮名称添加页面</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript">
		$(document).ready( function() {		
			$("#saveBtn").click( function() {
			 // 签章名称非空校验
				if(!isEmpty($("input[name=btnName]"),"按钮名称不允许为空！")){
					return;
				}
				$('form').submit();
			});
		});
	</script>
</head>
<body>
	<div class="sow">
			<h3 class="title"><font size="3"><strong>新增按钮名称</strong></font></h3>
			<form class="f0" action="${appDomain}/buttonname/add_buttonname.htm" method="POST">
				<table class="ftb">
				<tr>
				    <th>职责:</th>
					<td>						
						<select name="positionId">
						  	<option value="">请选择</option>
						 	<#list grpoList as grpo>
								<option value="${grpo.id}">${grpo.grpoName}</option>
							</#list>
                         </select>
					</td>
				</tr>
				<tr>
					<th>模块:</th>
					<td>						
						<select name="module">
						  	<option value="">请选择</option>
						 	<option value="1">通知模块</option>
	                      	<option value="2">公告模块</option>
	                      	<option value="3">发文模块</option>
	                      	<option value="4">收文模块</option>
                         </select>
					</td>
				</tr>
				<tr>
				    <th>模块页面:</th>
					<td>						
						<select name="moduleType">
						  	<option value="">请选择</option>
						 	<option value="1">列表页面</option>
	                      	<option value="2">审核页面</option>
                         </select>
					</td>
				</tr>
				<tr>
					<th>按钮名称:</th>
					<td>						
						<input class="text" type="text" name="btnName" maxlength="10"/>
					</td>
				</tr>
			
				<tr class="act">
				   <td colspan="6">				
						<input type="button" id="saveBtn" class="btn" value="提 交"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>	
				   </td>
			    </tr>	
			</table>								
			</form>
	</div>
</body>
</html>
