package com.bcqsoft.sgoa.service.userkey.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.userkey.UserKeyDAO;
import com.bcqsoft.sgoa.dao.userkey.dataobject.UserKey;
import com.bcqsoft.sgoa.service.userkey.UserKeyService;

/**
 * 用户Key模块业务逻辑实现类
 */
@Service
public class UserKeyServiceImpl extends BaseService implements UserKeyService {

	/**
	 * 用户key模块DAO实现类
	 */
	@Autowired
	private UserKeyDAO userKeyDAO;
	
	/**
	 * 查找全部用户KEY
	 * 
	 * @return 用户KEY列表
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	public UserKey findUserKeyInfo(String serverIaguid){
		return userKeyDAO.findUserKeyInfo(serverIaguid);
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
	public boolean createUserKey(UserKey userKey){
		// 数据库新增一条模块记录,并返回是否插入成功
		Long pk = userKeyDAO.insertIntoUserKey(userKey);
		return isInsertSucc(pk);
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
	public boolean deleteUserKeyInfoById(UserKey userKey){
		// 根据id取得用户信息
		Integer count = userKeyDAO.deleteUserKeyInfoById(userKey);
		return isUpdateSucc(count);
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
	public boolean editUserKey(UserKey userKey) {
		Integer count = userKeyDAO.updateUserKey(userKey);
		return isUpdateSucc(count);
	}
}
