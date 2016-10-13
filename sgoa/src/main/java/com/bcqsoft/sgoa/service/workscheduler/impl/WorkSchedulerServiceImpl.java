package com.bcqsoft.sgoa.service.workscheduler.impl;

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
import com.bcqsoft.sgoa.dao.workscheduler.WorkSchedulerDAO;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkScheduler;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkSchedulerPage;
import com.bcqsoft.sgoa.service.workscheduler.WorkSchedulerService;

/**
 * 日程模块业务逻辑类实现类
 */
@Service
public class WorkSchedulerServiceImpl extends BaseService implements
		WorkSchedulerService {

	@Autowired
	private WorkSchedulerDAO WorkSchedulerDAO;
	
	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 取得日程管理列表(分页)
	 * 
	 * @param page
	 * @return WorkSchedulerPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	@Override
	public List<WorkScheduler> getWorkSchedulerList(WorkSchedulerPage workSchedulerPage) {
		// 取得日程管理集合(分页查询)
		List<WorkScheduler> workSchedulerList = WorkSchedulerDAO
				.findWorkSchedulerList(workSchedulerPage);
		return workSchedulerList;
	}

	/**
	 * 创建一条新的日程管理
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public boolean createWorkSchedulerInfo(WorkScheduler workScheduler) {
		Long pk = WorkSchedulerDAO.insertIntoWorkScheduler(workScheduler);
		return isInsertSucc(pk);
	}

	/**
	 * 更新日程信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public boolean updateWorkSchedulerInfo(WorkScheduler workScheduler) {
		Integer count = WorkSchedulerDAO.updateWorkSchedulerInfoById(workScheduler);
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
	public boolean deleteWorkSchedulerInfo(Long id) {
		Integer count = WorkSchedulerDAO.updateWorkSchedulerStatusToDisabled(id);
		return isUpdateSucc(count);
	}
	/**
	 * 设置日程提醒信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateWorkScheduler(WorkScheduler workScheduler) {
		Integer count = WorkSchedulerDAO.updateWorkSchedulerById(workScheduler);
		
		RemindPage remindPage = new RemindPage();
		remindPage.setBusId(workScheduler.getId());
		remindPage.setLoginId(workScheduler.getLoginId());
		remindPage.setModeName(CommonChar.MODE_WORK_SCHEDULER);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		List<Remind> remindList = remindDAO.findRemindInfoList(remindPage);
		if (remindList.size() > 0) {
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(workScheduler.getId());
			remind.setLoginId(workScheduler.getLoginId());
			remind.setModeName(CommonChar.MODE_WORK_SCHEDULER);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remind.setStartTime(workScheduler.getStartRemindTime());
			remind.setEndTime(workScheduler.getStartTime());
			remindDAO.updateRemindInfoByLoginId(remind);
		} else {
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(workScheduler.getId());
			remind.setLoginId(workScheduler.getLoginId());
			remind.setModeName(CommonChar.MODE_WORK_SCHEDULER);
			remind.setTitle(workScheduler.getContent());
			remind.setUrl("workscheduler/work_scheduler.htm");
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remind.setStartTime(workScheduler.getStartRemindTime());
			remind.setEndTime(workScheduler.getStartTime());
			remindDAO.insertIntoRemind(remind);
		}
		return isUpdateSucc(count);
	}
	/**
	 * 根据ID查询日程提醒的详细信息
	 * @param id
	 * @return  WorkScheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2012-03-02
	 */
	@Override
	public WorkScheduler selectWorkSchedulerById(long id) {
		return WorkSchedulerDAO.selectWorkSchedulerById(id);
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
	public WorkSchedulerPage getWorkSchedulerInfoList(WorkSchedulerPage workSchedulerPage) {
		int count = WorkSchedulerDAO.findWorkSchedulerInfoCount(workSchedulerPage);

		if (count == 0) {
			return workSchedulerPage;
		}
		// 取得日程提醒集合(分页查询)
		List<WorkScheduler> workSchedulerList = WorkSchedulerDAO.findWorkSchedulerInfoList(workSchedulerPage);

		workSchedulerPage.setTotalRow(count); // 日程提醒总数量
		workSchedulerPage.setWorkSchedulerList(workSchedulerList); // 日程提醒集合
		return workSchedulerPage;
	}

}
