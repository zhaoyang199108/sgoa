package com.bcqsoft.sgoa.mvc.controller.index;

import java.sql.Blob;
import java.sql.SQLException;
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
import com.bcqsoft.sgoa.dao.message.dataobject.Message;
import com.bcqsoft.sgoa.dao.message.dataobject.MessagePage;
import com.bcqsoft.sgoa.dao.messagelook.dataobject.MessageLook;
import com.bcqsoft.sgoa.dao.messagereview.dataobject.MessageReviewPage;
import com.bcqsoft.sgoa.service.message.MessageService;
import com.bcqsoft.sgoa.service.messagelook.MessageLookService;

/*
 * App通知控制器
 * */
@Controller
public class AppMessageController {
	private @Autowired MessageService messageService;
	private @Autowired MessageLookService messageLookService;
	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author zy
	 * @Date 2016/10/19
	 */
	@RequestMapping(value = "/home/message/message_search.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> messageSearchList(HttpServletRequest request,
			HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String title = request.getParameter("title");
		String draftsDeptId = request.getParameter("draftsDeptId");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		MessagePage outPage = new MessagePage();
		outPage.setCurrentPage(Integer.parseInt(currentPage));
		outPage.setPageSize(Integer.parseInt(pageSize));
		outPage.setTitle(title);
		outPage.setSort(CommonChar.SORT_TZ);
		outPage.setStatus(CommonChar.ACTION_PZ);
		MessagePage resPage = messageService.getMessageSearchList(outPage);
		List<Message> list = resPage.getMessageList();
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
	 * @Author zy
	 * @Date 20161022
	 */
	@RequestMapping(value = "/home/message/look_detail.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> messageLookDetail(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//获取当前登录ID
		String loginId =request.getParameter("loginId");
		Long id =Long.parseLong(request.getParameter("id"));
		Map<String,Object> resMap = new HashMap<String, Object>();
		if(loginId == null || "".equals(loginId) || "anonymousUser".equals(loginId)){
		System.out.println("kkkkkk");
		}
		MessageLook messageForList = new MessageLook();
		messageForList.setLoginId(loginId);
		messageForList.setMessageId(id);
		List<MessageLook> messageLookList = messageLookService.getAllMessageLookList(messageForList);
		resMap.put("data", messageLookList);
		List<MessageLook> messageLookListForAll = messageLookService.getAllMessageLookListAll(id);
		resMap.put("list", messageLookListForAll);
		Message message = messageService.getUserDraftMessageDetail(id);
		if(message.getContent() !=null ){
			  String content = new String(message.getContent());  
			  System.out.println(content);
			  resMap.put("content",content);
		}
		resMap.put("message", message);
		MessageReviewPage page = messageService.getMessageReviewListById(id);
//		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		resMap.put("page", page);
		return resMap;
	}

}
