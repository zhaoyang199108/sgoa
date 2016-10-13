<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>用户列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    $('input[name=sorting]').change(function(){
		      var url = "${appDomain}/user/editSo_user.htm?id=" +  $(this).attr("alt")+ "&sorting="+ $(this).val() +"&r=" + Math.random();
		      if (confirm("确定修改？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').attr("action", "${appDomain}/user/user_list.htm");
		                $('form').submit();
		            });
		        }
		     
		     });
		     
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/user/delete_user.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该用户？")) {
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
		        
		        if (confirm("确定删除所选用户?")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/user/delete_userArray.htm"
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
            <#include "user/menu.ftl">
            <div id="content">                  
                <form id="userForm" name="userForm" action="${appDomain}/user/user_list.htm" method="GET">
                <div class="ct-top">
	              <div class="search-bk01">
                		<span>登录ID:</span>
                		<input class="sch-txt-more" type="text" name="loginId" value="${page.loginId}" />
						<span>姓名:</span>
						<input class="sch-txt-more" type="text" name="userName" value="${page.userName}" />
						<span>部门:</span>
						<select class="sel-txt" name="deptId">
						      <option value="">请选择</option>
					          <#list deptPage as dept>
                		      <option value="${dept.id}" <#if dept.id == page.deptId> selected="selected"</#if>> ${dept.deptName} </option>
                              </#list>
                         </select>
                         <a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>	                
	                
	                <div class="btn-bk">
                       <a class="btn-add add-btn" href="${appDomain}/user/add_user.htm">新增</a>
                        <a class="btn-del delete-btn" href="#">删除</a>
                        
                    </div>  
	                </div>
	                    <div class="ct">
	                    <table class="list">
	                        <tr>
	                        	<th>
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>
								<th>登录ID</th>
								<th>姓名</th>
								<th>性别</th>
								<th>部门名称</th>															
								<th>更新日期</th>
								<th>排序号</th>		
	                        	<th>操作</th>						                           
	                        </tr>
	                        <#list page.userList as user>
								<tr>
									<td width="3%">
		                                <input type="checkbox" name="chkItem" value=${user.id} />
		                            </td>
									<td width="13%">${user.loginId}</td>
									<td width="17%">${user.userName?html}</td>
									<td width="6%"><#if user.gender==1>男
									<#else>女</#if></td>							
									<td width="23%">${user.deptName}</td>																		
									<td width="15%">${user.updateDate?date}</td>
									<td width="6%"><input style="width:70%;" class="text" type="text" name="sorting" value="${user.sorting}" alt="${user.id}"/></td>																							
		                            <td class="td-btn" width="15%">
										<a class="act-btn edit" href="${appDomain}/user/edit_user.htm?id=${user.id}" title="更新">更新</a>
										<a class="act-btn detail" href="${appDomain}/user/user_detail.htm?id=${user.id}" title="详细">详细</a>
										<a class="act-btn del" href="#" title="删除" alt="${user.id}">删除</a>
										<a class="act-btn" href="${appDomain}/userkey/add_user_key.htm?loginId=${user.loginId}" title="UKEY">UKEY</a>
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
        </div>
        <script type="text/javascript">
            var ctHeight = document.documentElement.clientHeight;
            $("#content").height(ctHeight + "px");
        </script>
    </body>
</html>