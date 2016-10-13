package com.bcqsoft.sgoa.dao.scheduler;

import java.util.List;

import com.bcqsoft.sgoa.dao.scheduler.dataobject.Scheduler;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.SchedulerPage;

/**
 * 日程表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_SCHEDULE
 * </pre>
 */
public interface SchedulerDAO {
	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	List<Scheduler> findSchedulerList(SchedulerPage schedulerPage);

	/**
	 * 插入一条信息至日程管理
	 * 
	 * @param scheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Long insertIntoScheduler(Scheduler scheduler);

	/**
	 * 更新日程信息
	 * 
	 * @param scheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Integer updateSchedulerInfoById(Scheduler scheduler);

	/**
	 * 根据ID删除某条日程信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Integer updateSchedulerStatusToDisabled(Long id);

	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	List<Scheduler> findSchedulerListForDay(SchedulerPage schedulerPage);
	
	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	Integer findSchedulerListForAlert(SchedulerPage schedulerPage);

	/**
	 * 更新日程信息
	 * 
	 * @param scheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Integer updateSchedulerById(Scheduler scheduler);
	/**
	 * 根据ID查询日程提醒的详细信息
	 * @param id
	 * @return  scheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2012-03-02
	 */

	Scheduler selectSchedulerById(long id);

	/**
	 * 查找日程提醒数量
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;Scheduler&gt;
	 */
	Integer findSchedulerInfoCount(SchedulerPage schedulerPage);
	/**
	 * 查找日程体醒
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;Scheduler&gt;
	 */
	List<Scheduler> findSchedulerInfoList(SchedulerPage schedulerPage);

}
