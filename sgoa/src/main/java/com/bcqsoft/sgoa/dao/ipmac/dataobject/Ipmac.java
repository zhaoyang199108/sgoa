package com.bcqsoft.sgoa.dao.ipmac.dataobject;

/**
 * IP/MAC表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_IPMAC
 * </pre>
 */
public class Ipmac {

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 创建日期
	 */
	private String createDate;

	/**
	 * 更新日期
	 */
	private String updateDate;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
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
