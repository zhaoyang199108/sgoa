<input type="hidden" name="crtpage" value="${page.currentPage}" />
<input type="hidden" name="totalpage" value="${page.totalPage}" />

<div class="page-info">
    <p class="page-count">
	        共<span>${page.totalRow}</span>条记录,
	        当前第<span>${page.currentPage}/${page.totalPage}</span>页,
	        每页<span>10</span>条记录
    </p>
    <div class="page-btn">
        <a href="#"></a>
        <#if page.firstPage>
			首 页|
		<#else>
			<a  href="#" name="fplink">首 页</a>|
		</#if>
		
		<#if page.firstPage>
			上一页|
	 	<#else>
			<a href="#" name="pplink">上一页</a>|
		</#if>
		
		<#if page.lastPage>
			下一页|
		<#else>
			<a href="#" name="nplink">下一页</a>|
	  	</#if>
	  	
	  	<#if page.lastPage>
			尾页|
	 	<#else>
			<a href="#" name="lplink">尾页</a>|
	 	</#if>
	        	
	        跳转至<input name="cp" id="cp" size="3" value="${page.currentPage}">页
        <input id="goPage" type="button" value="GO" /></div>
	</div>


<div>