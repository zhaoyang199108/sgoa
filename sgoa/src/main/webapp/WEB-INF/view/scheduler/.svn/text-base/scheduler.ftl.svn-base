<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>日程提醒管理-列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script src="${jsDomain}/js/scheduler/dhtmlxscheduler.js" type="text/javascript" charset="utf-8"></script>
   		<link rel="stylesheet" href="${jsDomain}/js/scheduler/dhtmlxscheduler.css" type="text/css" media="screen" title="no title" charset="utf-8">
		<script src="${jsDomain}/js/scheduler/ext/dhtmlxscheduler_minical.js" type="text/javascript" charset="utf-8"></script>
		<script src="${jsDomain}/js/scheduler/locale_cn.js" type="text/javascript" charset="utf-8"></script>
		<script src="${jsDomain}/js/scheduler/locale_recurring_cn.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css" media="screen">
		   html, body{
		   	  left:0;
		      margin:0px;
		      padding:0px;
		      height:100%;
		      overflow:hidden;
		   }   
		</style>
	    <script type="text/javascript">
			function init() {
				scheduler.config.multi_day = true;
				scheduler.config.xml_date="%Y-%m-%d %H:%i";
				scheduler.init('scheduler_here',new Date(),"week");
				scheduler.load("${appDomain}/upload/schedulerFile/event.xml?r="+Math.random());
				scheduler.attachEvent("onEventAdded", addEvent);//定义方法        
		        scheduler.attachEvent("onEventChanged", changeEvent);
		        scheduler.attachEvent("onBeforeEventDelete", deleteEvent); 
		        
		
			}
			var addEvent = function addEvent(event_id, e)
		    {
		    	if(e.text == '' || e.text == null){
		    		alert('标题内容不能为空');
		    		// 设置日程,删除日程成功
		            window.location.href = "${appDomain}/scheduler/scheduler.htm";
		    		return;
		    	}
		    	programing = true;
		        $.ajax({
		            type: 'POST',
		            contentType: 'application/json',
		            url: '/scheduler/add_scheduler.htm',
		            dataType: 'json',
		            contentType: "application/x-www-form-urlencoded; charset=utf-8",
		            data: 'id=' + event_id + '&content=' + encodeURI(e.text) + '&startTime=' + e.start_date.pattern("yyyy-MM-dd HH:mm:ss") + '&endTime=' + e.end_date.pattern("yyyy-MM-dd HH:mm:ss") + '&r=' + Math.random(),
		            success: function(data){
		            	// 设置日程,添加日程成功
		            	//window.location.href = "${appDomain}/scheduler/scheduler.htm";
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		            	programing = false;
		                alert("添加日程失败！");
		                // 设置日程
		            	window.location.href = "${appDomain}/scheduler/scheduler.htm";
		            }
		        });
		     }
		     
		     var changeEvent = function changeEvent(event_id, e){
		     	if(e.text == '' || e.text == null){
		    		alert('标题内容不能为空');
		    		return;
		    	}
		    	programing = true;
		     	$.ajax({
		            type: 'POST',
		            contentType: 'application/json',
		            url: '/scheduler/edit_scheduler.htm',
		            dataType: 'json',
		            contentType: "application/x-www-form-urlencoded; charset=utf-8",
		            data: 'id=' + event_id + '&content=' + encodeURI(e.text) + '&startTime=' + e.start_date.pattern("yyyy-MM-dd HH:mm:ss") + '&endTime=' + e.end_date.pattern("yyyy-MM-dd HH:mm:ss") + '&r=' + Math.random(),
		            success: function(data){
		                // 设置日程,修改日程成功
		               
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		            	programing = false;
		                alert("编辑日程失败！");
		                window.location.href = "${appDomain}/scheduler/scheduler.htm";
		            }
		        });
		     }
		     
		     deleteEvent = function(event_id, e){
		     	$.ajax({
		            type: 'POST',
		            contentType: 'application/json',
		            url: '/scheduler/delete_scheduler.htm',
		            dataType: 'json',
		            contentType: "application/x-www-form-urlencoded; charset=utf-8",
		            data: 'id=' + event_id + '&r=' + Math.random(),
		            success: function(data){
		                // 设置日程,删除日程成功
		               window.location.href = "${appDomain}/scheduler/scheduler.htm";
		            },
		            error: function(){
		            	// 请求错误时,提示用户
		                alert("删除日程失败！");
		               	window.location.href = "${appDomain}/scheduler/scheduler.htm";
		            }
		        });
		     }
			
			function show_minical(){
				if (scheduler.isCalendarVisible())
					scheduler.destroyCalendar();
				else
					scheduler.renderCalendar({
						position:"dhx_minical_icon",
						date:scheduler._date,
						navigation:true,
						handler:function(date,calendar){
							scheduler.setCurrentView(date);
							scheduler.destroyCalendar()
							var url = "${appDomain}/scheduler/scheduler.htm?selectTime=" + date.pattern("yyyy-MM-dd HH:mm:ss");
				            $.get(url, function(result){
				                // 查询成功
				            });
						}
					});
			}
			
			/**     
			 * 对Date的扩展，将 Date 转化为指定格式的String     
			 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符     
			 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)     
			 * eg:     
			 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423     
			 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04     
			 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04     
			 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04     
			 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18     
			 */       
			Date.prototype.pattern=function(fmt) {        
			    var o = {        
			    "M+" : this.getMonth()+1, //月份        
			    "d+" : this.getDate(), //日        
			    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时        
			    "H+" : this.getHours(), //小时        
			    "m+" : this.getMinutes(), //分        
			    "s+" : this.getSeconds(), //秒        
			    "q+" : Math.floor((this.getMonth()+3)/3), //季度        
			    "S" : this.getMilliseconds() //毫秒        
			    };        
			    var week = {        
			    "0" : "/u65e5",        
			    "1" : "/u4e00",        
			    "2" : "/u4e8c",        
			    "3" : "/u4e09",        
			    "4" : "/u56db",        
			    "5" : "/u4e94",        
			    "6" : "/u516d"       
			    };        
			    if(/(y+)/.test(fmt)){        
			        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));        
			    }        
			    if(/(E+)/.test(fmt)){        
			        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);        
			    }        
			    for(var k in o){        
			        if(new RegExp("("+ k +")").test(fmt)){        
			            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));        
			        }        
			    }        
			    return fmt;        
			}
		</script> 
		</head>
<body onload="init();">
	<div id="main">
		<div class="main_nav">
    	<#include "scheduler/menu.ftl">
			<div id="content">
				<div id="scheduler_here" class="dhx_cal_container" style='width:100%;height:420px;_height:420px;'>
	    			<div class="dhx_cal_navline">
				    	<div class="dhx_cal_prev_button">&nbsp;</div>
				        <div class="dhx_cal_next_button">&nbsp;</div>
				        <div class="dhx_cal_today_button"></div>
				        <div class="dhx_cal_date"></div>
				        <div class="dhx_minical_icon" id="dhx_minical_icon" onclick="show_minical()">&nbsp;</div>
				        <div class="dhx_cal_tab" name="day_tab" style="right:204px;"></div>
				        <div class="dhx_cal_tab" name="week_tab" style="right:140px;"></div>
				        <div class="dhx_cal_tab" name="month_tab" style="right:76px;"></div>
		      		</div>
			    	<div class="dhx_cal_header">
			    	</div>
			   		<div class="dhx_cal_data">
			    	</div>
		    	</div>
			</div>
		</div>
	</div>
	</body>
</html>