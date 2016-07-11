<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>修改平台活动</title>  
    <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/upload/ajaxfileupload.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {				
		
			//初始化xhEditor编辑器插件
				$("#ct").xheditor({
				    html5Upload:false,
					tools:'full',
					skin:'default',
					upMultiple:false,
					upLinkUrl:"${appDomain}/admin/upload_image.htm?dir=pthd",
					upLinkExt:"doc,docx,xls,xlsx,txt,rar,zip,pdf",
					upImgUrl: "${appDomain}/admin/upload_image.htm?dir=pthd",
					upImgExt: "jpg,jpeg,gif,bmp,png"
				});
					
			$("#saveBtn").click( function() {
			    // 平台活动名称非空校验
				if(!isEmpty($("input[name=name]"),"平台活动名称不允许为空！")){
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
						url:'${appDomain}/admin/common/image_upload.htm',//用于文件上传的服务器端请求地址
						secureuri:false,//一般设置为false
						fileElementId:'srcUploadFile',//文件上传空间的id属性  <input type="file" id="file" name="file" />
						dataType: 'json',//返回值类型 一般设置为json
						success: function (data, status)  //服务器成功响应处理函数
						{
							if (data.fileDir != "undefined" && data.fileDir != undefined){
								$('#imgZp').attr("src",data.fileDir);
								$('#zp').val(data.fileDir);
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
	</script>
</head>
<body>
	<div id="main">
		<div id="content">
			<h3 class="title">修改平台活动</h3>
			<form class="f0" action="${appDomain}/admin/pthd/edit_pthd.htm" method="POST">
			<input type="hidden" name="id" value="${pthd.id}" />
				<table class="tbls">
			  <tr>
			    <th >标题:</th>
			    <td><input class="text" type="text" name="title" maxlength="20" value="${pthd.title}"/>
				</td>
			  </tr>
			    <tr>
			    <th>行业:</th>
			     <td>
			     <select name="sortId" class="sees">			    
                	<#list sortdetailList as sortdetail>
						<option value="${sortdetail.id}" <#if pthd.sortId == sortdetail.id>selected="selected"</#if> >${sortdetail.name}</option>
					</#list>
                 </select>
				</td>
			  </tr>
			     <tr>
			    <th>周期:</th>
			     <td><input class="text" type="text" name="zq" maxlength="20" value="${pthd.zq}" />
				</td>
			  </tr>
			  <tr>
			    <th>要求:</th>
			     <td><input class="text" type="text" name="yq" maxlength="20" value="${pthd.yq}" />
				</td>
			  </tr>
			  <tr>
			    <th>招牌:</th>
			     <td>
					<img src="" id="imgZp" width="100px" height="125px" value="${pthd.zp}" /><br />
					<input width="60" type="hidden" id="zp" name="zp" value="${pthd.zp}">
			        <input type="file" title="选择照片上传"  size="40" name="srcUploadFile" id="srcUploadFile">
			        <input type="button" id="uploadBtn" onclick="return ajaxFileUpload();" value="上传" style="width:60px;height:23px; background:#E1E1E1; border:#ADADAD;"/>
					<img src="${jsDomain}/js/upload/loading.gif" id="loading" style="display: none;"></td>
				</tr>
			  </tr>
			    <tr>
			    <th>内容:</th>
			     <td>
			     	<textarea id="ct" name="content" rows="25" style="width:100%; border: 1px">${pthd.content}</textarea>
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