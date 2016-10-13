package com.bcqsoft.sgoa.dao.leaderscheduler.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.leaderscheduler.LeaderSchedulerDAO;
import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderScheduler;
import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderSchedulerPage;


/**
 * 日程表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_LEADER_SCHEDULE
 * </pre>
 */
@Repository
public class IbatisLeaderSchedulerDAO extends BaseDAO implements LeaderSchedulerDAO {

	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param LeaderScheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LeaderScheduler> findLeaderSchedulerList(LeaderSchedulerPage leaderSchedulerPage) {
		return (List<LeaderScheduler>) ibatis().queryForList("leaderScheduler.findLeaderSchedulerList", leaderSchedulerPage);
	}
	
	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param LeaderScheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LeaderScheduler> findLeaderSchedulerCheckList(LeaderSchedulerPage leaderSchedulerPage) {
		return (List<LeaderScheduler>) ibatis().queryForList("leaderScheduler.findLeaderSchedulerCheckList", leaderSchedulerPage);
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
	public Long insertIntoLeaderScheduler(LeaderScheduler leaderScheduler) {
		return (Long) ibatis().insert("leaderScheduler.insertIntoLeaderScheduler", leaderScheduler);
	}

	/**
	 * 根据ID更新某条日程信息
	 * 
	 * @param LeaderScheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public Integer updateLeaderSchedulerInfoById(LeaderScheduler leaderScheduler) {
		return (Integer) ibatis().update("leaderScheduler.updateLeaderSchedulerInfoById", leaderScheduler);
	}

	/**
	 * 根据ID删除某条日程信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public Integer updateLeaderSchedulerStatusToDisabled(Long id) {
		return (Integer) ibatis().update("leaderScheduler.updateLeaderSchedulerStatusToDisabled", id);
	}

	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param LeaderScheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LeaderScheduler> findLeaderSchedulerListForDay(LeaderSchedulerPage leaderSchedulerPage) {
		return (List<LeaderScheduler>) ibatis().queryForList("leaderScheduler.findLeaderSchedulerListForDay", leaderSchedulerPage);
	}

	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	public Integer findLeaderSchedulerListForAlert(LeaderSchedulerPage leaderSchedulerPage) {
		return (Integer) ibatis().queryForObject("leaderScheduler.findLeaderSchedulerListForAlert", leaderSchedulerPage);
	}
	/**
	 * 根据ID设置某条日程提醒信息
	 * 
	 * @param LeaderScheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public Integer updateLeaderSchedulerById(LeaderScheduler leaderScheduler) {
		return (Integer) ibatis().update("leaderScheduler.updateLeaderSchedulerById", leaderScheduler);
	}

	/**
	 * 根据ID查询日程提醒的详细信息
	 * 
	 * @param id
	 * @return LeaderScheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-03-02
	 */
	@Override
	public LeaderScheduler selectLeaderSchedulerById(long id) {

		return (LeaderScheduler) ibatis().queryForObject("leaderScheduler.selectLeaderSchedulerById", id);
	}

	/**
	 * 
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;LeaderScheduler&gt;
	 */
	@Override
	public Integer findLeaderSchedulerInfoCount(LeaderSchedulerPage leaderSchedulerPage) {		
		return (Integer) ibatis().queryForObject("leaderScheduler.findLeaderSchedulerInfoCount", leaderSchedulerPage);
	}
	/**
	 * 查找日程体醒
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;LeaderScheduler&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LeaderScheduler> findLeaderSchedulerInfoList(LeaderSchedulerPage leaderSchedulerPage) {
		return (List<LeaderScheduler>) ibatis().queryForList("leaderScheduler.findLeaderSchedulerInfoList", leaderSchedulerPage);
	}
}

