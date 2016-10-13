package com.bcqsoft.sgoa.dao.message.dataobject;

import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 信息表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_MESSAGE
 * </pre>
 */
public class MessagePage extends BasePage {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -6216970780063519018L;

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
	private List<Message> messageList;

	/**
	 * 是否已读
	 */
	private String isRead;
	
	/**
	 * 登录人部门ID
	 */
	private String deptId;
	
	/**
	 * 原附件名称
	 */
	private String srcFileName;

	/**
	 * 附件路径(服务器相对路径, 例/abc/2011/dddkk.zip)
	 */
	private String fileDir;
	
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

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
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
	
}
