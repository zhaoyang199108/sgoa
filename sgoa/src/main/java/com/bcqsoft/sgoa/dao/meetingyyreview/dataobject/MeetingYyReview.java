package com.bcqsoft.sgoa.dao.meetingyyreview.dataobject;

import java.util.Date;

public class MeetingYyReview{

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
	 * 会议预约ID(关联SCOA_TB_MEETING_YY.ID)
	 */
	private Long yyId;
	
	/**
	 * 当前操作人ID(关联SCOA_TB_USER.ID)
	 */
	private String currentOptId;

	/**
	 * 当前操作人名称(关联SCOA_TB_USER.USER_NAME)
	 */
	private String currentOptName;

	/**
	 * 执行动作(1:未读, 2:提交,3:否决, 4:批准, 5:提交申请, 6:归档)
	 */
	private Integer doAction;

	/**
	 * 意见
	 */
	private String opinion;
	
	/**
	 * 备注
	 */
	private String remark;
	
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

	public Long getYyId() {
		return yyId;
	}

	public void setYyId(Long yyId) {
		this.yyId = yyId;
	}

	public Integer getDoAction() {
		return doAction;
	}

	public void setDoAction(Integer doAction) {
		this.doAction = doAction;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCurrentOptId() {
		return currentOptId;
	}

	public void setCurrentOptId(String currentOptId) {
		this.currentOptId = currentOptId;
	}

	public String getCurrentOptName() {
		return currentOptName;
	}

	public void setCurrentOptName(String currentOptName) {
		this.currentOptName = currentOptName;
	}

	
}