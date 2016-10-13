<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>审批流程列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
			// 增加按钮点击事件
		    $(".add-btn").click(function(){
		        var url = "${appDomain}/approval/add_approval.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=880px;dialogHeight=200px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 更新按钮点击事件
		    $(".edit").click(function(){
		        var url = "${appDomain}/approval/approval_edit.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=880px;dialogHeight=200px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
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
		
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/approval/delete_approval.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该审批流程？")) {
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
		        
		        if (confirm("确定删除所选审批流程?")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/approval/delete_approvalArray.htm"
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
		var url = "${appDomain}/approval/approval_detail.htm?id=" + messageId;
		        var param = 'dialogWidth=880px;dialogHeight=200px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        
		}
		</script>
	</head>
    <body>
        <div id="main">
         <div class="main_nav">
            <#include "seal/menu.ftl">
            <div id="content">                          
                <form id="approvalForm" name="approvalForm" action="${appDomain}/approval/approval_list.htm" method="POST">
                <div class="cont_nav">
                <div class="ct-top">
	              <div class="search-bk">
                		<span>审批流程名称:</span>
                		<input class="sch-txt-more" type="text" name="approvalName" value="${page.approvalName}" />
						<a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>	                
	                
	                <div class="btn-bk">
	                	<a class="btn-add add-btn" href="#">新增</a>
                        <a class="btn-del delete-btn" href="#">删除</a>
                    </div>  
	                </div>
	                    <div class="ct">
	                   <table class="list" cellpadding="0" cellspacing="0" >
	                         <tr>
	                        	<th>
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>
								<th>审批流程名称</th>
								<th>审批流程分类</th>
								<th>操作</th>	                            
	                        </tr>
	                        <#list page.approvalList as approval>
								<tr>
									<td width="5%">
		                                <input type="checkbox" name="chkItem" value=${approval.id} />
		                            </td>
									<td>${approval.approvalName}</td>
									<td width="25%">
										<#if approval.approvalType=='X'>通知公告</#if>
										<#if approval.approvalType=='Y'>收文</#if>
										<#if approval.approvalType=='Z'>发文</#if>
										<#if approval.approvalType=='W'>发文办事</#if>		
										<#if approval.approvalType=='U'>会议预约</#if>
										<#if approval.approvalType=='J'>要情简报</#if>
									</td>			
								   <td width="15%"><span class="cz">
										<a class="act-btn  detail" href="#" title="查看" alt="${approval.id}">查看</a>
										<a class="act-btn  edit" href="#" title="更新" alt="${approval.id}">更新</a>
										<a class="act-btn  del" href="#" title="删除" alt="${approval.id}">删除</a>
									 </span></td>							
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
		$("table.list tr:not(:first)").mouseover(function() {
		$(this).css("background-color", "#F9F9F9");
		});
		$("table.list tr:not(:first)").mouseout(function() {
			$(this).css("background-color", "#ffffff");
		});
        </script>
    </body>
</html>