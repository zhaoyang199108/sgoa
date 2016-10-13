package com.bcqsoft.sgoa.dao.addressbook.dataobject;

import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

public class AddressBookPage extends BasePage{
	
	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -5622021560288626237L;
	
	/**
	 * 通讯录集合
	 */
	List<AddressBook> addressList;
	
	/**
	 * 登录ID
	 */
	private String loginId;
	
	/**
	 * 姓名
	 */
	private String addName;
	
	/**
	 * 生成Getter和Setter方法
	 */

	public List<AddressBook> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressBook> addressList) {
		this.addressList = addressList;
	}
	
	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
}