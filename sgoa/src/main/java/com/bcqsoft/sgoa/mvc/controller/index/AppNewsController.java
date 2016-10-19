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

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.dao.news.dataobject.News;
import com.bcqsoft.sgoa.dao.news.dataobject.NewsPage;
import com.bcqsoft.sgoa.service.news.NewsService;

/**
 * App要情控制器
 */
@Controller
public class AppNewsController {
	
	private @Autowired NewsService newsService;
	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author zy
	 * @Date 2016-10-19
	 */
	@RequestMapping(value = "/home/news/news_search.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> newsSearchList(HttpServletRequest request, HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String title = request.getParameter("title");
		String draftsDeptId = request.getParameter("draftsDeptId");
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "1";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		NewsPage outPage = new NewsPage();
		outPage.setCurrentPage(Integer.parseInt(currentPage));
		outPage.setPageSize(Integer.parseInt(pageSize));
		outPage.setTitle(title);
		outPage.setSort(CommonChar.SORT_YQ);
		outPage.setStatus(CommonChar.ACTION_PZ);
		NewsPage newPage =  newsService.getNewsSearchList(outPage);
		List<News> list = newPage.getNewsList();
		retCode = list==null?"1":"0";
		message = list==null?"取得失败":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", list);
		return resMap;
	}

}
