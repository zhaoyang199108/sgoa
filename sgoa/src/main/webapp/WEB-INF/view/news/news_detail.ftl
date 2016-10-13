<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="textml; charset=UTF-8">
        <title><#if news.sort=='1'>每日要情</#if>
        		<#if news.sort=='2'>简报</#if></title>
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
			        var url = "${appDomain}/news/content_detail.htm?dRecordid=" + $(this).attr("alt") + "&r=" + Math.random();
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
            <#include "news/menu.ftl">
            <div id="content">
			<h3 class="title"><font size="3"><strong>详细信息</strong></font></h3>
			<form id="newsForm" name="newsForm" action="" method="GET">
 			<table class="ftb">
		                <tr>
		                    <th>
		                    	 标题：
		                    </th>
		                    <td colspan="3">
		                        <input class="title" type="text" name="title" value="${news.title}" readonly="readonly"/>
		                    </td>
		                </tr>
		                 <tr>
		                    <th> 主题词:</th>
		                    <td>
		                        <input class="txt" type="text" name="subject" value="${news.subject}" readonly="readonly"/>
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
		                        <input class="txt" type="text" name="textTime" value="${news.textTime}" readonly="readonly"/>
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
		                     <select id="approvalId" name="approvalId" disabled="disabled">
					          <#list approvalList as approval>
                		       <option value="${approval.id}" <#if approval.id == news.approvalId>selected="selected"</#if>>${approval.approvalName}</option>
                              </#list>
                         </select>
		                    </td>
		                </tr>
		                <tr>
				     	<th>备注:</th>
						<td colspan="3">
						<textarea class="woe" name="remark" readonly="readonly">${news.remark}</textarea>
						</td>
					    </tr>
		                <tr>
		                    <th>
		                       	 内容：
		                    </th>
		                    <td colspan="3">
  								<a style="color:red; text-decoration: underline;" class="neirong" href="#" title="点击查看详细内容" alt="${news.dRecordid}">点击查看详细内容</a>
  		                    </td>
		                </tr>
		          <#list page.newsReviewList as newsReview>
				  <tr>
				    <th>审核意见：
				    	<input alt="${newsReview_index}" class="btn signBtn" name="signBtn" type="hidden" value="手写签名" />
				    </th>
				    <td colspan="3">
				    <label>
					<OBJECT id="SendOut${newsReview_index}" classid="clsid:2294689C-9EDF-40BC-86AE-0438112CA439" codebase=${jsDomain}/js/iWebRevision/iWebRevision.cab#version=6,6,0,294" width=100% height=100%>
                      <param name="WebUrl" value="${jsDomain}/js/iWebRevision/iWebServer.jsp">    <!-- WebUrl:系统服务器路径，与服务器交互操作，如打开签章信息 -->
                      <param name="RecordID" value="${newsReview.opinion}">    <!-- RecordID:本文档记录编号 -->
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
				     <span>负责人:${newsReview.currentOptName}</span>
				   </td>
				  </tr>
				   </#list>
		            </table>
		       </form>
			</div>
		   </div>
		</div>	
</body>
</html>
