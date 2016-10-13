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
				$('form').attr("action","${appDomain}/resShareDown/download_file.htm");
				$('form').submit();
			});	
			
			    // 增加按钮点击事件
			    $(".neirong").click(function(){
			        var url = "${appDomain}/sw/content_detail.htm?dRecordid=" + $(this).attr("alt") + "&r=" + Math.random();
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
            <#include "sw/menu.ftl">
            <div id="content">
			 <div class="pstty"><h4>文件处理单</h4>
			<form id="swForm" name="swForm" action="" method="GET">
 			<table class="stty">
		           	  	<tr class="yty">
					    <td colspan="3" class="rre"><B>全宗号：</B>
					     
					      <input type="text" name="fondsNum" value="${sw.fondsNum}" readonly="readonly"/> </td>
					   <td colspan="3" class="rre">    
					       <B>全宗名称：</B>
					      
					      <input type="text" name="fondsName" value="${sw.fondsName}" readonly="readonly"/>
					      </td>
					    </tr>
					  <tr>
					    <th width="9%">来文单位：</th>
					    <td>
					     <input type="text" name="fileDept" value="${sw.fileDept}" readonly="readonly"/>
					     </td>
					     <th width="9%">文件编号：</th>
					    <td>
					     <input type="text" name="fileNum" value="${sw.fileNum}" readonly="readonly"/>
					     </td>
					     <th width="9%">缓急程度：</th>
					    <td>
					      <#if sw.urgent == ""><input class="text" type="text" value="" readonly="readonly"/></#if>
					      <#if sw.urgent == 1><input class="text" type="text" value="正常" readonly="readonly"/></#if>
	                      <#if sw.urgent == 2><input class="text" type="text" value="加急" readonly="readonly"/></#if>
	                      <#if sw.urgent == 3><input class="text" type="text" value="特急" readonly="readonly"/></#if>
	                      <#if sw.urgent == 4><input class="text" type="text" value="紧急" readonly="readonly"/></#if>
	                      <#if sw.urgent == 5><input class="text" type="text" value="特提" readonly="readonly"/></#if>
					     </td>
					  </tr>
					  <tr>
					    <!--<th width="9%">成文时间：</th>
					    <td>
					     <input type="text" name="textTime" value="${sw.textTime}" readonly="readonly"/>
					     </td>-->
					     <th width="9%">收文时间：</th>
					    <td>
					     <input type="text" name="receiverTime" value="${sw.receiverTime}" readonly="readonly"/>
					     </td>
					     <th width="9%">登记号：</th>
					    <td>
					     <input type="text" name="registerNum" value="${sw.registerNum}" readonly="readonly"/>
					     </td>
					     <th width="9%">密　　级：</th>
					    <td>
					      <#if sw.security == ""><input class="text" type="text" value="" readonly="readonly"/></#if>
					      <#if sw.security == 1><input class="text" type="text" value="普通" readonly="readonly"/></#if>
	                      <#if sw.security == 2><input class="text" type="text" value="加密" readonly="readonly"/></#if>
					     </td>
					    </tr>
					  <tr>
		                    <th>督　　办：</th>
					   		 <td colspan="5"><input type="checkbox" name="supervise" <#if sw.supervise==1> checked=true</#if> value="1" disabled="disabled" style="width:auto;"/></td>
		               </tr>
					  <tr>
					    <th>文件标题：</th>
					    <td colspan="5"><input type="text" name="title" class="wid" value="${sw.title}" readonly="readonly"/></td>
					    </tr>
					  <tr>
					    <th>收件人：</th>
					    <td colspan="5">
					     <input type="hidden" id="receiverId" name="receiverId" value="${sw.receiverId}" />
		                 <input id="receiverIds" name="receiverIds" class="wid" type="text" value="${sw.receiverName}" readonly="readonly" />
					    </tr>
					  <tr>
					    <th>附　　件：</th>
					    <input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${sw.srcFileName}"/>
						<td colspan="5"><a class="act-down" href="#" alt="${sw.srcFileName}">${sw.srcFileName}</a>
						</td>
					  </tr>
				    <tr>
		            </table>
		       </form>
			</div>
		   </div>
		   </div>
		</div>	
</body>
</html>
