  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>四川省新闻出版广电局政务系统</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/message/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${jsDomain}/js/message/lhgdialog.min.js"></script>
		<script type="text/javascript" src="${jsDomain}/js/jquery.timers-1.1.2.js"></script>
        <script>
			$(document).ready(function() {
				
				/**
				 * 站内信刷新
				 */
				$(document).everyTime('6das', function() {
					var alertPage;
					// 取得日程提醒信息
			        $.ajax({
			            type: 'GET',
			            contentType: 'application/json',
			            url: '/message/message_info.htm',
			            dataType: 'json',
			            data: 'r=' + Math.random(),
			            success: function(data){
			            
			            	// 设置显示信息
			            	var isShow = false;
			            	if (data.amInfoCount != "undefined" && data.amInfoCount != undefined) {
			            		// 设置我的日程提醒信息
			            		isShow = true;
			            	}
			            	if ((data.amInfoCount == "undefined" || data.amInfoCount == undefined)) {
			            		isShow = false;
			            	}
			            	if (isShow) {
			            		window.focus();
			            		document.all.bgs.src="${appDomain}/upload/video/alert.mp3";
			            		// 设置消息显示
			            		$("#remindMessage").text("您有"+data.amInfoCount+"个待办事项需要办理，请及时查收！");
			            	}
			            },
			            error: function(){
			            }
			        });
				});
			
				// 视频资料点击事件
				$("#video").click(function(){
		        	var url = "${appDomain}/video.htm" + "?r=" + Math.random();
			        var param = 'height=480,width=750,top=50,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no';
			        var val = window.open(url, '', param);
			        if (val == 'refresh') {
			            alert("操作成功");
			            $('form').submit();
			        }
			    });
				
				// 账户管理点击事件
			    $("#pwdChange").click(function(){
			        var url = "${appDomain}/user/edit_password.htm" + "?r=" + Math.random();
			        var param = 'dialogWidth=350px;dialogHeight=210px;status=no;center=yes;scroll=no';
			        var val = window.showModalDialog(url, '', param);
			        if (val == 'refresh') {
			            alert("操作成功");
			            document.getElementById("exitObj").click();
			        }
			    });
			    
			    $('#jsddm > li').bind('mouseover', jsddm_open);
				$('#jsddm > li').bind('mouseout',  jsddm_timer);
			});
			
			var timeout         = 500;
			var closetimer		= 0;
			var ddmenuitem      = 0;
			
			function jsddm_open()
			{	jsddm_canceltimer();
				jsddm_close();
				ddmenuitem = $(this).find('ul').eq(0).css('visibility', 'visible');
			}
			
			function jsddm_close()
			{	if(ddmenuitem) ddmenuitem.css('visibility', 'hidden');}
			
			function jsddm_timer()
			{	closetimer = window.setTimeout(jsddm_close, timeout);}
			
			function jsddm_canceltimer()
			{	if(closetimer)
				{	window.clearTimeout(closetimer);
					closetimer = null;
				}
			}
			document.onclick = jsddm_close;
		</script>
		<script type="text/javascript">
				
		  </script>
    </head>
    <body>
<div id="header">
  <div class="top01">
    <div class="logo"></div>
	 <div class="top-right">
	   <div class="cd"><a href="#">帮助</a>   <a href="#">版权</a>  <a href="#">服务</a></div>
	 </div>
  </div>
  <div class="header-main">
		  <ul id="jsddm">
		  	<li><a href="${appDomain}/init.htm?frame=index" target="mainFrame">首页</a></li>
		  	<#if userAuth("ROLE_ADMIN", "ROLE_NEWS","ROLE_NEWS_LOOK","ROLE_NEWS_EDIT","ROLE_NEWS_DEL","ROLE_NEWS_REW" )>
			<li><a href="#">要情简报</a>
				<ul class="xl">
					<#if userAuth("ROLE_ADMIN", "ROLE_NEWS","ROLE_NEWS_LOOK","ROLE_NEWS_EDIT","ROLE_NEWS_DEL","ROLE_NEWS_REW" )>
					<li><a href="${appDomain}/news/news_review_list.htm?sort=1" target="mainFrame">每日要情</a></li>
					</#if>
					<#if userAuth("ROLE_ADMIN", "ROLE_NEWS","ROLE_NEWS_LOOK","ROLE_NEWS_EDIT","ROLE_NEWS_DEL","ROLE_NEWS_REW" )>
					<li><a href="${appDomain}/brief/brief_review_list.htm?sort=2" target="mainFrame">简报</a></li>
					</#if>
				</ul>			
			</li>
			</#if>
			<li><a href="#">通知公告</a>
				<ul class="xl">
					<#if userAuth("ROLE_ADMIN", "ROLE_MESSAGE","ROLE_MESSAGE_LOOK","ROLE_MESSAGE_EDIT","ROLE_MESSAGE_DEL","ROLE_MESSAGE_REW" )>
					<li><a href="${appDomain}/message/message_review_list.htm?sort=1" target="mainFrame">通知管理</a></li>
					</#if>
					<#if userAuth("ROLE_ADMIN", "ROLE_MESSAGE","ROLE_MESSAGE_LOOK","ROLE_MESSAGE_EDIT","ROLE_MESSAGE_DEL","ROLE_MESSAGE_REW" )>
					<li><a href="${appDomain}/notice/notice_review_list.htm?sort=2" target="mainFrame">公告管理</a></li>
					</#if>
				</ul>
			</li>			
			<li><a href="#">公文管理</a>
				<ul class="xl">
					<#if userAuth("ROLE_ADMIN", "ROLE_DOCOUT","ROLE_DOCOUT_LOOK","ROLE_DOCOUT_EDIT","ROLE_DOCOUT_REW","ROLE_DOCOUT_DEL","ROLE_DOCOUT_DUBAN","ROLE_DOCOUT_DO" )>
					<li><a href="${appDomain}/docout/docout_review_list.htm" target="mainFrame">发文管理</a>	</li>
					</#if>
					<#if userAuth("ROLE_ADMIN", "ROLE_DOCIN","ROLE_DOCIN_LOOK","ROLE_DOCIN_EDIT","ROLE_DOCIN_REW","ROLE_DOCIN_DEL","ROLE_DOCIN_DUBAN","ROLE_DOCIN_DO" )>
					<li><a href="${appDomain}/docin/docin_review_list.htm" target="mainFrame">收文管理</a>	</li>
					</#if>
				</ul>
			</li>
			<li><a href="#">工作管理</a>
				<ul class="xl">
					<#if userAuth("ROLE_ADMIN", "ROLE_MEETING","ROLE_MEETING_NEW","ROLE_MEETING_REW" )>
					<li><a href="${appDomain}/meetingYy/meetingYy_list.htm" target="mainFrame">会议室预约</a></li>
					</#if>
					<#if userAuth("ROLE_ADMIN", "ROLE_GGTXL","ROLE_GGTXL_LOOK","ROLE_GGTXL_EDIT","ROLE_GGTXL_JJ" )>
					<li><a href="${appDomain}/ggtxl/ggtxl_list.htm" target="mainFrame">公共通讯录</a></li>
					</#if>
					<#if userAuth("ROLE_ADMIN", "ROLE_WORKSCHEDULER","ROLE_WORKSCHEDULER_EDIT","ROLE_WORKSCHEDULER_CHECK" )>
					<li><a href="${appDomain}/workscheduler/work_scheduler.htm" target="mainFrame">工作日程</a></li>
					</#if>
					<li><a href="${appDomain}/alert/alert_list.htm" target="mainFrame">备忘录</a></li>
					<#if userAuth("ROLE_ADMIN", "ROLE_RESFILE","ROLE_RESFILE_UPLOAD","ROLE_RESFILE_LOOK" )>
					<li><a href="${appDomain}/resFile/folder_all.htm" target="mainFrame">知识库</a></li>
					</#if>
				</ul>
			</li>
			<li><a href="#">个人管理</a>
				<ul class="xl">
					<li><a class="short" href="${appDomain}/msgone/msgoneInbox_list.htm" target="mainFrame">文稿拟订</a></li>
					<#if userAuth("ROLE_ADMIN", "ROLE_ADDRESS_BOOK","ROLE_ADDRESS_BOOK_EDIT" )>
					<li><a href="${appDomain}/addressBook/addrmain.htm" target="mainFrame">私人通讯录</a></li>
					</#if>
					<#if userAuth("ROLE_ADMIN", "ROLE_MSG","ROLE_MSG_LOOK","ROLE_MSG_EDIT","ROLE_MSG_DEL" )>
					<li><a class="short" href="${appDomain}/msg/msgInbox_list.htm" target="mainFrame">站内信</a></li>
					</#if>
					<#if userAuth("ROLE_ADMIN", "ROLE_SCHEDULER","ROLE_SCHEDULER_EDIT")>
					<li><a href="${appDomain}/scheduler/scheduler.htm" target="mainFrame">个人日程</a></li>
					</#if>
					<#if userAuth("ROLE_ADMIN", "ROLE_NET_FILE","ROLE_NET_FILE_UPLOAD","ROLE_NET_FILE_DOWN" )>
					<li><a href="${appDomain}/netFile/list.htm" target="mainFrame">网络硬盘</a></li>
					</#if>
					<li><a href="${appDomain}/remind/remind_list.htm" target="mainFrame">消息中心</a></li>
				</ul>
			</li>
			<#if userAuth("ROLE_ADMIN")>
		    <li><a href="${appDomain}/dept/menu.htm" target="mainFrame">基础设置</a></li>
		    </#if>
		    <#if userAuth("ROLE_ADMIN","ROLE_MANAGE")>
		     <li><a href="${appDomain}/seal/seal_list.htm" target="mainFrame">功能设置</a></li>
		     </#if>
		</ul>
		<div class="clear"> </div>
       <div class="top-userinfo">
		<span>您好</span>
		<span class="u-name">${userName}</span>
		<a href="#" id="pwdChange">[更改密码]</a>
		<a href="${appDomain}/logout" id="exitObj" target="_parent">[退出]</a>
		
	</div>
	<div class="yiyo">
	<p>欢迎进入四川省新闻出版广电局政务系统！<a href="${appDomain}/remind/remind_list.htm" target="mainFrame"><lable style="color:red;" id="remindMessage"></lable></a></p>
	<span class="desc_txt top-time">今天是：${date}</span>
	</div>
  </div>
</div>
<bgsound loop="1" id="bgs">
    </body>
</html>