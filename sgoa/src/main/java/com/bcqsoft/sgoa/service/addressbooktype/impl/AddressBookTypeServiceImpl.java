package com.bcqsoft.sgoa.service.addressbooktype.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.addressbooktype.AddressBookTypeDAO;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookType;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;
import com.bcqsoft.sgoa.service.addressbooktype.AddressBookTypeService;

/**
 * 通讯录分组模块业务逻辑类实现类
 */
@Service
public class AddressBookTypeServiceImpl extends BaseService implements AddressBookTypeService{
	
	
	/**
	 * 通讯录表数据库访问DAO接口
	 */
	@Autowired
	private AddressBookTypeDAO addressBookTypeDAO;

	/**
	 * 根据查询条件查找通讯录分信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	@Override
	public AddressBookTypePage getAddressBookTypeListByPage(AddressBookTypePage page) {
		
		// 取得通讯录分组集合(分页查询)
		List<AddressBookType> addressBookTypeList = addressBookTypeDAO.findAddressBookTypeInfoList(page);
		page.setAddressTypeList(addressBookTypeList);//通讯录分组信息集合
		return page;
	}

	/**
	 * 创建一条新的通讯录分组
	 * 
	 * @param AddressBookType
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	public boolean creatAddressBookTypeInfo(AddressBookType addressBookType) {
		Long pk = addressBookTypeDAO.insertIntoAddressBookType(addressBookType);
		return isInsertSucc(pk);
	}
	
	/**
	 * 通讯录分组更新处理
	 * 
	 * @param AddressBook
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2013-5-7
	 */
	public boolean updateAddressBookTypeInfo(AddressBookType addressBookType) {
		Integer count = addressBookTypeDAO.updateAddressBookTypeInfoById(addressBookType);
		return isUpdateSucc(count);
	}
	/**
	 * 删除一条通讯录分组(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	public boolean deleteAddressBookTypeInfoById(long id) {
		Integer count =addressBookTypeDAO.updateAddressBookTypeStatusToDisabled(id);
		return isUpdateSucc(count);
	}

}