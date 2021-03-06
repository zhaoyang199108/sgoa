package com.bcqsoft.sgoa.mvc.controller.index;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/home/appLogin.htm")
	@ResponseBody
	public Map<String, Object> appLogin(HttpServletRequest request, ModelMap map) throws UnsupportedEncodingException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String loginId = request.getParameter("loginId");
		String loginIdEn = URLDecoder.decode(loginId, "UTF-8");
/*		try {
			if(loginId!=null){
				loginId = new String(loginId.getBytes("iso-8859-1"),"utf-8");
				}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String psw = request.getParameter("psw");
		if (loginIdEn == null || loginIdEn.equals("")) {
			//0成功，1是失败（用户名密码错误），2数据连接错误
			
			resultMap.put("message", "用户名密码不正确，请重新输入！");
			resultMap.put("code", "1");
			resultMap.put("token", loginIdEn);
			resultMap.put("data", null);
			return resultMap;
		}
		if (psw == null || psw.equals("")) {
			resultMap.put("message", "用户名密码不正确，请重新输入！");
			resultMap.put("code", "1");
			resultMap.put("token", loginIdEn);
			resultMap.put("data", null);
			return resultMap;
		}
		String pswMd5 = MD5Util.toMd5(psw);
		User user = userService.getUserInfoByLoginId(loginIdEn);
		User user1 = null;
		User user2 = null;
		if ((user != null) && pswMd5.equals(user.getPassword())) {
			resultMap.put("loginId", loginIdEn);
			resultMap.put("code", "0");
			resultMap.put("token", loginIdEn);
			resultMap.put("message", "登录成功！");
			resultMap.put("data", user);
		}else{
			user1 = userService.findLoginIdByUserName(loginIdEn);
			if(user1!=null){
			user2 = userService.getUserInfoByLoginId(user1.getLoginId());
			if((user2!=null)&&pswMd5.equals(user2.getPassword())){
			 	resultMap.put("loginId", user2.getLoginId());
				resultMap.put("code", "0");
				resultMap.put("token", user2.getLoginId());
				resultMap.put("message", "登录成功！");
				resultMap.put("data", user2);
			}else{
				resultMap.put("loginId", loginIdEn);
				resultMap.put("code", "1");
				resultMap.put("token", loginIdEn);
				resultMap.put("message", "用户名密码不正确，请重新输入！");
				resultMap.put("data", null);
			}
		  }else{
			  	resultMap.put("loginId", loginIdEn);
				resultMap.put("code", "1");
				resultMap.put("token", loginIdEn);
				resultMap.put("message", "用户名密码不正确，请重新输入！");
				resultMap.put("data", null);
		  }
		}

		return resultMap;

	}
	/**
	 * 用户详细信息列表
	 * 
	 * @author zy
	 * @date 2016-9-21
	 * @return Map
	 */
	@RequestMapping("/home/app_getuser.htm")
	@ResponseBody
	public Map<String, Object> appGetUser(HttpServletRequest request, ModelMap map) {
		String loginId = request.getParameter("loginId");
		String retCode = "";
		String message = "";
		User user = userService.getUserInfoByLoginId(loginId);
		

		retCode = user==null?"1":"0";
		message = user==null?"取得失败":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", user);
		return resMap;

	}

}
