<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
       <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>部门-列表</title>
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
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}
		function onRemove(e, treeId, treeNode) {
			showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			$(document).ready(function(){
			 	$.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/dept/delete.htm',
		            dataType: 'json',
					data: 'id=' + treeNode.id +'&r=' + Math.random(),
					success: function(data){
						// 从Controller里取得对象数组
		            	var deptListObj = data.deptList;
		            	// 定义树形数组对象
		            	var zNodes = [deptListObj.length];
		            	// 循环取得对象里信息
		            	for (var i=0;i<deptListObj.length;i++) {
		            		// 设置树形结构数组
		            		var dept = deptListObj[i];
		            		zNodes[i] = {id:dept.id,pId:dept.unitId,name:dept.deptName, open:true};
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
				alert("节点名称不能为空.");
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
		            url: '/dept/dept_uptate.htm',
		            dataType: 'json',
					data: 'id=' + treeNode.id +'&deptName='+encodeURI(encodeURI(treeNode.name))+'&pId='+treeNode.pId+'&r=' + Math.random(),
					success: function(data){
						// 从Controller里取得对象数组
		            	var deptListObj = data.deptList;
		            	// 定义树形数组对象
		            	var zNodes = [deptListObj.length];
		            	// 循环取得对象里信息
		            	for (var i=0;i<deptListObj.length;i++) {
		            		// 设置树形结构数组
		            		var dept = deptListObj[i];
		            		zNodes[i] = {id:dept.id,pId:dept.unitId,name:dept.deptName, open:true};
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
		    // 取得人员信息
            $.ajax({
                type: 'GET',
                contentType: 'application/json',
                url: '/common/choose_dept_user.htm',
                dataType: 'json',
                data: 'deptId=' + treeNode.id + '&r=' + Math.random(),
                success: function(data){
                    // 设置部门用户列表,并设置选中部门背景色
                    appendDeptUserList(data);
                },
                error: function(){
                    alert("取得人员失败,请联系管理员");
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
				+ "' title='add node' onfocus='this.blur();'></button>";
			sObj.append(addStr);
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", function(){
				$(document).ready(function(){
			 $.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '/dept/add_dept.htm',
	            dataType: 'json',
				data: 'deptName='+encodeURI(encodeURI(treeNode.name))+newCount+'++'+'&pId='+treeNode.id+'&r=' + Math.random(),
				success: function(data){
					// 从Controller里取得对象数组
	            	var deptListObj = data.deptList;
	            	// 定义树形数组对象
	            	var zNodes = [deptListObj.length];
	            	// 循环取得对象里信息
	            	for (var i=0;i<deptListObj.length;i++) {
	            		// 设置树形结构数组
	            		var dept = deptListObj[i];
	            		zNodes[i] = {id:dept.id,pId:dept.unitId,name:dept.deptName, open:true};
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
	            url: '/dept/dept_list.htm',
	            dataType: 'json',
	            data: 'r=' + Math.random(),
	            success: function(data){
	            	// 从Controller里取得对象数组
	            	var deptListObj = data.deptList;
	            	// 定义树形数组对象
	            	var zNodes = [deptListObj.length];
	            	// 循环取得对象里信息
	            	for (var i=0;i<deptListObj.length;i++) {
	            		// 设置树形结构数组
	            		var dept = deptListObj[i];
	            		zNodes[i] = {id:dept.id,pId:dept.unitId,name:dept.deptName, open:false};
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
		
		/**
	     * 设置部门列表
	     */
	    function appendDeptUserList(data){
	        // 设置用户列表
	        $("#userTable tr:not(:first)").remove();
	        // 如果当前用户已经被选择,此单选框默认选中
	        $.each(data, function(i, user){
	            var newTr = "<tr>";
	            newTr = newTr + "<td class=\"uname\">" + user.loginId + "</td>";
	            newTr = newTr + "<td class=\"uname\">" + user.userName + "</td>";
	            newTr = newTr + "<td class=\"uname\">" + user.deptName + "</td></tr>";
	            $(newTr).appendTo($("#userTable"));
	        });
	    }

	</SCRIPT>
	<style type="text/css">
.ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
	</style>
</HEAD>

<BODY>
<div id="main">
    <div class="main_nav">
    <#include "user/menu.ftl">
		<div class="content_wrap">
			<div class="zTreeDemoBackground left">
				<ul id="treeDemo" class="ztree" style="margin-left:15px;"></ul>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
    var ctHeight = document.documentElement.clientHeight;
    $("#content").height(ctHeight + "px");
</script>
</BODY>
</HTML>