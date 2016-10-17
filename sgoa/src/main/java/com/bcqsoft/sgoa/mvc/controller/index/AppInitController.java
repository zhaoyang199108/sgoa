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
import com.bcqsoft.sgoa.mvc.form.user.UserForm;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 
 * @author wudi
 * @date 2016/10/17
 *用户更新密码
 */
@Controller
public class AppInitController {
	/**
	 * 用户业务逻辑层
	 */
	@Autowired
	private UserService userService;
	
	
	/**
	 * 用户修改密码
	 * @param request
	 * @param map
	 * @param form
	 * @return
	 */
	@RequestMapping("/home/editPassword.htm")
	@ResponseBody
	public Map<String, Object> editUserPassWord(HttpServletRequest request, ModelMap map,UserForm form) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String loginId = request.getParameter("loginId"); //SecurityUtils.getLoginId(); 追加用户
		String psw = request.getParameter("psw");//当前用户密码
		String npsw = request.getParameter("npsw");//设置新密码
		User user = userService.getUserInfoByLoginId(loginId);
		if (user.getPassword().equals(MD5Util.toMd5(psw))) {//当前密码与数据库密码相等
			map.put("loginId", loginId);
			map.put("password", MD5Util.toMd5(npsw));
			userService.modifyUserPassword(map);
		}else{
			map.put("message", "用户名密码不正确");
		}
		String pswMd5 = MD5Util.toMd5(npsw);//新密码Md5加密
		if (pswMd5.equals(user.getPassword())) {
			resultMap.put("loginId", loginId);
			resultMap.put("password", npsw);
			resultMap.put("code", "0");
			resultMap.put("token", loginId);
			resultMap.put("message", "密码修改成功！");
			resultMap.put("data", user);
		}else{
				resultMap.put("message", "用户名密码不正确！");
				resultMap.put("code", "1");
				resultMap.put("token", loginId);
				resultMap.put("data", null);
		}
		
		return resultMap;
	}

}
