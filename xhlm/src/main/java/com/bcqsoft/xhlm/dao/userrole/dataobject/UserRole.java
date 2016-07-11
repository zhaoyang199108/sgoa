package com.bcqsoft.xhlm.dao.userrole.dataobject;

import java.util.Date;

/**
 * 人员角色关系表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_USER_ROLE
 * </pre>
 */
public class UserRole {

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
	 * 用户ID(关联SCOA_TB_USER.ID)
	 */
	private String loginId;
	
	/**
	 * 角色ID(关联SCOA_TB_ROLE.ID)
	 */
	private Long roleId;
	
	/**
	 * 角色名称(关联SCOA_TB_ROLE.ROLE_NAME)
	 */
	private String roleName;

	/**
	 * 取得自增型主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置自增型主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 取得创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 取得更新日期
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置更新日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 取得用户ID(关联SCOA_TB_USER.ID)
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * 设置用户ID(关联SCOA_TB_USER.ID)
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	/**
	 * 取得角色ID(关联SCOA_TB_ROLE.ID)
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * 设置角色ID(关联SCOA_TB_ROLE.ID)
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * 取得角色名称(关联SCOA_TB_ROLE.ROLE_NAME)
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * 设置角色名称(关联SCOA_TB_ROLE.ROLE_NAME)
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
