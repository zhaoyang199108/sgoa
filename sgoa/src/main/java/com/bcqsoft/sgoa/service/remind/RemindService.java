package com.bcqsoft.sgoa.service.remind;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.remind.dataobject.RemindPage;

/**
 * 消息中心表模块业务逻辑类接口
 */
@Service
public interface RemindService {
	
	/**
	 * 根据查询条件查找消息中心信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-05-07
	 */
	RemindPage getRemindList(RemindPage page);

	/**
	 * 消息中心详细信息
	 * 
	 * @param approval
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-05-07
	 */
	Remind getRemindInfo(long id);

	/**
	 * 修改消息中心信息
	 * 
	 * @param approval
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean editRemindInfo(Remind remind);

	/**
	 * 删除消息中心信息
	 * 
	 * @param approvalId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteRemind(long id);

	/**
	 * 删除消息中心信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteReminds(long[] longArray);
}
