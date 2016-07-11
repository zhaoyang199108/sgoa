<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>修改协会新闻</title>  
    <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>    
	<script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/upload/ajaxfileupload.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js"defer="defer"></script>
	<script type="text/javascript">
		$(document).ready( function() {	
		
			// 日期控件
			$("input[name=releaseDate]").click(function(){
				WdatePicker();
			});			
		
			//初始化xhEditor编辑器插件
				$("#ct").xheditor({
				    html5Upload:false,
					tools:'full',
					skin:'default',
					upMultiple:false,
					upLinkUrl:"${appDomain}/admin/upload_image.htm?dir=xhxw",
					upLinkExt:"doc,docx,xls,xlsx,txt,rar,zip,pdf",
					upImgUrl: "${appDomain}/admin/upload_image.htm?dir=xhxw",
					upImgExt: "jpg,jpeg,gif,bmp,png"
				});
							
			$("#saveBtn").click( function() {
			    // 协会活动名称非空校验
				if(!isEmpty($("input[name=name]"),"协会活动名称不允许为空！")){
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
			<h3 class="title">修改协会新闻</h3>
			<form class="f0" action="${appDomain}/admin/xhxw/edit_xhxw.htm" method="POST">
			<input type="hidden" name="id" value="${xhxw.id}" />
				<table class="tbls">
			  <tr>
			    <th >标题:</th>
			    <td><input class="text" type="text" name="title" maxlength="20" value="${xhxw.title}"/>
				</td>
			  </tr>
			    <tr>
			    <th>行业:</th>
			     <td>
			     <select name="sortId" class="sees">			    
                	<#list sortdetailList as sortdetail>
						<option value="${sortdetail.id}" <#if xhxw.sortId == sortdetail.id>selected="selected"</#if> >${sortdetail.name}</option>
					</#list>
                 </select>
				</td>
			  </tr>
			  <th>出处:</th>
			     <td><input class="text" type="text" name="cc" maxlength="20" value="${xhxw.cc}" />
				</td>
			  </tr>
			  <tr>
			    <th>时间:</th>
			     <td><input class="text" type="text" name="releaseDate" maxlength="20" value="${xhxw.releaseDate}" />
				</td>
			  </tr>				    
			    <tr>
			    <th>内容:</th>
			     <td>
			     	<textarea id="ct" name="content" rows="25" style="width:100%; border: 1px">${xhxw.content}</textarea>
				</td>
			  </tr>
			</table>
			<input type="button" id="saveBtn" class="fm-btn" value="提 交"/>
				<input type="button" value="取 消" class="fm-btn" onclick="window.close();"/>
		</form>
	</div>
	</div>
</body>
</html>