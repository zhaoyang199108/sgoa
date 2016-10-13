package com.bcqsoft.sgoa.dao.dept.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.dept.DeptDAO;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.dept.dataobject.DeptPage;

/**
 * 部门科室表(记录当前单位科室及下属单位科室)数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DEPT
 * </pre>
 */
@Repository
public class IbatisDeptDAO extends BaseDAO implements DeptDAO {
	/**
	 * 查找直属的部门信息列表
	 * 
	 * @return 部门信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<Dept> findUnitImmediateDept() {
		return (List<Dept>) ibatis().queryForList("dept.findUnitImmediateDept");
	}

	/**
	 * 查找全部部门信息列表
	 * 
	 * @return 部门信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<Dept> findAllDeptInfo() {
		return (List<Dept>) ibatis().queryForList("dept.findAllDeptInfo");
	}

	/**
	 * 查找全部部门信息列表
	 * 
	 * @return 部门信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<Dept> findAllDeptLogin(Map<String, Object> data) {
		return (List<Dept>) ibatis()
				.queryForList("dept.findAllDeptLogin", data);
	}

	/**
	 * 插入一条信息至部门表
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Long insertIntoDept(Dept dept) {
		return (Long) ibatis().insert("dept.insertIntoDept", dept);
	}

	/**
	 * 根据查询条件查询符合条件的部门(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */

	public Integer findDeptInfoCount(DeptPage page) {
		return (Integer) ibatis()
				.queryForObject("dept.findDeptInfoCount", page);
	}

	/**
	 * 根据查询条件查询符合条件的部门
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */

	@SuppressWarnings("unchecked")
	public List<Dept> findDeptInfoList(DeptPage page) {
		return (List<Dept>) ibatis()
				.queryForList("dept.findDeptInfoList", page);
	}

	/**
	 * 根据ID查询某一条通告通知
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Dept findDeptInfoById(long id) {
		return (Dept) ibatis().queryForObject("dept.findDeptInfoById", id);
	}

	/**
	 * 根据ID更新某条部门信息
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Integer updateDeptInfoById(Dept dept) {
		return (Integer) ibatis().update("dept.updateDeptInfoById", dept);
	}

	/**
	 * 根据ID删除某条部门信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Integer updateDeptStatusToDisabled(Map<String, Object> data) {
		return (Integer) ibatis().update("dept.updateDeptStatusToDisabled",
				data);
	}

	/**
	 * 根据用户登录ID查询部门信息
	 * 
	 * @param loginId
	 * @return 部门信息
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Dept findDeptInfoByLoginId(String loginId) {
		return (Dept) ibatis().queryForObject("dept.findDeptInfoByLoginId",
				loginId);
	}
}
