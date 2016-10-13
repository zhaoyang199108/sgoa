package com.bcqsoft.sgoa.dao.seal;

import java.util.List;

import com.bcqsoft.sgoa.dao.seal.dataobject.Seal;
import com.bcqsoft.sgoa.dao.seal.dataobject.SealPage;

/**
 * 签章模块数据库访问DAO接口
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public interface SealDAO {
	/**
	 * 查找签章模块列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Seals&gt;
	 */
	Integer findSealInfoCount(SealPage page);

	/**
	 * 查找签章模块列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Seals&gt;
	 */
	List<Seal> findSealInfoList(SealPage page);
	
	/**
	 * 查找签章模块列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Seals&gt;
	 */
	List<Seal> findSealInfoAllList();

	/**
	 * 插入一条签章模块信息至签章模块表
	 * 
	 * @param seal
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Long insertIntoSeal(Seal seal);

	/**
	 * 根据签章模块ID查询签章模块表信息
	 * 
	 * @param sealId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Seal getSealInfo(long id);
	/**
	 * 根据签章模块ID更新签章模块表信息
	 * 
	 * @param seal
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer updateSealInfoById(Seal seal);
	/**
	 * 根据签章模块ID删除签章模块表信息
	 * 
	 * @param sealId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer deleteSealInfoById(long id);

}
