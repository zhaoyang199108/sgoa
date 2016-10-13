package com.bcqsoft.sgoa.service.optlog.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.optlog.OptLogDAO;
import com.bcqsoft.sgoa.dao.optlog.dataobject.OptLog;
import com.bcqsoft.sgoa.dao.optlog.dataobject.page.OptLogPage;
import com.bcqsoft.sgoa.service.optlog.OptLogService;

/**
 *登录日志模块业务逻辑类实现类
 */
@Service
public class OptLogServiceImpl extends BaseService implements OptLogService {

	/**
	 * 登录日志表数据库访问DAO接口
	 */
	@Autowired
	private OptLogDAO optLogDAO;

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
	public boolean creatOptLogInfo(OptLog optLog) {
		Long pk = optLogDAO.insertIntoOptLog(optLog);
		return isInsertSucc(pk);
	}

	/**
	 * 根据查询条件查找登录日志信息列表
	 * 
	 * @param page
	 * @return 操作日志分页对象
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-26
	 */
	@Override
	public OptLogPage findOptLogList(OptLogPage page) {
		int count = optLogDAO.findOptLogInfoCount(page);
		if (count == 0) {
			return page;
		}
		// 取得操作日志信息集合(分页查询)
		List<OptLog> optLogList = optLogDAO.findOptLogInfoList(page);
		page.setTotalRow(count); // 操作日志总数量
		page.setOptLogList(optLogList); // 操作日志信息集合
		return page;
	}
}
