<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>我的申请列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <script src="${jsDomain}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script src="${jsDomain}/js/commons.js" type="text/javascript"></script>
	    <script src="${jsDomain}/js/page.js" type="text/javascript"></script>
        <script type="text/javascript">
        	$(document).ready(function(){
	        	  
			    // 撤销按钮点击事件
			    $(".back").click(function(){
			        var url = "${appDomain}/sw/sw_back.htm?id=" + $(this).attr("alt")+"&r=" + Math.random();
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
                
            });
        </script>
    </head>
    <body>
        <div id="main">
          <div class="main_nav">
            <#include "sw/menu.ftl">
            <div id="content">
            	<form id="swForm" name="swForm" action="${appDomain}/sw/list.htm" method="GET">
	                <div class="ct-top">
	                	<div class="search-bk">
							<span>标题：</span>
							<input type="text" class="sch-txt" name="title" value="${page.title}" />
	                 		<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                 	</div>
	                    <div class="btn-bk">
	                        	<a class="btn-add add-btn" href="${appDomain}/sw/add_sw.htm">新增</a>
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
	                            <th>文件编号</th>
	                            <!--<th>成文时间</th>-->
	                            <th>来文单位</th>
	                            <th>操作</th>
	                        </tr>
	                        <#list page.swList as sw>
		                        <tr>
		                        	<td width="3%">
		                                <input type="checkbox" name="chkItem" value="${sw.id}" />
		                            </td>
		                            <td class="left"><label style="width:380px;">${sw.title}</label></td>
		                            <td>${sw.fileNum}</td>
		                            <!--<td>${sw.textTime}</td>-->
		                            <td>${sw.fileDept}</td>
		                             <td class="td-btn" width="15%"">
			                            <a class="act-btn detail" href="${appDomain}/sw/detail.htm?id=${sw.id}" title="查看">查看</a>
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