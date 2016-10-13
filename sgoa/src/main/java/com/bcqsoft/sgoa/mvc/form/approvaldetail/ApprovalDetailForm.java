package com.bcqsoft.sgoa.mvc.form.approvaldetail;

import java.util.Date;

import com.bcqsoft.sgoa.core.base.BaseForm;

/**
 * 审批流程表ORM对象
 * 
 * <pre>
 * 表: WSOA_TB_APPROVAL_DETAIL
 * </pre>
 */
public class ApprovalDetailForm extends BaseForm {

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
	 * 审批ID
	 */
	private String detailId;
	
	/**
	 * 父节点
	 */
	private Long pId;

	/**
	 * 职务ID
	 */
	private Long positionId;
	
	/**
	 * 职务名
	 */
	private String grpoName;
	
	/**
	 * 判断是否有审批权限
	 */
	private String status;
	
	/**
	 * 是否有效
	 */
	private String enabled;

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

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getGrpoName() {
		return grpoName;
	}

	public void setGrpoName(String grpoName) {
		this.grpoName = grpoName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
