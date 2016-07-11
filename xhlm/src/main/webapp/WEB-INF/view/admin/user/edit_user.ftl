<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>审核会员</title>  
    <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/upload/ajaxfileupload.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
			$("#updateBtn").click( function() {
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
							$('#imgPhoto').attr("src",data.fileDir);
							$('#photo').val(data.fileDir);
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
			<h3 class="title">审核会员</h3>
			<form class="f0" action="${appDomain}/admin/user/edit_user.htm" method="POST" enctype="multipart/form-data">
				<input type="hidden" name="id"  value="${user.id}"/>
				<ul class="form-1c">
				<li>
						<label>用户名:</label>
						<input class="text" type="text" name="loginId" value="${user.loginId}" readonly="readonly"/>
				</li>
				<li>
						<label>名称:</label>
						<input class="text" type="text" name="userName" value="${user.userName}" readonly="readonly"/>
				</li>
				 <li>
						<label>行业:</label>
						<select name="sortId" class="sees" disabled="disabled">
					        <#list sortdetailList as sortdetail>
                		    	<option value="${sortdetail.id}" <#if sortdetail.id == user.sortId>selected="selected"</#if>>${sortdetail.name}</option>
                       		</#list>
                         </select>
				</li>
				<li>
						<label>区域:</label>
						${user.s_province},${user.s_city},${user.s_county}
				</li>
				<li>
						<label>经度:</label>
						<input class="text" type="text" name="jd" value="${user.jd}" readonly="readonly"/>
				</li>
				<li>
						<label>纬度:</label>
						<input class="text" type="text" name="wd" value="${user.wd}" readonly="readonly"/>
				</li>
				<li>
						<label>地址:</label>
						<input class="text" type="text" name="address" value="${user.address}" readonly="readonly"/>
				</li>
				<li>
						<label>介绍:</label>
						<textarea name="introduce" rows="2" cols="40" maxlength="400" readonly>${user.introduce}</textarea>
				</li>
				<li>
						<label>logo:</label>
						<img src="${user.logo}" width="88" height="84" id="imgPhoto" />
				</li>
				<li>
						<label>banner:</label>
						<img src="${user.banner}" width="88" height="84" id="imgPhoto" />
				</li>
				<li>
						<label>资质:</label>
						<#list userzztList as userzzt>
						<img src="${userzzt.aptitude}" width="88" height="84" id="imgPhoto" />
						</#list>
				</li>
				<#if user.type == 1>
				 <li>
						<label>产品:</label>
						<select name="productId" class="sees" disabled="disabled">
					        <#list psortdetailList as sortdetail>
                		    	<option value="${sortdetail.id}" <#if sortdetail.id == user.productId>selected="selected"</#if>>${sortdetail.name}</option>
                       		</#list>
                         </select>
				</li>
				</#if>
				<#if user.type == 2>
				<li>
						<label>产品:</label>
						<input class="text" type="text" name="product" value="${user.product}" readonly="readonly"/>
				</li>
				</#if>
				
				<#list userdetailList as userdetail>
				<#if userdetail.type == 1>
				<li>
						<label>${userdetail.tmname}:</label>
						<input class="text" type="text" value="${userdetail.content}" readonly="readonly"/>
				</li>
				</#if>
				<#if userdetail.type == 2>
				<li>
						<label>${userdetail.tmnameq}:</label>
						<input class="text" type="text" value="${userdetail.content}" readonly="readonly"/>
				</li>
				</#if>
				</#list>
				<li class="action">
						<input type="button" id="updateBtn" class="btn" value="审 核"/>
						<input type="button" id="updateBtn" class="btn" value="拒 绝"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>
				</li>
			</ul>	
		</form>
	</div>
	</div>
</body>
</html>
