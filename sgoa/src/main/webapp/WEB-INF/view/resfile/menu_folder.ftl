<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
       <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>文件-列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/menu_folder.css" type="text/css" rel="stylesheet">
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
				onRename: onRename,
				onClick: zTreeOnClick
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
			if(treeNode.getParentNode() == null){
				alert("不允许删除根目录!");
				return false;
			}
			showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			$(document).ready(function(){
			 	$.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/resFile/delete_folder.htm',
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
			$(document).ready(function(){
			 	$.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/resFile/uptate_folder.htm',
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
			});
		}
		
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

		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.id).length>0) return;
			var addStr = "<button type='button' class='add' id='addBtn_" + treeNode.id
				+ "' title='增加' onfocus='this.blur();'></button>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				$(document).ready(function(){
				 $.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/resFile/add_folder.htm',
		            dataType: 'json',
					data: 'folderName='+encodeURI(encodeURI(treeNode.name))+newCount+'++'+'&pId='+treeNode.id+'&r=' + Math.random(),
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
	            url: '/resFile/folder_list.htm',
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
			
			// 上传按钮点击事件
		    $("#addBtn").click(function(){
		    	if ($("#folderId").val() == "") {
		    		alert("请选择目录！");
		    		return;
		    	}
		        var url = "${appDomain}/resFile/add.htm?folderId=" + $("#folderId").val() + "&r=" + Math.random();
		        var param = 'dialogWidth=760px;dialogHeight=420px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            // 取得人员信息
		            $.ajax({
		                type: 'GET',
		                contentType: 'application/json',
		                url: '/resFile/choose_folder_file.htm',
		                dataType: 'json',
		                data: 'folderId=' + $("#folderId").val() + '&r=' + Math.random(),
		                success: function(data){
		                    // 设置部门用户列表,并设置选中部门背景色
		                    appendFolderFileList(data);
		                },
		                error: function(){
		                    alert("取得人员失败,请联系管理员1");
		                }
		            });
		        }
		    });
		});
		
		//下载事件
		function actDownLoad(obj){
			$("#srcFileNameOne").val(obj);
			$('form').attr("action","${appDomain}/resShareDown/download_file.htm");
			$('form').submit();
		}
		
		 // 更新按钮点击事件
	    function actUpdate(obj){
	        var url = "${appDomain}/resFile/edit.htm?id=" + obj +"&r=" + Math.random();
	        var param = 'dialogWidth=760px;dialogHeight=420px;status=no;center=yes;scroll=no';
	        var val = window.showModalDialog(url, '', param);
	           if (val == 'refresh') {
	            alert("操作成功");
	            $('form').submit();
	        }
	    }
	    
	    // 删除按钮点击事件
	    function actDel(){
	        var url = "${appDomain}/resFile/delete.htm?id=" + $(".act-del").attr("alt") +"&r=" + Math.random();
	        if (confirm("确定删除该文件？")) {
	            $.get(url, function(result){
	            if(result){
	                alert("操作成功");
	                $('form').submit();
	                }
	            else{
	             alert("不能删除文件，有人共享");
	            }    
	            });
	        }
	    }
		
		/**
	     * 设置部门列表
	     */
	    function appendFolderFileList(data){
	        // 设置用户列表
	        $("#userTable tr:not(:first)").remove();
	        // 如果当前用户已经被选择,此单选框默认选中
	        $.each(data, function(i, resFile){
	            var newTr = "<tr>";
	            newTr = newTr + "<td width='150' class=\"uname\">" + resFile.title + "</td>";
	            newTr = newTr + "<td width='300' class=\"uname\"><a onclick=actDownLoad('" + resFile.srcFileName + "') href='#'>" + resFile.srcFileName.substr(15) + "</a></td>";
	            newTr = newTr + "<td class=\"uname\"><a onclick='actDel();' class='act-btn act-del' href='#' alt=" + resFile.id + ">删除</a></td>";
	            newTr = newTr + "<td class=\"uname\"><a onclick=actUpdate('" + resFile.id + "'); class='act-btn act-update' href='#' alt=" + resFile.id + ">更新</a></td></tr>";
	            $(newTr).appendTo($("#userTable"));
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
		<table style="width:73%;">
			<tr>
				<td style="width:33%;">
					<div class="zTreeDemoBackground">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</td>
				<td style="width:45%;">
					<div class="btn-bk">
					<a id="addBtn" class="btn-add02" href="#">新增</a>
					</div>
					<div class="user_list">
					<table id="userTable" class="kow">
			            <tr id="userTr">
							<th width="30%">标题</th>
							<th width="40%">文件名称</th>
							<th colspan="2">操作</th>															
			            </tr>
			        </table>
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