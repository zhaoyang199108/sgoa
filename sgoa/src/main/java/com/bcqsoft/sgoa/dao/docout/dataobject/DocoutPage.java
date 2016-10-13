package com.bcqsoft.sgoa.dao.docout.dataobject;

import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 信息表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_DOCOUT
 * </pre>
 */
public class DocoutPage extends BasePage {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -2600809959357582130L;

	/**
	 * 拟稿人ID
	 */
	private String draftsId;

	/**
	 * 拟稿部门ID
	 */
	private Long draftsDeptId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 文件状态(1:正常, 2:草稿, 3:删除)
	 */
	private Integer enabled;

	/**
	 * 类别(1、通知，2、公告)
	 */
	private Integer sort;

	/**
	 * 当前操作人ID
	 */
	private String currentOptId;
	
	/**
	 * 下一步操作人ID(关联SCOA_TB_USER.ID)
	 */
	private String nextOptId;

	/**
	 * 当前状态(1:未读, 2:提交,3:否决, 4:批准, 5:提交申请, 6:归档)
	 */
	private Integer status;

	/**
	 * 通知公告集合
	 */
	private List<Docout> docoutList;

	/**
	 * 是否已读
	 */
	private String isRead;
	
	/**
	 * 登录人部门ID
	 */
	private String deptId;
	
	/**
	 * 发文字号
	 */
	private String docoutNum;
	/**
	 * 收件人
	 */
	private String receivedId;
	/**
	 * Getter And Setter
	 */

	public String getDraftsId() {
		return draftsId;
	}

	public void setDraftsId(String draftsId) {
		this.draftsId = draftsId;
	}

	public Long getDraftsDeptId() {
		return draftsDeptId;
	}

	public void setDraftsDeptId(Long draftsDeptId) {
		this.draftsDeptId = draftsDeptId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Docout> getDocoutList() {
		return docoutList;
	}

	public void setDocoutList(List<Docout> docoutList) {
		this.docoutList = docoutList;
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

	public String getNextOptId() {
		return nextOptId;
	}

	public void setNextOptId(String nextOptId) {
		this.nextOptId = nextOptId;
	}

	public String getDocoutNum() {
		return docoutNum;
	}

	public void setDocoutNum(String docoutNum) {
		this.docoutNum = docoutNum;
	}

	public String getReceivedId() {
		return receivedId;
	}

	public void setReceivedId(String receivedId) {
		this.receivedId = receivedId;
	}
	
}
