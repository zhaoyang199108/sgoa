<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>登录日志列表</title>
         <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="${jsDomain}/js/dhtmlxCalendar/codebase/dhtmlxcalendar.css"></link>
		<link rel="stylesheet" type="text/css" href="${jsDomain}/js/dhtmlxCalendar/codebase/skins/dhtmlxcalendar_dhx_web.css"></link>
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
	    <script src="${jsDomain}/js/dhtmlxCalendar/codebase/dhtmlxcalendar.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){        
				//日期控件
		 		var cal1 = new dhtmlxCalendarObject(['startTime', 'endTime']);
				cal1.setDateFormat("%Y-%m-%d %H:%i:%s");
				cal1.setSkin('dhx_web');
		    
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
           <#include "seal/menu.ftl">
            <div id="content">                  
                <form id="optLogForm" name="optLogForm" action="${appDomain}/log/optLog_list.htm" method="GET">
                <div class="ct-top"> 
	              <div class="search-bk">
                         <span>开始时间：</span>  
                         <input class="schyy" type=="text" id="startTime" name="startTime" value="${page.startTime}" />
                         <span>结束时间：</span>
                         <input class="schyy" type=="text" id="endTime" name="endTime" value="${page.endTime}" />
					     <a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>	                
	                </div>
	                    <div class="ct">
	                    <table class="list">
	                        <tr>
								<th>操作人</th>
								<th>操作日期</th>
								<th>IP地址</th>
	                        </tr>
	                        <#list page.optLogList as optLog>
								<tr>								
		                            
									<td width="15%">${optLog.optName}</td>
									<td width="25%">${optLog.createDate?datetime}</td>
									<td width="20%">${optLog.optIp}</td>														
									<input type="hidden" name="optLogId" value=${optLog.id} />
								</tr>
							</#list>
	                        </tr>
	                    </table>
						<#include "common/page.ftl">
	                </div>
				</form>
	        </div>
        </div>
          </div>
        <script type="text/javascript">
            var ctHeight = document.documentElement.clientHeight;
            $("#content").height(ctHeight + "px");
        </script>
    </body>
</html>