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
			
				$('form').submit();
			});
		});
		
	</script>
</head>
<body>
	<div class="sow">
			<form class="f0" action="${appDomain}/netFile/edit.htm"  method="POST">
			<input type="hidden" name="id" value="${netFile.id}"/>
				<table class="ftb">
					<tr>
						<th>标题:</th>
						<td><input class="text title0" type="text" name="title" maxlength="100" value="${netFile.title}" /></td>
					</tr>		
				    
					 <tr>
					 	<th>内容:</th>
						<td><textarea id="ct" class="woe" style="width:95%;height:200px;" name="content">${netFile.content}</textarea></td>
					 </tr>
					 <tr class="act">
						<td colspan="2">
							<input class="btn" name="draftBtn" type="button" id="saveBtn" value="提 交" />
						    <input class="btn" name="draftBtn" type="button" value="取 消" onclick="window.close();" />	 
						</td>
					 </tr>
				</table>
			
				
			
					
			</form>
	</div>
</body>
</html>
