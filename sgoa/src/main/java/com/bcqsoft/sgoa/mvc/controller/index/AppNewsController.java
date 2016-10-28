package com.bcqsoft.sgoa.mvc.controller.index;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.dao.news.dataobject.News;
import com.bcqsoft.sgoa.dao.news.dataobject.NewsPage;
import com.bcqsoft.sgoa.dao.newslook.dataobject.NewsLook;
import com.bcqsoft.sgoa.dao.newsreview.dataobject.NewsReviewPage;
import com.bcqsoft.sgoa.service.news.NewsService;
import com.bcqsoft.sgoa.service.newslook.NewsLookService;

/**
 * App要情控制器
 */
@Controller
public class AppNewsController {
	
	private @Autowired NewsService newsService;
	
	private @Autowired NewsLookService newsLookService;
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
		String title = request.getParameter("title") ;
		try {
			if(title!=null){
				title = new String(title.getBytes("iso-8859-1"),"utf-8");
				}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	/**
	 * 点击查看通知表
	 * 
	 * @param id
	 * @param map
	 * @return 通知表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/home/news/look_detail.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> newsLookDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 获取当前登录ID
		String loginId = request.getParameter("loginId");
		Long id =Long.parseLong(request.getParameter("id"));
		Map<String,Object> resMap = new HashMap<String, Object>();
		if (loginId == null || "".equals(loginId)
				|| "anonymousUser".equals(loginId)) {
			return null;
		}
		NewsLook newsForList = new NewsLook();
		newsForList.setLoginId(loginId);
		newsForList.setNewsId(id);
		List<NewsLook> newsLookList = newsLookService
				.getAllNewsLookList(newsForList);
		Integer count = newsLookList.size();
		if (count == 0) {
			NewsLook newsLook = new NewsLook();
			newsLook.setLoginId(loginId);
			newsLook.setNewsId(id);
			newsLookService.addNewsInfo(newsLook);
		}
		List<NewsLook> newsLookListForAll = newsLookService
				.getAllNewsLookListAll(id);
		resMap.put("look", newsLookListForAll);

		News news = newsService.getUserDraftNewsDetail(id);
		byte[] bt = news.getContent();
		String text = null;
		try{
			if(bt!=null || bt.equals("")){
				FileOutputStream fos = new FileOutputStream("E:\\aaa.doc");
		        fos.write(bt);
		        fos.close();
		        FileInputStream is = new FileInputStream(new File("E:\\aaa.doc"));
		        WordExtractor extrator = new WordExtractor(is); 
		       text = extrator.getText(); 
				
				}
			
		}catch(Exception e){
		}
		resMap.put("content",text);
		resMap.put("data", news);
		NewsReviewPage page = newsService.getNewsReviewListById(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		//resMap.put("page", page);
		String re_Code = news==null?"1":"0";
		String message = news==null?"取得失败":"取得成功";
		resMap.put("re_Code", re_Code);
		resMap.put("message", message);
		return resMap;
	}

}
