package com.bcqsoft.sgoa.dao.optlog;

import java.util.List;

import com.bcqsoft.sgoa.dao.optlog.dataobject.OptLog;
import com.bcqsoft.sgoa.dao.optlog.dataobject.page.OptLogPage;


/**
 * 操作日志表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_OPT_LOG
 * </pre>
 */
public interface OptLogDAO {

	/**
	 * 添加登录日志
	 * 
	 * @param optLog
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-1-22
	 */
	Long insertIntoOptLog(OptLog optLog);

	/**
	 * 查找操作日志数量
	 * 
	 * @author ly
	 * @date 2011-12-26
	 * @return List&lt;page&gt;
	 */
	Integer findOptLogInfoCount(OptLogPage page);

	/**
	 * 查找操作日志列表
	 * 
	 * @author ly
	 * @date 2011-12-26
	 * @return List&lt;page&gt;
	 */
	List<OptLog> findOptLogInfoList(OptLogPage page);


	
}
