package com.bcqsoft.sgoa.mvc.controller.scheduler;

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
import com.bcqsoft.sgoa.dao.scheduler.dataobject.Scheduler;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.SchedulerPage;
import com.bcqsoft.sgoa.mvc.form.scheduler.SchedulerForm;
import com.bcqsoft.sgoa.service.scheduler.SchedulerService;

@Controller
public class SchedulerController {
	/**
	 * 日程模块业务逻辑类接口
	 */
	@Autowired
	private SchedulerService schedulerService;

	/**
	 * 取得日程信息列表
	 * 
	 * @param map
	 * @return 日程列表页面
	 * 
	 * @Author cql
	 * @Date 2011-12-23
	 */
	@RequestMapping("/scheduler/scheduler.htm")
	public String schedulerList(String selectTime, ModelMap map) {
		SchedulerPage schedulerPage = new SchedulerPage();
		if (selectTime == null || "".equals(selectTime)) {
			selectTime = DateUtil.getDateTime();
		}
		schedulerPage.setSelectTime(selectTime);// 设置选择时间
		schedulerPage.setLoginId(SecurityUtils.getLoginId()); // 设置登录Id
		List<Scheduler> list = schedulerService.getSchedulerList(schedulerPage);
		// 设置输出event。xml路径
		String filePath = PropertiesUtil.getFileUploadDir()
				+ "\\schedulerFile\\event.xml";
		try {
			XmlUtil.writeToXml(list, filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "scheduler");
		// 跳转至用户列表页面
		return "/scheduler/scheduler";
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
	@RequestMapping("/scheduler/add_scheduler.htm")
	@ResponseBody
	public String addScheduler(SchedulerForm form) {
		schedulerService.createSchedulerInfo(tobean(form));
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
	@RequestMapping("/scheduler/edit_scheduler.htm")
	@ResponseBody
	public String editScheduler(SchedulerForm form) {
		schedulerService.updateSchedulerInfo(tobean(form));
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
	@RequestMapping("/scheduler/scheduler_list.htm")
	public String schedulerList(SchedulerForm form, ModelMap map) {
		// 用户分页对象初始化
		SchedulerPage schedulerPage = new SchedulerPage();
		// 设置查询条件
		setSearchKey(form, schedulerPage);
		// 取得用户列表,分页显示
		SchedulerPage page = schedulerService
				.getSchedulerInfoList(schedulerPage);
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "scheduler_list");
		// 跳转至用户列表页面
		return "scheduler/scheduler_list";
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
	@RequestMapping("/scheduler/delete_scheduler.htm")
	@ResponseBody
	public String deleteScheduler(Long id) {
		schedulerService.deleteSchedulerInfo(id);
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
	@RequestMapping(value = "/scheduler/edit_scheduler_one.htm", method = RequestMethod.GET)
	public String editScheduler(long id, ModelMap map) {
		map.put("scheduler", schedulerService.selectSchedulerById(id));

		return "scheduler/edit_scheduler";
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
	@RequestMapping("/scheduler/edit_scheduler_one.htm")
	public String editScheduler(SchedulerForm form, ModelMap map) {
		schedulerService.updateScheduler(tobean(form));
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
	private Scheduler tobean(SchedulerForm form) {
		Scheduler scheduler = new Scheduler();
		scheduler.setId(form.getId());
		scheduler.setContent(form.getContent());// 内容
		scheduler.setStartTime(form.getStartTime());// 开始时间
		scheduler.setEndTime(form.getEndTime());// 结束时间
		scheduler.setEnabled(Scheduler.ABLED);
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
	private void setSearchKey(SchedulerForm form, SchedulerPage schedulerPage) {
		// 设置查询条件
		schedulerPage.setCurrentPage(form.getCp()); // 当前页数
		schedulerPage.setStartTime(form.getStartTime()); // 日程开始时间
		schedulerPage.setEndTime(form.getEndTime()); // 日程结束时间
		schedulerPage.setIsRemind(form.getIsRemind());// 是否提醒
		schedulerPage.setLoginId(SecurityUtils.getLoginId()); // 登录人

	}
}
