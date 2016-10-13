<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base target="_self">
        <title>通讯录分组-列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css" />
		<link href="${cssDomain}/css/addressbook.css" rel="stylesheet" type="text/css" />
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/biz/addressBookType.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		    
		     // 保存按钮点击事件
		    $(".save").click(function(){
		        var index = $(this).attr("alt");
		        // 分组名称非空校验
		        if ($("#typeNameId"+index).val() == "") {
		        	alert("分组名称不允许为空！");
		        	$("#typeNameId"+index).focus();
        			$("#typeNameId"+index).css('borderColor','red');
		        	return;
		        }
			    if(""!=$("#sortingId"+index).val() && undefined!=$("#sortingId"+index)){		
					// 排序号数字校验
					var patrn=/^[0-9]{1,20}$/;//判断字符串是否为数字      
    				if (!patrn.exec($("#sortingId"+index).val())){
    					alert("排序号必须为数字！");
    					$("#sortingId"+index).focus();
        				$("#sortingId"+index).css('borderColor','red');
    					return;
    				}				
				}
				var url = "${appDomain}/addressBookType/edit_addressBookType.htm?id="+$("#typeId"+index).val()+"&sorting="+$("#sortingId"+index).val()+"&typeName="+encodeURI($("#typeNameId"+index).val())+"&r=" + Math.random();	
		        if (confirm("确定保存该信息？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                window.opener=null;
						window.open('','_self');
						window.returnValue="refresh";
					    window.close();
		            });
		        }
		    });
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/addressBookType/delete.htm?id=" + $(this).attr("alt")+"&r=" + Math.random();
		        if (confirm("确定删除该信息？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                window.opener=null;
						window.open('','_self');
						window.returnValue="refresh";
					    window.close();
		            });
		        }
		    });
		    
		});
		</script>
	</head>
    <body>
		  <table class="yxb">
		 <tr>
		   <td class="right_ad">
		   <a id="addBtn" class="action-opt" href="#">新建分组</a>
		   </td>
		 </tr>
		  <tr>
		    <form id="listForm" name="listForm" action="${appDomain}/addressBookType/list.htm">
		    <td class="right_ad">
			 
		     <table id="boundTb" class="wile">
		       <tr>
		         <th>排序号</th>
		         <th>分组名称</th>
		         <th colspan="2">操作</th>
		       </tr>
		    <#if typeSize == 0>
			   <tr id="typeTr1">
		         <td>
		         <input class="bi" type="hidden" id="typeId1" name="id" value="0"/>
		         <input class="bi" type="text" id="sortingId1" name="sorting" value=""/>
		         </td>
		         <td>
		         <input class="bi" type="text" id="typeNameId1" name="typeName" value=""/>
		         </td>
		         <td>
				<a class="act-btn save" id="saveTrBtn1"  href="#" title="保存" alt="1">保存</a>
			 </td>
			 <td>
				<a class="act-btn del" id="delTrBtn1" href="#" title="删除" alt="">删除</a>
			 </td>	
		       </tr>
		       </#if>
		      <#list page.addressTypeList as addressBookType>
		       <tr id="typeTr${addressBookType_index+1}">
		         <td>
		         <input class="bi" type="hidden" id="typeId${addressBookType_index+1}" name="id" value="${addressBookType.id}"/>
		         <input class="bi" type="text" id="sortingId${addressBookType_index+1}" name="sorting" value="${addressBookType.sorting}"/>
		         </td>
		         <td>
		         <input class="bi" type="text" id="typeNameId${addressBookType_index+1}" name="typeName" value="${addressBookType.typeName}"/>
		         </td>
		         <td>
					<a class="act-btn save" id="saveTrBtn${addressBookType_index+1}"  href="#" title="保存" alt="${addressBookType_index+1}">保存</a>
				 </td>
				 <td>
					<a class="act-btn del" id="delTrBtn${addressBookType_index+1}" href="#" title="删除" alt="${addressBookType.id}">删除</a>
				 </td>	
		       </tr>
		       </#list>
		     </table></td>
		  </tr>
		</table>
	 </form>
    </body>
</html>