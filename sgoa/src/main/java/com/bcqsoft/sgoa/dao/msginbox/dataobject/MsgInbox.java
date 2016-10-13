package com.bcqsoft.sgoa.dao.msginbox.dataobject;

import java.util.Date;

/**
 * 站内信收件箱ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_MSG_INBOX
 * </pre>
 */
public class MsgInbox {

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 创建日期
	 */
	private String createDate;

	/**
	 * 更新日期
	 */
	private Date updateDate;

	/**
	 * 收件人ID(关联SCOA_TB_USER.ID)
	 */
	private String receiverId;

	/**
	 * 发件人ID(关联SCOA_TB_USER.ID)
	 */
	private String senderId;

	/**
	 * 发件人姓名
	 */
	private String senderName;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 内容ID(关联SCOA_TB_MSG_TEXT.ID)
	 */
	private Long textId;
	/**
	 * 站内信详细内容
	 */
	private String msgText;
	/**
	 * 短信内容
	 */
	private String phoneText;

	/**
	 * 是否已读(Y:已读, N:未读)
	 */
	private String isRead;

	/**
	 * 已读日期
	 */
	private Date readDate;

	/**
	 * 是否是有效记录(Y:有效, N:无效)
	 */
	private String enabled;
	/**
	 * 邮件分类
	 * 
	 */
	private String msgType;

	/**
	 * 原附件名称
	 */
	private String srcFileName;

	/**
	 * 附件路径(服务器相对路径, 例/abc/2011/dddkk.zip)
	 */
	private String fileDir;

	/**
	 * 取得自增型主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置自增型主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 取得创建日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * 取得更新日期
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置更新日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 取得收件人ID(关联SCOA_TB_USER.ID)
	 */
	public String getReceiverId() {
		return receiverId;
	}

	/**
	 * 设置收件人ID(关联SCOA_TB_USER.ID)
	 */
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	/**
	 * 取得发件人ID(关联SCOA_TB_USER.ID)
	 */
	public String getSenderId() {
		return senderId;
	}

	/**
	 * 设置发件人ID(关联SCOA_TB_USER.ID)
	 */
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	/**
	 * 取得标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 取得内容ID(关联SCOA_TB_MSG_TEXT.ID)
	 */
	public Long getTextId() {
		return textId;
	}

	/**
	 * 设置内容ID(关联SCOA_TB_MSG_TEXT.ID)
	 */
	public void setTextId(Long textId) {
		this.textId = textId;
	}

	/**
	 * 取得是否已读(Y:已读, N:未读)
	 */
	public String getIsRead() {
		return isRead;
	}

	/**
	 * 设置是否已读(Y:已读, N:未读)
	 */
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	/**
	 * 取得已读日期
	 */
	public Date getReadDate() {
		return readDate;
	}

	/**
	 * 设置已读日期
	 */
	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}

	/**
	 * 取得是否是有效记录(Y:有效, N:无效)
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * 设置是否是有效记录(Y:有效, N:无效)
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public String getFileDir() {
		return fileDir;
	}

	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}

	public String getPhoneText() {
		return phoneText;
	}

	public void setPhoneText(String phoneText) {
		this.phoneText = phoneText;
	}

}
