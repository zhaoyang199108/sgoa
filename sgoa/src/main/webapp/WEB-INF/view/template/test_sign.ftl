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
        <script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
        <link REL="stylesheet" href="${jsDomain}/js/iWebRevision/iWebRevision.css" type="text/css">
        <script type="text/javascript">
            $(document).ready(function(){
				
				// 提交按钮
                $("#submitBtn").click(function(){
                    if(!confirm("是否确定提交?")){
                    	return false;
                    }
                    if(SaveSignature()) {
                    	$('form').submit();
                    }
                });
                
                // 手写签名按钮
                $("#signBtn").click(function(){
                    document.getElementById('SendOut').LoadSignature();
                });
            });
        </script>
        
        
        <script language=javascript>
			
			
			
			
			
		</script>
    </head>
    <body onload="LoadSignature();">
		<div id="main">
          <div class="main_nav">
            <#include "seal/menu.ftl">
            
            <div id="content">
		        <form class="f0" action="${appDomain}/template/add_sign.htm" method="POST">
		            <table class="ftb">
		                <tr>
		                    <th>
		                    	 标题：
		                    </th>
		                    <td colspan="5">
		                        <input class="title" type="text" name="title" value="" />
		                    </td>
		                </tr>
		                <tr>
		                    <th>
		                       	 内容：
		                       	<input id="signBtn" class="btn" name="signBtn" type="button" value="手写签名" />
		                    </th>
		                    <td colspan="5">
		                        <OBJECT id="SendOut" name="SendOut" classid="clsid:2294689C-9EDF-40BC-86AE-0438112CA439" codebase="${jsDomain}/js/iWebRevision/iWebRevision.cab#version=6,6,0,294" width=100% height=100%>
                                  <param name="WebUrl" value="${jsDomain}/js/iWebRevision/iWebServer.jsp">    <!-- WebUrl:系统服务器路径，与服务器交互操作，如打开签章信息 -->
                                  <param name="RecordID" value="SX20131231131534">    <!-- RecordID:本文档记录编号 -->
                                  <param name="FieldName" value="SendOut">         <!-- FieldName:签章窗体可以根据实际情况再增加，只需要修改控件属性 FieldName 的值就可以 -->
                                  <param name="UserName" value="${loginId}">    <!-- UserName:签名用户名称 -->
                                  <param name="Enabled" value="1">  <!-- Enabled:是否允许修改，0:不允许 1:允许  默认值:1  -->
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
		                    </td>
		                </tr>
		                <tr class="act">
		                    <td colspan="6">
		                        <input id="submitBtn" class="btn" name="draftBtn" type="button" value="确认发布" />
		                        <input id="cancelBtn" class="btn" name="draftBtn" type="button" value="取消按钮" />
		                    </td>
		                </tr>
		            </table>
		        </form>
			</div>
		   </div>
		</div>	
    </body>
</html>