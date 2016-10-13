<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base target="_self">
        <title>内容详细页面</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
       	<script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>

	<script type="text/javascript" for="eWebOffice1" event="OnInit()">
		eWebOfficeJS.SetWorkModeOnInit("eWebOffice1", "read");
	</script>
	<script type="text/javascript" for="eWebOffice1" event="OnDocumentAfterOpen()">
	//文档打开后触发此事件
	//在此事件中设置初始Office菜单、工具栏、痕迹、保护等。
	eWebOfficeJS.SetWorkModeOnOpen("eWebOffice1", "read");
	</script>
	<script type="text/javascript" for="eWebOffice1" event="OnLoad()">
		eWebOffice1.WebUrl = "${jsDomain}/js/eWebOffice/eWebDocinAction.jsp";
		eWebOffice1.RecordID = "${d_recordId}";
		eWebOffice1.SetTitleIcon ("${appDomain}/images/rr.gif");
		eWebOffice1.TitleCaption="四川省新闻出版广电局政务系统";
		eWebOffice1.AllowPrint =true;
		eWebOffice1.AllowCopy =true;
		eWebOffice1.WebOpen();
	</script>
	<script type="text/javascript" for="eWebOffice1" event="OnCustomButtonClick(s_Key, s_Value)">
		//s_Key: 为自定义按钮关键字，可以随便定义，不要与系统自带冲突即可，演示中为了区别，快捷工具栏上的按钮定义为"QB_"开头，Office文件菜单下的按钮定义为"File_"开头。
		switch(s_Key){
		case "QB_Print":
			eWebOffice1.PrintDialog();
			break;
		}
	
	</script>
    </head>
    <body>
		<div id="main">
          <div class="main_nav">
            <div style="margin:0 auto;width:96%;">
		     <!--创建eWebOffice实例-->
			<script type="text/javascript">
			eWebOfficeJS.Create("eWebOffice1", "100%", "700px");
			</script>
			</div>
		   </div>
		</div>	
    </body>
</html>