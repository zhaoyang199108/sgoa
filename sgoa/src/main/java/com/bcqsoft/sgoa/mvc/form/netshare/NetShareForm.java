package com.bcqsoft.sgoa.mvc.form.netshare;

import java.util.Date;

import com.bcqsoft.sgoa.core.base.BaseForm;

public class NetShareForm extends BaseForm{


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
	 * 资源ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	private Long netId;

	/**
	 * 被共享人ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	private String toShareId;

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
	 * 取得资源ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	public Long getNetId() {
		return netId;
	}

	/**
	 * 设置资源ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	public void setNetId(Long netId) {
		this.netId = netId;
	}

	/**
	 * 取得被共享人ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	public String getToShareId() {
		return toShareId;
	}

	/**
	 * 设置被共享人ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	public void setToShareId(String toShareId) {
		this.toShareId = toShareId;
	}

}

