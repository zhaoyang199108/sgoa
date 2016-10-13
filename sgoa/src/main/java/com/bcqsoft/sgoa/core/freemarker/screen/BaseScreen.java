package com.bcqsoft.sgoa.core.freemarker.screen;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Screen类接口<br>
 * 
 * @author zbq
 * @date 2010-05-28
 */
public abstract class BaseScreen {

	/**
	 * 取得渲染页面所需要使用的数据<br>
	 * <li>子类实现方法取得数据保存至model中</li>
	 * 
	 * @param request
	 * @throws Exception
	 */
	public abstract Map<String, Object> referenceData(HttpServletRequest request, String[] param);

	/**
	 * 取得模板名称,如果不复写此方法,默认使用传入参数的第一个参数
	 * 
	 * @param param
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-3-2
	 */
	public String getTemplate(String[] param, Map<String, Object> model) {
		return param[0];
	}
}
