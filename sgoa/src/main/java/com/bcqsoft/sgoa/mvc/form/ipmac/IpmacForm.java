package com.bcqsoft.sgoa.mvc.form.ipmac;

import java.util.Date;

import com.bcqsoft.sgoa.core.base.BaseForm;

/**
 * IP/MAC表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_IPMAC
 * </pre>
 */
public class IpmacForm extends BaseForm {


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
	 * IP地址
	 */
	private String optIp;

	/**
	 * MAC地址
	 */
	private String optMac;
	
	/**
	 * Y: 有效, N无效
	 */
	private String enabled;

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

	public String getOptIp() {
		return optIp;
	}

	public void setOptIp(String optIp) {
		this.optIp = optIp;
	}

	public String getOptMac() {
		return optMac;
	}

	public void setOptMac(String optMac) {
		this.optMac = optMac;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
}
