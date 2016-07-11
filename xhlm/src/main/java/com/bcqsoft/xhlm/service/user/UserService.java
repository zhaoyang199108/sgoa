package com.bcqsoft.xhlm.service.user;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.bcqsoft.xhlm.dao.role.dataobject.Role;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.Sortdetail;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.dao.user.dataobject.UsersPage;
import com.bcqsoft.xhlm.dao.userdetail.dataobject.Userdetail;
import com.bcqsoft.xhlm.dao.userrole.dataobject.UserRole;
import com.bcqsoft.xhlm.dao.userxh.dataobject.UserXh;
import com.bcqsoft.xhlm.dao.userzzt.dataobject.Userzzt;

/**
 * 仓库模块业务逻辑类接口
 */
public interface UserService {
	
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
	 * 修改用户密码
	 * 
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean modifyUserPassword(ModelMap map);
	
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
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean modifyUserHome(User user);
	
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
	 * 查询全部用户角色集合
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author ly
	 * @Date 2012-1-13
	 */
	List<Role> getRoleList();
	
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
	boolean createUserRole(String loginId, String deptId, long[] roleIdArray);

	/**
	 * 用户开启禁用状态处理
	 * 
	 * @param map
	 * @return 开启禁用状态页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean updateUserStatus(User user);

	/**
	 * 资质图列表
	 * 
	 * @param map
	 * @return 资质图列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<Userzzt> getUserzztList(Userzzt userzzt);

	/**
	 * 用户列表
	 * 
	 * @param map
	 * @return 用户列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<User> getUserList(User user);
	
	/**
	 * 禁用用户信息(多选框批量禁用)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean endUsers(long[] idArray);

	/**
	 * 用户详细列表
	 * 
	 * @param map
	 * @return 用户详细列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<Userdetail> getUserdetailList(Userdetail userdetail);

	/**
	 * 行业详细列表
	 * 
	 * @param map
	 * @return 行业详细列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<Sortdetail> findAllSortdetailInfo();

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
	UsersPage getHomeUserInfoListByXh(UsersPage page);
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<User> findUserInfoByXhVipId(Long id);

	/**
	 * 用户推荐处理
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean modifyUserByTj(User user);

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
	UsersPage getHomeUserInfoListByXhNew(UsersPage page);
	
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
	 * 分类页接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	UsersPage getHomeUserInfoListByFl(UsersPage page);
	
	/**
	 * 添加用户资质信息
	 * 
	 * @param userzzt
	 * @return 是否成功
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	boolean createUserZzt(Userzzt userzzt);
	
	/**
	 * 用户推荐处理
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean updateUserDeptIdByHome(User user);
	
	/**
	 * 用户推荐处理
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean updateUserProductByHome(User user);
	
	/**
	 * 用户入会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean createUserXh(UserXh userXh);
	
	/**
	 * 用户退会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteUserXh(UserXh userXh);
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<User> findUserInfoByXhId(Long id);
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	UserXh getUserXhInfo(UserXh userXh);
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<User> getUserListAll(User user);
}
