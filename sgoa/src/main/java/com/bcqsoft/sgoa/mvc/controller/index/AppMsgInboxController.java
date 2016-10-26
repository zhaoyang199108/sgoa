package com.bcqsoft.sgoa.mvc.controller.index;

import java.io.UnsupportedEncodingException;
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
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInbox;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInboxPage;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutbox;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutboxPage;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.service.msg.MsgInboxService;
import com.bcqsoft.sgoa.service.msg.MsgOutboxService;
@Controller
public class AppMsgInboxController {

	private @Autowired MsgInboxService msgInboxService;
	private @Autowired MsgOutboxService msgOutboxService;
	private @Autowired MsgOutboxService siteMsgService;
	/**
	 * 取得有效的收件箱列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author zy
	 * @Date 20161020
	 */
	@RequestMapping("/home/msg/msgInbox_list.htm")
	@ResponseBody
	public Map<String,Object> selectMsgInboxListByPage(HttpServletRequest request,HttpServletResponse response) {
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
		String loginId = request.getParameter("loginId");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		MsgInboxPage msgInboxPage = new MsgInboxPage(); // 分页对象
		//setSearchKey(form, msgInboxPage); // 设置页面中的查询条件
		msgInboxPage.setTitle(title);
		msgInboxPage.setReceiverId(loginId);// 获取登录帐号
		// 取得收件箱列表,分页显示
		msgInboxPage.setCurrentPage(Integer.parseInt(currentPage));
		MsgInboxPage page = msgInboxService.getMsgInboxListByPage(msgInboxPage);
		List<MsgInbox> list = page.getMsgInboxList();
		retCode = list==null?"0":"0";
		message = list==null?"取得成功":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", list);
		return resMap;
	}
	
	/**
	 * 取得有效的发件箱列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@RequestMapping("/home/msg/msgOutbox_list.htm")
	@ResponseBody
	public Map<String,Object> selectMsgOutboxListByPage(HttpServletRequest request,HttpServletResponse response) {
		
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String title = request.getParameter("title");
		try {
			if(title!=null){
				title = new String(title.getBytes("iso-8859-1"),"utf-8");
				}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String loginId = request.getParameter("loginId");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		MsgOutboxPage msgOutboxPage = new MsgOutboxPage(); // 分页对象
		msgOutboxPage.setCurrentPage(Integer.parseInt(currentPage)); // 当前页数
	//	msgOutboxPage.setReceiverIds(loginId);// 获取登录帐号
		msgOutboxPage.setTitle(title);// 获取标题
		msgOutboxPage.setSenderId(loginId);
		// 取得发件箱列表,分页显示
		MsgOutboxPage page = msgOutboxService.getMsgOutboxListByPage(msgOutboxPage);
		List<MsgOutbox> list = page.getMsgOutboxList();
		retCode = list==null?"0":"0";
		message = list==null?"取得成功":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", list);
		return resMap;
	}
	/**
	 * 跳转至收件箱详细页面
	 * 
	 * @return 收件箱详细页面
	 * 
	 * @Author cql
	 * @Date 2012-02-21
	 */
	@RequestMapping(value = "/home/msg/detail_msgInbox.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> detailMsgInbox(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("id");
		Map<String,Object> map = new HashMap<String,Object>();
		if(id == null || "".equals(id)){
			map.put("data", null);
			map.put("retCode", 1);
			map.put("message", "取得失败");
			return map;
		}
		MsgInbox msgInbox = msgInboxService.selectMsgInboxById(Long.parseLong(id));
		
		map.put("data", msgInbox);
		map.put("retCode", 0);
		map.put("message", "取得成功");
		return map;
	}
	/**
	 * 跳转至发件箱详细页面
	 * 
	 * @return 发件箱详细页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/home/msg/detail_msgOutbox.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> detailMsgOutbox(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("id");
		Map<String,Object> map = new HashMap<String,Object>();
		if(id == null || "".equals(id)){
			map.put("data", null);
			map.put("retCode", 1);
			map.put("message", "取得失败");
			return map;
		}
		MsgOutbox msgOutbox = siteMsgService.selectMsgOutboxById(Long.parseLong(id));
		
		map.put("data", msgOutbox);
		map.put("retCode", 0);
		map.put("message", "取得成功");
		return map;
	}

}
