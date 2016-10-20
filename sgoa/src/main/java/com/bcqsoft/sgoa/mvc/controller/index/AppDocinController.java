package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docin.dataobject.DocinPage;
import com.bcqsoft.sgoa.service.docin.DocinService;

/**
 * App收文控制器
 * Author zy
 */
@Controller
public class AppDocinController {
	
	@Autowired private DocinService docinService;
	/**
	 * 通知查询列表
	 * @param map
	 * @return 信息页面模板
	 * @Author zy
	 * @Date 2016-10-17
	 */
	@ResponseBody
	@RequestMapping("/home/docin_search.htm")
	public Map<String,Object> bsReviewMyList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String title = request.getParameter("title");
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "1";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		DocinPage docin = new DocinPage();
		docin.setCurrentPage(Integer.parseInt(currentPage));
		docin.setPageSize(Integer.parseInt(pageSize));
		docin.setTitle(title);
		docin.setStatus(CommonChar.STATUS_FF);
		DocinPage docinPage = docinService.getDocinSearchList(docin);
		List<Docin> docinList = docinPage.getDocinList();
		retCode = docinList==null?"1":"0";
		message = docinList==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data",docinList);
		return map;
	}

}
