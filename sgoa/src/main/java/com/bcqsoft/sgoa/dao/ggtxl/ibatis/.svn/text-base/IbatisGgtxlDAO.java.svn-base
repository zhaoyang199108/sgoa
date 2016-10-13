package com.bcqsoft.sgoa.dao.ggtxl.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.ggtxl.GgtxlDAO;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.Ggtxl;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.GgtxlPage;

/**
 * 公共通讯录数据库访问DAO实现类
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
@Repository
public class IbatisGgtxlDAO extends BaseDAO implements GgtxlDAO {

	/**
	 * 查找公共通讯录列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	public Integer findGgtxlInfoCount(GgtxlPage page) {
		return (Integer) ibatis()
				.queryForObject("ggtxl.findGgtxlInfoCount", page);
	}


	/**
	 * 查找公共通讯录列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Ggtxl> findGgtxlInfoList(GgtxlPage page) {
		return (List<Ggtxl>) ibatis()
				.queryForList("ggtxl.findGgtxlInfoList", page);
	}

	/**
	 * 查找公共通讯录列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Ggtxl> findGgtxlInfoAllList() {
		return (List<Ggtxl>) ibatis()
				.queryForList("ggtxl.findGgtxlInfoAllList");
	}
	
	/**
	 * 插入一条公共通讯录信息至公共通讯录表(PSI_USER)
	 * 
	 * @param ggtxl
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Long insertIntoGgtxl(Ggtxl ggtxl) {
		return (Long) ibatis().insert("ggtxl.insertIntoGgtxl", ggtxl);
	}


	/**
	 * 根据公共通讯录ID查询公共通讯录表信息
	 * 
	 * @param ggtxlId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Ggtxl getGgtxlInfo(long id) {
		return (Ggtxl) ibatis().queryForObject("ggtxl.getGgtxlInfo", id);
	}

	/**
	 * 根据公共通讯录ID更新公共通讯录表信息
	 * 
	 * @param ggtxl
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@Override
	public Integer updateGgtxlInfoById(Ggtxl ggtxl) {
		return (Integer) ibatis().update("ggtxl.updateGgtxlInfoById", ggtxl);
	}


	/**
	 * 根据公共通讯录ID删除公共通讯录表信息
	 * 
	 * @param ggtxlId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer deleteGgtxlInfoById(long id) {
		return (Integer) ibatis().update("ggtxl.deleteGgtxlInfoById", id);
	}

	/**
	 * 查找公共通讯录列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	@Override
	public Integer findGgtxlAllCount(GgtxlPage page) {
		return (Integer) ibatis()
				.queryForObject("ggtxl.findGgtxlAllCount", page);
	}


	/**
	 * 查找公共通讯录列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Ggtxls&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Ggtxl> findGgtxlAllList(GgtxlPage page) {
		return (List<Ggtxl>) ibatis()
				.queryForList("ggtxl.findGgtxlAllList", page);
	}


	@Override
	public Integer findGgtxlInfoSearchCount(GgtxlPage page) {
		return (Integer) ibatis()
				.queryForObject("ggtxl.findGgtxlInfoSearchCount", page);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ggtxl> findGgtxlInfoSearchList(GgtxlPage page) {
		return (List<Ggtxl>) ibatis()
				.queryForList("ggtxl.findGgtxlInfoSearchList", page);
	}

}
