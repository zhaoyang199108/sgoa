package com.bcqsoft.sgoa.service.addressbooktype;


import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookType;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;


/**
 * 通讯录分组模块业务逻辑类接口
 */
@Service
public interface AddressBookTypeService {

	/**
	 * 根据查询条件查找通讯录分信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	AddressBookTypePage getAddressBookTypeListByPage(AddressBookTypePage addressBookTypePage);
	
	/**
	 * 创建一条新的通讯录分组
	 * 
	 * @param AddressBookType
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	boolean creatAddressBookTypeInfo(AddressBookType addressBookType);
	/**
	 * 通讯录分组更新处理
	 * 
	 * @param AddressBookType
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2013-5-7
	 */

	boolean updateAddressBookTypeInfo(AddressBookType addressBookType);
	
	/**
	 * 删除一条通讯录分组(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */

	boolean deleteAddressBookTypeInfoById(long id);



	
}