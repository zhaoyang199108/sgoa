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
			        var url = "${appDomain}/docin/docin_back.htm?id=" + $(this).attr("alt")+"&r=" + Math.random();
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
                
                 // 记录按钮点击事件
			    $("#jlBtn").click(function(){
			        var url = "${appDomain}/docin/jl.htm" + "?r=" + Math.random();
			        var param = 'dialogWidth=800px;dialogHeight=650px;status=no;center=yes;scroll=yes';
			        var val = window.showModalDialog(url, '', param);
			        if (val == 'refresh') {
			            alert("操作成功");
			            $('form').submit();
			        }
			    });
                
                // 流程按钮点击事件
				$(".approval").click(function(){
				 	var temp="docin";
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
            <#include "docin/menu.ftl">
            <div id="content">
            	<form id="docinForm" name="docinForm" action="${appDomain}/docin/list.htm" method="GET">
	                <div class="ct-top">
	                	<div class="search-bk">
							<span>标题：</span>
							<input type="text" class="sch-txt" name="title" value="${page.title}" />
	                 		<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                 		<a id="jlBtn" href="#" class="search-btn">记录</a>
	                 	</div>
	                    <div class="btn-bk">
	                        	<a class="btn-add add-btn" href="${appDomain}/docin/add_docin.htm">新增</a>
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
	                        <#list page.docinList as docin>
		                        <tr>
		                        	<td width="3%">
		                                <input type="checkbox" name="chkItem" value="${docin.id}" />
		                            </td>
		                            <td class="left"><label style="width:380px;">${docin.title}</label></td>
		                            <td>${docin.fileNum}</td>
		                            <!--<td>${docin.textTime}</td>-->
		                            <td>${docin.fileDept}</td>
		                             <td class="td-btn" width="15%"">
		                                    <#if docin.currentOptId == docin.loginId>
		                             		<a class="act-btn back" href="#" alt="${docin.id}" title="撤销">撤销</a>
		                             		<#else>
		                             		<a class="act-btn" style="background:url(../images/gt.jpg); color:#8B8B8B;" href="#" title="撤销">撤销</a>
		                             		</#if>
			                            	<a class="act-btn detail" href="${appDomain}/docin/detail.htm?id=${docin.id}" title="详细">详细</a>
			                            	<a class="act-btn approval" href="#" alt="${docin.id}" title="流程">流程</a>
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