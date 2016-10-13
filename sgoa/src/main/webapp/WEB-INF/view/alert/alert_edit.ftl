<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>消息提醒更新页面</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/GooCalendar/GooFunc.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/GooCalendar/GooCalendar.js"></script>	
	<script type="text/javascript">
		var property={
			divId:"demo1",//日历控件最外层DIV的ID
			needTime:true,//是否需要显示精确到秒的时间选择器，即输出时间中是否需要精确到小时：分：秒 默认为FALSE可不填
			yearRange:[1900,2030],//可选年份的范围,数组第一个为开始年份，第二个为结束年份,如[1900,2030],可不填
			week:["一","二","三","四","五","六","日"],//数组，设定了周日至周六的显示格式,可不填
			month:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],//数组，设定了12个月份的显示格式,可不填
			format:"yyyy-MM-dd"
			/*设定日期的输出格式,可不填*/
		};
		
		$(document).ready( function() {		
		  	birthday=$.createGooCalendar("birthday",property);
			$("#saveBtn").click( function() {
				$('form').submit();
			});
		});
	</script>
</head>
<body>
	<div class="sow">
			<h3 class="title01">消息提醒更新</h3>
			<form class="f0" action="${appDomain}/alert/alert_edit.htm" method="POST">
			<input class="text" type="hidden" name="id" value="${alert.id}"/>
			<input class="text" type="hidden" name="busId" value="${alert.busId}"/>
			<input class="text" type="hidden" name="loginId" value="${alert.loginId}"/>
			<table class="ftb">
				<tr>
				    <th>标题:</th>
					<td colspan="3">						
						<input class="text" type="text" name="title" value="${alert.title}" readonly="readonly"/>
					</td>
				</tr>	
				<tr>
				    <th>用户名称:</th>
					<td>						
						<input class="text" type="text" name="userName" value="${alert.userName}" readonly="readonly"/>
					</td>
					<th>模块名称:</th>
					<td>						
						<input class="text" type="text" name="modeName" value="${alert.modeName}" readonly="readonly"/>
					</td>
				</tr>			
				<tr>
				    <th>提醒时间:</th>
					<td>						
						<input class="text" type="text" name="alertTime" value="${alert.alertTime}" readonly="readonly"/>
					</td>
					<th>提醒状态:</th>
					<td>						
						<select class="sel-txt" name="status">
						      <option value="1" <#if alert.status == 1>selected="selected"</#if>>未办理</option>
						      <option value="2" <#if alert.status == 2>selected="selected"</#if>>已办理</option>
                         </select>
					</td>
				</tr>
				<tr>
				    <th>内容:</th>
					<td colspan="3">						
						<textarea name="remark" rows="4" cols="65" maxlength="400">${alert.remark}</textarea>
					</td>
				</tr>
				<tr class="act">
				   <td colspan="6">				
						<input type="button" id="saveBtn" class="btn" value="提 交"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>	
				   </td>
			    </tr>	
			</table>								
			</form>
	</div>
</body>
</html>
