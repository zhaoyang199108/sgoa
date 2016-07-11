<#-- 
	自定义宏函数
 -->
<#-- 搜索结果关键字加红 -->
<#function strongText text keyword>
	<#if text == "" || keyword == "">
		<#return text> 	
	</#if>
	<#assign strongKw = "<strong>" + keyword + "</strong>">
	<#assign result = text?replace(keyword, strongKw)>
	<#return result> 	
</#function>
