package com.bcqsoft.sgoa.dao.resshare.dataobject;

import java.util.Date;

/**
 * 资源(文件)表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_RES_SHARE
 * </pre>
 */
public class ResShare {

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
	private Long resId;

	/**
	 * 被共享人ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	private String toShareId;
	/**
	 * 状态 （1代表只能浏览，2代表可以下载）
	 */
	private String status;
	/**
	 * 被共享人姓名（往页面传值用）
	 */
	
	private String toShareName;

	/**
	 * @return the toShareName
	 */
	public String getToShareName() {
		return toShareName;
	}

	/**
	 * @param toShareName the toShareName to set
	 */
	public void setToShareName(String toShareName) {
		this.toShareName = toShareName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

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
	public Long getResId() {
		return resId;
	}

	/**
	 * 设置资源ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	public void setResId(Long resId) {
		this.resId = resId;
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
