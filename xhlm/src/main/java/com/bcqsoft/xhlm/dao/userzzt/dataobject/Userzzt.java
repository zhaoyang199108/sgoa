package com.bcqsoft.xhlm.dao.userzzt.dataobject;

import java.util.Date;

/**
 * 资质图表ORM对象
 * 
 * <pre>
 * 表: XHLM_TB_USER_ZZT
 * </pre>
 */
public class Userzzt {

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
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 资质图
	 */
	private String aptitude;
	
	
	// get和set方法
	
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAptitude() {
		return aptitude;
	}

	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}

}
