package com.bcqsoft.sgoa.service.grporole;

import java.util.List;

import com.bcqsoft.sgoa.dao.grporole.dataobject.GrpoRole;


public interface GrpoRoleService {
	
	/**
	 * 取得分组权限详细信息
	 * 
	 * @param id
	 * @return Grpo
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	List<GrpoRole> getGrpoRoleList(String groupId);
	

}
