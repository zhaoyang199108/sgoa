<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改用户</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
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
		    
		    /**
		     * 部门选择事件
		     */
		    $("input[name=deptName]").click(function(){
		        var url = "${appDomain}/common/choose_dept.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=510px;dialogHeight=480px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
                if(val==undefined) {
		        		return false;
		     	}
                if (val.length > 0) {
                    $("#deptName").val(val[1]);
                    $("#deptId").val(val[0]);
                }
		    });
		     /**
		     * 修改密码事件
		     */
		       $("#isPass").click(function() {
		       
                if (!!$("#isPass").attr("checked")) {
					$("#password").removeAttr("readonly"); //去除readonly属性
	                $('#password').val("");
                }else{
                	$("#password").attr({ readonly: 'true' });
                	$('#password').val($('#passwordTemp').val());
                }
            });
		    /**
		     * 职务下拉框选择事件
		     */
		    $("input[name=grpoName]").click(function(){
		        var url = "";
		        if ($('#positionId').val() == "") {
		        	url = "${appDomain}/common/choose_grpo.htm?r=" + Math.random();
		        } else {
		        	url = "${appDomain}/common/choose_grpo.htm?id="+$('#positionId').val()+"&r=" + Math.random();
		        }
		        var param = 'dialogWidth=450px;dialogHeight=400px;status=no;center=yes;scroll=no';
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
		    
			$("#updateBtn").click( function() {
				  // 登录ID非空校验
				if(!isEmpty($("input[name=loginId]"),"登录ID不允许为空！")){
					return;
				}				
				// 用户密码非空
				if(!isEmpty($("input[name=password]"),"用户密码不允许为空！")){
					return;
				}				
				// 姓名非空校验
				if(!isEmpty($("input[name=userName]"),"姓名不允许为空！")){
					return;
				}
				
				if(""!=$("input[name=officeTell]").val()&&null!=$("input[name=officeTell]").val()){		
					// 办公室号码数字校验
					if(!isPlusInteger($("input[name=officeTell]"),"办公室号码数字校验必须为数字！")){
						return;
					}					
				}				
				if(""!=$("input[name=officeTell]").val()&&null!=$("input[name=officeTell]").val()){	
					// 是否为电话号码校验
					if(!isPhone($("input[name=officeTell]"),"办公室电话输入不正确！请重新输入")){
						return;
					}
				}
				if(""!=$("input[name=phoneNo]").val()&&null!=$("input[name=phoneNo]").val()){	
					// 手机号码校验
					if(!isPlusInteger($("input[name=phoneNo]"),"手机号码输入不正确！请重新输入")){
						return;
					}
				}			
				if(""!=$("input[name=email]").val()&&null!=$("input[name=email]").val()){	
					// 电子邮箱是否合法校验
					if(!isEmail($("input[name=email]"),"电子邮箱不合法！请重新输入")){
						return;
					}
				}
				if(""!=$("input[name=urgentUserTell]").val()&&null!=$("input[name=urgentUserTell]").val()){	
					// 紧急联系电话校验
					if(!isMobile($("input[name=urgentUserTell]"),"紧急联系电话输入不正确！请重新输入")){
						return;
					}
				}		
			    var item = $("input[name=chkItem]:checked").val();	
			    
			    if($("#userNameIsExist").val() == "1"){
					alert("此用户名已经使用！请重新输入用户名！");
            		$("#userName").focus();
					$("#userName").css('borderColor','red');
			    	return;
			    }
				$('form').submit();
			});
			
			$("#userName").change(function(){
			  	// 判断用户名是否存在
		        $.ajax({
		            type: 'GET',
		            contentType: 'application/json',
		            url: '${appDomain}/user/user_name_exist.htm',
		            dataType: 'json',
		            data: 'userName=' + encodeURI(encodeURI($("#userName").val())) + '&r=' + Math.random(),
		            success: function(data){
		            	// 从Controller里取得对象数组
		            	var isExist = data.isExist;
		            	if (isExist) {
		            		alert("此用户名已经使用！请重新输入用户名！");
		            		$("#userName").focus();
							$("#userName").css('borderColor','red');
							$("#userNameIsExist").val("1");
		            		return;
		            	} else {
		            		$("#userNameIsExist").val("");
		            	}
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		                alert("取得用户信息失败！");
		            }
		        });
			});
		});
	</script>
</head>
<body>
<div id="main">
	<div class="main_nav">
	<#include "user/menu.ftl">
	<div id="content"> 
			<h3 class="title"><font size="3"><strong>更新用户</strong></font></h3>
			<form class="f0" action="${appDomain}/user/edit_user.htm" method="POST">
				<input type="hidden" name="id"  value="${user.id}"/>
				<input type="hidden" id="passwordTemp" name="passwordTemp"  value="${user.password}"/>
				<input type="hidden" id="userNameIsExist" value=""/>
				<table class="ftb">
				<tr>
				    <th>登录ID:</th>
					<td>						
						<input class="text" type="text" readonly="readonly" name="loginId" value="${user.loginId}" maxlength="20"/>
					</td>
					<th>用户密码:</th>
					<td>		
						<input class="iowoe" type="password" id="password" name="password" value="${user.password}" maxlength="32" readonly="readonly"/>
						<input class="passuip" type="checkbox" id="isPass" name="isPass" value="1" /> <span style="color:red;">是否重置</span>			
					</td>
				</tr>
				<tr>
				    <th>姓名:</th>
					<td>						
						<input class="text" type="text" id="userName" name="userName" value="${user.userName}" maxlength="20"/>
					</td>
					<th>性别:</th>
					<td>						
						<select name="gender" style="width:154px;">
        					<option value=1 <#if user.gender == 1>selected="selected"</#if>>男</option>
                          	<option value=0 <#if user.gender == 0>selected="selected"</#if>>女</option>
                         </select>
					</td>
				</tr>
				<tr>
				    <th>部门:</th>
					<td>	
					    <input class="text" type="text" id="deptName" name="deptName" value="${user.deptName}"/>
						<input class="text" type="hidden" id="deptId" name="deptId" value="${user.deptId}"/>					
					</td>
					<th>职务:</th>
					<td>
                    <input class="text" type="text" name="levelName" value="${user.levelName}"/>		
					</td>
				</tr>
				<tr>
				    <th>职责:</th>
					<td>
					    <input class="text" type="text" id="grpoName" name="grpoName" value="${user.grpoName}"/>
						<input class="text" type="hidden" id="positionId" name="positionId" value="${user.positionId}"/>	
					</td>
					<th>办公室电话:</th>
					<td>						
						<input class="text" type="text" name="officeTell" value="${user.officeTell}" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<th>个人电话:</th>
					<td>
						<input class="text" type="text" name="phoneNo" value="${user.phoneNo}" maxlength="11"/>
					</td>
					<th>家庭住址:</th>
					<td>						
						<input class="text" type="text" name="homeAddress" value="${user.homeAddress}" maxlength="120"/>
					</td>
				</tr>
				<tr>
				    <th>电子邮箱:</th>
					<td>
						<input class="text" type="text" name="email" value="${user.email}" maxlength="40"/>
					</td>
					<th>紧急联系人:</th>
					<td>						
						<input class="text" type="text" name="urgentUserName" value="${user.urgentUserName}" maxlength="20"/>
					</td>
				</tr>
				<tr>
				    <th>紧急联系电话:</th>
					<td>						
						<input class="text" type="text" name="urgentUserTell" value="${user.urgentUserTell}" maxlength="11"/>
					</td>
					<th>出生日期:</th>
					<td>
						<input class="text" type="text" name="birthday" value="${user.birthday}" maxlength="10"/>
					</td>
				</tr>
				<tr>
				    <th>身份证号:</th>
					<td>						
						<input class="text" type="text" name="idNumber" value="${user.idNumber}" maxlength="18"/>
					</td>
					<th>卡号:</th>
					<td>						
						<input class="text" type="text" name="cardNo" value="${user.cardNo}" maxlength="20"/>
					</td>
				</tr>
				<tr>
				    <th>排序号:</th>
					<td>						
						<input class="text" type="text" name="sorting" value="${user.sorting}"/>
					</td>
					<th>昵称:</th>
					<td>						
						<input class="text" type="text" name="ncName" value="${user.ncName}"/>
					</td>
				</tr>
				<tr>
				    <th>备注信息:</th>
					<td colspan="3">						
						<textarea name="remark" rows="4" cols="58" maxlength="400">${user.remark}</textarea>
					</td>
				</tr>
				
				<tr class="act">
				   <td colspan="4">													
						<input type="button" id="updateBtn" class="btn" value="提 交"/>
						<input type="reset" value="重 置" class="btn" />	
				   </td>
				</tr>
				</table>				
				</ul>
			</form>
	</div>
	</div>
	</div>
</body>
</html>
