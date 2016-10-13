<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
       <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>文件-列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/demo.css" type="text/css" rel="stylesheet">
       	<link href="${cssDomain}/css/zTreeStyle/zTreeStyle.css"  type="text/css" rel="stylesheet">
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.core-3.1.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.excheck-3.1..js"></script>
	   <script type="text/javascript"  src="${jsDomain}/js/ztree/jquery.ztree.exedit-3.1.js"></script>
		<SCRIPT type="text/javascript">

		var setting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true,
				editNameSelectAll: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove,
				onRename: onRename
			}
		};
	
		var log, className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function beforeEditName(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return;
		}
		function beforeRemove(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除 " + treeNode.name + "文件夹吗？");
		}
		function onRemove(e, treeId, treeNode) {
			showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			$(document).ready(function(){
			 	$.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/resFile/delete_folder_system.htm',
		            dataType: 'json',
					data: 'id=' + treeNode.id +'&r=' + Math.random(),
					success: function(data){
						// 从Controller里取得对象数组
		            	var resFolderListObj = data.resFolderList;
		            	// 定义树形数组对象
		            	var zNodes = [resFolderListObj.length];
		            	// 循环取得对象里信息
		            	for (var i=0;i<resFolderListObj.length;i++) {
		            		// 设置树形结构数组
		            		var resFolder = resFolderListObj[i];
		            		zNodes[i] = {id:resFolder.id,pId:resFolder.unitId,name:resFolder.folderName, open:true};
	            			zNodes[i].iconSkin = "pIcon01";
		            	}
		            	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
						$("#selectAll").bind("click", selectAll);
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		                alert("取得部门默认值失败");
		            }
		        });
			});
		}
		function beforeRename(treeId, treeNode, newName) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			if (newName.length == 0) {
				alert("文件夹名称不能为空.");
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				setTimeout(function(){zTree.editName(treeNode)}, 10);
				return false;
			}
			return true;
		}
		function onRename(e, treeId, treeNode) {
			showLog("[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
		 	$.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '/resFile/uptate_folder_system.htm',
	            dataType: 'json',
				data: 'id=' + treeNode.id +'&folderName='+encodeURI(encodeURI(treeNode.name))+'&pId='+treeNode.pId+'&r=' + Math.random(),
				success: function(data){
					// 从Controller里取得对象数组
	            	var resFolderListObj = data.resFolderList;
	            	// 定义树形数组对象
	            	var zNodes = [resFolderListObj.length];
	            	// 循环取得对象里信息
	            	for (var i=0;i<resFolderListObj.length;i++) {
	            		// 设置树形结构数组
	            		var resFolder = resFolderListObj[i];
	            		zNodes[i] = {id:resFolder.id,pId:resFolder.unitId,name:resFolder.folderName, open:true};
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

		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<button type='button' class='add' id='addBtn_" + treeNode.id
				+ "' title='增加' onfocus='this.blur();'></button>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				// 选择提交审核人
                var url = "${appDomain}/common/choose_all_user.htm" + "?r=" + Math.random();
                var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                
                var value = window.showModalDialog(url, '', param);
               	if(value==undefined) {
	        		return false;
	     	    }
                if (value.length == 0) {
                    alert("未选择用户,请重新提交!是否现在选择用户?");
                    return false;
                }
                if(value[0].indexOf(",") > -1){
                	alert("用户只能选择一个!");
                    return false;
                }
				
				$.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/resFile/add_folder_system.htm',
		            dataType: 'json',
					data: 'folderName='+encodeURI(encodeURI(treeNode.name))+newCount+'++'+'&pId='+treeNode.id+'&loginId='+value[0]+'&r=' + Math.random(),
					success: function(data){
						// 从Controller里取得对象数组
		            	var resFolderListObj = data.resFolderList;
		            	// 定义树形数组对象
		            	var zNodes = [resFolderListObj.length];
		            	// 循环取得对象里信息
		            	for (var i=0;i<resFolderListObj.length;i++) {
		            		// 设置树形结构数组
		            		var resFolder = resFolderListObj[i];
		            		zNodes[i] = {id:resFolder.id,pId:resFolder.unitId,name:resFolder.folderName, open:true};
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
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:treeNode.name + (newCount++)});
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.id).unbind().remove();
		};
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
	</SCRIPT>
	<style type="text/css">
.ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
.ztree li button.down {margin-left:2px; margin-right: -1px; background-position:-126px -64px; vertical-align:top; *vertical-align:middle}
	</style>
</HEAD>

<BODY>
<div id="main">
    <div class="main_nav">
    <#include "user/menu.ftl">
    	<form id="listForm" name="listForm" action="${appDomain}/resFile/folder.htm" method="GET">
    	<input type="hidden" id="fileDir" name="fileDir" value=""/>
		<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value=""/>
		<input type="hidden" id="folderId" name="folderId" value=""/>
		<input type="hidden" id="deptId" name="deptId" value=""/>
		<div class="content_wrap">
			<div class="zTreeDemoBackground left">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
		</div>
	</div>
	</form>
</div>
</div>
<script type="text/javascript">
    var ctHeight = document.documentElement.clientHeight;
    $("#content").height(ctHeight + "px");
</script>
</BODY>
</HTML>