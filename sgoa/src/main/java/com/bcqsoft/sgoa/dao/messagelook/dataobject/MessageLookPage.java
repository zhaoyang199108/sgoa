package com.bcqsoft.sgoa.dao.messagelook.dataobject;

import java.sql.Date;
import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 信息表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_MESSAGELOOK
 * </pre>
 */
public class MessageLookPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7750081675775739336L;

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
	 * 部门ID
	 */
	private String loginId;
	/**
	 * 公告通知ID
	 */
	private Long messageId;
	/**
	 * 部门名称
	 */
	private String loginName;
	
	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 查看状态
	 */
	private Integer status;
	/**
	 * 发文集合
	 */
	private List<MessageLook> messageLookList;

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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<MessageLook> getMessageLookList() {
		return messageLookList;
	}

	public void setMessageLookList(List<MessageLook> messageLookList) {
		this.messageLookList = messageLookList;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
