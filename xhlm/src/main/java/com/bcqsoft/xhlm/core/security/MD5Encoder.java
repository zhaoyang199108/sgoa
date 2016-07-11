package com.bcqsoft.xhlm.core.security;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.bcqsoft.xhlm.common.util.MD5Util;

public class MD5Encoder implements PasswordEncoder {

	/**
	 * 用户密码进行MD5加密
	 */
	@Override
	public String encodePassword(String rawPass, Object salt) throws DataAccessException {
		return MD5Util.toMd5(rawPass);
	}

	/**
	 * 用户密码验证
	 */
	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) throws DataAccessException {
		return encPass.equals(encodePassword(rawPass, salt));
	}

}
