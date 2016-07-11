package com.bcqsoft.xhlm.dao.user;

import java.util.List;

import org.springframework.ui.ModelMap;

import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.dao.user.dataobject.UsersPage;

/**
 * 用户表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: PSI_USER
 * </pre>
 */
public interface UserDAO {
	
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
	 * 根据用户ID更新用户表信息
	 * 
	 * @param user
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateUserInfoByHome(User user);
	
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
	 * 推荐协会banner图接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	List<User> findHomeUserInfoListByXh(UsersPage page);

	/**
	 * 用户推荐处理
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateUserByTj(User user);

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
	List<User> findHomeUserInfoListByXhNew(UsersPage page);

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
	Integer findHomeUserInfoCountByXhNew(UsersPage page);

	/**
	 * 用户推荐处理
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Long insertIntoUser(User user);

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
	Integer findHomeUserInfoCountByFl(UsersPage page);

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
	List<User> findHomeUserInfoListByFl(UsersPage page);
	
	/**
	 * 用户推荐处理
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateUserDeptIdByHome(User user);
	
	/**
	 * 用户推荐处理
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateUserProductByHome(User user);
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<User> getUserInfoByXhId(Long id);
	
	/**
	 * 查询当前企业所有入住的协会
	 * 
	 * @param map
	 * @return 推荐用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<User> getUserInfoByXhVipId(Long id);
	
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
