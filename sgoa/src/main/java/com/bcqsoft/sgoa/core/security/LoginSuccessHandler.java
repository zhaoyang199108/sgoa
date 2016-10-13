package com.bcqsoft.sgoa.core.security;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.bcqsoft.sgoa.common.util.Base64;
import com.bcqsoft.sgoa.dao.userkey.dataobject.UserKey;
import com.bcqsoft.sgoa.service.userkey.UserKeyService;

/**
 * 用户登录成功操作对象 <br>
 * scoa-security.xml中添加authentication-success-handler-ref="loginSuccessHandler"<br>
 * 用户登录成功后执行此对象的onAuthenticationSuccess方法
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


	/**
	 * 默认跳转页
	 */
	public static final String DEFAULT_URL = "/main.htm";
	
	/**
	 * 默认跳转页
	 */
	public static final String DEFAULT_URL_MOBILE = "/main_mobile.htm";
	
	/**
	 * 登录页面
	 */
	public static final String DEFAULT_URL_LOGIN = "/login.htm";
	
	/**
	 * 用户KEY申领表的业务逻辑层
	 */
	@Autowired
	private UserKeyService userKeyService;

	/**
	 * 用户登录成功操作
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			session.removeAttribute(WebAttributes.LAST_USERNAME);
		}
		SavedRequest savedRequest = (DefaultSavedRequest) session.getAttribute(WebAttributes.SAVED_REQUEST);
		// 取得用户登录ID
		String loginId = authentication.getName(); // 用户ID
		// 记录用户登录时间等信息
		// 如果用户直接登录,跳转至主页
		if (savedRequest == null) {
			String url = request.getParameter("isMobile");
			String serverIaguid = request.getParameter("serverIaguid");
			String _RndData = request.getParameter("_RndData");
			String serverSeed = request.getParameter("serverSeed");
			if (serverIaguid != null) {
				// 根据用户名称取得loginID
				UserKey userKey = userKeyService.findUserKeyInfo(serverIaguid);
				boolean result = false;
				if (userKey != null) {
					try {
						String Server_Seed = userKey.getServerSeed();		//数据库中取种子码
						MessageDigest md = MessageDigest.getInstance("SHA1");
						String a = _RndData+Server_Seed;
						byte[] serverDigest = md.digest(a.getBytes());
						byte[] clientDigest = Base64.decode(serverSeed);
						result = Arrays.equals(serverDigest, clientDigest);
					} catch (NoSuchAlgorithmException e) {
						result = false;
					} 
				}
				if (!result) {
					response.sendRedirect(DEFAULT_URL_LOGIN);
					return;
				}
			}
			if (url != null && "1".equals(url.toString())) {
				response.sendRedirect(DEFAULT_URL_MOBILE);
				return;
			}
			response.sendRedirect(DEFAULT_URL);
			return;
		}
		// 跳转至用户的目标页面
		session.removeAttribute(WebAttributes.SAVED_REQUEST);
		response.sendRedirect(savedRequest.getRedirectUrl());

	}

}
