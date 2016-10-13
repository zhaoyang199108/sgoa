package com.bcqsoft.sgoa.dao.seal.dataobject;

import java.util.Date;

/**
 * 签章模块表ORM对象
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public class Seal {

	// Enabled字段值(N:不可用, Y:可用)
	public static final String DISABLED = "N";
	public static final String ABLED = "Y";

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 用户密码
	 */
	private String passWord;
	/**
	 * 文件时间
	 */
	private Date fileDate;
	/**
	 * 签章名称
	 */
	private String sealName;

	/**
	 * 签章类型
	 */
	private String fileType;

	/**
	 * 签章字数
	 */
	private Integer fileSize;

	/**
	 * 签章内容
	 */
	private byte[] fileBody;
	/**
	 * 签章路径
	 */
	private String filePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}

	public String getSealName() {
		return sealName;
	}

	public void setSealName(String sealName) {
		this.sealName = sealName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public byte[] getFileBody() {
		return fileBody;
	}

	public void setFileBody(byte[] fileBody) {
		this.fileBody = fileBody;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	

}
