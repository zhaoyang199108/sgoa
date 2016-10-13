package com.bcqsoft.sgoa.service.addressbook.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.addressbook.AddressBookDAO;
import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBook;
import com.bcqsoft.sgoa.dao.addressbooktype.AddressBookTypeDAO;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookType;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;
import com.bcqsoft.sgoa.service.addressbook.AddressBookService;

/**
 * 通讯录模块业务逻辑类实现类
 */
@Service
public class AddressBookServiceImpl extends BaseService implements AddressBookService {

	/**
	 * 通讯录表数据库访问DAO接口
	 */
	@Autowired
	private AddressBookDAO addressBookDAO;

	/**
	 * 通讯录表数据库访问DAO接口
	 */
	@Autowired
	private AddressBookTypeDAO addressBookTypeDAO;

	/**
	 * 创建一条新的通讯录
	 * 
	 * @param AddressBookType
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	public boolean creatAddressBookInfo(AddressBook addressbook) {
		Long pk = addressBookDAO.insertIntoAddressBook(addressbook);
		return isInsertSucc(pk);
	}

	/**
	 * 根据ID查询通讯录
	 * 
	 * @param id
	 * @return addressBook
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	public AddressBook selectAddressBookById(long id) {
		return addressBookDAO.selectAddressBookById(id);
	}

	/**
	 * 查找全部通讯录名称信息列表
	 * 
	 * @return 通讯录名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	@Override
	public AddressBookTypePage findAllTypeInfo(AddressBookTypePage page) {
		// 取得通讯录分组集合(分页查询)
		List<AddressBookType> addressBookTypeList = addressBookTypeDAO.findAllTypeInfo(page);
		page.setAddressTypeList(addressBookTypeList);// 通讯录分组信息集合
		return page;
	}

	/**
	 * 通过TYPE_ID查询同分组的通讯录列表
	 * 
	 * @return 同分组的通讯录列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	@Override
	public List<AddressBook> getAddressBookList(long id) {
		return addressBookDAO.getAddressBookList(id);
	}

	/**
	 * 通讯录更新处理
	 * 
	 * @param AddressBook
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2013-5-7
	 */
	public boolean updateAddressBookInfo(AddressBook addressBook) {
		Integer count = addressBookDAO.updateAddressBookInfoById(addressBook);
		return isUpdateSucc(count);
	}

	/**
	 * 通讯录人员删除处理
	 * 
	 * @param map
	 * @return 更新通讯录人员成功页面
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	@Override
	public boolean deleteAddressbook(long id) {
		Integer count = addressBookDAO.updateAddressBookStatusToDisabled(id);
		return isUpdateSucc(count);
	}

}