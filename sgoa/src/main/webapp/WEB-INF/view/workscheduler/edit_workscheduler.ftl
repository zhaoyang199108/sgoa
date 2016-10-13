<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>日程提醒</title>  
	<link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/dhtmlxCalendar/codebase/dhtmlxcalendar.css"></link>
	<link rel="stylesheet" type="text/css" href="${jsDomain}/js/dhtmlxCalendar/codebase/skins/dhtmlxcalendar_dhx_web.css"></link>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>  
	<script src="${jsDomain}/js/dhtmlxCalendar/codebase/dhtmlxcalendar.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {
		
			//日期控件
	 		var cal1 = new dhtmlxCalendarObject(['startRemindTime']);
			cal1.setDateFormat("%Y-%m-%d %H:%i:%s");
			cal1.setSkin('dhx_web');
			
			$("#updateBtn").click( function() {	
			  var isRemind=$("#isRemind").val()	
			  if('Y'==(isRemind)){
			  // 提醒时间非空校验
				if(!isEmpty($("input[name=startRemindTime]"),"提醒时间不能为空！")){
					return;
				}
				 // 是否继续提醒非空校验
				if(!isEmpty($("select[name=isRemind]"),"是否继续提醒不能为空！")){
					return;
				}
			  }		
				$('form').submit();
			});
		});
	</script>
</head>
<body>
     <div class="sow">
			<h3 class="title"><font size="3"><strong>更新日程提醒</strong></font></h3>
			<form class="f0" action="${appDomain}/workscheduler/edit_workscheduler_one.htm" method="POST">
				<input type="hidden" name="id"  value="${workScheduler.id}"/>
				<table class="ftb">
				<tr>
				    <th>日程开始时间:</th>
					<td>						
						<input class="text" type="text" name="startTime" value="${workScheduler.startTime}" readonly="readonly"/>
					</td>
					<th>日程结束时间:</th>
					<td>						
						<input class="text" type="text" name="endTime" value="${workScheduler.endTime}" readonly="readonly"/>
					</td>
				</tr>
				<tr>
				    <th>开始提醒时间:</th>
					<td>						
						<input class="text" type="text" id="startRemindTime" name="startRemindTime" value="${workScheduler.startRemindTime}" />
					</td>
					<th>是否继续提醒:</th>
					<td>						
						<select id="isRemind" name="isRemind">
                					<option value='Y' <#if workScheduler.isRemind == "Y">selected="selected"</#if>>提醒</option>
                         </select>
					</td>
				</tr>				
				<tr>
				    <th>日程内容:</th>
					<td colspan="3">						
						<textarea name="content" id="ct"  class="woe"  readonly="readonly" >${workScheduler.content}</textarea>
					</td>
				</tr>
				
				<tr class="act">
				   <td colspan="6">													
						<input type="button" id="updateBtn" class="btn" value="提 交"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>	
				   </td>
				</tr>
				</table>				
				</ul>
			</form>
	</div>
</body>
</html>
