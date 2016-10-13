package com.bcqsoft.sgoa.mvc.controller.addressbooktype;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookType;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;
import com.bcqsoft.sgoa.mvc.form.addressbooktype.AddressBookTypeForm;
import com.bcqsoft.sgoa.service.addressbooktype.AddressBookTypeService;

/**
 * 通讯录分组模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class AddressBookTypeController {
	
	/**
	 * 通讯录分组的业务逻辑层
	 */
	@Autowired
	private AddressBookTypeService addressBookTypeService;
	

	/**
	 * 取得有效的通讯录列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	@RequestMapping("/addressBookType/list.htm")
	public String selectAddressBookTypeListByPage(ModelMap map) {
		AddressBookTypePage addressBookTypePage = new AddressBookTypePage(); //分页对象
		addressBookTypePage.setLoginId(SecurityUtils.getLoginId()); //登录ID
		 //取得通讯录分组列表，分页显示
		AddressBookTypePage page = addressBookTypeService.getAddressBookTypeListByPage(addressBookTypePage);
		map.put("page", page); //保存页面渲染数据
		map.put("typeSize", page.getAddressTypeList().size());   
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "add_ressbooktype");
	    //跳转至通讯录列表页面
		return "addressbooktype/addressBookType_list";
	}

	/**
	 * 通讯录分组更新处理
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	@RequestMapping("/addressBookType/edit_addressBookType.htm")
	public String editAddressBookType(Long id, Integer sorting, String typeName,ModelMap map) {
		AddressBookType addressBookType = new AddressBookType();
		addressBookType.setId(id); //设置ID
		addressBookType.setSorting(sorting); //设置排序号
		addressBookType.setTypeName(typeName); //设置分组名称
		addressBookType.setEnabled(AddressBookType.ABLED);// 设置记录为有效记录
		addressBookType.setLoginId(SecurityUtils.getLoginId()); // 设置登录Id
		if(id == null||id == 0){
	    //新增分组表信息
	    addressBookTypeService.creatAddressBookTypeInfo(addressBookType);	
		}
		else{
		//更新分组表信息
		addressBookTypeService.updateAddressBookTypeInfo(addressBookType);
		}
		AddressBookTypePage addressBookTypePage = new AddressBookTypePage(); //分页对象
		addressBookTypePage.setLoginId(SecurityUtils.getLoginId()); //登录ID
		 //取得通讯录分组列表，分页显示
		AddressBookTypePage page = addressBookTypeService.getAddressBookTypeListByPage(addressBookTypePage);
		map.put("page", page); //保存页面渲染数据
		map.put("typeSize", page.getAddressTypeList().size());
		return "addressbooktype/addressBookType_list";
	}

	/**
	 * 通讯录分组删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新通讯录分组成功页面
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	@RequestMapping("/addressBookType/delete.htm")
	public String delectAddressBookType(long id,ModelMap map) {
		addressBookTypeService.deleteAddressBookTypeInfoById(id);
		AddressBookTypePage addressBookTypePage = new AddressBookTypePage(); //分页对象
		addressBookTypePage.setLoginId(SecurityUtils.getLoginId()); //登录ID
		 //取得通讯录分组列表，分页显示
		AddressBookTypePage page = addressBookTypeService.getAddressBookTypeListByPage(addressBookTypePage);
		map.put("page", page); //保存页面渲染数据
		map.put("typeSize", page.getAddressTypeList().size());
		return "addressbooktype/addressBookType_list";

	}
	
	/**
	 * 跳转至左菜单页面
	 * 
	 * @return 左菜单
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	@RequestMapping("/addressBook/menu.htm")
	public String menu(AddressBookTypeForm form,ModelMap map) {
		AddressBookTypePage addressBookTypePage = new AddressBookTypePage(); //分页对象
		setSearchKey(form,addressBookTypePage); //设置页面中的查询条件
		 //取得通讯录分组列表，分页显示
		AddressBookTypePage page = addressBookTypeService.getAddressBookTypeListByPage(addressBookTypePage);
		map.put("page", page); //保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "add_ressbooktype");
		return "addressbook/menu";
	}
	
	/**
	 * 通讯录列表页面设置查询条件
	 * 
	 * @param form
	 * @param AddressBookTypePage
	 * 
	 * @Author cql
	 * @Date 2013-5-3
	 */
	private void setSearchKey(AddressBookTypeForm form, AddressBookTypePage addressBookTypePage) {
		addressBookTypePage.setCurrentPage(form.getCp()); //当前页数
		addressBookTypePage.setLoginId(SecurityUtils.getLoginId()); //登录ID
	}
}
