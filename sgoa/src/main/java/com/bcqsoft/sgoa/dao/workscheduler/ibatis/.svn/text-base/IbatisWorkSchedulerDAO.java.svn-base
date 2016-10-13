package com.bcqsoft.sgoa.dao.workscheduler.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.workscheduler.WorkSchedulerDAO;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkScheduler;
import com.bcqsoft.sgoa.dao.workscheduler.dataobject.WorkSchedulerPage;


/**
 * 日程表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_SCHEDULE
 * </pre>
 */
@Repository
public class IbatisWorkSchedulerDAO extends BaseDAO implements WorkSchedulerDAO {

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
	public List<WorkScheduler> findWorkSchedulerList(WorkSchedulerPage workSchedulerPage) {
		return (List<WorkScheduler>) ibatis().queryForList("workScheduler.findWorkSchedulerList", workSchedulerPage);
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
	public Long insertIntoWorkScheduler(WorkScheduler workScheduler) {
		return (Long) ibatis().insert("workScheduler.insertIntoWorkScheduler", workScheduler);
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
	public Integer updateWorkSchedulerInfoById(WorkScheduler workScheduler) {
		return (Integer) ibatis().update("workScheduler.updateWorkSchedulerInfoById", workScheduler);
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
	public Integer updateWorkSchedulerStatusToDisabled(Long id) {
		return (Integer) ibatis().update("workScheduler.updateWorkSchedulerStatusToDisabled", id);
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
	public List<WorkScheduler> findWorkSchedulerListForDay(WorkSchedulerPage workSchedulerPage) {
		return (List<WorkScheduler>) ibatis().queryForList("workScheduler.findWorkSchedulerListForDay", workSchedulerPage);
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
	public Integer findWorkSchedulerListForAlert(WorkSchedulerPage workSchedulerPage) {
		return (Integer) ibatis().queryForObject("workScheduler.findWorkSchedulerListForAlert", workSchedulerPage);
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
	public Integer updateWorkSchedulerById(WorkScheduler workScheduler) {
		return (Integer) ibatis().update("workScheduler.updateWorkSchedulerById", workScheduler);
	}

	/**
	 * 根据ID查询日程提醒的详细信息
	 * 
	 * @param id
	 * @return WorkScheduler
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-03-02
	 */
	@Override
	public WorkScheduler selectWorkSchedulerById(long id) {

		return (WorkScheduler) ibatis().queryForObject("workScheduler.selectWorkSchedulerById", id);
	}

	/**
	 * 
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;WorkScheduler&gt;
	 */
	@Override
	public Integer findWorkSchedulerInfoCount(WorkSchedulerPage workSchedulerPage) {		
		return (Integer) ibatis().queryForObject("workScheduler.findWorkSchedulerInfoCount", workSchedulerPage);
	}
	/**
	 * 查找日程体醒
	 * 
	 * @author cql2109
	 * @date 2012-03-02
	 * @return List&lt;WorkScheduler&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<WorkScheduler> findWorkSchedulerInfoList(WorkSchedulerPage workSchedulerPage) {
		return (List<WorkScheduler>) ibatis().queryForList("workScheduler.findWorkSchedulerInfoList", workSchedulerPage);
	}
}

