<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base target="_self">
	<title>会员详细</title>  
    <link href="${cssDomain}/css/main.css" type="text/css" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="${jsDomain}/js/GooCalendar/GooCalendar.css"/>
	<script type="text/javascript" src="${jsDomain}/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${jsDomain}/js/commons.js"></script>	
	<script type="text/javascript" src="${jsDomain}/js/volatile.js"></script>	
</head>
<body>
	<div id="main">
		<div id="content">
			<h3 class="title">会员详细</h3>
			<form class="f0" action="${appDomain}/admin/user/xx_user.htm" method="POST">
				<input type="hidden" name="id"  value="${user.id}"/>
				<ul class="form-1c">
				<li>
						<label>用户名:</label>
						<input class="text" type="text" name="loginId" value="${user.loginId}" readonly="readonly"/>
				</li>
				<li>
						<label>名称:</label>
						<input class="text" type="text" name="userName" value="${user.userName}" readonly="readonly"/>
				</li>
				 <li>
						<label>行业:</label>
						<select name="sortId" class="sees" disabled="disabled">
					        <#list sortdetailList as sortdetail>
                		    	<option value="${sortdetail.id}" <#if sortdetail.id == user.sortId>selected="selected"</#if>>${sortdetail.name}</option>
                       		</#list>
                         </select>
				</li>
				<li>
						<label>区域:</label>
						${user.s_province},${user.s_city},${user.s_county}
				</li>
				<li>
						<label>经度:</label>
						<input class="text" type="text" name="jd" value="${user.jd}" readonly="readonly"/>
				</li>
				<li>
						<label>纬度:</label>
						<input class="text" type="text" name="wd" value="${user.wd}" readonly="readonly"/>
				</li>
				<li>
						<label>地址:</label>
						<input class="text" type="text" name="address" value="${user.address}" readonly="readonly"/>
				</li>
				<li>
						<label>介绍:</label>
						<textarea name="introduce" rows="2" cols="40" maxlength="400" readonly>${user.introduce}</textarea>
				</li>
				<li>
						<label>logo:</label>
						<img src="${user.logo}" width="88" height="84" id="imgPhoto" />
				</li>
				<li>
						<label>banner:</label>
						<img src="${user.banner}" width="88" height="84" id="imgPhoto" />
				</li>
				<li>
						<label>资质:</label>
						<#list userzztList as userzzt>
						<img src="${userzzt.aptitude}" width="88" height="84" id="imgPhoto" />
						</#list>
				</li>
				<#if user.type == 1>
				 <li>
						<label>产品:</label>
						<select name="productId" class="sees" disabled="disabled">
					        <#list psortdetailList as sortdetail>
                		    	<option value="${sortdetail.id}" <#if sortdetail.id == user.productId>selected="selected"</#if>>${sortdetail.name}</option>
                       		</#list>
                         </select>
				</li>
				</#if>
				<#if user.type == 2>
				<li>
						<label>产品:</label>
						<input class="text" type="text" name="product" value="${user.product}" readonly="readonly"/>
				</li>
				</#if>
				
				<#list userdetailList as userdetail>
				<#if userdetail.type == 1>
				<li>
						<label>${userdetail.tmname}:</label>
						<input class="text" type="text" value="${userdetail.content}" readonly="readonly"/>
				</li>
				</#if>
				<#if userdetail.type == 2>
				<li>
						<label>${userdetail.tmnameq}:</label>
						<input class="text" type="text" value="${userdetail.content}" readonly="readonly"/>
				</li>
				</#if>
				</#list>
				<li class="action">
						<input type="button" value="关 闭" class="btn" onclick="window.close();"/>
				</li>
			</ul>	
		</form>
	</div>
	</div>
</body>
</html>
