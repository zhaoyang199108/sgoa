<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>传阅单列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <script src="${jsDomain}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script src="${jsDomain}/js/commons.js" type="text/javascript"></script>
	    <script src="${jsDomain}/js/page.js" type="text/javascript"></script>
        <script type="text/javascript">
        	$(document).ready(function(){
	        	  
			    // 撤销按钮点击事件
			    $(".back").click(function(){
			        var url = "${appDomain}/cyd/cyd_back.htm?id=" + $(this).attr("alt")+"&r=" + Math.random();
			        if (confirm("确定撤销该信息？")) {
			            $.get(url, function(result){
			                alert("操作成功");
			                $('form').submit();
			            });
			        }
			    });
        	
	        	/**
	        	 * 点击查询按钮
	        	 */
                $("#searchBtn").click(function(){
		            $('form').submit();
                });
                
                // 更新按钮点击事件
		    $(".detail").click(function(){
		        var url = "${appDomain}/cyd/detail.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=800px;dialogHeight=650px;status=no;center=yes;scroll=yes';
		        var val = window.showModalDialog(url, '', param);
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
            <#include "cyd/menu.ftl">
            <div id="content">
            	<form id="cydForm" name="cydForm" action="${appDomain}/cyd/cyd_list.htm" method="GET">
	                <div class="ct-top">
	                	<div class="search-bk">
							<span>文件编号：</span>
							<input type="text" class="sch-txt" name="num" />
	                 		<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                 	</div>
	                    <div class="btn-bk">
	                    	<a class="btn-add add-btn" href="${appDomain}/cyd/to_add_cyd.htm">新增</a>
	                    	<a class="btn-del delete-btn" href="#">删除</a>
	                    </div>
	                </div>
	                <div class="ct">
	                    <table class="list">
	                        <tr>
	                        	<th>
	                                <input id="allBtn" type="checkbox" name="" value="" />
	                            </th>	                            
	                            <th>文件编号</th>
	                            <th>份数</th>
	                            <th>操作</th>
	                        </tr>
	                        <#list page.cydList as cyd>
		                        <tr>
		                        	<td width="3%">
		                                <input type="checkbox" name="chkItem" value="${cyd.id}" />
		                            </td>
		                            <td class="left"><label style="width:380px;">${cyd.numFirst}</label></td>
		                            <td>${cyd.count}</td>
		                             <td class="td-btn" width="15%"">
			                            <a class="act-btn detail" href="#" title="查看" alt="${cyd.id}">查看</a>
			                            <a class="act-btn edit" href="${appDomain}/cyd/to_edit_cyd.htm?id=${cyd.id}" title="编辑">编辑</a>
			                            <a class="act-btn delete" href="${appDomain}/cyd/delete_cyd.htm?id=${cyd.id}" title="删除">删除</a>
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