<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>用户权限</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link href="${cssDomain}/css/demo_dept.css" type="text/css" rel="stylesheet">
	<link href="${cssDomain}/css/zTreeStyle/zTreeStyle.css"  type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.core-3.1.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.excheck-3.1.js"></script>
    <script type="text/javascript"  src="${jsDomain}/js/ztree/jquery.ztree.exedit-3.1.js"></script>	
	<script type="text/javascript">
		// 部门树形菜单设置
		var setting = {
			check: {
				enable: true,
				chkStyle: "radio",
				radioType: "all"
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onCheck: zTreeOnClick
			}
		};
		var log, className = "dark";
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
		// 部门信息全选
		function selectAll() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
		}
		// 部门信息节点单击事件
		function zTreeOnClick(event, treeId, treeNode){
			$("#deptId").val(treeNode.id);
			$("#deptName").val(treeNode.name);
		}
		
		// 角色信息树形菜单设置
		var settingrole = {
			check: {
				enable: true,
				chkStyle: "checkbox",
				chkboxType: {"Y":"ps","N":"ps"},
				autoCheckTrigger: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onCheck: zTreeOnCheck
			}
		};
		
		// 角色信息选择方法
		function zTreeOnCheck(event, treeId, treeNode) {
		    if (treeNode.checked) {
		    	if (isExistInList(treeNode.id)) {
		            return;
		        }
		        var li = "<input id=\"role_" + treeNode.id + "\" value='" + treeNode.id + "' name='roleIdArray' type='hidden'>";
		        
		        var selectUl = $("#role_list");
		        $(li).appendTo(selectUl);
		    } else {
		    	removeSelectRole(treeNode.id);
		    }
		}
		
		/**
	     * 判断当前角色是否已经被选择
	     */
	    function isExistInList(nodeId){
	        var isExist = false;
	        $("input[name='roleIdArray']").each(function(){
                var idTemp = $(this).attr("id");
                var idHiden = "role_" + nodeId;
	            if (idHiden == idTemp) {
	                isExist = true;
	                return;
	            }
            });
	        return isExist;
	    }
		
		// 删除某一被选中的用户
	    function removeSelectRole(roleId){
	        $('#role_' + roleId).remove();
	    }
	    
	    // 删除某一被选中的用户
	    function isRoleChecked(roleId,userRoleObj){
	        var result = false;
	        for (var i=0;i<userRoleObj.length;i++) {
        		// 设置树形结构数组
        		var role = userRoleObj[i];
        		if (roleId == role.roleId) {
        			result = true;
        			return result;
        		}
	        }
	        return result;
	    }
		
		$(document).ready( function() {
			$("#saveBtn").click( function() {
				 var newTb = document.getElementById("table_role_select");
	        	 if($("input[name='roleIdArray']").length == 0){
	        	 	alert("请添加权限后再保存！");
	        	 	return;
	        	 }
				$('form').submit();
			});
			
	        // 取得权限信息
	        $.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '${appDomain}/admin/user/find_user_role.htm',
	            dataType: 'json',
	            data: 'loginId=' + $("#loginId").val() + '&r=' + Math.random(),
	            success: function(data){
	            	// 从Controller里取得对象数组
	            	var deptListObj = data.roleList;
	            	var userRoleObj = data.userRoleList;
	            	// 定义树形数组对象
	            	var zNodes = [deptListObj.length];
	            	// 循环取得对象里信息
	            	for (var i=0;i<deptListObj.length;i++) {
	            		// 设置树形结构数组
	            		var role = deptListObj[i];
	            		// 判断是否为选中
	            		var isChecked = isRoleChecked(role.id,userRoleObj);
            			if (isChecked){
            				zNodes[i] = {id:role.id,pId:role.pId,name:role.roleName, open:true,checked:true};
            				var li = "<input id=\"role_" + role.id + "\" value='" + role.id + "' name='roleIdArray' type='hidden'>";
					        var selectUl = $("#role_list");
					        $(li).appendTo(selectUl);
            			}else{
            				zNodes[i] = {id:role.id,pId:role.pId,name:role.roleName, open:true};
            			}
	            	}
	            	$.fn.zTree.init($("#treeDemoRole"), settingrole, zNodes);
	            	$("#selectAll").bind("click", selectAll);
	            },
	            error: function(){
	            	// 请求错误时,提示用户
	                alert("取得权限信息失败！");
	            }
	        });
		});
	</script>
</head>
<body>
<div id="main">
	<div id="content">
	<h3 class="title">用户权限</h3>
		<form class="f0" name="roleForm" action="${appDomain}/admin/user/add_user_role.htm" method="POST">
			<input type="hidden" id="deptId" name="deptId" value="${deptIdForMap}" />
			<input type="hidden" id="deptName" name="deptName" value="" />
			<table class="ftb">
				<tr>
					<th>用户:</th>
					<td colspan="3">
						<input type="hidden" id="loginId" name="loginId"  value="${user.loginId}"/>
						<input class="text" type="text" name="userName" value="${user.userName}"/>
					</td>
				</tr>
				<tr>
					<th>权限:</th>
					<td class="cc" valign="top" style="width:565px;">
						<div class="se_left">
				         	<div class="content_wrap">
								<div class="zTreeDemoBackground left" style="width:456px;">
									<ul id="treeDemoRole" class="ztree"></ul>
								</div>
							</div>
	 					</div>
	 					<div id="role_list"><div>
					</td>
				</tr>
				<tr class="act">
				   <td colspan="4">				
						<input type="button" id="saveBtn" class="btn" value="提 交"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>	
				   </td>
			    </tr>
			</table>
		</form>
	</div>
	</div>
</body>
</html>
