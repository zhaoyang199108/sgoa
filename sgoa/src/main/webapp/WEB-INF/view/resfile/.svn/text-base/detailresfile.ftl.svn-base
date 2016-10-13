<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>共享页面</title>  
	<link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
    <script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
		 		//初始化xhEditor编辑器插件
			$("#ct").xheditor({
				tools:'full',
				skin:'default',
				upMultiple:false,
				upImgUrl: "${homeDomain}/upload_image.htm?dir=msg",
				upImgExt: "jpg,jpeg,gif,bmp,png"
			});
	      	//文件下载
			$(".act-down").click(function(){
				if ($("#isDown").val() == "0") {
					alert("您没有此权限下载此文件,请联系管理员！");
					return;
				}
				$("#srcFileNameOne").val($(this).attr("alt"));
				$('form').attr("action","${appDomain}/resShareDown/download_file.htm");
				$('form').submit();
			});	
	
		});
    </script>
</head>
<body>
	<div id="main">
	
		<div id="content">
		<h3 class="title"><font size="3"><strong>详细共享信息</strong></font></h3>
			<form class="f0" action="#" method="POST">
		     <input type="hidden" name="id" value="${resFile.id}" />
				<input type="hidden" id="isDown" value="1"/>
				<table class="ftb">
					<tr>
						<th>标题:</th>
						<td colspan="3"><input class="title title0"  type="text" name="title" value="${resFile.title}" maxlength="100" readonly="readonly"/></td>
					</tr>
					<tr>
						<th>附件名:</th>
						<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${resFile.srcFileName}"/>
						<td colspan="3"><a class="act-down" href="#" alt="${resFile.srcFileName}">${resFile.srcFileName}</a>
						</td>
					</tr>
					<tr>
						<th>内容:</th>
						<td colspan="3"><textarea id="ct" cols=39 class="woe" name="content" readonly="readonly">${resFile.content}</textarea></td>
					</tr>
				 	<tr class="act">
					 	<td colspan="4">
							
						<input class="btn" name="draftBtn" type="button" value="关闭" onclick="window.close();" />	 
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>