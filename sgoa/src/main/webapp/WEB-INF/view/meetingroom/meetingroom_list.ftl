<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>会议室-列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	    <script type="text/javascript">
		$(document).ready(function(){
		
		    // 增加按钮点击事件
		    $(".add-btn").click(function(){
		        var url = "${appDomain}/meetingRoom/add.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=780px;dialogHeight=200px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		     //搜索按钮
		    
		     $("#searchBtn").click(function(){
		            $('form').submit();
             });
                
		    //双击事件
			$("table.list tr:not(:first)").dblclick(function(){
			
			   var url = "${appDomain}/meetingRoom/detail.htm?id=" + $(this).find("input[name=chkItem]").val() + "&r=" + Math.random();
			   var param = 'dialogWidth=780px;dialogHeight=200px;status=no;center=yes;scroll=no';
                var value = window.showModalDialog(url, '', param);
				
			  });
			  
		    // 更新按钮点击事件
		    $(".edit").click(function(){
		        var url = "${appDomain}/meetingRoom/edit.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
		        var param = 'dialogWidth=780px;dialogHeight=200px;status=no;center=yes;scroll=no';
		        var val = window.showModalDialog(url, '', param);
		        if (val == 'refresh') {
		            alert("操作成功");
		            $('form').submit();
		        }
		    });
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/meetingRoom/delete.htm?id=" + $(this).attr("alt");
		        if (confirm("确定删除该信息？")) {
		            $.get(url, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		    
		    // 批量删除按钮点击事件
		    $(".delete-btn").click(function(){
		    	// 被选中的单选框
		        var item = $("input[name=chkItem]:checked");
		        // 校验是否至少选择了一个单选框
		        if (item.length == 0) {
		            alert("请至少选择一条记录进行操作");
		            return false;
		        }
		        
		        if (confirm("确定删除所选信息？")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/meetingRoom/delete_batch.htm"
		            $.get(url, {
		                idArray: value
		            }, function(result){
		                alert("操作成功");
		                $('form').submit();
		            });
		        }
		    });
		});
		</script>
    <body>
        <div id="main">
          <div class="main_nav">
          <#include "user/menu.ftl">
            <div id="content">
                <div class="ct-top">
                <form id="listForm" name="listForm" action="${appDomain}/meetingRoom/list.htm" method="GET">
	                    <div class="search-bk">
	                      <span>会议室名称:</span>
	                      <input class="sch-txt-more" type="text" name="roomName" value="${page.roomName}" />
	                      <span>会议室地址:</span>
	                      <input class="sch-txt-more" type="text" name="roomAddress" value="${page.roomAddress}" />
	                    <a id="searchBtn" href="#" class="search-btn">搜索</a>
	              	  </div>
	               	   
	               	 <div class="btn-bk">
                       <a class="btn-add add-btn" href="#">新增</a>
                        <a class="btn-del delete-btn" href="#">删除</a>
                     </div>  
	                </div>
	                
	                  <div class="ct">
	                    <table class="list">
	                        <tr>
	                            <th class="left">
                                	<input  id="allBtn" type="checkbox" name="" value="" />
                            	</th>
								<th>会议室名称</th>
								<th>会议室地址</th>
								<th>创建时间</th>
								<th>操作</th>
	                        </tr>
	                        <#list page.meetingRoomList as meetingRoom>
								<tr>
									<td width="3%" >
		                                <input type="checkbox" name="chkItem" value=${meetingRoom.id} />
		                            </td>
									<td class="left" width="30%"><label style="width:280px;">${meetingRoom.roomName}</label></td>
									<td class="left" width="45%"><label style="width:380px;">${meetingRoom.roomAddress}</label></td>
									<td width="10%">${meetingRoom.createDate?date}</td>
									<td class="td-btn" width="10%"">
										<a class="act-btn edit"  title="更新" href="#" alt="${meetingRoom.id}">更新</a>
										<a class="act-btn del" title="删除" href="#" alt="${meetingRoom.id}">删除</a>
									</td>
								</tr>
							</#list>
	                        </tr>
	                    </table>
						<#include "common/page.ftl">
	                </div>
				</form>
	        </div>
        </div>
        </div>
    </body>
</html>