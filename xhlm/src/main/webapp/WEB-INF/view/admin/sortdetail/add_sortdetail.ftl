<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>新增分类</title>  
    <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/validator.js"></script>
	<script type="text/javascript">
		$(document).ready( function() {					
			$("#saveBtn").click( function() {
			    // 分类名称非空校验
				if(!isEmpty($("input[name=name]"),"分类名称不允许为空！")){
					return;
				}
				$('form').submit();
			});
		});			
	</script>
</head>
<body>
	<div id="main">
		<div id="content">
			<h3 class="title">新增子类</h3>
			<form class="f0" action="${appDomain}/admin/sortdetail/add_sortdetail.htm" method="POST">
			<input type="hidden" value="${sortId}" name="sortId" />
				<table class="tbls">
					<tr>
						<th>名称:</th>
						<td>
							<input class="text" type="text" name="name" maxlength="20"/>
						</td>
					</tr>
				</table>	
				<input class="fm-btn" type="button" id="saveBtn" value="提 交" />
				<input class="fm-btn" type="button" value="取 消" onclick="window.close();" />
			</form>
		</div>
	</div>
</body>
</html>