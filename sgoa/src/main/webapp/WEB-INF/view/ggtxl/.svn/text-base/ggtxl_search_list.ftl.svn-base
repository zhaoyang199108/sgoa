<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>公共通讯录列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		        /**
	        	 * 点击查询按钮
	        	 */
                $("#searchBtn").click(function(){
		            $('form').submit();
                });
	
		});
		</script>
	</head>
    <body>
        <div id="main">
         <div class="main_nav">
            <#include "ggtxl/menu.ftl">
            <div id="content">                  
                <form id="ggtxlForm" name="ggtxlForm" action="${appDomain}/ggtxl/ggtxl_search_list.htm" method="GET">
                <div class="ct-top">
	              <div class="search-bk">
                		<span>姓名:</span>
                		<input class="sch-txt-more" type="text" name="addName" value="${page.addName}" />
                		<span>工作电话:</span>
                		<input class="sch-txt-more" type="text" name="unitTel" value="${page.unitTel}" />
						<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>	                
	                </div>
	                    <div class="ct">
	                    <table class="list">
	                         <tr>
								<th>姓名</th>
								<th>部门</th>
								<th>工作电话</th>
								<th>手机</th>
	                        </tr>
	                        <#list page.ggtxlList as ggtxl>
								<tr>
									<td>${ggtxl.addName}</td>
									<td>${ggtxl.typeName}</td>
									<td>${ggtxl.unitTel}</td>
									<td>${ggtxl.cellPhone}</td>
								</tr>
							</#list>
	                    </table>
						<#include "common/page.ftl">
	                </div>
				</form>
	        </div>
	       </div>
	       </div>
        </div>
        <script type="text/javascript">
            var ctHeight = document.documentElement.clientHeight;
            $("#content").height(ctHeight + "px");
        </script>
    </body>
</html>