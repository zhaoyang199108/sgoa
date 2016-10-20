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

import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.Ggtxl;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.GgtxlPage;
import com.bcqsoft.sgoa.mvc.controller.index.util.GgtxlRes;
import com.bcqsoft.sgoa.service.ggtxl.GgtxlService;

/**
 * App 公共通讯录申领表模块控制器
 * 
 * @author zy
 * 
 */
@Controller
public class AppGgtxlController {

	/**
	 * 公共通讯录申领表的业务逻辑层
	 */
	@Autowired
	private GgtxlService ggtxlService;

	/**
	 * 查询公共通讯录
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping(value = "/home/ggtxl_search_list.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> selectGgtxlSearchList(
			HttpServletRequest request, HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "1000";
		}
		GgtxlPage ggtxlPage = new GgtxlPage(); // 分页对象
		String retCode = "";
		String message = "";
		ggtxlPage.setLoginId(SecurityUtils.getLoginId());
		ggtxlPage.setCurrentPage(Integer.parseInt(currentPage));
		ggtxlPage.setPageSize(Integer.parseInt(pageSize));
		GgtxlPage page = ggtxlService.getGgtxlInfoSearchList(ggtxlPage);
		List<Ggtxl> ggtxlList = page.getGgtxlList();
		Map<String, Object> map = new HashMap<String, Object>();
		for(Ggtxl i : ggtxlList){
			map.put(i.getTypeId(), null);
		}
		List<GgtxlRes> ggResList = new ArrayList<GgtxlRes>();
		for(String t : map.keySet()){
			
			GgtxlRes ggtxlRes = new GgtxlRes();
				List<Ggtxl> ggList = new ArrayList<Ggtxl>();
				for(Ggtxl i:ggtxlList){
					if(i.getTypeId().equals(t)){
						ggList.add(i);
						ggtxlRes.name=i.getTypeName();
					}
				}
			
			ggtxlRes.ggtxl = ggList;
			ggResList.add(ggtxlRes);
		}
		Map<String,Object> resMap = new HashMap<String, Object>();
		retCode = ggResList == null?"1":"0";
		message = ggResList == null?"取得失败":"取得成功";
		resMap.put("retCode", retCode);
		resMap.put("message", message);
		resMap.put("data",ggResList);
		return resMap;
		//return ggResList;
	}
	/**
	 * 查询公共通讯录按人员
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author zy
	 * @Date 20161020
	 */
	@RequestMapping(value = "/home/ggtxl_search_list_person.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> selectGgtxlSearchListByPerson(
			HttpServletRequest request, HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "1000";
		}
		GgtxlPage ggtxlPage = new GgtxlPage(); // 分页对象
		String retCode = "";
		String message = "";
		ggtxlPage.setLoginId(SecurityUtils.getLoginId());
		ggtxlPage.setCurrentPage(Integer.parseInt(currentPage));
		ggtxlPage.setPageSize(Integer.parseInt(pageSize));
		GgtxlPage page = ggtxlService.getGgtxlInfoSearchList(ggtxlPage);
		List<Ggtxl> ggtxlList = page.getGgtxlList();
		Map<String, Object> map = new HashMap<String, Object>();
		for(Ggtxl i : ggtxlList){
			map.put(getPinYinHeadChar(i.getAddName()).charAt(0)+"", null);
		}
		List<GgtxlRes> ggResList = new ArrayList<GgtxlRes>();
		for(String t : map.keySet()){
			System.out.println(t);
			GgtxlRes ggtxlRes = new GgtxlRes();
				List<Ggtxl> ggList = new ArrayList<Ggtxl>();
				for(Ggtxl i:ggtxlList){
					if(getPinYinHeadChar(i.getAddName().charAt(0)+"").equals(t)){
						ggList.add(i);
						char str = getPinYinHeadChar(i.getAddName()).charAt(0);
						ggtxlRes.name=""+str;
					}
				}
			
			ggtxlRes.ggtxl = ggList;
			ggResList.add(ggtxlRes);
		}
		Collections.sort(ggResList, new MySort());
		Map<String,Object> resMap = new HashMap<String, Object>();
		retCode = ggResList == null?"1":"0";
		message = ggResList == null?"取得失败":"取得成功";
		resMap.put("retCode", retCode);
		resMap.put("message", message);
		resMap.put("data",ggResList);
		return resMap;
		//return ggResList;
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
	        	GgtxlRes p1 = ((GgtxlRes) object1); // 强制转换  
	        	GgtxlRes p2 = ((GgtxlRes) object2);  
	            return p1.name.compareTo(p2.name);  
	        }  
	    }  
}
