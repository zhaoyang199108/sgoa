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
			        var url = "${appDomain}/docin/docin_history.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
			        window.open(url,'newwindow','height=520,width=760,top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
			    });
                
                // 流程按钮点击事件
				$(".approval").click(function(){
				 	var temp="docin";
					var url = "${appDomain}/common/work_flow.htm?id=" +  $(this).attr("alt")+ "&type="+temp+"&r=" + Math.random();
					var param = 'dialogWidth=440px;dialogHeight=500px;status=no;center=yes;scroll=yes';
					var val = window.showModalDialog(url, '', param);
				});
				
				// 改派按钮点击事件
		   		$(".gp").click(function(){
			        var url = "${appDomain}/docin/gp.htm?id=" + $(this).attr("alt") +"&nextOptIds=" + $("#nextOptId").val()+"&r=" + Math.random();
			        var param = 'dialogWidth=440px;dialogHeight=420px;status=no;center=yes;scroll=no';
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
            <#include "docin/menu.ftl">
            <div id="content">
            	<form id="docinForm" name="docinForm" action="${appDomain}/docin/my_docin_list.htm" method="GET">
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
	                            <th>文件编号</th>
	                            <!--<th>成文时间</th>-->
	                            <th>来文单位</th>
	                            <th>操作</th>
	                        </tr>
	                        <#list page.docinList as docin>
		                        <tr>
		                        	<td width="3%">
		                        		<input type="hidden" id="nextOptId" name="nextOptId" value="${docin.nextOptId}" />
		                                <input type="checkbox" name="chkItem" value="${docin.id}" />
		                            </td>
		                            <td class="left"><label style="width:380px;">${docin.title}</label></td>
		                            <td>${docin.fileNum}</td>
		                            <!--<td>${docin.textTime}</td>-->
		                            <td>${docin.fileDept}</td>
		                             <td class="td-btn" width="10%">
		                            		<a class="act-btn gp" href="#" alt="${docin.id}" title="重发">重发</a>
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