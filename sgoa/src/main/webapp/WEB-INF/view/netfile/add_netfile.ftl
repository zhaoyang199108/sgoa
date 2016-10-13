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
	<script type="text/javascript" src="${jsDomain}/js/upload/ajaxfileupload.js"></script>
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
		// 文件上传控件
		function ajaxFileUpload() {
			$("#loading").ajaxStart(function(){
				$(this).show();
			})//开始上传文件时显示一个图片
			.ajaxComplete(function(){
				$(this).hide();
			});//文件上传完成将图片隐藏起来
			$.ajaxFileUpload
			(
				{
					url:'${appDomain}/common/file_upload.htm',//用于文件上传的服务器端请求地址
					secureuri:false,//一般设置为false
					fileElementId:'srcUploadFile',//文件上传空间的id属性  <input type="file" id="file" name="file" />
					dataType: 'json',//返回值类型 一般设置为json
					success: function (data, status)  //服务器成功响应处理函数
					{
						if (data.fileDir != "undefined" && data.fileDir != undefined){
							var htmlUrl = "<span id=\"div"+ data.fileDir +"\">";
							htmlUrl = htmlUrl + data.message;
							htmlUrl = htmlUrl + "<input type=\"hidden\" name=\"srcFileName\" value=\"" + data.fileDir + "\" />";
							htmlUrl = htmlUrl + "<input type=\"hidden\" name=\"fileDir\" value=\"" + data.message + "\" />";
							htmlUrl = htmlUrl + "<a href=\"#\" class=\"cancel\" onclick=\"removeOldFile(event,'" + data.fileDir + "')\"></a>";
							htmlUrl = htmlUrl + "</span>";
							$('#fileDirDiv').html(htmlUrl);
						}
					},
					error: function (data, status, e)//服务器响应失败处理函数
					{
						alert(e);
					}
				}
			)
			return false;
		}
		
		function removeOldFile(evt, id){
		
			$.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '/common/file_delete.htm',
	            dataType: 'json',
	            data: 'fileNameDel=' + encodeURI(id) + '&r=' + Math.random(),
	            success: function(data){
	            },
	            error: function(){
		            // 失败
		            return false;
	            }
	        });
	        // 成功
         	var el = evt.target == null ? evt.srcElement : evt.target;
		    var div = el.parentNode;
		    var cont = document.getElementById('fileDirDiv');    
		    if(cont.removeChild(div) == null){
		        return false;
		    }
		    return true;
		}
		
	</script>
</head>
<body>
	<div class="sow">
			<form class="f0" action="${appDomain}/netFile/upload_file.htm" enctype="multipart/form-data" method="POST">
			<input type="hidden" id="folderId" name="folderId" value="${folderId}"/>
				<table class="ftb">
					<tr>
						<th>标题:</th>
						<td><input class="text title0" type="text" name="title" maxlength="100"/></td>
					</tr>		
				     <tr>
				     	<th rowspan="2">附件:</th>
						<td>
						<input type="file" class=" " name="srcUploadFile" id="srcUploadFile">
                    	<input type="button" id="uploadBtn" class="btn" onclick="return ajaxFileUpload();" value="上传"/>
                    	<img src="${jsDomain}/js/upload/loading.gif" id="loading" style="display: none;">
						</td>
					  </tr>
  					  <tr>
						<td>
	                    	<div id="fileDirDiv" style="height:30px;border: 2px solid green;overflow-y:scroll;overflow-x:hidden;"></div>
	                    </td>
					  </tr>	
					 <tr>
					 	<th>内容:</th>
						<td><textarea id="ct" class="woe" style="width:95%;height:200px;" name="content"></textarea></td>
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
	</div>
</body>
</html>
