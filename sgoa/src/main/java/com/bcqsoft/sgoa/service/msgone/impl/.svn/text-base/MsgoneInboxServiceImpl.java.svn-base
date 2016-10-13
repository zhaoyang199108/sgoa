package com.bcqsoft.sgoa.service.msgone.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.msgoneinbox.MsgoneInboxDAO;
import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInbox;
import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInboxPage;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.service.msgone.MsgoneInboxService;

/**
 * 收件箱模块业务逻辑实现类
 */
@Service
public class MsgoneInboxServiceImpl extends BaseService implements MsgoneInboxService {
	@Autowired
	private MsgoneInboxDAO msgoneInboxDAO;
	
	/**
	 * 消息中心模块DAO实现类
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 根据查询条件查找收件箱信息列表
	 * 
	 * @param id
	 * @return 收件箱分页对象
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	@Override
	public MsgoneInboxPage getMsgoneInboxListByPage(MsgoneInboxPage page) {
		int count = msgoneInboxDAO.findMsgoneInboxInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得收件箱集合(分页查询)
		List<MsgoneInbox> msgoneInboxList = msgoneInboxDAO.findMsgoneInboxInfoList(page);

		page.setTotalRow(count); // 收件箱总数量
		page.setMsgoneInboxList(msgoneInboxList); // 收件箱信息集合
		return page;
	}

	/**
	 * 删除工作动态(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author sbq
	 * @Date 2011-12-26
	 */
	public boolean deleteMsgoneInboxs(long[] longArray) {
		boolean returnValue = false;
		// 循环删除收件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = deleteMsgoneInboxInfoById(storageId);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
		// TODO Auto-generated method stub

	}

	/**
	 * 根据ID查询收件箱
	 * 
	 * @param id
	 * @return msgoneInbox
	 * 
	 * @author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	public MsgoneInbox selectMsgoneInboxById(long id) {
		return msgoneInboxDAO.selectMsgoneInboxById(id);
	}

	/**
	 * 收件箱更新处理
	 * 
	 * @param MsgoneInbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	public boolean updateMsgoneInboxInfo(MsgoneInbox msgoneInbox) {
		Integer count = msgoneInboxDAO.updateMsgoneInboxInfoById(msgoneInbox);
		return isUpdateSucc(count);
	}

	/**
	 * 删除一条收件箱(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	public boolean deleteMsgoneInboxInfoById(long id) {

		Integer count = msgoneInboxDAO.updateMsgoneInboxStatusToDisabled(id);
		return isUpdateSucc(count);
	}

	/**
	 * 根据查询条件查找垃圾箱列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	@Override
	public MsgoneInboxPage getDustbinListByPage(MsgoneInboxPage msgoneInboxPage) {
		int count = msgoneInboxDAO.findDustbinInfoCount(msgoneInboxPage);

		if (count == 0) {
			return msgoneInboxPage;
		}
		// 取得垃圾箱集合(分页查询)
		List<MsgoneInbox> msgoneInboxList = msgoneInboxDAO.findDustbinInfoList(msgoneInboxPage);

		msgoneInboxPage.setTotalRow(count); // 垃圾箱总数量
		msgoneInboxPage.setMsgoneInboxList(msgoneInboxList); // 垃圾箱信息集合
		return msgoneInboxPage;
	}
	/**
	 * 根据ID恢复信息
	 * 
	  * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@Override
	public boolean editMsgoneInboxById(long id) {
		Integer count = msgoneInboxDAO.updateMsgoneInboxById(id);
		return isUpdateSucc(count);
	}
	/**
	 * 已读一条收件箱(逻辑已读)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	@Override
	public boolean readMsgoneInboxInfoById(long id) {
		MsgoneInbox msgoneInbox=new MsgoneInbox();
		msgoneInbox.setId(id);
		Integer count = msgoneInboxDAO.updateMsgoneInboxInfoById(msgoneInbox);
		return isUpdateSucc(count);
	}
	/**
	 *已读一条收件箱(逻辑已读)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	@Override
	public boolean readMsgoneInboxs(long[] longArray) {
		boolean returnValue = false;
		// 循环删除收件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = readMsgoneInboxInfoById(storageId);
			
			// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
			Remind remind = new Remind();
			remind.setBusId(storageId);
			remind.setModeName(CommonChar.MODE_MSG);
			remind.setLoginId(SecurityUtils.getLoginId());
			remind.setStatus(CommonChar.REMIND_STATUS_BTX);
			remindDAO.updateRemindInfoByLoginId(remind);
			
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}

}
