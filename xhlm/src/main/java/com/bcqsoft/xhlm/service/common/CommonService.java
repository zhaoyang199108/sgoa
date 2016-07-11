package com.bcqsoft.xhlm.service.common;

import com.bcqsoft.xhlm.dao.user.dataobject.User;

/**
 * 共通业务模块业务逻辑接口
 */
public interface CommonService {

	/**
	 * 取得当前用户信息
	 * 
	 * @return 当前用户信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	User getCurrentUserInfo();
}
