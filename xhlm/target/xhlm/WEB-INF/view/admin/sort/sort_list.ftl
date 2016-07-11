<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>分类列表</title>
        <link href="${cssDomain}/css/main.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    // 增加按钮点击事件
		    $("#addBtn").click(function(){
		        var url = "${appDomain}/admin/sort/add_sort.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=720px;dialogHeight=220px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 更新按钮点击事件
		    $(".act-update").click(function(){
		        var url = "${appDomain}/admin/sort/edit_sort.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=720px;dialogHeight=220px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    		    
		    // 删除按钮点击事件
		    $(".act-delete").click(function(){
		        var url = "${appDomain}/admin/sort/delete_sort.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该分类？")) {
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
					
		            var url = "${appDomain}/admin/sort/delete_sortArray.htm"
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
            <div id="content">    
             <h3 class="title">分类列表页面</h3>              
                <form id="sortForm" name="sortForm" action="${appDomain}/admin/sort/list.htm" method="GET">
	              <div class="search">
					<ul>
                		<li>名称:<input class="sch-txt-more" type="text" name="name" value="${page.name}" /></li>
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
	                            <li>
	                                <a id="addBtn" class="action-opt action-new" href="#">新增</a>
	                            </li>
	                            <li>
	                                 <a id="delBatchBtn" class="action-opt action-del" href="#">删除</a>
	                            </li>
	                        </ul>
	                    </div>
	                   
	                    <table class="list-info">
	                        <tr>
	                        	<th>选择</th>
								<th>分类</th>		
	                        	<th>操作</th>						                           
	                        </tr>
	                        <#list page.sortList as sort>
								<tr>
									<td width="3%">
		                                <input type="checkbox" name="chkItem" value=${sort.id} />
		                            </td>
									<td>${sort.name}</td>																							
		                            <td class="td-btn" width="12%">
		                            <#if sort.id==1||sort.id==2 ||sort.id==3>
		                            <a class="action-opt detail" href="${appDomain}/admin/sortdetail/list.htm?sortId=${sort.id}" title="详细" alt="${sort.id}">详细</a>
		                            </#if>
		                            <#if sort.id!=1&&sort.id!=2 &&sort.id!=3>
		                           		<a class="action-opt detail" href="${appDomain}/admin/sortdetail/list.htm?sortId=${sort.id}" title="详细" alt="${sort.id}">详细</a>
										<a class="action-opt act-update" href="#" title="更新" alt="${sort.id}">修改</a>
										<a class="action-opt act-delete" href="#" title="删除" alt="${sort.id}">删除</a>
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