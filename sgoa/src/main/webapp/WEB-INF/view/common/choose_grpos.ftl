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
		       		var item = $("input[name=positionId]:checked");
		            if (item.length == 0) {
		                alert("请选择职责");
		                return false;
		            }
		            
		            var grpoNames = "";
		            var positionIds = "";
		            item.each(function(i){
		                grpoNames = grpoNames + $(this).attr("alt");
		                positionIds = positionIds + $(this).val();
		                
		                 if (i != item.length - 1) {
		                    grpoNames = grpoNames + ",";
		                    positionIds = positionIds + ",";
		                }
		            });
		            
					
		            // 设置返回值数组,用户ID和用户姓名
		            var rtValue = new Array();
		            rtValue[0] = positionIds
		            rtValue[1] = grpoNames
		            window.opener = null;
		            window.open('', '_self');
		            window.returnValue = rtValue;
		            window.close();
		        });
		        
		         /**
			     * 判断当前用户是否已经被选择
			     */
			    function isExistInList(id){
			        var isExist = false;
			        $("input[name=positionId]").each(function(){
			            var positionId = $(this).val();
			            if (id == positionId) {
			                isExist = true;
			                $(this).find("input.radioBtn").checked = true;
			                return;
			            }
			        });
			        return isExist;
			    }
		        
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
		    	<input type="hidden" id="positionIdSplit" value="${grpoIdMap}" />
		        <div class="ku">  
		        <ul class="select-list">
		            <li>
		            </li>
		            <#list grpoList as grpo>
						<li class="zck">
			            	<input type="checkbox" class="radioBtn" alt="${grpo.grpoName}" name="positionId" value="${grpo.id}"/>
			                <span class="uname">${grpo.grpoName}</span>
			            </li>
		            </#list>
		            <script type="text/javascript">
		            	var grpoIdStr = document.getElementById("positionIdSplit").value;
		            	if(grpoIdStr != "") {
		            		var grpoIdSplit = grpoIdStr.split(",");
					    	for(var i=0;i<grpoIdSplit.length;i++) {
					    		$("input[name=positionId]").each(function(){
						            var positionId = $(this).val();
						            if (grpoIdSplit[i] == positionId) {
						                $(this).attr("checked",true);
						            }
						        });
					    	}
		            	}
		            </script>
		        </ul>
		        </div>
		        <input type="button" class="but" id="doneBtn" name="doneBtn" value="提交" />
		        <input type="button"  class="but" id="closeBtn" name="closeBtn" value="关闭" />
	     	</div>
	     </div>
    </body>
</html>