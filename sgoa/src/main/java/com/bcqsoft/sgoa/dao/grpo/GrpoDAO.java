package com.bcqsoft.sgoa.dao.grpo;

import java.util.List;

import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.dao.grpo.dataobject.GrpoPage;

/**
 * 分组权限表(记录当前单位科室及下属单位科室)数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DEPT
 * </pre>
 */
public interface GrpoDAO {


	/**
	 * 查找全部分组权限列表
	 * 
	 * @return 分组权限列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<Grpo> findAllGrpoInfo(Grpo grpo);

	/**
	 * 插入信息至部门表
	 * 
	 * @param grpo
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Long insertIntoGrpo(Grpo grpo);

	/**
	 * 根据查询条件查询符合条件的部门(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-09
	 */
	Integer findGrpoInfoCount(GrpoPage page);

	/**
	 * 根据查询条件查询符合条件的部门
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com
	 * @Date 2011-12-09
	 */

	List<Grpo> findGrpoInfoList(GrpoPage page);

	/**
	 * 根据ID查询某一条部门
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Grpo findGrpoInfoById(long id);

	/**
	 * 根据ID更新某条分组权限
	 * 
	 * @param grpo
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Integer updateGrpoInfoById(Grpo grpo);

	/**
	 * 根据ID删除某条分组权限(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Integer deleteGrpoStatusToDisabled(long id);

}
