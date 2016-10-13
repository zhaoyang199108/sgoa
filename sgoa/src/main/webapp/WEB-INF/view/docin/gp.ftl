<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>选择用户</title>
		<base target="_self">
        <link href="${cssDomain}/css/base.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/demo_dept.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/login.css" type="text/css" rel="stylesheet">
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery-1.4.4.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.core-3.1.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/ztree/jquery.ztree.excheck-3.1.js"></script>
	    <script type="text/javascript"  src="${jsDomain}/js/ztree/jquery.ztree.exedit-3.1.js"></script>
		<script type="text/javascript">
		    $(document).ready(function(){
		        /**
		         * 人员选择完成后, 点击确认按钮返回父页面
		         */
		        $("#doneBtn").click(function(){
		        	$('form').submit(); 
		        });
		        
		        /**
		         * 关闭当前页面
		         */
		        $("#closeBtn").click(function(){
		            window.returnValue = new Array();
		            window.close();
		        });
		        
		        $(".radioBtn").each(function(i){
	                if (isExistInList($(this).attr("alt"))) {
	                	$(this).attr("checked",true);
	                }
	            });
		    });
		    
		    /**
		     * 判断当前用户是否已经被选择
		     */
		    function isExistInList(loginId){
		        var isExist = false;
		        var nextOptIds = $("#nextOptId").val();
		        if(nextOptIds != null && nextOptIds != ""){
			        var nextOptId = nextOptIds.split(",");
			        for(var i=0;i<nextOptId.length;i++){
			        	if(loginId == nextOptId[i]){
			        		isExist = true;
		                	break;
			        	}
			        }
			    }
		        return isExist;
		    }
		</script>
    </head>
    <body>
    <form class="f0" action="${appDomain}/docin/gp.htm" method="POST">
    <div class="calog">
    	<div class="f0">
    		<div class="wrap">
		    	<input type="hidden" id="nextOptId" value="${nextOptId}" />
		    	<input type="hidden" id="id" name="id" value="${id}" />
		        <div class="ku">  
		        <ul class="select-list">
		            <li>
		            </li>
		            <#list userList as selUser>
			                <li class="zck" id="li_${selUser.loginId}">
			                <input type="checkbox" class="radioBtn" name="loginId" alt="${selUser.loginId}" value="${selUser.loginId}" <#if selUser.loginId == nextOptId>checked="true"</#if>/>
			                <span>
			                	${selUser.userName}
			                	<#if selUser.levelName != null>
			                		(${selUser.levelName})
			                	</#if>
			                	<#if selUser.ncName != null>
			                		(${selUser.ncName})
			                	</#if>
			                </span>
			            </li>
		            </#list>
		        </ul>
		        </div>
		        <input type="button" class="sewe" id="doneBtn" name="doneBtn" value="提交" />
		        <input type="button"  class="sewe" id="closeBtn" name="closeBtn" value="关闭" />
	     	</div>
	     </div>
	      </div>
	     </form>
    </body>
</html>