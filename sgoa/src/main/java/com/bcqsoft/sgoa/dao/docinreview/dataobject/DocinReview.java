package com.bcqsoft.sgoa.dao.docinreview.dataobject;

import java.util.Date;

/**
 * 收文审核表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_DOCIN_REVIEW
 * </pre>
 */
public class DocinReview {

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
	 * 当前操作人ID(关联SCOA_TB_USER.ID)
	 */
	private String currentOptId;

	/**
	 * 当前操作人姓名
	 */
	private String currentOptName;
	
	/**
	 * 通知公告ID(关联SCOA_TB_DOCIN.ID)
	 */
	private Long docinId;
	
	/**
	 * 意见
	 */
	private String opinion;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 执行动作(1:未读, 2:提交,3:否决, 4:批准, 5:提交申请, 6:归档)
	 */
	private Integer doAction;
	
	/**
	 * 自增型主键
	 */
	private Long stepId;
	
	/**
	 * 职务
	 */
	private String levelName;
	
	/**
	 * 位置
	 */
	private String seat;

	
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

	public Long getDocinId() {
		return docinId;
	}

	public void setDocinId(Long docinId) {
		this.docinId = docinId;
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

	public Integer getDoAction() {
		return doAction;
	}

	public void setDoAction(Integer doAction) {
		this.doAction = doAction;
	}

	public Long getStepId() {
		return stepId;
	}

	public void setStepId(Long stepId) {
		this.stepId = stepId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
}
