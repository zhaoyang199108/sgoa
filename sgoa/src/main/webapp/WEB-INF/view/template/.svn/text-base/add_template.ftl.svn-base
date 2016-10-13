<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>模版模块添加页面</title>  
    <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	<script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>
	<script type="text/javascript">
		function DoCheckSubmit(){
			eWebOffice1.FileName=encodeURI($("#d_filename").val());
			eWebOffice1.Description=encodeURI($("#d_descript").val());
		    try{    
		        return eWebOffice1.WebSaveTemplate();
		    }catch(e){
		        alert("请选安装eWebOffice控件，再操作！");
		        return false;
		    }
		}
	</script>
<script type="text/javascript" for="eWebOffice1" event="OnInit()">
    eWebOffice1.QuickBarCommentVisible = false;
</script>

<script type="text/javascript" for="eWebOffice1" event="OnLoad()">
	eWebOffice1.WebUrl = "${jsDomain}/js/eWebOffice/eWebOfficeAction.jsp";
	eWebOffice1.TemplateID = "${d_templateId}";
	eWebOffice1.UserName = "${d_userName}";
	eWebOffice1.FileType = "${d_fileType}";
	eWebOffice1.SetTitleIcon ("${appDomain}/images/rr.gif");
	eWebOffice1.TitleCaption="四川省新闻出版广电局政务系统";
	eWebOffice1.WebNewTemplate();
</script>

</head>
<body>
	<div class="sow">
			<h3 class="title"><font size="3"><strong>新增模版模块</strong></font></h3>
			<form class="f0" action="${appDomain}/template/add_template.htm" enctype="multipart/form-data" method="POST" onsubmit="return DoCheckSubmit();">
				<table class="ftb">
				<tr>
				    <th>模版名称:</th>
					<td>						
						<input type=text class=txt name="d_filename" id="d_filename" value="" size=50>
					</td>
				</tr>
				<tr>
					<th>模版说明:</th>
					<td>						
     				 	<input type=text class=txt name="d_descript" id="d_descript" value="" size=50>
					</td>
				</tr>
				<tr class="act">
				   <td colspan="6">				
						<input type="submit"  class="btn" value="提 交"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>	
				   </td>
			    </tr>	
			</table>								
			</form>
	<!--创建eWebOffice实例-->
	<script type="text/javascript">
	eWebOfficeJS.Create("eWebOffice1", "100%", "700px");
	</script>
	</div>
</body>
</html>
