package com.bcqsoft.xhlm.dao.role;

import java.util.List;

import com.bcqsoft.xhlm.dao.role.dataobject.Role;

/**
 * 角色表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_ROLE
 * </pre>
 */
public interface RoleDAO {

	/**
	 * 查找全部用户角色
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	List<Role> findRoleInfoList();
}
