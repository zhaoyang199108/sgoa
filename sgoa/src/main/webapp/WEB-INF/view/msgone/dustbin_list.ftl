<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>已删文件列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	     <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
	    <script type="text/javascript">
		$(document).ready(function() {
		
           // 日期控件
			$("input[name=createDate]").click(function(){
				WdatePicker();
			});     
			
			     /**
                 * 发件人选择按钮事件,弹出对话框选择发件人
                 */
                $("#senderSelect").click(function(){
                    var url = "${appDomain}/common/choose_one_user.htm" + "?id=" + $("#senderId").val() + "&r=" + Math.random();
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
		  
	
	             /**
	        	 * 点击查询按钮
	        	 */
                $("#searchBtn").click(function(){
		            $('form').submit();
                });
	 
		 // 删除按钮点击事件
		    $(".del").click(function(){	
		    alert($(this).attr("alt"));
		        var url = "${appDomain}/msgone/delete_one.htm?" + $(this).attr("alt");
		        if (confirm("确定删除该文稿拟订")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
			 // 恢复按钮点击事件
		    $(".update").click(function(){
		    	
		        var url = "${appDomain}/msgone/regain.htm?" + $(this).attr("alt");
		        if (confirm("确定恢复该文稿拟订")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		  
		      // 批量恢复按钮点击事件
		    $("#updateBatchBtn").click(function(){
		        // 被选中的单选框
		        var item = $("input[name=chkItem]:checked");
		        // 校验是否至少选择了一个单选框
		        if (item.length == 0) {
		            alert("请至少选择一条记录进行操作");
		            return false;
		        }
		        
		        if (confirm("确定删除所选文稿拟订")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/msgone/regain_dustbin_one.htm"
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
           <#include "msgone/menu.ftl">
            <div id="content">                              
                <form id="messageForm" name="messageForm" action="${appDomain}/msgone/dustbin_list.htm" method="GET">
	                <div class="ct-top">
                    <div  class="search-bk01">
                		<span>发件人：</span>
	                    <input class="sch-txt-more" id="sender" name="sender" type="text" value="" readonly="readonly" />
	                    <a id="senderSelect" href="#" class="search-btn">选择</a>
	                    <input class="txt title" type="hidden" id="senderId" name="senderId" value="" />
						<span>标题：</span>
						<input class="sch-txt-more" type="text" name="title" value="${page.title}" />
						<span>发件日期：</span>
						<input class="sch-txt-more" type="text" name="createDate" value="${page.createDate}" />
						<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>
	                 <div class="btn-bk">
                       <a class="btn-add add-btn" href="${appDomain}/msgone/write_list.htm">新增</a>
                        <a class="btn-del delete-btn" href="#">删除</a>
                        
                    </div>
	                 </div>	                      
	                     <div class="ct">
	                    <table class="list">
	                        <tr>
	                        	<th width="3%">
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>                        	
								<th>标题</th>
								<th width="20%">发件人</th>
								<th width="20%">发件日期</th>    
							    <th width="10%">操作</th>          
	                         </tr>
	                        <#list page.msgoneInboxList as msgoneInbox>
								<tr>
									<td>
		                                <input type="checkbox" name="chkItem" value="id=${msgoneInbox.id}&msgoneType=${msgoneInbox.msgoneType}" />
		                                <input type="hidden" name="msgoneType" value="${msgoneInbox.msgoneType}"/>
		                            </td>       
									<td class="left"><label style="width:280px;"><a href="${appDomain}/dustbin/edit_msgoneDustbin.htm?id=${msgoneInbox.id}&msgoneType=${msgoneInbox.msgoneType}" >${msgoneInbox.title}</a>	</label></td>
									<td class="left">${msgoneInbox.senderName}</td>
									<td>${msgoneInbox.createDate?datetime}</td>
								    <td class="td-btn" width="7%"">
							            <a class="act-btn update"  title="恢复" href="#" alt="id=${msgoneInbox.id}&msgoneType=${msgoneInbox.msgoneType}">恢复</a>	
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