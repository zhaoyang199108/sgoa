package com.bcqsoft.sgoa.dao.addressbooktype.dataobject;

import java.util.Date;

public class AddressBookType{
	
	// Enabled字段值(N:不可用, Y:可用)
	public static final String DISABLED = "N";
	public static final String ABLED = "Y";
	
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
	 * 用户ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	private String loginId;
	
	/**
	 * 排序号
	 */
	private Integer sorting;
	
	/**
	 * 分组名称
	 */
	private String typeName;
	
	/**
	 * Y: 有效, N无效
	 */
	private String enabled;
	
	/**
	 * 生成Getter和Setter方法
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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Integer getSorting() {
		return sorting;
	}

	public void setSorting(Integer sorting) {
		this.sorting = sorting;
	}

}
