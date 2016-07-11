package com.bcqsoft.xhlm.dao.userdetail.dataobject;

import java.util.Date;
import java.util.List;

import com.bcqsoft.xhlm.core.base.BasePage;

/**
 * 用户详细表ORM对象
 * 
 * <pre>
 * 表: XHLM_TB_USER_DETAIL
 * </pre>
 */
public class UserdetailPage extends BasePage {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 6705948302633054735L;

	/**
	 * 用户详细集合
	 */
	private List<Userdetail> userdetailList;

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
	 * 服务ID
	 */
	private String xhfwId;

	/**
	 * 用户ID
	 */
	private String loginId;

	/**
	 * 用户名称
	 */
	private String userName;

	/**
	 * 是否是有效记录(Y:有效, N:无效)
	 */
	private String enabled;

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

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getXhfwId() {
		return xhfwId;
	}

	public void setXhfwId(String xhfwId) {
		this.xhfwId = xhfwId;
	}

	public List<Userdetail> getUserdetailList() {
		return userdetailList;
	}

	public void setUserdetailList(List<Userdetail> userdetailList) {
		this.userdetailList = userdetailList;
	}
}