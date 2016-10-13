package com.bcqsoft.sgoa.dao.optlog.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.optlog.OptLogDAO;
import com.bcqsoft.sgoa.dao.optlog.dataobject.OptLog;
import com.bcqsoft.sgoa.dao.optlog.dataobject.page.OptLogPage;

/**
 * 操作日志表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_OPT_LOG
 * </pre>
 */
@Repository
public class IbatisOptLogDAO extends BaseDAO implements OptLogDAO {

	/**
	 * 添加登录日志
	 * 
	 * @param optLog
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-1-22
	 */
	@Override
	public Long insertIntoOptLog(OptLog optLog) {
		return (Long) ibatis().insert("optlog.insertIntoOptLog", optLog);
	}
	
	/**
	 * 查找操作日志数量
	 * 
	 * @author ly
	 * @date 2011-12-26
	 * @return List&lt;page&gt;
	 */
	public Integer findOptLogInfoCount(OptLogPage page){
		return (Integer) ibatis().queryForObject("optlog.findOptLogInfoCount", page);
	}

	/**
	 * 查找操作日志列表
	 * 
	 * @author ly
	 * @date 2011-12-26
	 * @return List&lt;page&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<OptLog> findOptLogInfoList(OptLogPage page){
		return (List<OptLog>) ibatis().queryForList("optlog.findOptLogInfoList", page);
	}

}
