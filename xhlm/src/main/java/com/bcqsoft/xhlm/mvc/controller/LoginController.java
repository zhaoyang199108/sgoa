package com.bcqsoft.xhlm.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制器
 */
@Controller
public class LoginController {

	/**
	 * 登录页面
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("/admin/login.htm")
	public String initLogin() {
		return "admin/login";
	}
}
