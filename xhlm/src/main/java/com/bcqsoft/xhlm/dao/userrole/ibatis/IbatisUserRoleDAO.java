package com.bcqsoft.xhlm.dao.userrole.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.userrole.UserRoleDAO;
import com.bcqsoft.xhlm.dao.userrole.dataobject.UserRole;

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
	 * 根据用户ID更新用户角色信息
	 * 
	 * @param map
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	public Integer updateUserRole(ModelMap map) {
		return (Integer) ibatis().update("userrole.updateUserRole", map);
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
	public Integer deleteUserRoleInfoById(String loginId) {
		return (Integer) ibatis().delete("userrole.deleteUserRoleInfoById", loginId);
	}
	
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

}
