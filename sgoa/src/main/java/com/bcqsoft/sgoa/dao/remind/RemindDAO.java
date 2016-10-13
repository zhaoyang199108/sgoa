package com.bcqsoft.sgoa.dao.remind;

import java.util.List;

import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.remind.dataobject.RemindPage;

/**
 * 消息中心表数据库访问DAO接口
 * 
 * <pre>
 * 表:SCOA_TB_REMIND
 * </pre>
 */
public interface RemindDAO {
	/**
	 * 查找消息提醒列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Reminds&gt;
	 */
	Integer findRemindInfoCount(RemindPage page);
	
	/**
	 * 查找消息提醒列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Reminds&gt;
	 */
	List<Remind> findRemindInfoList(RemindPage page);
	
	/**
	 * 插入一条消息提醒信息至消息提醒表
	 * 
	 * @param approval
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Long insertIntoRemind(Remind remind);
	
	/**
	 * 根据消息提醒ID查询消息提醒表信息
	 * 
	 * @param approvalId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Remind getRemindInfo(long id);
	
	/**
	 * 根据消息提醒ID更新消息提醒表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateRemindInfoById(Remind remind);
	
	/**
	 * 根据消息提醒ID删除消息提醒表信息
	 * 
	 * @param approvalId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer deleteRemindInfoById(long id);
	
	/**
	 * 查找全部审批名称信息列表
	 * 
	 * @return 审批名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	List<Remind> findAllRemindInfo();
	
	/**
	 * 查找消息提醒列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Reminds&gt;
	 */
	Integer findRemindInfoForIndex(RemindPage page);
	
	/**
	 * 根据消息提醒ID更新消息提醒表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateRemindInfoByLoginId(Remind remind);
	
	/**
	 * 根据模块名称更新消息提醒表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateRemindInfoByModeName(Remind remind);
}
