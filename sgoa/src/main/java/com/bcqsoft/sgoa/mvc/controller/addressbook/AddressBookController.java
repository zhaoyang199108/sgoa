package com.bcqsoft.sgoa.mvc.controller.addressbook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.common.util.PinyinUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBook;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;
import com.bcqsoft.sgoa.mvc.form.addressbook.AddressBookForm;
import com.bcqsoft.sgoa.service.addressbook.AddressBookService;

/**
 * 通讯录模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class AddressBookController {
	
	/**
	 * 通讯录的业务逻辑层
	 */
	@Autowired
	private AddressBookService addressBookService;
	
	
	/**
	 * 初始化页面框架
	 * 
	 * @author cql
	 * @date 2013-5-7
	 * @return String
	 */
	@RequestMapping("/addressBook/addrmain.htm")
	public String initMain() {
		return "addressbook/addrmain";
	}
	

	/**
	 * 通过TYPE_ID查询同分组的通讯录列表
	 * 
	 * @return 同分组的通讯录列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-7
	 */
	@RequestMapping(value="/addressBook/list.htm" , method = RequestMethod.GET)
	public String selectAddressBookListByPage(long id, ModelMap map) {
	    if(id == 0){
	    	map.put("addressBookList", new ArrayList<AddressBook>());
	    }
	    else{
		List<AddressBook> addressBookList = addressBookService.getAddressBookList(id);
	    map.put("addressBookList", addressBookList); //保存页面渲染数据
	    }
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "addressbook_list");
	    //跳转至通讯录列表页面
		return "addressbook/addressBook_list";
	}
	
	
	/**
	 * 跳转到通讯录的添加页面
	 * 
	 * @return 通讯录的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	@RequestMapping(value = "/addressBook/add_addressBook.htm", method = RequestMethod.GET)
	public String addAddressBook(ModelMap map) {
		AddressBookTypePage addressBookTypePage = new AddressBookTypePage();
		addressBookTypePage.setLoginId(SecurityUtils.getLoginId());
		AddressBookTypePage addressBookTypePages = addressBookService.findAllTypeInfo(addressBookTypePage);
		map.put("addressBookTypePages", addressBookTypePages);//取得分组列表
		return "addressbook/add_addressBook";
	}

	/**
	 * 通讯录新增处理
	 * 
	 * @param map
	 * @return 通讯录的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	@RequestMapping("/addressBook/add_addressBook.htm")
	public String addAddressBook(AddressBookForm form) {
		addressBookService.creatAddressBookInfo(toBean(form));
		return "common/action_succ";
	}
	
	/**
	 * DO设置
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-6
	 */
	private AddressBook toBean(AddressBookForm form) {
		AddressBook addressBook = new AddressBook();
		BeanUtils.copyProperties(form, addressBook); // 复制表单至DO
		addressBook.setEnabled(AddressBook.ABLED);// 设置记录为有效记录
		addressBook.setLoginId(SecurityUtils.getLoginId()); // 设置登录通讯录Id
		addressBook.setAddNamePy(PinyinUtil.toAbbLowPinyin(addressBook.getAddName()));// 用户名转换成拼音
		return addressBook;
	}

	/**
	 * 跳转至更新通讯录页面
	 * 
	 * @return 新增通讯录页面
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	@RequestMapping(value = "/addressBook/edit_addressBook.htm", method = RequestMethod.GET)
	public String editAddressBook(long id, ModelMap map) {
		if(id == 0){
	    	map.put("addressBook", new AddressBook());
	    }
	    else{
		AddressBook addressBook =  addressBookService.selectAddressBookById(id);
		map.put("addressBook",addressBook);
	    }
		AddressBookTypePage addressBookTypePage = new AddressBookTypePage();
		addressBookTypePage.setLoginId(SecurityUtils.getLoginId());
		AddressBookTypePage addressBookTypePages = addressBookService.findAllTypeInfo(addressBookTypePage);
		map.put("addressBookTypePages", addressBookTypePages);//取得分组列表
		return "addressbook/edit_addressBook";
	}
	
	/**
	 * 通讯录更新处理
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2013-5-6
	 */
	@RequestMapping("/addressBook/edit_addressBook.htm")
	public String editAddressBook(AddressBookForm form, ModelMap map) {
		addressBookService.updateAddressBookInfo(toBean(form));
		map.put("addressBookId", form.getId());
		return "addressbook/add_success";
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
	@RequestMapping(value = "/addressBook/delete.htm", method = RequestMethod.GET)
	public String deleteAddressbook(Long id) {
		addressBookService.deleteAddressbook(id);
		return "common/action_succ";
	}


}
