package com.bcqsoft.sgoa.service.dept.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.dept.DeptDAO;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.user.UserDAO;
import com.bcqsoft.sgoa.service.dept.DeptService;

@Service
public class DeptServiceImpl extends BaseService implements DeptService {
	/**
	 * 部门模块的DAO实现类
	 */
	@Autowired
	private DeptDAO deptDAO;
	/**
	 * 用户模块DAO实现类
	 */
	@Autowired
	private UserDAO userDAO;
	/**
	 * 部门列表ID
	 * 
	 */
	private List<Long> strList = null;

	/**
	 * 创建一条新的部门
	 * 
	 * @param dept
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public boolean createDeptInfo(Dept dept) {
		Long pk = deptDAO.insertIntoDept(dept);
		return isInsertSucc(pk);
	}

	/**
	 * 更新部门信息
	 * 
	 * @param dept
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public boolean updateDeptInfo(Dept dept) {
		Integer count = deptDAO.updateDeptInfoById(dept);
		return isUpdateSucc(count);
	}

	/**
	 * 取得部门列表(分页)
	 * 
	 * @param page
	 * @return DeptPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public List<Dept> getDeptListByAll() {
		// 取得部门集合(分页查询)
		List<Dept> deptList = deptDAO.findAllDeptInfo();
		return deptList;
	}

	/**
	 * 删除一条部门(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public void deleteDeptInfo(Long id) {
		// 取得所有部门列表
		List<Dept> deptList = deptDAO.findAllDeptInfo();
		strList = new ArrayList<Long>();
		// 取得登录人部门下的所有部门ID
		getNodeString(deptList, id);
		// 对部门下的所有部门进行删除
		deptDAO.updateDeptStatusToDisabled(toMap("idList", strList));
		// 删除部门下的所有用户
		userDAO.deleteUserInfoByIds(toMap("idList", strList));

	}

	/**
	 * 取得部门详细信息
	 * 
	 * @param id
	 * @return Dept
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Dept getDeptDetailInfo(Long id) {
		return deptDAO.findDeptInfoById(id);
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
		return deptDAO.findDeptInfoByLoginId(loginId);
	}

	/**
	 * 取得所有登录人下的所有部门节点
	 */
	private void getNodeString(List<Dept> deptList, Long unitId) {
		strList.add(unitId);
		for (Dept dept : deptList) {

			if (unitId.equals(dept.getUnitId())) {
				strList.add(dept.getId());
				getNodeString(deptList, dept.getId());
			}
		}
	}

}
