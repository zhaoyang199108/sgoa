package com.bcqsoft.xhlm.dao.user.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.user.UserDAO;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.dao.user.dataobject.UsersPage;

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
	 * 根据用户ID更新用户表信息
	 * 
	 * @param user
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer updateUserInfoByHome(User user) {
		return (Integer) ibatis().update("user.updateUserInfoByHome", user);
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
	 * 用户列表
	 * 
	 * @param map
	 * @return 用户列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList(User user) {
		return (List<User>) ibatis().queryForList("user.getUserList",user);
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
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findHomeUserInfoListByXh(UsersPage page) {
		return (List<User>) ibatis().queryForList("user.findHomeUserInfoListByXh",page);
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
	public Integer updateUserByTj(User user) {
		return (Integer) ibatis().update("user.updateUserByTj", user);
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
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findHomeUserInfoListByXhNew(UsersPage page) {
		return (List<User>) ibatis().queryForList("user.findHomeUserInfoListByXhNew",page);
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
	public Integer findHomeUserInfoCountByXhNew(UsersPage page) {
		return (Integer) ibatis()
				.queryForObject("user.findHomeUserInfoCountByXhNew", page);
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
	public Long insertIntoUser(User user){
		return (Long) ibatis().insert("user.insertIntoUser", user);
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
	public Integer findHomeUserInfoCountByFl(UsersPage page) {
		return (Integer) ibatis()
				.queryForObject("user.findHomeUserInfoCountByFl", page);
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
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findHomeUserInfoListByFl(UsersPage page) {
		return (List<User>) ibatis().queryForList("user.findHomeUserInfoListByFl",page);
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
	public Integer updateUserDeptIdByHome(User user) {
		return (Integer) ibatis().update("user.updateUserDeptIdByHome", user);
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
	public Integer updateUserProductByHome(User user) {
		return (Integer) ibatis().update("user.updateUserProductByHome", user);
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
	@SuppressWarnings("unchecked")
	public List<User> getUserInfoByXhId(Long id) {
		return (List<User>) ibatis().queryForList("user.getUserInfoByXhId",id);
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
	@SuppressWarnings("unchecked")
	public List<User> getUserInfoByXhVipId(Long id) {
		return (List<User>) ibatis().queryForList("user.getUserInfoByXhVipId",id);
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
	@SuppressWarnings("unchecked")
	public List<User> getUserListAll(User user) {
		return (List<User>) ibatis().queryForList("user.getUserListAll",user);
	}
}
