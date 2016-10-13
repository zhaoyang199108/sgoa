<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>签章模块列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    // 增加按钮点击事件
		    $(".add-btn").click(function(){
		        var url = "${appDomain}/buttonname/add_buttonname.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=880px;dialogHeight=350px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 更新按钮点击事件
		    $(".edit").click(function(){
		        var url = "${appDomain}/buttonname/buttonname_edit.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=880px;dialogHeight=350px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		   
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/buttonname/delete_buttonname.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该按钮信息？")) {
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
		        
		        if (confirm("确定删除所选签章?")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/buttonname/delete_buttonnameArray.htm"
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
		var url = "${appDomain}/buttonname/buttonname_detail.htm?id=" + messageId;
		        var param = 'dialogWidth=800px;dialogHeight=350px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        
		}
		</script>
	</head>
    <body>
        <div id="main">
         <div class="main_nav">
            <#include "seal/menu.ftl">
            <div id="content">                  
                <form id="sealForm" name="sealForm" action="${appDomain}/buttonname/buttonname_list.htm" method="POST">
                <div class="ct-top">
	              <div class="search-bk">
                		<span>按钮名称:</span>
                		<input class="sch-txt-more" type="text" name="btnName" value="${page.btnName}" />
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
								<th>职责</th>
								<th>模块名称</th>
								<th>模块类别</th>
								<th>按钮名称</th>
								<th>操作</th>	                            
	                        </tr>
	                        <#list page.buttonNameList as buttonName>
								<tr>
									<td width="3%">
		                                <input type="checkbox" name="chkItem" value=${buttonName.id} />
		                            </td>
									<td width="12%">${buttonName.grpoName}</td>
									<td width="12%">
										<#if buttonName.module == '1'>通知模块
										<#elseif buttonName.module == '2'>公告模块
										<#elseif buttonName.module == '3'>发文模块
										<#elseif buttonName.module == '4'>收文模块
					                    </#if>
									</td>
									<td width="12%">
										<#if buttonName.moduleType == '1'>列表页面
										<#elseif buttonName.moduleType == '2'>审核页面
					                    </#if>
									</td>
									<td width="12%">${buttonName.btnName}</td>
									<td class="td-btn" width="15%"">
										<a class="act-btn  detail" href="#" title="查看" alt="${buttonName.id}">查看</a>
										<a class="act-btn  edit" href="#" title="更新" alt="${buttonName.id}">更新</a>
										<a class="act-btn  del" href="#" title="删除" alt="${buttonName.id}">删除</a>
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