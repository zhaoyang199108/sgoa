package com.bcqsoft.xhlm.dao.sortdetail;

import java.util.List;

import com.bcqsoft.xhlm.dao.sortdetail.dataobject.Sortdetail;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;

/**
 * 类别详细数据库访问层Ibatis接口
 */
public interface SortdetailDAO {

	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sortdetails&gt;
	 */
	Integer findSortdetailInfoCount(SortdetailPage page);

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sortdetails&gt;
	 */
	List<Sortdetail> findSortdetailInfoList(SortdetailPage page);

	/**
	 * 插入一条类别详细信息至类别详细表(SCOA_TB_NEWS)
	 * 
	 * @param sortdetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoSortdetail(Sortdetail sortdetail);

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param sortdetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer updateSortdetailInfoById(Sortdetail sortdetail);

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param sortdetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer deleteSortdetailInfoById(Long sortdetailId);

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param sortdetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Sortdetail getSortdetailInfo(long sortdetailId);

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Sortdetail&gt;
	 */
	List<Sortdetail> getSortdetailListById(SortdetailPage page);

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

	/**
	 * 行业详细列表
	 * 
	 * @param map
	 * @return 行业详细列表
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	List<Sortdetail> findAllSortdetailInfo();
}