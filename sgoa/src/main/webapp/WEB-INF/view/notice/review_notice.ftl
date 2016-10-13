<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>通知公告审批</title>  
	<link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>
	<link REL="stylesheet" href="${jsDomain}/js/iWebRevision/iWebRevision.css" type="text/css">
		<script language="javascript" for=SendOut event="OnMenuClick(vIndex,vCaption)">
		  if (vIndex==10){  //自定义菜单事件
		    alert("这里是“签发”控件自定义菜单演示：清除所有签章、签批信息");
		    SendOut.ClearAll();
		    SendOutStatusMsg("清除所有签章、签批信息成功。");
		  }
		</script>
	<script type="text/javascript">
            $(document).ready(function(){
                $("#draftBtn").click(function(){
                	// 提示用户确认否决
                	 $("#doAction").val(3);
                	 $("#status").val(3);
                    if(!confirm("确定否决申请?")){
                    	return false;
                    }
                	// 添加校验
                	$('form').attr("action", "${appDomain}/notice/add_notice_review.htm");
                	 if(DoCheckSubmit())
                    {
                    if(SaveSignature()) {
                    	$('form').submit();
                    }
                    } 
                });
                
                 $("#submitBnt").click(function(){					
			        $("#status").val(4);
			         $("#doAction").val(4);
			        if(!confirm("是否确定批准?")){
			        	return false;
			        }
                	 if(DoCheckSubmit())
                    {
                    	if(SaveSignature()) {
                    	$('form').submit();
                    }
                    } 
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
			        $("#doAction").val(2);
                    if(!confirm("是否确定提交?")){
                    	return false;
                    }
		        $('form').attr("action", "${appDomain}/notice/add_notice_review.htm");
		    	 if(DoCheckSubmit())
                    {
                    	if(SaveSignature()) {
                    	$('form').submit();
                    }
                    } 
		    });
		    
		    $("#rebackBtn").click(function(){
                    if(!confirm("请选择返回人!")){
                    	return false;
                    }
                    // 添加校验
                    // 选择提交返回人
                    var url = "${appDomain}/common/choose_reback_user1.htm?step="+$("#step").val()+"&id=" + $(this).attr("alt") + "&r=" + Math.random();
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
                    $("#step").val(value[1]);
                    $("#status").val(1);
			        $("#doAction").val(1);
                    if(!confirm("是否确定返回?")){
                    	return false;
                    }
                    $('form').attr("action", "${appDomain}/notice/notice_reback.htm");
		    		 if(DoCheckSubmit())
                    {
                    	if(SaveSignature()) {
                    	$('form').submit();
                    }
                    } 
		    	
			    });
                
                $("#clearBtn").click(function(){
			    	if (eWebOffice1.ViewMode == 0) {
			    		eWebOffice1.AcceptAllRevisions();
			    	} else {
			    		alert("请您选择文档模式后在清除痕迹！如需清除批注，请点击重新批注！");
			    	}
                });
                
                /**
		     	* 修改密码事件
		     	*/
		       $("#isAlert").click(function() {
	                if (!!$("#isAlert").attr("checked")) {
						$("#alertBtn").removeAttr("disabled"); //去除readonly属性
		                $('#alertTime').val("");
		                $('#alertRemark').val("");
	                }else{
	                	$("#alertBtn").attr("disabled", true);
	                }
		        });
		        
		        // 更新按钮点击事件
			    $("#alertBtn").click(function(){
			    	var modeName = "公告";
			    	var busId = "notice";
			        var url = "${appDomain}/alert/add_alert.htm?title=" + encodeURI($("#title").val()) + "&modeName="+encodeURI(modeName)+"&busId="+busId + "&r=" + Math.random();
			        var param = 'dialogWidth=780px;dialogHeight=350px;status=no;center=yes;scroll=no';
			        var val = window.showModalDialog(url, '', param);
			        if (val == 'refresh') {
			            alert("添加提醒成功");
			        }
			    });
			     //文件下载
				$(".act-down").click(function(){
					$("#srcFileNameOne").val($(this).attr("alt"));
					$('form').attr("action","${appDomain}/messageDown/download_file.htm");
					$('form').submit();
				});		
            });
        </script>
<script type="text/javascript">
		function DoCheckSubmit(){
		  try{    	
		    eWebOffice1.RecordID = $("#dRecordid").val();
		  	eWebOffice1.WebSaveVersion("版本描述", false)
		  	eWebOffice1.RecordID = $("#d_templateid").val();
		    return eWebOffice1.WebSave();
		}catch(e){
		    alert("请选安装eWebOffice控件，再操作！");
		    return false;
		}
		}
	</script>
<script type="text/javascript" for="eWebOffice1" event="OnInit()">
	//控件初始化事件
	eWebOffice1.QuickBarCommentVisible = true;
	//标题栏、快捷工具栏、边框等界面相关设置可以在此事件中作，使得界面上不会有转变过程显现
	//如：隐藏快捷工具栏。当访问此网页时，如在OnLoad中设，则会先显示出工具栏，再看到工具栏没了。如在OnInit中设，直接打开就看不到。没有这个变化过程。
	eWebOfficeJS.SetWorkModeOnInit("eWebOffice1", "comment");
</script>
<script type="text/javascript" for="eWebOffice1" event="OnDocumentAfterOpen()">
	//文档打开后触发此事件
	//在此事件中设置初始Office菜单、工具栏、痕迹、保护等。
	eWebOfficeJS.SetWorkModeOnOpen("eWebOffice1", "comment");
</script>
<script type="text/javascript" for="eWebOffice1" event="OnLoad()">
	eWebOffice1.WebUrl = "${jsDomain}/js/eWebOffice/eWebMessageAction.jsp";
	eWebOffice1.RecordID = "${message.dRecordid}";
	eWebOffice1.SetTitleIcon ("${appDomain}/images/rr.gif");
	eWebOffice1.TitleCaption="四川省新闻出版广电局政务系统";
	eWebOffice1.WebOpen();
</script>
<script language=javascript>
			
			//作用：显示SendOut操作状态
			function SendOutStatusMsg(mString){
			  iSendOutStatusBar.innerText=" "+mString;
			}
			
			//作用：调入签章数据信息
			function LoadSignature(){
			  	document.getElementById('SendOut').AppendMenu("9","-");                 //“签发”控件自定义右键菜单
			  	document.getElementById('SendOut').AppendMenu("10","清除所有签批");   //“签发”控件自定义右键菜单
			 	document.getElementById('SendOut').LoadSignature();                    //调用“签发”签章数据信息
    			SendOutStatusMsg(document.getElementById('SendOut').Status);
			}
			
			//作用：保存签章数据信息  
			//保存流程：先保存签章数据信息，成功后再提交到DocumentSave，保存表单基本信息
			function SaveSignature(){
			  if (document.getElementById('SendOut').Modify){                    //判断签章数据信息是否有改动
			    if (!document.getElementById('SendOut').SaveSignature()){        //保存签章数据信息
			      alert("保存签发签批内容失败！");
			      return false;  
			    }
			  }
			  return true;
			}
			
			//作用：SendOut控件切换读取签章的来源方式 （*高级版本提供该功能）
			function chgReadSignatureType(){
			  if (document.getElementById('SendOut').SignatureType=="1"){
			    document.getElementById('SendOut').SignatureType="0";
			    alert("签发：签章来源从数据库中读取！");
			  }
			}
			
			//作用：SendOut控件打开签章窗口
			function SendOutOpenSignature(){
			  document.getElementById('SendOut').ShowDate("",2);
			  if(document.getElementById('SendOut').OpenSignature()){
			    SendOutStatusMsg("签章、签批成功。");
			  }else{
			    SendOutStatusMsg(document.getElementById('SendOut').Status);
			  }
			}
			
			//作用：SendOut控件打开签章窗口
			function SendEditTypeChange(){
			  if (document.getElementById('SendOut').EditType==0){
			    document.getElementById('SendOut').EditType=1;
			    SendOutStatusMsg("当前为文字签批状态。");
			  }
			  else{
			    document.getElementById('SendOut').EditType=0;
			    SendOutStatusMsg("当前为手写签批状态。");
			  }
			}
			
			//作用：打印页
			function PrintPage() { 
			  var pwin=window.open("","print"); 
			  pwin.document.write(Page.innerHTML); 
			  pwin.print(); 
			  //pwin.close();
			}
	</script>
</head>
<body onload="LoadSignature();">
<div id="main">
	<div class="main_nav">
	<#include "notice/menu.ftl">
		<div id="content">
			 <form class="f0" action="${appDomain}/notice/add_notice_review.htm" method="POST">
			  <div class="ct">
				<table class="ftb">
				    <input type="hidden" name="id" value="${message.id}"/>
					<input type="hidden"  id="doAction" name="doAction" value=""/>
            		<input type="hidden" id="status" name="status" value="" />
            		<input type="hidden" id="nextOptId" name="nextOptId" value="" />
            		<input type="hidden" id="dRecordid" name="dRecordid" value="${d_recordId}" />
            		<input type="hidden" id="d_templateid" name="d_templateid" value="${message.dRecordid}" />
					<input class="text" type="hidden" id="step"  name="step" value="${stepNext}"  />
					<input type="hidden" id="opinion" name="opinion" value="${opinionId}" />
				  <tr>
		                    <th>
		                    	 标题：
		                    </th>
		                    <td colspan="3">
		                        <input class="title" type="text" name="title" value="${message.title}" readonly="readonly"/>
		                    </td>
		                </tr>
		                 <tr>
		                    <th> 主题词:</th>
		                    <td>
		                        <input class="txt" type="text" name="subject" value="${message.subject}" readonly="readonly"/>
		                    </td>
		                    <th>
		                      	  拟稿人：
		                    </th>
		                    <td>
		                        <input type="text" id="draftsId" value="${message.draftsName}" readonly="readonly"/>
		                    </td>
		                </tr>
		                <tr>
		                     <th>
		                      	  发布时间：
		                    </th>
		                    <td>
		                        <input class="txt" type="text" name="textTime" value="${message.textTime}" readonly="readonly"/>
		                    </td>
		                    <th> 拟稿部门:</th>
		                    <td>
							    <input class="text" type="text"  value="${message.draftsDeptName}" readonly="readonly"/>
		                    </td>
		                </tr>
		               <tr>
		                     <th>
		                      	  流程名称：
		                    </th>
		                    <td colspan="3">
		                     <select id="approvalId" name="approvalId" disabled="disabled">
					          <#list approvalList as approval>
                		       <option value="${approval.id}" <#if approval.id == message.approvalId>selected="selected"</#if>>${approval.approvalName}</option>
                              </#list>
                         </select>
		                    </td>
		                </tr>
		                <#if message.srcFileName !=null>
		                <tr>
						<th>附件名:</th>
						<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${message.srcFileName}"/>
						<td colspan="3"><a class="act-down" href="#" alt="${message.srcFileName}">${message.srcFileName}</a>
						</td>
						</tr>
						</#if>
		                <tr>
				     	<th>备注:</th>
						<td colspan="3">
						<textarea class="woe" name="remark" readonly="readonly">${message.remark}</textarea>
						</td>
				</tr>
				<#list onePage.messageReviewList as messageReview>
				  <tr>
				    <th>审核意见：
				    	<input alt="${messageReview_index}" class="btn signBtn" name="signBtn" type="hidden" value="手写签名" />
				    </th>
				    <td colspan="3">
				    <label>
					<OBJECT id="SendOut${messageReview_index}" classid="clsid:2294689C-9EDF-40BC-86AE-0438112CA439" codebase="${jsDomain}/js/iWebRevision/iWebRevision.cab#version=6,6,0,294" width=100% height=100%>
                      <param name="WebUrl" value="${jsDomain}/js/iWebRevision/iWebServer.jsp">    <!-- WebUrl:系统服务器路径，与服务器交互操作，如打开签章信息 -->
                      <param name="RecordID" value="${messageReview.opinion}">    <!-- RecordID:本文档记录编号 -->
                      <param name="FieldName" value="SendOut">         <!-- FieldName:签章窗体可以根据实际情况再增加，只需要修改控件属性 FieldName 的值就可以 -->
                      <param name="UserName" value="">    <!-- UserName:签名用户名称 -->
                      <param name="Enabled" value="0">  <!-- Enabled:是否允许修改，0:不允许 1:允许  默认值:1  -->
                      <param name="PenColor" value="#ff0000">     <!-- PenColor:笔的颜色，采用网页色彩值  默认值:#000000  -->
                      <param name="BorderStyle" value="0">    <!-- BorderStyle:边框，0:无边框 1:有边框  默认值:1  -->
                      <param name="EditType" value="0">    <!-- EditType:默认签章类型，0:签名 1:文字  默认值:0  -->
                      <param name="ShowPage" value="0">    <!-- ShowPage:设置默认显示页面，0:电子印章,1:网页签批,2:文字批注  默认值:0  -->
                      <param name="InputText" value="">    <!-- InputText:设置署名信息，  为空字符串则默认信息[用户名+时间]内容  -->
                      <param name="PenWidth" value="2">     <!-- PenWidth:笔的宽度，值:1 2 3 4 5   默认值:2  -->
                      <param name="FontSize" value="11">    <!-- FontSize:文字大小，默认值:11 -->
                      <param name="SignatureType" value="0">    <!-- SignatureType:签章来源类型，0表示从服务器数据库中读取签章，1表示从硬件密钥盘中读取签章，2表示从本地读取签章，并与ImageName(本地签章路径)属性相结合使用  默认值:0 -->
                      <param name="InputList" value="同意\r\n不同意\r\n请上级批示\r\n请速办理">    <!-- InputList:设置文字批注信息列表  -->
                    </OBJECT>
                    </label>
					<br /><br />
				     <span>负责人:${messageReview.currentOptName}</span>
				   </td>
				  </tr>
				   </#list>
			    <tr>
				    <th>审核意见：</th>
				    <td colspan="3">
					<label>
					 <OBJECT id="SendOut" name="SendOut" classid="clsid:2294689C-9EDF-40BC-86AE-0438112CA439" codebase="${jsDomain}/js/iWebRevision/iWebRevision.cab#version=6,6,0,294" width=100% height=100%>
                      <param name="WebUrl" value="${jsDomain}/js/iWebRevision/iWebServer.jsp">    <!-- WebUrl:系统服务器路径，与服务器交互操作，如打开签章信息 -->
                      <param name="RecordID" value="${opinionId}">    <!-- RecordID:本文档记录编号 -->
                      <param name="FieldName" value="SendOut">         <!-- FieldName:签章窗体可以根据实际情况再增加，只需要修改控件属性 FieldName 的值就可以 -->
                      <param name="UserName" value="${loginId}">    <!-- UserName:签名用户名称 -->
                      <param name="Enabled" value="1">  <!-- Enabled:是否允许修改，0:不允许 1:允许  默认值:1  -->
                      <param name="PenColor" value="#ff0000">     <!-- PenColor:笔的颜色，采用网页色彩值  默认值:#000000  -->
                      <param name="BorderStyle" value="0">    <!-- BorderStyle:边框，0:无边框 1:有边框  默认值:1  -->
                      <param name="EditType" value="1">    <!-- EditType:默认签章类型，0:签名 1:文字  默认值:0  -->
                      <param name="ShowPage" value="0">    <!-- ShowPage:设置默认显示页面，0:电子印章,1:网页签批,2:文字批注  默认值:0  -->
                      <param name="InputText" value="">    <!-- InputText:设置署名信息，  为空字符串则默认信息[用户名+时间]内容  -->
                      <param name="PenWidth" value="2">     <!-- PenWidth:笔的宽度，值:1 2 3 4 5   默认值:2  -->
                      <param name="FontSize" value="11">    <!-- FontSize:文字大小，默认值:11 -->
                      <param name="SignatureType" value="0">    <!-- SignatureType:签章来源类型，0表示从服务器数据库中读取签章，1表示从硬件密钥盘中读取签章，2表示从本地读取签章，并与ImageName(本地签章路径)属性相结合使用  默认值:0 -->
                      <param name="InputList" value="同意\r\n不同意\r\n请上级批示\r\n请速办理">    <!-- InputList:设置文字批注信息列表  -->
                    </OBJECT>
					</label>
					<br /><br />
				     <span>负责人:
				   <input class="txt"  type="hidden" id="currentOptId" name="currentOptId" value="" />${userName}</span></td>
				  </tr>
				 
				  <tr>
					<th>
						<input class="passuip" type="checkbox" id="isAlert" name="isAlert" value="1" /> <span style="color:red;">是否提醒</span>
					</th>
					<td colspan="3">
						<input id="alertBtn" class="btn" name="alertBtn" type="button" disabled="true" value="添加提醒" />
					</td>
				  </tr>
				  <tr class="act">
                    <td colspan="4">
                  
					<#if stepNext!=null>
		                <input id="saveBtn" class="btn" name="draftBtn" type="button" value="${pageButtonName}" />
		             </#if>
		           
                    <#if approvalDetailForStatus == 'Y'>
					    <input id="submitBnt" class="btn" name="draftBtn" type="button" value="同意" />
					</#if>
					 <#if approvalDetailForStatus == 'Y'>
                        <input id="draftBtn" class="btn" name="draftBtn" type="button" value="不同意" />
                    </#if>
		             <#if message.draftsId!=message.nextOptId>
		             <input id="rebackBtn" class="btn" name="draftBtn" type="button" alt="${message.id}" value="返 回" />
		              </#if>
                     <input id="clearBtn" class="btn" name="clearBtn" type="button" value="清除痕迹" />
                    </td>
                </tr>
		</table>
	</div>
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
