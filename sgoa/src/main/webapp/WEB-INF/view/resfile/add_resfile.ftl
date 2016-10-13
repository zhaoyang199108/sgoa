<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>上传</title>  
	<link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
		
		 //初始化xhEditor编辑器插件
			$("#ct").xheditor({
				tools:'full',
				skin:'default',
				upMultiple:false,
				upImgUrl: "${homeDomain}/upload_image.htm?dir=msg",
				upImgExt: "jpg,jpeg,gif,bmp,png"
			});
			
		  $("#saveBtn").click( function() {
		  
		 
		
		        // 标题非空校验
				if(!isEmpty($("input[name=title]"),"标题不允许为空！")){
					return;
				}				
				
		        // 附件非空校验
				if(!isEmpty($("input[name=srcUploadFile]"),"附件不允许为空！")){
					return;
				}				
				$('form').submit();
			});
		});
		
	</script>
</head>
<body>
	<div class="sow">
		<h3 class="title"><font size="3"><strong>新增共享</strong></font></h3>
		<form class="f0" action="${appDomain}/resFile/upload_file.htm" enctype="multipart/form-data" method="POST">
			<input type="hidden" id="folderId" name="folderId" value="${folderId}"/>
			<table class="ftb">
				<tr>
					<th>标题:</th>
					<td colspan="3"><input class="text title0" type="text" name="title" maxlength="100"/></td>
				</tr>		
			     <tr>
			     	<th>附件:</th>
					<td colspan="3"><input type="file" class="title title0" name="srcUploadFile" id="srcUploadFile"></td>
				 </tr>
				 <tr>
				 	<th>内容:</th>
					<td colspan="3"><textarea id="ct" rows="10" cols="60" name="content"></textarea></td>
				 </tr>
				 <tr class="act">
					<td colspan="4">
						<input class="btn" name="draftBtn" type="button" id="saveBtn" value="提 交" />
					    <input class="btn" name="draftBtn" type="button" value="取 消" onclick="window.close();" />	 
					</td>
				 </tr>
			</table>
		</form>
	</div>
</body>
</html>
