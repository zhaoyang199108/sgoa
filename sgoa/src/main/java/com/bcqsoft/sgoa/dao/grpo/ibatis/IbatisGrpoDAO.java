package com.bcqsoft.sgoa.dao.grpo.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.grpo.GrpoDAO;
import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.dao.grpo.dataobject.GrpoPage;

/**
 * 分组权限表(记录当前单位科室及下属单位科室)数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DEPT
 * </pre>
 */
@Repository
public class IbatisGrpoDAO extends BaseDAO implements GrpoDAO {

	/**
	 * 查找全部部门信息列表
	 * 
	 * @return 部门信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<Grpo> findAllGrpoInfo(Grpo grpo) {
		return (List<Grpo>) ibatis().queryForList("grpo.findAllGrpoInfo",grpo);
	}


	/**
	 * 插入一条信息至部门表
	 * 
	 * @param grpo
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Long insertIntoGrpo(Grpo grpo) {
		return (Long) ibatis().insert("grpo.insertIntoGrpo", grpo);
	}

	/**
	 * 根据查询条件查询符合条件的部门(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */

	public Integer findGrpoInfoCount(GrpoPage page) {
		return (Integer) ibatis()
				.queryForObject("grpo.findGrpoInfoCount", page);
	}

	/**
	 * 根据查询条件查询符合条件的部门
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */

	@SuppressWarnings("unchecked")
	public List<Grpo> findGrpoInfoList(GrpoPage page) {
		return (List<Grpo>) ibatis()
				.queryForList("grpo.findGrpoInfoList", page);
	}

	/**
	 * 根据ID查询某一条通告通知
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Grpo findGrpoInfoById(long id) {
		return (Grpo) ibatis().queryForObject("grpo.findGrpoInfoById", id);
	}

	/**
	 * 根据ID更新某条部门信息
	 * 
	 * @param grpo
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Integer updateGrpoInfoById(Grpo grpo) {
		return (Integer) ibatis().update("grpo.updateGrpoInfoById", grpo);
	}

	/**
	 * 根据ID删除某条部门信息
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Integer deleteGrpoStatusToDisabled(long id) {
		return (Integer) ibatis().delete("grpo.deleteGrpoStatusToDisabled", id);
	}

}
