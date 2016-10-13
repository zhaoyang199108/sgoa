<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>通讯录-列表</title>
		<link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css" />
		<link href="${cssDomain}/css/addressbook.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		  // 增加按钮点击事件
		    $(".lxr22").click(function(){
		        var url = "${appDomain}/addressBook/add_addressBook.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=820px;dialogHeight=530px;status=no;center=yes;scroll=yes';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            parent.middleFrame.location.reload();
		        }
		    });
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/addressBook/delete.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除此人信息？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                parent.middleFrame.location.reload();
		            });
		        }
		    });
		    

		   /**
	        * 点击查询按钮
	       */
            $("#searchBtn").click(function(){
		        $('form').submit();
            });    			
		});				
		</script>
	</head>

<body>
<table class="yxb">
  <tr>
    <form id="listForm" name="listForm" action="${appDomain}/addressBook/list.htm" method="GET">
    <td class="right_ad">
	 <div class="sear">
	 <a class="lxr22"  href="#">新建联系人</a>
    </div>
    
    <div class="lxr">
        <h4 class="tite">联系人</h4>
         <div class="dd">
        
          <ul class="lxd">
            <#list addressBookList as addressBook>
            <li>
            
            <#if addressBook.photo==null>
            <img src="${imageDomain}/images/0.gif" />
            <#else>
            <img src="${addressBook.photo}" width="50" height="50"/>
            </#if>
            
            <span>
                ${addressBook.addName}
            </span>
            <span style="float:right; margin-right:10px;">
            <a class="act-btn"  href="${appDomain}/addressBook/edit_addressBook.htm?id=${addressBook.id}" title="编辑" target="rightFrame" >编辑</a>
            <a class="act-btn del" title="删除" href="#" alt="${addressBook.id}">删除</a>
            </span>
            </li>
            </#list>
          </ul>
        </div>
     </div>
	</td>
  </tr>
</table>
 </form>
</body>
</html>
