<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>推荐页面</title>  
    <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>	
	<script type="text/javascript">
		$(document).ready( function() {
			$("#updateBtn").click( function() {
				$('form').submit();
			});
		});
	</script>
</head>
<body>
	<div id="main">
		<div id="content">
			<h3 class="title">推荐页面</h3>
			<form class="f0" action="${appDomain}/admin/user/tj_user.htm" method="POST">
				<input type="hidden" name="id"  value="${user.id}"/>
				<ul class="form-1c">
				<li>
					<label>是否推荐:</label>
					<select name="tj" class="sees">
						<option value=" ">请选择</option>
            		    <option value="1" <#if 1 == user.tj>selected="selected"</#if>>是</option>
            		    <option value="2" <#if 2 == user.tj>selected="selected"</#if>>否</option>
                     </select>
				</li>
				<li class="action">
						<input type="button" id="updateBtn" class="btn" value="提 交"/>
						<input type="button" value="取 消" class="btn" onclick="window.close();"/>
				</li>
			</ul>	
		</form>
	</div>
	</div>
</body>
</html>
