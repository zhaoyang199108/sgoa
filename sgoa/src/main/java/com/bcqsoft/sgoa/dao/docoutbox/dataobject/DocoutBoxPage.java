package com.bcqsoft.sgoa.dao.docoutbox.dataobject;

import java.sql.Date;
import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 信息表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_DOCOUTLOOK
 * </pre>
 */
public class DocoutBoxPage extends BasePage {



	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -5809082392717706400L;

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
	 * 收件人ID
	 */
	private String receiverId;
	/**
	 * 收件人名称
	 */
	private String loginName;
	/**
	 * 公告通知ID
	 */
	private Long docoutId;

	/**
	 * 查看状态
	 */
	private Integer enabled;
	/**
	 * 发文集合
	 */
	private List<DocoutBox> docoutBoxList;
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
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Long getDocoutId() {
		return docoutId;
	}
	public void setDocoutId(Long docoutId) {
		this.docoutId = docoutId;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public List<DocoutBox> getDocoutBoxList() {
		return docoutBoxList;
	}
	public void setDocoutBoxList(List<DocoutBox> docoutBoxList) {
		this.docoutBoxList = docoutBoxList;
	}

}
