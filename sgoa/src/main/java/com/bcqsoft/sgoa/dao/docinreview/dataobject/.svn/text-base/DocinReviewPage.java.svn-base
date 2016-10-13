package com.bcqsoft.sgoa.dao.docinreview.dataobject;

import java.util.Date;
import java.util.List;

/**
 * 收文审核表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_DOCIN_REVIEW
 * </pre>
 */
public class DocinReviewPage {
	
	/**
	 * 通知公告集合
	 */
	private List<DocinReview> docinReviewList;

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

	public List<DocinReview> getDocinReviewList() {
		return docinReviewList;
	}

	public void setDocinReviewList(List<DocinReview> docinReviewList) {
		this.docinReviewList = docinReviewList;
	}

}
