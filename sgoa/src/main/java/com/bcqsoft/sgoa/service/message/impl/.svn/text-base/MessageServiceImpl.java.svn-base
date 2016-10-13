package com.bcqsoft.sgoa.service.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.message.MessageDAO;
import com.bcqsoft.sgoa.dao.message.dataobject.Message;
import com.bcqsoft.sgoa.dao.message.dataobject.MessagePage;
import com.bcqsoft.sgoa.dao.messagehistory.MessageHistoryDAO;
import com.bcqsoft.sgoa.dao.messagehistory.dataobject.MessageHistory;
import com.bcqsoft.sgoa.dao.messagereview.MessageReviewDAO;
import com.bcqsoft.sgoa.dao.messagereview.dataobject.MessageReview;
import com.bcqsoft.sgoa.dao.messagereview.dataobject.MessageReviewPage;
import com.bcqsoft.sgoa.dao.messagestep.MessageStepDAO;
import com.bcqsoft.sgoa.dao.messagestep.dataobject.MessageStep;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.service.message.MessageService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class MessageServiceImpl extends BaseService implements MessageService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private MessageDAO messageDAO;
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private MessageHistoryDAO messageHistoryDAO;
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private MessageStepDAO messageStepDAO;
	/**
	 * 信息审核表数据库访问DAO接口
	 */
	@Autowired
	private MessageReviewDAO messageReviewDAO;
	
	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 添加信息草稿
	 * 
	 * @param message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addMessageDraftInfo(Message message) {
		// 设置信息状态为草稿状态
		message.setEnabled(CommonChar.FILE_DRAFT);
		message.setSort(CommonChar.SORT_TZ);
		message.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = messageDAO.insertIntoMessage(message);
		return isInsertSucc(pk);
	}

	/**
	 * 添加信息草稿
	 * 
	 * @param message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateMessageDraftInfo(Message message) {
		message.setEnabled(CommonChar.FILE_DRAFT); // 设置状态为草稿
		// 更新信息信息
		Integer count = messageDAO.updateMessageInfoById(message);
		return isUpdateSucc(count);
	}

	/**
	 * 添加信息数据
	 * 
	 * <pre>
	 * <li>1.将信息信息添加至信息临时表</li>
	 * <li>2.将本次提交信息添加至信息审核表</li>
	 * </pre>
	 * 
	 * @param Message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addMessageInfo(Message message) {
		// 设置信息状态为正常状态
		message.setEnabled(CommonChar.FILE_NORMAL);
		message.setSort(CommonChar.SORT_TZ);
		message.setStatus(CommonChar.STATUS_WD);
		message.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = messageDAO.insertIntoMessage(message);
		// 添加这条数据的历史记录
		messageHistoryDAO.insertIntoMessageHistory(getMessageHistoryByMessage(
				message, pk));
		messageStepDAO.insertIntoMessageStep(getMessageStepByMessage(message,
				pk));
		// 添加消息提醒的信息
		if (message.getNextOptId() != null && !"".equals(message.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(pk);
			remind.setLoginId(message.getNextOptId());
			remind.setModeName(CommonChar.MODE_MESSAGE);
			remind.setTitle(message.getTitle());
			remind.setUrl("message/edit_message_review.htm?id="+pk);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		return isInsertSucc(pk);
	}

	/**
	 * 拟稿的信息
	 * 
	 * @param MessagePage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public MessagePage getMyDraftMessageList(MessagePage messagePage) {
		// 根据条件查找用户信息拟稿数量
		int count = messageDAO.findMyDraftMessageCount(messagePage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return messagePage;
		}

		// 根据条件查找用户信息拟稿集合
		List<Message> messageList = messageDAO
				.findMyDraftMessageList(messagePage);
		messagePage.setTotalRow(count); // 拟稿总数量
		messagePage.setMessageList(messageList); // 拟稿信息集合

		// 返回分页对象
		return messagePage;
	}

	/**
	 * 我的申请页面
	 * 
	 * @param MessagePage
	 * @return 分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public MessagePage getApprovedMessageList(MessagePage messagePage) {
		// 根据条件查找用户待审核信息数量
		int count = messageDAO.findApprovedMessageCount(messagePage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return messagePage;
		}

		// 根据条件查找用户待审核信息集合
		List<Message> messageList = messageDAO
				.findApprovedMessageList(messagePage);
		messagePage.setTotalRow(count); // 待审核总数量
		messagePage.setMessageList(messageList); // 待审核信息集合

		// 返回分页对象
		return messagePage;
	}

	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long
	 *            信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean removeOneMessageInfo(Long id) {
		int count = messageDAO.updateMessageStatusToEnabled(id);
		return isUpdateSucc(count);
	}

	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long
	 *            信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean removeOneMessageInfo(long[] longArray) {
		boolean returnValue = false;
		// 循环删除收件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = removeOneMessageInfo(storageId);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * 
	 * @param id
	 *            信息ID
	 * @return Message
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Message getUserDraftMessageDetail(Long id) {
		Message out = messageDAO.findMessageDetailInfoById(id);
		return out;
	}

	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateMessageInfo(Message message) {
		// 更新信息信息
		Integer count = messageDAO.updateMessageInfoById(message);
		// 添加这条数据的历史记录

		messageHistoryDAO.insertIntoMessageHistory(getMessageHistoryByMessage(
				message, message.getId()));
		messageStepDAO.insertIntoMessageStep(getMessageStepByMessage(message,
				message.getId()));
		return isUpdateSucc(count);
	}

	/**
	 * 根据信息ID撤销该条信息记录
	 * 
	 * 
	 * @param Long
	 *            信息ID
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateOneMessageInfo(Long id) {
		Integer count = messageDAO.updateOneMessageInfo(id);

		// 添加步骤记录
		messageStepDAO.delectIntoMessageStepById(id);
		return isUpdateSucc(count);
	}

	/**
	 * 查找通知公告审批表详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@Override
	public MessageReviewPage getMessageReviewListById(Long id) {
		MessageReviewPage page = new MessageReviewPage();
		List<MessageReview> messageReviewList = messageReviewDAO
				.findMessageReviewList(id);
		page.setMessageReviewList(messageReviewList);
		return page;
	}
	
	
	/**
	 * 查找通知公告审批表一条详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@Override
	public MessageReviewPage getMessageReviewListByIdOne(Long id) {
		MessageReviewPage page = new MessageReviewPage();
		List<MessageReview> messageReviewList = messageReviewDAO
				.findMessageReviewListByOne(id);
		page.setMessageReviewList(messageReviewList);
		return page;
	}

	/**
	 * 历史表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public MessageHistory getMessageHistoryByMessage(Message message, long pk) {
		MessageHistory messageHistory = new MessageHistory();
		messageHistory.setCurrentOptId(message.getCurrentOptId());
		messageHistory.setNextOptId(message.getNextOptId());
		messageHistory.setMessageId(pk);
		messageHistory.setRecordID(message.getdRecordid());
		return messageHistory;
	}

	/**
	 * 步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public MessageStep getMessageStepByMessage(Message message, long pk) {
		MessageStep messageStep = new MessageStep();
		messageStep.setCurrentOptId(SecurityUtils.getLoginId());
		messageStep.setMessageId(pk);
		messageStep.setStep(message.getStep() - 1);
		return messageStep;
	}

	/**
	 * 步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public MessageStep getMessageStepByMessageByStep(Message message,
			Integer step, long pk) {
		MessageStep messageStep = new MessageStep();
		messageStep.setCurrentOptId(message.getCurrentOptId());
		messageStep.setMessageId(pk);
		messageStep.setStep(step);
		return messageStep;
	}

	/**
	 * 待审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@Override
	public MessagePage getMessageReviewList(MessagePage messagePage) {
		// 根据条件查找用户待审核信息数量
		int count = messageDAO.findMessageReviewCount(messagePage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return messagePage;
		}

		// 根据条件查找用户待审核信息集合
		List<Message> messageList = messageDAO
				.findMessageReviewList(messagePage);
		messagePage.setTotalRow(count); // 待审核总数量
		messagePage.setMessageList(messageList); // 待审核信息集合

		// 返回分页对象
		return messagePage;
	}

	/**
	 * 经我审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@Override
	public MessagePage getMyMessageReviewList(MessagePage messagePage) {
		// 根据条件查找用户待审核信息数量
		int count = messageDAO.getMyMessageReviewCount(messagePage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return messagePage;
		}

		// 根据条件查找用户待审核信息集合
		List<Message> messageList = messageDAO
				.getMyMessageReviewList(messagePage);
		messagePage.setTotalRow(count); // 待审核总数量
		messagePage.setMessageList(messageList); // 待审核信息集合

		// 返回分页对象
		return messagePage;
	}

	/**
	 * 通知公告表审批修改
	 * 
	 * @param from
	 * @param map
	 * @return 通知公告表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createMessageReview(Message message) {

		Integer stepInt = 0;
		// 取得当前信息步骤表里的最大步骤
		List<MessageStep> messageStepList = messageStepDAO.findAllMessageStepById(message.getId());
		if (messageStepList == null || messageStepList.size() == 0) {
			stepInt = 0;
		} else {
			Integer setpIntTemp = 0;
			for (int i = 0; i < messageStepList.size(); i++) {
				MessageStep messageStep = messageStepList.get(i);
				// 把列表中的大的值赋值给临时变量
				if (messageStep.getStep() > setpIntTemp) {
					setpIntTemp = messageStep.getStep();
				}
			}
			stepInt = setpIntTemp + 1;
		}
		// 数据库新增一条审核记录,并返回是否插入成功
		message.setCurrentOptId(SecurityUtils.getLoginId());
		message.setEnabled(1);
		messageDAO.updateMessageById(message);
		Long pk = messageReviewDAO
				.insertIntoMessageReview(toInsterMessageReview(message));
		// 添加历史记录
		messageHistoryDAO.insertIntoMessageHistory(getMessageHistoryByMessage(
				message, message.getId()));
		// 添加步骤记录
		messageStepDAO.insertIntoMessageStep(getMessageStepByMessageByStep(
				message, stepInt, message.getId()));
		
		// 添加消息提醒的信息
		if (message.getNextOptId() != null && !"".equals(message.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(message.getId());
			remind.setLoginId(message.getNextOptId());
			remind.setModeName(CommonChar.MODE_MESSAGE);
			remind.setTitle(message.getTitle());
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remind.setUrl("message/edit_message_review.htm?id="+message.getId());
			remindDAO.insertIntoRemind(remind);
		}
		// 此处默认返回操作成功成功
		return isInsertSucc(pk);
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return MessageReview
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	private MessageReview toInsterMessageReview(Message message) {
		MessageReview messageReview = new MessageReview();
		messageReview.setMessageId(message.getId());// 获取主表ID
		messageReview.setCurrentOptId(SecurityUtils.getLoginId());// 当前操作人
		messageReview.setOpinion(message.getOpinion()); // 意见
		messageReview.setDoAction(message.getDoAction());// 设置状态
		return messageReview;
	}

	/**
	 * 返回跳转
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@Override
	public List<MessageStep> getMessageStepList(Long id) {
		List<MessageStep> messageStepList = messageStepDAO
				.findAllMessageStepById(id);
		return messageStepList;
	}

	/**
	 * 通知公告表返回
	 * 
	 * @param from
	 * @param map
	 * @return 通知公告
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createMessageReback(Message message) {
		// 数据库新增一条审核记录,并返回是否插入成功
		message.setCurrentOptId(SecurityUtils.getLoginId());
		// 判断当返回给拟稿人的场合设置状态为拟稿
		if (message.getStep() == 0) {
			message.setEnabled(2);
			message.setNextOptId("");
		} else {
			message.setEnabled(1);
		}
			
		messageDAO.updateMessageById(message);
		Long pk = messageReviewDAO
				.insertIntoMessageReview(toInsterMessageReview(message));
		// 添加历史记录
		messageHistoryDAO.insertIntoMessageHistory(getMessageHistoryByMessage(
				message, message.getId()));
		// 添加步骤记录
		messageStepDAO.delectIntoMessageStep(getMessageStepByMessageByStep(
				message, message.getStep(), message.getId()));

		// 添加消息提醒的信息
		if (message.getNextOptId() != null && !"".equals(message.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(message.getId());
			remind.setLoginId(message.getNextOptId());
			remind.setModeName(CommonChar.MODE_MESSAGE);
			remind.setTitle(message.getTitle());
			if (message.getStep() == 0) {
				remind.setUrl("message/edit_message.htm?id="+message.getId());
			} else {
				remind.setUrl("message/edit_message_review.htm?id="+message.getId());
			}
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		// 此处默认返回操作成功成功
		return isInsertSucc(pk);
	}

	/**
	 * 跳转至历史记录页面
	 * 
	 * @return 历史记录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@Override
	public List<MessageHistory> getMessageHistoryInfo(long id) {
		List<MessageHistory> messageHistoryList = messageHistoryDAO
				.findAllMessageHistoryById(id);
		return messageHistoryList;
	}

	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	public MessagePage getMessageSearchList(MessagePage outPage) {
		int count = messageDAO.findMessageSeacheCount(outPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return outPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Message> messageList = messageDAO.findMessageSeacheList(outPage);
		outPage.setTotalRow(count); // 待审核总数量
		outPage.setMessageList(messageList); // 待审核信息	
		return outPage;
	}

	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public boolean updateMessageStatusById(Message message){
		int count = messageDAO.updateMessageStatusById(message);
		return isUpdateSucc(count);
	}
}
