<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>标题栏</title>
        <link href="${cssDomain}/css/frame.css" type="text/css" rel="stylesheet">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript">
			$(document).ready(function(){
			
			    // 账户管理点击事件
			    $("#pwdChange").click(function(){
			        var url = "${appDomain}/admin/user/edit_password.htm" + "?r=" + Math.random();
			        var param = 'dialogWidth=380px;dialogHeight=220px;status=no;center=yes;scroll=no';
			        var val = window.showModalDialog(url, '', param);
			        if (val == 'refresh') {
			            alert("操作成功");
			            document.getElementById("exitObj").click();
			        }
			    });
				$("#logout").click(function(){
					return confirm("确定退出?");
				});
				$("#userInfo-btn").click(function(){
					var url = "${appDomain}/admin/user/edit_user_info_show.htm?loginId=" + $(this).attr("alt") + "&r=" + Math.random();
			        var param = 'dialogWidth=440px;dialogHeight=400px;status=no;center=yes;scroll=no';
			        var val = window.showModalDialog(url, '', param);
			        if (val == 'refresh') {
			            alert("操作成功");
			            document.getElementById("logout").click();
			        }
				});
			});
		</script>
    </head>
    <body>
   		
        <div id="header">
            <div alt="管理系统" class="logg"></div>
            <div class="top-btn">
                <a class="home-ico" href="${appDomain}/admin/init.htm?frame=index" target="mainFrame"></a>
                <a href="#" onclick="javascprit:history.go(-1);"></a>
                <a href="#" onclick="javascprit:history.go(1);"></a>
                <a href="${appDomain}/admin/init.htm?frame=index" target="mainFrame"></a>
                <a class="info-ico" href="#" id="pwdChange"></a>
                <a id="logout" class="logout-ico" target="_parent" href="${appDomain}/admin/logout" ></a>
            </div>
            <div class="top-datestyle"><p>${userName}</p><span class="desc_txt top-time">日期：${date}</span></div>
        </div>
    </body>
</html>
