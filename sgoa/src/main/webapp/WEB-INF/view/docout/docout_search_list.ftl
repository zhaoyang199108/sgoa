<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>通知查询列表</title>
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
			        var url = "${appDomain}/docout/del_docout.htm?id=" + $(this).attr("alt");
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
						
			            var url = "${appDomain}/docout/delete_docoutArray.htm"
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
			        var url = "${appDomain}/docout/docout_history.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
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
            <#include "docout/menu.ftl">
            <div id="content">
            	<form id="docoutForm" name="docoutForm" action="${appDomain}/docout/docout_search.htm" method="GET">
	                <div class="ct-top">
	                	<div class="search-bk">
							<span>标题：</span>
							<input type="text" class="sch-txt" name="title" value="${page.title}" />
							<span>发文字号：</span>
							<input type="text" class="sch-txt" name="docoutNum" value="${page.docoutNum}" />
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
	                            <th>正文时间</th>
	                            <th>发文字号</th>
	                            <th>操作</th>
	                        </tr>
	                        <#list page.docoutList as docout>
		                        <tr>
		                        	<td width="3%">
		                                <input type="checkbox" name="chkItem" value="${docout.id}" />
		                            </td>
		                            <td class="left"><label style="width:380px;">
		                            	<a class="detail" target="_Blank" href="${appDomain}/docout/look_detail.htm?id=${docout.id}" title="${docout.title}">${docout.title}</a>
									</label></td>
		                            <td class="left"><label style="width:380px;">${docout.subject}</label></td>
		                            <td>${docout.textTime}</td>
		                            <td>${docout.docoutNum}</td>
		                             <td class="td-btn" width="5%"">
			                            	<a class="act-btn del" href="#" alt="${docout.id}" title="删除">删除</a>
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