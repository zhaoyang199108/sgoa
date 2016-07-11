package com.bcqsoft.xhlm.core.freemarker.function;

import java.util.List;

import org.springframework.stereotype.Component;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 用户权限对象
 */
@Component
public class StrSplitIndexFunction implements TemplateMethodModel {

	/**
	 * 判断用户权限Function <br>
	 * 参数中List为多个角色,取得用户的角色和参数进行比较.<br>
	 * 如果用户角色为当前参数中的角色返回True,反之False
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		
		String strObj = "";
		if(arguments.get(0) != null && !"".equals(arguments.get(0))){
			// 取得当前的位置信息
			strObj = String.valueOf(arguments.get(0));
		}
		String strTemp = "";
		if (strObj.length() > 12) {
			strTemp = strObj.substring(0,12)+"...";
		} else {
			strTemp = strObj;
		}
		return strTemp;
	}
}
