<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>选择人员</title>
		<base target="_self">
		<link href="${cssDomain}/css/base.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/demo_dept.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/seal.css" type="text/css" rel="stylesheet">
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
		<script type="text/javascript">
		
		    $(document).ready(function(){
		    
		    	
		        /**
		         * 人员选择完成后, 点击确认按钮返回父页面
		         */
		        $("#doneBtn").click(function(){
		            if ($("#loginId").val() == "") {
		                alert("请选择人员！");
		                return false;
		            }
					
		            // 设置返回值数组,用户ID和用户姓名
		            var rtValue = new Array();
		            rtValue[0] = $("#loginId").val();
		            rtValue[1] = $("#userName").val();
		            window.opener = null;
		            window.open('', '_self');
		            window.returnValue = rtValue;
		            window.close();
		        });
		        
		        /**
		         * 人员选择完成后, 点击确认按钮返回父页面
		         */
		        $(".radioBtn").click(function(){
		            $("#loginId").val($(this).val());
		            $("#userName").val($(this).attr("alt"));
		        });
		        
		        /**
		         * 关闭当前页面
		         */
		        $("#closeBtn").click(function(){
		            window.returnValue = new Array();
		            window.close();
		        });
		    });
		</script>
    </head>
    <body>
	     <div class="f0">
    		<div class="wrap">
		    	<input type="hidden" id="loginId" name="loginId" value="" />
		    	<input type="hidden" id="userName" name="userName" value="" />
		        <div class="ku">  
		        <ul class="select-list">
		            <li>
		            </li>
		            <#list selUserList as user>
						<li class="zck">
			            	<input type="radio" class="radioBtn" alt="${user.userName}" name="loginIds" value="${user.loginId}"  <#if user.loginId == selLoginId>checked="true"</#if>/>
			                <span class="uname">${user.userName}</span>
			            </li>
		            </#list>
		        </ul>
		        </div>
		        <input type="button" class="but" id="doneBtn" name="doneBtn" value="提交" />
		        <input type="button"  class="but" id="closeBtn" name="closeBtn" value="关闭" />
	     	</div>
	     </div>
    </body>
</html>