package com.bcqsoft.sgoa.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.util.Base64;
import com.bcqsoft.sgoa.dao.ipmac.dataobject.IpmacPage;
import com.bcqsoft.sgoa.dao.ipset.dataobject.IpSet;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.userkey.dataobject.UserKey;
import com.bcqsoft.sgoa.service.ipmac.IpmacService;
import com.bcqsoft.sgoa.service.ipset.IpSetService;
import com.bcqsoft.sgoa.service.user.UserService;
import com.bcqsoft.sgoa.service.userkey.UserKeyService;

/**
 * 登录控制器
 */
@Controller
public class LoginController {
	
	/**
	 * IP/MAC模块业务逻辑类接口
	 */
	@Autowired
	private IpmacService ipmacService;
	
	/**
	 * IP设置模块业务逻辑类接口
	 */
	@Autowired
	private IpSetService ipSetService;
	
	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 用户KEY申领表的业务逻辑层
	 */
	@Autowired
	private UserKeyService userKeyService;

	/**
	 * 登录页面
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("/login.htm")
	public String initLogin(HttpServletRequest request, ModelMap map) {
		
		// 取出是否需要判断ip地址
		IpSet ipSet = ipSetService.getIpSetListById();
		if (ipSet == null ) {
			return "login_key";
		}else if ("Y".equals(ipSet.getIsOpen())) {
			
			String ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
			
			IpmacPage page = new IpmacPage();
			page.setOptIp(ip);
			int count = ipmacService.findIpmacInfoCount(page);
			if (count == 0) {
				return "login_key";
			}
		}
		String _RndData = "";
		int b = 0;
		int a = 0;
		Random r = new Random();
		for (int i = 0; i < 32; i++) {
			a = r.nextInt(26);
			b = (char) (a + 65);
			_RndData += new Character((char) b).toString();
		}
		map.put("_RndData", _RndData);
		map.put("randomStr", new String(Base64.encode(_RndData.getBytes())));
		return "login";
	}
	
	/**
	 * 根据用户名称取得loginID
	 * 
	 * @param userName
	 * @return 用户信息
	 * @throws UnsupportedEncodingException 
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/user_key_sel.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> userKeySel(String serverIaguid) {
		// 根据用户名称取得loginID
		UserKey userKey = userKeyService.findUserKeyInfo(serverIaguid);
		User user = new User();
		if (userKey != null) {
			user = userService.getUserInfoByLoginId(userKey.getLoginId());
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userName", user.getUserName());
		return dataMap;
	}
	
	/**
	 * 根据摘要信息判断uKey是否正确
	 * 
	 * @param result
	 * @return 结果
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/user_key_check.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> userKeyCheck(String serverIaguid,String serverSeed,String _RndData) {
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
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("resultBoolean", result);
		return dataMap;
	}
	
	/**
	 * 根据用户名称取得loginID
	 * 
	 * @param userName
	 * @return 用户信息
	 * @throws UnsupportedEncodingException 
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/user_name_check.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> userNameCheck(String userName) throws UnsupportedEncodingException {
		// 根据用户名称取得loginID
		User user = userService.findLoginIdByUserName(URLDecoder.decode(userName, "UTF-8"));
		if(user == null){
			user = userService.getUserInfoByLoginId(URLDecoder.decode(userName, "UTF-8"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("user", user);
		return dataMap;
	}

	/**
	 * 登录页面
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("/loginIndex.htm")
	public String openLogin() {
		return "login_index";
	}

	/**
	 * 登录页面
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("/login_mobile.htm")
	public String initLoginMobile() {
		return "login_mobile";
	}
	
	/**
	 * 登录页面
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("/finger_index.htm")
	public String indexWorkTouch() {
		return "finger_index";
	}
	
	/**
	 * 登录页面
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("/finger_touch.htm")
	public String initWorkTouch() {
		return "finger_touch";
	}
}
