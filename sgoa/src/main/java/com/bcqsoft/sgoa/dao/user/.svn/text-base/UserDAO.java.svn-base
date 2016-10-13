package com.bcqsoft.sgoa.dao.user;

import java.util.List;
import java.util.Map;

import org.springframework.ui.ModelMap;

import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.user.dataobject.UsersPage;

/**
 * 用户表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: PSI_USER
 * </pre>
 */
public interface UserDAO {

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
	List<User> findUsersInfoForChoose(Map<String, Object> data);
	
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
	List<User> findAppUsersInfoForChoose(Map<String, Object> data);

	/**
	 * 查找用户列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Users&gt;
	 */
	Integer findUserInfoCount(UsersPage page);

	/**
	 * 查找用户列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Users&gt;
	 */
	List<User> findUserInfoList(UsersPage page);

	/**
	 * 插入一条用户信息至用户表(PSI_USER)
	 * 
	 * @param user
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Long insertIntoUser(User user);

	/**
	 * 根据用户ID更新用户表信息
	 * 
	 * @param user
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateUserInfoById(User user);

	/**
	 * 根据用户ID删除用户表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer deleteUserInfoById(Long userId);

	/**
	 * 根据用户ID查询用户表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	User getUserInfo(long userId);

	/**
	 * 根据用户LoginID查询用户表信息
	 * 
	 * @param userId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	User getUserInfoByLoginId(String loginId);

	/**
	 * 查询全部用户集合
	 * 
	 * @return 用户列表
	 * 
	 * @Author zbq
	 * @Date 2011-8-17
	 */
	List<User> findAllUserList();

	/**
	 * 根据拼音查询符合条件全部用户集合
	 * 
	 * @return 用户列表
	 * 
	 * @Author zbq
	 * @Date 2011-8-17
	 */
	List<User> findUserListByPy(String userNamePy);

	/**
	 * 根据条件查询符合条件全部用户集合
	 * 
	 * @return 用户列表
	 * 
	 * @Author zbq
	 * @Date 2011-8-17
	 */
	List<User> findUsersByRfile(Map<String, Object> data);
	/**
	 * 根据条件查询符合条件全部用户集合
	 * 
	 * @return 用户列表
	 * 
	 * @Author zbq
	 * @Date 2011-8-17
	 */
	List<User> findUsersByMsg(Map<String, Object> data);

	/**
	 * 修改用户密码
	 * 
	 * @param user
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-05-09
	 */
	Integer updateUserPassword(ModelMap map);

	/**
	 * 删除用户根据部门ID
	 * 
	 * @param user
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-05-09
	 */
	Integer deleteUserInfoByIds(Map<String, Object> map);

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
	List<User> findUsersInfoForDeptId(Map<String, Object> data);

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
	List<User> findSchedulerUserInfoList(long positionId);
	
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
	List<User> findUserInfoListByDeptId(long deptId);

	Integer editSoUserInfoById(User user);
	
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
	List<User> getUserListByDP(User user);

	List<User> getUserListByPositionId(User user);
}
