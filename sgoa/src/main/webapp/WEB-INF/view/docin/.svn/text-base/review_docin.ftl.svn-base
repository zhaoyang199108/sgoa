<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>收文审批</title>  
	<link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript">
            $(document).ready(function(){
            
             /**
                 * 收件人选择按钮事件,弹出对话框选择收件人
                 */
                $("#receiverSelect").click(function(){
                    var url = "${appDomain}/common/choose_all_user.htm" + "?ids=" + $("#receiverId").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#receiverIds").val(value[1]);
                        $("#receiverId").val(value[0]);
                    }
                });
                
                $("#draftBtn").click(function(){
                	// 提示用户确认否决
                	 $("#doAction").val(3);
                	 $("#status").val(3);
                    if(!confirm("确定办结申请?")){
                    	return false;
                    }
                	// 添加校验
                	$('form').attr("action", "${appDomain}/docin/add_docin_review.htm");
                    $('form').submit();
                });
                
                 $("#submitBnt").click(function(){
                 	var url = "${appDomain}/common/choose_all_user.htm" + "?ids=" + $("#receiverId").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#receiverIds").val(value[1]);
                        $("#receiverId").val(value[0]);
                    }
                    
			        $("#status").val(5);
			         $("#doAction").val(5);
			        if(!confirm("是否确定批准?")){
			        	return false;
			        }
                    $('form').submit();
                });
                
                $("#gdBnt").click(function(){
			        $("#status").val(5);
			         $("#doAction").val(5);
                     $("#receiverId").val($("#loginId").val());
			        if(!confirm("是否确定归档?")){
			        	return false;
			        }
                    $('form').submit();
                });
            
            // 提交意见
            $(".hqBtn").click(function(){
            	$("#seat").val($(this).attr("alt"));
            	$("#opinion").val($("#opinion"+$(this).attr("alt")).val());
            	//如果登录人是局长，直接提交给秘书
				var loginiddq = document.getElementById("loginIddq").value; 
				var loginidjzms = document.getElementById("loginIdjzms").value; 
				if(loginiddq == 8001){
					$("#nextOptId").val(loginidjzms);
				} else {
					//如果登录人职务是副局长，直接提交给机要员
					var zwid = document.getElementById("zwId").value; 
					var loginidjyy = document.getElementById("loginIdjyy").value; 
					if(zwid == 9 || zwid == 16 || zwid == 17 || zwid == 18 || zwid == 19 || zwid == 37){
						$("#nextOptId").val(loginidjyy);
					} 
					else{
	                	if($("#submitStatus").val()){
			                if(!confirm("请选择审批人!")){
			                	return false;
			                }
			                // 添加校验
			                // 选择提交审核人
			                var url = "";
			               	if($(this).attr("alt")==3){
			                  url = "${appDomain}/common/choose_approval_user_all.htm?step="+$("#step").val()+"&approvalId=" + $("#approvalId").val()+"&yxOptId=" + $("#yxOptId").val()+"&r=" + Math.random();
			                }
			                else{
			                  url = "${appDomain}/common/choose_approval_user_all.htm?step="+$("#step").val()+"&approvalId=" + $("#approvalId").val()+"&r=" + Math.random();
			                }
			                var param = 'dialogWidth=380px;dialogHeight=380px;status=no;center=yes;scroll=no';
			                
			                var value = window.showModalDialog(url, '', param);
			                if(value==undefined) {
				        		  return false;
				     	    }
			                $("#nextOptId").val(value[0]);
			            }
	                }
	            }
                $("#status").val(1);
		        $("#doAction").val(2);
                if(!confirm("是否确认"+$(this).val()+"?")){
                	return false;
                }
		        $('form').attr("action", "${appDomain}/docin/add_docin_review.htm");
                $('form').submit();
		    });
		    
		    /**
			 * 提交审核按钮按下-2011-09-05-追加开始
			 */
			$("#saveBtn").click(function(){
                    //如果登录人是局长，直接提交给秘书
					var loginiddq = document.getElementById("loginIddq").value; 
					var loginidjzms = document.getElementById("loginIdjzms").value; 
					if(loginiddq == 8001){
						$("#nextOptId").val(loginidjzms);
					}
					//如果登录人职务是副局长，直接提交给机要员
					var zwid = document.getElementById("zwId").value; 
					var loginidjyy = document.getElementById("loginIdjyy").value; 
					if(zwid == 9 || zwid == 16 || zwid == 17 || zwid == 18 || zwid == 19 || zwid == 37){
						$("#nextOptId").val(loginidjyy);
					} 
					else{
                    if(!confirm("请选择审批人!")){
                    	return false;
                    }
                    // 添加校验
                    // 选择提交审核人
                    var url = "${appDomain}/common/choose_approval_user_all.htm?step="+$("#step").val()+"&approvalId=" + $("#approvalId").val()+"&yxOptId=" + $("#yxOptId").val()+"&r=" + Math.random();
                    var param = 'dialogWidth=380px;dialogHeight=380px;status=no;center=yes;scroll=no';
                    
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
		        	{
		        		  return false;
		     	    }
                    $("#nextOptId").val(value[0]);
                    }
                    $("#status").val(1);
			        $("#doAction").val(2);
			        $("#seat").val(5);
            		$("#opinion").val("");
                    if(!confirm("是否确定提交?")){
                    	return false;
                    }
		        $('form').attr("action", "${appDomain}/docin/add_docin_review_ms.htm");
                $('form').submit();
		    });
                
		    $("#rebackBtn").click(function(){
                if(!confirm("请选择返回人!")){
                	return false;
                }
                // 添加校验
                // 选择提交返回人
                var url = "${appDomain}/common/choose_reback_user2.htm?step="+$("#step").val()+"&id=" + $(this).attr("alt") + "&r=" + Math.random();
                var param = 'dialogWidth=380px;dialogHeight=380px;status=no;center=yes;scroll=no';
                
                var value = window.showModalDialog(url, '', param);
                if(value==undefined)
	        	{
	        		  return false;
	     	    }
                if (value.length == 0) {
                    alert("未选择返回人,请重新选择!是否现在选择返回人?");
                    return false;
                }
                if(value[0].indexOf(",") > -1){
                	alert("提交返回人只能选择一个!");
                    return false;
                }
                $("#nextOptId").val(value[0]);
                $("#step").val(value[1]);
                $("#status").val(1);
		        $("#doAction").val(1);
                if(!confirm("是否确定返回?")){
                	return false;
                }
                $('form').attr("action", "${appDomain}/docin/docin_reback.htm");
                $('form').submit();
	    	
		    });
			    
			//文件下载
			$(".act-down").click(function(){
				$("#srcFileNameOne").val($(this).attr("alt"));
				$('form').attr("action","${appDomain}/docinShareDown/download_file.htm");
				$('form').submit();
			});	
			
			/**
		     * 修改密码事件
		     */
		       $("#isAlert").click(function() {
	                if (!!$("#isAlert").attr("checked")) {
						$("#alertBtn").removeAttr("disabled"); //去除readonly属性
		                $('#alertTime').val("");
		                $('#alertRemark').val("");
	                }else{
	                	$("#alertBtn").attr("disabled", true);
	                }
		        });
		        
		        // 更新按钮点击事件
			    $("#alertBtn").click(function(){
			    	var modeName = "收文通知";
			    	var busId = "docin";
			        var url = "${appDomain}/alert/add_alert.htm?title=" + encodeURI($("#title").val()) + "&modeName="+encodeURI(modeName)+"&busId="+busId + "&r=" + Math.random();
			        var param = 'dialogWidth=780px;dialogHeight=350px;status=no;center=yes;scroll=no';
			        var val = window.showModalDialog(url, '', param);
			        if (val == 'refresh') {
			            alert("添加提醒成功");
			        }
			    });
			    // 常用语
			    $("#yybtn1").click(function(){
			        $("#opinion1").val($("#opinion1").val()+$(this).val());
			    	$("#opinion").val($("#opinion1").val()+$(this).val());
			    	$("#seat").val(1);
			    });
			     // 常用语
			    $("#tynbyjbtn1").click(function(){
			    	$("#opinion1").val($("#opinion1").val()+$(this).val());
			    	$("#opinion").val($("#opinion1").val()+$(this).val()); 
			    	$("#seat").val(1);
			    });
                // 常用语
			    $("#yybtn2").click(function(){
			        $("#opinion2").val($("#opinion2").val()+$(this).val());
			    	$("#opinion").val($("#opinion2").val()+$(this).val());
			    	$("#seat").val(2);
			    });
			     // 常用语
			    $("#tynbyjbtn2").click(function(){
			    	$("#opinion2").val($("#opinion2").val()+$(this).val());
			    	$("#opinion").val($("#opinion2").val()+$(this).val()); 
			    	$("#seat").val(2);
			    });
			    // 常用语
			    $("#yybtn3").click(function(){
			        $("#opinion3").val($("#opinion3").val()+$(this).val());
			    	$("#opinion").val($("#opinion3").val()+$(this).val()); 
			    	$("#seat").val(3);
			    });
			     // 常用语
			    $("#tynbyjbtn3").click(function(){
			    	$("#opinion3").val($("#opinion3").val()+$(this).val());
			    	$("#opinion").val($("#opinion3").val()+$(this).val()); 
			    	$("#seat").val(3);
			    });
			    
			     // 常用语
			    $("#yyjzbtn4").click(function(){
			        $("#opinion4").val($("#opinion4").val()+$(this).val());
			    	$("#opinion").val($("#opinion4").val()+$(this).val()); 
			    	$("#seat").val(4);
			    });
			     // 常用语
			    $("#tynbyjbtn4").click(function(){
			    	$("#opinion4").val($("#opinion4").val()+$(this).val());
			    	$("#opinion").val($("#opinion4").val()+$(this).val()); 
			    	$("#seat").val(4);
			    });
			    
			    // 会签领导预选择
			    $("#yybtn4").click(function(){
                 	var url = "${appDomain}/common/choose_all_user_nc.htm" + "?ids=" + $("#receiverId").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#opinion4").text($("#opinion4").text()+"请"+value[1]+"审阅");
                        $("#yxOptId").val(value[0]);
                    }
                });
                
                  // 预选办事员
			    $("#yybtn33").click(function(){
                 	var url = "${appDomain}/common/choose_dept_user_all.htm?r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#opinion3").text($("#opinion3").text()+"请"+value[1]+"办事");
                        $("#yxOptId").val($("#yxOptId").val()+','+value[0]);
                    }
                });
            });
        </script>
</head>
<body>
<div id="main">
	<div class="main_nav">
	<#include "docin/menu.ftl">
		<div id="content">
		<div class="pstty"><h4>文件处理单</h4>
			 <form class="f0" action="${appDomain}/docin/add_docin_review.htm" method="POST">
				<table class="stty">
				    <input type="hidden" id="id" name="id" value="${docin.id}"/>
					<input type="hidden"  id="doAction" name="doAction" value=""/>
            		<input type="hidden" id="status" name="status" value="" />
            		<input type="hidden" id="nextOptId" name="nextOptId" value="" />
            		<input type="hidden" id="dRecordid" name="dRecordid" value="${d_recordId}" />
            		<input type="hidden" id="d_templateid" name="d_templateid" value="${docin.dRecordid}" />
					<input class="text" type="hidden" id="step"  name="step" value="${stepNext}"  />
					<input class="text" type="hidden" id="reviewStep"  name="reviewStep" value="${reviewStep}"  />
					<input class="text" type="hidden" id="steps"  name="steps" value="1"  />
					<input type="hidden" id="sort" name="sort" value="${docin.sort}" />
					<input type="hidden" id="loginIddq" name="loginIddq" value="${loginIddq}" />
		        	<input type="hidden" id="loginIdjzms" name="loginIdjzms" value="${loginIdjzms}" />
		        	<input type="hidden" id="loginIdjyy" name="loginIdjyy" value="${loginIdjyy}" />
		        	<input type="hidden" id="zwId" name="zwId" value="${zwId}" />
		        	<input type="hidden" id="loginId" name="loginId" value="${loginId}" />
		        	<input type="hidden" id="category" name="category" value="${docin.category}" />
		        	<input type="hidden" id="opinion" name="opinion" value="" />
		        	<input type="hidden" id="seat" name="seat" value="" />
		        	<input type="hidden" id="submitStatus" value="${submitStatus}" />
		        	<input type="hidden" id="receiverId" name="receiverId" value="${docin.receiverId}" />
			        <input id="receiverIds" name="receiverIds" type="hidden" value="${docin.receiverName}" readonly="readonly" />
				  	<input type="hidden" id="yxOptId" name="yxOptId" value="${docin.yxOptId}" />
				  	<input type="hidden" id="approvalId" name="approvalId" value="${docin.approvalId}" />
				  	<tr class="yty">
					    <td colspan="4" class="rre">全宗号：
					     
					      <input type="text" name="fondsNum" value="${docin.fondsNum}" readonly="readonly"/> </td>
					   <td colspan="4" class="rre">    
					       全宗名称：
					      
					      <input type="text" name="fondsName" value="${docin.fondsName}" readonly="readonly"/>
					      </td>
					    </tr>
					  <tr>
					    <th width="9%">来文单位：</th>
					    <td colspan="3">
					     <input type="text" name="fileDept" value="${docin.fileDept}" readonly="readonly"/>
					     </td>
					     <th width="9%">文件编号：</th>
					    <td>
					     <input type="text" name="fileNum" value="${docin.fileNum}" readonly="readonly"/>
					     </td>
					     <th width="9%">缓急程度：</th>
					    <td>
					      <#if docin.urgent == ""><input class="text" type="text" value="" readonly="readonly"/></#if>
					      <#if docin.urgent == 1><input class="text" type="text" value="正常" readonly="readonly"/></#if>
	                      <#if docin.urgent == 2><input class="text" type="text" value="加急" readonly="readonly"/></#if>
	                      <#if docin.urgent == 3><input class="text" type="text" value="特急" readonly="readonly"/></#if>
	                      <#if docin.urgent == 4><input class="text" type="text" value="紧急" readonly="readonly"/></#if>
	                      <#if docin.urgent == 5><input class="text" type="text" value="特提" readonly="readonly"/></#if>
					     </td>
					  </tr>
					  <tr>
					    <!--<th width="9%">成文时间：</th>
					    <td>
					     <input type="text" name="textTime" value="${docin.textTime}" readonly="readonly"/>
					     </td>-->
					     <th width="9%">收文时间：</th>
					    <td colspan="3">
					     <input type="text" name="receiverTime" value="${docin.receiverTime}" readonly="readonly"/>
					     </td>
					     <th width="9%">登记号：</th>
					    <td>
					     <input type="text" name="registerNum" value="${docin.registerNum}" readonly="readonly"/>
					     </td>
					     <th width="9%">办理期限：</th>
					    <td>
					     <input type="text" name="blqx" id="blqx" value="${docin.blqx}" readonly="readonly"/>
					     </td>
					    </tr>
					  <tr>
		                    
		               </tr>
					  <tr>
					    <th>文件标题：</th>
					    <td colspan="5"><input type="text" name="title" class="wid" value="${docin.title}" readonly="readonly"/></td>
					 	<th>督　　办：</th>
					   	<td><input type="checkbox" name="supervise" <#if docin.supervise==1> checked=true</#if> value="1" style="width:auto;"/>是否列为督办</td>
					  </tr>
					   
					  <tr>
					    <th>附　　件：</th>
						<td colspan="7">
						<#list docinFjPage as docinFj>
						<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${docinFj.srcFileName}"/>
						<a class="act-down" href="#" alt="${docinFj.srcFileName}">${docinFj.srcFileName}</a>
						</#list>
						</td>
					  </tr>
				 	 <tr>
					    <th>局　　长<br />意　　见</th>
					    <td colspan="7" height="130" >
					    	<div style="width:700px;min-height:100px; height:auto;font-size:16px;overflow:hidden">${opinion1}</div>
					    	<textarea name="opinion1" id="opinion1" class="tt"></textarea>
					    	<br />
							<#if loginIddq == 8001>
							<input id="yybtn1" class="btnnb02" type="button" value="已阅"/>
							<input id="tynbyjbtn1" class="btnnb02" type="button" value="同意拟办意见"/>
							<#if zwId == 7>
							<input id="hqBtn1" class="btn02 hqBtn" alt="1" <#if btnStatus == true>disabled="true"</#if> name="hqBtn" type="button" value="退回" />
							<input id="hqBtn1" class="btn02 hqBtn" alt="1" <#if btnStatus == true>disabled="true"</#if> name="hqBtn" type="button" value="发送" />
							</#if>
							</#if>
							<br />
					    </td>
					    </tr>
					  <tr>
					    <th>分管领导<br />意　　见</th>
					    <td colspan="7" height="130">
					    	<div style="width:700px;min-height:100px; height:auto;font-size:16px;overflow:hidden">${opinion2}</div>
					    	<textarea name="opinion2" id="opinion2" class="tt"></textarea>
					    	<br />
							<#if zwId == 9 || zwId == 16 || zwId == 17 || zwId == 18 || zwId == 19 || zwId == 37>
							<input id="yybtn2" class="btnnb02" type="button" value="已阅"/>
							<input id="tynbyjbtn2" class="btnnb02" type="button" value="请局长审示"/>
							<input id="hqBtn2" class="btn02 hqBtn" alt="2" <#if btnStatus == true>disabled="true"</#if> name="hqBtn" type="button" value="退回" />
							<input id="hqBtn2" class="btn02 hqBtn" alt="2" <#if btnStatus == true>disabled="true"</#if> name="hqBtn" type="button" value="发送" />
							</#if>
							<br />
					    </td>
					    </tr>
					  <tr>
					    <th>承办处室<br />意　　见</th>
					    <td colspan="7" height="80">
					    	<div style="width:700px;min-height:50px; height:auto;font-size:16px;overflow:hidden">${opinion3}</div>
					    	<textarea name="opinion3" id="opinion3" class="tt02"></textarea>
					    	<br />
							<#if zwId == 4 || zwId == 8 || zwId ==12>
							<#if reviewStep != 1>
							<input id="yybtn3" class="btnnb02" type="button" value="请局长审示"/>
							<input id="tynbyjbtn3" class="btnnb02" type="button" value="请领导审阅"/>
							<input id="hqBtn3" class="btn02 hqBtn" alt="3" <#if btnStatus == true>disabled="true"</#if> name="hqBtn" type="button" value="办理" />
							<input id="yybtn33" class="btnnb02" type="button" value="预选办事员"/>
							</#if>
							</#if>
							<br />	
					    </td>
					    </tr>
					  <tr>
					    <th>办公室<br />意　　见</th>
					    <td colspan="7" height="80">
					    	<div style="width:700px;min-height:50px; height:auto;font-size:16px;overflow:hidden">${opinion4}</div>
					    	<textarea name="opinion4" id="opinion4" class="tt02"></textarea>
					    	<br />
							<#if zwId == 4 && deptId == 30 && reviewStep == 1>
							<input id="yybtn4" class="btnnb02" <#if docin.yxOptId != ''>disabled="true"</#if> type="button" value="参与会签领导"/>
							<input id="yyjzbtn4" class="btnnb02" type="button" value="请吉祥局长审示"/>
							<input id="tynbyjbtn4" class="btnnb02" type="button" value="请领导审阅"/>
							<input id="hqBtn4" class="btn02 hqBtn" alt="4" <#if btnStatus == true>disabled="true"</#if> name="hqBtn" type="button" value="办理" />
							</#if>
							<br />	
					    </td>
					  </tr>
				  <tr>
					<th>
						<input class="passuip" type="checkbox" id="isAlert" name="isAlert" value="1" /> <span style="color:red;">是否提醒</span>
					</th>
					<td colspan="7">
						<input id="alertBtn" class="btn" name="alertBtn" type="button" disabled="true" value="添加提醒" />
					</td>
				  </tr>
				  <tr class="act">
                    <td colspan="8">
                    	<#if approvalDetailForStatus == 'Y'>
						    <#if stepNext!=null>
				            	<input id="saveBtn" class="btn" name="draftBtn" <#if submitStatus == false>disabled="true"</#if> type="button" value="${pageButtonName}" />
				            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				            </#if>
				            <input id="gdBnt" class="btn" name="draftBtn" type="button" value="归档" />&nbsp;&nbsp;
						    <input id="submitBnt" class="btn" name="draftBtn" type="button" value="传阅" />
						</#if>
                    </td>
                </tr>
		</table>
    </form>
   </div>
</div>
</div>
</div>
</body>
</html>
