package com.bcqsoft.sgoa.dao.userkey.ibatis;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.userkey.UserKeyDAO;
import com.bcqsoft.sgoa.dao.userkey.dataobject.UserKey;

/**
 * 用户表数据库访问层Ibatis实现类
 * 
 * <pre>
 * TABLE: USERS
 * </pre>
 */
@Repository
public class IbatisUserKeyDAO extends BaseDAO implements UserKeyDAO {

	/**
	 * 查找全部用户KEY
	 * 
	 * @return 用户KEY列表
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	public UserKey findUserKeyInfo(String serverIaguid) {
		return (UserKey) ibatis().queryForObject("userKey.findUserKeyInfo", serverIaguid);
	}

	/**
	 * 插入一条用户KEY信息至用户KEY表(SCOA_TB_USER_KEY)
	 * 
	 * @param userRole
	 * @return 插入记录的ID
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	public Long insertIntoUserKey(UserKey userKey) {
		return (Long) ibatis().insert("userKey.insertIntoUserKey", userKey);
	}

	/**
	 * 根据用户ID删除用户KEY信息
	 * 
	 * @param loginId
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	public Integer deleteUserKeyInfoById(UserKey userKey) {
		return (Integer) ibatis().delete("user.deleteUserKeyInfoById", userKey);
	}
	
	/**
	 * 根据用户ID更新用户KEY信息
	 * 
	 * @param userRole
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	public Integer updateUserKey(UserKey userKey) {
		return (Integer) ibatis().update("userKey.updateUserKey", userKey);
	}
}
