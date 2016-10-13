package com.bcqsoft.sgoa.dao.alert;

import java.util.List;

import com.bcqsoft.sgoa.dao.alert.dataobject.Alert;
import com.bcqsoft.sgoa.dao.alert.dataobject.AlertPage;

/**
 * 物资设备申领表数据库访问DAO接口
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public interface AlertDAO {
	/**
	 * 查找消息提醒列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Alerts&gt;
	 */
	Integer findAlertInfoCount(AlertPage page);
	/**
	 * 查找消息提醒列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Alerts&gt;
	 */
	List<Alert> findAlertInfoList(AlertPage page);
	/**
	 * 插入一条消息提醒信息至消息提醒表
	 * 
	 * @param approval
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Long insertIntoAlert(Alert alert);
	/**
	 * 根据消息提醒ID查询消息提醒表信息
	 * 
	 * @param approvalId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Alert getAlertInfo(long id);
	/**
	 * 根据消息提醒ID更新消息提醒表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateAlertInfoById(Alert alert);
	/**
	 * 根据消息提醒ID删除消息提醒表信息
	 * 
	 * @param approvalId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer deleteAlertInfoById(long id);
	
	/**
	 * 查找全部审批名称信息列表
	 * 
	 * @return 审批名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	List<Alert> findAllAlertInfo();
	
	/**
	 * 查找消息提醒列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Alerts&gt;
	 */
	Integer findAlertInfoForIndex(AlertPage page);
}
