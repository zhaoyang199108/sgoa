package com.bcqsoft.sgoa.service.leaderscheduler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.leaderscheduler.LeaderSchedulerDAO;
import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderScheduler;
import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderSchedulerPage;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.remind.dataobject.RemindPage;
import com.bcqsoft.sgoa.service.leaderscheduler.LeaderSchedulerService;

/**
 * 日程模块业务逻辑类实现类
 */
@Service
public class LeaderSchedulerServiceImpl extends BaseService implements
		LeaderSchedulerService {

	@Autowired
	private LeaderSchedulerDAO LeaderSchedulerDAO;

	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;
	
	/**
	 * 取得日程管理列表(分页)
	 * 
	 * @param page
	 * @return LeaderSchedulerPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	@Override
	public List<LeaderScheduler> getLeaderSchedulerList(LeaderSchedulerPage leaderSchedulerPage) {
		// 取得日程管理集合(分页查询)
		List<LeaderScheduler> leaderSchedulerList = LeaderSchedulerDAO
				.findLeaderSchedulerList(leaderSchedulerPage);
		return leaderSchedulerList;
	}
	
	/**
	 * 取得日程管理列表(分页)
	 * 
	 * @param page
	 * @return LeaderSchedulerPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	@Override
	public List<LeaderScheduler> findLeaderSchedulerCheckList(LeaderSchedulerPage leaderSchedulerPage) {
		// 取得日程管理集合(分页查询)
		List<LeaderScheduler> leaderSchedulerList = LeaderSchedulerDAO
				.findLeaderSchedulerCheckList(leaderSchedulerPage);
		return leaderSchedulerList;
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
	public boolean createLeaderSchedulerInfo(LeaderScheduler leaderScheduler) {
		Long pk = LeaderSchedulerDAO.insertIntoLeaderScheduler(leaderScheduler);
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
	public boolean updateLeaderSchedulerInfo(LeaderScheduler leaderScheduler) {
		Integer count = LeaderSchedulerDAO.updateLeaderSchedulerInfoById(leaderScheduler);
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
	public boolean deleteLeaderSchedulerInfo(Long id) {
		Integer count = LeaderSchedulerDAO.updateLeaderSchedulerStatusToDisabled(id);
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
	public boolean updateLeaderScheduler(LeaderScheduler leaderScheduler) {
		Integer count = LeaderSchedulerDAO.updateLeaderSchedulerById(leaderScheduler);
		
		RemindPage remindPage = new RemindPage();
		remindPage.setBusId(leaderScheduler.getId());
		remindPage.setLoginId(leaderScheduler.getLoginId());
		remindPage.setModeName(CommonChar.MODE_LEADER_SCHEDULER);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		List<Remind> remindList = remindDAO.findRemindInfoList(remindPage);
		if (remindList.size() > 0) {
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(leaderScheduler.getId());
			remind.setLoginId(leaderScheduler.getLoginId());
			remind.setModeName(CommonChar.MODE_LEADER_SCHEDULER);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remind.setStartTime(leaderScheduler.getStartRemindTime());
			remind.setEndTime(leaderScheduler.getStartTime());
			remindDAO.updateRemindInfoByLoginId(remind);
		} else {
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(leaderScheduler.getId());
			remind.setLoginId(leaderScheduler.getLoginId());
			remind.setModeName(CommonChar.MODE_LEADER_SCHEDULER);
			remind.setTitle(leaderScheduler.getContent());
			remind.setUrl("leaderscheduler/leader_scheduler.htm");
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remind.setStartTime(leaderScheduler.getStartRemindTime());
			remind.setEndTime(leaderScheduler.getStartTime());
			remindDAO.insertIntoRemind(remind);
		}
		return isUpdateSucc(count);
	}
	/**
	 * 根据ID查询日程提醒的详细信息
	 * @param id
	 * @return  LeaderScheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2012-03-02
	 */
	@Override
	public LeaderScheduler selectLeaderSchedulerById(long id) {
		return LeaderSchedulerDAO.selectLeaderSchedulerById(id);
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
	public LeaderSchedulerPage getLeaderSchedulerInfoList(LeaderSchedulerPage leaderSchedulerPage) {
		int count = LeaderSchedulerDAO.findLeaderSchedulerInfoCount(leaderSchedulerPage);

		if (count == 0) {
			return leaderSchedulerPage;
		}
		// 取得日程提醒集合(分页查询)
		List<LeaderScheduler> leaderSchedulerList = LeaderSchedulerDAO.findLeaderSchedulerInfoList(leaderSchedulerPage);

		leaderSchedulerPage.setTotalRow(count); // 日程提醒总数量
		leaderSchedulerPage.setLeaderSchedulerList(leaderSchedulerList); // 日程提醒集合
		return leaderSchedulerPage;
	}

}
