package com.bcqsoft.sgoa.dao.addressbook;

import java.util.List;

import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBook;
import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBookPage;

/**
 * 通讯录表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_ADDRESS_BOOK
 * </pre>
 */
public interface AddressBookDAO{

	/**
	 * 根据查询条件查询符合条件的通讯录数量(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	Integer findAddressBookInfoCount(AddressBookPage page);

	/**
	 * 根据查询条件查询符合条件的通讯录
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	List<AddressBook> findAddressBookInfoList(AddressBookPage addressBookPage);

	/**
	 * 插入一条信息至通讯录表
	 * 
	 * @param AddressBookType
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */

	Long insertIntoAddressBook(AddressBook addressbook);

	/**
	 * 根据ID查询通讯录的详细信息
	 * 
	 * @param id
	 * @return addressBook
	 * 
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date  2013-5-6
	 */
	AddressBook selectAddressBookById(long id);

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
	 * 根据ID更新某条通讯录信息
	 * 
	 * @param addressBook
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	Integer updateAddressBookInfoById(AddressBook addressBook);

	/**
	 * 通讯录人员删除处理
	 * 
	 * @param map
	 * @return 更新通讯录人员成功页面
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	Integer updateAddressBookStatusToDisabled(long id);
	
}