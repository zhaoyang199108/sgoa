package com.bcqsoft.sgoa.dao.alert.dataobject;

import java.util.Date;
import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 物资设备申领表ORM对象
 * 
 * <pre>
 * 表: WSOA_TB_APPROVAL
 * </pre>
 */
public class AlertPage extends BasePage {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -2440778511275466267L;
	/**
	 * 通讯录列表
	 */
	List<Alert> alertList;

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
	 * 登录人ID
	 */
	private String loginId;

	/**
	 * 业务关键词
	 */
	private String busId;

	/**
	 * 模块名称
	 */
	private String modeName;
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 提醒时间
	 */
	private String alertTime;

	/**
	 * 内容
	 */
	private String remark;

	/**
	 * 当前状态(1:未读, 2:已读)
	 */
	private Integer status;

	/**
	 * getter &&setter
	 */
	public List<Alert> getAlertList() {
		return alertList;
	}

	public void setAlertList(List<Alert> alertList) {
		this.alertList = alertList;
	}

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

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(String alertTime) {
		this.alertTime = alertTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
