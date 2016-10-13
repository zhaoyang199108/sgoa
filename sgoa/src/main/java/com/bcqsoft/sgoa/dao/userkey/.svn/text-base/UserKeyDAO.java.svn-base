package com.bcqsoft.sgoa.dao.userkey;

import com.bcqsoft.sgoa.dao.userkey.dataobject.UserKey;

/**
 * 人员角色关系表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_USER_KEY
 * </pre>
 */
public interface UserKeyDAO {

	/**
	 * 查找全部用户KEY
	 * 
	 * @return 用户KEY列表
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	UserKey findUserKeyInfo(String serverIaguid);

	/**
	 * 插入一条用户KEY信息至用户KEY表(SCOA_TB_USER_KEY)
	 * 
	 * @param userRole
	 * @return 插入记录的ID
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	Long insertIntoUserKey(UserKey userKey);

	/**
	 * 根据用户ID删除用户KEY信息
	 * 
	 * @param loginId
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	Integer deleteUserKeyInfoById(UserKey userKey);
	
	/**
	 * 根据用户ID更新用户KEY信息
	 * 
	 * @param userRole
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	Integer updateUserKey(UserKey userKey);
}
