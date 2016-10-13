package com.bcqsoft.sgoa.service.user;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.role.dataobject.Role;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.user.dataobject.UsersPage;
import com.bcqsoft.sgoa.dao.userrole.dataobject.UserRole;

/**
 * 仓库模块业务逻辑类接口
 */
public interface UserService {

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean createUser(User user);

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean modifyUser(User user);

	/**
	 * 删除用户信息
	 * 
	 * @param userId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteUser(long userId);

	/**
	 * 删除用户信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteUsers(long[] idArray);

	/**
	 * 根据ID查找某一用户的信息
	 * 
	 * @param userId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	User getUserInfo(long userId);

	/**
	 * 根据用户LoginID查询用户表信息
	 * 
	 * @param userId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	User getUserInfoByLoginId(String loginId);

	/**
	 * 根据查询条件查找用户信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	UsersPage getUserInfoList(UsersPage page);

	/**
	 * 查询全部用户集合
	 * 
	 * @return 用户列表
	 * 
	 * @Author zbq
	 * @Date 2011-8-17
	 */
	List<User> getUserList();

	/**
	 * 查询全部用户角色集合
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author ly
	 * @Date 2012-1-13
	 */
	List<Role> getRoleList();

	/**
	 * 查询全部部门集合
	 * 
	 * @return 部门列表
	 * 
	 * @Author ly
	 * @Date 2012-1-13
	 */
	List<Dept> getDeptList();

	/**
	 * 查询全部用户角色集合
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author ly
	 * @Date 2012-1-13
	 */
	List<UserRole> getUserRoleList(String loginId);

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
	boolean createUserRole(String loginId, long deptId, long[] roleIdArray);

	/**
	 * 根据拼音查询全部符合条件用户角色集合
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author ly
	 * @Date 2012-1-13
	 */
	List<User> getUserListByPy(String userNamePy);

	List<Dept> findAllDeptInfo();

	boolean modifyUserPassword(ModelMap map);

	/**
	 * 修改用户排序号信息
	 * 
	 * @param user
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean editSoUser(User user);
	
	/**
	 * 根据用户名称查询用户表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	User findLoginIdByUserName(String userName);

	
	/**
	 * 局长秘书loginId
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	User getUserLoginIdjzms();

	
	/**
	 * 取得当前登录人LONGIN_ID的职务ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	User getUserLoginIdjyy(String loginIddq);

	/**
	 * 办公室主任loginId
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	User getUserLoginIdByPByD(User user);

	/**
	 * 机要员loginId
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	User getUserLoginIdjyyd();

	List<User> getUserListByPositionId(User user);
}
