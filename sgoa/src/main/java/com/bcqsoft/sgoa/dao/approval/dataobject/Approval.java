package com.bcqsoft.sgoa.dao.approval.dataobject;

import java.util.Date;

/**
 * 审批流程表ORM对象
 * 
 * <pre>
 * 表: WSOA_TB_APPROVAL
 * </pre>
 */
public class Approval {

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
	 * 审批流程名称
	 */
	private String approvalName;

	/**
	 * 审批流程分类
	 */
	private String approvalType;

	/**
	 * 是否有效
	 */
	private String enabled;
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
	private String steps;

	/**
	 * 职务
	 */
	private String positionId;

	/**
	 * getter &&setter
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

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getApprovalType() {
		return approvalType;
	}

	public void setApprovalType(String approvalType) {
		this.approvalType = approvalType;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
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

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
}
