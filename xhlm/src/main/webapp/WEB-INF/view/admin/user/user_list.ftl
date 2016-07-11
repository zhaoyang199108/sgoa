<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>会员列表</title>
        <link href="${cssDomain}/css/main.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    // 审核按钮点击事件
		    $(".act-update").click(function(){
		        var url = "${appDomain}/admin/user/edit_user.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=500px;dialogHeight=650px;status=no;center=yes;scroll=yes';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		      // 推荐按钮点击事件
		    $(".tj").click(function(){
		        var url = "${appDomain}/admin/user/tj_user.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=500px;dialogHeight=200px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 权限按钮点击事件
		    $(".act-role").click(function(){
		        var url = "${appDomain}/admin/user/user_role.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=780px;dialogHeight=580px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		     // 禁用按钮点击事件
		    $(".act-end").click(function(){
		        var url = "${appDomain}/admin/user/end_user.htm?id=" + $(this).attr("alt");
		        if (confirm("确定禁用该会员？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		    // 批量禁用按钮点击事件
		    $("#endBatchBtn").click(function(){
		        // 被选中的单选框
		        var item = $("input[name=chkItem]:checked");
		        // 校验是否至少选择了一个单选框
		        if (item.length == 0) {
		            alert("请至少选择一条记录进行操作");
		            return false;
		        }
		        
		        if (confirm("确定禁用所选会员?")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/admin/user/end_userArray.htm"
		            $.get(url, {
		                idArray: value
		            }, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		     // 开启按钮点击事件
		    $(".act-start").click(function(){
		        var url = "${appDomain}/admin/user/start_user.htm?id=" + $(this).attr("alt");
		        if (confirm("确定开启该会员？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		    // 删除按钮点击事件
		    $(".act-delete").click(function(){
		        var url = "${appDomain}/admin/user/delete_user.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该会员？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		     // 企业按钮点击事件
		    $(".detail").click(function(){
		    	 var messageId = $(this).attr("alt");
				 doMinute(messageId);
		    });
		    
		       //双击事件
			$("table.list-info tr:not(:first)").dblclick(function(){
			   var url = "${appDomain}/admin/user/xx_user.htm?id=" + $(this).find("input[name=chkItem]").val() + "&r=" + Math.random();
			   var param = 'dialogWidth=500px;dialogHeight=650px;status=no;center=yes;scroll=yes';
               var value = window.showModalDialog(url, '', param);
			  });
			  
			// 详细按钮点击事件
		    $(".xx").click(function(){
		    	var url = "${appDomain}/admin/user/xx_user.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
			   	var param = 'dialogWidth=500px;dialogHeight=650px;status=no;center=yes;scroll=yes';
                var value = window.showModalDialog(url, '', param);
				 doMinute(userId);
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
		        
		        if (confirm("确定删除所选会员?")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/admin/user/delete_userArray.htm"
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
		var url = "${appDomain}/admin/user/user_detail.htm?id=" + messageId;
		        var param = 'dialogWidth=800px;dialogHeight=520px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        
		}
		</script>
		<style type="text/css">
		.top{ margin:5px auto; color:#990000; text-align:center;}
		.info select{ border:1px #9bd1f9 solid; background:#FFFFFF;}
		.info{ float:left; text-align:center;}
		.info #show{ color:#3399FF; }
		.bottom{ text-align:right; font-size:12px; color:#CCCCCC; width:1000px;}
		</style>
	</head>
    <body>
        <div id="main">
            <div id="content">    
             <h3 class="title">会员列表页面</h3>              
                <form id="userForm" name="userForm" action="${appDomain}/admin/user/user_list.htm" method="GET">
	              <div class="search">
	              <ul>
                		<li>用户名:<input class="sch-txt-more" type="text" name="loginId" value="${page.loginId}" /></li>
						<li>选择行业:
						<select class="sel-txt" name="sortId">
						      <option value="">请选择</option>
					          <#list sortdetailPage as sortdetail>
                		      <option value="${sortdetail.id}" <#if sortdetail.id == page.sortId> selected="selected"</#if>> ${sortdetail.name} </option>
                              </#list>
                         </select>
						</li>
						<li><div class="info">选择区域:</div><div class="info">
							<div>
							<select id="s_province" name="s_province" value="${page.s_province}"></select>  
						    <select id="s_city" name="s_city" value="${page.s_city}"></select>  
						    <select id="s_county" name="s_county" value="${page.s_county}"></select>
						    <script class="resources library" src="${jsDomain}/js/area.js" type="text/javascript"></script>
						    
						    <script type="text/javascript">_init_area();</script>
						    </div>
						</div></li>
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
	                                 <a id="delBatchBtn" class="action-opt action-del" href="#">删除</a>
	                            </li>
	                            <li>
	                                 <a id="endBatchBtn" class="action-opt action-del" href="#">禁用</a>
	                            </li>
	                        </ul>
	                    </div>
	                   
	                    <table class="list-info">
	                        <tr>
	                        	<th>选择</th>
								<th>用户名</th>
								<th>名称</th>
								<th>行业</th>
								<th>区域</th>
								<th>入驻</th>
								<th>注册时间</th>	
								<th>状态</th>	
								<th>类型</th>
								<th>推荐</th>	
	                        	<th>操作</th>						                           
	                        </tr>
	                        <#list page.userList as user>
								<tr>
									<td width="3%">
		                                <input type="checkbox" name="chkItem" value=${user.id} />
		                            </td>
									<td width="7%">${user.loginId}</td>
									<td width="16%"><a class="xx" alt="${user.id}">${user.userName}</a></td>
									<td width="9%">${user.name}</td>
									<td width="10%">${user.s_province},${user.s_city},${user.s_county}</td>
									<td>${user.userNamep}</td>
									<td width="10%">${user.createDate?datetime}</td>		
									<td width="3%">
									<#if user.type == 1>
										<#if user.status == 1>正常</#if>
										<#if user.status == 2>待审</#if>
									<#else>
										<#if user.inStatus == 1>正常</#if>
										<#if user.inStatus == 2>待审</#if>
									</#if>
									</td>						
									<td width="3%"><#if user.type == 1>协会</#if>
									<#if user.type == 2>企业</#if>
									<#if user.type == 3>平台</#if>
									<#if user.type == 4>盲客</#if>
									</td>	
									<td width="2%"><#if user.tj == 1>是
									<#else>否</#if></td>																									
		                            <td class="td-btn" width="22%">
		                            	<#if user.type == 1>
											<#if user.status == 2>
												<a class="action-opt act-update" href="#" title="审核" alt="${user.id}">审核</a>
											</#if>
										<#else>
											<#if user.inStatus == 2>
												<a class="action-opt act-update" href="#" title="审核" alt="${user.id}">审核</a>
											</#if>
										</#if>
										<#if user.type == 1>
										<a class="action-opt detail" href="#" title="企业" alt="${user.id}">企业</a>
										</#if>
										<#if user.type == 1>
										<a class="action-opt tj" href="#" title="推荐" alt="${user.id}">推荐</a>
										</#if>
										<a class="action-opt act-role" href="#" title="权限" alt="${user.id}">权限</a>
										<a class="action-opt act-delete" href="#" title="删除" alt="${user.id}">删除</a>
										<a class="action-opt act-end" href="#" title="禁用" alt="${user.id}">禁用</a>
										<a class="action-opt act-start" href="#" title="开启" alt="${user.id}">开启</a>
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
        <script type="text/javascript">
		var Gid  = document.getElementById ;
		var showArea = function(){
			Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
			Gid('s_city').value + " - 县/区" + 
			Gid('s_county').value + "</h3>"
									}
		Gid('s_county').setAttribute('onchange','showArea()');
		</script>
    </body>
</html>