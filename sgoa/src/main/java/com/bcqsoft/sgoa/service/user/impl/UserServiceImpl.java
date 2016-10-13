package com.bcqsoft.sgoa.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.dept.DeptDAO;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.role.RoleDAO;
import com.bcqsoft.sgoa.dao.role.dataobject.Role;
import com.bcqsoft.sgoa.dao.user.UserDAO;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.user.dataobject.UsersPage;
import com.bcqsoft.sgoa.dao.userrole.UserRoleDAO;
import com.bcqsoft.sgoa.dao.userrole.dataobject.UserRole;
import com.bcqsoft.sgoa.service.user.UserService;

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
	 * 部门模块DAO实现类
	 */
	@Autowired
	private DeptDAO deptDAO;
	
	/**
	 * 部门列表ID
	 * 
	 */
	private List<Long> strList = null;

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createUser(User user) {
		// 返回是否操作成功
		boolean returnValue = false;
		UserRole userRole = new UserRole();
		// 设置用户Id
		userRole.setLoginId(user.getLoginId());
		// 设置分组Id
		userRole.setGrpoId(user.getPositionId());
		userRole.setGrpoType("2");
		Long pl = userRoleDAO.insertIntoUserRole(userRole);
		// 某条删除成功即设置操作成功
		if (pl != null && pl > 0) {
			returnValue = true;
		   }
		
		// 数据库新增一条用户记录,并返回是否插入成功
		Long pk = userDAO.insertIntoUser(user);
		if (pk != null && pk > 0) {
			returnValue = true;
		   }
		return returnValue;
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
	public boolean modifyUser(User user) {
		
		User userOld = userDAO.getUserInfo(user.getId());
		UserRole userRole = new UserRole();
		userRole.setLoginId(userOld.getLoginId());
		userRole.setOldGrpoId(userOld.getPositionId());
		userRole.setGrpoId(user.getPositionId());
		
		// 更新用户角色里的用户登录ID
		userRoleDAO.updateUserRole(userRole);
		
		// 更新用户表loginId
		Integer count = userDAO.updateUserInfoById(user);
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
		UserRole userRole=new UserRole();
		userRole.setLoginId(user.getLoginId());
		userRole.setGrpoType("2");
		// 删除该用户Id的用户角色信息,并返回是否删除成功
		userRoleDAO.deleteUserRoleInfoById(userRole);
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
			// 删除该用户Id的用户角色信息,并返回是否删除成功
			UserRole userRole=new UserRole();
			userRole.setLoginId(user.getLoginId());
			userRole.setGrpoType("2");
			// 删除该用户Id的用户角色信息,并返回是否删除成功
			userRoleDAO.deleteUserRoleInfoById(userRole);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
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
	 * 根据查询条件查找用户信息列表
	 * 
	 * @param id
	 * @return 用户分页对象
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public UsersPage getUserInfoList(UsersPage page) {
		if(page.getDeptId() == null){
			page.setDeptList(strList);
		}
		else{
			List<Dept> deptList = deptDAO.findAllDeptInfo();
			strList = new ArrayList<Long>();
			// 取得登录人部门下的所有部门ID
			getNodeString(deptList, page.getDeptId());
			page.setDeptList(strList);
		}

		
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
	 * 取得所有登录人下的所有部门节点
	 */
	private void getNodeString(List<Dept> deptList, Long unitId) {
		strList.add(unitId);
		for (Dept dept : deptList) {

			if (unitId.equals(dept.getUnitId())) {
				strList.add(dept.getId());
				getNodeString(deptList, dept.getId());
			}
		}
	}

	/**
	 * 查询全部用户集合
	 * 
	 * @return 用户列表
	 * 
	 * @Author zbq
	 * @Date 2011-8-17
	 */
	@Override
	public List<User> getUserList() {
		return userDAO.findAllUserList();
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
	 * 查询全部部门集合
	 * 
	 * @return 部门列表
	 * 
	 * @Author ly
	 * @Date 2012-1-13
	 */
	public List<Dept> getDeptList() {
		return deptDAO.findAllDeptInfo();
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
	public boolean createUserRole(String loginId, long deptId, long[] roleIdArray) {
		// 返回是否操作成功
		boolean returnValue = false;
		// 删除该用户Id下的所有角色信息
		// 插入用户角色信息
		for (long roleId : roleIdArray) {
			UserRole userRole = new UserRole();
			// 设置用户Id
			userRole.setLoginId(loginId);
			userRole.setGrpoType("2");
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
	 * 查询全部用户角色集合
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author ly
	 * @Date 2012-1-13
	 */
	public List<User> getUserListByPy(String userNamePy) {

		return userDAO.findUserListByPy(userNamePy);
	}

	@Override
	public List<Dept> findAllDeptInfo() {
		return deptDAO.findAllDeptInfo();
	}

	@Override
	public boolean modifyUserPassword(ModelMap map) {
		Integer count = userDAO.updateUserPassword(map);
		return isUpdateSucc(count);
	}

	@Override
	public boolean editSoUser(User user) {
		Integer count = userDAO.editSoUserInfoById(user);
		return isUpdateSucc(count);
	}
	
	/**
	 * 根据用户名称查询用户表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public User findLoginIdByUserName(String userName) {
		User user = userDAO.findLoginIdByUserName(userName);
		return user;
	}

	/**
	 * 局长秘书loginId
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public User getUserLoginIdjzms() {
		return userDAO.getUserLoginIdjzms();
	}

	/**
	 * 取得当前登录人LONGIN_ID的职务ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public User getUserLoginIdjyy(String loginIddq) {
		return userDAO.getUserLoginIdjyy(loginIddq);
	}

	/**
	 * 办公室主任loginId
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public User getUserLoginIdByPByD(User user) {
		return userDAO.getUserLoginIdByPByD(user);
	}

	/**
	 * 机要员loginId
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public User getUserLoginIdjyyd() {
		return userDAO.getUserLoginIdjyyd();
	}

	@Override
	public List<User> getUserListByPositionId(User user) {
		return userDAO.getUserListByPositionId(user);
	}
}
