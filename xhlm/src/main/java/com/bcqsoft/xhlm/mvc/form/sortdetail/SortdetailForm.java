package com.bcqsoft.xhlm.mvc.form.sortdetail;

import java.util.Date;

import com.bcqsoft.xhlm.core.base.BaseForm;

public class SortdetailForm extends BaseForm {

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
	 * 所属分类
	 */
	private String sortId;
	/**
	 * 备注
	 */
	private String remark;
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
