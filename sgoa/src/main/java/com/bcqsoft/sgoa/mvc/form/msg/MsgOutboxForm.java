package com.bcqsoft.sgoa.mvc.form.msg;

import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.sgoa.core.base.BaseForm;

/**
 * 站内信发件箱ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_MSG_OUTBOX
 * </pre>
 */
public class MsgOutboxForm extends BaseForm {

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
	private String updateDate;

	/**
	 * 收件人ID(关联SCOA_TB_USER.ID,多个收件ID,中间使用半角分号区分,例:abc;ggg)
	 */
	private String receiverIds;

	/**
	 * 收件人名字
	 */
	private String receiverNames;

	/**
	 * 发件人ID(关联SCOA_TB_USER.ID)
	 */
	private String senderId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 内容ID(关联SCOA_TB_MSG_TEXT.ID)
	 */
	private Long textId;
	/**
	 * 内容
	 */
	private String msgText;
	/**
	 * 短信内容
	 */
	private String phoneText;
	/**
	 * 状态(Y发送N存草稿箱)
	 */
	private String msgStatus;

	/**
	 * 是否是有效记录(Y:有效, N:无效)
	 */
	private String enabled;

	/**
	 * 原附件名称
	 */
	private String srcFileName;

	/**
	 * 上传文件流
	 */
	private MultipartFile srcUploadFile;

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
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置更新日期
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 取得收件人ID(关联SCOA_TB_USER.ID,多个收件ID,中间使用半角分号区分,例:abc;ggg)
	 */
	public String getReceiverIds() {
		return receiverIds;
	}

	/**
	 * 设置收件人ID(关联SCOA_TB_USER.ID,多个收件ID,中间使用半角分号区分,例:abc;ggg)
	 */
	public void setReceiverIds(String receiverIds) {
		this.receiverIds = receiverIds;
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

	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}

	public String getMsgStatus() {
		return msgStatus;
	}

	public void setMsgStatus(String msgStatus) {
		this.msgStatus = msgStatus;
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

	public String getReceiverNames() {
		return receiverNames;
	}

	public void setReceiverNames(String receiverNames) {
		this.receiverNames = receiverNames;
	}

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public MultipartFile getSrcUploadFile() {
		return srcUploadFile;
	}

	public void setSrcUploadFile(MultipartFile srcUploadFile) {
		this.srcUploadFile = srcUploadFile;
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
