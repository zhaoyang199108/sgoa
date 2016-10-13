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
        <script type="text/javascript">
            $(document).ready(function(){
			
                
                $("#openBtn").click(function(){
                	
                	$("#isOpen").val("Y");
                	// 添加校验
                    $('form').submit();
                });
                
                $("#closeBtn").click(function(){
	                $("#isOpen").val("N");
                  	$('form').submit();
		    	
			    });
			});
        </script>
    </head>
    <body>
		<div id="main">
          <div class="main_nav">
            <#include "seal/menu.ftl">
            <div id="content">
           <div class="pstty"><h4>IP功能开启设置</h4>
		        <form class="f0" action="${appDomain}/ipset/ipset_edit.htm" enctype="multipart/form-data" method="POST">
		        	<input type="hidden" id="isOpen" name="isOpen" value="" />
		        	<input type="hidden" id="id"  name="id" value="1"  />
		        	<#if ipSet.isOpen == 'Y'>
		        		<a id="closeBtn" class="closebtn" name="closeBtn" href="#"></a>
		        	<#elseif ipSet.isOpen == 'N'>
		        		<a id="openBtn" class="openbtn" name="openBtn" href="#"></a>
		        	</#if>
		        </form>
			</div>
		   </div>
		   </div>
		</div>	
    </body>
</html>