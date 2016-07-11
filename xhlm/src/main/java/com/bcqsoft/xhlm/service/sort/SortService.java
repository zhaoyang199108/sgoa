package com.bcqsoft.xhlm.service.sort;

import com.bcqsoft.xhlm.dao.sort.dataobject.Sort;
import com.bcqsoft.xhlm.dao.sort.dataobject.SortPage;

/**
 * 类别分类模块业务逻辑类接口
 */
public interface SortService {
	/**
	 * 添加类别分类信息
	 * 
	 * @param sort
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean createSort(Sort sort);

	/**
	 * 修改类别分类信息
	 * 
	 * @param sort
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean modifySort(Sort sort);

	/**
	 * 删除类别分类信息
	 * 
	 * @param sortId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteSort(long sortId);

	/**
	 * 删除类别分类信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteSorts(long[] idArray);

	/**
	 * 根据ID查找某一类别分类的信息
	 * 
	 * @param sortId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Sort getSortInfo(long sortId);

	/**
	 * 根据查询条件查找类别分类信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	SortPage getSortInfoList(SortPage page);

	/**
	 * 根据查询条件查找类别分类信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	SortPage getAllSortForList(SortPage sortPage);
}