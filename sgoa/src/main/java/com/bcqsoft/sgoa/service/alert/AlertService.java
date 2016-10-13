package com.bcqsoft.sgoa.service.alert;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.alert.dataobject.Alert;
import com.bcqsoft.sgoa.dao.alert.dataobject.AlertPage;

/**
 * 消息提醒表模块业务逻辑类接口
 */
@Service
public interface AlertService {
	/**
	 * 根据查询条件查找消息提醒信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	AlertPage getAlertList(AlertPage page);

	/**
	 * 添加消息提醒信息
	 * 
	 * @param approval
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean createAlert(Alert alert);

	/**
	 * 消息提醒详细信息
	 * 
	 * @param approval
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	Alert getAlertInfo(long id);

	/**
	 * 修改消息提醒信息
	 * 
	 * @param approval
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean editAlertInfo(Alert alert);

	/**
	 * 删除消息提醒信息
	 * 
	 * @param approvalId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteAlert(long id);

	/**
	 * 删除消息提醒信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteAlerts(long[] longArray);
}
