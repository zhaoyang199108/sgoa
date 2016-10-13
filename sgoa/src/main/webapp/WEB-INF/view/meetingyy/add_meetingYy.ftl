<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>新增会议预约</title>  
    <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/dhtmlxCalendar/codebase/dhtmlxcalendar.css">
	<link rel="stylesheet" type="text/css" href="${jsDomain}/js/dhtmlxCalendar/codebase/skins/dhtmlxcalendar_dhx_web.css">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script src="${jsDomain}/js/dhtmlxCalendar/codebase/dhtmlxcalendar.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
		      //日期控件
		 		var cal1 = new dhtmlxCalendarObject(['startTime', 'endTime']);
				cal1.setDateFormat("%Y-%m-%d %H:%i:%s");
				cal1.setSkin('dhx_web');
		
			/**
			 * 提交审核按钮按下-2011-09-05-追加开始
			 */
			$("#saveBtn").click(function(){
			   // 会议室非空校验
				if(!isEmpty($("select[name=roomId]"),"会议室不允许为空！")){
					return;
				}
				// 当前流程非空校验
				if(!isEmpty($("select[name=approvalId]"),"当前流程不允许为空！")){
					return;
				}
				// 预约开始时间非空校验
				if(!isEmpty($("input[name=startTime]"),"预约开始时间不允许为空！")){
					return;
				}
				// 预约结束时间非空校验
				if(!isEmpty($("input[name=endTime]"),"预约结束时间不允许为空！")){
					return;
				}
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
                if(!confirm("是否确定提交?")){
                	return false;
                }
                $.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '/meetingYy/time_compare.htm',
		            dataType: 'json',
					data: 'roomId=' + $("#roomId").val() +'&startTime=' + $("#startTime").val() + '&endTime=' + $("#endTime").val() +'&r=' + Math.random(),
					success: function(data){
						// 从Controller里取得对象数组
		            	var temp = data.isNormal;
		            	if(temp == false){
		            	    alert("此会议室此时间段已经被预约！");
		            	    return false;
		            	} else {
		            		$('form').attr("action", "${appDomain}/meetingYy/add_meetingYy.htm");
		    				$('form').submit();
		            	}
		            	
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		               alert("时间比较失败");
		               return false;
		            }
		        });
		    });
		});
	</script>
</head>
<body>
<div id="main">
	<div class="main_nav">
	<#include "meetingyy/menu.ftl">
		<div id="content">
			<form class="f0" action="${appDomain}/meetingYy/add_meetingYy.htm" method="POST">
			  <div class="ct">
				<table class="ftb">
					<input type="hidden" id="currentOptId" name="currentOptId" value="" />
		        	<input type="hidden" id="nextOptId" name="nextOptId" value="" />
		        	<input type="hidden" id="status" name="status" value="" />
		        	<input class="text" type="hidden" id="step"  name="step" value="1"  />
				<tr>
				    <th>预约人:</th>
					<td>						
						<input class="text" type="text" name="userName"  value="${userName}" readonly="readonly"/>
						<input class="text" type="hidden" name="loginId" value="${loginId}"/>
					</td>
				</tr>
				<tr>
					<th>会议室:</th>
					<td>						
						 <select name="roomId" id="roomId">
						      <option value="">请选择</option>
					          <#list meetingRoomPage as meetingRoom>
                		      <option value="${meetingRoom.id}" > ${meetingRoom.roomName} </option>
                              </#list>
                         </select>
					</td>
				</tr>
				<tr>
					<th>当前流程:</th>
					<td>						
						 <select id="approvalId" name="approvalId">
						      <option value="">请选择</option>
					          <#list approvalPage as approval>
                		      <option value="${approval.id}" > ${approval.approvalName} </option>
                              </#list>
                         </select>
					</td>
				</tr>
				<tr>
				    <th>预约开始时间:</th>
					<td>						
						<input class="text" type="text" name="startTime" id="startTime"/>
					</td>
				</tr>
				<tr>
					<th>预约结束时间:</th>
					<td>						
					    <input class="text" type="text" name="endTime" id="endTime"/>
					</td>
				</tr>
					
				<tr class="act">
				   <td colspan="2">				
						<input type="button" id="saveBtn" class="btn" value="提 交" style="margin-right:18%;"/>
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
