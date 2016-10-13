<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>欢迎使用四川广电新闻出版局信息管理系统</title>
        <link href="${cssDomain}/css/base.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript">
	        $(document).ready( function() {
				$(".act-down").click(function(){
					var url = "${appDomain}/rfileInbox/read.htm?id=" + $(this).attr("altt");
		            $.get(url, function(result){
		                //读取成功
		            });
					$("#srcFileName").val($(this).attr("alt"));
					$('form').attr("action","${appDomain}/rfile/download_file.htm");
					$('form').submit();
				});	
			});
		</script>
    </head>
    <body>
    <form method="POST">
    <input type="hidden" id="srcFileName" name="srcFileName"/>
		<div id="main">
		 <div class="main_nav">
		 	
				<div class="so">
			  		<div class="so_tit">
					    <h4>通知</h4>
					    <a href="${appDomain}/message/list.htm?sort=1"></a>
					</div>
			  		<ul class="tzg">
						<#list messagePage.messageList as message>
							<li>
								<a onclick="setInterval('location.reload()',3000);" target="_Blank" <#if message.isRead==0>style="color:blue;font-weight:bold;font-size:14px;"<#else>style="font-size:14px;" class="read"</#if> href="${appDomain}/message/look_detail.htm?id=${message.id}" title="${message.title}">${message.title}</a>
								<lable>${message.textTime}</lable>
							</li>
						</#list>
					</ul>
				</div>
				<div class="so">
					<div class="so_tit">
						<h4>公告</h4>
					    <a href="${appDomain}/notice/list.htm?sort=2"></a>
					</div>
					<ul class="tzg">
							<#list noticePage.messageList as notice>
							<li>
								<a onclick="setInterval('location.reload()',3000);" target="_Blank" <#if notice.isRead==0>style="color:blue;font-weight:bold;font-size:14px;"<#else>style="font-size:14px;" class="read"</#if> href="${appDomain}/message/look_detail.htm?id=${notice.id}" title="${notice.title}">${notice.title}</a>
								<lable>${notice.textTime}</lable>
							</li>
						</#list>
					</ul>
				</div>
				<div class="so">
			  		<div class="so_tit">
					    <h4>要情简报</h4>
					    <a href="${appDomain}/news/list.htm?sort=1"></a>
					</div>
			  		<ul class="tzg02">
						<#list newsPage.newsList as news>
							<li>
								<a onclick="setInterval('location.reload()',3000);" target="_Blank" <#if news.isRead==0>style="color:blue;font-weight:bold;font-size:14px;"<#else>style="font-size:14px;" class="read"</#if> href="${appDomain}/news/look_detail.htm?id=${news.id}" title="${news.title}">${news.title}</a>
								<lable>${news.textTime}</lable>
							</li>
						</#list>						
					</ul>
					<div class="knon">&nbsp;</div>
					<ul class="tzg02">
						<#list briefPage.newsList as brief>
							<li>
								<a target="_Blank" <#if brief.isRead==0>style="color:blue;font-weight:bold;font-size:14px;"<#else>style="font-size:14px;"</#if> href="${appDomain}/news/look_detail.htm?id=${brief.id}" title="${brief.title}">${brief.title}</a>
								<lable>${brief.textTime}</lable>
							</li>
						</#list>
					</ul>					
				</div>
			</div>
		</div>
		<br/>
		<br/>
	</form>
    </body>
</html>
