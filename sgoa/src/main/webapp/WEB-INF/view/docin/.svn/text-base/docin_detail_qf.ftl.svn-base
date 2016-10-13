<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="textml; charset=UTF-8">
        <title>收文详细</title>
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
        <script src="${jsDomain}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <link REL="stylesheet" href="${jsDomain}/js/iWebRevision/iWebRevision.css" type="text/css">
		<script type="text/javascript">
	    	$(document).ready(function(){
	    	
	    	//文件下载
			$(".act-down").click(function(){
				$("#srcFileNameOne").val($(this).attr("alt"));
				$('form').attr("action","${appDomain}/docinShareDown/download_file.htm");
				$('form').submit();
			});	
			
			    // 增加按钮点击事件
			    $(".neirong").click(function(){
			        var url = "${appDomain}/docin/content_detail.htm?dRecordid=" + $(this).attr("alt") + "&r=" + Math.random();
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
            <#include "docin/menu.ftl">
            <div id="content">
			 <div class="pstty"><h4>文件处理单</h4>
			<form id="docinForm" name="docinForm" action="" method="GET">
 			<table class="stty">
		           	  	<tr class="yty">
					    <td colspan="4" class="rre"><B>全宗号：</B>
					     
					      <input type="text" name="fondsNum" value="${docin.fondsNum}" readonly="readonly"/> </td>
					   <td colspan="4" class="rre">    
					       <B>全宗名称：</B>
					      
					      <input type="text" name="fondsName" value="${docin.fondsName}" readonly="readonly"/>
					      </td>
					    </tr>
					  <tr>
					    <th width="9%">来文单位：</th>
					    <td colspan="3">
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
					    <td colspan="3">
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
		                      	收文流程：
		                    </th>
		                    <td colspan="3">
		                      <select id="approvalId" name="approvalId" disabled="disabled">
					          <#list approvalList as approval>
                		       <option value="${approval.id}" <#if approval.id == docin.approvalId>selected="selected"</#if>>	　------  　${approval.approvalName}    　-----　</option>
                              </#list>
                             </select>
		                    </td>
		                    <th>督　　办：</th>
					   		 <td colspan="3"><input type="checkbox" name="supervise" <#if docin.supervise==1> checked=true</#if> value="1" disabled="disabled" style="width:auto;"/></td>
		               </tr>
					  <tr>
					    <th>文件标题：</th>
					    <td colspan="7"><input type="text" name="title" class="wid" value="${docin.title}" readonly="readonly"/></td>
					    </tr>
					  <tr>
					    <th>收件人：</th>
					    <td colspan="7">
					     <input type="hidden" id="receiverId" name="receiverId" value="${docin.receiverId}" />
		                 <input id="receiverIds" name="receiverIds" class="wid" type="text" value="${docin.receiverName}" readonly="readonly" />
					    </tr>
					  <tr>
					    <th>附　　件：</th>
						<td colspan="7">
						<#list docinFjPage as docinFj>
						<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${docinFj.srcFileName}"/>
						<a class="act-down" href="#" alt="${docinFj.srcFileName}">${docinFj.srcFileName}</a>
						</#list>
						</td>
					  </tr>
				   <tr>
					    <th>局　　长<br />意　　见</th>
					    <td colspan="7" height="130" >
					    	<div style="width:700px;min-height:100px; height:auto;font-size:16px;overflow:hidden">${opinion1}</div>
							<br />
					    </td>
					    </tr>
					  <tr>
					    <th>分管领导<br />意　　见</th>
					    <td colspan="7" height="130">
					    	<div style="width:700px;min-height:100px; height:auto;font-size:16px;overflow:hidden">${opinion2}</div>
					    </td>
					    </tr>
					  <tr>
					    <th>承办处室<br />意　　见</th>
					    <td colspan="7" height="80">
					    	<div style="width:700px;min-height:50px; height:auto;font-size:16px;overflow:hidden">${opinion3}</div>
					    </td>
					    </tr>
					  <tr>
					    <th>办公室<br />意　　见</th>
					    <td colspan="7" height="80">
					    	<div style="width:700px;min-height:50px; height:auto;font-size:16px;overflow:hidden">${opinion4}</div>
					    	<br />
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
