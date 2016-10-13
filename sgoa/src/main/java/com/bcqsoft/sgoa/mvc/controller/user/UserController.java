package com.bcqsoft.sgoa.mvc.controller.user;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.MD5Util;
import com.bcqsoft.sgoa.common.util.PinyinUtil;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.role.dataobject.Role;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.user.dataobject.UsersPage;
import com.bcqsoft.sgoa.dao.userrole.dataobject.UserRole;
import com.bcqsoft.sgoa.mvc.form.user.UserForm;
import com.bcqsoft.sgoa.service.user.UserService;

@Controller
public class UserController {

	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;

	/**
	 * 查看用户信息列表
	 * 
	 * @param map
	 * @return 用户列表页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/user/user_list.htm")
	public String userList(UserForm form, ModelMap map) {
		// 用户分页对象初始化
		UsersPage usersPage = new UsersPage();
		// 设置查询条件
		setSearchKey(form, usersPage);
		// 取得用户列表,分页显示
		UsersPage page = userService.getUserInfoList(usersPage);
		map.put("page", page);
		map.put("deptPage", userService.findAllDeptInfo());
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "user_list");
		// 跳转至用户列表页面
		return "user/user_list";
	}

	/**
	 * 跳转至新增用户页面
	 * 
	 * @return 新增用户页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/user/add_user.htm", method = RequestMethod.GET)
	public String addUser(ModelMap map) {
		return "user/add_user";
	}

	/**
	 * 判断登录ID是否存在
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/user/user_exist.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserExist(String loginId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 根据部门列表查找部门下所有人员
		User user = userService.getUserInfoByLoginId(loginId);
		boolean result = false;
		if (user == null) {
			result = false;
		} else {
			result = true;
		}
		dataMap.put("isExist", result);
		return dataMap;
	}
	
	/**
	 * 判断登录ID是否存在
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * @throws UnsupportedEncodingException 
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/user/user_name_exist.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserNameExist(String userName) throws UnsupportedEncodingException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 根据部门列表查找部门下所有人员
		User user = userService.findLoginIdByUserName(URLDecoder.decode(userName, "UTF-8"));
		boolean result = false;
		if (user == null) {
			result = false;
		} else {
			result = true;
		}
		dataMap.put("isExist", result);
		return dataMap;
	}

	/**
	 * 用户新增处理
	 * 
	 * @param map
	 * @return 新增用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/user/add_user.htm")
	public String addUser(UserForm form, ModelMap map) {
		// 追加用户
		userService.createUser(setBeans(form));
		return "user/add_success";
	}

	/**
	 * 跳转至更新用户页面
	 * 
	 * @return 新增用户页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/user/edit_user.htm", method = RequestMethod.GET)
	public String editUser(long id, ModelMap map) {
		// 取得要更新的仓库信息
		User user = userService.getUserInfo(id);
		map.put("user", user);
		return "user/edit_user";
	}

	/**
	 * 跳转至用户详细页面
	 * 
	 * @return 用户页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/user/user_detail.htm", method = RequestMethod.GET)
	public String userDetail(long id, ModelMap map) {
		// 取得用户详细页面
		User user = userService.getUserInfo(id);
		map.put("user", user);
		return "user/user_detail";
	}

	/**
	 * 用户更新处理
	 * 
	 * @param map
	 * @return 更新用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/user/edit_user.htm")
	public String editUser(UserForm form, ModelMap map) {
		// 追加用户
		if (null == form.getIsPass()) {
			userService.modifyUser(setBeansForPass(form));
		} else {
			userService.modifyUser(setBeans(form));
		}
		return "user/add_success";
	}
	
	/**
	 * 用户更新处理
	 * 
	 * @param map
	 * @return 更新用户排序号成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/user/editSo_user.htm")
	public String editSoUser(long id,String sorting) {
		User user = new User();
		user.setId(id);
		user.setSorting(sorting);
		userService.editSoUser(user);
		return "common/action_succ";
	}

	/**
	 * 用户删除处理
	 * 
	 * @param map
	 * @return 更新用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/user/delete_user.htm")
	public String deleteUser(long id) {
		// 删除用户
		userService.deleteUser(id);
		return "common/action_succ";
	}

	/**
	 * 删除仓库(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/user/delete_userArray.htm")
	public String removeUser(String idArray) {
		// 删除用户信息
		userService.deleteUsers(toLongArray(idArray));
		// 返回到操作成功页面
		return "common/action_succ";
	}

	/**
	 * 跳转至添加用户角色页面
	 * 
	 * @return 新增用户角色页面
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/user/user_role.htm", method = RequestMethod.GET)
	public String addUserRole(long id, ModelMap map) {
		// 取得要用户的基本信息
		User user = userService.getUserInfo(id);
		map.put("user", user);
		// 取得所有角色信息
		List<Role> roleList = userService.getRoleList();
		map.put("roleList", roleList);
		// 取得所有部门信息
		List<Dept> deptList = userService.getDeptList();
		map.put("deptList", deptList);
		// 取得当前用户的角色信息
		List<UserRole> userRoleList = userService.getUserRoleList(user
				.getLoginId());
		map.put("userRoleList", userRoleList);
		// 取得当前用户的部门Id
		Long deptIdForMap = null;
		for (UserRole userRoleTemp : userRoleList) {
			deptIdForMap = userRoleTemp.getDeptId();
		}
		map.put("deptIdForMap", deptIdForMap);
		return "user/user_role";
	}

	/**
	 * 添加用户角色
	 * 
	 * @return 操作成功页面
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	@RequestMapping("/user/add_user_role.htm")
	public String addUserRole(UserForm userForm) {
		// String[]转换long[]数组
		String[] strArray = userForm.getRoleIdArray();
		long[] idArray = new long[strArray.length];
		// 转换
		for (int i = 0; i < strArray.length; i++) {
			idArray[i] = NumberUtils.toLong(strArray[i]);
		}
		// 添加用户角色信息
		userService.createUserRole(userForm.getLoginId(), userForm.getDeptId(),
				idArray);
		// 返回到操作成功页面
		return "common/action_succ";
	}

	/**
	 * 用户列表页面设置查询条件
	 * 
	 * @param form
	 * @param usersPage
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private void setSearchKey(UserForm form, UsersPage usersPage) {
		// 设置查询条件
		usersPage.setCurrentPage(form.getCp()); // 当前页数
		usersPage.setLoginId(form.getLoginId()); // 仓库名称
		usersPage.setUserName(form.getUserName()); // 仓库地址
		usersPage.setDeptId(form.getDeptId()); // 部门
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return User
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private User setBeans(UserForm form) {
		User user = new User();
		BeanUtils.copyProperties(form, user); // 设置表单属性
		user.setPassword(MD5Util.toMd5(form.getPassword()));// 设置用户密码为MD5加密
		user.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		// user.setLoginId(SecurityUtils.getLoginId()); // 设置登录用户Id
		user.setUserNamePy(PinyinUtil.toAbbLowPinyin(user.getUserName()));// 用户名转换成拼音
		return user;
	}
	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return User
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private User setBeansForPass(UserForm form) {
		User user = new User();
		BeanUtils.copyProperties(form, user); // 设置表单属性
		user.setPassword(null);// 
		user.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		// user.setLoginId(SecurityUtils.getLoginId()); // 设置登录用户Id
		user.setUserNamePy(PinyinUtil.toAbbLowPinyin(user.getUserName()));// 用户名转换成拼音
		return user;
	}
	/**
	 * 取得所有权限信息
	 * 
	 * @param map
	 * @return 权限信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/user/find_user_role.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findUserLoer(String loginId, ModelMap map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 查找权限列表
		List<Role> roleList = userService.getRoleList();
		dataMap.put("roleList", roleList);
		// 取得当前用户的角色信息
		List<UserRole> userRoleList = userService.getUserRoleList(loginId);
		dataMap.put("userRoleList", userRoleList);
		return dataMap;
	}
}
