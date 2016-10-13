package com.bcqsoft.sgoa.service.alert.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.alert.AlertDAO;
import com.bcqsoft.sgoa.dao.alert.dataobject.Alert;
import com.bcqsoft.sgoa.dao.alert.dataobject.AlertPage;
import com.bcqsoft.sgoa.service.alert.AlertService;

/**
 * 消息提醒表模块业务逻辑实现类
 */
@Service
public class AlertServiceImpl extends BaseService implements AlertService {
	/**
	 * 消息提醒模块DAO实现类
	 */
	@Autowired
	private AlertDAO alertDAO;

	/**
	 * 根据查询条件查找消息提醒信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public AlertPage getAlertList(AlertPage page) {
		int count = alertDAO.findAlertInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得消息提醒信息集合(分页查询)
		List<Alert> alertList = alertDAO.findAlertInfoList(page);

		page.setTotalRow(count); // 消息提醒总数量
		page.setAlertList(alertList); // 消息提醒信息集合
		return page;
	}

	/**
	 * 添加消息提醒信息
	 * 
	 * @param alert
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createAlert(Alert alert) {
		// 数据库新增一条消息提醒记录,并返回是否插入成功
		Long pk = alertDAO.insertIntoAlert(alert);
		return isInsertSucc(pk);
	}

	/**
	 * 消息提醒详细信息
	 * 
	 * @param alert
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public Alert getAlertInfo(long id) {
		Alert alert = alertDAO.getAlertInfo(id);
		return alert;
	}

	/**
	 * 修改消息提醒信息
	 * 
	 * @param alert
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean editAlertInfo(Alert alert) {
		Integer count = alertDAO.updateAlertInfoById(alert);
		return isUpdateSucc(count);
	}

	/**
	 * 删除消息提醒信息
	 * 
	 * @param alertId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean deleteAlert(long id) {
		// 根据id取得用户信息
		Integer count = alertDAO.deleteAlertInfoById(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除消息提醒信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean deleteAlerts(long[] longArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long alertId : longArray) {

			// 删除用户信息
			Integer count = alertDAO.deleteAlertInfoById(alertId);

			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}
}
