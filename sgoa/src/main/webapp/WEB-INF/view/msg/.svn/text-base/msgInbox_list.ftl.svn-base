<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>已收文件-列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/search/c.suggest.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
			 $("#userNamePy").suggest({attachObject:'#suggest',url:'${appDomain}/megUser/user_list.htm'});
			 
		
			// 日期控件
			$("input[name=createDate]").click(function(){
				WdatePicker();
			});
			
			    /**
                 * 发件人选择按钮事件,弹出对话框选择发件人
                 */
                $("#senderSelect").click(function(){
                    var url = "${appDomain}/common/choose_all_user.htm" + "?id=" + $("#senderId").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#sender").val(value[1]);
                        $("#senderId").val(value[0]);
                    }
                });
			
		    
		      // 转发按钮点击事件
		    $(".edit").click(function(){
		        var url = "${appDomain}/msgInbox/edit_msgInbox.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=800px;dialogHeight=450px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/msgInbox/delete.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该信息？")) {
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
					
		            var url = "${appDomain}/msg/delete_msgInboxArray.htm"
		            $.get(url, {
		                idArray: value
		            }, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		   // 已读按钮点击事件
		    $(".sign").click(function(){
		        var url = "${appDomain}/msgInbox/read.htm?id=" + $(this).attr("alt");
		        if (confirm("确定读取该信息？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    // 批量已读按钮点击事件
		    $(".sign-btn").click(function(){
		    	// 被选中的单选框
		        var item = $("input[name=chkItem]:checked");
		        // 校验是否至少选择了一个单选框
		        if (item.length == 0) {
		            alert("请至少选择一条记录进行操作");
		            return false;
		        }
		        
		          if (confirm("确定读取所选信息？")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/msg/read_msgInboxArray.htm"
		            $.get(url, {
		                idArray: value
		            }, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		});
		
		</script>
	</head>
    <body>
        <div id="main">
        <div class="main_nav">
         <#include "msg/menu.ftl">
            <div id="content">                     
                <form id="listForm" name="listForm" action="${appDomain}/msg/msgInbox_list.htm" method="GET">
                   <div class="ct-top">
					<div  class="search-bk02">
						<span>标题：</span>
						<input type="text" class="sch-txt-more" name="title" value="${page.title}" />
						<span>发件日期：</span>
						<input type="text"  class="sch-txt-more" name="createDate" value="${page.createDate}" />
						<span>是否读取：</span>
            			 <select class="sel-txt" name="isRead">
            			        <option value="">请选择</option>        
        					 	<option value="Y" <#if page.isRead == "Y">selected="selected"</#if>>已读</option>
                              	<option value="N" <#if page.isRead == "N">selected="selected"</#if>>未读</option>                                       
                          </select>
                          <a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>
	                 <div class="btn-bk">
                       <a class="btn-add add-btn" href="${appDomain}/msg/write_list.htm">新增</a>
                        <a class="btn-del delete-btn" href="#">删除</a>
                         <a class="sign-btn" href="#">读取</a>
                       
                    </div>
	                 </div>	                      
	                   <div class="ct">
	                    <table class="list">
	                        <tr>
	                        	<th width="3%">
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>
								<th width="30%">标题</th>
								<th width="12%">发件人</th>
								<th width="15%">发件日期</th>
								<th width="15%">已读日期</th>	
								<th width="10%">操作</th>							
	                        </tr>
	                        <#list page.msgInboxList as msgInbox>
								<tr>
									<td>
		                                <input type="checkbox" name="chkItem" value=${msgInbox.id} />
		                            </td>
									<td class="left">
										<#if msgInbox.isRead == "Y">
											<label style="width:280px;"><a href="${appDomain}/msg/detail_msgInbox.htm?id=${msgInbox.id}">${msgInbox.title}</a></label>
										<#else>
											<strong><label style="width:380px;">${msgInbox.title}</label></strong>
										</#if>
									</td>
									<td class="left">${msgInbox.senderName}</td>
									<td>${msgInbox.createDate?datetime}</td>
									<td><#if msgInbox.isRead == "Y">
											${msgInbox.updateDate?datetime}
										<#else>
											<strong>-</strong>
										</#if></td>	
								    <td class="td-btn" width="10%">
                                  	  	<#if msgInbox.isRead == "Y">
											<a class="act-btn"  title="读取"  href="#" alt="${msgInbox.id}">读取</a>
										<#else>
											<a class="act-btn sign"  title="读取"  href="#" alt="${msgInbox.id}">读取</a>
											
										</#if>
                                    </td>								
								</tr>
							</#list>
	                        </tr>
	                    </table>
						<#include "common/page.ftl">
	                </div>
				</form>
				</div>
	        </div>
        </div>
         <script type="text/javascript">
            var ctHeight = document.documentElement.clientHeight;
            $("#content").height(ctHeight + "px");
        </script>
    </body>
</html>