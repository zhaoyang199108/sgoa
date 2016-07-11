<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/qytml1/DTD/qytml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/qytml" xml:lang="en" lang="zh-CN">
<head>
	<base target="_self">
	<title>企业条目详细信息</title>  
	<link href="${cssDomain}/css/main.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
    <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js"defer="defer"></script>
    <script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
		
			//初始化xhEditor编辑器插件
			$("#ct").xheditor({
			    html5Upload:false,
				tools:'full',
				skin:'default',
				upMultiple:false,
				upLinkUrl:"${appDomain}/admin/upload_image.htm?dir=qytm",
				upLinkExt:"doc,docx,xls,xlsx,txt,rar,zip,pdf",
				upImgUrl: "${appDomain}/admin/upload_image.htm?dir=qytm",
				upImgExt: "jpg,jpeg,gif,bmp,png"
			});
		});
	</script>
</head>
<body>
	<div id="main">
		<div id="content">
			<h3 class="title">企业条目详细信息</h3>
			<form action="${appDomain}/admin/qytm/edit.htm" method="POST">
				<input type="hidden" name="id" value="${qytm.id}" />
				<table class="tbls">
				   <tr>
				    <th >条目</th>
				    <td>
				    <input type="text" name="tmname" value="${qytm.tmname}" readonly="readonly"/></td>
				  </tr>
				    <tr>
				    <th>类型</th>
				    <td><select name="lx" class="sees" disabled="disabled">
                		    <option value="1" <#if 1 == qytm.lx>selected="selected"</#if>>文本</option>
                		    <option value="2" <#if 2 == qytm.lx>selected="selected"</#if>>单选</option>
                		    <option value="3" <#if 3 == qytm.lx>selected="selected"</#if>>连选</option>
                		    <option value="4" <#if 4 == qytm.lx>selected="selected"</#if>>多文本</option>
                		    <option value="5" <#if 5 == qytm.lx>selected="selected"</#if>>图片</option>
                         </select></td>
				  </tr>
				</table>			
				<input class="fm-btn" type="button" value="取 消" onclick="window.close();"/>
			</form>
		</div>
	</div>
</body>
</html>
