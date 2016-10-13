<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
       <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>文件-列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/folder_all.css" type="text/css" rel="stylesheet">
       	<link href="${cssDomain}/css/zTreeStyle/zTreeStyle.css"  type="text/css" rel="stylesheet">
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.core-3.1.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.excheck-3.1..js"></script>
	   <script type="text/javascript"  src="${jsDomain}/js/ztree/jquery.ztree.exedit-3.1.js"></script>
		<SCRIPT type="text/javascript">

		var setting = {
			view: {
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: zTreeOnClick
			}
		};
	
		var log, className = "dark";
		// 
		function zTreeOnClick(event, treeId, treeNode) {
			$("#folderId").val(treeNode.id);
		    // 取得人员信息
            $.ajax({
                type: 'GET',
                contentType: 'application/json',
                url: '/resFile/choose_folder_file.htm',
                dataType: 'json',
                data: 'folderId=' + treeNode.id + '&r=' + Math.random(),
                success: function(data){
                    // 设置部门用户列表,并设置选中部门背景色
                    appendFolderFileList(data);
                },
                error: function(){
                    alert("取得人员失败,请联系管理员1");
                }
            });
		}
		
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}

		function selectAll() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
		}
		
		$(document).ready(function(){
			// 根据所选部门ID,取得所选部门的默认值
	        $.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '/resFile/folder_all_list.htm',
	            dataType: 'json',
	            data: 'r=' + Math.random(),
	            success: function(data){
	            	// 从Controller里取得对象数组
	            	var resFolderListObj = data.resFolderList;
	            	// 定义树形数组对象
	            	var zNodes = [resFolderListObj.length];
	            	// 循环取得对象里信息
	            	for (var i=0;i<resFolderListObj.length;i++) {
	            		// 设置树形结构数组
	            		var resFolder = resFolderListObj[i];
	            		zNodes[i] = {id:resFolder.id,pId:resFolder.unitId,name:resFolder.folderName, open:false};
	            		zNodes[i].iconSkin = "pIcon01";
	            	}
	            	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
					$("#selectAll").bind("click", selectAll);
	            },
	            error: function(){
	            	// 请求错误时,提示用户
	                alert("取得默认值失败");
	            }
	        });
		});
		
		//下载事件
		function actDownLoad(obj){
			if ($("#isDown").val() == "0") {
				alert("您没有此权限下载此文件,请联系管理员！");
				return;
			}
			$("#srcFileNameOne").val(obj);
			$('form').attr("action","${appDomain}/resShareDown/download_file.htm");
			$('form').submit();
		}
		
		 // 更新按钮点击事件
	    function actUpdate(obj){
	       var url = "${appDomain}/resFile/dbdetail.htm?id=" + obj + "&r=" + Math.random();
		   var param = 'dialogWidth=760px;dialogHeight=500px;status=no;center=yes;scroll=no';
           var value = window.showModalDialog(url, '', param);
	    }
		
		/**
	     * 设置部门列表
	     */
	    function appendFolderFileList(data){
	        // 设置用户列表
	        $("#fileUl li").remove();
	        // 如果当前用户已经被选择,此单选框默认选中
	        $.each(data, function(i, resFile){
	        	var fileName = resFile.srcFileName;
	        	var fileSplit=fileName.split(".");
	            var newLi = "";
	            var fileSplitEnd = fileSplit[fileSplit.length-1];
	            if (fileSplitEnd == "doc" || fileSplitEnd == "docx") {
	            	newLi = newLi + "<li class=\"word\">";
	            } else if (fileSplitEnd == "xls" || fileSplitEnd == "xlsx") {
	            	newLi = newLi + "<li class=\"excel\">";
	            } else if (fileSplitEnd == "ppt" || fileSplitEnd == "pptx") {
	            	newLi = newLi + "<li class=\"ppoint\">";
	            } else if (fileSplitEnd == "txt") {
	            	newLi = newLi + "<li class=\"txt\">";
	            } else if (fileSplitEnd == "zip" || fileSplitEnd == "rar") {
	            	newLi = newLi + "<li class=\"rar\">";
	            } else {
	            	newLi = newLi + "<li class=\"blank\">";
	            }
	            newLi = newLi + "<span></span>";
	            newLi = newLi + "<p><a title=\""+resFile.srcFileName.substr(15)+"\" onclick=\"actDownLoad('" + resFile.srcFileName + "')\" href='#'>" + resFile.srcFileName.substr(15) + "</a></p>";
	            newLi = newLi + "</li>";
	            $(newLi).appendTo($("#fileUl"));
	        });
	    }
	</SCRIPT>
	<style type="text/css">
.ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
.ztree li button.down {margin-left:2px; margin-right: -1px; background-position:-126px -64px; vertical-align:top; *vertical-align:middle}
	</style>
</HEAD>

<BODY>
<div id="main">
    <div class="main_nav">
    <#include "resfile/menu.ftl">
    	<form id="listForm" name="listForm" action="${appDomain}/resFile/folder.htm" method="GET">
    	<input type="hidden" id="fileDir" name="fileDir" value=""/>
		<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value=""/>
		<input type="hidden" id="folderId" name="folderId" value=""/>
		<input type="hidden" id="isDown" value="1"/>
		<table style="width:80%;">
			<tr>
				<td>
					<div class="">
						<div class="zTreeDemoBackground">
							<ul id="treeDemo" class="ztree"></ul>
						</div>
						
					</div>
				</td>
				<td>
					<div class="user_list">
						<ul class="wjbut" id="fileUl">
						</ul>
			        </div>
				</td>
			</tr>
		</table>	
		
		</form>
	</div>
</div>
<script type="text/javascript">
    var ctHeight = document.documentElement.clientHeight;
    $("#content").height(ctHeight + "px");
</script>
</BODY>
</HTML>