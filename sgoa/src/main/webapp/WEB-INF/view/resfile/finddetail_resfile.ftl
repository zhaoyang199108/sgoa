<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>查看页面</title>  
	<link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
	<link href="${cssDomain}/css/base.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
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
			<form class="f0" action="${appDomain}/resFile/findDetail.htm" method="GET">
		     <input type="hidden" name="id" value="${resFile.id}" />
				<table class="ftb">
					<tr>
						<th>标题:</th>
						<td colspan="3"><input class="text title0" type="text" name="title" value="${resFile.title}" maxlength="100" readonly="readonly"/></td>
					</tr>
					<tr>
						<th>附件名:</th>
						<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${resFile.srcFileName}"/>
						<td colspan="3"><a class="act-down" href="#" alt="${resFile.srcFileName}">${resFile.srcFileName}</a>
						</td>
					</tr>
					<tr>
						<th>内容:</th>
						<td colspan="3"><textarea id="ct" cols=36 class="woe" name="content" readonly="readonly">${resFile.content}</textarea></td>
					</tr>
				    <tr>
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