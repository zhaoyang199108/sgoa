package com.bcqsoft.xhlm.mvc.form.qytm;

import java.util.Date;

import com.bcqsoft.xhlm.core.base.BaseForm;

/**
 * 企业条目模块form表单对象
 * 
 * @author 2013-9-12 cql
 * 
 */
public class QytmForm extends BaseForm {
	// Enabled字段值(N:不可用, Y:可用)
	public static final String DISABLED = "N";
	public static final String ABLED = "Y";
	/**
	 * 企业条目表ID(PK)
	 */
	private long id;

	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 更新时间
	 */
	private Date updateDate;

	/**
	 * 条目
	 */
	private String tmname;
	
	/**
	 * 类型
	 */
	private String lx;
	
	/**
	 * 创建人ID
	 */
	private String loginId;
	
	/**
	 * 创建人
	 */
	private String userName;
	
	/**
	 * 是否有效(Y:有效, N:无效)
	 */
	private String enabled;

	/**
	 * ===================<br>
	 * Getter&Setter<br>
	 * ===================
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getTmname() {
		return tmname;
	}

	public void setTmname(String tmname) {
		this.tmname = tmname;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
