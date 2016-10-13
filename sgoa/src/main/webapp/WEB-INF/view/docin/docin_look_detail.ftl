<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="textml; charset=UTF-8">
        <title>收文</title>
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
        <script src="${jsDomain}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>
		<script type="text/javascript">
	    	$(document).ready(function(){
	    	//文件下载
			$(".act-down").click(function(){
				$("#srcFileNameOne").val($(this).attr("alt"));
				$('form').attr("action","${appDomain}/docinShareDown/download_file.htm");
				$('form').submit();
			});	
			    // 增加按钮点击事件
			    $(".neirong").click(function(){
			        var url = "${appDomain}/docin/content_detail.htm?dRecordid=" + $(this).attr("alt") + "&r=" + Math.random();
			        var param = 'dialogWidth=940px;dialogHeight=750px;status=no;center=yes;scroll=yes';
			        var val = window.showModalDialog(url, '', param);
			  	 if (val == 'refresh') {
			            alert("操作成功");
			        }
			    });
			});
			
			//作用：调入签章数据信息
			function LoadSignature(){
				$("input[name='signBtn']").each(function(){
	                document.getElementById('SendOut'+$(this).attr('alt')).LoadSignature();
	            });
			}
		</script>
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
		eWebOffice1.RecordID="${docin.dRecordid}";
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
<style type="text/css">
<!--
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, button, textarea, p, blockquote, th, td a {
	margin: 0;
	padding: 0;

}
table {
    border-collapse: collapse;
    border-spacing: 0;
}
.clwj { width:98%; margin:0 auto;
}
.clqh{ font-size:30px; font-family:"楷体" font-weight:bold; text-align:center; line-height:50px; }
.clwj p{ width:48%; float: left; font-size:16px; line-height:35px;}
.clwj table.cld{ width:100%; border:1px solid #333333; font-size:14px;}
.clwj table.cld th{ width:8%;border:1px solid #333333;}
.clwj table.cld td{ padding:3px; line-height:28px;border:1px solid #333333;}
-->
</style>

    </head>

<body>
<div class="clwj">
  <h4 class="clqh">四川省新闻出版广电局文件处理笺</h4>
  <div>
    <p>　全宗号：${docin.fondsNum}</p>
    <p style="text-align:right;">全宗名称：${docin.fondsName}</p>
  </div>
  <table  class="cld">
  <tr>
    <th>来文单位</th>
    <td ><label for="textfield"></label>
      <input type="text" name="textfield" id="textfield" value="${docin.fileDept}" readonly="readonly"/></td>
    <th>文件编号</th>
    <td><input type="text" name="textfield2" id="textfield2" value="${docin.fileNum}" readonly="readonly"/></td>
    <th>缓急程度</th>
    <td><#if docin.urgent == ""><input class="text" type="text" value="" readonly="readonly"/></#if>
      <#if docin.urgent == 1><input class="text" type="text" value="正常" readonly="readonly"/></#if>
      <#if docin.urgent == 2><input class="text" type="text" value="加急" readonly="readonly"/></#if>
      <#if docin.urgent == 3><input class="text" type="text" value="特急" readonly="readonly"/></#if>
      <#if docin.urgent == 4><input class="text" type="text" value="紧急" readonly="readonly"/></#if>
      <#if docin.urgent == 5><input class="text" type="text" value="特提" readonly="readonly"/></#if>
     </td>
    </tr>
  <tr>
    <th>收文时间</th>
    <td>${docin.receiverTime}</td>
    <th>登 记 号</th>
    <td>${docin.registerNum}</td>
    <th>办理期限</th>
    <td><input type="text" name="blqx" id="blqx" value="${docin.blqx}" readonly="readonly"/>
    </td>
  </tr>
  <tr>
    <th>文　　件<br />标　　题</th>
    <td colspan="5" height="80">${docin.title}</td>
  </tr>
  <tr>
    <th>附　　件</th>
    <td colspan="5" height="80">
    <#list docinFjPage as docinFj>
	<input type="hidden" id="srcFileNameOne" name="srcFileNameOne" value="${docinFj.srcFileName}"/>
	<a class="act-down" href="#" alt="${docinFj.srcFileName}">${docinFj.srcFileName}</a>
	</#list>
    </td>
  </tr>
 <tr>
    <th>局　　长<br />意　　见</th>
    <td colspan="7" height="130" >
    	<div style="width:700px;min-height:100px; height:auto;font-size:16px;overflow:hidden">${opinion1}</div>
		<br />
    </td>
    </tr>
  <tr>
    <th>分管领导<br />意　　见</th>
    <td colspan="7" height="130">
    	<div style="width:700px;min-height:100px; height:auto;font-size:16px;overflow:hidden">${opinion2}</div>
    </td>
    </tr>
  <tr>
    <th>承办处室<br />意　　见</th>
    <td colspan="7" height="80">
    	<div style="width:700px;min-height:50px; height:auto;font-size:16px;overflow:hidden">${opinion3}</div>
    </td>
    </tr>
  <tr>
    <th>办公室<br />意　　见</th>
    <td colspan="7" height="80">
    	<div style="width:700px;min-height:50px; height:auto;font-size:16px;overflow:hidden">${opinion4}</div>
		<br />	
    </td>
  </tr>
   <tr> 
  	 <th>回执信息：  </th>
	    <td colspan="5">
	    <div style=" height:160px;overflow-y:auto;">
	    <table class="stty">
	     	 <tr>
                <th>回执人员</th>
                <th>回执时间</th>
                <th>回执情况</th>
            </tr>
			<#list docinBoxListForAll as docinBox>
			 <tr>
				<td>${docinBox.loginName} </td>
				<td>${docinBox.updateDate?datetime}</td>
				<td>${docinBox.stituation}</td>
			 </tr>
            </#list>
              </table>
         </div>
		 </td>
	</tr>
  </table>
</div>
</body>
</html>
