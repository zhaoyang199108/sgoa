package com.bcqsoft.sgoa.service.addressbook;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBook;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;

/**
 * 通讯录模块业务逻辑类接口
 */
@Service
public interface AddressBookService {
	
	/**
	 * 创建一条新的通讯录
	 * 
	 * @param AddressBookType
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	boolean creatAddressBookInfo(AddressBook addressbook);

	/**
	 * 根据ID查询通讯录的详细信息
	 * @param id
	 * @return  addressBook
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2013-5-6
	 */
	AddressBook selectAddressBookById(long id);
	
	/**
	 * 查找全部通讯录名称信息列表
	 * 
	 * @return 通讯录名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	AddressBookTypePage findAllTypeInfo(AddressBookTypePage addressBookTypePage);

	/**
	 * 通过TYPE_ID查询同分组的通讯录列表
	 * 
	 * @return 同分组的通讯录列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	List<AddressBook> getAddressBookList(long id);
	
	/**
	 * 通讯录更新处理
	 * 
	 * @param AddressBook
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date  2013-5-7
	 */

	boolean updateAddressBookInfo(AddressBook addressBook);

	/**
	 * 通讯录人员删除处理
	 * 
	 * @param map
	 * @return 更新通讯录人员成功页面
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	boolean deleteAddressbook(long id);

	
	
	
}