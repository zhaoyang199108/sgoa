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
            // 日期控件
			$("input[name=textTime]").click(function(){
				WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'});
			});
                $("#draftBtn").click(function(){
                	// 提示用户确认信息
                    if(!confirm("确定保存为草稿?")){
                    	return false;
                    }
                	// 添加校验
                	$('form').attr("action", "${appDomain}/news/draft_news.htm?edit=true");
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
                    $("#enabled").val(1);
                    if(!confirm("是否确定提交?")){
                    	return false;
                    }
		    	 if(DoCheckSubmit())
                    {
                    	$('form').submit();
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
	eWebOffice1.WebUrl = "${jsDomain}/js/eWebOffice/eWebNewsAction.jsp";
	eWebOffice1.RecordID = "${news.dRecordid}";
	eWebOffice1.SetTitleIcon ("${appDomain}/images/rr.gif");
	eWebOffice1.TitleCaption="四川省新闻出版广电局政务系统";
	eWebOffice1.WebOpen();
</script>
    </head>
    <body>
		<div id="main">
          <div class="main_nav">
            <#include "news/menu.ftl">
            <div id="content">
		        <form class="f0" action="${appDomain}/news/edit_news.htm" enctype="multipart/form-data" method="POST">
		        	<input type="hidden" id="currentOptId" name="currentOptId" value="${news.currentOptId}" />
		        	<input type="hidden" id="nextOptId" name="nextOptId" value="" />
		        	<input type="hidden" id="status" name="status" value="" />
		        	<input type="hidden" id="dRecordid" name="dRecordid" value="${news.dRecordid}" />
		        	<input type="hidden" id="enabled" name="enabled" value="" />
		        	<input class="text" type="hidden" id="step"  name="step" value="1"  />
		        	<input type="hidden" id="id" name="id" value="${news.id}" />
		            <table class="ftb">
		                <tr>
		                    <th>
		                    	 标题：
		                    </th>
		                    <td colspan="3">
		                        <input class="title" type="text" name="title" value="${news.title}" />
		                    </td>
		                </tr>
		                 <tr>
		                    <th> 主题词:</th>
		                    <td>
		                        <input class="txt" type="text" name="subject" value="${news.subject}" />
		                    </td>
		                    <th>
		                      	  拟稿人：
		                    </th>
		                    <td>
		                        <input type="text" id="draftsId" value="${news.draftsName}" readonly="readonly"/>
		                    </td>
		                </tr>
		                <tr>
		                     <th>
		                      	  发布时间：
		                    </th>
		                    <td>
		                        <input class="txt" type="text" name="textTime" value="${news.textTime}" />
		                    </td>
		                    <th> 拟稿部门:</th>
		                    <td>
							    <input class="text" type="text"  value="${news.draftsDeptName}" readonly="readonly"/>
		                    </td>
		                </tr>
		               <tr>
		                     <th>
		                      	  流程名称：
		                    </th>
		                    <td colspan="3">
		                     <select id="approvalId" name="approvalId">
					          <#list approvalList as approval>
                		       <option value="${approval.id}" <#if approval.id == news.approvalId>selected="selected"</#if>>${approval.approvalName}</option>
                              </#list>
                         </select>
		                    </td>
		                </tr>
		                <tr>
				     	<th>备注:</th>
						<td colspan="3">
						<textarea class="woe" name="remark">${news.remark}</textarea>
						</td>
					    </tr>
		                <tr class="act">
		                    <td colspan="4">
		                        <input id="draftBtn" class="btn" name="draftBtn" type="button" value="保存草稿" />
		                        <input id="submitBtn" class="btn" name="draftBtn" type="button" value="确认发布" />
		                        <input id="cancelBtn" class="btn" name="draftBtn" type="reset" value="取消按钮" />
		                    </td>
		                </tr>
		            </table>
		        </form>
		           <!--创建eWebOffice实例-->
			<script type="text/javascript">
			eWebOfficeJS.Create("eWebOffice1", "85%", "700px");
			</script>
			</div>
		   </div>
		</div>	
    </body>
</html>