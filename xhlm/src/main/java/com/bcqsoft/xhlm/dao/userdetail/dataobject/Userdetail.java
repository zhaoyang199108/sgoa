package com.bcqsoft.xhlm.dao.userdetail.dataobject;

import java.util.Date;

/**
 * 用户详细表ORM对象
 * 
 * <pre>
 * 表: XHLM_TB_USER_DETAIL
 * </pre>
 */
public class Userdetail {

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
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 名称
	 */
	private String userName;
	
	/**
	 * 条目ID
	 */
	private String tmId;
	
	/**
	 * 条目
	 */
	private String tmname;
	
	/**
	 * 条目企业
	 */
	private String tmnameq;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 类别（1、协会，2、企业）
	 */
	private Integer type;
	
	
	// get和set方法
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTmId() {
		return tmId;
	}

	public void setTmId(String tmId) {
		this.tmId = tmId;
	}

	public String getTmname() {
		return tmname;
	}

	public void setTmname(String tmname) {
		this.tmname = tmname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTmnameq() {
		return tmnameq;
	}

	public void setTmnameq(String tmnameq) {
		this.tmnameq = tmnameq;
	}

}
