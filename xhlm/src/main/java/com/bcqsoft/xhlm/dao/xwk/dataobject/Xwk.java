package com.bcqsoft.xhlm.dao.xwk.dataobject;

import java.util.Date;

/**
 * 新闻库表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_SORT_XWK
 * </pre>
 */
public class Xwk {

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
	 * 标题
	 */
	private String title;

	/**
	 * 行业ID
	 */
	private String sortId;
	
	/**
	 * 行业名称
	 */
	private String sortName;
	
	/**
	 * 出处
	 */
	private String cc;
	
	/**
	 * 时间
	 */
	private String releaseDate;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 用户ID
	 */
	private String loginId;

	/**
	 * 是否是有效记录(Y:有效, N:无效)
	 */
	private String enabled;
	
	/**
	 * 对象(0:所有用户,1:协会用户,2:企业用户)
	 */
	private String type;

	/**
	 * get && set 方法
	 */
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

	public String getSortId() {
		return sortId;
	}

	public void setSortId(String sortId) {
		this.sortId = sortId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}	

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}
}