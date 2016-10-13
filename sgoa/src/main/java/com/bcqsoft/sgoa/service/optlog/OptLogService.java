package com.bcqsoft.sgoa.service.optlog;

import com.bcqsoft.sgoa.dao.optlog.dataobject.OptLog;
import com.bcqsoft.sgoa.dao.optlog.dataobject.page.OptLogPage;

/**
 * 登录日志模块业务逻辑类接口
 */
public interface OptLogService {

	
	/**
	 * 添加登录日志
	 * 
	 * @param optLog
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-1-22
	 */
	boolean creatOptLogInfo(OptLog optLog);

	/**
	 * 取得有效的登录日志列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	OptLogPage findOptLogList(OptLogPage optLogPage);

	
}
