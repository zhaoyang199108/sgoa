package com.bcqsoft.sgoa.mvc.controller.workscheduler;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.common.util.PropertiesUtil;
import com.bcqsoft.sgoa.common.util.XmlUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkScheduler;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkSchedulerPage;
import com.bcqsoft.sgoa.mvc.form.workscheduler.WorkSchedulerForm;
import com.bcqsoft.sgoa.service.workscheduler.WorkSchedulerService;

@Controller
public class WorkSchedulerController {
	/**
	 * 日程模块业务逻辑类接口
	 */
	@Autowired
	private WorkSchedulerService workSchedulerService;

	/**
	 * 取得日程信息列表
	 * 
	 * @param map
	 * @return 日程列表页面
	 * 
	 * @Author cql
	 * @Date 2011-12-23
	 */
	@RequestMapping("/workscheduler/work_scheduler.htm")
	public String schedulerList(String selectTime,ModelMap map) {
		WorkSchedulerPage schedulerPage = new WorkSchedulerPage();
		if (selectTime == null || "".equals(selectTime)) {
			selectTime = DateUtil.getDateTime();
		}
		schedulerPage.setSelectTime(selectTime);// 设置选择时间
		schedulerPage.setLoginId(SecurityUtils.getLoginId()); // 设置登录Id
		List<WorkScheduler> list = workSchedulerService.getWorkSchedulerList(schedulerPage);
		// 设置输出event。xml路径
		String filePath = PropertiesUtil.getFileUploadDir()
				+ "\\schedulerFile\\work_event.xml";
		try {
			XmlUtil.writeToWorkSchedulerXml(list, filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "work_scheduler");
		// 跳转至用户列表页面
		return "/workscheduler/work_scheduler";
	}
	
	/**
	 * 取得日程信息列表
	 * 
	 * @param map
	 * @return 日程列表页面
	 * 
	 * @Author cql
	 * @Date 2011-12-23
	 */
	@RequestMapping("/workscheduler/work_scheduler_check.htm")
	public String schedulerCheckList(String selectTime,String loginId,String userName,ModelMap map) {
		WorkSchedulerPage schedulerPage = new WorkSchedulerPage();
		if (selectTime == null || "".equals(selectTime)) {
			selectTime = DateUtil.getDateTime();
		}
		schedulerPage.setSelectTime(selectTime);// 设置选择时间
		schedulerPage.setLoginId(loginId); // 设置登录Id
		schedulerPage.setUserName(userName);
		map.put("page", schedulerPage);
		List<WorkScheduler> list = workSchedulerService.getWorkSchedulerList(schedulerPage);
		// 设置输出event。xml路径
		String filePath = PropertiesUtil.getFileUploadDir()
				+ "\\schedulerFile\\work_event.xml";
		try {
			XmlUtil.writeToWorkSchedulerXml(list, filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "work_scheduler_check");
		// 跳转至用户列表页面
		return "/workscheduler/work_scheduler_check";
	}

	/**
	 * 添加日程列表
	 * 
	 * @param map
	 * @return 日程管理页面
	 * 
	 * @Author cql
	 * @Date 2011-12-26
	 */
	@RequestMapping("/workscheduler/add_workscheduler.htm")
	@ResponseBody
	public String addWorkScheduler(WorkSchedulerForm form) {
		workSchedulerService.createWorkSchedulerInfo(tobean(form));
		return "common/action_succ";
	}

	/**
	 * 修改日程列表
	 * 
	 * @param map
	 * @return 日程列表页面
	 * 
	 * @Author cql
	 * @Date 2011-12-26
	 */
	@RequestMapping("/workscheduler/edit_workscheduler.htm")
	@ResponseBody
	public String editWorkScheduler(WorkSchedulerForm form) {
		workSchedulerService.updateWorkSchedulerInfo(tobean(form));
		return "common/action_succ";
	}

	/**
	 * 查看日程提醒列表
	 * 
	 * @param map
	 * @return 日程提醒页面
	 * 
	 * @Author cql
	 * @Date 2012-03-02
	 */
	@RequestMapping("/workscheduler/workscheduler_list.htm")
	public String schedulerList(WorkSchedulerForm form, ModelMap map) {
		// 用户分页对象初始化
		WorkSchedulerPage schedulerPage = new WorkSchedulerPage();
		// 设置查询条件
		setSearchKey(form, schedulerPage);
		// 取得用户列表,分页显示
		WorkSchedulerPage page = workSchedulerService
				.getWorkSchedulerInfoList(schedulerPage);
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "workscheduler_list");
		// 跳转至用户列表页面
		return "workscheduler/workscheduler_list";
	}
	
	/**
	 * 根据ID查找某条日程提醒信息
	 * 
	 * @param id
	 * @return 设置日程提醒页面
	 * 
	 * @Author sbq
	 * @Date 2011-03-02
	 */
	@RequestMapping(value = "/workscheduler/edit_workscheduler_one.htm", method = RequestMethod.GET)
	public String editScheduler(long id, ModelMap map) {
		map.put("scheduler", workSchedulerService.selectWorkSchedulerById(id));

		return "workscheduler/edit_workscheduler";
	}
	
	/**
	 * 设置日程提醒信息
	 * 
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author sbq
	 * @Date 2011-03-02
	 */
	@RequestMapping("/workscheduler/edit_workscheduler_one.htm")
	public String editScheduler(WorkSchedulerForm form, ModelMap map) {
		workSchedulerService.updateWorkScheduler(tobean(form));
		return "common/action_succ";
	}

	/**
	 * 删除日程信息列表
	 * 
	 * @param map
	 * @return 日程列表页面
	 * 
	 * @Author cql
	 * @Date 2011-12-26
	 */
	@RequestMapping("/workscheduler/delete_scheduler.htm")
	@ResponseBody
	public String deleteWorkScheduler(Long id) {
		workSchedulerService.deleteWorkSchedulerInfo(id);
		return "common/action_succ";
	}

	/**
	 * 根据ID查找某条日程提醒信息
	 * 
	 * @param id
	 * @return 设置日程提醒页面
	 * 
	 * @Author sbq
	 * @Date 2011-03-02
	 */
	@RequestMapping(value = "/workscheduler/edit_workscheduler_alert.htm", method = RequestMethod.GET)
	public String editWorkScheduler(long id, ModelMap map) {
		map.put("workScheduler", workSchedulerService.selectWorkSchedulerById(id));

		return "workscheduler/edit_workscheduler";
	}

	/**
	 * 设置日程提醒信息
	 * 
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author sbq
	 * @Date 2011-03-02
	 */
	@RequestMapping("/workscheduler/edit_workscheduler_alert.htm")
	public String editWorkScheduler(WorkSchedulerForm form, ModelMap map) {
		workSchedulerService.updateWorkScheduler(tobean(form));
		return "common/action_succ";
	}

	/**
	 * DO设置
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-27
	 */
	private WorkScheduler tobean(WorkSchedulerForm form) {
		WorkScheduler scheduler = new WorkScheduler();
		scheduler.setId(form.getId());
		scheduler.setContent(form.getContent());// 内容
		scheduler.setStartTime(form.getStartTime());// 开始时间
		scheduler.setEndTime(form.getEndTime());// 结束时间
		scheduler.setEnabled(WorkScheduler.ABLED);
		scheduler.setLoginId(SecurityUtils.getLoginId());
		scheduler.setStartRemindTime(form.getStartRemindTime());// 提醒时间
		scheduler.setIsRemind(form.getIsRemind());// 状态
		return scheduler;
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
	private void setSearchKey(WorkSchedulerForm form, WorkSchedulerPage schedulerPage) {
		// 设置查询条件
		schedulerPage.setCurrentPage(form.getCp()); // 当前页数
		schedulerPage.setStartTime(form.getStartTime()); // 日程开始时间
		schedulerPage.setEndTime(form.getEndTime()); // 日程结束时间
		schedulerPage.setIsRemind(form.getIsRemind());// 是否提醒
		schedulerPage.setLoginId(SecurityUtils.getLoginId()); // 登录人

	}
}
