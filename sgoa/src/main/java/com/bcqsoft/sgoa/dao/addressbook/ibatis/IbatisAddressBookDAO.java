package com.bcqsoft.sgoa.dao.addressbook.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.addressbook.AddressBookDAO;
import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBook;
import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBookPage;

/**
 * 通讯录表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_ADDRESS_BOOK
 * </pre>
 */
@Repository
public class IbatisAddressBookDAO extends BaseDAO implements AddressBookDAO{

	/**
	 * 根据查询条件查询符合条件的通讯录数量(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	public Integer findAddressBookInfoCount(AddressBookPage page) {
		return (Integer) ibatis().queryForObject("addressBook.findAddressBookInfoCount",page);
	}
	
	/**
	 * 根据查询条件查询符合条件的通讯录
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	@SuppressWarnings("unchecked")
	public List<AddressBook> findAddressBookInfoList(AddressBookPage page) {
		return (List<AddressBook>) ibatis().queryForList("addressBook.findAddressBookInfoList",page);
	}
	
	/**
	 * 插入一条信息至通讯录表
	 * 
	 * @param addressbook
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	public Long insertIntoAddressBook(AddressBook addressbook) {
		return (Long) ibatis().insert("addressBook.insertIntoAddressBook",addressbook);
	}
	
	/**
	 * 根据ID查询通讯录的详细信息
	 * @param id
	 * @return  addressBook
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2013-5-6
	 */
	public AddressBook selectAddressBookById(long id) {
		
		return (AddressBook)ibatis().queryForObject("addressBook.selectAddressBookById" ,id);
	}

	/**
	 * 通过TYPE_ID查询同分组的通讯录列表
	 * 
	 * @return 同分组的通讯录列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AddressBook> getAddressBookList(long id) {
		return (List<AddressBook>) ibatis().queryForList("addressBook.getAddressBookList",id);
	}
	
	/**
	 * 根据ID更新某条通讯录信息
	 * 
	 * @param addressBook
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	public Integer updateAddressBookInfoById(AddressBook addressBook) {
		return (Integer)ibatis().update("addressBook.updateAddressBookInfoById", addressBook);
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
	public Integer updateAddressBookStatusToDisabled(long id) {
		return (Integer) ibatis().update("addressBook.updateAddressBookStatusToDisabled", id);
	}
}