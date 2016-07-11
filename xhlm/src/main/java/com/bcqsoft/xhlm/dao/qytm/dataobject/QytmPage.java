package com.bcqsoft.xhlm.dao.qytm.dataobject;

import java.util.List;

import com.bcqsoft.xhlm.core.base.BasePage;



/**
 * 企业条目数据库访问ORM_DO对象
 * 
 * <pre>
 * TABLE: XHLM_TB_QYTM
 * </pre>
 */
public class QytmPage extends BasePage {
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 4042573930437712371L;
	
	/**
	 * 企业条目结合
	 */

	private List<Qytm> qytmList;
	
	/**
	 * 条目
	 */
	private String tmname;
	
	/**
	 * 创建人ID
	 */
	private String loginId;
	
	/**
	 * 创建人
	 */
	private String userName;
	
	/**
	 * 类型
	 */
	private String lx;
	
	/**
	 * Getter&Setter
	 */
	
	public String getTmname() {
		return tmname;
	}

	public void setTmname(String tmname) {
		this.tmname = tmname;
	}

	public List<Qytm> getQytmList() {
		return qytmList;
	}

	public void setQytmList(List<Qytm> qytmList) {
		this.qytmList = qytmList;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
