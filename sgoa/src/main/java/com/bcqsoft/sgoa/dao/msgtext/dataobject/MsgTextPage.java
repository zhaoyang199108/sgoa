package com.bcqsoft.sgoa.dao.msgtext.dataobject;

import java.util.Date;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 站内信详细内容ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_MSG_TEXT
 * </pre>
 */
public class MsgTextPage extends BasePage {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 8664820498438260413L;

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 创建日期
	 */
	private Date createDate;

	/**
	 * 更新日期
	 */
	private Date updateDate;

	/**
	 * 站内信详细内容
	 */
	private String msgText;
	/**
	 * 短信内容
	 */
	private String phoneText;
	
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
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 */
	public void setCreateDate(Date createDate) {
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
	 * 取得站内信详细内容
	 */
	public String getMsgText() {
		return msgText;
	}

	/**
	 * 设置站内信详细内容
	 */
	public void setMsgText(String msgText) {
		this.msgText = msgText;
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
