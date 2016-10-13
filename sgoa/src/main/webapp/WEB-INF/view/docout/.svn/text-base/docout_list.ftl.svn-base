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
			        var url = "${appDomain}/docout/docout_back.htm?id=" + $(this).attr("alt")+"&r=" + Math.random();
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
                
                // 流程按钮点击事件
				$(".approval").click(function(){
				 	var temp="docout";
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
            <#include "docout/menu.ftl">
            <div id="content">
            	<form id="docoutForm" name="docoutForm" action="${appDomain}/docout/list.htm" method="GET">
	                <div class="ct-top">
	                	<div class="search-bk">
							<span>标题：</span>
							<input type="text" class="sch-txt" name="title" value="${page.title}" />
							<span>发文字号：</span>
							<input type="text" class="sch-txt" name="docoutNum" value="${page.docoutNum}" />
	                 		<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                 	</div>
	                    <div class="btn-bk">
	                        	<a class="btn-add add-btn" href="${appDomain}/docout/add_docout.htm">新增</a>
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
	                            <th>正文时间</th>
	                            <th>发文字号</th>
	                            <th>操作</th>
	                        </tr>
	                        <#list page.docoutList as docout>
		                        <tr>
		                        	<td width="3%">
		                                <input type="checkbox" name="chkItem" value="${docout.id}" />
		                            </td>
		                            <td class="left"><label style="width:380px;">${docout.title}</label></td>
		                            <td class="left"><label style="width:380px;">${docout.subject}</label></td>
		                            <td>${docout.textTime}</td>
		                            <td>${docout.docoutNum}</td>
		                             <td class="td-btn" width="15%"">
		                                    <#if docout.currentOptId == docout.draftsId && docout.status == 1>
		                             		<a class="act-btn back" href="#" alt="${docout.id}" title="撤销">撤销</a>
		                             		<#else>
		                             		<a class="act-btn" style="background:url(../images/gt.jpg); color:#8B8B8B;" href="#" title="撤销">撤销</a>
		                             		</#if>
			                            	<a class="act-btn detail" href="${appDomain}/docout/detail.htm?id=${docout.id}" title="详细">详细</a>
			                            	<a class="act-btn approval" href="#" alt="${docout.id}" title="流程">流程</a>
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