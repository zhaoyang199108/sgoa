<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>新增通知</title>  
    <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
		
			//初始化xhEditor编辑器插件
			$("#ct").xheditor({
			    html5Upload:false,
				tools:'full',
				skin:'default',
				upMultiple:false,
				upLinkUrl:"${appDomain}/admin/upload_image.htm?dir=notice",
				upLinkExt:"doc,docx,xls,xlsx,txt,rar,zip,pdf",
				upImgUrl: "${appDomain}/admin/upload_image.htm?dir=notice",
				upImgExt: "jpg,jpeg,gif,bmp,png",
				onUpload:insertUpload
			});
			//xbhEditor编辑器图片上传回调函数
			function insertUpload(msg) {
				var s = msg.toString();
				var _msg = s.substring(1,s.length).replace(/\\/g,'/');
				if(confirm("确定将此图片显示在主页定州景点栏目？")) {
					$("#pictureDir").val(_msg);
				}
			}
							
			$("#saveBtn").click( function() {
			    // 分类名称非空校验
				if(!isEmpty($("input[name=name]"),"分类名称不允许为空！")){
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
			<h3 class="title">新增通知</h3>
			<form class="f0" action="${appDomain}/admin/notice/add_notice.htm" method="POST">			
				<table class="tbls">
			  <tr>
			    <th >标题:</th>
			    <td><input class="text" type="text" name="title" maxlength="20"/>
				</td>
			  </tr>
			    <tr>
			    <th>行业:</th>
			     <td>
			     <select name="sortId" class="sees">			    
                	<#list sortdetailList as sortdetail>
						<option value="${sortdetail.id}">${sortdetail.name}</option>
					</#list>
                 </select>
				</td>
			  </tr>
			    <tr>
			    <th>对象:</th>
			     <td><select name="type" class="sees">
	    		    <option value="1">协会用户</option>
	    		    <option value="2">企业用户</option>
                </select>
				</td>
			  </tr>
			    <tr>
			    <th>内容:</th>
			     <td>
			     	<textarea id="ct" name="content" rows="25" style="width:100%; border: 1px"></textarea>
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
