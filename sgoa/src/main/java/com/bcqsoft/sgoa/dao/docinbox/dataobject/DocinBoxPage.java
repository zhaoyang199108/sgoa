package com.bcqsoft.sgoa.dao.docinbox.dataobject;

import java.sql.Date;
import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 信息表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_DOCINLOOK
 * </pre>
 */
public class DocinBoxPage extends BasePage {



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
	private Long docinId;

	/**
	 * 状态
	 */
	private Integer status;
	
	/**
	 * 办事情况
	 */
	private String stituation;
	
	/**
	 * 收文集合
	 */
	private List<DocinBox> docinBoxList;
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
	public Long getDocinId() {
		return docinId;
	}
	public void setDocinId(Long docinId) {
		this.docinId = docinId;
	}
	public List<DocinBox> getDocinBoxList() {
		return docinBoxList;
	}
	public void setDocinBoxList(List<DocinBox> docinBoxList) {
		this.docinBoxList = docinBoxList;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStituation() {
		return stituation;
	}
	public void setStituation(String stituation) {
		this.stituation = stituation;
	}

}
