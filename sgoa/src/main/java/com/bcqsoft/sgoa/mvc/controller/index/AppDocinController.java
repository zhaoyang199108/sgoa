package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docin.dataobject.DocinPage;
import com.bcqsoft.sgoa.mvc.form.docin.DocinForm;
import com.bcqsoft.sgoa.service.docin.DocinService;

/**
 * App收文控制器
 * 
 * Author zy
 */
@Controller
public class AppDocinController {
	
	@Autowired private DocinService docinService;
	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
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
	/**
	 * 我的拟稿列表页面设置查询条件
	 * 
	 * @param form
	 * @param goodsPage
	 * 
	 * @Author zbq
	 * @Date 2011-8-25
	 */
	private void setSearchKey(DocinForm form, DocinPage docinPage) {
		// 设置查询条件
		docinPage.setCurrentPage(form.getCp()); // 当前页数
		docinPage.setTitle(form.getTitle()); // 标题
		docinPage.setTextTime(form.getTextTime()); // 标题
		docinPage.setSort(CommonChar.SORT_TZ); // 分类
		docinPage.setStatus(form.getStatus()); // 当前状态
		docinPage.setEnabled(form.getEnabled()); // 文件状态
	}
}
