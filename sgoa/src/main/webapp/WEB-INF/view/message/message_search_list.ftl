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
			        var url = "${appDomain}/message/del_message.htm?id=" + $(this).attr("alt");
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
						
			            var url = "${appDomain}/message/delete_messageArray.htm"
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
			        var url = "${appDomain}/message/message_history.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
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
            <#include "message/menu.ftl">
            <div id="content">
            	<form id="messageForm" name="messageForm" action="${appDomain}/message/message_search.htm" method="GET">
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
	                        <#list page.messageList as message>
		                        <tr>
		                        	<td width="3%">
		                                <input type="checkbox" name="chkItem" value="${message.id}" />
		                            </td>
		                            <td class="left"><label style="width:380px;">
		                            	<a class="detail" target="_Blank" href="${appDomain}/message/look_detail.htm?id=${message.id}" title="${message.title}">${message.title}</a>
									</label></td>
		                            <td class="left"><label style="width:200px;">${message.subject}</label></td>
		                            <td style="width:105px;">${message.textTime}</td>
		                            <td style="width:60px;"><#if message.sort == 1>通知<#else>公告</#if></td>
		                             <td class="td-btn" width="5%">
		                             	<#if userAuth("ROLE_ADMIN","ROLE_MESSAGE_DEL")>
			                            	<a class="act-btn del" href="#" alt="${message.id}" title="删除">删除</a>
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