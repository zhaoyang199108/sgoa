package com.bcqsoft.sgoa.dao.newslook.dataobject;

import java.sql.Date;
import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 信息表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_NEWSLOOK
 * </pre>
 */
public class NewsLookPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7750081675775739336L;

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
	 * 部门ID
	 */
	private String loginId;

	/**
	 * 部门名称
	 */
	private String deptName;

	/**
	 * 公告通知ID
	 */
	private Long newsId;

	/**
	 * 部门名称
	 */
	private String loginName;

	/**
	 * 查看状态
	 */
	private Integer status;
	/**
	 * 发文集合
	 */
	private List<NewsLook> newsLookList;

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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<NewsLook> getNewsLookList() {
		return newsLookList;
	}

	public void setNewsLookList(List<NewsLook> newsLookList) {
		this.newsLookList = newsLookList;
	}
}