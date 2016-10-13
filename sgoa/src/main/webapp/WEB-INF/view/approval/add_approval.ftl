<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>审批流程添加页面</title>  
	<base target="_self">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/biz/approval.js"></script>		
	<script type="text/javascript">
		$(document).ready( function() {		
			$("#saveBtn").click( function() {
				// 审批流程名称非空校验
				if(!isEmpty($("input[name=approvalName]")," 审批流程名称不允许为空！")){
					return;
				}
				$('form').submit();
			});
			
			$("#cancelBtn").click( function() {
                $('form').attr("action", "${appDomain}/approval/approval_list.htm");
				$('form').submit();				
			});	  	
			
			$("input[name=stepss]").blur( function() {
				 if(""!=$(this).val()&&null!=$(this).val()){		
						// 步骤顺序数字校验
						if(!isPlusInteger($(this),"步骤顺序必须为数字！")){
							return;
						}					
					}		
			});
		});
	</script>
</head>
<body>
<div class="sow">
		<h3 class="title"><font size="3"><strong>新增审批流程</strong></font></h3>
			<form class="f0" action="${appDomain}/approval/add_approval.htm" method="POST">
			<table class="ftb">
				<tr>
				    <th>审批流程名称:</th>
					<td>						
						<input class="op" type="text" name="approvalName" maxlength="20"/>
					</td>
			    </tr>
			    <tr>
					 <th>审批流程分类:</th>
					<td>						
						<select name="approvalType">
    					 	<option value= X>通知公告</option>
                          	<option value= Y>收文</option>
                          	<option value= Z>发文</option>
                          	<option value= W>发文办事</option>
                          	<option value= U>会议预约</option>
                          	<option value= J>要情简报</option>
                         </select>
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
</body>
</html>
