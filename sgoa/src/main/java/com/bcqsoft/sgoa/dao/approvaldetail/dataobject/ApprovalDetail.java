package com.bcqsoft.sgoa.dao.approvaldetail.dataobject;

import java.util.Date;

/**
 * 物资设备申领表ORM对象
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public class ApprovalDetail {

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
	 * 审批步骤名称
	 */
	private String detailName;

	/**
	 * 审批ID
	 */
	private String detailId;

	/**
	 * 步骤
	 */
	private Long pId;
	
	/**
	 * 审批人
	 */
	private Long positionId;
	
	/**
	 * 审批人职务名称
	 */
	private String grpoName;
	
	/**
	 * 判断是否有审批权限
	 */
	private String status;
	/**
	 * 审批人名称
	 */
	private String draftsName;

	/**
	 * 是否有效
	 */
	private String enabled;

	// get和set方法

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

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDraftsName() {
		return draftsName;
	}

	public void setDraftsName(String draftsName) {
		this.draftsName = draftsName;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getGrpoName() {
		return grpoName;
	}

	public void setGrpoName(String grpoName) {
		this.grpoName = grpoName;
	}

}
