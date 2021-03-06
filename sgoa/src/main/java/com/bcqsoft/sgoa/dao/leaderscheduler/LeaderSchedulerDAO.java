package com.bcqsoft.sgoa.dao.leaderscheduler;

import java.util.List;

import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderScheduler;
import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderSchedulerPage;



/**
 * 日程表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_SCHEDULE
 * </pre>
 */
public interface LeaderSchedulerDAO {
	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	List<LeaderScheduler> findLeaderSchedulerList(LeaderSchedulerPage leaderSchedulerPage);

	/**
	 * 插入一条信息至日程管理
	 * 
	 * @param LeaderScheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Long insertIntoLeaderScheduler(LeaderScheduler leaderScheduler);

	/**
	 * 更新日程信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Integer updateLeaderSchedulerInfoById(LeaderScheduler leaderScheduler);

	/**
	 * 根据ID删除某条日程信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Integer updateLeaderSchedulerStatusToDisabled(Long id);

	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	List<LeaderScheduler> findLeaderSchedulerListForDay(LeaderSchedulerPage leaderSchedulerPage);
	
	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param LeaderScheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	List<LeaderScheduler> findLeaderSchedulerCheckList(LeaderSchedulerPage leaderSchedulerPage);
	
	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	Integer findLeaderSchedulerListForAlert(LeaderSchedulerPage leaderSchedulerPage);

	/**
	 * 更新日程信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Integer updateLeaderSchedulerById(LeaderScheduler leaderScheduler);
	/**
	 * 根据ID查询日程提醒的详细信息
	 * @param id
	 * @return  LeaderScheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2012-03-02
	 */

	LeaderScheduler selectLeaderSchedulerById(long id);

	/**
	 * 查找日程提醒数量
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;LeaderScheduler&gt;
	 */
	Integer findLeaderSchedulerInfoCount(LeaderSchedulerPage leaderSchedulerPage);
	/**
	 * 查找日程体醒
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;LeaderScheduler&gt;
	 */
	List<LeaderScheduler> findLeaderSchedulerInfoList(LeaderSchedulerPage leaderSchedulerPage);

}
