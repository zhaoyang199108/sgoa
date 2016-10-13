 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>共享页面</title>  
	<link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
	<link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
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
	         // 保存按钮点击事件
	         $("#saveBtn").click( function() {
	         
				if(!areEmpty($("input[name=receiver1Name]"),$("input[name=receiver2Name]"),"请选择共享人！")){
					return;
				}				
				$('form').submit();
			 }); 
	
			// 浏览按钮点击事件
		    $(".act-share1").click(function(){
                var url = "${appDomain}/common/choose_all_user.htm"+"?ids=" + $("#receiverIds1").val() + "&r=" + Math.random();
                var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                var value = window.showModalDialog(url, '', param);
                if(value==undefined)
			        	{
			        		  return false;
			     	    }
                if (value != null && value.length > 0) {
                    $("#receiver1").val(value[1]);
                    $("#receiverIds1").val(value[0]);
                }
            });
            
            function areEmpty(chObj,ch2Obj,chMsg){
            if (chObj.val() == ""&&ch2Obj.val() == "") {
           	alert(chMsg);
	         chObj.focus();
	       chObj.css('borderColor','red');
             return false; 
                }
              chObj.css('borderColor','');
            return true;
              }
			
			// 下载按钮点击事件
             $(".act-share2").click(function(){
                var url = "${appDomain}/common/choose_all_user.htm"+"?ids=" + $("#receiverIds2").val() + "&r=" + Math.random();
                var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                var value = window.showModalDialog(url, '', param);
                if(value==undefined)
			        	{
			        		  return false;
			     	    }
                if (value != null && value.length > 0) {
                    $("#receiver2").val(value[1]);
                    $("#receiverIds2").val(value[0]);
                }
            });
	
		});
    </script>
</head>
<body>
	<div id="main">
	<div class="main_nav">
	 <#include "netfile/menu.ftl">
		<div id="content">
			<form class="f0" action="${appDomain}/netFile/detail.htm" method="POST">
		     <input type="hidden" name="id" value="${netFile.id}" />
		     <div class="ct">
				<table class="ftb">
					<tr>
						<th>标题:</th>
						<td><input class="title title0" type="text" name="title" value="${netFile.title}" maxlength="100" readonly="true"/></td>
					</tr>
					<tr>
						<th>附件名:</th>
						<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${netFile.srcFileName}"/>
						<td><a class="act-down" href="#" alt="${netFile.srcFileName}">${netFile.srcFileName}</a>
						</td>
					</tr>
					<tr>
						<th>内容:</th>
						<td><textarea  id="ct" class="woe"  style="width:95%;height:200px;" name="content">${netFile.content}</textarea></td>
					</tr>
	                <tr>
	                    <th>
				共享人(下载):
		            	</th>
		          		<td>
	                        <input class="title title0" type="text title" id="receiver2" name="receiver2Name" value="${downName}" readonly="readonly" />
	                        <input type="hidden" id="receiverIds2" name="isDownId" value="${downId}" />
	                        <input class="btn act-share2" id="act-share2" type="button" value="选择" />
	                    </td>
				 	</tr>
				 	<tr class="act">
					 	<td colspan="2">
							<input class="btn" name="draftBtn" type="button" id="saveBtn" value="提 交" />
							<a href="${appDomain}/netFile/list.htm" target="mainFrame"><input class="btn" name="draftBtn" type="button" value="关闭" />	</a> 
						</td>
					</tr>
				</table>
				</div>
			</form>
	</div>
	</div>
	</div>
</body>
</html>