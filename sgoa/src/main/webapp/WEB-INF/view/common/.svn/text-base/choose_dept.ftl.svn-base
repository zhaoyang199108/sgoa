<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>选择部门</title>
		<base target="_self">
        <link href="${cssDomain}/css/base.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/demo_dept.css" type="text/css" rel="stylesheet">
		<link href="${cssDomain}/css/zTreeStyle/zTreeStyle.css"  type="text/css" rel="stylesheet">
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.core-3.1.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.excheck-3.1.js"></script>
	    <script type="text/javascript"  src="${jsDomain}/js/ztree/jquery.ztree.exedit-3.1.js"></script>
		<script type="text/javascript">
			// 部门树形菜单设置
			var setting = {
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
				$("#deptId").val(treeNode.id)
				$("#deptName").val(treeNode.name)
			}
		
		    $(document).ready(function(){
		    
		    	// 取得部门信息
		        $.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/common/find_dept.htm',
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
		            		zNodes[i] = {id:dept.id,pId:dept.unitId,name:dept.deptName, open:true};
		            	}
		            	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		            	$("#selectAll").bind("click", selectAll);
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		                alert("取得部门信息失败！");
		            }
		        });
		    	
		        /**
		         * 人员选择完成后, 点击确认按钮返回父页面
		         */
		        $("#doneBtn").click(function(){
		            if ($("#deptId").val() == "") {
		                alert("请选择部门");
		                return false;
		            }
					
		            // 设置返回值数组,用户ID和用户姓名
		            var rtValue = new Array();
		            rtValue[0] = $("#deptId").val();
		            rtValue[1] = $("#deptName").val();
		            
		            window.opener = null;
		            window.open('', '_self');
		            window.returnValue = rtValue;
		            window.close();
		        });
		        
		        /**
		         * 关闭当前页面
		         */
		        $("#closeBtn").click(function(){
		            window.returnValue = new Array();
		            window.close();
		        });
		    });
		    
		    // 当部门被选择时, 设置背景色
		    function addCurrentDeptStyle(id){
		        $(".dept-list li").removeClass("current");
		        $('#d_' + id).addClass("current");
		    }
		</script>
    </head>
    <body>
    	<div class="f0">
    		<div class="wrap">
		    	<input type="hidden" id="deptId" name="deptId" value="" />
		    	<input type="hidden" id="deptName" name="deptName" value="" />
		        <div class="wrap-div">
		         	<div class="content_wrap">
						<div class="zTreeDemoBackground left">
							<ul id="treeDemo" class="ztree"></ul>
							
							<div style="padding-top:20px; width:100%; float:left;">
				        	<input type="button" class="bttn" id="doneBtn" name="doneBtn" value="提交" />
				        	<input type="button" class="bttn" id="closeBtn" name="closeBtn" value="关闭" />
				        	</div>
						</div>
					</div>
		        </div>
		        
	     	</div>
	     </div>
    </body>
</html>