package com.bcqsoft.xhlm.service.sortdetail;

import java.util.List;

import com.bcqsoft.xhlm.dao.sortdetail.dataobject.Sortdetail;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;


/**
 * 类别详细模块业务逻辑类接口
 */
public interface SortdetailService {
	
	/**
	 * 添加类别详细信息
	 * 
	 * @param detail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean createSortdetail(Sortdetail detail);

	/**
	 * 修改类别详细信息
	 * 
	 * @param detail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean modifySortdetail(Sortdetail detail);

	/**
	 * 删除类别详细信息
	 * 
	 * @param detailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteSortdetail(long detailId);

	/**
	 * 删除类别详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteSortdetails(long[] idArray);

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param detailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Sortdetail getSortdetailInfo(long detailId);

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	SortdetailPage getSortdetailInfoList(SortdetailPage page);

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	SortdetailPage getSortdetailListById(SortdetailPage page);

	/**
	 * 取得行业列表信息
	 * 
	 * @param detail
	 * @return
	 * 
	 * @Author cql
	 * @Date 2016-01-20
	 */
	List<Sortdetail> getSortdetailList(Sortdetail detail);
}