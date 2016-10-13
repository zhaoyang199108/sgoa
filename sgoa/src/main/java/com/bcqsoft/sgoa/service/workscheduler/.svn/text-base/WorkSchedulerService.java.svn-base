package com.bcqsoft.sgoa.service.workscheduler;
import java.util.List;

import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkScheduler;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkSchedulerPage;

/**
 * 日程模块业务逻辑类接口
 */
public interface WorkSchedulerService {
	
	/**
	 * 取得日程管理列表(分页)
	 * 
	 * @param page
	 * @return WorkSchedulerPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	List<WorkScheduler>  getWorkSchedulerList(WorkSchedulerPage workSchedulerPage);
	/**
	 * 创建一条新的日程管理
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean createWorkSchedulerInfo(WorkScheduler workScheduler);
	/**
	 * 更新日程列表信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean updateWorkSchedulerInfo(WorkScheduler workScheduler);
	
	
	/**
	 * 删除一条日程(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean deleteWorkSchedulerInfo(Long id);
	/**
	 * 根据查询条件查找日程提醒列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-03-02
	 */
	WorkSchedulerPage getWorkSchedulerInfoList(WorkSchedulerPage workSchedulerPage);
	
	/**
	 * 设置日程提醒信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean updateWorkScheduler(WorkScheduler workScheduler);
	/**
	 * 根据ID查询日程提醒的详细信息
	 * @param id
	 * @return  WorkScheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2012-03-02
	 */
	WorkScheduler selectWorkSchedulerById(long id);
	
}
