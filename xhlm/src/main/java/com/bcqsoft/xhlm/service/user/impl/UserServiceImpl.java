package com.bcqsoft.xhlm.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.role.RoleDAO;
import com.bcqsoft.xhlm.dao.role.dataobject.Role;
import com.bcqsoft.xhlm.dao.sortdetail.SortdetailDAO;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.Sortdetail;
import com.bcqsoft.xhlm.dao.user.UserDAO;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.dao.user.dataobject.UsersPage;
import com.bcqsoft.xhlm.dao.userdetail.UserdetailDAO;
import com.bcqsoft.xhlm.dao.userdetail.dataobject.Userdetail;
import com.bcqsoft.xhlm.dao.userrole.UserRoleDAO;
import com.bcqsoft.xhlm.dao.userrole.dataobject.UserRole;
import com.bcqsoft.xhlm.dao.userxh.UserXhDAO;
import com.bcqsoft.xhlm.dao.userxh.dataobject.UserXh;
import com.bcqsoft.xhlm.dao.userzzt.UserzztDAO;
import com.bcqsoft.xhlm.dao.userzzt.dataobject.Userzzt;
import com.bcqsoft.xhlm.service.user.UserService;

/**
 * 仓库模块业务逻辑实现类
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

	/**
	 * 用户模块DAO实现类
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 角色模块DAO实现类
	 */
	@Autowired
	private RoleDAO roleDAO;

	/**
	 * 用户角色模块DAO实现类
	 */
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	/**
	 * 资质图模块DAO实现类
	 */
	@Autowired
	private UserzztDAO userzztDAO;
	
	/**
	 * 用户详细模块DAO实现类
	 */
	@Autowired
	private UserdetailDAO userdetailDAO;

	/**
	 * 类别详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private SortdetailDAO sortdetailDAO;
	
	/**
	 * 用户角色模块DAO实现类
	 */
	@Autowired
	private UserXhDAO userXhDao;
	
	/**
	 * 根据用户LoginID查询用户表信息
	 * 
	 * @param userId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public User getUserInfoByLoginId(String loginId) {
		User user = userDAO.getUserInfoByLoginId(loginId);
		return user;
	}
	
	/**
	 * 修改用户密码
	 * 
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public boolean modifyUserPassword(ModelMap map) {
		Integer count = userDAO.updateUserPassword(map);
		return isUpdateSucc(count);
	}
	
	/**
	 * 根据查询条件查找用户信息列表
	 * 
	 * @param id
	 * @return 用户分页对象
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public UsersPage getUserInfoList(UsersPage page) {
		int count = userDAO.findUserInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得用户信息集合(分页查询)
		List<User> userList = userDAO.findUserInfoList(page);

		page.setTotalRow(count); // 用户总数量
		page.setUserList(userList); // 用户信息集合
		return page;
	}

	/**
	 * 根据ID查找某一用户的信息
	 * 
	 * @param userId
	 * @return User
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public User getUserInfo(long userId) {
		User user = userDAO.getUserInfo(userId);
		return user;
	}
	
	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean modifyUser(User user) {
		// 更新该条用户信息,并返回是更新成功
		long userId = user.getId();
		User userOld = userDAO.getUserInfo(userId);
		// 定义map
		ModelMap map = new ModelMap();
		// 设置map值
		map.put("loginId", user.getLoginId());
		// 取得更改以前的loginId
		map.put("loginOldId", userOld.getLoginId());
		// 更新用户角色里的用户登录ID
		userRoleDAO.updateUserRole(map);
		// 更新用户表loginId
		Integer count = userDAO.updateUserInfoById(user);
		if (userOld.getType() == 2) {
			UserXh userXh = new UserXh();
			userXh.setUserId(user.getId());
			User userF = userDAO.getUserInfoByLoginId(SecurityUtils.getLoginId());
			userXh.setpId(userF.getId());
			userXh.setStatus(1);
			userXhDao.updateUserXhInfo(userXh);
		}
		
		return isUpdateSucc(count);
	}
	
	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean modifyUserHome(User user){
		// 更新该条用户信息,并返回是更新成功
		// 更新用户表loginId
		Integer count = userDAO.updateUserInfoByHome(user);
		return isUpdateSucc(count);
	}

	/**
	 * 删除用户信息
	 * 
	 * @param userId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean deleteUser(long userId) {
		// 根据id取得用户信息
		User user = userDAO.getUserInfo(userId);
		// 删除该条用户信息,并返回是否删除成功
		Integer count = userDAO.deleteUserInfoById(userId);
		// 删除该用户Id的资质图片信息,并返回是否删除成功
		userzztDAO.deleteUserZztInfoById(userId);
		// 删除该用户Id的用户角色信息,并返回是否删除成功
		userRoleDAO.deleteUserRoleInfoById(user.getLoginId());
		return isUpdateSucc(count);
	}

	/**
	 * 删除用户(多选框批量删除)
	 * 
	 * @param idArray
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean deleteUsers(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long userId : idArray) {
			// 根据id取得用户信息
			User user = userDAO.getUserInfo(userId);
			// 删除用户信息
			Integer count = userDAO.deleteUserInfoById(userId);
			// 删除该用户Id的资质图片信息,并返回是否删除成功
			userzztDAO.deleteUserZztInfoById(userId);
			// 删除该用户Id的用户角色信息,并返回是否删除成功
			userRoleDAO.deleteUserRoleInfoById(user.getLoginId());
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	/**
	 * 查询全部用户角色集合
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author ly
	 * @Date 2012-1-13
	 */
	public List<Role> getRoleList() {
		return roleDAO.findRoleInfoList();
	}
	
	/**
	 * 查询全部用户角色集合
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author ly
	 * @Date 2012-1-13
	 */
	public List<UserRole> getUserRoleList(String loginId) {
		return userRoleDAO.findUserRoleInfoList(loginId);
	}

	/**
	 * 添加用户角色信息
	 * 
	 * @param loginId
	 * @param deptId
	 * @param roleIdArray
	 * @return 是否成功
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createUserRole(String loginId, String deptId, long[] roleIdArray) {
		// 返回是否操作成功
		boolean returnValue = false;
		// 删除该用户Id下的所有角色信息
		Integer count = userRoleDAO.deleteUserRoleInfoById(loginId);
		// 某条删除成功即设置操作成功
		if (count != null && count > 0) {
			returnValue = true;
		}
		// 插入用户角色信息
		for (long roleId : roleIdArray) {
			UserRole userRole = new UserRole();
			// 设置用户Id
			userRole.setLoginId(loginId);
			// 设置角色Id
			userRole.setRoleId(roleId);
			Long pk = userRoleDAO.insertIntoUserRole(userRole);
			// 某条删除成功即设置操作成功
			if (pk != null && pk > 0) {
				returnValue = true;
			}
		}
		// 返回是否成功
		return returnValue;
	}

	/**
	 * 用户开启禁用状态处理
	 * 
	 * @param map
	 * @return 开启禁用状态页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public boolean updateUserStatus(User user) {
		Integer count = userDAO.updateUserInfoById(user);
		return isUpdateSucc(count);
	}

	/**
	 * 资质图列表
	 * 
	 * @param map
	 * @return 资质图列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public List<Userzzt> getUserzztList(Userzzt userzzt) {
		return userzztDAO.getUserzztList(userzzt);
	}

	/**
	 * 用户列表
	 * 
	 * @param map
	 * @return 用户列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public List<User> getUserList(User user) {
		return userDAO.getUserList(user);
	}

	/**
	 * 禁用用户信息(多选框批量禁用)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public boolean endUsers(long[] idArray) {
		// 返回是否操作成功,成功禁用一条数据即为操作成功
		boolean returnValue = false;
		// 循环禁用记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long userId : idArray) {
			// 根据id取得用户信息
			User user = userDAO.getUserInfo(userId);
			user.setStatus(3);
			Integer count = userDAO.updateUserInfoById(user);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 用户详细列表
	 * 
	 * @param map
	 * @return 用户详细列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public List<Userdetail> getUserdetailList(Userdetail userdetail) {
		return userdetailDAO.getUserdetailList(userdetail);		
	}

	/**
	 * 行业详细列表
	 * 
	 * @param map
	 * @return 行业详细列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public List<Sortdetail> findAllSortdetailInfo() {
		return sortdetailDAO.findAllSortdetailInfo();	
	}

	/**
	 * 推荐协会banner图接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public UsersPage getHomeUserInfoListByXh(UsersPage page) {
		// 取得用户信息集合(分页查询)
		List<User> userList = userDAO.findHomeUserInfoListByXh(page);
		page.setUserList(userList); // 用户信息集合
		return page;
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
	@Override
	public boolean modifyUserByTj(User user) {
		Integer count = userDAO.updateUserByTj(user);
		return isUpdateSucc(count);
	}

	/**
	 * 新入协会接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public UsersPage getHomeUserInfoListByXhNew(UsersPage page) {
		int count = userDAO.findHomeUserInfoCountByXhNew(page);

		if (count == 0) {
			return page;
		}
		// 取得用户信息集合(分页查询)
		page.setTotalRow(count); // 用户总数量
		List<User> userList = userDAO.findHomeUserInfoListByXhNew(page);
		page.setUserList(userList); // 用户信息集合
		return page;
	}

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean createUser(User user) {
		// 数据库新增一条用户记录,并返回是否插入成功
		Long pk = userDAO.insertIntoUser(user);
		return isInsertSucc(pk);
	}

	/**
	 * 分类页接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public UsersPage getHomeUserInfoListByFl(UsersPage page) {
		int count = userDAO.findHomeUserInfoCountByFl(page);

		if (count == 0) {
			return page;
		}
		// 取得用户信息集合(分页查询)
		page.setTotalRow(count); // 用户总数量
		List<User> userList = userDAO.findHomeUserInfoListByFl(page);
		page.setUserList(userList); // 用户信息集合
		return page;
	}
	
	/**
	 * 添加用户资质信息
	 * 
	 * @param userzzt
	 * @return 是否成功
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	public boolean createUserZzt(Userzzt userzzt){
		Long pk = userzztDAO.insertIntoUserZzt(userzzt);
		return isInsertSucc(pk);
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
	public boolean updateUserDeptIdByHome(User user) {
		Integer count = userDAO.updateUserDeptIdByHome(user);
		return isUpdateSucc(count);
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
	public boolean updateUserProductByHome(User user) {
		Integer count = userDAO.updateUserProductByHome(user);
		return isUpdateSucc(count);
	}
	
	/**
	 * 用户入会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean createUserXh(UserXh userXh){
		Long pk = userXhDao.insertIntoUserXh(userXh);
		return isInsertSucc(pk);
	}
	
	/**
	 * 用户退会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean deleteUserXh(UserXh userXh){
		Integer pk = userXhDao.deleteUserXhInfoById(userXh);
		return isUpdateSucc(pk);
	}
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public List<User> findUserInfoByXhId(Long id){
		List<User> userList = userDAO.getUserInfoByXhId(id);
		return userList;
	}
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public List<User> findUserInfoByXhVipId(Long id){
		List<User> userList = userDAO.getUserInfoByXhId(id);
		return userList;
	}
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public UserXh getUserXhInfo(UserXh userXh){
		return userXhDao.getUserXhInfo(userXh);
	}
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public List<User> getUserListAll(User user){
		List<User> userList = userDAO.getUserListAll(user);
		return userList;
	}
}
