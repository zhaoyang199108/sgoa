package com.bcqsoft.sgoa.service.msg.impl;

import static com.bcqsoft.sgoa.common.util.ListUtil.toStringList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.msginbox.MsgInboxDAO;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInbox;
import com.bcqsoft.sgoa.dao.msgoutbox.MsgOutboxDAO;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutbox;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutboxPage;
import com.bcqsoft.sgoa.dao.msgtext.MsgTextDAO;
import com.bcqsoft.sgoa.dao.msgtext.dataobject.MsgText;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.UserDAO;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.service.msg.MsgOutboxService;

/**
 * 站内信模块业务逻辑类实现类
 */
@Service
public class MsgOutboxServiceImpl extends BaseService implements
		MsgOutboxService {
	/**
	 * 站内信详细模块DAO实现类
	 */
	@Autowired
	private MsgTextDAO msgTextDAO;
	/**
	 * 发件模块DAO实现类
	 */
	@Autowired
	private MsgOutboxDAO msgOutboxDAO;
	/**
	 * 收件模块DAO实现类
	 */
	@Autowired
	private MsgInboxDAO msgInboxDAO;
	/**
	 * 用户模块DAO实现类
	 */
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 写信的实现类
	 * 
	 * @param msgOutbox
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addMsgOutbox(MsgOutbox msgOutbox, MultipartFile srcUploadFile) {
		MsgText msgText = new MsgText();
		String dateStr = DateUtil.getDateTimeForYh();
		if (srcUploadFile != null && srcUploadFile.getSize() != 0) {

			// 文件上传
			try {
				InputStream input = srcUploadFile.getInputStream();
				FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK",
						"upload", 21);
				ftpUtil.connectServer("upload");
				ftpUtil.uploadFile(input,
						dateStr + "_" + srcUploadFile.getOriginalFilename());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 获取文件上传的文件名称
			msgText.setSrcFileName(dateStr + "_"
					+ srcUploadFile.getOriginalFilename());
		}

		msgText.setMsgText(msgOutbox.getMsgText());
		msgText.setPhoneText(msgOutbox.getPhoneText());
		Long textId = msgTextDAO.addMsgText(msgText);
		String msgStatus = msgOutbox.getMsgStatus();
		msgOutbox.setTextId(textId);
		String receiverIds = msgOutbox.getReceiverIds();
		List<User> userList = userDAO.findUsersByMsg(toMap("MsgIds",
				toStringList(receiverIds)));
		String receiverIdOne = "";
		for (int i = 0; i < userList.size(); i++) {
			receiverIdOne = receiverIdOne + userList.get(i).getUserName() + ",";
		}

		msgOutbox.setReceiverNames(receiverIdOne);
		msgOutboxDAO.addMsgOutbox(msgOutbox);

		if ("Y".equals(msgStatus)) {
			addMsgInbox(msgOutbox);
		}
		return true;
	}

	/**
	 * 写信的实现类
	 * 
	 * @param msgOutbox
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean editMsgOutbox(MsgOutbox msgOutbox) {
		MsgText msgText = new MsgText();

		msgText.setMsgText(msgOutbox.getMsgText());
		msgText.setSrcFileName(msgOutbox.getSrcFileName());
		msgText.setPhoneText(msgOutbox.getPhoneText());
		Long textId = msgTextDAO.addMsgText(msgText);
		String msgStatus = msgOutbox.getMsgStatus();
		msgOutbox.setTextId(textId);
		String receiverIds = msgOutbox.getReceiverIds();
		List<User> userList = userDAO.findUsersByMsg(toMap("MsgIds",
				toStringList(receiverIds)));
		String receiverIdOne = "";
		for (int i = 0; i < userList.size(); i++) {
			receiverIdOne = receiverIdOne + userList.get(i).getUserName() + ",";
		}

		msgOutbox.setReceiverNames(receiverIdOne);
		msgOutboxDAO.addMsgOutbox(msgOutbox);

		if ("Y".equals(msgStatus)) {
			addMsgInbox(msgOutbox);
		}
		
		return true;
	}

	/**
	 * 根据查询条件查找发件箱信息列表
	 * 
	 * @param id
	 * @return 发件箱分页对象
	 * 
	 * @Author cql
	 * @Date 2012-01-11
	 */
	@Override
	public MsgOutboxPage getMsgOutboxListByPage(MsgOutboxPage msgOutboxPage) {
		int count = msgOutboxDAO.findMsgInboxOutfoCount(msgOutboxPage);

		if (count == 0) {
			return msgOutboxPage;
		}
		// 取得发件箱集合(分页查询)
		List<MsgOutbox> msgOutboxList = msgOutboxDAO
				.findMsgOutboxInfoList(msgOutboxPage);

		msgOutboxPage.setTotalRow(count); // 发件箱总数量
		msgOutboxPage.setMsgOutboxList(msgOutboxList); // 发件箱信息集合
		return msgOutboxPage;
	}

	/**
	 * 删除一条发信(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@Override
	public boolean deleteMsgOutboxInfoById(long id) {
		Integer count = msgOutboxDAO.updateMsgOutboxStatusToDisabled(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除多条发信(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@Override
	public boolean deleteMsgOutboxs(long[] longArray) {
		boolean returnValue = false;
		// 循环删除发件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = deleteMsgOutboxInfoById(storageId);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID查询发件箱的详细信息
	 * 
	 * @param id
	 * @return msgOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	@Override
	public MsgOutbox selectMsgOutboxById(long id) {
		return msgOutboxDAO.selectMsgOutboxById(id);
	}

	/**
	 * 发件箱更新处理
	 * 
	 * @param msgOutbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateMsgOutboxInfo(MsgOutbox msgOutbox) {
		String receiverIds = msgOutbox.getReceiverIds();
		List<User> userList = userDAO.findUsersByMsg(toMap("MsgIds",
				toStringList(receiverIds)));
		String receiverIdOne = "";
		for (int i = 0; i < userList.size(); i++) {
			receiverIdOne = receiverIdOne + userList.get(i).getUserName() + ",";
		}

		msgOutbox.setReceiverNames(receiverIdOne);
		msgOutboxDAO.updateMsgOutboxInfoById(msgOutbox);
		msgOutbox.setMsgStatus(msgOutbox.getMsgStatus());
		MsgText msgText = new MsgText();
		msgText.setId(msgOutbox.getTextId());
		msgText.setMsgText(msgOutbox.getMsgText());
		msgText.setPhoneText(msgOutbox.getPhoneText());
		msgTextDAO.updateMsgText(msgText);

		String msgStatus = msgOutbox.getMsgStatus();
		if ("Y".equals(msgStatus)) {
			addMsgInbox(msgOutbox);
		}
		
		return true;
	}

	/**
	 * 查看未读的站内信
	 * 
	 * @param userId
	 *            当前登录ID
	 * @return 未读站内信列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-15
	 */
	public List<MsgInbox> getUnreadMessageByUserId(String userId) {
		return msgInboxDAO.findUnreadMessageByUserId(userId);
	}

	/**
	 * 草稿箱的实现类
	 * 
	 * @param msgOutboxPage
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2011-10-20
	 */
	@Override
	public MsgOutboxPage getMsgOutboxDraftListByPage(MsgOutboxPage msgOutboxPage) {
		int count = msgOutboxDAO.findDraftMsgOutboxSendCount(msgOutboxPage);

		if (count == 0) {
			return msgOutboxPage;
		}
		// 取得草稿箱信息集合(分页查询)
		List<MsgOutbox> msgOutboxList = msgOutboxDAO
				.findDraftMsgOutboxSendList(msgOutboxPage);

		msgOutboxPage.setTotalRow(count); // 草稿箱总数量
		msgOutboxPage.setMsgOutboxList(msgOutboxList); // 草稿箱信息集合
		return msgOutboxPage;
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
	public boolean editMsgOutboxById(long id) {
		Integer count = msgOutboxDAO.updateMsgOutboxById(id);
		return isUpdateSucc(count);
	}

	/**
	 * 收件箱的添加方法
	 * 
	 * @param messagePage
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addMsgInbox(MsgOutbox msgOutbox) {
		String receiverIds[] = msgOutbox.getReceiverIds().split(",");
		for (int i = 0; i < receiverIds.length; i++) {
			MsgInbox msgInbox = new MsgInbox();
			msgInbox.setReceiverId(receiverIds[i]);
			msgInbox.setSenderId(msgOutbox.getSenderId());
			msgInbox.setTextId(msgOutbox.getTextId());
			msgInbox.setTitle(msgOutbox.getTitle());
			Long pkId = msgInboxDAO.insertIntoMsgInbox(msgInbox);
			
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(pkId);
			remind.setLoginId(receiverIds[i]);
			remind.setModeName(CommonChar.MODE_MSG);
			remind.setTitle(msgOutbox.getTitle());
			remind.setUrl("msg/detail_msgInbox.htm?id="+pkId);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		return true;
	}

	/**
	 * 根据ID发送站内信的接口
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addMsgInboxById(String LoginId, String title, String text,
			String phoneText) {
		MsgText msgText = new MsgText();
		msgText.setMsgText(text);
		msgText.setPhoneText(phoneText);
		Long textId = msgTextDAO.addMsgText(msgText);

		MsgOutbox msgOutbox = new MsgOutbox();
		msgOutbox.setTextId(textId);
		msgOutboxDAO.addMsgOutbox(msgOutbox);// 发件箱添加记录
		addMsgInbox(msgOutbox);// 收件箱添加记录
		return true;

	}
}
