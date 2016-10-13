package com.bcqsoft.sgoa.service.dept;

import java.util.List;

import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;

public interface DeptService {
	/**
	 * 添加部门信息
	 * 
	 * @param dept
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */

	boolean createDeptInfo(Dept dept);

	/**
	 * 更新部门信息
	 * 
	 * @param dept
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	boolean updateDeptInfo(Dept dept);

	/**
	 * 取得部门列表(分页)
	 * 
	 * @param page
	 * @return DeptPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	List<Dept> getDeptListByAll();

	/**
	 * 删除一条部门(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	void deleteDeptInfo(Long id);

	/**
	 * 取得部门详细信息
	 * 
	 * @param id
	 * @return Dept
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Dept getDeptDetailInfo(Long id);

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
