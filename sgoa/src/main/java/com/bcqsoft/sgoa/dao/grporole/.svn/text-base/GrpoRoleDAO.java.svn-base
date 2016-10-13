package com.bcqsoft.sgoa.dao.grporole;

import java.util.List;

import com.bcqsoft.sgoa.dao.grporole.dataobject.GrpoRole;

/**
 * 人员角色关系表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_GRPO_ROLE
 * </pre>
 */
public interface GrpoRoleDAO {

	/**
	 * 查找全部用户角色
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	List<GrpoRole> findGrpoRoleInfoList(String groupId);

	/**
	 * 插入一条用户角色信息至用户角色表(SCOA_TB_GRPO_ROLE)
	 * 
	 * @param grpoRole
	 * @return 插入记录的ID
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	Long insertIntoGrpoRole(GrpoRole grpoRole);

	/**
	 * 根据用户ID删除用户角色信息
	 * 
	 * @param loginId
	 * @return 更新是否成功
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	Integer deleteGrpoRoleInfoById(String loginId);
	
}
