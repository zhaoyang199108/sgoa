package com.bcqsoft.xhlm.mvc.controller.index;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.xhlm.common.util.MD5Util;
import com.bcqsoft.xhlm.common.util.PinyinUtil;
import com.bcqsoft.xhlm.common.util.SendMessageUtil;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.service.common.UploadImageService;
import com.bcqsoft.xhlm.service.user.UserService;

@Controller
public class XhUserController {

	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 上传模块业务逻辑层
	 */
	@Autowired
	private UploadImageService uploadService;
	
	/**
	 * 用户注册接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/code.htm")
	public Map<String,Object> code(HashMap<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		String tel = request.getParameter("loginId");
		// 判断该用户名是否注册
		String retCode = "";
		String message = "";
		String code = "";
		if (tel == null) {
			retCode = "1";
			message = "电话号码有误,请重新填写";
		} else {
			code = SendMessageUtil.sendCode(tel);
		}
		if ("".equals(code)) {
			retCode = "1";
			message = "电话号码有误,请重新填写";
		} else {
			retCode = "0";
			message = "发送验证码成功";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("code", code);
		map.put("data", data);
		return map;
	}
	
	/**
	 * 用户注册接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/regist.htm")
	public Map<String,Object> regist(HashMap<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		
		String retCode = "";
		String message = "";
		// 验证验证码是否正确
		String code = request.getParameter("code");
		String codeInput = request.getParameter("codeInput");
		if (code != null) {
			if (!code.equals(codeInput)) {
				retCode = "1";
				message = "验证码不正确";
				// 输出json格式数据
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("ret_code", retCode);
				map.put("message", message);
				return map;
			}
		}
		String loginId = request.getParameter("loginId");
		// 判断该用户名是否注册
		User userObj = userService.getUserInfoByLoginId(loginId);
		
		if (userObj == null) {
			// 取得所有注册信息
			User user = new User();
			// 输入用户名
			user.setLoginId(loginId);
			user.setPassword(MD5Util.toMd5(request.getParameter("password")));
			user.setType(4);
			user.setStatus(2);
			boolean result = userService.createUser(user);
			if (result) {
				retCode = "0";
				message = "注册成功";
			} else {
				retCode = "2";
				message = "注册失败";
			}
		} else {
			retCode = "3";
			message = "用户名已经注册，请重写输入";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", loginId);
		return map;
	}
	
	/**
	 * 用户信息提交接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/login.htm")
	public Map<String,Object> login(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		Integer type = null;
		String loginIdRes = "";
		String retCode = "";
		String message = "";
		User user = userService.getUserInfoByLoginId(loginId);
		if (user != null) {
			if (MD5Util.toMd5(password).equals(user.getPassword())) {
				retCode = "0";
				message = "登录成功";
				loginIdRes = user.getLoginId();
				type = user.getType();
			} else {
				retCode = "2";
				message = "用户名或密码不正确";
			}
		} else {
			retCode = "2";
			message = "用户名或密码不正确";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", loginIdRes);
		// 输出json格式数据
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("type", type);
		map.put("data", data);
		return map;
	}
	
	/**
	 * 忘记密码接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/pwd_get.htm")
	public Map<String,Object> pwdGet(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得原密码
		String loginId = request.getParameter("loginId");
		String pwd = request.getParameter("password");
		// 选择职工
		User user = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		// 验证验证码是否正确
		String code = request.getParameter("code");
		String codeInput = request.getParameter("codeInput");
		if (code != null) {
			if (!code.equals(codeInput)) {
				retCode = "1";
				message = "验证码不正确";
				// 输出json格式数据
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("ret_code", retCode);
				map.put("message", message);
				return map;
			}
		}
		if (user != null) {
		    // 更改市民密码
		    ModelMap map = new ModelMap();
		    map.put("loginId", user.getLoginId());
		    map.put("password", MD5Util.toMd5(pwd));
		    boolean result = userService.modifyUserPassword(map);
		    if (result) {
        		retCode = "0";
				message = "密码设置成功";
			} else {
				retCode = "2";
				message = "密码设置失败";
			}
		} else {
			retCode = "3";
			message = "没有此用户，请联系管理员";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", loginId);
		// 输出json格式数据
		map.put("data", user);
		return map;
	}
	
	/**
	 * 退出接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/login_out.htm")
	public Map<String,Object> loginOut(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		String loginId = request.getParameter("loginId");
		String retCode = "";
		String message = "";
		if (loginId != null) {
			//loginStatusService.deleteLoginStatusInfoById(loginId);
			retCode = "0";
			message = "退出成功";
		} else {
			retCode = "1";
			message = "退出失败";
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		return map;
	}
	
	/**
	 * 照片上传接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/file_upload.htm")
	public Map<String,Object> logoUpload(@RequestParam(value = "file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) {
		
		// 判断该用户名是否注册
		String retCode = "";
		String message = "";
		// 上传文件并返回文件路径
		// 得到文件名
		String upDir = "";
		if (file != null) {
			String filename = file.getOriginalFilename();
			if (!"".equals(filename)) {
				if (file != null && file.getSize() != 0) {
					try {
						// 上传图片,返回图片访问路径,如果上传出错返回错误信息
						upDir = uploadService.uploadNewsImage(file,"logo");
						retCode = "0";
						message = "上传头像成功";
					} catch (IOException e) {
						retCode = "2";
						message = "上传头像失败";
					}
				}
			}
		} else {
			retCode = "1";
			message = "上传头像失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("fileDir", upDir);
		map.put("data", data);
		return map;
	}
	
	/**
	 * 用户信息提交接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/user_info_save.htm")
	public Map<String,Object> userInfoSave(HttpServletRequest request,HttpServletResponse response) {
		
		String loginId = request.getParameter("loginId");
		// 判断该用户名是否注册
		User userObj = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		if (userObj != null) {
			String userName = request.getParameter("userName");
			String logo = request.getParameter("logo");
			String banner = request.getParameter("banner");
			String sortId = request.getParameter("sortId");
			String qyStr = request.getParameter("qyStr");
			String s_province = "";
		    String s_city = "";
			String s_county = "";
			if (qyStr != null && !"".equals(qyStr)) {
				String[] qyStrs = qyStr.split(" ");
				s_province = qyStrs[0];
				if (qyStrs.length > 1) {
					s_city = qyStrs[1];
				}
				if (qyStrs.length > 2) {
					s_county = qyStrs[2];
				}
			}
			String address = request.getParameter("address");
			String introduce = request.getParameter("introduce");
			String productId = request.getParameter("productId");
			
			// 输入用户名
			userObj.setUserName(userName);
			userObj.setUserNamePy(PinyinUtil.toAbbLowPinyin(userName));
			userObj.setLogo(logo);
			userObj.setBanner(banner);
			userObj.setSortId(sortId);
			userObj.setS_province(s_province);
			userObj.setS_city(s_city);
			userObj.setS_county(s_county);
			userObj.setAddress(address);
			userObj.setIntroduce(introduce);
			userObj.setProductId(productId);
			boolean result = userService.modifyUserHome(userObj);
			if (result) {
				retCode = "0";
				message = "更新成功";
			} else {
				retCode = "2";
				message = "更新失败";
			}
		} else {
			retCode = "1";
			message = "更新失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", loginId);
		map.put("data", userObj);
		return map;
	}
	
	/**
	 * 用户协会信息提交接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/user_xh_info_save.htm")
	public Map<String,Object> userXhInfoSave(HttpServletRequest request,HttpServletResponse response) {
		
		String loginId = request.getParameter("loginId");
		// 判断该用户名是否注册
		User userObj = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		if (userObj != null) {
			String userName = request.getParameter("userName");
			String logo = request.getParameter("logo");
			String banner = request.getParameter("banner");
			String sortId = request.getParameter("sortId");
			String qyStr = request.getParameter("qyStr");
			String s_province = "";
		    String s_city = "";
			String s_county = "";
			if (qyStr != null && !"".equals(qyStr)) {
				String[] qyStrs = qyStr.split(" ");
				s_province = qyStrs[0];
				if (qyStrs.length > 1) {
					s_city = qyStrs[1];
				}
				if (qyStrs.length > 2) {
					s_county = qyStrs[2];
				}
			}
			String address = request.getParameter("address");
			String introduce = request.getParameter("introduce");
			String productId = request.getParameter("productId");
			
			// 输入用户名
			userObj.setUserName(userName);
			userObj.setUserNamePy(PinyinUtil.toAbbLowPinyin(userName));
			userObj.setLogo(logo);
			userObj.setBanner(banner);
			userObj.setSortId(sortId);
			userObj.setS_province(s_province);
			userObj.setS_city(s_city);
			userObj.setS_county(s_county);
			userObj.setAddress(address);
			userObj.setIntroduce(introduce);
			userObj.setProductId(productId);
			userObj.setType(1);
			boolean result = userService.modifyUserHome(userObj);
			if (result) {
				retCode = "0";
				message = "更新成功";
			} else {
				retCode = "2";
				message = "更新失败";
			}
		} else {
			retCode = "1";
			message = "更新失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", loginId);
		map.put("data", userObj);
		return map;
	}
}
