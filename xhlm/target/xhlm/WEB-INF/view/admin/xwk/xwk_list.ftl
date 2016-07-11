<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>新闻库列表</title>
        <link href="${cssDomain}/css/main.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    // 增加按钮点击事件
		    $("#addBtn").click(function(){
		        var url = "${appDomain}/admin/xwk/add_xwk.htm";
		        var param = 'dialogWidth=720px;dialogHeight=600px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 更新按钮点击事件
		    $(".act-update").click(function(){
		        var url = "${appDomain}/admin/xwk/edit_xwk.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=720px;dialogHeight=600px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 删除按钮点击事件
		    $(".act-delete").click(function(){
		        var url = "${appDomain}/admin/xwk/delete_xwk.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该分类？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		     // 详细按钮点击事件
		    $(".act-detail").click(function(){		    	 
		    	 var messageId = $(this).attr("alt");
				 doMinute(messageId);
		    });
		    		    			
		        /**
	        	 * 点击查询按钮
	        	 */
                $("#searchBtn").click(function(){
		            $('form').submit();
                });
		    
		     // 发布按钮点击事件
		    $(".act-release").click(function(){
		        var url = "${appDomain}/admin/xhxw/release_xhxw.htm?id=" + $(this).attr("alt");
		        if (confirm("确定发布该新闻？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		    // 批量删除按钮点击事件
		    $("#delBatchBtn").click(function(){
		        // 被选中的单选框
		        var item = $("input[name=chkItem]:checked");
		        // 校验是否至少选择了一个单选框
		        if (item.length == 0) {
		            alert("请至少选择一条记录进行操作");
		            return false;
		        }
		        
		        if (confirm("确定删除所选分类?")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/admin/xwk/delete_xwkArray.htm"
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
			var url = "${appDomain}/admin/xwk/detail_xwk.htm?id=" + messageId;
		    var param = 'dialogWidth=720px;dialogHeight=600px;status=no;center=yes;scroll=no';
		    var val = window.showModalDialog(url, '', param);
		}
		</script>
	</head>
    <body>
        <div id="main">
            <div id="content">    
             <h3 class="title">新闻库列表页面</h3>              
                <form id="xwkForm" name="xwkForm" action="${appDomain}/admin/xwk/list.htm" method="GET">
	              <div class="search">
					<ul>
                		<li>标题:<input class="sch-txt-more" type="text" name="title" value="${page.title}" /></li>
                		<li><input type="submit" id="searchBtn" class="btn_clk" value="查询"/></li>
                       </ul>
	                </div>
	                <div class="list">                    
                     <div class="opt-btn">
	                        <ul class="select-btn">
	                            <li>
	                                <input id="allBtn" type="checkbox" value="" />全选
	                            </li>
	                            <li>
	                                <input id="oppBtn" type="checkbox" value="" />反选
	                            </li>
	                        </ul>
	                        <ul class="action-btn">
	                        <#if user.type==3>
	                            <li>
	                                <a id="addBtn" class="action-opt action-new" href="#" >新增</a>
	                            </li>
	                            
	                            <li>
	                                 <a id="delBatchBtn" class="action-opt action-del" href="#">删除</a>
	                            </li>
	                            </#if>
	                        </ul>
	                    </div>
	                   
	                    <table class="list-info">
	                        <tr>
	                        	<th>选择</th>
								<th>标题</th>		
	                        	<th>行业</th>
	                        	<th>出处</th>
	                        	<th>时间</th>
	                        	<th>操作</th>						                           
	                        </tr>
	                        <#list page.xwkList as xwk>
								<tr>
									<td width="3%">
		                                <input type="checkbox" name="chkItem" value=${xwk.id} />
		                            </td>
									<td>${xwk.title}</td>
									<td>${xwk.sortName}</td>
									<td>${xwk.cc}</td>
									<td>${xwk.releaseDate}</td>
		                            <td class="td-btn" width="20%">
		                            <a class="action-opt act-detail" href="#" title="更新" alt="${xwk.id}">详细</a>
		                            <#if user.type==3>
		                            <a class="action-opt act-update" href="#" title="更新" alt="${xwk.id}">修改</a>
									<a class="action-opt act-delete" href="#" title="删除" alt="${xwk.id}">删除</a>
		                            </#if>
		                            <#if user.type==1>
										<a class="action-opt act-release" href="#" title="发布" alt="${xwk.id}">发布</a>										
									</#if>
									</td>
								</tr>
							</#list>
	                        </tr>
	                    </table>
						<#include "admin/common/page.ftl">
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