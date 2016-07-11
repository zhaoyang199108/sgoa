<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>协会条目</title>
        <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet"></head>
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js"defer="defer"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
			// 日期控件
			$("input[name=releaseDate]").click(function(){
				WdatePicker();
			});
			
		
		    // 增加按钮点击事件
		    $("#addBtn").click(function(){
		        var url = "${appDomain}/admin/xhtm/add_xhtm.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=720px;dialogHeight=220px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });

		    // 更新按钮点击事件
		    $(".act-update").click(function(){
		        var url = "${appDomain}/admin/xhtm/edit_xhtm.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=720px;dialogHeight=220px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 删除按钮点击事件
		    $(".act-delete").click(function(){
		        var url = "${appDomain}/admin/xhtm/delete_xhtm.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该信息？")) {
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
		        
		        if (confirm("确定删除所选信息？")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/admin/xhtm/delete_xhtmArray.htm"
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
    <body>
        <div id="main">
            <div id="content">
                <h3 class="title">协会条目管理页面</h3>
                <form id="listForm" name="listForm" action="${appDomain}/admin/xhtm/list.htm" method="GET">
					<div class="search">
	                	<ul>
							<li>条目: <input type="text" name="tmname" value="${page.tmname}" /></li>
							<li><input type="submit"  class="btn_clk" value="查询"/></li>
	                	</ul>
	                </div>
	                <div class="list">
	                    <div class="opt-btn">
	                        <ul class="select-btn">
	                        </ul>
	                        <ul class="action-btn">
	                            <li>
	                                <a id="addBtn" class="action-opt action-new" href="#">新增</a>
	                            </li> 
	                        </ul>
	                    </div>
	                    <table class="list-info">
	                        <tr>
	                        	<th width="6%">序号</th>
								<th>条目</th>
								<th>类型</th>
	                            <th colspan="2" width="10%">操作</th>
	                        </tr>
	                        <#list page.xhtmList as xhtm>
								<tr>
									<td class="txt_center">
		                                ${xhtm.id}
		                            </td>
									<td class="txt_center">${xhtm.tmname}</td>
									<td class="txt_center">
									<#if xhtm.lx == 1>文本</#if>
									<#if xhtm.lx == 2>单选</#if>
									<#if xhtm.lx == 3>连选</#if>
									<#if xhtm.lx == 4>多文本</#if>
									<#if xhtm.lx == 5>图片</#if>
									</td>
									<#if xhtm.id == 1 || xhtm.id == 2 || xhtm.id == 3 || xhtm.id == 4 || xhtm.id == 5 || xhtm.id == 6 || xhtm.id == 7 || xhtm.id == 8 || xhtm.id == 9 >
									<td width="42px" class="txt_center">-</td>
									<td width="42px" class="txt_center">-</td>
									<#else>
									<td width="42px"><a class="action-opt act-update" href="#" alt="${xhtm.id}">修改</a></td>
									<td width="42px"><a class="action-opt act-delete" href="#" alt="${xhtm.id}">删除</a></td>
									</#if>
								</tr>
							</#list>
	                        </tr>
	                    </table>
						<#include "admin/common/page.ftl">
	                </div>
				</form>
	        </div>
        </div>
    </body>
</html>