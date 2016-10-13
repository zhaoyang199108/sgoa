package com.bcqsoft.sgoa.service.grpo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.grpo.GrpoDAO;
import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.dao.grpo.dataobject.GrpoPage;
import com.bcqsoft.sgoa.dao.grporole.GrpoRoleDAO;
import com.bcqsoft.sgoa.dao.grporole.dataobject.GrpoRole;
import com.bcqsoft.sgoa.dao.role.RoleDAO;
import com.bcqsoft.sgoa.dao.role.dataobject.Role;
import com.bcqsoft.sgoa.dao.userrole.UserRoleDAO;
import com.bcqsoft.sgoa.dao.userrole.dataobject.UserRole;
import com.bcqsoft.sgoa.service.grpo.GrpoService;

@Service
public class GrpoServiceImpl extends BaseService implements GrpoService {
	/**
	 * 部门模块的DAO实现类
	 */
	@Autowired
	private GrpoDAO grpoDAO;
	
	/**
	 * 分组权限模块的DAO实现类
	 */
	@Autowired
	private GrpoRoleDAO grpoRoleDAO;
	
	/**
	 * 角色模块DAO实现类
	 */
	@Autowired
	private RoleDAO roleDAO;
	
	/**
	 * 用户角色模块DAO实现类
	 */
	@Autowired
	private UserRoleDAO userRoleDAO;


	/**
	 * 创建一条新的部门
	 * 
	 * @param grpo
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public boolean createGrpoInfo(Grpo grpo) {
		Long pk = grpoDAO.insertIntoGrpo(grpo);
		return isInsertSucc(pk);
	}

	/**
	 * 更新分组权限
	 * 
	 * @param grpo
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public boolean updateGrpoInfo(Grpo grpo) {
		Integer count = grpoDAO.updateGrpoInfoById(grpo);
		return isUpdateSucc(count);
	}

	/**
	 * 取得部门列表(分页)
	 * 
	 * @param page
	 * @return GrpoPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public List<Grpo> getGrpoListByAll(Grpo grpo) {
		// 取得部门集合(分页查询)
		List<Grpo> grpoList = grpoDAO.findAllGrpoInfo(grpo);
		return grpoList;
	}

	/**
	 * 删除一条部门(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public boolean deleteGrpoInfo(Long id) {
		// 对部门下的所有部门进行删除
		Integer count = grpoDAO.deleteGrpoStatusToDisabled(id);
		// 删除部门下的所有用户
		// grpoRoleDAO.deleteGrpoRolerInfoByIds(toMap("idList", strList));
		return isUpdateSucc(count);

	}

	/**
	 * 取得部门详细信息
	 * 
	 * @param id
	 * @return Grpo
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Grpo getGrpoDetailInfo(Long id) {
		return grpoDAO.findGrpoInfoById(id);
	}

	/**
	 * 根据查询条件查找分组权限信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	@Override
	public GrpoPage getGrpoInfoList(GrpoPage page) {
		int count = grpoDAO.findGrpoInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得分组权限信息集合(分页查询)
		List<Grpo> grpoList = grpoDAO.findGrpoInfoList(page);

		page.setTotalRow(count); // 分组权限总数量
		page.setGrpoList(grpoList); // 分组权限信息集合
		return page;
	}
	/**
	 * 删除分组权限信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean deleteGrpos(long[] longArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除分组权限
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long grpoId : longArray) {

			// 删除分组权限
			Integer count = grpoDAO.deleteGrpoStatusToDisabled(grpoId);

			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 查询全部分组角色集合
	 * 
	 * @return 分组角色列表
	 * 
	 * @Author cql
	 * @Date 2013-12-29
	 */
	@Override
	public List<Role> getRoleList() {
		return roleDAO.findRoleInfoList();
	}

	/**
	 * 添加分组角色信息
	 * 
	 * @param groupId
	 * @param roleIdArray
	 * @return 是否成功
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createGrpoRole(String groupId, long[] roleIdArray) {
		// 返回是否操作成功
		boolean returnValue = false;
		// 删除该用户Id下的所有角色信息
		Integer count = grpoRoleDAO.deleteGrpoRoleInfoById(groupId);
		// 某条删除成功即设置操作成功
		if (count != null && count > 0) {
			returnValue = true;
		}
		// 插入用户角色信息
		for (long roleId : roleIdArray) {
			GrpoRole grpoRole = new GrpoRole();
			// 设置用户Id
			grpoRole.setGroupId(groupId);
			// 设置角色Id
			grpoRole.setRoleId(roleId);
			Long pk = grpoRoleDAO.insertIntoGrpoRole(grpoRole);
			// 某条删除成功即设置操作成功
			if (pk != null && pk > 0) {
				returnValue = true;
			}
		}
		// 返回是否成功
		return returnValue;
	}

	/**
	 * 所选用户和分组
	 * 
	 * @return 是否成功
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	@Override
	public boolean selUserGroup(String[] idArray, long[] gropIds) {
		boolean returnValue = false;
		for (String userId : idArray) {
			UserRole userRoles = new UserRole();
			// 设置用户Id
			userRoles.setLoginId(userId);
			userRoles.setGrpoType("1");
			userRoleDAO.deleteUserRoleInfoById(userRoles);
			for (long groupId : gropIds){
				UserRole userRole = new UserRole();
				// 设置用户Id
				userRole.setLoginId(userId);
				// 设置分组Id
				userRole.setGrpoId(groupId);
				userRole.setGrpoType("1");
				Long pl = userRoleDAO.insertIntoUserRole(userRole);
				// 某条删除成功即设置操作成功
				if (pl != null && pl > 0) {
					returnValue = true;
				   }
			}
		}
		return returnValue;
	}


}
