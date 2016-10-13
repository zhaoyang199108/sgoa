<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>四川省广播电影电视局政务系统-登录</title>
	<script type="text/javascript">
	  	function fullScreenWindowNamed(url,windowName,fullScreenFeatureList,returnWindowHandle) {
			fullScreenFeatureList = "left=0,top=0,screenX=0,screenY=0,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1";
			try {
				if(window.screen){
					var ah = screen.availHeight - 30;
					var aw = screen.availWidth - 10;
					fullScreenFeatureList += ",height=" + ah;
					fullScreenFeatureList += ",innerHeight=" + ah;
					fullScreenFeatureList += ",width=" + aw;
					fullScreenFeatureList += ",innerWidth=" + aw;
					fullScreenFeatureList += ",resizable=no";
				}else{
					fullScreenFeatureList += ",resizable=no";
				} 
			} 
			catch(e) {
			} 
			var link = window.open(url,"printPreview",fullScreenFeatureList);
			window.opener=null;//没有这句，关闭时有提示,ie5.5以上有效
	  		window.open('','_self');
	  		window.close();
			if(returnWindowHandle) {
				return link;
			} 
		} 
	</script>
</head>
	<body onload='fullScreenWindowNamed("${appDomain}/login.htm","","","");'>
	</body>  
</html>  
