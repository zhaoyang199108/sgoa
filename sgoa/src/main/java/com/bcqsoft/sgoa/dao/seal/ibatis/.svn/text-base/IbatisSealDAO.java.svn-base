package com.bcqsoft.sgoa.dao.seal.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.seal.SealDAO;
import com.bcqsoft.sgoa.dao.seal.dataobject.Seal;
import com.bcqsoft.sgoa.dao.seal.dataobject.SealPage;

/**
 * 签章模块数据库访问DAO实现类
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
@Repository
public class IbatisSealDAO extends BaseDAO implements SealDAO {

	/**
	 * 查找签章模块列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Seals&gt;
	 */
	public Integer findSealInfoCount(SealPage page) {
		return (Integer) ibatis()
				.queryForObject("seal.findSealInfoCount", page);
	}


	/**
	 * 查找签章模块列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Seals&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Seal> findSealInfoList(SealPage page) {
		return (List<Seal>) ibatis()
				.queryForList("seal.findSealInfoList", page);
	}

	/**
	 * 查找签章模块列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Seals&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Seal> findSealInfoAllList() {
		return (List<Seal>) ibatis()
				.queryForList("seal.findSealInfoAllList");
	}
	
	/**
	 * 插入一条签章模块信息至签章模块表(PSI_USER)
	 * 
	 * @param seal
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Long insertIntoSeal(Seal seal) {
		return (Long) ibatis().insert("seal.insertIntoSeal", seal);
	}


	/**
	 * 根据签章模块ID查询签章模块表信息
	 * 
	 * @param sealId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Seal getSealInfo(long id) {
		return (Seal) ibatis().queryForObject("seal.getSealInfo", id);
	}

	/**
	 * 根据签章模块ID更新签章模块表信息
	 * 
	 * @param seal
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public Integer updateSealInfoById(Seal seal) {
		return (Integer) ibatis().update("seal.updateSealInfoById", seal);
	}


	/**
	 * 根据签章模块ID删除签章模块表信息
	 * 
	 * @param sealId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer deleteSealInfoById(long id) {
		return (Integer) ibatis().update("seal.deleteSealInfoById", id);
	}


}
