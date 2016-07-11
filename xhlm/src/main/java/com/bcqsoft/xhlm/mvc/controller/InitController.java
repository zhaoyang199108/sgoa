package com.bcqsoft.xhlm.mvc.controller;

import static com.bcqsoft.xhlm.common.util.DateUtil.getTodays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.util.MD5Util;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.mvc.form.user.UserForm;
import com.bcqsoft.xhlm.service.user.UserService;

/**
 * 页面框架初始化控制器
 */
@Controller
public class InitController {
	
	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 初始化页面框架
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("/admin/main.htm")
	public String initMain() {
		return "admin/main";
	}

	/**
	 * 初始化页面顶部
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/admin/init.htm", params = "frame=top")
	public String initTop(ModelMap map) {
		map.put("date", getTodays()); // 取得当前日期
		map.put("loginId", SecurityUtils.getLoginId()); // 取得登录用户名
		// 根据loginId取得用户信息
		User user = userService.getUserInfoByLoginId(SecurityUtils.getLoginId());
		map.put("userName", user == null ? "" : user.getUserName());// 取得登录用户名
		return "admin/body/top";
	}

	/**
	 * 初始化页面主要区域
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/admin/init.htm", params = "frame=index")
	public String initIndex() {
		return "admin/index";
	}

	/**
	 * 初始化页面左侧菜单栏
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/admin/init.htm", params = "frame=left")
	public String initLeft() {
		return "admin/body/left";
	}

	/**
	 * 初始化页面主要区域
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/admin/init.htm", params = "frame=bottom")
	public String initBottom() {
		return "admin/body/bottom";
	}
	
	/**
	 * 错误页面
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("error.htm")
	public String error() {
		return "error";
	}
	
	/**
	 * 没有权限页面
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("no_auth.htm")
	public String noAuth() {
		return "no_auth";
	}
		/**
	 * 用户更密码
	 * 
	 * @return 新增用户页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/admin/user/edit_password.htm", method = RequestMethod.GET)
	public String editUserPassWord() {
		return "admin/user/edit_password";
	}

	/**
	 * 用户更密码
	 * 
	 * @param map
	 * @return 更新用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/user/edit_password.htm")
	public String editUserPassWord(UserForm form, ModelMap map) {
		// 追加用户
		String loginId = SecurityUtils.getLoginId();
		User user = userService.getUserInfoByLoginId(loginId);
		if (user.getPassword().equals(MD5Util.toMd5(form.getOldPassword()))) {
			map.put("loginId", loginId);
			map.put("password", MD5Util.toMd5(form.getPassword()));
			userService.modifyUserPassword(map);
			
		}
		return "admin/common/action_succ";
	}
}
