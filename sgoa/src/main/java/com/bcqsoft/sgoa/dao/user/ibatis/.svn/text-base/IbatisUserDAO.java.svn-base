package com.bcqsoft.sgoa.dao.user.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.user.UserDAO;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.user.dataobject.UsersPage;

/**
 * 用户表数据库访问层Ibatis实现类
 * 
 * <pre>
 * TABLE: USERS
 * </pre>
 */
@Repository
public class IbatisUserDAO extends BaseDAO implements UserDAO {

	/**
	 * 查找某一部门下的全部人员
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUsersInfoForChoose(Map<String, Object> data) {
		return (List<User>) ibatis().queryForList(
				"user.findUsersInfoForChoose", data);
	}
	
	/**
	 * 查找某一部门下的全部人员
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAppUsersInfoForChoose(Map<String, Object> data) {
		return (List<User>) ibatis().queryForList(
				"user.findAppUsersInfoForChoose", data);
	}

	/**
	 * 查找用户列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Users&gt;
	 */
	public Integer findUserInfoCount(UsersPage page) {
		return (Integer) ibatis()
				.queryForObject("user.findUserInfoCount", page);
	}

	/**
	 * 查找用户列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Users&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUserInfoList(UsersPage page) {
		return (List<User>) ibatis()
				.queryForList("user.findUserInfoList", page);
	}

	/**
	 * 插入一条用户信息至用户表(PSI_USER)
	 * 
	 * @param user
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Long insertIntoUser(User user) {
		return (Long) ibatis().insert("user.insertIntoUser", user);
	}

	/**
	 * 根据用户ID更新用户表信息
	 * 
	 * @param user
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer updateUserInfoById(User user) {
		return (Integer) ibatis().update("user.updateUserInfoById", user);
	}

	/**
	 * 根据用户ID删除用户表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer deleteUserInfoById(Long userId) {
		return (Integer) ibatis().update("user.deleteUserInfoById", userId);
	}

	/**
	 * 根据用户ID查询用户表信息
	 * 
	 * @param userId
	 * @return User
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public User getUserInfo(long userId) {
		return (User) ibatis().queryForObject("user.getUserInfo", userId);
	}

	/**
	 * 根据用户LoginID查询用户表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public User getUserInfoByLoginId(String loginId) {
		return (User) ibatis().queryForObject("user.getUserInfoByLoginId",
				loginId);
	}

	/**
	 * 查询全部用户集合
	 * 
	 * @return 用户列表
	 * 
	 * @Author zbq
	 * @Date 2011-8-17
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUserList() {
		return (List<User>) ibatis().queryForList("user.findAllUserList");
	}

	/**
	 * 根据用户ID查询用户表信息
	 * 
	 * @param userId
	 * @return User
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUserListByPy(String userNamePy) {

		return (List<User>) ibatis().queryForList("user.findUserListByPy",
				userNamePy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsersByRfile(Map<String, Object> data) {
		return (List<User>) ibatis().queryForList("user.findUsersByRfile", data);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsersByMsg(Map<String, Object> data) {
		return (List<User>) ibatis().queryForList("user.findUsersByMsg", data);
	}


	/**
	 * 根据用户ID更新用户表信息
	 * 
	 * @param user
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer updateUserPassword(ModelMap map) {
		return (Integer) ibatis().update("user.updateUserPassword", map);
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-05-09
	 */
	@Override
	public Integer deleteUserInfoByIds(Map<String, Object> data) {
		return (Integer) ibatis().update("user.deleteUserInfoByIds", data);
	}
	/**
	 * 查找某一部门下的全部人员
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUsersInfoForDeptId(Map<String, Object> data) {
		return (List<User>) ibatis().queryForList("user.findUsersInfoForDeptId", data);
	}
	
	/**
	 * 查找某一职责所负责的人员信息
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<User> findSchedulerUserInfoList(long positionId){
		return (List<User>) ibatis().queryForList("user.findSchedulerUserInfoList", positionId);
	}
	
	/**
	 * 查找某一职责所负责的人员信息
	 * 
	 * @param deptId
	 *            部门ID
	 * @return 人员列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUserInfoListByDeptId(long deptId){
		return (List<User>) ibatis().queryForList("user.findUserInfoListByDeptId", deptId);
	}

	@Override
	public Integer editSoUserInfoById(User user) {
		return (Integer) ibatis().update("user.editSoUserInfoById", user);
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
		return (User) ibatis().queryForObject("user.findLoginIdByUserName",
				userName);
	}

	/**
	 * 局长秘书loginId
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public User getUserLoginIdjzms() {
		return (User) ibatis().queryForObject("user.getUserLoginIdjzms");
	}

	/**
	 * 取得当前登录人LONGIN_ID的职务ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public User getUserLoginIdjyy(String loginIddq) {
		return (User) ibatis().queryForObject("user.getUserLoginIdjyy",loginIddq);
	}

	/**
	 * 办公室主任loginId
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public User getUserLoginIdByPByD(User user) {
		return (User) ibatis().queryForObject("user.getUserLoginIdByPByD",user);
	}

	/**
	 * 机要员loginId
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public User getUserLoginIdjyyd() {
		return (User) ibatis().queryForObject("user.getUserLoginIdjyyd");
	}

	/**
	 * 预选
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserListByDP(User user) {
		return (List<User>) ibatis().queryForList("user.getUserListByDP",user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserListByPositionId(User user) {
		return (List<User>) ibatis().queryForList("user.getUserListByPositionId",user);
	}
}
