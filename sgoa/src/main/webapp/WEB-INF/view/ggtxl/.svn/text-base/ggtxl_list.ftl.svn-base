<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>物资设备列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    // 增加按钮点击事件
		    $(".add-btn").click(function(){
		        var url = "${appDomain}/ggtxl/add_ggtxl.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=880px;dialogHeight=550px;status=no;center=yes;scroll=yes';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 更新按钮点击事件
		    $(".edit").click(function(){
		        var url = "${appDomain}/ggtxl/ggtxl_edit.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=880px;dialogHeight=550px;status=no;center=yes;scroll=yes';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		   
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/ggtxl/delete_ggtxl.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该公共通讯录？")) {
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
		        
		        if (confirm("确定删除所选公共通讯录?")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/ggtxl/delete_ggtxlArray.htm"
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
		var url = "${appDomain}/ggtxl/ggtxl_detail.htm?id=" + messageId;
		        var param = 'dialogWidth=800px;dialogHeight=550px;status=no;center=yes;scroll=yes';
		        var val = window.showModalDialog(url, '', param);
		        
		}
		</script>
	</head>
    <body>
        <div id="main">
         <div class="main_nav">
            <#include "ggtxl/menu.ftl">
            <div id="content">                  
                <form id="ggtxlForm" name="ggtxlForm" action="${appDomain}/ggtxl/ggtxl_list.htm" method="GET">
                <div class="ct-top">
	              <div class="search-bk">
                		<span>姓名:</span>
                		<input class="sch-txt-more" type="text" name="addName" value="${page.addName}" />
						<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>	                
	                
	                <div class="btn-bk">
                       <a class="btn-add add-btn" href="#">新增</a>
                        <a class="btn-del delete-btn" href="#">删除</a>
                        
                    </div>  
	                </div>
	                    <div class="ct">
	                    <table class="list">
	                         <tr>
	                        	<th>
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>
								<th>姓名</th>
								<th>性别</th>
								<th>年龄</th>
								<th>职务</th>
								<th>工作电话</th>
								<th>操作</th>	                            
	                        </tr>
	                        <#list page.ggtxlList as ggtxl>
								<tr>
									<td width="3%">
		                                <input type="checkbox" name="chkItem" value=${ggtxl.id} />
		                            </td>
									<td width="12%">${ggtxl.addName}</td>
									<td width="12%">
										<#if ggtxl.gender==1>男
										<#else>女</#if>
									</td>
									<td width="12%">${ggtxl.age}</td>
									<td width="12%">${ggtxl.duties}</td>
									<td width="12%">${ggtxl.unitTel}</td>
									<td class="td-btn" width="15%"">
										<a class="act-btn  detail" href="#" title="查看" alt="${ggtxl.id}">查看</a>
										<a class="act-btn  edit" href="#" title="更新" alt="${ggtxl.id}">更新</a>
										<a class="act-btn  del" href="#" title="删除" alt="${ggtxl.id}">删除</a>
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