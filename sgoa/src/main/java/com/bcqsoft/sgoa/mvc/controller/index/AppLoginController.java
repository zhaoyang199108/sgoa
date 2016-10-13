package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.util.MD5Util;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * App登录控制器
 * 
 */
@Controller
public class AppLoginController {
	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;

	/**
	 * 登录页面
	 * 
	 * @author zy
	 * @date 2016-9-21
	 * @return Map
	 */
	@RequestMapping("/home/appLogin.htm")
	@ResponseBody
	public Map<String, Object> appLogin(HttpServletRequest request, ModelMap map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String loginId = request.getParameter("loginId");
		String psw = request.getParameter("psw");
		if (loginId == null || loginId.equals("")) {
			//0成功，1是失败（用户名密码错误），2数据连接错误
			
			resultMap.put("message", "用户名密码不正确，请重新输入！");
			resultMap.put("code", "1");
			resultMap.put("token", loginId);
			resultMap.put("data", null);
			return resultMap;
		}
		if (psw == null || psw.equals("")) {
			resultMap.put("message", "用户名密码不正确，请重新输入！");
			resultMap.put("code", "1");
			resultMap.put("token", loginId);
			resultMap.put("data", null);
			return resultMap;
		}
		String pswMd5 = MD5Util.toMd5(psw);
		
		User user = userService.getUserInfoByLoginId(loginId);
		if (pswMd5.equals(user.getPassword())) {
			resultMap.put("loginId", loginId);
			resultMap.put("code", "0");
			resultMap.put("token", loginId);
			resultMap.put("message", "登录成功！");
			resultMap.put("data", user);
		}

		return resultMap;

	}

}
