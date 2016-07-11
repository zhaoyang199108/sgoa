package com.bcqsoft.xhlm.dao.userzzt.dataobject;

import java.util.Date;
import java.util.List;

import com.bcqsoft.xhlm.core.base.BasePage;

/**
 * 资质图表ORM对象
 * 
 * <pre>
 * 表: XHLM_TB_USER_ZZT
 * </pre>
 */
public class UserzztPage extends BasePage {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 8132078471504897056L;
	
	/**
	 * 资质图集合
	 */
	private List<Userzzt> userzztList;
	
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
	private String userId;
	
	/**
	 * 资质图
	 */
	private String aptitude;
	

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

	public List<Userzzt> getUserzztList() {
		return userzztList;
	}

	public void setUserzztList(List<Userzzt> userzztList) {
		this.userzztList = userzztList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAptitude() {
		return aptitude;
	}

	public void setAptitude(String aptitude) {
		this.aptitude = aptitude;
	}
}
