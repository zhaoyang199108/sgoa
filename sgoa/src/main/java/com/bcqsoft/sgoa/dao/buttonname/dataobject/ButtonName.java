package com.bcqsoft.sgoa.dao.buttonname.dataobject;

import java.util.Date;

/**
 * 部门科室表(记录当前单位科室及下属单位科室)ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_DEPT
 * </pre>
 */
public class ButtonName {

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
	 * 职务ID(关联职务表)
	 */
	private Long positionId;
	
	/**
	 * 职务ID(关联职务表)
	 */
	private String grpoName;
	
	/**
	 * 按钮名称
	 */
	private String btnName;
	
	/**
	 * 模块名称
	 */
	private String module;
	
	/**
	 * 模块页面类型名称
	 */
	private String moduleType;

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

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getGrpoName() {
		return grpoName;
	}

	public void setGrpoName(String grpoName) {
		this.grpoName = grpoName;
	}
}
