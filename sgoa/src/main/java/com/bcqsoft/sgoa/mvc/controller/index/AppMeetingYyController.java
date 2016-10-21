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

import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoom;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYy;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYyPage;
import com.bcqsoft.sgoa.service.meetingyy.MeetingYyService;
/*
 * App会议室控制器
 * */
@Controller
public class AppMeetingYyController {
	
	private @Autowired MeetingYyService meetingYyService;
	@RequestMapping("/home/meetingYy/meetingRoom_list.htm")
	@ResponseBody
	public Map<String,Object> getMeetingRoomList(HttpServletRequest request,
			HttpServletResponse response){
		String retCode = "";
		String message = "";
		List<MeetingRoom> list = meetingYyService.findAllRoomInfo();
		retCode = list==null?"1":"0";
		message = list==null?"取得失败":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", list);
		return resMap;
		
	}
	/**
	 * 取得有效的会议室预约列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author zy
	 * @Date 20161020
	 */
	@RequestMapping("/home/meetingYy/meetingYy_list.htm")
	@ResponseBody
	public Map<String,Object> meetingYyList(HttpServletRequest request,
			HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String loginId = request.getParameter("loginId");
		String roomId = request.getParameter("roomId");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		MeetingYyPage meetingYyPage = new MeetingYyPage();
		meetingYyPage.setCurrentPage(Integer.parseInt(currentPage));
		meetingYyPage.setPageSize(Integer.parseInt(pageSize));
		meetingYyPage.setLoginId(loginId);
		meetingYyPage.setRoomId(roomId);
		MeetingYyPage page = meetingYyService.getMeetingYyInfoList(meetingYyPage);
		List<MeetingYy> list =  page.getMeetingYyList();
		retCode = list==null?"0":"0";
		message = list==null?"取得成功":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", list);
		return resMap;
	}
}
