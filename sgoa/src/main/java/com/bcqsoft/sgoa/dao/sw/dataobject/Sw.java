package com.bcqsoft.sgoa.dao.sw.dataobject;

import java.util.Date;

/**
 * 信息表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_DOCIN
 * </pre>
 */
public class Sw {

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
	 * 全宗号
	 */
	private String fondsNum;
	
	/**
	 * 全宗名称
	 */
	private String fondsName;

	/**
	 * 成文时间
	 */
	private String textTime;
	
	/**
	 * 收文时间
	 */
	private String receiverTime;
	
	/**
	 * 缓急
	 */
	private Integer urgent;
	
	/**
	 * 密级
	 */
	private Integer security;
	
	/**
	 * 来文单位
	 */
	private String fileDept;
	
	/**
	 * 文件编号
	 */
	private String fileNum;
	
	/**
	 * 登记号
	 */
	private String registerNum;
	
	/**
	 * 是否督办
	 */
	private Integer supervise;
	
	/**
	 * 原附件名称
	 */
	private String srcFileName;

	/**
	 * 附件路径(服务器相对路径, 例/abc/2011/dddkk.zip)
	 */
	private String fileDir;
	

	/**
	 * 当前流程ID(关联SCOA_TB_APPROVAL.ID)
	 */
	private String approvalIds;

	/**
	 * 步骤
	 */
	private Integer steps;
	
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
	 * 类别(1、通知，2、公告)
	 */
	private Integer sort;

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
	 * 意见
	 */
	private String opinion;

	/**
	 * 执行动作(1:未读, 2:提交,3:否决, 4:批准, 5:提交申请, 6:归档)
	 */
	private Integer doAction;
	/**
	 * 内容
	 */
	private byte[] content;
	/**
	 * 收件人ID
	 */
	private String receiverId;
	/**
	 * 收件人名称
	 */
	private String receiverName;
	
	/**
	 * 收件人ID(关联SCOA_TB_USER.ID,多个收件ID,中间使用半角分号区分,例:abc;ggg)
	 */
	private String receiverIds;
	
	/**
	 * 收件人名字
	 */
	private String receiverNames;
	
	/**
	 * 用户ID
	 */
	private String loginId;
	
	/**
	 * 用户
	 */
	private String loginName;
	/**
	 * 回执状态
	 */
	private String boxStatus;
	
	/**
	 * getter和setter方法
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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

	public Integer getEnabled() {
		return enabled;
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

	public String getdRecordid() {
		return dRecordid;
	}

	public void setdRecordid(String dRecordid) {
		this.dRecordid = dRecordid;
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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Integer getUrgent() {
		return urgent;
	}

	public void setUrgent(Integer urgent) {
		this.urgent = urgent;
	}

	public Integer getSecurity() {
		return security;
	}

	public void setSecurity(Integer security) {
		this.security = security;
	}

	public String getApprovalIds() {
		return approvalIds;
	}

	public void setApprovalIds(String approvalIds) {
		this.approvalIds = approvalIds;
	}

	public Integer getSteps() {
		return steps;
	}

	public void setSteps(Integer steps) {
		this.steps = steps;
	}

	public String getFondsNum() {
		return fondsNum;
	}

	public void setFondsNum(String fondsNum) {
		this.fondsNum = fondsNum;
	}

	public String getFondsName() {
		return fondsName;
	}

	public void setFondsName(String fondsName) {
		this.fondsName = fondsName;
	}

	public String getReceiverTime() {
		return receiverTime;
	}

	public void setReceiverTime(String receiverTime) {
		this.receiverTime = receiverTime;
	}

	public String getFileDept() {
		return fileDept;
	}

	public void setFileDept(String fileDept) {
		this.fileDept = fileDept;
	}

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	public String getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}

	public Integer getSupervise() {
		return supervise;
	}

	public void setSupervise(Integer supervise) {
		this.supervise = supervise;
	}

	public String getSrcFileName() {
		return srcFileName;
	}

	public void setSrcFileName(String srcFileName) {
		this.srcFileName = srcFileName;
	}

	public String getFileDir() {
		return fileDir;
	}

	public void setFileDir(String fileDir) {
		this.fileDir = fileDir;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getBoxStatus() {
		return boxStatus;
	}

	public void setBoxStatus(String boxStatus) {
		this.boxStatus = boxStatus;
	}

	public String getReceiverIds() {
		return receiverIds;
	}

	public void setReceiverIds(String receiverIds) {
		this.receiverIds = receiverIds;
	}

	public String getReceiverNames() {
		return receiverNames;
	}

	public void setReceiverNames(String receiverNames) {
		this.receiverNames = receiverNames;
	}
	
}
