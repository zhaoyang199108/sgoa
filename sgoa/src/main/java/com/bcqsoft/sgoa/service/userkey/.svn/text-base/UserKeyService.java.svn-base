package com.bcqsoft.sgoa.service.userkey;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.userkey.dataobject.UserKey;

/**
 * 签章模块设备申领表模块业务逻辑类接口
 */
@Service
public interface UserKeyService {
	
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
	boolean createUserKey(UserKey userKey);

	/**
	 * 根据用户ID删除用户KEY信息
	 * 
	 * @param loginId
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	boolean deleteUserKeyInfoById(UserKey userKey);
	
	/**
	 * 根据用户ID更新用户KEY信息
	 * 
	 * @param userRole
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	boolean editUserKey(UserKey userKey);
}
