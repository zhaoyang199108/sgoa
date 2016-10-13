<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>历史记录列表</title>
        <link href="${cssDomain}/css/style.css" rel="stylesheet" type="text/css">
        <script src="${jsDomain}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
        <script src="${jsDomain}/js/commons.js" type="text/javascript"></script>
	    <script src="${jsDomain}/js/page.js" type="text/javascript"></script>
	    <script type="text/javascript">
	    $(document).ready(function(){
			    // 内容按钮点击事件
			    $(".neirong").click(function(){
			        var url = "${appDomain}/docout/content_history.htm?dRecordid=" + $(this).attr("alt") + "&r=" + Math.random();
			        var param = 'dialogWidth=680px;dialogHeight=750px;status=no;center=yes;scroll=yes';
			        var val = window.showModalDialog(url, '', param);
			  	 if (val == 'refresh') {
			            alert("操作成功");
			        }
			    });
			});
		</script>
    </head>
    <body>
          <div class="main_nav">
            	<form id="docoutForm" name="docoutForm" action="${appDomain}/docout/docout_history.htm" method="GET">
	                <div class="ct">
	                    <table class="list">
	                        <tr>
	                            <th>标题</th>
	                            <th>当前操作人</th>
	                            <th>下一步操作人</th>
	                            <th>创建日期</th>
	                            <th>内容</th>
	                        </tr>
	                        <#list docoutHistoryList as docoutHistory>
		                        <tr>
		                            <td>${docoutHistory.title}</td>
		                            <td>${docoutHistory.currentOptName}</td>
		                            <td>${docoutHistory.nextOptName}</td>
		                            <td>${docoutHistory.createDate?date}</td>
		                            <td><a class="act-btn  neirong" href="#" title="内容" alt="${docoutHistory.recordID}">内容</a></td>
		                        </tr>
	                        </#list>
	                    </table>
	                </div>
	            </form>
            </div>
    </body>
</html>