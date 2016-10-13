package com.bcqsoft.sgoa.dao.addressbooktype;

import java.util.List;

import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookType;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;


/**
 * 通讯录表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_ADDRESS_BOOK_TYPE
 * </pre>
 */
public interface AddressBookTypeDAO{
	
	/**
	 * 根据查询条件查询符合条件的通讯录分组
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-8
	 */
	List<AddressBookType> findAddressBookTypeInfoList(AddressBookTypePage page);

	/**
	 * 查找全部通讯录名称信息列表
	 * 
	 * @return 通讯录名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-8
	 */
	List<AddressBookType> findAllTypeInfo(AddressBookTypePage page);
	
	/**
	 * 插入一条信息至通讯录表分组
	 * 
	 * @param AddressBookType
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-8
	 */

	Long insertIntoAddressBookType(AddressBookType addressBookType);

	/**
	 * 根据ID更新某条通讯录分组信息
	 * 
	 * @param AddressBookType
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-8
	 */
	Integer updateAddressBookTypeInfoById(AddressBookType addressBookType);

	/**
	 * 根据ID删除某条通讯录分组信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-8
	 */

	Integer updateAddressBookTypeStatusToDisabled(long id);


}