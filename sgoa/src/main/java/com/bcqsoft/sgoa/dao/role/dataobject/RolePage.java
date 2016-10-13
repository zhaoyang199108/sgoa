package com.bcqsoft.sgoa.dao.role.dataobject;

import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

public class RolePage extends BasePage {
	private static final long serialVersionUID = -5622021560288626237L;
	private List<Role> RoleList;

	public List<Role> getRoleList() {
		return RoleList;
	}

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 角色CODE
	 */
	private String roleCode;

	/**
	 * 角色级别
	 */
	private Integer roleLevel;

	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 父类ID
	 */
	private Long pId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Integer getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(Integer roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public void setRoleList(List<Role> roleList) {
		RoleList = roleList;
	}

}
