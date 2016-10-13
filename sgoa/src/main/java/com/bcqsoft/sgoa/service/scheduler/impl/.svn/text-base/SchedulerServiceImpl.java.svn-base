package com.bcqsoft.sgoa.service.scheduler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.remind.dataobject.RemindPage;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.Scheduler;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.SchedulerPage;
import com.bcqsoft.sgoa.dao.scheduler.SchedulerDAO;
import com.bcqsoft.sgoa.service.scheduler.SchedulerService;

/**
 * 日程模块业务逻辑类实现类
 */
@Service
public class SchedulerServiceImpl extends BaseService implements
		SchedulerService {

	@Autowired
	private SchedulerDAO schedulerDAO;
	
	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 取得日程管理列表(分页)
	 * 
	 * @param page
	 * @return schedulerPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	@Override
	public List<Scheduler> getSchedulerList(SchedulerPage schedulerPage) {
		// 取得日程管理集合(分页查询)
		List<Scheduler> schedulerList = schedulerDAO
				.findSchedulerList(schedulerPage);
		return schedulerList;
	}

	/**
	 * 创建一条新的日程管理
	 * 
	 * @param scheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public boolean createSchedulerInfo(Scheduler scheduler) {
		Long pk = schedulerDAO.insertIntoScheduler(scheduler);
		return isInsertSucc(pk);
	}

	/**
	 * 更新日程信息
	 * 
	 * @param scheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public boolean updateSchedulerInfo(Scheduler scheduler) {
		Integer count = schedulerDAO.updateSchedulerInfoById(scheduler);
		return isUpdateSucc(count);
	}

	/**
	 * 删除一条日程(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public boolean deleteSchedulerInfo(Long id) {
		Integer count = schedulerDAO.updateSchedulerStatusToDisabled(id);
		return isUpdateSucc(count);
	}
	/**
	 * 设置日程提醒信息
	 * 
	 * @param scheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateScheduler(Scheduler scheduler) {
		Integer count = schedulerDAO.updateSchedulerById(scheduler);
		
		RemindPage remindPage = new RemindPage();
		remindPage.setBusId(scheduler.getId());
		remindPage.setLoginId(scheduler.getLoginId());
		remindPage.setModeName(CommonChar.MODE_SCHEDULER);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		List<Remind> remindList = remindDAO.findRemindInfoList(remindPage);
		
		if (remindList.size() > 0) {
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(scheduler.getId());
			remind.setLoginId(scheduler.getLoginId());
			remind.setModeName(CommonChar.MODE_SCHEDULER);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remind.setStartTime(scheduler.getStartRemindTime());
			remind.setEndTime(scheduler.getStartTime());
			remindDAO.updateRemindInfoByLoginId(remind);
		} else {
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(scheduler.getId());
			remind.setLoginId(scheduler.getLoginId());
			remind.setModeName(CommonChar.MODE_SCHEDULER);
			remind.setTitle(scheduler.getContent());
			remind.setUrl("scheduler/scheduler.htm");
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remind.setStartTime(scheduler.getStartRemindTime());
			remind.setEndTime(scheduler.getStartTime());
			remindDAO.insertIntoRemind(remind);
		}
		
		return isUpdateSucc(count);
	}
	/**
	 * 根据ID查询日程提醒的详细信息
	 * @param id
	 * @return  scheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2012-03-02
	 */
	@Override
	public Scheduler selectSchedulerById(long id) {
		return schedulerDAO.selectSchedulerById(id);
	}
	/**
	 * 根据查询条件查找日程提醒列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-03-02
	 */
	@Override
	public SchedulerPage getSchedulerInfoList(SchedulerPage schedulerPage) {
		int count = schedulerDAO.findSchedulerInfoCount(schedulerPage);

		if (count == 0) {
			return schedulerPage;
		}
		// 取得日程提醒集合(分页查询)
		List<Scheduler> schedulerList = schedulerDAO.findSchedulerInfoList(schedulerPage);

		schedulerPage.setTotalRow(count); // 日程提醒总数量
		schedulerPage.setSchedulerList(schedulerList); // 日程提醒集合
		return schedulerPage;
	}

}
