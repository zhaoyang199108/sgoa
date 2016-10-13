<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${cssDomain}/css/login.css" type="text/css" rel="stylesheet">
        <title>视频资料</title>
		<script>
		function a_click(obj){
			document.getElementById('MediaPlayer1').Filename = obj;
			document.getElementById('MediaPlayer1').AutoStart = -1;
		}
	</script>
        <style type="text/css">
			<!--
			.owi{ background:#F1FBFD; color:#FF3300; font-size:12px; width:150px; height:35px; line-height:35px; border-bottom:1px dashed #990000; cursor:pointer;}
			.owi02{ color:#000000; font-size:12px; font-weight:bold; background:#FFAB00; line-height:35px; height:35px; width:150px; }
			-->
        </style>
</head>
<body id="login">	
		

<div align="center" style="float:left; margin-left:30px; margin-top:30px;">
    <div class="owi02">视频列表</div>
	<div class="owi"><a onClick="a_click('${jsDomain}/upload/video/1.wmv');">美丽的地质宫</a></div>
	<div class="owi"><a onClick="a_click('${jsDomain}/upload/video/2.mp4');">深山探宝</a></div>
	<div class="owi"><a onClick="a_click('${jsDomain}/upload/video/3.mp4');">长春的回忆</a></div>
	<div class="owi"><a onClick="a_click('${jsDomain}/upload/video/4.mp4');">长春的回忆</a></div>
</div>
<div align="center" style="float:right;  margin-top:30px; margin-right:20px;"">
		<object classid="clsid:22D6F312-B0F6-11D0-94AB-0080C74C7E95" id="MediaPlayer1" width="502" height="397">
        <param name="AudioStream" value="-1">
        <param name="AutoSize" value="0">
        <param name="AutoStart" value="-1">      <!--  设置是否为自动播放，-1为自动播放，0为不自动播放  -->     
        <param name="AnimationAtStart" value="0">
        <param name="AllowScan" value="-1">
        <param name="AllowChangeDisplaySize" value="-1">
        <param name="AutoRewind" value="0">
        <param name="Balance" value="0">
        <param name="BaseURL" value>
        <param name="BufferingTime" value="5">
        <param name="CaptioningID" value>
        <param name="ClickToPlay" value="-1">
        <param name="CursorType" value="0">
        <param name="CurrentPosition" value="-1">
        <param name="CurrentMarker" value="0">
        <param name="DefaultFrame" value>
        <param name="DisplayBackColor" value="0">
        <param name="DisplayForeColor" value="16777215">
        <param name="DisplayMode" value="0">
        <param name="DisplaySize" value="2">
        <param name="Enabled" value="-1">
        <param name="EnableContextMenu" value="-1">
        <param name="EnablePositionControls" value="-1">
        <param name="EnableFullScreenControls" value="0">
        <param name="EnableTracker" value="-1">   
        <param name="Filename" value="images/beauty.swf">   <!--  设置播放的路径 ，一般通过参数传入 -->
        <param name="InvokeURLs" value="-1">
        <param name="Language" value="-1">
        <param name="Mute" value="0">
        <param name="PlayCount" value="1">
        <param name="PreviewMode" value="0">
        <param name="Rate" value="1">
        <param name="SAMILang" value>
        <param name="SAMIStyle" value>
        <param name="SAMIFileName" value>
        <param name="SelectionStart" value="-1">
        <param name="SelectionEnd" value="-1">
        <param name="SendOpenStateChangeEvents" value="-1">
        <param name="SendWarningEvents" value="-1">
        <param name="SendErrorEvents" value="-1">
        <param name="SendKeyboardEvents" value="0">
        <param name="SendMouseClickEvents" value="0">
        <param name="SendMouseMoveEvents" value="0">
        <param name="SendPlayStateChangeEvents" value="-1">
        <param name="ShowCaptioning" value="0">
        <param name="ShowControls" value="-1">
        <param name="ShowAudioControls" value="-1">
        <param name="ShowDisplay" value="0">
        <param name="ShowGotoBar" value="0">
        <param name="ShowPositionControls" value="-1">
        <param name="ShowStatusBar" value="-1">
        <param name="ShowTracker" value="-1">
        <param name="TransparentAtStart" value="0">
        <param name="VideoBorderWidth" value="0">
        <param name="VideoBorderColor" value="0">
        <param name="VideoBorder3D" value="0">
        <param name="Volume" value="-40">
        <param name="WindowlessVideo" value="0">
        </object>
	</div>
</body>
</html>
