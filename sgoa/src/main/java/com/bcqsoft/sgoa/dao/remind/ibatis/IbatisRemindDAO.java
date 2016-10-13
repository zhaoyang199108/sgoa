package com.bcqsoft.sgoa.dao.remind.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.remind.dataobject.RemindPage;

/**
 * 消息中心表数据库访问DAO实现类
 * 
 * <pre>
 * 表: SCOA_TB_REMIND
 * </pre>
 */
@Repository
public class IbatisRemindDAO extends BaseDAO implements RemindDAO {

	/**
	 * 查找消息中心列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Reminds&gt;
	 */
	public Integer findRemindInfoCount(RemindPage page) {
		return (Integer) ibatis().queryForObject(
				"remind.findRemindInfoCount", page);
	}

	/**
	 * 查找消息中心列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Reminds&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Remind> findRemindInfoList(RemindPage page) {
		return (List<Remind>) ibatis().queryForList(
				"remind.findRemindInfoList", page);
	}

	/**
	 * 插入一条消息中心信息至消息中心表
	 * 
	 * @param remind
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Long insertIntoRemind(Remind remind) {
		return (Long) ibatis().insert("remind.insertIntoRemind", remind);
	}
	/**
	 * 根据消息中心ID查询消息中心表信息
	 * 
	 * @param remindId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Remind getRemindInfo(long id) {
		return (Remind) ibatis().queryForObject("remind.getRemindInfo", id);
	}

	/**
	 * 根据消息中心ID更新消息中心表信息
	 * 
	 * @param remind
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public Integer updateRemindInfoById(Remind remind) {
		return (Integer) ibatis().update("remind.updateRemindInfoById", remind);
	}


	/**
	 * 根据消息中心ID删除消息中心表信息
	 * 
	 * @param remindId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer deleteRemindInfoById(long id) {
		return (Integer) ibatis().update("remind.deleteRemindInfoById", id);
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
	public List<Remind> findAllRemindInfo() {
		return (List<Remind>) ibatis().queryForList("remind.findAllRemindInfo");
	}

	/**
	 * 查找消息中心列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Reminds&gt;
	 */
	public Integer findRemindInfoForIndex(RemindPage page) {
		return (Integer) ibatis().queryForObject("remind.findRemindInfoForIndex", page);
	}
	
	/**
	 * 根据消息提醒ID更新消息提醒表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer updateRemindInfoByLoginId(Remind remind) {
		return (Integer) ibatis().update("remind.updateRemindInfoByLoginId", remind);
	}
	
	/**
	 * 根据模块名称更新消息提醒表信息
	 * 
	 * @param approval
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer updateRemindInfoByModeName(Remind remind) {
		return (Integer) ibatis().update("remind.updateRemindInfoByModeName", remind);
	}
}
