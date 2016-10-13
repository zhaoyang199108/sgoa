package com.bcqsoft.sgoa.dao.grporole.dataobject;

import java.util.Date;

/**
 * 人员角色关系表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_GRPO_ROLE
 * </pre>
 */
public class GrpoRole {

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 创建日期
	 */
	private Date createDate;

	/**
	 * 更新日期
	 */
	private Date updateDate;

	/**
	 * 部门ID(关联SCOA_TB_DEPT.ID)
	 */
	private String groupId;

	/**
	 * 角色ID(关联SCOA_TB_ROLE.ID)
	 */
	private Long roleId;

	/**
	 * 角色名称(关联SCOA_TB_ROLE.ROLE_NAME)
	 */
	private String roleName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
