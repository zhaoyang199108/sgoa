package com.bcqsoft.sgoa.mvc.controller.leaderscheduler;

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
import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderScheduler;
import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderSchedulerPage;
import com.bcqsoft.sgoa.mvc.form.leaderscheduler.LeaderSchedulerForm;
import com.bcqsoft.sgoa.service.leaderscheduler.LeaderSchedulerService;

@Controller
public class LeaderSchedulerController {
	/**
	 * 日程模块业务逻辑类接口
	 */
	@Autowired
	private LeaderSchedulerService leaderSchedulerService;

	/**
	 * 取得日程信息列表
	 * 
	 * @param map
	 * @return 日程列表页面
	 * 
	 * @Author cql
	 * @Date 2011-12-23
	 */
	@RequestMapping("/leaderscheduler/leader_scheduler.htm")
	public String schedulerList(String selectTime,String loginId,String userName,ModelMap map) {
		LeaderSchedulerPage schedulerPage = new LeaderSchedulerPage();
		if (selectTime == null || "".equals(selectTime)) {
			selectTime = DateUtil.getDateTime();
		}
		schedulerPage.setSelectTime(selectTime);// 设置选择时间
		schedulerPage.setLoginId(loginId); // 设置登录Id
		schedulerPage.setUserName(userName);
		map.put("page", schedulerPage);
		List<LeaderScheduler> list = leaderSchedulerService.getLeaderSchedulerList(schedulerPage);
		// 设置输出event。xml路径
		String filePath = PropertiesUtil.getFileUploadDir()
				+ "\\schedulerFile\\leader_event.xml";
		try {
			XmlUtil.writeToLeaderSchedulerXml(list, filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "leader_scheduler");
		// 跳转至用户列表页面
		return "/leaderscheduler/leader_scheduler";
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
	@RequestMapping("/leaderscheduler/leader_scheduler_check.htm")
	public String schedulerCheckList(String selectTime,String loginId,String userName,ModelMap map) {
		LeaderSchedulerPage schedulerPage = new LeaderSchedulerPage();
		if (selectTime == null || "".equals(selectTime)) {
			selectTime = DateUtil.getDateTime();
		}
		schedulerPage.setSelectTime(selectTime);// 设置选择时间
		schedulerPage.setLoginId(loginId); // 设置登录Id
		schedulerPage.setUserName(userName);
		map.put("page", schedulerPage);
		List<LeaderScheduler> list = leaderSchedulerService.findLeaderSchedulerCheckList(schedulerPage);
		// 设置输出event。xml路径
		String filePath = PropertiesUtil.getFileUploadDir()
				+ "\\schedulerFile\\leader_event.xml";
		try {
			XmlUtil.writeToLeaderSchedulerAllXml(list, filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "leader_scheduler_check");
		// 跳转至用户列表页面
		return "/leaderscheduler/leader_scheduler_check";
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
	@RequestMapping("/leaderscheduler/add_leaderscheduler.htm")
	@ResponseBody
	public String addLeaderScheduler(LeaderSchedulerForm form) {
		leaderSchedulerService.createLeaderSchedulerInfo(tobean(form));
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
	@RequestMapping("/leaderscheduler/edit_leaderscheduler.htm")
	@ResponseBody
	public String editLeaderScheduler(LeaderSchedulerForm form) {
		leaderSchedulerService.updateLeaderSchedulerInfo(tobean(form));
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
	@RequestMapping("/leaderscheduler/leaderscheduler_list.htm")
	public String schedulerList(LeaderSchedulerForm form, ModelMap map) {
		// 用户分页对象初始化
		LeaderSchedulerPage schedulerPage = new LeaderSchedulerPage();
		// 设置查询条件
		setSearchKey(form, schedulerPage);
		schedulerPage.setLoginId(form.getLoginId());
		// 取得用户列表,分页显示
		LeaderSchedulerPage page = leaderSchedulerService
				.getLeaderSchedulerInfoList(schedulerPage);
		map.put("page", page);
		map.put("schedulerPage", schedulerPage);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "leaderscheduler_list");
		// 跳转至用户列表页面
		return "leaderscheduler/leaderscheduler_list";
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
	@RequestMapping(value = "/leaderscheduler/edit_leaderscheduler_one.htm", method = RequestMethod.GET)
	public String editScheduler(long id, ModelMap map) {
		map.put("scheduler", leaderSchedulerService.selectLeaderSchedulerById(id));

		return "leaderscheduler/edit_workscheduler";
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
	@RequestMapping("/leaderscheduler/edit_leaderscheduler_one.htm")
	public String editScheduler(LeaderSchedulerForm form, ModelMap map) {
		leaderSchedulerService.updateLeaderScheduler(tobean(form));
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
	@RequestMapping("/leaderscheduler/delete_scheduler.htm")
	@ResponseBody
	public String deleteLeaderScheduler(Long id) {
		leaderSchedulerService.deleteLeaderSchedulerInfo(id);
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
	@RequestMapping(value = "/leaderscheduler/edit_leaderscheduler_alert.htm", method = RequestMethod.GET)
	public String editLeaderScheduler(long id, ModelMap map) {
		map.put("leaderScheduler", leaderSchedulerService.selectLeaderSchedulerById(id));

		return "leaderscheduler/edit_leaderscheduler";
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
	@RequestMapping("/leaderscheduler/edit_leaderscheduler_alert.htm")
	public String editLeaderScheduler(LeaderSchedulerForm form, ModelMap map) {
		leaderSchedulerService.updateLeaderScheduler(tobean(form));
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
	private LeaderScheduler tobean(LeaderSchedulerForm form) {
		LeaderScheduler scheduler = new LeaderScheduler();
		scheduler.setId(form.getId());
		scheduler.setContent(form.getContent());// 内容
		scheduler.setStartTime(form.getStartTime());// 开始时间
		scheduler.setEndTime(form.getEndTime());// 结束时间
		scheduler.setEnabled(LeaderScheduler.ABLED);
		scheduler.setLoginId(form.getLoginId());
		scheduler.setStartRemindTime(form.getStartRemindTime());// 提醒时间
		scheduler.setIsRemind(form.getIsRemind());// 状态
		scheduler.setCurrentOptId(SecurityUtils.getLoginId());
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
	private void setSearchKey(LeaderSchedulerForm form, LeaderSchedulerPage schedulerPage) {
		// 设置查询条件
		schedulerPage.setCurrentPage(form.getCp()); // 当前页数
		schedulerPage.setStartTime(form.getStartTime()); // 日程开始时间
		schedulerPage.setEndTime(form.getEndTime()); // 日程结束时间
		schedulerPage.setIsRemind(form.getIsRemind());// 是否提醒
		schedulerPage.setUserName(form.getUserName());
	}
}
