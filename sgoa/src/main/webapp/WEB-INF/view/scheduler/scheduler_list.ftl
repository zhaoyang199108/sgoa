<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>日程提醒列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="${jsDomain}/js/dhtmlxCalendar/codebase/dhtmlxcalendar.css"></link>
	    <link rel="stylesheet" type="text/css" href="${jsDomain}/js/dhtmlxCalendar/codebase/skins/dhtmlxcalendar_dhx_web.css"></link>
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>  
	    <script src="${jsDomain}/js/dhtmlxCalendar/codebase/dhtmlxcalendar.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){	   
		
		   //日期控件
		 		var cal1 = new dhtmlxCalendarObject(['startTime', 'endTime']);
				cal1.setDateFormat("%Y-%m-%d %H:%i:%s");
				cal1.setSkin('dhx_web');
		   
		     // 设置按钮点击事件
		    $(".edit").click(function(){
		    	 var messageId = $(this).attr("alt");
				 doMinute(messageId);
		    });
		    	
			 //详细的双击事件
		 	$("table.list tr:not(:first)").dblclick(function(){
				var id = $(this).find("input[name=schedulerId]").val();	
				doMinute(id);
			});   		 				    
		        /**
	        	 * 点击查询按钮
	        	 */
                $("#searchBtn").click(function(){
		            $('form').submit();
                });    
			});	
		function doMinute(messageId){
				var url = "${appDomain}/scheduler/edit_scheduler_one.htm?id=" +  messageId;
		        var param = 'dialogWidth=780px;dialogHeight=380px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		            $('form').submit();
		}	
		</script>
	</head>
    <body>
        <div id="main">
         <div class="main_nav">
            <#include "scheduler/menu.ftl">
            <div id="content">                  
                <form id="schedulerForm" name="schedulerForm" action="${appDomain}/scheduler/scheduler_list.htm" method="GET">   
                <div class="ct-top">
	              <div class="search-bk">
		                		<span>开始时间：</span>
		                		<input class="sch-txt-mo" type="text" id="startTime" name="startTime" value="${page.startTime}" />
								<span>结束时间：</span>
								<input class="sch-txt-mo" type="text" id="endTime" name="endTime" value="${page.endTime}" />
	                			
                                <a id="searchBtn" href="#" class="search-btn">搜索</a>    
	                </div>	                
	         </div>	
	                  <div class="ct">
	                    <table class="list">
	                        <tr>	                        	
								<th>日程开始时间</th>
								<th>日程结束时间</th>
								<th>日程内容</th>
								<th>开始提醒时间</th>
								<th>是否继续提醒</th>														                           
								<th>操作</th>
	                        </tr>
	                        <#list page.schedulerList as scheduler>             
								<tr>	       
								                								   				
									<td width="18%">${scheduler.startTime}</td>
									<td width="18%">${scheduler.endTime}</td>					
									<td class="left"><label style="width:280px;">${scheduler.content}</label></td>
									<td width="18%">${scheduler.startRemindTime}</td>
									<td width="12%"><#if scheduler.isRemind == 'Y'>提醒</#if>
													<#if scheduler.isRemind == 'N'>不提醒</#if></td>			
									 <td class="td-btn" width="5%">
									 	<input type="hidden" name="schedulerId"  value="${scheduler.id}"/>
										<a class="act-btn edit" href="#" title="更新" alt="${scheduler.id}">更新</a>
							         </td>																																						
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