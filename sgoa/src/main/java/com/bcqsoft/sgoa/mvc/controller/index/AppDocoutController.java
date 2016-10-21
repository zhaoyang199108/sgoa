package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.dao.docout.dataobject.Docout;
import com.bcqsoft.sgoa.dao.docout.dataobject.DocoutPage;
import com.bcqsoft.sgoa.service.docout.DocoutService;

/**
 * App发文控制器
 * 
 * Author zy
 */
@Controller
public class AppDocoutController {

	public DocoutService docoutService;
	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author zy
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/home/docout_search.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> docoutSearchList(HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String title = request.getParameter("title");
		String docoutNum = request.getParameter("docoutNum");
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "1";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		
		DocoutPage outPage = new DocoutPage();
		outPage.setCurrentPage(Integer.parseInt(currentPage));
		outPage.setPageSize(Integer.parseInt(pageSize));
		outPage.setTitle(title);
		outPage.setStatus(CommonChar.STATUS_FF);
		outPage.setDocoutNum(docoutNum);
		// 根据用户ID查找该待该用户审批的信息
		//	map.put("page", docoutService.getDocoutSearchList(outPage));
		// 左侧菜单点击后高亮显示
		//map.put("menuHighLight", "docout_search");
		DocoutPage page = docoutService.getDocoutSearchList(outPage);
		List<Docout> docoutList = page.getDocoutList();
		retCode = docoutList==null?"1":"0";
		message = docoutList==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data",docoutList);
		return map;
	}

}
