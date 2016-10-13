package com.bcqsoft.sgoa.core.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 权限管理工具类
 */
public class SecurityUtils {

	/**
	 * 取得登录用户名
	 * 
	 * @return 用户名
	 * 
	 * @Author zbq
	 * @Date 2011-9-7
	 */
	public static String getLoginId() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	/**
	 * 取得登录用户角色
	 * 
	 * @return 角色集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-3-7
	 */
	public static List<String> getUserAuthority() {
		List<String> authList = new ArrayList<String>();

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth == null) {
			return authList;
		}

		for (GrantedAuthority authority : auth.getAuthorities()) {
			authList.add(authority.getAuthority());
		}
		return authList;
	}

	/**
	 * 判断某一用户ID是否是当前登录用户
	 * 
	 * @param userId
	 * @return True:是, False:否
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-13
	 */
	public static boolean isLoginUser(String userId) {
		if (StringUtils.isBlank(userId)) {
			return Boolean.FALSE;
		}
		return userId.equals(SecurityUtils.getLoginId());
	}

}
