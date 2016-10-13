package com.bcqsoft.sgoa.service.msgone.impl;

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
import com.bcqsoft.sgoa.dao.msgoneinbox.MsgoneInboxDAO;
import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInbox;
import com.bcqsoft.sgoa.dao.msgoneoutbox.MsgoneOutboxDAO;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutbox;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutboxPage;
import com.bcqsoft.sgoa.dao.msgonetext.MsgoneTextDAO;
import com.bcqsoft.sgoa.dao.msgonetext.dataobject.MsgoneText;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.UserDAO;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.service.msgone.MsgoneOutboxService;

/**
 * 站内信模块业务逻辑类实现类
 */
@Service
public class MsgoneOutboxServiceImpl extends BaseService implements
		MsgoneOutboxService {
	/**
	 * 站内信详细模块DAO实现类
	 */
	@Autowired
	private MsgoneTextDAO msgoneTextDAO;
	/**
	 * 发件模块DAO实现类
	 */
	@Autowired
	private MsgoneOutboxDAO msgoneOutboxDAO;
	/**
	 * 收件模块DAO实现类
	 */
	@Autowired
	private MsgoneInboxDAO msgoneInboxDAO;
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
	 * @param msgoneOutbox
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addMsgoneOutbox(MsgoneOutbox msgoneOutbox, MultipartFile srcUploadFile) {
		MsgoneText msgoneText = new MsgoneText();
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
			msgoneText.setSrcFileName(dateStr + "_"
					+ srcUploadFile.getOriginalFilename());
		}

		msgoneText.setdRecordid(msgoneOutbox.getdRecordid());
		msgoneText.setPhoneText(msgoneOutbox.getPhoneText());
		Long textId = msgoneTextDAO.addMsgoneText(msgoneText);
		String msgStatus = msgoneOutbox.getMsgStatus();
		msgoneOutbox.setTextId(textId);
		String receiverIds = msgoneOutbox.getReceiverIds();
		// 取得已发送用户名称
		User user = userDAO.getUserInfoByLoginId(receiverIds);
		msgoneOutbox.setReceiverNames(user.getUserName());
		msgoneOutboxDAO.addMsgoneOutbox(msgoneOutbox);

		if ("Y".equals(msgStatus)) {
			addMsgoneInbox(msgoneOutbox);
		}
		return true;
	}
	
	/**
	 * 写信的实现类
	 * 
	 * @param msgoneOutbox
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addEditMsgoneOutbox(MsgoneOutbox msgoneOutbox, MultipartFile srcUploadFile) {
		MsgoneText msgoneText = new MsgoneText();
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
			msgoneText.setSrcFileName(dateStr + "_"
					+ srcUploadFile.getOriginalFilename());
		}
		msgoneText.setId(msgoneOutbox.getTextId());
		msgoneText.setPhoneText(msgoneOutbox.getPhoneText());
		msgoneText.setSrcFileName(msgoneText.getSrcFileName());
		msgoneTextDAO.editMsgoneText(msgoneText);

		String msgStatus = msgoneOutbox.getMsgStatus();
		msgoneOutbox.setTextId(msgoneOutbox.getTextId());
		String receiverIds = msgoneOutbox.getReceiverIds();
		// 取得已发送用户名称
		User user = userDAO.getUserInfoByLoginId(receiverIds);
		msgoneOutbox.setReceiverNames(user.getUserName());
		msgoneOutboxDAO.addMsgoneOutbox(msgoneOutbox);

		if ("Y".equals(msgStatus)) {
			addMsgoneInbox(msgoneOutbox);
		}
		return true;
	}

	/**
	 * 写信的实现类
	 * 
	 * @param msgoneOutbox
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean editMsgoneOutbox(MsgoneOutbox msgoneOutbox) {
		MsgoneText msgoneText = new MsgoneText();

		msgoneText.setdRecordid(msgoneOutbox.getdRecordid());
		msgoneText.setSrcFileName(msgoneOutbox.getSrcFileName());
		msgoneText.setPhoneText(msgoneOutbox.getPhoneText());
		Long textId = msgoneTextDAO.addMsgoneText(msgoneText);
		String msgStatus = msgoneOutbox.getMsgStatus();
		msgoneOutbox.setTextId(textId);
		String receiverIds = msgoneOutbox.getReceiverIds();
		// 取得已发送用户名称
		User user = userDAO.getUserInfoByLoginId(receiverIds);
		msgoneOutbox.setReceiverNames(user.getUserName());
		msgoneOutboxDAO.addMsgoneOutbox(msgoneOutbox);

		if ("Y".equals(msgStatus)) {
			addMsgoneInbox(msgoneOutbox);
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
	public MsgoneOutboxPage getMsgoneOutboxListByPage(MsgoneOutboxPage msgoneOutboxPage) {
		int count = msgoneOutboxDAO.findMsgoneInboxOutfoCount(msgoneOutboxPage);

		if (count == 0) {
			return msgoneOutboxPage;
		}
		// 取得发件箱集合(分页查询)
		List<MsgoneOutbox> msgoneOutboxList = msgoneOutboxDAO
				.findMsgoneOutboxInfoList(msgoneOutboxPage);

		msgoneOutboxPage.setTotalRow(count); // 发件箱总数量
		msgoneOutboxPage.setMsgoneOutboxList(msgoneOutboxList); // 发件箱信息集合
		return msgoneOutboxPage;
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
	public boolean deleteMsgoneOutboxInfoById(long id) {
		Integer count = msgoneOutboxDAO.updateMsgoneOutboxStatusToDisabled(id);
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
	public boolean deleteMsgoneOutboxs(long[] longArray) {
		boolean returnValue = false;
		// 循环删除发件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = deleteMsgoneOutboxInfoById(storageId);
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
	 * @return msgoneOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	@Override
	public MsgoneOutbox selectMsgoneOutboxById(long id) {
		return msgoneOutboxDAO.selectMsgoneOutboxById(id);
	}

	/**
	 * 发件箱更新处理
	 * 
	 * @param msgoneOutbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateMsgoneOutboxInfo(MsgoneOutbox msgoneOutbox) {
		String receiverIds = msgoneOutbox.getReceiverIds();
		// 取得已发送用户名称
		User user = userDAO.getUserInfoByLoginId(receiverIds);
		msgoneOutbox.setReceiverNames(user.getUserName());
		msgoneOutboxDAO.updateMsgoneOutboxInfoById(msgoneOutbox);
		msgoneOutbox.setMsgStatus(msgoneOutbox.getMsgStatus());
		MsgoneText msgoneText = new MsgoneText();
		msgoneText.setId(msgoneOutbox.getTextId());
		msgoneText.setdRecordid(msgoneOutbox.getdRecordid());
		msgoneText.setPhoneText(msgoneOutbox.getPhoneText());
		msgoneTextDAO.updateMsgoneText(msgoneText);

		String msgStatus = msgoneOutbox.getMsgStatus();
		if ("Y".equals(msgStatus)) {
			addMsgoneInbox(msgoneOutbox);
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
	public List<MsgoneInbox> getUnreadMessageByUserId(String userId) {
		return msgoneInboxDAO.findUnreadMessageByUserId(userId);
	}

	/**
	 * 草稿箱的实现类
	 * 
	 * @param msgoneOutboxPage
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2011-10-20
	 */
	@Override
	public MsgoneOutboxPage getMsgoneOutboxDraftListByPage(MsgoneOutboxPage msgoneOutboxPage) {
		int count = msgoneOutboxDAO.findDraftMsgoneOutboxSendCount(msgoneOutboxPage);

		if (count == 0) {
			return msgoneOutboxPage;
		}
		// 取得草稿箱信息集合(分页查询)
		List<MsgoneOutbox> msgoneOutboxList = msgoneOutboxDAO
				.findDraftMsgoneOutboxSendList(msgoneOutboxPage);

		msgoneOutboxPage.setTotalRow(count); // 草稿箱总数量
		msgoneOutboxPage.setMsgoneOutboxList(msgoneOutboxList); // 草稿箱信息集合
		return msgoneOutboxPage;
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
	public boolean editMsgoneOutboxById(long id) {
		Integer count = msgoneOutboxDAO.updateMsgoneOutboxById(id);
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
	public boolean addMsgoneInbox(MsgoneOutbox msgoneOutbox) {
		String receiverIds[] = msgoneOutbox.getReceiverIds().split(",");
		for (int i = 0; i < receiverIds.length; i++) {
			MsgoneInbox msgoneInbox = new MsgoneInbox();
			msgoneInbox.setReceiverId(receiverIds[i]);
			msgoneInbox.setSenderId(msgoneOutbox.getSenderId());
			msgoneInbox.setTextId(msgoneOutbox.getTextId());
			msgoneInbox.setTitle(msgoneOutbox.getTitle());
			Long pkId = msgoneInboxDAO.insertIntoMsgoneInbox(msgoneInbox);
			
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(pkId);
			remind.setLoginId(receiverIds[i]);
			remind.setModeName(CommonChar.MODE_MSG_ONE);
			remind.setTitle(msgoneOutbox.getTitle());
			remind.setUrl("msgone/detail_msgoneInbox.htm?id="+pkId);
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
	public boolean addMsgoneInboxById(String LoginId, String title, String text,
			String phoneText) {
		MsgoneText msgoneText = new MsgoneText();
		msgoneText.setdRecordid(text);
		msgoneText.setPhoneText(phoneText);
		Long textId = msgoneTextDAO.addMsgoneText(msgoneText);

		MsgoneOutbox msgoneOutbox = new MsgoneOutbox();
		msgoneOutbox.setTextId(textId);
		msgoneOutboxDAO.addMsgoneOutbox(msgoneOutbox);// 发件箱添加记录
		addMsgoneInbox(msgoneOutbox);// 收件箱添加记录
		return true;

	}
}
