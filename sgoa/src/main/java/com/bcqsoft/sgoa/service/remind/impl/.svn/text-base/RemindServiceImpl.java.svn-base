package com.bcqsoft.sgoa.service.remind.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.remind.dataobject.RemindPage;
import com.bcqsoft.sgoa.service.remind.RemindService;

/**
 * 消息中心表模块业务逻辑实现类
 */
@Service
public class RemindServiceImpl extends BaseService implements RemindService {
	/**
	 * 消息中心模块DAO实现类
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 根据查询条件查找消息中心信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public RemindPage getRemindList(RemindPage page) {
		int count = remindDAO.findRemindInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得消息中心信息集合(分页查询)
		List<Remind> remindList = remindDAO.findRemindInfoList(page);

		page.setTotalRow(count); // 消息中心总数量
		page.setRemindList(remindList); // 消息中心信息集合
		return page;
	}

	/**
	 * 消息中心详细信息
	 * 
	 * @param remind
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public Remind getRemindInfo(long id) {
		Remind remind = remindDAO.getRemindInfo(id);
		return remind;
	}

	/**
	 * 修改消息中心信息
	 * 
	 * @param remind
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean editRemindInfo(Remind remind) {
		Integer count = remindDAO.updateRemindInfoById(remind);
		return isUpdateSucc(count);
	}

	/**
	 * 删除消息中心信息
	 * 
	 * @param remindId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean deleteRemind(long id) {
		// 根据id取得用户信息
		Integer count = remindDAO.deleteRemindInfoById(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除消息中心信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean deleteReminds(long[] longArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除消息中心记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long remindId : longArray) {

			// 删除消息中心信息
			Integer count = remindDAO.deleteRemindInfoById(remindId);

			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}
}
