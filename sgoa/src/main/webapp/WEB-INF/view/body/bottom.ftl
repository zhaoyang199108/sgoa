<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7"/>
        <title>Copyright</title>
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
		<link href="${jsDomain}/js/message/common.css" type="text/css" rel="stylesheet"/>
		<script type="text/javascript" src="${jsDomain}/js/message/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${jsDomain}/js/message/lhgdialog.min.js"></script>
		<script type="text/javascript" src="${jsDomain}/js/jquery.timers-1.1.2.js"></script>
    </head>
    <script type="text/javascript">
    	$(document).ready(function() {
    	
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
	            		var url = "${appDomain}/message/alert_info.htm?r=" + Math.random();
		        		var param = 'dialogWidth=440px;dialogHeight=710px;status=no;center=yes;scroll=no';
		        		var result = window.showModalDialog(url,'',param);
		        		if(result==undefined) {
			        		return false;
			     	    }
			     	    if (result.length == 0) {
		                    return false;
		                }
		                window.parent.frames["mainFrame"].location.href=result[0];
	            	} 
	            },
	            error: function(){
	            }
	        });
		        
		    // 账户管理点击事件
		    $("#alertMessage").click(function(){
		    	var url = "${appDomain}/message/alert_info.htm?r=" + Math.random();
        		var param = 'dialogWidth=440px;dialogHeight=710px;status=no;center=yes;scroll=no';
        		var result = window.showModalDialog(url,'',param);
        		if(result==undefined) {
	        		return false;
	     	    }
	     	    if (result.length == 0) {
                    return false;
                }
                window.parent.frames["mainFrame"].location.href=result[0];
		    });
		    
		    /**
			 * 站内信刷新
			 */
			$(document).everyTime('3das', function() {
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
		            		// 设置消息显示
		            		$("#Image1").attr("src","images/mail0.gif");
		            	} else {
		            		$("#Image1").attr("src","images/mail.png");
		            	}
		            },
		            error: function(){
		            }
		        });
			});
		    
		    // 万事通点击事件
		    $("#allKnow").click(function(){
		    	var url = "${appDomain}/all_know.htm" + "?r=" + Math.random();
		        var param = 'height=510,width=800,top=50,left=200,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no';
		        var val = window.open(url, '', param);
		    });
		});
    </script>
    <body>
        <div id="bottom">
          <bgsound loop="1" id="bgs">
          <p>
          <a>Copyright © 2012-2013 北京诚启电子科技发展有限公司. All Rights Reserved
          </a>
          <a id="allKnow" title="万事通" class="mail" href="#"><img src="images/dgn.png" width="40" height="29" id="Image2" /></a>
          <a id="alertMessage" title="消息提醒" class="mail" href="#"><img src="images/mail.png" width="40" height="29" id="Image1" /></a>
          </p>
       </div>
    </body>
</html>
