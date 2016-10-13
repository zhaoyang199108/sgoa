package com.bcqsoft.sgoa.mvc.result;


/**
 * 审批流程对象
 * 
 * <pre>
 * 审批返回结果
 * </pre>
 */
public class WorkFlow {

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 审批流程名称
	 */
	private String approvalName;

	/**
	 * 步骤
	 */
	private String steps;

	/**
	 * 审批人
	 */
	private String loginId;
	
	/**
	 * 审批人名称
	 */
	private String draftsName;

	/**
	 * 颜色
	 */
	private String color;

	/**
	 * 执行动作(1:未读, 2:提交,3:否决, 4:批准, 5:提交申请, 6:归档)
	 */
	private Integer doAction;

	/**
	 * getter &&setter
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getDraftsName() {
		return draftsName;
	}

	public void setDraftsName(String draftsName) {
		this.draftsName = draftsName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getDoAction() {
		return doAction;
	}

	public void setDoAction(Integer doAction) {
		this.doAction = doAction;
	}
}
