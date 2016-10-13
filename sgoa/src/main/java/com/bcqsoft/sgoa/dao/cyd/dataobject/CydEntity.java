package com.bcqsoft.sgoa.dao.cyd.dataobject;

import java.util.Date;

public class CydEntity {
	
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
	 * 文件编号1
	 */
	private String numFirst;

	/**
	 * 文件编号2
	 */
	private String numSecond;
	
	/**
	 * 文件编号3
	 */
	private String numThird;
	
	/**
	 * 文件编号4
	 */
	private String numFourth;
	
	/**
	 * 份数
	 */
	private Integer count;
	
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 用户ID
	 */
	private String createId;	

	/**
	 * 是否可用
	 */
	private Integer enabled;
	
	/**
	 * 用户Id数组
	 */
	private String[] userId;
	
	/**
	 * 送文时间数组
	 */
	private String[] outTime;
	
	/**
	 * 退文时间数组
	 */
	private String[] inTime;

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

	public String getNumFirst() {
		return numFirst;
	}

	public void setNumFirst(String numFirst) {
		this.numFirst = numFirst;
	}

	public String getNumSecond() {
		return numSecond;
	}

	public void setNumSecond(String numSecond) {
		this.numSecond = numSecond;
	}

	public String getNumThird() {
		return numThird;
	}

	public void setNumThird(String numThird) {
		this.numThird = numThird;
	}

	public String getNumFourth() {
		return numFourth;
	}

	public void setNumFourth(String numFourth) {
		this.numFourth = numFourth;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String[] getUserId() {
		return userId;
	}

	public void setUserId(String[] userId) {
		this.userId = userId;
	}

	public String[] getOutTime() {
		return outTime;
	}

	public void setOutTime(String[] outTime) {
		this.outTime = outTime;
	}

	public String[] getInTime() {
		return inTime;
	}

	public void setInTime(String[] inTime) {
		this.inTime = inTime;
	}
	public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}
}