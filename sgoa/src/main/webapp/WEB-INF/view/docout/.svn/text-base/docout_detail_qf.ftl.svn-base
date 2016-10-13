<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="textml; charset=UTF-8">
        <title>发文详细</title>
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
        <script src="${jsDomain}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <link REL="stylesheet" href="${jsDomain}/js/iWebRevision/iWebRevision.css" type="text/css">
		<script type="text/javascript">
	    	$(document).ready(function(){
			    // 增加按钮点击事件
			    $(".neirong").click(function(){
			        var url = "${appDomain}/docout/content_detail.htm?dRecordid=" + $(this).attr("alt") + "&r=" + Math.random();
			        var param = 'dialogWidth=940px;dialogHeight=750px;status=no;center=yes;scroll=yes';
			        var val = window.showModalDialog(url, '', param);
			  	 if (val == 'refresh') {
			            alert("操作成功");
			        }
			    });
			});
			
			//作用：调入签章数据信息
			function LoadSignature(){
				$("input[name='signBtn']").each(function(){
	                document.getElementById('SendOut'+$(this).attr('alt')).LoadSignature();
	            });
			}
		</script>
    </head>

<body onload="LoadSignature();">
      <div id="main">
          <div class="main_nav">
            <#include "docout/menu.ftl">
            <div id="content">
			 <div class="pst"><h4>四川省新闻出版广电局发文</h4>
			<form id="docoutForm" name="docoutForm" action="" method="GET">
 			<table class="st">
		            <tr>
					    <td colspan="6" class="rre">&nbsp;文&nbsp;&nbsp;号：
					     
					      <input type="text" name="docoutNum" value="${docout.docoutNum}" readonly="readonly"/>
					      号 （日期
					      
					      <input type="text" name="textTime" id="textTime" value="${docout.textTime}" readonly="readonly"/>
					      ） 缓急： 
					      <#if docout.urgent == 1><input class="text" type="text" value="正常" readonly="readonly"/></#if>
	                      <#if docout.urgent == 2><input class="text" type="text" value="加急" readonly="readonly"/></#if>
	                      <#if docout.urgent == 3><input class="text" type="text" value="特急" readonly="readonly"/></#if>
	                      <#if docout.urgent == 4><input class="text" type="text" value="特提" readonly="readonly"/></#if>
					      密级：      
					      <#if docout.security == 1><input class="text" type="text" value="普通" readonly="readonly"/></#if>
	                      <#if docout.security == 2><input class="text" type="text" value="加密" readonly="readonly"/></#if>
					      </td>
					    </tr>
					<#list page.docoutReviewList as docoutReview>
					  <tr>
					    <th>签发：
					    	<input alt="${docoutReview_index}" class="btn signBtn" name="signBtn" type="hidden" value="手写签名" />
					    </th>
					    <td colspan="5">
					    <label>
						<OBJECT id="SendOut${docoutReview_index}" classid="clsid:2294689C-9EDF-40BC-86AE-0438112CA439" codebase=${jsDomain}/js/iWebRevision/iWebRevision.cab#version=6,6,0,294" width=100% height=100%>
	                      <param name="WebUrl" value="${jsDomain}/js/iWebRevision/iWebServer.jsp">    <!-- WebUrl:系统服务器路径，与服务器交互操作，如打开签章信息 -->
	                      <param name="RecordID" value="${docoutReview.opinion}">    <!-- RecordID:本文档记录编号 -->
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
				     <span>负责人:
				   <input class="txt"  type="hidden" id="currentOptId" name="currentOptId" value="" />${docoutReview.currentOptName}</span>
					   </td>
					  </tr>
					   </#list>
					   <tr>
					    <th width="9%">主　　送：</th>
					    <td colspan="5">
					     <input type="hidden"  id="mainSend" name="mainSend" value="${docout.mainSend}" />
		                 <input id="mainSendName" class="wid" name="mainSendName" type="text" value="${docout.mainSendName}" readonly="readonly" />
					      <br /></td>
					    </tr>
					  <tr>
					    <th height="20">抄　　送：</th>
					    <td colspan="5">
					    <input type="hidden" id="copySend" name="copySend" value="${docout.copySend}" />
		                 <input id="copySendName" class="wid" name="copySendName" type="text" value="${docout.copySendName}" readonly="readonly" />
					    </td>
					    </tr>
					  <tr>
					    <th>拟稿单位：</th>
					    <td >
					      <input class="text" type="text"  value="${docout.draftsDeptName}" readonly="readonly"/>
					   </td>
					    <th >拟　　稿：</th>
					    <td ><input type="text" id="draftsId" value="${docout.draftsName}" readonly="readonly"/></td>
					    <th >核　　稿：</th>
					    <td ><input type="text" name="reviewId" value="${reviewName}"/></td>
					  </tr>
					  <tr>
					    <th>印　　刷：</th>
					    <td><input type="text" name="printing" value="${docout.printing}" readonly="readonly"/></td>
					    <th>校　　对：</th>
					    <td><input type="text" name="proofread" value="${proofreadName}"/></td>
					    <th>份　　数：</th>
					    <td><input type="text" name="copies" value="${docout.copies}" readonly="readonly"/></td>
					  </tr>
					  <tr>
		                      <th>
		                      	  流程名称：
		                    </th>
		                    <td colspan="5">
		                     <select id="approvalId" name="approvalId" disabled="disabled">
					          <#list approvalList as approval>
                		       <option value="${approval.id}" <#if approval.id == docout.approvalId>selected="selected"</#if>>	　------  　${approval.approvalName}    　-----　</option>
                              </#list>
                             </select>
		                    </td>
		                </tr>
					  <tr>
					    <th>主 题 词：</th>
					    <td colspan="5">
					      <input type="text" name="subject" class="wid"  value="${docout.subject}" readonly="readonly"/>
					    </td>
					    </tr>
					  <tr>
					    <th>标　　题：</th>
					    <td colspan="5"><input type="text" name="title" class="wid"  value="${docout.title}" readonly="readonly"/></td>
					    </tr>
		                <tr>
		                    <th>
		                       	 内　　容：
		                    </th>
		                    <td colspan="5">
  								<a style="color:red; text-decoration: underline;" class="neirong" href="#" title="点击查看详细内容" alt="${docout.dRecordid}">点击查看详细内容</a>
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
