package com.bcqsoft.xhlm.dao.sort.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.sort.SortDAO;
import com.bcqsoft.xhlm.dao.sort.dataobject.Sort;
import com.bcqsoft.xhlm.dao.sort.dataobject.SortPage;

/**
 *类别分类数据库访问层Ibatis实现类
 * 
 */
@Repository
public class IbatisSortDAO extends BaseDAO implements SortDAO {
	/**
	 * 查找类别分类列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sorts&gt;
	 */
	public Integer findSortInfoCount(SortPage page) {
		return (Integer) ibatis().queryForObject("sort.findSortInfoCount", page);
	}

	/**
	 * 查找类别分类列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sorts&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Sort> findSortInfoList(SortPage page) {
		return (List<Sort>) ibatis().queryForList("sort.findSortInfoList", page);
	}

	/**
	 * 插入一条类别分类信息至类别分类表
	 * 
	 * @param sort
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoSort(Sort sort) {
		return (Long) ibatis().insert("sort.insertIntoSort", sort);
	}

	/**
	 * 根据类别分类ID更新类别分类表信息
	 * 
	 * @param sort
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updateSortInfoById(Sort sort) {
		return (Integer) ibatis().update("sort.updateSortInfoById", sort);
	}

	/**
	 * 根据类别分类ID删除类别分类表信息
	 * 
	 * @param sortId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deleteSortInfoById(Long sortId) {
		return (Integer) ibatis().update("sort.deleteSortInfoById", sortId);
	}

	/**
	 * 根据类别分类ID查询类别分类表信息
	 * 
	 * @param sortId
	 * @return Sort
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Sort getSortInfo(long sortId) {
		return (Sort) ibatis().queryForObject("sort.getSortInfo", sortId);
	}
	/**
	 * 查找类别分类列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sorts&gt;
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Sort> getAllSortForList(SortPage sortPage) {
		return (List<Sort>) ibatis().queryForList("sort.getAllSortForList", sortPage);

	}
}