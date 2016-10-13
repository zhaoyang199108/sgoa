<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>IP/MAC-列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    // 增加按钮点击事件
		    $(".add-btn").click(function(){
		        var url = "${appDomain}/ipmac/add.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=780px;dialogHeight=200px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		     //搜索按钮
		    
		     $("#searchBtn").click(function(){
		            $('form').submit();
             });
                
		    //双击事件
			$("table.list tr:not(:first)").dblclick(function(){
			
			   var url = "${appDomain}/ipmac/detail.htm?id=" + $(this).find("input[name=chkItem]").val() + "&r=" + Math.random();
			   var param = 'dialogWidth=780px;dialogHeight=200px;status=no;center=yes;scroll=no';
                var value = window.showModalDialog(url, '', param);
				
			  });
			  
		    // 更新按钮点击事件
		    $(".edit").click(function(){
		        var url = "${appDomain}/ipmac/edit.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=780px;dialogHeight=200px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/ipmac/delete.htm?id=" + $(this).attr("alt");
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
					
		            var url = "${appDomain}/ipmac/delete_batch.htm"
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
          <div class="main_nav">
          <#include "seal/menu.ftl">
            <div id="content">
                <div class="ct-top">
                <form id="listForm" name="listForm" action="${appDomain}/ipmac/list.htm" method="GET">
	                    <div class="search-bk">
	                      <span>IP名称:</span>
	                      <input class="sch-txt-more" type="text" name="optIp" value="${page.optIp}" />
	                      <span>MAC名称:</span>
	                      <input class="sch-txt-more" type="text" name="optMac" value="${page.optMac}" />
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
	                            <th class="left">
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>
								<th>IP名称</th>
								<th>MAC名称</th>
								<th>创建时间</th>
								<th>操作</th>
	                        </tr>
	                        <#list page.ipmacList as ipmac>
								<tr>
									<td width="3%" >
		                                <input type="checkbox" name="chkItem" value=${ipmac.id} />
		                            </td>
									<td width="30%"><label style="width:280px;">${ipmac.optIp}</label></td>
									<td width="30%"><label style="width:380px;">${ipmac.optMac}</label></td>
									<td width="20%">${ipmac.createDate?date}</td>
									<td class="td-btn" width="10%"">
										<a class="act-btn edit"  title="更新" href="#" alt="${ipmac.id}">更新</a>
										<a class="act-btn del" title="删除" href="#" alt="${ipmac.id}">删除</a>
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
    </body>
</html>