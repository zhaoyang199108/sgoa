package com.bcqsoft.sgoa.dao.alert.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.alert.AlertDAO;
import com.bcqsoft.sgoa.dao.alert.dataobject.Alert;
import com.bcqsoft.sgoa.dao.alert.dataobject.AlertPage;

/**
 * 消息提醒表数据库访问DAO实现类
 * 
 * <pre>
 * 表: sgoa_TB_ALERT
 * </pre>
 */
@Repository
public class IbatisAlertDAO extends BaseDAO implements AlertDAO {

	/**
	 * 查找消息提醒列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Alerts&gt;
	 */
	public Integer findAlertInfoCount(AlertPage page) {
		return (Integer) ibatis().queryForObject(
				"alert.findAlertInfoCount", page);
	}

	/**
	 * 查找消息提醒列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Alerts&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Alert> findAlertInfoList(AlertPage page) {
		return (List<Alert>) ibatis().queryForList(
				"alert.findAlertInfoList", page);
	}

	/**
	 * 插入一条消息提醒信息至消息提醒表
	 * 
	 * @param alert
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Long insertIntoAlert(Alert alert) {
		return (Long) ibatis().insert("alert.insertIntoAlert", alert);
	}
	/**
	 * 根据消息提醒ID查询消息提醒表信息
	 * 
	 * @param alertId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Alert getAlertInfo(long id) {
		return (Alert) ibatis().queryForObject("alert.getAlertInfo", id);
	}

	/**
	 * 根据消息提醒ID更新消息提醒表信息
	 * 
	 * @param alert
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public Integer updateAlertInfoById(Alert alert) {
		return (Integer) ibatis().update("alert.updateAlertInfoById", alert);
	}


	/**
	 * 根据消息提醒ID删除消息提醒表信息
	 * 
	 * @param alertId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer deleteAlertInfoById(long id) {
		return (Integer) ibatis().update("alert.deleteAlertInfoById", id);
	}

	/**
	 * 查找全部审批名称信息列表
	 * 
	 * @return 审批名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Alert> findAllAlertInfo() {
		return (List<Alert>) ibatis().queryForList("alert.findAllAlertInfo");
	}

	/**
	 * 查找消息提醒列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Alerts&gt;
	 */
	public Integer findAlertInfoForIndex(AlertPage page) {
		return (Integer) ibatis().queryForObject("alert.findAlertInfoForIndex", page);
	}
}
