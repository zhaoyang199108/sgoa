package com.bcqsoft.xhlm.dao.xhfwdetail.dataobject;

import java.util.Date;

/**
 * 通知表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_SORT_NOTICE
 * </pre>
 */
public class XhfwDetail {

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
	 * 服务ID
	 */
	private String xhfwId;
	
	/**
	 * 服务标题
	 */
	private String title;
	
	/**
	 * 协会ID
	 */
	private String xhId;
	
	/**
	 * 协会名称
	 */
	private String xhName;

	/**
	 * 用户ID
	 */
	private String loginId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getXhId() {
		return xhId;
	}

	public void setXhId(String xhId) {
		this.xhId = xhId;
	}

	public String getXhName() {
		return xhName;
	}

	public void setXhName(String xhName) {
		this.xhName = xhName;
	}

	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 是否是有效记录(Y:有效, N:无效)
	 */
	private String enabled;

	/**
	 * get && set 方法
	 */
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getXhfwId() {
		return xhfwId;
	}

	public void setXhfwId(String xhfwId) {
		this.xhfwId = xhfwId;
	}
}