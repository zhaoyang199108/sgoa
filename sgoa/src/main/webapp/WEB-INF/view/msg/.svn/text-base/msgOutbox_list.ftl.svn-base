<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>已发文件-列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
			// 日期控件
			$("input[name=createDate]").click(function(){
				WdatePicker();
			});
			
			    /**
                 * 收件人选择按钮事件,弹出对话框选择收件人
                 */
                $("#receiverSelect").click(function(){
                    var url = "${appDomain}/common/choose_all_user.htm" + "?ids=" + $("#receiverIds").val() + "&r=" + Math.random();
                    var param = 'dialogWidth=780px;dialogHeight=420px;status=no;center=yes;scroll=no';
                    var value = window.showModalDialog(url, '', param);
                    if(value==undefined)
			        	{
			        		  return false;
			     	    }
                    if (value.length > 0) {
                        $("#receiver").val(value[1]);
                        $("#receiverIds").val(value[0]);
                    }
                });
		    
		      // 转发按钮点击事件
		    $(".edit").click(function(){
		        var url = "${appDomain}/msg/edit_msgOutbox.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=800px;dialogHeight=450px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/msg/delete.htm?id=" + $(this).attr("alt");
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
					
		            var url = "${appDomain}/msg/delete_msgOutboxArray.htm"
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
                <form id="listForm" name="listForm" action="${appDomain}/msg/msgOutbox_list.htm" method="GET">
                   <div class="ct-top">
					<div  class="search-bk01">
						<span>收件人：</span>
	                    <input class="sch-txt-more" id="receiver" name="receiver" type="text" value="" readonly="readonly"/>
	                    <a id="receiverSelect" href="#" class="search-btn">选择</a>
	                    <input class="txt title" type="hidden" id="receiverIds" name="receiverIds" value="" />
                		<span>标题：</span>
                		<input type="text" class="sch-txt-more" name="title" value="${page.title}" />
						<span>发件日期：</span>
						<input type="text" class="sch-txt-more" name="createDate" value="${page.createDate}" />
						<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>
	                 <div class="btn-bk">
                       <a class="btn-add add-btn" href="${appDomain}/msg/write_list.htm">新增</a>
                        <a class="btn-del delete-btn" href="#">删除</a>
                    </div> 
	                 </div>	                      
	                   <div class="ct">
	                    <table class="list">
	                        <tr>
	                        	<th width="3%">
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>
								<th >标题</th>
								<th width="20%">收件人</th>
								<th width="20%">发件日期</th>
	                        </tr>
	                        <#list page.msgOutboxList as msgOutbox>
								<tr>
									<td>
		                                <input type="checkbox" name="chkItem" value=${msgOutbox.id} />
		                            </td>
									<td class="left"><label style="width:280px;"><a href="${appDomain}/msg/detail_msgOutbox.htm?id=${msgOutbox.id}">${msgOutbox.title}</a></label></td>
									<td class="left">${msgOutbox.receiverNames}</td>
									<td>${msgOutbox.createDate?datetime}</td>
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