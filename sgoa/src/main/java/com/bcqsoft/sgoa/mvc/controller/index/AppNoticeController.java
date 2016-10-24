package com.bcqsoft.sgoa.mvc.controller.index;

import java.io.UnsupportedEncodingException;
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
import com.bcqsoft.sgoa.dao.message.dataobject.Message;
import com.bcqsoft.sgoa.dao.message.dataobject.MessagePage;
import com.bcqsoft.sgoa.service.notice.NoticeService;

/**
 * App公告控制器
 * 
 */
@Controller
public class AppNoticeController {
	
	private @Autowired NoticeService noticeService;
	
	/**
	 * 公告查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author zy
	 * @Date 2016/10/19
	 */
	@RequestMapping(value = "/home/notice/notice_search.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> noticeSearchList(HttpServletRequest request, HttpServletResponse response) {

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
		MessagePage outPage = new MessagePage();
		outPage.setCurrentPage(Integer.parseInt(currentPage));
		outPage.setPageSize(Integer.parseInt(pageSize));
		outPage.setTitle(title);
		outPage.setStatus(CommonChar.ACTION_PZ);
		outPage.setSort(CommonChar.SORT_GG);
		MessagePage mesPage = noticeService.getNoticeSearchList(outPage);
		List<Message> list = mesPage.getMessageList();
		retCode = list==null?"1":"0";
		message = list==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("retCode", retCode);
		map.put("data", list);
		return map;
	}
}
