package com.bcqsoft.sgoa.dao.seal.dataobject;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 签章模块表ORM对象
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public class SealPage extends BasePage {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -2440778511275466267L;
	/**
	 * 办公用品列表
	 */
	List<Seal> SealList;

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
	private Blob fileBody;
	/**
	 * 签章路径
	 */
	private String fiePath;

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

	public Blob getFileBody() {
		return fileBody;
	}

	public void setFileBody(Blob fileBody) {
		this.fileBody = fileBody;
	}

	public String getFiePath() {
		return fiePath;
	}

	public void setFiePath(String fiePath) {
		this.fiePath = fiePath;
	}

	public List<Seal> getSealList() {
		return SealList;
	}

	public void setSealList(List<Seal> sealList) {
		SealList = sealList;
	}


}
