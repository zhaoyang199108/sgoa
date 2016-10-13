package com.bcqsoft.sgoa.dao.grporole.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.grporole.GrpoRoleDAO;
import com.bcqsoft.sgoa.dao.grporole.dataobject.GrpoRole;

/**
 * 人员角色关系表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_GRPO_ROLE
 * </pre>
 */
@Repository
public class IbatisGrpoRoleDAO extends BaseDAO implements GrpoRoleDAO {

	/**
	 * 查找全部用户角色
	 * 
	 * @return 用户角色列表
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<GrpoRole> findGrpoRoleInfoList(String groupId) {
		return (List<GrpoRole>) ibatis().queryForList("grporole.findGrpoRoleInfoList", groupId);
	}

	/**
	 * 插入一条用户角色信息至用户角色表(SCOA_TB_GRPO_ROLE)
	 * 
	 * @param grpoRole
	 * @return 插入记录的ID
	 * 
	 * @Author ly
	 * @Date 2011-12-26
	 */
	public Long insertIntoGrpoRole(GrpoRole grpoRole) {
		return (Long) ibatis().insert("grporole.insertIntoGrpoRole", grpoRole);
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
	public Integer deleteGrpoRoleInfoById(String loginId) {
		return (Integer) ibatis().delete("grporole.deleteGrpoRoleInfoById", loginId);
	}
}
