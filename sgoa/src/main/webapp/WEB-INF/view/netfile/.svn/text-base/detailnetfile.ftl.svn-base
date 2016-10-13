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
				$("#srcFileNameOne").val($(this).attr("alt"));
				$('form').attr("action","${appDomain}/resShareDown/download_file.htm");
				$('form').submit();
			});	
	
		});
    </script>
</head>
<body>
	<div class="sow">
			<form class="f0" action="#" method="POST">
		     <input type="hidden" name="id" value="${netFile.id}" />
				<table class="ftb">
					<tr>
						<th>标题:</th>
						<td><input class="title title0"  type="text" name="title" value="${netFile.title}" maxlength="100" readonly="readonly"/></td>
					</tr>
					<tr>
						<th>附件名:</th>
						<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${netFile.srcFileName}"/>
						<td><a class="act-down" href="#" alt="${netFile.srcFileName}">${netFile.srcFileName}</a>
						</td>
					</tr>
					<tr>
						<th>内容:</th>
						<td><textarea id="ct" class="woe"  style="width:95%;height:200px;" name="content" readonly="readonly">${netFile.content}</textarea></td>
					</tr>
	                <tr>
	                    <th>
				共享人(下载):
		            	</th>
		          		<td>
	                        <input class="title title0"  type="text title" id="receiver2" name="receiverName" value="${downName}" readonly="readonly" />
	                       
	                    </td>
				 	</tr>
				 	<tr class="act">
					 	<td colspan="2">
						<input class="btn" name="draftBtn" type="button" value="关闭" onclick="window.close();" />	 
						</td>
					</tr>
				</table>
			</form>
	</div>
</body>
</html>