package com.bcqsoft.sgoa.dao.cyddetail.dataobject;

import java.util.Date;
import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;
import com.bcqsoft.sgoa.dao.cyddetail.dataobject.CydDetail;

public class CydDetailPage extends BasePage{

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 4685024541044263324L;
	
	/**
	 * 通讯录集合
	 */
	List<CydDetail> cydDetailList;

	public List<CydDetail> getCydDetailList() {
		return cydDetailList;
	}

	public void setCydDetailList(List<CydDetail> cydDetailList) {
		this.cydDetailList = cydDetailList;
	}
	
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
	 * 传阅单Id
	 */
	private Long cydId;

	/**
	 * 用户Id
	 */
	private String userId;
	
	/**
	 * 送文时间
	 */
	private String outTime;
	
	/**
	 * 退文时间
	 */
	private String inTime;

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

	public Long getCydId() {
		return cydId;
	}

	public void setCydId(Long cydId) {
		this.cydId = cydId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
}