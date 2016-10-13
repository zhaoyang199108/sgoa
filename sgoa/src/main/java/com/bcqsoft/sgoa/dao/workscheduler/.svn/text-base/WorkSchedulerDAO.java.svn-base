package com.bcqsoft.sgoa.dao.workscheduler;

import java.util.List;

import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkScheduler;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkSchedulerPage;



/**
 * 日程表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_SCHEDULE
 * </pre>
 */
public interface WorkSchedulerDAO {
	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	List<WorkScheduler> findWorkSchedulerList(WorkSchedulerPage workSchedulerPage);

	/**
	 * 插入一条信息至日程管理
	 * 
	 * @param LeaderScheduler
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Long insertIntoWorkScheduler(WorkScheduler workScheduler);

	/**
	 * 更新日程信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Integer updateWorkSchedulerInfoById(WorkScheduler workScheduler);

	/**
	 * 根据ID删除某条日程信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Integer updateWorkSchedulerStatusToDisabled(Long id);

	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	List<WorkScheduler> findWorkSchedulerListForDay(WorkSchedulerPage workSchedulerPage);
	
	/**
	 * 根据查询条件查询符合条件的日程管理
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-23
	 */
	Integer findWorkSchedulerListForAlert(WorkSchedulerPage workSchedulerPage);

	/**
	 * 更新日程信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	Integer updateWorkSchedulerById(WorkScheduler workScheduler);
	/**
	 * 根据ID查询日程提醒的详细信息
	 * @param id
	 * @return  WorkScheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2012-03-02
	 */

	WorkScheduler selectWorkSchedulerById(long id);

	/**
	 * 查找日程提醒数量
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;WorkScheduler&gt;
	 */
	Integer findWorkSchedulerInfoCount(WorkSchedulerPage workSchedulerPage);
	/**
	 * 查找日程体醒
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;WorkScheduler&gt;
	 */
	List<WorkScheduler> findWorkSchedulerInfoList(WorkSchedulerPage workSchedulerPage);

}
