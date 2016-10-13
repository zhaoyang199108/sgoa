package com.bcqsoft.sgoa.dao.userrole;

import java.util.List;

import com.bcqsoft.sgoa.dao.userrole.dataobject.UserRole;

/**
 * 人员角色关系表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_USER_ROLE
 * </pre>
 */
public interface UserRoleDAO {

	/**
	 * 查找全部用户角色
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	List<UserRole> findUserRoleInfoList(String loginId);

	/**
	 * 插入一条用户角色信息至用户角色表(SCOA_TB_USER_ROLE)
	 * 
	 * @param userRole
	 * @return 插入记录的ID
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	Long insertIntoUserRole(UserRole userRole);

	/**
	 * 根据用户ID删除用户角色信息
	 * 
	 * @param loginId
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	Integer deleteUserRoleInfoById(UserRole userRole);
	
	/**
	 * 根据用户ID更新用户角色信息
	 * 
	 * @param userRole
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	Integer updateUserRole(UserRole userRole);
}
