package com.bcqsoft.xhlm.core.freemarker.function;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bcqsoft.xhlm.core.security.SecurityUtils;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

/**
 * 用户权限对象
 */
@Component
public class UserAuthFunction implements TemplateMethodModel {

	/**
	 * 判断用户权限Function <br>
	 * 参数中List为多个角色,取得用户的角色和参数进行比较.<br>
	 * 如果用户角色为当前参数中的角色返回True,反之False
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		// 取得当前登录用户所具有的权限
		List<String> authList = SecurityUtils.getUserAuthority();
		// 遍历集合,查找该用户是否满足此权限
		for (int i = 0; i < arguments.size(); i++) {
			String role = String.valueOf(arguments.get(i));
			for (String auth : authList) {
				// 如果当前登录用户有此权限
				// 返回用户满足此权限
				if (auth.equals(role)) {
					return Boolean.TRUE;
				}
			}
		}
		// 该用户不满足此权限
		return Boolean.FALSE;
	}
}
