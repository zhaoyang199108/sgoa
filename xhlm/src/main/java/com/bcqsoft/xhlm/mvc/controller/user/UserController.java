package com.bcqsoft.xhlm.mvc.controller.user;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

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

import com.bcqsoft.xhlm.common.util.MD5Util;
import com.bcqsoft.xhlm.common.util.PinyinUtil;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.role.dataobject.Role;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.Sortdetail;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.dao.user.dataobject.UsersPage;
import com.bcqsoft.xhlm.dao.userdetail.dataobject.Userdetail;
import com.bcqsoft.xhlm.dao.userrole.dataobject.UserRole;
import com.bcqsoft.xhlm.dao.userzzt.dataobject.Userzzt;
import com.bcqsoft.xhlm.mvc.form.user.UserForm;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;
import com.bcqsoft.xhlm.service.user.UserService;

@Controller
public class UserController {

	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 分类详细模块业务逻辑类接口
	 */
	@Autowired
	private SortdetailService sortdetailService;
	
	/**
	 * 查看用户信息列表
	 * 
	 * @param map
	 * @return 用户列表页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/user/user_list.htm")
	public String userList(UserForm form, ModelMap map) {
		// 用户分页对象初始化
		UsersPage usersPage = new UsersPage();
		// 设置查询条件
		setSearchKey(form, usersPage);
		String loginId = SecurityUtils.getLoginId();
		User user = userService.getUserInfoByLoginId(loginId);
		if (user != null && user.getType() == 1) {
			usersPage.setDeptId(String.valueOf(user.getId()));
		}
		// 取得用户列表,分页显示
		UsersPage page = userService.getUserInfoList(usersPage);
		map.put("page", page);
		
		Sortdetail detail = new Sortdetail();
		detail.setSortId("2");
		map.put("sortdetailPage", sortdetailService.getSortdetailList(detail));
		// 跳转至用户列表页面
		return "admin/user/user_list";
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
		usersPage.setLoginId(form.getLoginId()); // 登录ID
		usersPage.setSortId(form.getSortId());//行业
		usersPage.setS_province(form.getS_province());
		usersPage.setS_city(form.getS_city());
		usersPage.setS_county(form.getS_county());
	}
	
	/**
	 * 跳转至更新用户页面
	 * 
	 * @return 新增用户页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/admin/user/edit_user.htm", method = RequestMethod.GET)
	public String editUser(long id, ModelMap map) {
		// 取得要更新的仓库信息
		User user = userService.getUserInfo(id);
		map.put("user", user);
		
		//取得会员资质图列表
		Userzzt userzzt = new Userzzt();
		userzzt.setUserId(id);
		List<Userzzt> userzztList = userService.getUserzztList(userzzt);
		map.put("userzztList", userzztList);
		
		//取得会员详细列表
		Userdetail userdetail = new Userdetail();
		userdetail.setUserId(String.valueOf(user.getLoginId()));
		List<Userdetail> userdetailList = userService.getUserdetailList(userdetail);
		map.put("userdetailList", userdetailList);
		
		//取得行业列表
		Sortdetail detail = new Sortdetail();
		detail.setSortId("2");
		List<Sortdetail> sortdetailList = sortdetailService.getSortdetailList(detail);
		map.put("sortdetailList", sortdetailList);
		
		//取得产品列表
		Sortdetail pdetail = new Sortdetail();
		pdetail.setSortId("3");
		List<Sortdetail> psortdetailList = sortdetailService.getSortdetailList(pdetail);
		map.put("psortdetailList", psortdetailList);
		return "admin/user/edit_user";
	}
	
	/**
	 * 跳转至用户详细页面
	 * 
	 * @return 用户详细页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/admin/user/xx_user.htm", method = RequestMethod.GET)
	public String xxUser(long id, ModelMap map) {
		// 取得要更新的仓库信息
		User user = userService.getUserInfo(id);
		map.put("user", user);
		
		//取得会员资质图列表
		Userzzt userzzt = new Userzzt();
		userzzt.setUserId(id);
		List<Userzzt> userzztList = userService.getUserzztList(userzzt);
		map.put("userzztList", userzztList);
		
		//取得会员详细列表
		Userdetail userdetail = new Userdetail();
		userdetail.setUserId(String.valueOf(user.getLoginId()));
		List<Userdetail> userdetailList = userService.getUserdetailList(userdetail);
		map.put("userdetailList", userdetailList);
		
		//取得行业列表
		Sortdetail detail = new Sortdetail();
		detail.setSortId("2");
		List<Sortdetail> sortdetailList = sortdetailService.getSortdetailList(detail);
		map.put("sortdetailList", sortdetailList);
		
		//取得产品列表
		Sortdetail pdetail = new Sortdetail();
		pdetail.setSortId("3");
		List<Sortdetail> psortdetailList = sortdetailService.getSortdetailList(pdetail);
		map.put("psortdetailList", psortdetailList);
		return "admin/user/xx_user";
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
	@RequestMapping("/admin/user/edit_user.htm")
	public String editUser(UserForm form, ModelMap map) {
		// 追加用户
		userService.modifyUser(setBeans(form));
		return "admin/common/action_succ";
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
		user.setUserNamePy(PinyinUtil.toAbbLowPinyin(user.getUserName()));// 用户名转换成拼音
		user.setStatus(1);
		return user;
	}
	
	/**
	 * 跳转至添加用户角色页面
	 * 
	 * @return 新增用户角色页面
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/admin/user/user_role.htm", method = RequestMethod.GET)
	public String addUserRole(long id, ModelMap map) {
		// 取得要用户的基本信息
		User user = userService.getUserInfo(id);
		map.put("user", user);
		// 取得所有角色信息
		List<Role> roleList = userService.getRoleList();
		map.put("roleList", roleList);
		// 取得当前用户的角色信息
		List<UserRole> userRoleList = userService.getUserRoleList(user
				.getLoginId());
		map.put("userRoleList", userRoleList);
		// 取得当前用户的部门Id
		Long deptIdForMap = null;
		//for (UserRole userRoleTemp : userRoleList) {
			//deptIdForMap = userRoleTemp.getDeptId();
		//}
		map.put("deptIdForMap", deptIdForMap);
		return "admin/user/user_role";
	}
	
	/**
	 * 添加用户角色
	 * 
	 * @return 操作成功页面
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/user/add_user_role.htm")
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
		return "admin/common/action_succ";
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
	@RequestMapping("/admin/user/delete_user.htm")
	public String deleteUser(long id) {
		// 删除用户
		userService.deleteUser(id);
		return "admin/common/action_succ";
	}
	
	/**
	 * 删除用户(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/user/delete_userArray.htm")
	public String removeUser(String idArray) {
		// 删除用户信息
		userService.deleteUsers(toLongArray(idArray));
		// 返回到操作成功页面
		return "admin/common/action_succ";
	}
	
	/**
	 * 跳转至用户详细页面
	 * 
	 * @return 用户页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/admin/user/user_detail.htm", method = RequestMethod.GET)
	public String userDetail(long id, ModelMap map) {
		User user = new User();
		user.setDeptId(String.valueOf(id));
		List<User> userList = userService.getUserList(user);
		map.put("userList", userList);
		return "admin/user/user_detail";
	}
	
	/**
	 * 用户开启处理
	 * 
	 * @param map
	 * @return 开启用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/user/start_user.htm")
	public String startUser(long id) {
		User user = new User();
		user.setId(id);
		user.setStatus(1);
		userService.updateUserStatus(user);
		return "admin/common/action_succ";
	}
	
	/**
	 * 用户禁用处理
	 * 
	 * @param map
	 * @return 禁用用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/user/end_user.htm")
	public String endUser(long id) {
		User user = new User();
		user.setId(id);
		user.setStatus(3);
		userService.updateUserStatus(user);
		return "admin/common/action_succ";
	}
	
	/**
	 * 禁用用户(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/user/end_userArray.htm")
	public String endUser(String idArray) {
		// 禁用用户信息
		userService.endUsers(toLongArray(idArray));
		// 返回到操作成功页面
		return "admin/common/action_succ";
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
	@RequestMapping(value = "/admin/user/find_user_role.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findUserLoer(String loginId,ModelMap map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 查找权限列表
		List<Role> roleList = userService.getRoleList();
		dataMap.put("roleList", roleList);
		// 取得当前用户的角色信息
		List<UserRole> userRoleList = userService.getUserRoleList(loginId);
		dataMap.put("userRoleList", userRoleList);
		return dataMap;
	}
	
	/**
	 * 跳转至推荐用户页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/admin/user/tj_user.htm", method = RequestMethod.GET)
	public String tjUser(long id, ModelMap map) {
		User user = userService.getUserInfo(id);
		map.put("user", user);
		return "admin/user/tj_user";
	}
	
	/**
	 * 用户推荐处理
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/admin/user/tj_user.htm")
	public String tjUser(UserForm form, ModelMap map) {
		User user = new User();
		user.setId(form.getId());
		user.setTj(form.getTj());
		userService.modifyUserByTj(user);
		return "admin/common/action_succ";
	}
}
