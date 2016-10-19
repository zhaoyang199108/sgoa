package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.ArrayList;
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

import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.Ggtxl;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.GgtxlPage;
import com.bcqsoft.sgoa.mvc.controller.index.util.GgtxlRes;
import com.bcqsoft.sgoa.mvc.form.ggtxl.GgtxlForm;
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
	 * @Author zy
	 * @Date 2016-10-19
	 */
	@RequestMapping(value = "/home/ggtxl_search_list.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> selectGgtxlSearchList(
			HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>>  result = new ArrayList<Map<String,Object>>();
		GgtxlPage ggtxlPage = new GgtxlPage(); // 分页对象
		String retCode = "";
		String message = "";
		GgtxlPage page = ggtxlService.getGgtxlInfoSearchList(ggtxlPage);
		List<Ggtxl> ggtxlList = page.getGgtxlList();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapRes = new HashMap<String, Object>();
		List<Ggtxl> list = new ArrayList<Ggtxl>();
		for(Ggtxl i : ggtxlList){
			map.put(i.getTypeId(), null);
		}
		List<Object> lis = new ArrayList<Object>();
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
	 * 公共通讯录申领表列表页面设置查询条件
	 * @Author zy
	 * @Date 2016-10-17
	 */
	private void setSearchKey(GgtxlForm form, GgtxlPage ggtxlPage) {
		ggtxlPage.setLoginId(SecurityUtils.getLoginId()); // 设置登录通讯录Id
		ggtxlPage.setAddName(form.getAddName());
		ggtxlPage.setUnitTel(form.getUnitTel());
		ggtxlPage.setCurrentPage(form.getCp()); // 当前页数

	}
}
