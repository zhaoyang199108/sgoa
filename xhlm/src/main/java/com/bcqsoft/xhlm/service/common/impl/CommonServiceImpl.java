package com.bcqsoft.xhlm.service.common.impl;

import static com.bcqsoft.xhlm.core.security.SecurityUtils.getLoginId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.user.UserDAO;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.service.common.CommonService;

/**
 * 共通业务模块业务逻辑类实现类
 */
@Service
public class CommonServiceImpl extends BaseService implements CommonService {

	/**
	 * 人员表数据库访问DAO接口
	 */
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 取得当前用户信息
	 * 
	 * @return 当前用户信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	public User getCurrentUserInfo() {
		return userDAO.getUserInfoByLoginId(getLoginId());
	}

}
