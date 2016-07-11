package com.bcqsoft.xhlm.dao.sort;

import java.util.List;

import com.bcqsoft.xhlm.dao.sort.dataobject.Sort;
import com.bcqsoft.xhlm.dao.sort.dataobject.SortPage;

/**
 * 类别分类数据库访问层Ibatis接口
 * 
 */
public interface SortDAO {
	
	/**
	 * 查找类别分类列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sorts&gt;
	 */
	Integer findSortInfoCount(SortPage page);

	/**
	 * 查找类别分类列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sorts&gt;
	 */
	List<Sort> findSortInfoList(SortPage page);
	
	/**
	 * 插入一条类别分类信息至类别分类表(SCOA_TB_NEWS)
	 * 
	 * @param sort
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoSort(Sort sort);

	/**
	 * 根据类别分类ID更新类别分类表信息
	 * 
	 * @param sort
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer updateSortInfoById(Sort sort);
	
	/**
	 * 根据类别分类ID删除类别分类表信息
	 * 
	 * @param sortId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer deleteSortInfoById(Long sortId);
	
	/**
	 * 根据类别分类ID查询类别分类表信息
	 * 
	 * @param sortId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Sort getSortInfo(long sortId);
	
	/**
	 * 查找类别分类列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sorts&gt;
	 */
	List<Sort> getAllSortForList(SortPage sortPage);
}