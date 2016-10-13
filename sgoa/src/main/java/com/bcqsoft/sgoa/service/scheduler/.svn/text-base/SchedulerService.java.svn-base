package com.bcqsoft.sgoa.service.scheduler;
import java.util.List;

import com.bcqsoft.sgoa.dao.scheduler.dataobject.Scheduler;
import com.bcqsoft.sgoa.dao.scheduler.dataobject.SchedulerPage;

/**
 * 日程模块业务逻辑类接口
 */
public interface SchedulerService {
	
	/**
	 * 取得日程管理列表(分页)
	 * 
	 * @param page
	 * @return schedulerPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	List<Scheduler>  getSchedulerList(SchedulerPage schedulerPage);
	/**
	 * 创建一条新的日程管理
	 * 
	 * @param scheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean createSchedulerInfo(Scheduler scheduler);
	/**
	 * 更新日程列表信息
	 * 
	 * @param scheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean updateSchedulerInfo(Scheduler scheduler);
	
	
	/**
	 * 删除一条日程(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean deleteSchedulerInfo(Long id);
	/**
	 * 根据查询条件查找日程提醒列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-03-02
	 */
	SchedulerPage getSchedulerInfoList(SchedulerPage schedulerPage);
	
	/**
	 * 设置日程提醒信息
	 * 
	 * @param scheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean updateScheduler(Scheduler scheduler);
	/**
	 * 根据ID查询日程提醒的详细信息
	 * @param id
	 * @return  scheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2012-03-02
	 */
	Scheduler selectSchedulerById(long id);
	
}
