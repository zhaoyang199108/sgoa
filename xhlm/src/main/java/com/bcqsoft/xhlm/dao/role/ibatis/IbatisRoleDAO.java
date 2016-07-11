package com.bcqsoft.xhlm.dao.role.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.role.RoleDAO;
import com.bcqsoft.xhlm.dao.role.dataobject.Role;

/**
 * 角色表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_ROLE
 * </pre>
 */
@Repository
public class IbatisRoleDAO extends BaseDAO implements RoleDAO {

	/**
	 * 查找全部用户角色
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<Role> findRoleInfoList() {
		return (List<Role>) ibatis().queryForList("role.findRoleInfoList");
	}
}
