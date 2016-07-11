package com.bcqsoft.xhlm.service.sort.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.sort.SortDAO;
import com.bcqsoft.xhlm.dao.sort.dataobject.Sort;
import com.bcqsoft.xhlm.dao.sort.dataobject.SortPage;
import com.bcqsoft.xhlm.service.sort.SortService;

/**
 * 类别分类模块业务逻辑类接口
 */
@Service
public class SortServiceImpl extends BaseService implements SortService {
	/**
	 * 类别分类数据库访问层Ibatis接口
	 */
	@Autowired
	private SortDAO sortDAO;

	/**
	 * 添加类别分类信息
	 * 
	 * @param sort
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public boolean createSort(Sort sort) {
		// 数据库新增一条类别分类记录,并返回是否插入成功
		Long pk = sortDAO.insertIntoSort(sort);
		return isInsertSucc(pk);
	}

	/**
	 * 修改类别分类信息
	 * 
	 * @param sort
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public boolean modifySort(Sort sort) {
		// 更新该条类别分类信息,并返回是更新成功
		Integer count = sortDAO.updateSortInfoById(sort);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别分类信息
	 * 
	 * @param sortId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public boolean deleteSort(long sortId) {
		// 删除该条类别分类信息,并返回是否删除成功
		Integer count = sortDAO.deleteSortInfoById(sortId);
		// 删除该类别分类Id的类别分类角色信息,并返回是否删除成功
		// sortRoleDAO.deleteSortRoleById(sortId);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别分类(多选框批量删除)
	 * 
	 * @param idArray
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public boolean deleteSorts(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long sortId : idArray) {
			// 删除类别分类信息
			Integer count = sortDAO.deleteSortInfoById(sortId);
			// 删除该类别分类Id的类别分类角色信息,并返回是否删除成功
			// sortRoleDAO.deleteSortRoleById(sortId);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID查找某一类别分类的信息
	 * 
	 * @param sortId
	 * @return Sort
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Sort getSortInfo(long sortId) {
		Sort sort = sortDAO.getSortInfo(sortId);
		return sort;
	}

	/**
	 * 根据查询条件查找类别分类信息列表
	 * 
	 * @param id
	 * @return 类别分类分页对象
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public SortPage getSortInfoList(SortPage page) {
		int count = sortDAO.findSortInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得类别分类信息集合(分页查询)
		List<Sort> sortList = sortDAO.findSortInfoList(page);

		page.setTotalRow(count); // 类别分类总数量
		page.setSortList(sortList); // 类别分类信息集合
		return page;
	}

	/**
	 * 根据查询条件查找类别分类信息列表
	 * 
	 * @param id
	 * @return 类别分类分页对象
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@Override
	public SortPage getAllSortForList(SortPage sortPage) {
		List<Sort> sortList = sortDAO.getAllSortForList(sortPage);
		sortPage.setSortList(sortList);
		return sortPage;
	}
}