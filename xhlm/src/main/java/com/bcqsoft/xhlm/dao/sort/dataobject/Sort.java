package com.bcqsoft.xhlm.dao.sort.dataobject;

import java.util.Date;

/**
 * 分类表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_Sort
 * </pre>
 */
public class Sort {

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
	 * 登录人LOGIN_ID
	 */
	private String loginId;
	
	/**
	 * 分类名称
	 */
	private String name;
	
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

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getLoginId() {
		return loginId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
}