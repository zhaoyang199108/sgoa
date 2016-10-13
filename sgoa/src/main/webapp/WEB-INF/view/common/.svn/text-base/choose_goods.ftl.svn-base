<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>选择物品</title>
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
		            if ($("#sealId").val() == "") {
		                alert("请选择物品");
		                return false;
		            }
					
		            // 设置返回值数组,用户ID和用户姓名
		            var rtValue = new Array();
		            rtValue[0] = $("#sealId").val();
		            rtValue[1] = $("#sealName").val();
		            rtValue[2] = $("#unitPrice").val();
		            rtValue[3] = $("#unit").val();
		            rtValue[4] = $("#model").val();
		            
		            window.opener = null;
		            window.open('', '_self');
		            window.returnValue = rtValue;
		            window.close();
		        });
		        
		        /**
		         * 人员选择完成后, 点击确认按钮返回父页面
		         */
		        $(".radioBtn").click(function(){
		            $("#sealId").val($(this).val());
		            $("#sealName").val($(this).attr("alt"));
		            $("#unitPrice").val($(this).attr("altp"));
		            $("#unit").val($(this).attr("altu"));
		            $("#model").val($(this).attr("altm"));
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
		    	<input type="hidden" id="sealId" name="sealId" value="" />
		    	<input type="hidden" id="sealName" name="sealName" value="" />
		    	<input type="hidden" id="unitPrice" name="unitPrice" value="" />
		    	<input type="hidden" id="unit" name="unit" value="" />
		    	<input type="hidden" id="model" name="model" value="" />
		        <div class="ku">  
		        <ul class="select-list">
		            <li>
		            </li>
		            <#list selSealList as seal>
						<li class="zck">
			            	<input type="radio" class="radioBtn" alt="${seal.sealName}" altp="${seal.unitPrice}" altu="${seal.unit}" altm="${seal.model}" name="sealIdArray" value="${seal.id}"  <#if seal.id == sealIdMap>checked="true"</#if>/>
			                <span class="uname">${seal.sealName}</span>
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