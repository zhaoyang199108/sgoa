package com.bcqsoft.sgoa.dao.addressbooktype.ibatis;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.addressbooktype.AddressBookTypeDAO;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookType;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;

/**
 * 通讯录表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_ADDRESS_BOOK_TYPE
 * </pre>
 */
@Repository
public class IbatisAddressBookTypeDAO extends BaseDAO implements AddressBookTypeDAO{

	/**
	 * 根据查询条件查询符合条件的通讯录分组
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-8
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AddressBookType> findAddressBookTypeInfoList(AddressBookTypePage page) {
		return (List<AddressBookType>) ibatis().queryForList("addressBookType.findAddressBookTypeInfoList",page);
	}

	/**
	 * 查找全部通讯录名称信息列表
	 * 
	 * @return 通讯录名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AddressBookType> findAllTypeInfo(AddressBookTypePage page) {
		return (List<AddressBookType>) ibatis().queryForList("addressBookType.findAllTypeInfo",page);
	}
	
	/**
	 * 插入一条信息至通讯录分组表
	 * 
	 * @param addressBookType
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-8
	 */
	public Long insertIntoAddressBookType(AddressBookType addressBookType) {
		return (Long) ibatis().insert("addressBookType.insertIntoAddressBookType",addressBookType);
	}

	/**
	 * 根据ID更新某条通讯录分组信息
	 * 
	 * @param addressBook
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-8
	 */
	public Integer updateAddressBookTypeInfoById(AddressBookType addressBookType) {
		return (Integer)ibatis().update("addressBookType.updateAddressBookTypeInfoById", addressBookType);
	}

	/**
	 * 根据ID删除某条通讯录分组信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-8
	 */
	public Integer updateAddressBookTypeStatusToDisabled(long id) {
		return (Integer)ibatis().update("addressBookType.updateAddressBookTypeStatusToDisabled",id);
	}

	

}