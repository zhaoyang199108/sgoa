package com.bcqsoft.sgoa.dao.dept;

import java.util.List;
import java.util.Map;

import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.dept.dataobject.DeptPage;

/**
 * 部门科室表(记录当前单位科室及下属单位科室)数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DEPT
 * </pre>
 */
public interface DeptDAO {

	/**
	 * 查找直属的部门信息列表
	 * 
	 * @return 部门信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<Dept> findUnitImmediateDept();

	/**
	 * 查找全部部门信息列表
	 * 
	 * @return 部门信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<Dept> findAllDeptInfo();

	/**
	 * 查找全部部门信息列表
	 * 
	 * @return 部门信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<Dept> findAllDeptLogin(Map<String, Object> data);

	/**
	 * 插入信息至部门表
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Long insertIntoDept(Dept dept);

	/**
	 * 根据查询条件查询符合条件的部门(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-09
	 */
	Integer findDeptInfoCount(DeptPage page);

	/**
	 * 根据查询条件查询符合条件的部门
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-09
	 */

	List<Dept> findDeptInfoList(DeptPage page);

	/**
	 * 根据ID查询某一条部门
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Dept findDeptInfoById(long id);

	/**
	 * 根据ID更新某条部门信息
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Integer updateDeptInfoById(Dept dept);

	/**
	 * 根据ID删除某条部门信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Integer updateDeptStatusToDisabled(Map<String, Object> map);

	/**
	 * 根据用户登录ID查询部门信息
	 * 
	 * @param loginId
	 * @return 部门信息
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Dept findDeptInfoByLoginId(String loginId);
}
