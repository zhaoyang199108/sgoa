<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>菜单栏</title>
        <link href="${cssDomain}/css/frame.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/chili-1.7.pack.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/jquery.easing.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/jquery.dimensions.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/jquery.accordion.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/left.js"></script>
        <script type="text/javascript">
			$(document).ready(function(){
			    // 增加按钮点击事件
			    $(".sort-head").click(function(){
			    	var sortId = $(this).attr("alt");
			    	var detaliMenu = "#detail"+sortId;
			        $.ajax({
		                type: 'GET',
		                contentType: 'application/json',
		                url: '${appDomain}/admin/left_sort_detail.htm',
		                dataType: 'json',
		                data: 'sortId=' + sortId + '&r=' + Math.random(),
		                success: function(data){
		                    // 设置部门用户列表,并设置选中部门背景色
		                    // 设置用户列表
					        $(detaliMenu).find("li").remove();
					        // 如果当前用户已经被选择,此单选框默认选中
					        $.each(data, function(i, detail){
					            var newTr = "<li>";
					            var url = "${appDomain}/admin/"+detail.action+"/list.htm?sortId="+detail.id;
					            newTr = newTr + "<a href=\""+url+"\" alt=\""+detail.id+"\" target=\"mainFrame\">"+detail.name+"</a>";
					            newTr = newTr + "</li>";
					            $(newTr).appendTo($(detaliMenu));
					        });
		                },
		                error: function(){
		                    alert("取得人员失败,请联系管理员");
		                }
		            });
			    });
		    });
		</script>
    </head>
    <body>
        <div id="left">
            <ul id="navigation">
            	<li>
                    <a class="head" href="#">信息管理</a>
                    <ul>
						<li>
						    <a href="${appDomain}/admin/notice/list.htm" target="mainFrame">通知管理</a>
						</li>
						<li>
                            <a href="${appDomain}/admin/xhfw/list.htm" target="mainFrame">协会服务</a>
                        </li>
                        <li>
                            <a href="${appDomain}/admin/xhfwdetail/list.htm" target="mainFrame">服务报名</a>
                        </li>
                        <li>
                            <a href="${appDomain}/admin/xhhd/list.htm" target="mainFrame">协会活动</a>
                        </li>
                        <li>
                            <a href="${appDomain}/admin/xhhddetail/list.htm" target="mainFrame">活动报名</a>
                        </li>
                        
                        <li>
                            <a href="${appDomain}/admin/ptfw/list.htm" target="mainFrame">平台服务</a>
                        </li>
                        <li>
                            <a href="${appDomain}/admin/ptfwdetail/list.htm" target="mainFrame">服务报名</a>
                        </li>
                        <li>
                            <a href="${appDomain}/admin/pthd/list.htm" target="mainFrame">平台活动</a>
                        </li>
                        <li>
                            <a href="${appDomain}/admin/pthddetail/list.htm" target="mainFrame">活动报名</a>
                        </li>
                        <li>
                            <a href="${appDomain}/admin/xhxw/list.htm" target="mainFrame">协会新闻</a>
                        </li>
                         <li>
                            <a href="${appDomain}/admin/xwk/list.htm" target="mainFrame">新闻库</a>
                        </li>
                    </ul>
                </li>
            	<#if userAuth("ROLE_ADMIN","ROLE_SYSTEM" )>
                <li>
                    <a class="head" href="#">系统管理</a>
                    <ul>
						<#if userAuth("ROLE_ADMIN" )>
						<li>
						    <a href="${appDomain}/admin/user/user_list.htm" target="mainFrame">用户管理</a>
						</li>
						</#if>
						<li>
						    <a href="${appDomain}/admin/xhtm/list.htm" target="mainFrame">协会条目管理</a>
						</li>
						<li>
						    <a href="${appDomain}/admin/qytm/list.htm" target="mainFrame">企业条目管理</a>
						</li>
						<li>
						    <a href="${appDomain}/admin/sort/list.htm" target="mainFrame">分类列表</a>
						</li>
                    </ul>
                </li>
             	</#if>
            </ul>
        </div>
    </body>
</html>