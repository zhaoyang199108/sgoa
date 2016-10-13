<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>消息中心列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    // 更新按钮点击事件
		    $(".edit").click(function(){
		        var url = "${appDomain}/remind/remind_edit.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=680px;dialogHeight=300px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		   
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/remind/delete_remind.htm?id=" + $(this).attr("alt");
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
		            var url = "${appDomain}/remind/delete_remindArray.htm"
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
		var url = "${appDomain}/remind/remind_detail.htm?id=" + messageId;
		        var param = 'dialogWidth=680px;dialogHeight=300px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        
		}
		</script>
	</head>
    <body>
        <div id="main">
         <div class="main_nav">
            <#include "remind/menu.ftl">
            <div id="content">                  
                <form id="remindForm" name="remindForm" action="${appDomain}/remind/remind_list.htm" method="GET">
                <div class="ct-top">
	              <div class="search-bk" style="width:72%;">
                		<span>标题:</span>
                		<input class="sch-txt-more" type="text" name="title" value="${page.title}" />
                		<span>模块名称:</span>
                		<select class="sel-txt" name="modeName">
						      <option value="">请选择</option>
						      <option value="1" <#if page.modeName == '1'>selected="selected"</#if>>通知管理</option>
						      <option value="2" <#if page.modeName == '2'>selected="selected"</#if>>公告管理</option>
						      <option value="3" <#if page.modeName == '3'>selected="selected"</#if>>发文管理</option>
						      <option value="4" <#if page.modeName == '4'>selected="selected"</#if>>收文管理</option>
						      <option value="5" <#if page.modeName == '5'>selected="selected"</#if>>工作日程</option>
						      <option value="6" <#if page.modeName == '6'>selected="selected"</#if>>个人日程</option>
						      <option value="7" <#if page.modeName == '7'>selected="selected"</#if>>会议室预约</option>
						      <option value="8" <#if page.modeName == '8'>selected="selected"</#if>>站内信</option>
						      <option value="9" <#if page.modeName == '9'>selected="selected"</#if>>领导重大活动安排</option>
						      <option value="10" <#if page.modeName == '10'>selected="selected"</#if>>文稿拟定</option>
						      <option value="12" <#if page.modeName == '12'>selected="selected"</#if>>每日要情</option>
						      <option value="13" <#if page.modeName == '13'>selected="selected"</#if>>简报</option>
                         </select>
                		<span>状态:</span>
                		<select class="sel-txt" name="status">
						      <option value="">请选择</option>
						      <option value="1" <#if page.status == 1>selected="selected"</#if>>提醒</option>
						      <option value="2" <#if page.status == 2>selected="selected"</#if>>暂不提醒</option>
						      <option value="3" <#if page.status == 3>selected="selected"</#if>>不提醒</option>
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
								<th>状态</th>   
								<th>操作</th>                       
	                        </tr>
	                        <#list page.remindList as remind>
								<tr>
									<td width="3%">
		                                <input type="checkbox" name="chkItem" value=${remind.id} />
		                            </td>
									<td width="15%">
										<#if remind.modeName == '1'>通知管理
										<#elseif remind.modeName == '2'>公告管理
										<#elseif remind.modeName == '3'>发文管理
										<#elseif remind.modeName == '4'>收文管理
										<#elseif remind.modeName == '5'>工作日程
										<#elseif remind.modeName == '6'>个人日程
										<#elseif remind.modeName == '7'>会议室预约
										<#elseif remind.modeName == '8'>站内信
										<#elseif remind.modeName == '9'>局领导重大活动安排
										<#elseif remind.modeName == '10'>文稿拟定
										<#elseif remind.modeName == '11'>收文流转										
										<#elseif remind.modeName == '12'>每日要情										
										<#elseif remind.modeName == '13'>简报
										</#if>
									</td>
									<td width="52%" align="left">
										<#if remind.status = 1>
											<a style="color:blue;font-weight:bold;font-size:14px;" target="mainFrame" href="${appDomain}/${remind.url}">${remind.title}</a>
										<#elseif remind.status = 2>
											<a style="font-weight:bold;font-size:14px;" target="mainFrame" href="${appDomain}/${remind.url}">${remind.title}</a>
										<#elseif remind.status = 3>
											<a target="mainFrame" href="${appDomain}/${remind.url}">${remind.title}</a>
										<#else>
											<a target="mainFrame" href="${appDomain}/${remind.url}">${remind.title}</a>
										</#if>
									</td>	
									<td width="15%">
										<#if remind.status = 1>
											提醒
										<#elseif remind.status = 2>
											暂不提醒
										<#elseif remind.status = 3>
											不提醒
										</#if>
									</td>	
									<td class="td-btn" width="15%"">
										<a class="act-btn  detail" href="#" title="查看" alt="${remind.id}">查看</a>
										<#if remind.status == 3>
										<a class="act-btn" style="background:url(../images/gt.jpg); color:#8B8B8B;" href="#" title="更新">更新</a>
	                             		<#else>
	                             		<a class="act-btn  edit" href="#" title="更新" alt="${remind.id}">更新</a>
	                             		</#if>
										<a class="act-btn  del" href="#" title="删除" alt="${remind.id}">删除</a>
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