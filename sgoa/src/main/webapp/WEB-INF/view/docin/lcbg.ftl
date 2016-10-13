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
		        
		        	var loginIds = "";
		        	$(".radioBtn").each(function(i){
		                if ($(this).attr("checked")) {
		                	if(loginIds != "") {
		                		loginIds = loginIds + ",";
		                	}
		                	loginIds = loginIds + $(this).attr("alt");
		                }
		                
		            });
		            if (loginIds == "") {
		                alert("请选择人员");
		                return false;
		            }
					
		            // 设置返回值数组,用户ID和用户姓名
		            var rtValue = new Array();
		            rtValue[0] = loginIds;
		            $("#nextOptId").val(rtValue[0]);
		            $('form').submit();
		        });
		        
		        /**
		         * 人员选择完成后, 点击确认按钮返回父页面
		         */
		        $(".radioBtn").click(function(){
		            $("#loginIdStr").val($(this).attr("alt"));
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
		        var yxOptIds = $("#yxOptId").val();
		        if(yxOptIds != null && yxOptIds != ""){
			        var yxOptId = yxOptIds.split(",");
			        for(var i=0;i<yxOptId.length;i++){
			        	if(loginId == yxOptId[i]){
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
    <div class="calog">
    	<div class="f0">
    		<div class="wrap">
    		<form class="f0" action="${appDomain}/docin/lcbg.htm" method="POST">
		    	<input type="hidden" id="loginIdStr" name="loginIdStr" value="" />
		    	<input type="hidden" id="yxOptId" name="yxOptId" value="${yxOptId}" />
		    	<input type="hidden" id="id" name="id" value="${id}" />
		    	<input type="hidden" id="nextOptId" name="nextOptId" value="" />
		        <div class="ku">  
		        <ul class="select-list">
		            <li>
		            </li>
		            <#list selUserList as selUser>
			                <li class="zck" id="li_${selUser.loginId}">
			                <input type="checkbox" class="radioBtn" name="allBtn" alt="${selUser.loginId}" value="" />
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
		        </br>
		        <div style="font-size:16px; font-weight:bold;">原下一步操作人：</div>
		 		<div class="ku01"> 
		         <#list strList as strObj>
		          <li>
	             	${strObj}
	             </li>
	             </#list>
	             </div>
	             </br>
		        <input type="button" class="sewe" id="doneBtn" name="doneBtn" value="提交" />
		        <input type="button"  class="sewe" id="closeBtn" name="closeBtn" value="关闭" />
		        </form>
	     	</div>
	     </div>
	      </div>
    </body>
</html>