package com.bcqsoft.sgoa.dao.template.dataobject;

import java.util.Date;

/**
 * 模版模块表ORM对象
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public class Template {

	// Enabled字段值(N:不可用, Y:可用)
	public static final String DISABLED = "N";
	public static final String ABLED = "Y";

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 模版Id
	 */
	private String templateId;

	/**
	 * 文件时间
	 */
	private Date fileDate;
	/**
	 * 模版名称
	 */
	private String fileName;

	/**
	 * 模版类型
	 */
	private String fileType;

	/**
	 * 模版字数
	 */
	private Integer fileSize;

	/**
	 * 模版内容
	 */
	private byte[] fileBody;
	/**
	 * 模版路径
	 */
	private String filePath;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 模版说明
	 */
	private String descript;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

}
