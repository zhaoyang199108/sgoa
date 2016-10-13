package com.bcqsoft.sgoa.service.grpo;

import java.util.List;

import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.dao.grpo.dataobject.GrpoPage;
import com.bcqsoft.sgoa.dao.role.dataobject.Role;

public interface GrpoService {
	/**
	 * 添加分组权限
	 * 
	 * @param grpo
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */

	boolean createGrpoInfo(Grpo grpo);

	/**
	 * 更新分组权限
	 * 
	 * @param grpo
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	boolean updateGrpoInfo(Grpo grpo);

	/**
	 * 取得部门列表(分页)
	 * 
	 * @param page
	 * @return GrpoPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	List<Grpo> getGrpoListByAll(Grpo grpo);

	/**
	 * 删除一条部门(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	boolean deleteGrpoInfo(Long id);

	/**
	 * 取得部门详细信息
	 * 
	 * @param id
	 * @return Grpo
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Grpo getGrpoDetailInfo(Long id);
	/**
	 * 根据查询条件查找分组权限信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	GrpoPage getGrpoInfoList(GrpoPage page);
	/**
	 * 删除分组权限信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteGrpos(long[] longArray);

	/**
	 * 查询全部分组角色集合
	 * 
	 * @return 分组角色列表
	 * 
	 * @Author cql
	 * @Date 2013-12-29
	 */
	List<Role> getRoleList();

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
	boolean createGrpoRole(String groupId, long[] idArray);


	/**
	 * 所选用户和分组
	 * 
	 * @return 是否成功
	 * 
	 * @Author ly
	 * @Date 2012-01-04
	 */
	boolean selUserGroup(String[] idArray, long[] gropIds);

}
