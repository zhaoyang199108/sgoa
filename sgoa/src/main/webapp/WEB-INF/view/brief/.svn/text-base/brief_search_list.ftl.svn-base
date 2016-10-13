<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>简报查询列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
         <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
        <script type="text/javascript">
        	$(document).ready(function(){
	        	  
	        	/**
	        	 * 点击查询按钮
	        	 */
                $("#searchBtn").click(function(){
		            $('form').submit();
                });
                       
            // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/news/del_news.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该信息？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
                
                 // 批量删除按钮点击事件
		    $(".delete-btn").click(function(){
		    	// 被选中的单选框
		        var item = $("input[name=chkItem]:checked");
		        // 校验是否至少选择了一个单选框
		        if (item.length == 0) {
		            alert("请至少选择一条记录进行操作");
		            return false;
		        }
		        
		          if (confirm("确定删除所选信息？")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/news/delete_newsArray.htm"
		            $.get(url, {
		                idArray: value
		            }, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
                // 历史按钮点击事件
		    $(".history").click(function(){
		        var url = "${appDomain}/news/news_history.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=760px;dialogHeight=520px;status=no;center=yes;scroll=yes';
		        var val = window.open(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
                
            });
        </script>
    </head>
    <body>
        <div id="main">
          <div class="main_nav">
            <#include "brief/menu.ftl">
            <div id="content">
            	<form id="newsForm" name="newsForm" action="${appDomain}/brief/brief_search.htm" method="GET">
	                <div class="ct-top">
	                	<div class="search-bk">
							<span>标题：</span>
							<input type="text" class="sch-txt" name="title" value="${page.title}" />
	                 		<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                 	</div>
	                    <div class="btn-bk">
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
		                            <td class="left"><label style="width:380px;">
		                            <div style="width:380px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;">
		                            	<a class="detail" target="_Blank" href="${appDomain}/news/look_detail.htm?id=${news.id}" title="${news.title}">${news.title}</a>
		                            </div>
		                            </label></td>
		                            <td class="left" style="width:200px;"><label style="width:200px;">${news.subject}</label></td>
		                            <td style="width:105px;">${news.textTime}</td>
		                            <td style="width:60px;"><#if news.sort == 1>每日要情<#else>简报</#if></td>
		                             <td class="td-btn" width="5%">
		                             		<#if userAuth("ROLE_ADMIN","ROLE_NEWS_DEL")>
			                            	<a class="act-btn del" href="#" alt="${news.id}" title="删除">删除</a>
			                            	</#if>
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