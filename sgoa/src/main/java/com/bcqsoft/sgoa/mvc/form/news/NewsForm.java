package com.bcqsoft.sgoa.mvc.form.news;

import java.sql.Date;

import com.bcqsoft.sgoa.core.base.BaseForm;

public class NewsForm extends BaseForm {

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
	 * 标题
	 */
	private String title;

	/**
	 * 主题词
	 */
	private String subject;

	/**
	 * 发布时间
	 */
	private String textTime;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 内容ID（关联eweboffice_t_documentfile.D_RecordID）
	 */
	private String dRecordid;

	/**
	 * 当前流程ID(关联SCOA_TB_APPROVAL.ID)
	 */
	private String approvalId;

	/**
	 * 当前流程名称
	 */
	private String approvalName;

	/**
	 * 步骤
	 */
	private Integer step;

	/**
	 * 拟稿单位ID(关联SCOA_TB_DEPT.ID)
	 */
	private Long draftsDeptId;

	/**
	 * 拟稿部门名称
	 */
	private String draftsDeptName;

	/**
	 * 拟稿人ID(关联SCOA_TB_USER.ID)
	 */
	private String draftsId;

	/**
	 * 拟稿人姓名
	 */
	private String draftsName;

	/**
	 * 当前操作人ID(关联SCOA_TB_USER.ID)
	 */
	private String currentOptId;

	/**
	 * 当前操作人姓名
	 */
	private String currentOptName;

	/**
	 * 下一步操作人ID(关联SCOA_TB_USER.ID)
	 */
	private String nextOptId;

	/**
	 * 下一步操作人姓名
	 */
	private String nextOptName;

	/**
	 * 当前状态(1:未读, 2:提交,3:否决, 4:批准, 5:提交申请, 6:归档)
	 */
	private Integer status;

	/**
	 * 文件状态(1:正常, 2:草稿, 3:删除)
	 */
	private Integer enabled;

	/**
	 * 是否已读
	 */
	private String isRead;

	/**
	 * 登录人部门ID
	 */
	private String deptId;

	/**
	 * 通知公告ID(关联SCOA_TB_NEWS.ID)
	 */
	private Long newsId;

	/**
	 * 意见
	 */
	private String opinion;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTextTime() {
		return textTime;
	}

	public void setTextTime(String textTime) {
		this.textTime = textTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getdRecordid() {
		return dRecordid;
	}

	public void setdRecordid(String dRecordid) {
		this.dRecordid = dRecordid;
	}

	public String getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Long getDraftsDeptId() {
		return draftsDeptId;
	}

	public void setDraftsDeptId(Long draftsDeptId) {
		this.draftsDeptId = draftsDeptId;
	}

	public String getDraftsDeptName() {
		return draftsDeptName;
	}

	public void setDraftsDeptName(String draftsDeptName) {
		this.draftsDeptName = draftsDeptName;
	}

	public String getDraftsId() {
		return draftsId;
	}

	public void setDraftsId(String draftsId) {
		this.draftsId = draftsId;
	}

	public String getDraftsName() {
		return draftsName;
	}

	public void setDraftsName(String draftsName) {
		this.draftsName = draftsName;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Integer getDoAction() {
		return doAction;
	}

	public void setDoAction(Integer doAction) {
		this.doAction = doAction;
	}

	public String getNextOptId() {
		return nextOptId;
	}

	public void setNextOptId(String nextOptId) {
		this.nextOptId = nextOptId;
	}

	public String getNextOptName() {
		return nextOptName;
	}

	public void setNextOptName(String nextOptName) {
		this.nextOptName = nextOptName;
	}

	public Integer getEnabled() {
		return enabled;
	}
}