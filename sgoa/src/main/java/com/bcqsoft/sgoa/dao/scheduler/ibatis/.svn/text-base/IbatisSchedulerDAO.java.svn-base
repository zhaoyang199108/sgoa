package com.bcqsoft.sgoa.dao.scheduler.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.scheduler.SchedulerDAO;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.Scheduler;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.SchedulerPage;


/**
 * 日程表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_SCHEDULE
 * </pre>
 */
@Repository
public class IbatisSchedulerDAO extends BaseDAO implements SchedulerDAO {

	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param scheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Scheduler> findSchedulerList(SchedulerPage schedulerPage) {
		return (List<Scheduler>) ibatis().queryForList("scheduler.findSchedulerList", schedulerPage);
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
	public Long insertIntoScheduler(Scheduler scheduler) {
		return (Long) ibatis().insert("scheduler.insertIntoScheduler", scheduler);
	}

	/**
	 * 根据ID更新某条日程信息
	 * 
	 * @param scheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public Integer updateSchedulerInfoById(Scheduler scheduler) {
		return (Integer) ibatis().update("scheduler.updateSchedulerInfoById", scheduler);
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
	public Integer updateSchedulerStatusToDisabled(Long id) {
		return (Integer) ibatis().update("scheduler.updateSchedulerStatusToDisabled", id);
	}

	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param scheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Scheduler> findSchedulerListForDay(SchedulerPage schedulerPage) {
		return (List<Scheduler>) ibatis().queryForList("scheduler.findSchedulerListForDay", schedulerPage);
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
	public Integer findSchedulerListForAlert(SchedulerPage schedulerPage) {
		return (Integer) ibatis().queryForObject("scheduler.findSchedulerListForAlert", schedulerPage);
	}
	/**
	 * 根据ID设置某条日程提醒信息
	 * 
	 * @param scheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	@Override
	public Integer updateSchedulerById(Scheduler scheduler) {
		return (Integer) ibatis().update("scheduler.updateSchedulerById", scheduler);
	}

	/**
	 * 根据ID查询日程提醒的详细信息
	 * 
	 * @param id
	 * @return scheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-03-02
	 */
	@Override
	public Scheduler selectSchedulerById(long id) {

		return (Scheduler) ibatis().queryForObject("scheduler.selectSchedulerById", id);
	}

	/**
	 * 
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;Scheduler&gt;
	 */
	@Override
	public Integer findSchedulerInfoCount(SchedulerPage schedulerPage) {		
		return (Integer) ibatis().queryForObject("scheduler.findSchedulerInfoCount", schedulerPage);
	}
	/**
	 * 查找日程体醒
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;Scheduler&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Scheduler> findSchedulerInfoList(SchedulerPage schedulerPage) {
		return (List<Scheduler>) ibatis().queryForList("scheduler.findSchedulerInfoList", schedulerPage);
	}
}

