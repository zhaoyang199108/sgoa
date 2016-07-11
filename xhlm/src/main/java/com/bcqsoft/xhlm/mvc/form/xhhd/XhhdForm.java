package com.bcqsoft.xhlm.mvc.form.xhhd;

import java.util.Date;

import com.bcqsoft.xhlm.core.base.BaseForm;

public class XhhdForm extends BaseForm {

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
	 * 周期
	 */
	private String zq;

	/**
	 * 要求
	 */
	private String yq;

	/**
	 * 招牌
	 */
	private String zp;
	
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

	public String getZq() {
		return zq;
	}

	public void setZq(String zq) {
		this.zq = zq;
	}

	public String getYq() {
		return yq;
	}

	public void setYq(String yq) {
		this.yq = yq;
	}

	public String getZp() {
		return zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}
}