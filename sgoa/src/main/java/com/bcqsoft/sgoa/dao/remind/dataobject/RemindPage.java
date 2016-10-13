package com.bcqsoft.sgoa.dao.remind.dataobject;

import java.util.Date;
import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 消息中心表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_REMIND
 * </pre>
 */
public class RemindPage extends BasePage {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -2440778511275466267L;
	
	/**
	 * 消息中心列表
	 */
	List<Remind> remindList;

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
	private Long busId;

	/**
	 * 模块名称
	 */
	private String modeName;
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 跳转地址
	 */
	private String url;

	/**
	 * 当前状态(1:提醒, 2:暂不提醒 ,3:不提醒)
	 */
	private Integer status;
	
	/**
	 * 日程开始时间(格式: 2011-12-16 10:30:55)
	 */
	private String startTime;

	/**
	 * 日程结束时间(格式: 2011-12-16 10:30:55)
	 */
	private String endTime;

	/**
	 * getter &&setter
	 */
	public List<Remind> getRemindList() {
		return remindList;
	}

	public void setRemindList(List<Remind> remindList) {
		this.remindList = remindList;
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

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
