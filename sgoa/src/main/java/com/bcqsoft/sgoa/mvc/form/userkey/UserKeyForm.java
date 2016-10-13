package com.bcqsoft.sgoa.mvc.form.userkey;

import java.util.Date;

import com.bcqsoft.sgoa.core.base.BaseForm;

/**
 * 人员表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_USER
 * </pre>
 */
public class UserKeyForm extends BaseForm {

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
	 * 登录ID
	 */
	private String loginId;

	/**
	 * 设备ID
	 */
	private String serverIaguid;

	/**
	 * 种子码
	 */
	private String serverSeed;
	
	/**
	 * 摘要
	 */
	private String tridesKey;
	
	/**
	 * 随机数
	 */
	private String _RndData;

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

	public String getServerIaguid() {
		return serverIaguid;
	}

	public void setServerIaguid(String serverIaguid) {
		this.serverIaguid = serverIaguid;
	}

	public String getServerSeed() {
		return serverSeed;
	}

	public void setServerSeed(String serverSeed) {
		this.serverSeed = serverSeed;
	}

	public String getTridesKey() {
		return tridesKey;
	}

	public void setTridesKey(String tridesKey) {
		this.tridesKey = tridesKey;
	}

	public String get_RndData() {
		return _RndData;
	}

	public void set_RndData(String _RndData) {
		this._RndData = _RndData;
	}
}
