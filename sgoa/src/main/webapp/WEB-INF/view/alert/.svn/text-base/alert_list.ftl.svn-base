<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>备忘录列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    // 更新按钮点击事件
		    $(".edit").click(function(){
		        var url = "${appDomain}/alert/alert_edit.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=880px;dialogHeight=450px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		   
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/alert/delete_alert.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该提醒消息？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		     // 详细按钮点击事件
		    $(".detail").click(function(){
		    	 var messageId = $(this).attr("alt");
				 doMinute(messageId);
		    });
		    	
			 //详细的双击事件
		 	$("table.list tr:not(:first)").dblclick(function(){
				var id = $(this).find("input[name=chkItem]").val();	
				doMinute(id);
			});
		    
		        /**
	        	 * 点击查询按钮
	        	 */
                $("#searchBtn").click(function(){
		            $('form').submit();
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
		        
		        if (confirm("确定删除所选提醒消息?")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/alert/delete_alertArray.htm"
		            $.get(url, {
		                idArray: value
		            }, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		});
		function doMinute(messageId){
		var url = "${appDomain}/alert/alert_detail.htm?id=" + messageId;
		        var param = 'dialogWidth=880px;dialogHeight=450px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        
		}
		</script>
	</head>
    <body>
        <div id="main">
         <div class="main_nav">
            <#include "alert/menu.ftl">
            <div id="content">                  
                <form id="alertForm" name="alertForm" action="${appDomain}/alert/alert_list.htm" method="GET">
                <div class="ct-top">
	              <div class="search-bk" style="width:70%;">
                		<span>标题:</span>
                		<input class="sch-txt-more" type="text" name="title" value="${page.title}" />
                		<span>提醒时间:</span>
                		<input class="sch-txt-more" type="text" name="alertTime" value="${page.alertTime}" />
                		<span>状态:</span>
                		<select class="sel-txt" name="status">
						      <option value="">请选择</option>
						      <option value="1" >未办理</option>
						      <option value="2">已办理</option>
                         </select>
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
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>
								<th>模块名称</th>
								<th>标题</th>
								<th>提醒时间</th>	  
								<th>状态</th>   
								<th>操作</th>                       
	                        </tr>
	                        <#list page.alertList as alert>
								<tr>
									<td width="3%">
		                                <input type="checkbox" name="chkItem" value=${alert.id} />
		                            </td>
									<td width="12%">${alert.modeName}</td>
									<td width="30%">
										<#if alert.busId='message'>
											<a target="mainFrame" href="${appDomain}/${alert.busId}/${alert.busId}_review_list.htm?sort=1">${alert.title}</a>
										<#elseif alert.busId='notice'>
											<a target="mainFrame" href="${appDomain}/${alert.busId}/${alert.busId}_review_list.htm?sort=2">${alert.title}</a>
										<#elseif alert.busId='news'>
											<a target="mainFrame" href="${appDomain}/${alert.busId}/${alert.busId}_review_list.htm?sort=1">${alert.title}</a>
										<#elseif alert.busId='brief'>
											<a target="mainFrame" href="${appDomain}/${alert.busId}/${alert.busId}_review_list.htm?sort=2">${alert.title}</a>
										<#else>
											<a target="mainFrame" href="${appDomain}/${alert.busId}/${alert.busId}_review_list.htm">${alert.title}</a>
										</#if>
										
									</td>	
									<td width="15%">${alert.alertTime}</td>	
									<td width="15%">
										<#if alert.status = 1>
											未办理
										<#else>
											已办理
										</#if>
									</td>	
									<td class="td-btn" width="25%"">
										<a class="act-btn  detail" href="#" title="查看" alt="${alert.id}">查看</a>
										<a class="act-btn  edit" href="#" title="更新" alt="${alert.id}">更新</a>
										<a class="act-btn  del" href="#" title="删除" alt="${alert.id}">删除</a>
									</td>						
								</tr>
							</#list>
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