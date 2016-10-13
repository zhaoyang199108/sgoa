<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>会议室预约审批</title>  
	<link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript">
            $(document).ready(function(){
                $("#draftBtn").click(function(){
                	// 提示用户确认否决
                	 $("#doAction").val(3);
                	 $("#status").val(3);
                    if(!confirm("确定否决申请?")){
                    	return false;
                    }
                	// 添加校验
                	$('form').attr("action", "${appDomain}/meetingYy/add_meetingYy_review.htm");
                	$('form').submit();
                });
                
                 $("#submitBnt").click(function(){					
			        $("#status").val(4);
			         $("#doAction").val(4);
			        if(!confirm("是否确定提交?")){
			        	return false;
			        }
                	$('form').submit();
                });
                
             /**
			 * 提交审核按钮按下-2011-09-05-追加开始
			 */
			$("#saveBtn").click(function(){
		      if(!confirm("请选择审批人!")){
                    	return false;
                    }
                    // 添加校验
                    // 选择提交审核人
                    var url = "${appDomain}/common/choose_approval_user.htm?step="+$("#step").val()+"&approvalId=" + $("#approvalId").val()+"&r=" + Math.random();
                    var param = 'dialogWidth=380px;dialogHeight=380px;status=no;center=yes;scroll=no';
                    
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
		        	{
		        		  return false;
		     	    }
                    if (value.length == 0) {
                        alert("未选择提交人,请重新提交!是否现在选择审批人?");
                        return false;
                    }
                    if(value[0].indexOf(",") > -1){
                    	alert("提交审核人只能选择一个!");
                        return false;
                    }
                   	$("#nextOptId").val(value[0]);
                    $("#status").val(1);
			        $("#doAction").val(2);
                    if(!confirm("是否确定提交?")){
                    	return false;
                    }
		        $('form').attr("action", "${appDomain}/meetingYy/add_meetingYy_review.htm");
		    	$('form').submit();
		    });
                
            });
        </script>
</head>
<body>
<div id="main">
	<div class="main_nav">
	<#include "meetingyy/menu.ftl">
		<div id="content">
			 <form class="f0" action="${appDomain}/meetingYy/add_meetingYy_review.htm" method="POST">
			  <div class="ct">
				<table class="ftb">
				    <input type="hidden" name="id" value="${meetingYy.id}"/>
					<input type="hidden"  id="doAction" name="doAction" value=""/>
            		<input type="hidden" id="status" name="status" value="" />
            		<input type="hidden" id="nextOptId" name="nextOptId" value="" />
					<input class="text" type="hidden" id="step"  name="step" value="${stepNext}"  />
				<tr>
				    <th>预约人:</th>
					<td>						
						<input class="text" type="text" name="userName"  value="${meetingYy.userName}" readonly="readonly"/>
						<input class="text" type="hidden" name="loginId" value="${meetingYy.loginId}"/>
					</td>
				</tr>
				<tr>
					<th>会议室:</th>
					<td>						
						 <select name="roomId"  disabled="disabled">
						      <option value="">请选择</option>
					          <#list meetingRoomPage as meetingRoom>
                		       <option value="${meetingRoom.id}" <#if meetingRoom.id == meetingYy.roomId>selected="selected"</#if>>${meetingRoom.roomName}</option>
                              </#list>
                         </select>
					</td>
				</tr>
				<tr>
					<th>当前流程:</th>
					<td>						
						 <select id="approvalId" name="approvalId"  disabled="disabled">
						      <option value="">请选择</option>
					          <#list approvalPage as approval>
                		       <option value="${approval.id}" <#if approval.id == meetingYy.approvalId>selected="selected"</#if>>${approval.approvalName}</option>
                              </#list>
                         </select>
					</td>
				</tr>
				<tr>
				    <th>预约开始时间:</th>
					<td>						
						<input class="text" type="text" name="startTime" id="startTime" value="${meetingYy.startTime}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
					<th>预约结束时间:</th>
					<td>						
					    <input class="text" type="text" name="endTime" id="endTime" value="${meetingYy.endTime}" readonly="readonly"/>
					</td>
				</tr>
			    <tr>
				    <th>审核意见：</th>
				    <td colspan="3">
					<label><textarea class="big" name="opinion" rows="4" cols="92"/></textarea></label>
					<br /><br />
				     <span>负责人:
				   <input class="txt"  type="hidden" id="optId" name="optId" value="" />${userName}</span></td>
				  </tr>
				  <tr class="act">
                    <td colspan="2">
                    <#if approvalDetailForStatus == 'Y'>
                        <input id="draftBtn" class="btn" name="draftBtn" type="button" value="不同意" />
                    </#if>
                    <#if approvalDetailForStatus == 'Y'>
					    <input id="submitBnt" class="btn" name="draftBtn" type="button" value="同 意" />
					</#if>
					<#if stepNext!=null>
		                <input id="saveBtn" class="btn" name="draftBtn" type="button" value="提 交" />
		             </#if>
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
