package com.bcqsoft.sgoa.service.leaderscheduler;
import java.util.List;

import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderScheduler;
import com.bcqsoft.sgoa.dao.leaderscheduler.dataobject.LeaderSchedulerPage;

/**
 * 日程模块业务逻辑类接口
 */
public interface LeaderSchedulerService {
	
	/**
	 * 取得日程管理列表(分页)
	 * 
	 * @param page
	 * @return LeaderSchedulerPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	List<LeaderScheduler>  getLeaderSchedulerList(LeaderSchedulerPage leaderSchedulerPage);
	
	/**
	 * 取得日程管理列表(分页)
	 * 
	 * @param page
	 * @return LeaderSchedulerPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-23
	 */
	List<LeaderScheduler>  findLeaderSchedulerCheckList(LeaderSchedulerPage leaderSchedulerPage);
	/**
	 * 创建一条新的日程管理
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean createLeaderSchedulerInfo(LeaderScheduler leaderScheduler);
	/**
	 * 更新日程列表信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean updateLeaderSchedulerInfo(LeaderScheduler leaderScheduler);
	
	
	/**
	 * 删除一条日程(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean deleteLeaderSchedulerInfo(Long id);
	/**
	 * 根据查询条件查找日程提醒列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-03-02
	 */
	LeaderSchedulerPage getLeaderSchedulerInfoList(LeaderSchedulerPage leaderSchedulerPage);
	
	/**
	 * 设置日程提醒信息
	 * 
	 * @param LeaderScheduler
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-26
	 */
	boolean updateLeaderScheduler(LeaderScheduler leaderScheduler);
	/**
	 * 根据ID查询日程提醒的详细信息
	 * @param id
	 * @return  LeaderScheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date  2012-03-02
	 */
	LeaderScheduler selectLeaderSchedulerById(long id);
	
}
