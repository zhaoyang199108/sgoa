package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBook;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookType;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;
import com.bcqsoft.sgoa.service.addressbook.AddressBookService;

/**
 * 私人通讯录
 * @author wudi
 *@date 2016/10/18
 */

@Controller
public class AppAddressBookController {
	
	/**
	 * 通讯录的业务逻辑层
	 */	
	@Autowired
	private AddressBookService addressBookService;
	
	
	@RequestMapping(value="/home/addressBook/list.htm" , method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> selectAddressBookListByPage(HttpServletRequest request,HttpServletResponse response) {
		String typeId = request.getParameter("typeId");
		String retCode = "";
		String message = "";
		long id = Long.parseLong(typeId);
		List<AddressBook> addressBookList = addressBookService.getAddressBookList(id);
		retCode = addressBookList==null?"1":"0";
		message = addressBookList==null?"取得失败":"取得成功";
		Map<String,Object>  map = new HashMap<String, Object>();
		map.put("retCode", retCode);
		map.put("message", message);
		map.put("data",addressBookList);
		return map;
	}
	@RequestMapping(value = "/home/addressBook/add_addressBook.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> addAddressBook(HttpServletRequest request,HttpServletResponse response) {
		String loginId = request.getParameter("loginId");
		String retCode = "";
		String message = "";
		AddressBookTypePage addressBookTypePage = new AddressBookTypePage();
		addressBookTypePage.setLoginId(loginId);
		AddressBookTypePage addressBookTypePages = addressBookService.findAllTypeInfo(addressBookTypePage);
		List<AddressBookType> list = addressBookTypePages.getAddressTypeList();
		retCode = addressBookTypePages==null ? "1" : "0";
		message = addressBookTypePages==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data",list);
		return map;
	}


	
}
