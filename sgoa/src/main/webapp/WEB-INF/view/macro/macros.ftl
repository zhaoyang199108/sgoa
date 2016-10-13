<#-- 
	Screen定义及调用方式
	定义:需要进行数据逻辑处理的共通页面可以使用Screen.
	调用:<@myzbq.screen template="/home/common/banner" />
 -->
<#macro screen param...>
	${screenResolver.renderView(param)}
</#macro>
