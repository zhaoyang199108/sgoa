<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <base target="_self">
        <title>记录打印</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="${jsDomain}/js/date/WdatePicker.js" defer="defer"></script>
        <script type="text/javascript" src="${jsDomain}/js/print/jquery-1.9.0.js"></script>
       	<script type="text/javascript" src="${jsDomain}/js/print/jquery.PrintArea.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){	       
	            // 日期控件
				$("input[name=startTime]").click(function(){
					WdatePicker();
				});
				// 日期控件
				$("input[name=endTime]").click(function(){
					WdatePicker();
				});
			
				/**
	        	 * 点击查询按钮
	        	 */
                $("#searchBtn").click(function(){
		            $('form').submit();
                });
               	
				$("#printBtn").click(function(){
		            var mode = "iframe";		            
		            var close = "popup";
		            var extraCss = "";		            
		            var keepAttr = ["class","id","style","on"];		            
		            var headElements = '';		            
		            var options = { mode : mode, popClose : close, extraCss : extraCss, retainAttr : keepAttr, extraHead : headElements };		            
		            $("#cyd").printArea( options );		
		        });
			});
		</script>
    </head>
    <body style="background:url(${imageDomain}/images/jl_bg.png);">
           <form id="docinForm" name="docinForm" action="${appDomain}/docin/jl.htm" method="GET">
                <div class="ct-top">
                	<div class="search-bk" style="width:90%;">
						<span>开始时间：</span>
						<input type="text" class="sch-txt" name="startTime" id="startTime" value="${page.startTime}" />
						<span>结束时间：</span>
						<input type="text" class="sch-txt" name="endTime" id="endTime" value="${page.endTime}" />
                 		<a id="searchBtn" href="#" class="search-btn">搜索</a>
                 		<a id="printBtn" href="#" class="search-btn">打印</a>
                 	</div>
                </div>
                <div id="cyd" class="cyd">
                <h1><img src="${imageDomain}/images/jl_tit.png"/></h1>
                <div class="ct">
                    <table class="list">
                        <tr>
                            <th>标题</th>
                            <th>文件编号</th>
                            <th>来文单位</th>
                            <th>登记号</th>
                            <th>登记时间</th>
                        </tr>
                        <#list page.docinList as docin>
	                        <tr>
	                            <input type="hidden" value="${docin.id}" />
	                            <td class="left">${docin.title}</td>
	                            <td>${docin.fileNum}</td>
	                            <td>${docin.fileDept}</td>
	                            <td>${docin.registerNum}</td>
	                            <td>${docin.createDate?time}</td>
	                        </tr>
                        </#list>
                    </table>
                    <p style="text-align:right; font-size:14px; font-weight:bold; padding-right:25px; line-height:40px;">操作人：${userName}</p>
                  </div> 
             </div>    
        </form>
    </body>
</html>