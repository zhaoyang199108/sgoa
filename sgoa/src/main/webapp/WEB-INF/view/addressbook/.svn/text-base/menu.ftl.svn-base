<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>菜单栏</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css" />
		<link href="${cssDomain}/css/addressbook.css" rel="stylesheet" type="text/css" />
        <link href="${cssDomain}/css/frame.css" type="text/css" rel="stylesheet">
        <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/chili-1.7.pack.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/jquery.easing.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/jquery.dimensions.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/jquery.accordion.js"></script>
        <script type="text/javascript" src="${jsDomain}/js/menu/left.js"></script>
        <script type="text/javascript">
		$(document).ready(function(){
		
		    // 增加按钮点击事件
		    $("#add-btn").click(function(){
		        var url = "${appDomain}/addressBookType/list.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=520px;dialogHeight=280px;status=no;center=yes;scroll=yes';
		        var val = window.showModalDialog(url, '', param);
		        location.href="${appDomain}/addressBook/menu.htm";
		    });
		});
		</script>
    </head>
 <body>
   <td valign="top" class="left_xl"><img src="${imageDomain}/images/tx.jpg"/>
     <div class="txcd">
       <div class="xl_menu">
	   <div class="modl"><a class="ovw_active" >管理分组</a></div>
	   <br class="clearfloat"/>
	    <ul>
	       <li <#if menuHighLight == 'add_ressbooktype'>class="high_light"</#if>>
	       	<a class="lxr22" id="add-btn">新增分组</a>
	       </li>
        </ul>
	   </div>
	   
	   <div class="xl_menu">
	   <div class="modl"><a class="ovw_active">通讯录分组</a></div>
	   <br class="clearfloat"/>
	   <div class="dwe">
	   <ul>
	         <#list page.addressTypeList as addressBookType>
            <li <#if menuHighLight == 'addressbook_list'>class="high_light"</#if>>
              <a href="${appDomain}/addressBook/list.htm?id=${addressBookType.id}"  target="middleFrame">${addressBookType.typeName}</a>
            </li>
            </#list>
        </ul>
         </div>
	   </div>
     </div>
    </td>
     
</body>
</html>