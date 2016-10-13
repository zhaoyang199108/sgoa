<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>共享-列表</title>
         <link href="${cssDomain}/css/base.css" rel="stylesheet" type="text/css">
        <link href="${cssDomain}/css/list.css" rel="stylesheet" type="text/css"></head>
	    <script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
	    <script type="text/javascript" src="${jsDomain}/js/page.js"></script>
	     <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js"></script>
	     <script type="text/javascript" src="${jsDomain}/js/xheditor/xheditor-1.1.11-zh-cn.min.js"></script>
	    
	    <script type="text/javascript">
		$(document).ready(function(){
		 // 日期控件
			$("input[name=updateDate]").click(function(){
				WdatePicker();
			});
			//初始化xhEditor编辑器插件
			$("#ct").xheditor({
				tools:'full',
				skin:'default',
				upMultiple:false,
				upImgUrl: "${homeDomain}/upload_image.htm?dir=msg",
				upImgExt: "jpg,jpeg,gif,bmp,png"
			});
		    	//双击事件
			$("table.list tr:not(:first)").dblclick(function(){
			
			   var url = "${appDomain}/resFile/findDetail.htm?id=" + $(this).find("input[name=chkItem]").val() + "&r=" + Math.random();
			   var param = 'dialogWidth=760px;dialogHeight=500px;status=no;center=yes;scroll=no';
                var value = window.showModalDialog(url, '', param);
				
			  });
			  //详细按钮点击事件
              
            $(".edit").click(function(){
                var url = "${appDomain}/resFile/findDetail.htm?id=" + $(this).attr("alt") + "&r=" + Math.random();
                var param = 'dialogWidth=760px;dialogHeight=500px;status=no;center=yes;scroll=no';
                var value = window.showModalDialog(url, '', param);
            });
                
		
		    // 上传按钮点击事件
		    $("#addBtn").click(function(){
		        var url = "${appDomain}/resFile/add.htm" + "?r=" + Math.random();
		        var param = 'dialogWidth=760px;dialogHeight=560px;status=no;center=yes;scroll=no';
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
		 
		    
		    // 删除按钮点击事件
		    $(".del").click(function(){
		        var url = "${appDomain}/resShare/delete.htm?id=" + $(this).attr("alt");
		        
		        if (confirm("确定删除该公告？")) {
		            $.get(url, function(result){
		            
		             
		                $('form').submit();
		            });
		              
		        }
		    });
		    
		    // 批量删除按钮点击事件
		    $("#delBatchBtn").click(function(){
		    	// 被选中的单选框
		        var item = $("input[name=chkItem]:checked");
		        // 校验是否至少选择了一个单选框
		        if (item.length == 0) {
		            alert("请至少选择一条记录进行操作");
		            return false;
		        }
		        
		        if (confirm("确定删除所选公告？")) {
		            // 将所选Checkbox值转换为字符串
		            var value = "";
		            item.each(function(i){
		                if (i > 0) {value += ",";}
		                value += $(this).val();
		            });
					
		            var url = "${appDomain}/resShare/delete_batch.htm"
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
         <#include "resfile/menu.ftl">
            <div id="content">
               
                <div class="ct-top">
                
                
                 <form id="listForm" name="listForm" action="${appDomain}/resFile/sharelist.htm" method="GET">
					  <div class="btn-bk">
					 
	                        
	                        
	                     
	                    </div>
	                    <div class="search-bk">
	                	  <ul class="sch-key">
					
	                	
	                		<li><span>标题：</span><input class="sch-txt" type="text" name="title" value="${page.title}" /></li>
	                		<li><span>文件名称：</span><input class="sch-txt" type="text"name="srcFileName" value="${page.srcFileName}"/></li>
							<li><span>共享时间：</span><input class="sch-txt" type="text" name="updateDate" value="${page.updateDate}"  readonly="true"/></li>
							
	                	</ul>
	               	 </div>
	                <a id="searchBtn" href="#" class="search-btn">搜索</a>
	                </div>
	                
	                 
	                  <div class="ct">
	                    <table class="list">
	                        <tr>
	                        	
							    <th>标题</th>
								<th>内容</th>
								<th>附件名</th>
								<th>共享时间</th>
								 <th>操作</th>
	                          
	                        </tr>
	                        <#list page.resFileList as resFile >
								<tr>
									
									<td class="left" width="25%"><label style="width:240px;">${resFile.title}</label></td>
									<td class="left" width="25%"><label style="width:240px;">${resFile.content}</label></td>
									<td >${resFile.srcFileName}</td>
									<td>${resFile.updateDate?date}</td>
								<td wclass="td-btn" width="3%"><a class="act-btn edit" href="#" title="查看" alt="${resFile.id}">查看</a></td>
								</tr>
							</#list>
	                        </tr>
	                    </table>
						<#include "common/page.ftl">
	                </div>
				</form>
	        </div>
        </div>
    </body>
</html>