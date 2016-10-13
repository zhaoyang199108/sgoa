package com.bcqsoft.sgoa.service.msg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.msginbox.MsgInboxDAO;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInbox;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInboxPage;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.service.msg.MsgInboxService;

/**
 * 收件箱模块业务逻辑类实现类
 */
/**
 * 收件箱模块业务逻辑实现类
 */
@Service
public class MsgInboxServiceImpl extends BaseService implements MsgInboxService {
	@Autowired
	private MsgInboxDAO msgInboxDAO;
	
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
	public MsgInboxPage getMsgInboxListByPage(MsgInboxPage page) {
		int count = msgInboxDAO.findMsgInboxInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得收件箱集合(分页查询)
		List<MsgInbox> msgInboxList = msgInboxDAO.findMsgInboxInfoList(page);

		page.setTotalRow(count); // 收件箱总数量
		page.setMsgInboxList(msgInboxList); // 收件箱信息集合
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
	public boolean deleteMsgInboxs(long[] longArray) {
		boolean returnValue = false;
		// 循环删除收件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = deleteMsgInboxInfoById(storageId);
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
	 * @return msgInbox
	 * 
	 * @author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	public MsgInbox selectMsgInboxById(long id) {
		return msgInboxDAO.selectMsgInboxById(id);
	}

	/**
	 * 收件箱更新处理
	 * 
	 * @param MsgInbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	public boolean updateMsgInboxInfo(MsgInbox msgInbox) {
		Integer count = msgInboxDAO.updateMsgInboxInfoById(msgInbox);
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
	public boolean deleteMsgInboxInfoById(long id) {

		Integer count = msgInboxDAO.updateMsgInboxStatusToDisabled(id);
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
	public MsgInboxPage getDustbinListByPage(MsgInboxPage msgInboxPage) {
		int count = msgInboxDAO.findDustbinInfoCount(msgInboxPage);

		if (count == 0) {
			return msgInboxPage;
		}
		// 取得垃圾箱集合(分页查询)
		List<MsgInbox> msgInboxList = msgInboxDAO.findDustbinInfoList(msgInboxPage);

		msgInboxPage.setTotalRow(count); // 垃圾箱总数量
		msgInboxPage.setMsgInboxList(msgInboxList); // 垃圾箱信息集合
		return msgInboxPage;
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
	public boolean editMsgInboxById(long id) {
		Integer count = msgInboxDAO.updateMsgInboxById(id);
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
	public boolean readMsgInboxInfoById(long id) {
		MsgInbox msgInbox=new MsgInbox();
		msgInbox.setId(id);
		Integer count = msgInboxDAO.updateMsgInboxInfoById(msgInbox);
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
	public boolean readMsgInboxs(long[] longArray) {
		boolean returnValue = false;
		// 循环删除收件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = readMsgInboxInfoById(storageId);
			
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
