<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="textml; charset=UTF-8">
        <title><#if news.sort=='1'>每日要情</#if>
        		<#if news.sort=='2'>简报</#if></title>
        <link href="${cssDomain}/css/style.css" type="text/css" rel="stylesheet">
        <link href="${cssDomain}/css/iframe.css" type="text/css" rel="stylesheet">
        <script src="${jsDomain}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/eWebOffice/eWebOffice.js"></script>
	    
<script>
function setTab(name,cursel){
	cursel_0=cursel;
	for(var i=1; i<=links_len; i++){
		var menu = document.getElementById(name+i);
		var menudiv = document.getElementById("con_"+name+"_"+i);
		if(i==cursel){
			menu.className="off";
			menudiv.style.display="block";
		}
		else{
			menu.className="";
			menudiv.style.display="none";
		}
	}
}
function Next(){                                                        
	cursel_0++;
	if (cursel_0>links_len)cursel_0=1
	setTab(name_0,cursel_0);
} 
var name_0='one';
var cursel_0=1;
var links_len,iIntervalId;
onload=function(){
	var links = document.getElementById("tab1").getElementsByTagName('li')
	links_len=links.length;
	for(var i=0; i<links_len; i++){
		links[i].onmouseover=function(){
			clearInterval(iIntervalId);
			this.onmouseout=function(){
			}
		}
	}
	document.getElementById("con_"+name_0+"_"+links_len).parentNode.onmouseover=function(){
		clearInterval(iIntervalId);
		this.onmouseout=function(){
		}
	}
	setTab(name_0,cursel_0);
}
</script>

		<script type="text/javascript">
	    	$(document).ready(function(){
			    // 增加按钮点击事件
			    $(".neirong").click(function(){
			        var url = "${appDomain}/news/content_detail.htm?dRecordid=" + $(this).attr("alt") + "&r=" + Math.random();
			        var param = 'dialogWidth=940px;dialogHeight=750px;status=no;center=yes;scroll=yes';
			        var val = window.showModalDialog(url, '', param);
			  	 if (val == 'refresh') {
			            alert("操作成功");
			        }
			    });
			});
		</script>
	<script type="text/javascript" for="eWebOffice1" event="OnInit()">
		eWebOfficeJS.SetWorkModeOnInit("eWebOffice1", "read");
		eWebOffice1.HideMenuBar(true);
	</script>
	<script type="text/javascript" for="eWebOffice1" event="OnDocumentAfterOpen()">
	//文档打开后触发此事件
	//在此事件中设置初始Office菜单、工具栏、痕迹、保护等。
	eWebOfficeJS.SetWorkModeOnOpen("eWebOffice1", "read");
	eWebOffice1.HideMenuBar(true);
	</script>
	<script type="text/javascript" for="eWebOffice1" event="OnLoad()">
		eWebOffice1.WebUrl = "${jsDomain}/js/eWebOffice/eWebNewsAction.jsp";
		eWebOffice1.RecordID="${news.dRecordid}";
		eWebOffice1.SetTitleIcon ("${appDomain}/images/rr.gif");
		eWebOffice1.TitleCaption="四川省新闻出版广电局政务系统";
		eWebOffice1.AllowPrint =true;
		eWebOffice1.AllowCopy =true;
		eWebOffice1.HideMenuBar(true);
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
	<form id="newsForm" name="newsForm" action="" method="GET">
<div class="tab1" id="tab1">
	<div class="menu">
		<ul>
			<li id="one2" onclick="setTab('one',2)"><img src="${imageDomain}/images/c02.png"/>处理笺</li>
			<li id="one1" onclick="setTab('one',1)"><img src="${imageDomain}/images/c01.png"/><#if news.sort=='1'>每日要情</#if>
        		<#if news.sort=='2'>简报</#if></li>
		</ul>
	</div>
	<div class="menudiv">
		<div id="con_one_1">  
			<table class="ftb">
          	<tr>
                <td colspan="4">
					<!--创建eWebOffice实例-->
					<script type="text/javascript">
						eWebOfficeJS.Create("eWebOffice1", "100%", "1000px");
					</script>
	  			  </td>
            </tr>
            </table>
        </div>
		<div id="con_one_2" style="display:none;">
			<div class="wj_main">
			<h4 class="wj_titl">四川省新闻出版广电局文件处理笺</h4>
			<table width="200" border="0"  class="wj_pap">
			  <tr>
			    <th class="bh">编　　号</th>
			    <td colspan="3">&nbsp;</td>
			  </tr>
			  <tr>
			    <th>标　　题 </th>
			    <td colspan="3">${news.title}</td>
			  </tr>
			  <tr>
			    <th>拟　　稿</th>
			    <td>${news.draftsName}</td>
			    <th class="ee">签　　发</th>
			    <td>${news.currentOptName}</td>
			  </tr>
			  <tr>
			    <th>拟稿部门</th>
			    <td>${news.draftsDeptName}</td>
			    <th class="ee">发布时间</th>
			    <td>${news.textTime}</td>
			  </tr>
			  <tr>
			    <th valign="top" class="bhr" >意　　见</th>
			    <td colspan="3" height="100" >${news.remark}</td>
			  </tr>
			  <tr>
			  	<th align="left" class="bh02">已读（${newsLookListForAll?size}条）</th>
				<td colspan="3" class="ziti">
					&nbsp;
				</td>
			  </tr>
			  <tr>
				<td colspan="4" align="left" class="ziti">
					<#list newsLookListForAll as newsLook>
						<span>${newsLook.loginName}  【${newsLook.deptName} | ${newsLook.updateDate?datetime}】</span>
				    </#list>
				</td>
			  </tr>
			</table>
			</div>
         </div>
	</div>
</div>
   </form>
   </div>
</div>	
</body>
</html>
