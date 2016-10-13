<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>经我审核列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <script src="${jsDomain}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script src="${jsDomain}/js/commons.js" type="text/javascript"></script>
	    <script src="${jsDomain}/js/page.js" type="text/javascript"></script>
        <script type="text/javascript">
        	$(document).ready(function(){
	        	  
	        	/**
	        	 * 点击查询按钮
	        	 */
                $("#searchBtn").click(function(){
		            $('form').submit();
                });
                
              	// 历史按钮点击事件
			    $(".history").click(function(){
			        var url = "${appDomain}/news/news_history.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
			        window.open(url,'newwindow','height=520,width=760,top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
			    });
		    
		    	// 流程按钮点击事件
				$(".approval").click(function(){
				 	var temp="brief";
					var url = "${appDomain}/common/work_flow.htm?id=" +  $(this).attr("alt")+ "&type="+temp+"&r=" + Math.random();
					var param = 'dialogWidth=440px;dialogHeight=500px;status=no;center=yes;scroll=yes';
					var val = window.showModalDialog(url, '', param);
				});
                
            });
        </script>
    </head>
    <body>
        <div id="main">
          <div class="main_nav">
            <#include "brief/menu.ftl">
            <div id="content">
            	<form id="newsForm" name="newsForm" action="${appDomain}/brief/my_brief_list.htm" method="GET">
	                <input type="hidden" name="sort" id="sort" value="${sort}" />
	                <div class="ct-top">
	                	<div class="search-bk">
							<span>标题：</span>
							<input type="text" class="sch-txt" name="title" value="${page.title}" />
	                 		<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                 	</div>
	                    <div class="btn-bk">
	                        	<a class="btn-add add-btn" href="${appDomain}/brief/add_brief.htm?sort=${sort}">新增</a>
	                           <a class="btn-del delete-btn" href="#">删除</a>
	                    </div>
	                </div>
	                <div class="ct">
	                    <table class="list">
	                        <tr>
	                        	<th>
	                                <input id="allBtn" type="checkbox" name="" value="" />
	                            </th>
	                            <th>标题</th>
	                            <th>主题词</th>
	                            <th>发布时间</th>
	                            <th>类别</th>
	                            <th>操作</th>
	                        </tr>
	                        <#list page.newsList as news>
		                        <tr>
		                        	<td width="3%">
		                                <input type="checkbox" name="chkItem" value="${news.id}" />
		                            </td>
		                            <td class="left" style="width:380px;"><label style="width:380px;">${news.title}</label></td>
		                            <td class="left" style="width:200px;"><label style="width:380px;">${news.subject}</label></td>
		                            <td style="width:80px;">${news.textTime}</td>
		                            <td style="width:60px;"><#if news.sort == 1>每日要情<#else>简报</#if></td>
		                             <td class="td-btn" width="15%"">
			                            	<a class="act-btn detail" href="${appDomain}/brief/detail.htm?id=${news.id}" title="详细">详细</a>
			                            	<a class="act-btn approval" href="#" alt="${news.id}" title="流程">流程</a>
			                            	<a class="act-btn history" href="#"  alt="${news.id}" title="历史">历史</a>
		                            </td>
		                        </tr>
	                        </#list>
	                    </table>
	                    
	                    <#include "common/page.ftl">
	                  </div>    
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