<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>操作日志列表</title>
        <link href="${cssDomain}/css/base.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/list.css" rel="stylesheet" type="text/css">
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
                 * 收件人选择按钮事件,弹出对话框选择收件人
                 */
                $("#logSelect").click(function(){
                    var url = "${appDomain}/common/choose_all_user.htm" + "?id=" + $("#optId").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=380px;dialogHeight=400px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if (value.length > 0) {
                        $("#opt").val(value[1]);
                        $("#optId").val(value[0]);
                    }
                });  
 
		     // 详细按钮点击事件
		    $(".detail").click(function(){
		    	 var messageId = $(this).attr("alt");
				 doMinute(messageId);
		    });
		    	
			 //详细的双击事件
		 	$("table.list tr:not(:first)").dblclick(function(){
				var id = $(this).find("input[name=optLogId]").val();	
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
		var url = "${appDomain}/log/optLog_detail.htm?id=" + messageId;
		        var param = 'dialogWidth=800px;dialogHeight=420px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        
		}
		</script>
	</head>
    <body>
        <div id="main">
           <#include "user/menu.ftl">
            <div id="content">                  
                <form id="optLogForm" name="optLogForm" action="${appDomain}/log/optLog_list.htm" method="GET">
                <div class="ct-top"> 
	              <div class="search-bk">
                        <ul class="sch-key">
	                		<li>  
		                		<span>操作人：</span>
		                        <input class="sch-txt2" id="opt" name="opt" type="text" value="" readonly="readonly"/>
		                        <input id="logSelect" type="button" class="btn-ctt" value="选择" />
		                        <input class="txt" type="hidden" id="optId" name="optId" value="" />
	                		</li>	
	                		<li>
                                <span>操作模块：</span>
                                <input class="sch-txt" type=="text" id="optModule" name="optModule" value="${page.optModule}" />
                            </li> 						
							<li>
	                			<label>操作状态：</label>
	                			 <select name="optStatus" style="width:80px;">
	                			        <option value="">请选择</option>        
                					 	<option value=1>成功</option>
                                      	<option value=2>失败</option>                                       
                                  </select>
                             </li>             
                        </ul>
                        <ul class="sch-key">   
                            <li>
                                 <span>开始时间：</span>  
                                 <input class="sch-txt" type=="text" id="startTime" name="startTime" value="${page.startTime}" />
                            </li>
                             <li>
                                <span>结束时间：</span>
                                <input class="sch-txt" type=="text" id="endTime" name="endTime" value="${page.endTime}" />
                            </li> 
                            <li>
                            </li>
                         
					      </ul>
	                </div>	                
	                <a id="searchBtn" href="#" class="search-btn">搜索</a>             
	                </div>
	                    <div class="ct">
	                    <table class="list">
	                        <tr>
								<th>操作人</th>
								<th>操作日期</th>
								<th>操作模块</th>
								<th>操作动作</th>
								<th>操作状态</th>
								<th>操作</th>
																							                           
	                        </tr>
	                        <#list page.optLogList as optLog>
								<tr>								
		                            
									<td width="15%">${optLog.optName}</td>
									<td width="25%">${optLog.createDate?datetime}</td>
									<td width="20%">${optLog.optModule}</td>														
									<td width="20%">${optLog.optAction}</td>
									<td width="10%"><#if optLog.optStatus==1>成功
									<#else>失败</#if></td>	
									<td  class="td-btn" width="3%">
										<input type="hidden" name="optLogId" value=${optLog.id} />
										<a class="act-btn detail" href="#" title="详细" alt="${optLog.id}">详细</a>
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
        <script type="text/javascript">
            var ctHeight = document.documentElement.clientHeight;
            $("#content").height(ctHeight + "px");
        </script>
    </body>
</html>