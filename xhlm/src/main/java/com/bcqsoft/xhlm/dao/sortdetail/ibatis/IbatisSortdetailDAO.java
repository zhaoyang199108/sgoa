package com.bcqsoft.xhlm.dao.sortdetail.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.sortdetail.SortdetailDAO;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.Sortdetail;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;

@Repository
/**
 *类别详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisSortdetailDAO extends BaseDAO implements SortdetailDAO {
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findSortdetailInfoCount(SortdetailPage page) {
		return (Integer) ibatis().queryForObject("sortdetail.findSortdetailInfoCount", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sortdetails&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Sortdetail> findSortdetailInfoList(SortdetailPage page) {
		return (List<Sortdetail>) ibatis().queryForList("sortdetail.findSortdetailInfoList", page);
	}

	/**
	 * 插入一条类别详细信息至类别详细表
	 * 
	 * @param sortdetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoSortdetail(Sortdetail sortdetail) {
		return (Long) ibatis().insert("sortdetail.insertIntoSortdetail", sortdetail);
	}

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param sortdetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updateSortdetailInfoById(Sortdetail sortdetail) {
		return (Integer) ibatis().update("sortdetail.updateSortdetailInfoById", sortdetail);
	}

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param sortdetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deleteSortdetailInfoById(Long sortdetailId) {
		return (Integer) ibatis().update("sortdetail.deleteSortdetailInfoById", sortdetailId);
	}

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param sortdetailId
	 * @return Sortdetail
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Sortdetail getSortdetailInfo(long sortdetailId) {
		return (Sortdetail) ibatis().queryForObject("sortdetail.getSortdetailInfo", sortdetailId);
	}

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sortdetails&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Sortdetail> getSortdetailListById(SortdetailPage page) {
		return (List<Sortdetail>) ibatis().queryForList("sortdetail.getSortdetailListById", page);
	}

	/**
	 * 取得行业列表信息
	 * 
	 * @param detail
	 * @return
	 * 
	 * @Author cql
	 * @Date 2016-01-20
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Sortdetail> getSortdetailList(Sortdetail detail) {
		return (List<Sortdetail>) ibatis().queryForList("sortdetail.getSortdetailList",detail);
	}

	/**
	 * 行业详细列表
	 * 
	 * @param map
	 * @return 行业详细列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Sortdetail> findAllSortdetailInfo() {
		return (List<Sortdetail>) ibatis().queryForList("sortdetail.findAllSortdetailInfo");
	}
}