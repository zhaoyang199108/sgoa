package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.pinyin4j.PinyinHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBook;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookType;
import com.bcqsoft.sgoa.dao.addressbooktype.dataobject.AddressBookTypePage;
import com.bcqsoft.sgoa.mvc.result.AddressBookRes;
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
		if(typeId.equals(null)){
			retCode="1";
			message = "请求分组typeId类型不能为空";
			Map<String,Object>  map = new HashMap<String, Object>();
			map.put("retCode", retCode);
			map.put("message", message);
			map.put("data",null);
			return map;
		}
		long id = Long.parseLong(typeId);
		List<AddressBook> addressBookList = addressBookService.getAddressBookList(id);
		Map<String,Object> mapres = new HashMap<String, Object>();
		for(AddressBook i : addressBookList){
			String str = i.getAddName();
			mapres.put(getPinYinHeadChar(str), null);
		}
		List<AddressBookRes> ggResList = new ArrayList<AddressBookRes>();
		for(String t : mapres.keySet()){
			AddressBookRes addressBookRes = new AddressBookRes();
				List<AddressBook> ggList = new ArrayList<AddressBook>();
				for(AddressBook i:addressBookList){
					if(getPinYinHeadChar(i.getAddName()).equals(t)){
						ggList.add(i);
						char str = getPinYinHeadChar(i.getAddName()).charAt(0);
						addressBookRes.name=""+str;
					}
				}
			addressBookRes.addressBook = ggList;
			ggResList.add(addressBookRes);
		}
		Collections.sort(ggResList, new MySort());
		retCode = addressBookList==null?"1":"0";
		message = addressBookList==null?"取得失败":"取得成功";
		Map<String,Object>  map = new HashMap<String, Object>();
		map.put("retCode", retCode);
		map.put("message", message);
		map.put("data",ggResList);
		return map;
	}
	 public static String getPinYinHeadChar(String str) {
	        String convert = "";
	        for (int j = 0; j < str.length(); j++) {
	            char word = str.charAt(j);
	            // 提取汉字的首字母
	            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
	            if (pinyinArray != null) {
	                convert += pinyinArray[0].charAt(0);
	            } else {
	                convert += word;
	            }
	        }
	        return convert;
	    }
	
	  class MySort implements Comparator {  
	        public int compare(Object object1, Object object2) {// 实现接口中的方法  
	        	AddressBookRes p1 = ((AddressBookRes) object1); // 强制转换  
	        	AddressBookRes p2 = ((AddressBookRes) object2);  
	            return p1.name.compareTo(p2.name);  
	        }  
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
