<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>会议预约列表</title>
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
         
				
				 // 流程按钮点击事件
				$(".reviewpic").click(function(){
				    var temp="meetingyy";
					var url = "${appDomain}/common/work_flow.htm?id=" +  $(this).attr("alt")+ "&type="+temp+"&r=" + Math.random();
					var param = 'dialogWidth=340px;dialogHeight=540px;status=no;center=yes;scroll=yes';
					var val = window.showModalDialog(url, '', param);
				});
				
			    // 详细按钮点击事件
			    $(".act-detail").click(function(){
			        var url = "${appDomain}/meetingYy/detail_meetingYy.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
			        var param = 'dialogWidth=950px;dialogHeight=700px;status=no;center=yes;scroll=yes';
			        var val = window.showModalDialog(url, '', param);
			    });
		    
		});
		</script>
	</head>
    <body>
        <div id="main">
         <div class="main_nav">
            <#include "meetingyy/menu.ftl">
            <div id="content">                  
                <form id="userForm" name="userForm" action="${appDomain}/meetingYy/meetingYy_list.htm" method="GET">
                <div class="ct-top">
	              <div class="search-bk">
						<span>会议室:</span>
						<select class="sel-txt" name="roomId">
						      <option value="">请选择</option>
					          <#list meetingRoomPage as meetingRoom>
                		      <option value="${meetingRoom.id}" <#if meetingRoom.id == page.roomId>selected="selected"</#if>> ${meetingRoom.roomName} </option>
                              </#list>
                         </select>
                         <a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>	                
	                
	                <div class="btn-bk">
                       <a class="btn-add add-btn" href="${appDomain}/meetingYy/add_meetingYy.htm">新增</a>
                       <a class="btn-del delete-btn" href="#">删除</a>
                    </div>  
	                </div>
	                    <div class="ct">
	                    <table class="list">
	                        <tr>
	                        	<th>
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>
                            	<th>预约人</th>
								<th>会议室</th>
								<th>预约开始时间</th>
								<th>预约结束时间</th>
								<th>当前流程</th>															
								<th>创建日期</th>		
	                        	<th>操作</th>						                           
	                        </tr>
	                        <#list page.meetingYyList as meetingYy>
								<tr>
									<td width="3%">
		                                <input type="checkbox" name="chkItem" value=${meetingYy.id} />
		                            </td>
									<td>${meetingYy.userName}</td>
									<td>${meetingYy.roomName}</td>
									<td>${meetingYy.startTime}</td>		
									<td>${meetingYy.endTime}</td>		
									<td>${meetingYy.approvalName}</td>																
									<td>${meetingYy.updateDate?date}</td>																							
									<td class="td-btn" width="10%">
										<a class="act-btn act-detail detail" href="#" alt="${meetingYy.id}" title="查看详细">查看</a>
										<a class="act-btn  reviewpic" href="#" alt="${meetingYy.id}" title="查看流程">流程</a>
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
        </div>
        <script type="text/javascript">
            var ctHeight = document.documentElement.clientHeight;
            $("#content").height(ctHeight + "px");
        </script>
    </body>
</html>