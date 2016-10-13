package com.bcqsoft.sgoa.dao.userrole.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.userrole.UserRoleDAO;
import com.bcqsoft.sgoa.dao.userrole.dataobject.UserRole;

/**
 * 人员角色关系表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_USER_ROLE
 * </pre>
 */
@Repository
public class IbatisUserRoleDAO extends BaseDAO implements UserRoleDAO {

	/**
	 * 查找全部用户角色
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<UserRole> findUserRoleInfoList(String loginId) {
		return (List<UserRole>) ibatis().queryForList("userrole.findUserRoleInfoList", loginId);
	}

	/**
	 * 插入一条用户角色信息至用户角色表(SCOA_TB_USER_ROLE)
	 * 
	 * @param userRole
	 * @return 插入记录的ID
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	public Long insertIntoUserRole(UserRole userRole) {
		return (Long) ibatis().insert("userrole.insertIntoUserRole", userRole);
	}

	/**
	 * 根据用户ID删除用户角色信息
	 * 
	 * @param loginId
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	public Integer deleteUserRoleInfoById(UserRole userRole) {
		return (Integer) ibatis().delete("userrole.deleteUserRoleInfoById", userRole);
	}

	/**
	 * 根据用户ID更新用户角色信息
	 * 
	 * @param map
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	public Integer updateUserRole(UserRole userRole) {
		return (Integer) ibatis().update("userrole.updateUserRole", userRole);
	}

}
