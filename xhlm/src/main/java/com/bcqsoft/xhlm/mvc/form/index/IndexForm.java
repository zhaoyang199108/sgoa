package com.bcqsoft.xhlm.mvc.form.index;

import java.util.Date;

import com.bcqsoft.xhlm.core.base.BaseForm;

/**
 * 医院科室模块form表单对象
 * 
 * @author 2013-9-12 cql
 * 
 */
public class IndexForm extends BaseForm {
	// Enabled字段值(N:不可用, Y:可用)
	public static final String DISABLED = "N";
	public static final String ABLED = "Y";
	/**
	 * 医院科室表ID(PK)
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
	 * 医院ID
	 */
	private String hospitalId;
	
	/**
	 * 医院名称
	 */
	private String hospitalName;
	
	/**
	 * 科室名称
	 */
	private String title;
	
	/**
	 * 是否可用
	 */
	private String isuse;

	/**
	 * 创建人ID
	 */
	private String createrId;
	
	/**
	 * 创建人
	 */
	private String userName;
	
	/**
	 * 科室介绍
	 */
	private String remark;

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

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsuse() {
		return isuse;
	}

	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
