<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>审批流程更新页面</title>  
	<base target="_self">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/biz/approval.js"></script>	
	<script type="text/javascript">
		$(document).ready( function() {		
		 		 /** 拟稿人选择按钮事件,弹出对话框选择拟稿人
                 */
                $("input[name=draftsNames]").click(function(){
                
                	var index = $(this).attr("alt");
                    var url = "${appDomain}/common/choose_grpos.htm" + "?ids=" + $("#positionId"+index).val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=yes';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $(this).val(value[1]);
                        $("#positionId"+index).val(value[0]);
                    }
                });
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
		<h3 class="title"><font size="3"><strong>审批流程更新</strong></font></h3>
			<form class="f0" action="${appDomain}/approval/approval_edit.htm" method="POST">
			<input class="text" type="hidden" name="id" value="${approval.id}"/>
				<table class="ftb">
				<tr>
				    <th>审批流程名称:</th>
					<td>						
						<input class="op" type="text" name="approvalName" value="${approval.approvalName}"/>
					</td>
				</tr>
				<tr>
					<th>审批流程类型:</th>
					<td>
						<select name="approvalType">	
							<option value='X' <#if approval.approvalType=='X'>selected="selected"</#if>>通知公告</option>
							<option value='Y' <#if approval.approvalType=='Y'>selected="selected"</#if>>收文</option>
							<option value='Z' <#if approval.approvalType=='Z'>selected="selected"</#if>>发文</option>
							<option value='W' <#if approval.approvalType=='W'>selected="selected"</#if>>发文办事</option>
							<option value='U' <#if approval.approvalType=='U'>selected="selected"</#if>>会议预约</option>
							<option value='J' <#if approval.approvalType=='J'>selected="selected"</#if>>要情简报</option>
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
