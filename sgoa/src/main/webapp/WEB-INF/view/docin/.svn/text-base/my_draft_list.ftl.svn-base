<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>我的拟稿列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
        <script type="text/javascript">
        	$(document).ready(function(){
        	
                
            // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/docin/del_docin.htm?id=" + $(this).attr("alt");
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
					
		            var url = "${appDomain}/docin/delete_docinArray.htm"
		            $.get(url, {
		                idArray: value
		            }, function(result){
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
                
            });
        </script>
    </head>
    <body>
        <div id="main">
         <div class="main_nav">
            <#include "docin/menu.ftl">
            
            <div id="content">
            	<form id="docinForm" name="docinForm" action="${appDomain}/docin/my_draft_list.htm" method="GET">
	                <div class="ct-top">
	                 <div class="search-bk">
							<span>标题：</span>
							<input type="text" class="sch-txt" name="title" value="${page.title}" />
	                 		<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                 	</div>
	                    <div class="btn-bk">
	                        <a class="add-btn" href="${appDomain}/docin/add_docin.htm">新增</a>
	                        <a class="delete-btn" href="#">删除</a>
	                       
	                    </div>
	                    <div class="search-bk">
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
		                                <input type="checkbox" name="chkItem" value="${docin.id}" />
		                            </td>
		                          
		                            <td class="left"><label style="width:380px;">${docin.title}</label></td>
		                            <td>${docin.fileNum}</td>
		                            <!--<td>${docin.textTime}</td>-->
		                            <td>${docin.fileDept}</td>
		                             <td class="td-btn" width="10%"">
			                            	<a class="act-btn edit" href="${appDomain}/docin/edit_docin.htm?id=${docin.id}" title="更新">更新</a>
			                            	<a class="act-btn del" href="#" alt="${docin.id}" title="删除">删除</a>
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
        <script type="text/javascript">
            var ctHeight = document.documentElement.clientHeight;
            $("#content").height(ctHeight + "px");
        </script>
    </body>
</html>