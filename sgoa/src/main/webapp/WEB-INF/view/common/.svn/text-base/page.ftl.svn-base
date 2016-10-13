<div class="pagination">
	<input type="hidden" name="crtpage" value="${page.currentPage}" />
	<input type="hidden" name="totalpage" value="${page.totalPage}" />
    <span>
    <#if page.firstPage>
		<a >上一页</a>
 	<#else>
		<a href="#" name="pplink">上一页</a>
	</#if>
	
	<#if page.lastPage>
		<a >下一页</a>
	<#else>
		<a href="#" name="nplink">下一页</a>
  	</#if>
  	
    <#if page.firstPage>
		<a >首页</a>
	<#else>
		<a href="#" name="fplink">首页</a>
	</#if>
    
    <#if page.lastPage>
		<a >尾页</a>
	<#else>
		<a href="#" name="lplink">尾页</a>
	</#if>
	
    <p>
	        共<strong>${page.totalRow}</strong>条记录,
	        当前第<strong>${page.currentPage}/${page.totalPage}</strong>页,
    </p>
    <p>跳转至<input id="cp" class="go-txt" name="cp" size="3" value="${page.currentPage}">页</p>
    <a id="goPage" class="go-btn" href="#" name="goPage" value="">GO</a>
  </span>  
</div>