<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Untitled Document</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
       	<script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
            // 设置日期默认值
			$("#textTime").val(getToday());
			// 日期控件
			$("input[name=textTime]").click(function(){
				WdatePicker();
			});
			
			 /**
                 * 主送人选择按钮事件,弹出对话框选择主送人
                 */
                $("#receiverSelect").click(function(){
                    var url = "${appDomain}/common/choose_all_user.htm" + "?ids=" + $("#mainSend").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#mainSends").val(value[1]);
                        $("#mainSend").val(value[0]);
                    }
                });
                
                 /**
                 * 抄送人选择按钮事件,弹出对话框选择抄送人
                 */
                $("#receiversSelect").click(function(){
                    var url = "${appDomain}/common/choose_all_user.htm" + "?ids=" + $("#copySend").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#copySends").val(value[1]);
                        $("#copySend").val(value[0]);
                    }
                });
                
                $("#draftBtn").click(function(){
                	// 提示用户确认信息
                    if(!confirm("确定保存为草稿?")){
                    	return false;
                    }
                	// 添加校验
                	$('form').attr("action", "${appDomain}/docout/draft_docout.htm");
                	 if(DoCheckSubmitForNg())
                    {
                    	$('form').submit();
                    } 
                });
                
                $("#submitBtn").click(function(){
	                 // 标题非空校验
					if(!isEmpty($("input[name=title]"),"标题不允许为空！")){
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
                    if(DoCheckSubmit())
                    {
                    	$('form').submit();
                    } 
		    	
			    });
			    
			    // 加密文件提示
			    $("#security").change(function(){
                	// 提示用户确认信息
                    if($(this).val() == 2){
                    	alert("本系统禁止上传涉密文件！");
                    	$(this).val(1);
                    }
                });
			});
        </script>
	<script type="text/javascript">
		function DoCheckSubmit(){
		  try{    	
		  	eWebOffice1.WebSaveVersion("版本描述", false)
		    return eWebOffice1.WebSave();
		}catch(e){
		    alert("请选安装eWebOffice控件，再操作！");
		    return false;
		}
		}
	
		function DoCheckSubmitForNg(){
		  try{    	
		    return eWebOffice1.WebSave();
		}catch(e){
		    alert("请选安装eWebOffice控件，再操作！");
		    return false;
		}
		}
	</script>
<script type="text/javascript" for="eWebOffice1" event="OnInit()">
    eWebOffice1.QuickBarCommentVisible = false;
</script>
<script type="text/javascript" for="eWebOffice1" event="OnLoad()">
	eWebOffice1.WebUrl = "${jsDomain}/js/eWebOffice/eWebDocoutAction.jsp";
	eWebOffice1.RecordID = "${d_recordId}";
	eWebOffice1.UserName = "${d_userName}";
	eWebOffice1.FileType = "${d_fileType}";
	eWebOffice1.SetTitleIcon ("${appDomain}/images/rr.gif");
	eWebOffice1.TitleCaption="四川省新闻出版广电局政务系统";
	eWebOffice1.WebNew();
</script>
    </head>
    <body>
		<div id="main">
          <div class="main_nav">
            <#include "docout/menu.ftl">
            <div id="content">
           <div class="pst"><h4>四川省新闻出版广电局发文</h4>
		        <form class="f0" action="${appDomain}/docout/add_docout.htm" enctype="multipart/form-data" method="POST">
		        	<input type="hidden" id="currentOptId" name="currentOptId" value="" />
		        	<input type="hidden" id="nextOptId" name="nextOptId" value="" />
		        	<input type="hidden" id="status" name="status" value="" />
		        	<input type="hidden" id="dRecordid" name="dRecordid" value="${d_recordId}" />
		        	<input class="text" type="hidden" id="step"  name="step" value="1"  />
		            <table class="st">
		            <tr>
					    <td colspan="6" class="rre">&nbsp;文&nbsp;&nbsp;号：
					     
					      <input type="text" name="docoutNum" value="川新出广"/>
					      号 （日期
					      
					      <input type="text" name="textTime" id="textTime" value=""/>
					      ） 缓急： 
					      <select name="urgent">
                					 	<option value= 1>正常</option>
                                      	<option value= 2>加急</option>
                                      	<option value= 3>特急</option>
                                      	<option value= 4>特提</option>
                         </select>
					      密级：      
					      <select name="security" id="security">
                					 	<option value= 1>普通</option>
                                      	<option value= 2>加密</option>
                         </select></td>
					    </tr>
					  <tr>
					    <th width="9%">主　　送：</th>
					    <td colspan="5">
					     <input type="hidden" id="mainSend" name="mainSend" value="" />
		                 <input id="mainSends" name="mainSends" type="text" value="" readonly="readonly" />
		                 <input id="receiverSelect" type="button" class="btn" value="选择" />
					      <br /></td>
					    </tr>
					  <tr>
					    <th height="20">抄　　送：</th>
					    <td colspan="5">
					    <input type="hidden" id="copySend" name="copySend" value="" />
		                 <input id="copySends" name="copySends" type="text" value="" readonly="readonly" />
		                 <input id="receiversSelect" type="button" class="btn" value="选择" />
					    </td>
					    </tr>
					  <tr>
					    <th>拟稿单位：</th>
					    <td >
					      <input class="text" type="hidden" name="draftsDeptId" value="${dept.id}"  />
						  <input class="text" type="text"  value="${dept.deptName}" readonly="readonly"/>
						  <input type="hidden" id="draftsId" name="draftsId" value="${user.loginId}" />
					   </td>
					    <th >拟　　稿：</th>
					    <td ><input type="text" id="draftsId" value="${user.userName}" readonly="readonly"/></td>
					    <th >核　　稿：</th>
					    <td ><input type="text" name="reviewId" value=""/></td>
					  </tr>
					  <tr>
					    <th>印　　刷：</th>
					    <td><input type="text" name="printing" value=""/></td>
					    <th>校　　对：</th>
					    <td><input type="text" name="proofread" value=""/></td>
					    <th>份　　数：</th>
					    <td><input type="text" name="copies" value=""/></td>
					  </tr>
					  <tr>
		                     <th>
		                      	发文流程：
		                    </th>
		                    <td>
		                      <select id="approvalId" name="approvalId">
						         <#list approvalList as approval>
	                             <option value="${approval.id}">	　------  　${approval.approvalName}    　-----　</option>
	                             </#list>
                              </select>
		                    </td>
		                    <th>督　　办：</th>
					    	<td><input type="checkbox" name="supervise" value="1" checked="true" style="width:auto;" />是否列为督办</td>
					    	
					    	<th>公　　开：</th>
					    	<td><input type="checkbox" name="open" value="1" checked="true" style="width:auto;" />是否列为公开</td>
		                </tr>
					  <tr>
					    <th>主 题 词：</th>
					    <td colspan="5">
					      <input type="text" name="subject" class="wid" value=""/>
					    </td>
					    </tr>
					  <tr>
					    <th>标　　题：</th>
					    <td colspan="5"><input type="text" name="title" class="wid" value=""/></td>
					    </tr>
		             <tr class="act">
		                    <td colspan="6">
		                        <input id="draftBtn" class="btn" name="draftBtn" type="button" value="保存草稿" />
		                        <input id="submitBtn" class="btn" name="draftBtn" type="button" value="确认提交" />
		                        <input id="cancelBtn" class="btn" name="draftBtn" type="reset" value="取消按钮" />
		                    </td>
		                </tr>
		            </table>
		        </form>
		        <!--创建eWebOffice实例-->
			<script type="text/javascript">
			eWebOfficeJS.Create("eWebOffice1", "100%", "700px");
			</script>
			</div>
		   </div>
		   </div>
		</div>	
    </body>
</html>