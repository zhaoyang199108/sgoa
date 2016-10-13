package com.bcqsoft.sgoa.service.grporole.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.grporole.GrpoRoleDAO;
import com.bcqsoft.sgoa.dao.grporole.dataobject.GrpoRole;
import com.bcqsoft.sgoa.service.grporole.GrpoRoleService;

@Service
public class GrpoRoleServiceImpl extends BaseService implements GrpoRoleService {
	/**
	 * 分组权限模块的DAO实现类
	 */
	@Autowired
	private GrpoRoleDAO grpoRoleDAO;

	/**
	 * 取得分组权限详细信息
	 * 
	 * @param id
	 * @return Grpo
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@Override
	public List<GrpoRole> getGrpoRoleList(String groupId) {
		return grpoRoleDAO.findGrpoRoleInfoList(groupId);
	}
	

}
