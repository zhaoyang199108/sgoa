<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
       <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>审批流程管理</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/demo.css" type="text/css" rel="stylesheet">
       	<link href="${cssDomain}/css/zTreeStyle/zTreeStyle.css"  type="text/css" rel="stylesheet">
       	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.core-3.1.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.excheck-3.1..js"></script>
	    <script type="text/javascript"  src="${jsDomain}/js/ztree/jquery.ztree.exedit-3.1.js"></script>
		<SCRIPT type="text/javascript">
		var setting = {
			view: {
				selectedMulti: false
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRenameBtn: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeRemove: beforeRemove,
				onRemove: onRemove,
				onClick: zTreeOnClick
			}
		};

	
		var log, className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function beforeRemove(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}
		
		// 
		function zTreeOnClick(event, treeId, treeNode) {
		    // 取得人员信息
        	$("#pId").val(treeNode.id);
        	$("#grpoNames").val(treeNode.name);
        	$.ajax({
	            type: 'GET',
	            contentType: 'application/json',
	            url: '/approvalDetail/approval_detail.htm',
	            dataType: 'json',
				data: 'id=' + treeNode.id + '&r=' + Math.random(),
				success: function(data){
					// 从Controller里取得对象数组
	            	var approvalDetailObj = data.approvalDetailForStatus;
	            	if(approvalDetailObj.status == 'Y'){
	            		$("#status").attr("checked",'true');
	            	} else {
	            		$("#status").removeAttr("checked");
	            	}
	            },
	            error: function(){
	            }
	        });
          
		}
		
		function onRemove(e, treeId, treeNode) {
			showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			 	$.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/approvalDetail/delete.htm',
		            dataType: 'json',
					data: 'id=' + treeNode.id +'&detailId='+$("#detailId").val()+'&r=' + Math.random(),
					success: function(data){
						// 从Controller里取得对象数组
		            	var approvalDetailListObj = data.approvalDetailList;
		            	 alert("操作成功");
		            	if(approvalDetailListObj.length>0){
			            	// 定义树形数组对象
			            	var zNodes = [approvalDetailListObj.length];
			            	// 循环取得对象里信息
			            	for (var i=0;i<approvalDetailListObj.length;i++) {
			            		// 设置树形结构数组
			            		var approvalDetail = approvalDetailListObj[i];
			            		zNodes[i] = {id:approvalDetail.id,pId:approvalDetail.pId,name:approvalDetail.grpoName, open:true};
			            	}
			            	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			            	$("#selectAll").bind("click", selectAll);
		            		$("#submitBtnRoot").attr("disabled","true");
		            	} else {
		            		$("#treeDemo").html("");
		            		$("#submitBtnRoot").removeAttr("disabled");
		            	}
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		                alert("取得部门默认值失败");
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
	            url: '/approvalDetail/approvalDetail_list.htm',
	            dataType: 'json',
	            data: 'detailId='+$("#detailId").val()+'&r=' + Math.random(),
	            success: function(data){
	            	// 从Controller里取得对象数组
	            	var approvalDetailListObj = data.approvalDetail;
	            	if(approvalDetailListObj.length!=0){
	            		// 定义树形数组对象
		            	var zNodes = [approvalDetailListObj.length];
		            	// 循环取得对象里信息
		            	for (var i=0;i<approvalDetailListObj.length;i++) {
		            		// 设置树形结构数组
		            		var approvalDetail = approvalDetailListObj[i];
		            		zNodes[i] = {id:approvalDetail.id,pId:approvalDetail.pId,name:approvalDetail.grpoName, open:true};
		            	}
		            	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
						$("#selectAll").bind("click", selectAll);
						$("#submitBtnRoot").attr("disabled","true");
	            	} else {
	            		$("#treeDemo").html("");
	            		$("#submitBtnRoot").removeAttr("disabled");
	            	}
	            },
	            error: function(){
	            	// 请求错误时,提示用户
	                alert("取得默认值失败");
	            }
	        });
	        
	          // 增加按钮点击事件
		    $("#detailId").change(function(){
		    	// 根据所选部门ID,取得所选部门的默认值
		    	$.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/approvalDetail/approvalDetail_list.htm',
		            dataType: 'json',
		            data: 'detailId='+$(this).val()+'&r=' + Math.random(),
		            success: function(data){
		            	// 从Controller里取得对象数组
		            	var approvalDetailListObj = data.approvalDetail;
		            	if(approvalDetailListObj.length>0){
			            	// 定义树形数组对象
			            	var zNodes = [approvalDetailListObj.length];
			            	// 循环取得对象里信息
			            	for (var i=0;i<approvalDetailListObj.length;i++) {
			            		// 设置树形结构数组
			            		var approvalDetail = approvalDetailListObj[i];
			            		zNodes[i] = {id:approvalDetail.id,pId:approvalDetail.pId,name:approvalDetail.grpoName==null?"":approvalDetail.grpoName, open:false};
			            	}
			            	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			            	$("#selectAll").bind("click", selectAll);
			            	$("#submitBtnRoot").attr("disabled","true");
						} else {
							$("#treeDemo").html("");
		            		$("#submitBtnRoot").removeAttr("disabled");
		            	}
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		                alert("取得默认值失败");
		            }
	        	});
	        	$("#pId").val("");
	        	$("#grpoNames").val("");
	        	$("#status").removeAttr("checked");
	        	$("#grpoNames").val("");
		    });
	        
	         /**
             * 职务选择按钮事件,弹出对话框选择职务
             */
            $("#receiverSelect").click(function(){
            	var url = "";
            	if ($('#positionId').val() == "") {
		        	url = "${appDomain}/common/choose_grpo.htm?r=" + Math.random();
		        } else {
		        	url = "${appDomain}/common/choose_grpo.htm?id="+$('#positionId').val()+"&r=" + Math.random();
		        }
                var param = 'dialogWidth=780px;dialogHeight=480px;status=no;center=yes;scroll=no';
		        var vals = window.showModalDialog(url, '', param);
                 if(vals==undefined)
		    	{
		    		  return false;
		 	    }
		        if (vals.length == 0) {
		            alert("未选择职务,请重新选择!");
		            return false;
		        }
		        if (vals.length > 0) {
                    $("#grpoName").val(vals[1]);
                    $("#positionId").val(vals[0]);
                }
             });
             
             
             //新增根按钮提交
             $("#submitBtnRoot").click( function() {
            	 // 职务非空校验
				if(!isEmpty($("input[name=grpoName]")," 职务不允许为空！")){
					return;
				}
              	$("#pId").val(0);
				$('form').attr("action", "${appDomain}/approvalDetail/add_approvalDetailRoot.htm");
				 alert("操作成功");
				$('form').submit();
			});
			
			//新增按钮提交
			 $("#submitBtn").click( function() {
			 	// 上一步审批人非空校验
				if(!isEmpty($("input[name=grpoNames]")," 上一步审批人不允许为空！")){
					return;
				}
				// 职务非空校验
				if(!isEmpty($("input[name=grpoName]")," 职务不允许为空！")){
					return;
				}
				$('form').attr("action", "${appDomain}/approvalDetail/add_approvalDetail.htm");
				alert("操作成功");
				$('form').submit();
			});
			
			//更新根按钮提交
			 $("#draftBtn").click( function() {
			 	// 上一步审批人非空校验
				if(!isEmpty($("input[name=grpoNames]")," 上一步审批人不允许为空！")){
					return;
				}
				// 职务非空校验
				if(!isEmpty($("input[name=grpoName]")," 职务不允许为空！")){
					return;
				}
				$('form').attr("action", "${appDomain}/approvalDetail/edit_approvalDetail.htm");
				 alert("操作成功");
				$('form').submit();
			});
			
		});
		

	</SCRIPT>
	<style type="text/css">
.ztree li button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
	</style>
</HEAD>

<BODY>
<div id="main">
     <div class="main_nav">
        <#include "seal/menu.ftl">
     <div class="content" style="width:84%; float:right;background:url(../images/cotbg.jpg) no-repeat right;">
      <form id="approvalDetailForm" name="approvalDetailForm" action="${appDomain}/approvalDetail/approvalDetail_list.htm" method="POST">
     	<input type="hidden" id="steps" name="steps" value=""/>
     <div class="cont_nav">
		<div class="content_wrap" style="width:90%;">
			<div class="zTreeDemoBackground left">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
			<div class="right">
			<ul class="tiyww">
				<li><span>主表类别名称:</span>				
	                  <select id="detailId" name="detailId">
				         <#list approvalList as approval>
	                     <option value="${approval.id}" <#if detailIdSel == approval.id>selected="selected"</#if>>${approval.approvalName}</option>
	                     </#list>
	                  </select>
				</li>
				<li><span>上一步审批职务:	</span>					
					<input class="text" type="hidden" id="pId" name="pId"/>
					<input class="text" type="text" id="grpoNames" name="grpoNames"/>
				</li>
				<li><span>下一步审批职务:	</span>
				 <input class="txt title" type="hidden" id="positionId" name="positionId" value="" />
		         <input class="txt title" id="grpoName" name="grpoName" type="text" value="" readonly="readonly" />
		         <input id="receiverSelect" type="button" class="btn" value="选择" />
		         </li>
				 <li class="tiyan">
				 <input type="checkbox" id="status" name="status" value="Y" style="width:auto;" /><lable style="color:red;">是否有签发权限</lable>
				 </li>
				 <li class="tiyan">
				  <input id="submitBtnRoot" class="btn" type="button" value="创建节点" />
                  <input id="submitBtn" class="btn" type="button" value="新增节点" />
                  <input id="draftBtn" class="btn" type="button" value="更新节点" />
                  <input id="cancelBtn" class="btn" type="reset" value="取 消" />
				 </li>
			 </ul>
			</div>
		</div>
		</div>
		</form>
	</div>
	</div>
</div>
</BODY>
</HTML>