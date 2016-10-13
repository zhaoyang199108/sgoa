<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>收文办事</title>  
	<link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>
	<script type="text/javascript">
            $(document).ready(function(){
            
            /**
                 * 收件人选择按钮事件,弹出对话框选择收件人
                 */
                $("#receiverSelect").click(function(){
                    var url = "${appDomain}/common/choose_all_user.htm" + "?ids=" + $("#receiverId").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#receiverIds").val(value[1]);
                        $("#receiverId").val(value[0]);
                    }
                });
              
                 $("#submitBnt").click(function(){
                     $("#status").val(5);
			         $("#doAction").val(5);
			        if(!confirm("是否确定批准?")){
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
                    var url = "${appDomain}/common/choose_approval_users.htm?steps="+$("#steps").val()+"&approvalIds=" + $("#approvalIds").val()+"&r=" + Math.random();
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
                    $("#status").val(4);
			        $("#doAction").val(2);
                    if(!confirm("是否确定提交?")){
                    	return false;
                    }
		        	$('form').attr("action", "${appDomain}/docin/add_docin_work.htm");
                	$('form').submit();
                    
		    });
		    
		    $("#rebackBtn").click(function(){
                    if(!confirm("请选择返回人!")){
                    	return false;
                    }
                    // 添加校验
                    // 选择提交返回人
                    var url = "${appDomain}/common/choose_reback_user3.htm?steps="+$("#steps").val()+"&id=" + $(this).attr("alt") + "&r=" + Math.random();
                    var param = 'dialogWidth=380px;dialogHeight=380px;status=no;center=yes;scroll=no';
                    
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
		        	{
		        		  return false;
		     	    }
                    if (value.length == 0) {
                        alert("未选择返回人,请重新选择!是否现在选择返回人?");
                        return false;
                    }
                    if(value[0].indexOf(",") > -1){
                    	alert("提交返回人只能选择一个!");
                        return false;
                    }
                    $("#nextOptId").val(value[0]);
                    $("#steps").val(value[1]);
                    $("#status").val(4);
			        $("#doAction").val(1);
                    if(!confirm("是否确定返回?")){
                    	return false;
                    }
                    $('form').attr("action", "${appDomain}/docin/dooutin_reback.htm");
                    $('form').submit();
		    	
			    });
                
            });
        </script>
<script language=javascript>
			//作用：打印页
			function PrintPage() { 
			  var pwin=window.open("","print"); 
			  pwin.document.write(Page.innerHTML); 
			  pwin.print(); 
			  //pwin.close();
			}
	</script>
</head>
<body>
<div id="main">
	<div class="main_nav">
	<#include "docin/menu.ftl">
		<div id="content">
		<div class="pstty"><h4>文件处理单</h4>
			 <form class="f0" action="${appDomain}/docin/add_docin_work.htm" method="POST">
				<table class="stty">
				    <input type="hidden" name="id" value="${docin.id}"/>
					<input type="hidden"  id="doAction" name="doAction" value=""/>
            		<input type="hidden" id="status" name="status" value="" />
            		<input type="hidden" id="nextOptId" name="nextOptId" value="" />
            		<input type="hidden" id="dRecordid" name="dRecordid" value="${d_recordId}" />
            		<input type="hidden" id="d_templateid" name="d_templateid" value="${docin.dRecordid}" />
					<input class="text" type="hidden" id="steps"  name="steps" value="${stepNext}"  />
					<input type="hidden" id="sort" name="sort" value="${docin.sort}" />
					<input type="hidden" id="category" name="category" value="${docin.category}" />
				 <tr class="yty">
					    <td colspan="3" class="rre">全宗号：
					     
					      <input type="text" name="fondsNum" value="${docin.fondsNum}" readonly="readonly"/> </td>
					   <td colspan="3" class="rre">    
					       全宗名称：
					      <input type="text" name="fondsName" value="${docin.fondsName}" readonly="readonly"/>
					      </td>
					    </tr>
					  <tr>
					    <th width="9%">来文单位：</th>
					    <td>
					     <input type="text" name="fileDept" value="${docin.fileDept}" readonly="readonly"/>
					     </td>
					     <th width="9%">文件编号：</th>
					    <td>
					     <input type="text" name="fileNum" value="${docin.fileNum}" readonly="readonly"/>
					     </td>
					     <th width="9%">缓急程度：</th>
					    <td>
					   	 <#if docin.urgent == ""><input class="text" type="text" value="" readonly="readonly"/></#if>
					      <#if docin.urgent == 1><input class="text" type="text" value="正常" readonly="readonly"/></#if>
	                      <#if docin.urgent == 2><input class="text" type="text" value="加急" readonly="readonly"/></#if>
	                      <#if docin.urgent == 3><input class="text" type="text" value="特急" readonly="readonly"/></#if>
	                      <#if docin.urgent == 4><input class="text" type="text" value="紧急" readonly="readonly"/></#if>
	                      <#if docin.urgent == 5><input class="text" type="text" value="特提" readonly="readonly"/></#if>
					     </td>
					  </tr>
					  <tr>
					    <!--<th width="9%">成文时间：</th>
					    <td>
					     <input type="text" name="textTime" value="${docin.textTime}" readonly="readonly"/>
					     </td>-->
					     <th width="9%">收文时间：</th>
					    <td>
					     <input type="text" name="receiverTime" value="${docin.receiverTime}" readonly="readonly"/>
					     </td>
					     <th width="9%">登记号：</th>
					    <td>
					     <input type="text" name="registerNum" value="${docin.registerNum}" readonly="readonly"/>
					     </td>
					     <th width="9%">办理期限：</th>
					    <td>
					     <input type="text" name="blqx" id="blqx" value="${docin.blqx}" readonly="readonly"/>
					     </td>
					    </tr>
		              <tr>
		                    <th>
		                      	  办事流程：
		                    </th>
		                    <td colspan="3">
		                     <select id="approvalIds" name="approvalIds" disabled="disabled">
					          <#list approvalLists as approval>
                		       <option value="${approval.id}" <#if approval.id == docin.approvalIds>selected="selected"</#if>>	　------  　${approval.approvalName}    　-----　</option>
                              </#list>
                             </select>
		                    </td>
		                    <th>督　　办：</th>
					    <td colspan="3"><input type="checkbox" name="supervise" <#if docin.supervise==1> checked=true</#if> value="1" style="width:auto;"/>是否列为督办</td>
		               </tr>
					  <tr>
					    <th>文件标题：</th>
					    <td colspan="5"><input type="text" name="title" class="wid" value="${docin.title}" readonly="readonly"/></td>
					    </tr>
					   <tr>
					    <th>收件人：</th>
					    <td colspan="5">
					     <input type="hidden" id="receiverId" name="receiverId" value="${docin.receiverId}" />
		                 <input id="receiverIds" name="receiverIds" type="text" value="${docin.receiverName}" readonly="readonly" />
		                 <input id="receiverSelect" type="button" class="btn" value="选择" />
					    </tr>
					  <tr>
					    <th>附　　件：</th>
						<td colspan="5">
						<#list docinFjPage as docinFj>
						<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${docinFj.srcFileName}"/>
						<a class="act-down" href="#" alt="${docinFj.srcFileName}">${docinFj.srcFileName}</a>
						</#list>
						</td>
					  </tr>
			   	<#list drResList as docinReview>
				  <tr>
				    <th>${docinReview.levelName}意见：
				    	<input alt="${docinReview_index}" class="btn signBtn" name="signBtn" type="hidden" value="手写签名" />
				    </th>
				    <td colspan="7">
				    <label>
				    	<div id="SendOutView${docinReview_index}" style="width:500px;min-height:100px; height:auto;font-size:16px;overflow:hidden">${docinReview.opinion}</div>
                    </label>
					
				   </td>
				  </tr>
				   </#list>
				  <tr class="act">
                    <td colspan="6">
	                    <#if approvalDetailForStatus == 'Y'>
						    <input id="submitBnt" class="btn" name="draftBtn" type="button" value="同意" />
						</#if>
						<#if stepNext!=null>
			                <input id="saveBtn" class="btn" name="draftBtn" type="button" value="${pageButtonName}" />
			             </#if>
	                    </td>
                  
                </tr>
		</table>
    </form>
   </div>
</div>
</div>
</div>
</body>
</html>