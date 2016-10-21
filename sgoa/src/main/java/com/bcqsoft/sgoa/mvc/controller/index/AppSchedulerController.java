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
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutbox;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.Scheduler;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.SchedulerPage;
import com.bcqsoft.sgoa.mvc.form.scheduler.SchedulerForm;
import com.bcqsoft.sgoa.service.scheduler.SchedulerService;

@Controller
public class AppSchedulerController {
	private @Autowired SchedulerService schedulerService;
	/**
	 * 查看日程提醒列表
	 * 
	 * @param map
	 * @return 日程提醒页面
	 * 
	 * @Author zy
	 * @Date 20161020
	 */
	@RequestMapping("/home/scheduler/scheduler_list.htm")
	@ResponseBody
	public Map<String,Object> schedulerList(HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String loginId = request.getParameter("loginId");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		// 用户分页对象初始化
		SchedulerPage schedulerPage = new SchedulerPage();
		schedulerPage.setCurrentPage(Integer.parseInt(currentPage));
		schedulerPage.setPageSize(Integer.parseInt(pageSize));
		schedulerPage.setStartTime(startTime);
		schedulerPage.setEndTime(endTime);
		schedulerPage.setLoginId(loginId); // 登录人
		// 取得用户列表,分页显示
		SchedulerPage page = schedulerService
				.getSchedulerInfoList(schedulerPage);
		List<Scheduler> list = page.getSchedulerList();
		retCode = list==null?"0":"0";
		message = list==null?"取得成功":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", list);
		return resMap;
	}
	/**
	 * 日程提醒页面设置查询条件
	 * 
	 * @param form
	 * @param usersPage
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private void setSearchKey(SchedulerForm form, SchedulerPage schedulerPage) {
		// 设置查询条件
		schedulerPage.setCurrentPage(form.getCp()); // 当前页数
		schedulerPage.setStartTime(form.getStartTime()); // 日程开始时间
		schedulerPage.setEndTime(form.getEndTime()); // 日程结束时间
		schedulerPage.setIsRemind(form.getIsRemind());// 是否提醒
		schedulerPage.setLoginId(SecurityUtils.getLoginId()); // 登录人

	}
}
