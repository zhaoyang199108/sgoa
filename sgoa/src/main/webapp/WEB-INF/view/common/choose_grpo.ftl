<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>选择职责</title>
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
		            if ($("#positionId").val() == "") {
		                alert("请选择职责");
		                return false;
		            }
					
		            // 设置返回值数组,用户ID和用户姓名
		            var rtValue = new Array();
		            rtValue[0] = $("#positionId").val();
		            rtValue[1] = $("#grpoName").val();
		            window.opener = null;
		            window.open('', '_self');
		            window.returnValue = rtValue;
		            window.close();
		        });
		        
		        /**
		         * 人员选择完成后, 点击确认按钮返回父页面
		         */
		        $(".radioBtn").click(function(){
		            $("#positionId").val($(this).val());
		            $("#grpoName").val($(this).attr("alt"));
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
		    	<input type="hidden" id="positionId" name="positionId" value="" />
		    	<input type="hidden" id="grpoName" name="grpoName" value="" />
		        <div class="ku">  
		        <ul class="select-list">
		            <li>
		            </li>
		            <#list grpoList as grpo>
						<li class="zck">
			            	<input type="radio" class="radioBtn" alt="${grpo.grpoName}" name="positionId" value="${grpo.id}"  <#if grpo.id == grpoIdMap>checked="true"</#if>/>
			                <span class="uname">${grpo.grpoName}</span>
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