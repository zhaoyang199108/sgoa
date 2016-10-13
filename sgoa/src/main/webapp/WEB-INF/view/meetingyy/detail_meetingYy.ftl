<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>会议室预约详细信息</title>  
	<link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
</head>
<body>
 <div class="sow">
	<div id="main">
		<div id="content">
			 <h3 class="title"><font size="3"><strong>会议室预约详细</strong></font></h3>
			 <div class="ct">
				<table class="ftb">
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
						 <select name="roomId" disabled="disabled">
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
						 <select id="approvalId" name="approvalId" disabled="disabled">
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
			    <#list page.meetingYyReviewList as meetingYyReview>
				  <tr>
				    <th>审核意见：</th>
				    <td colspan="3">
					<label><textarea class="big" name="opinion" rows="4" cols="64"/>${meetingYyReview.opinion}</textarea></label>
					<br />
				     <span>负责人：${meetingYyReview.currentOptName}</span>
				   </td>
				  </tr>
				   </#list>
					</tr>
					 <tr class="act">
						 <td colspan="2">
				            <input class="btn" name="draftBtn" type="button" value="关闭" onclick="window.close();" />	 
				         </td>
				     </tr>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>
