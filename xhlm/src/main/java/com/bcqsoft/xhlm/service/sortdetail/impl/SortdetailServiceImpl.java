package com.bcqsoft.xhlm.service.sortdetail.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.sortdetail.SortdetailDAO;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.Sortdetail;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;

/**
 * 类别详细模块业务逻辑类接口
 */
@Service
public class SortdetailServiceImpl extends BaseService implements SortdetailService {
	/**
	 * 类别详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private SortdetailDAO sortdetailDAO;
	/**
	 * 添加类别详细信息
	 * 
	 * @param detail
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public boolean createSortdetail(Sortdetail detail) {
		// 数据库新增一条类别详细记录,并返回是否插入成功
		Long pk = sortdetailDAO.insertIntoSortdetail(detail);
		return isInsertSucc(pk);
	}

	/**
	 * 修改类别详细信息
	 * 
	 * @param detail
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public boolean modifySortdetail(Sortdetail detail) {
		// 更新该条类别详细信息,并返回是更新成功
		Integer count = sortdetailDAO.updateSortdetailInfoById(detail);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细信息
	 * 
	 * @param detailId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public boolean deleteSortdetail(long detailId) {
		// 删除该条类别详细信息,并返回是否删除成功
		Integer count = sortdetailDAO.deleteSortdetailInfoById(detailId);
		// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
		//detailRoleDAO.deleteSortdetailRoleById(detailId);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细(多选框批量删除)
	 * 
	 * @param idArray
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public boolean deleteSortdetails(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long detailId : idArray) {
			// 删除类别详细信息
			Integer count = sortdetailDAO.deleteSortdetailInfoById(detailId);
			// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
			//detailRoleDAO.deleteSortdetailRoleById(detailId);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param detailId
	 * @return Sortdetail
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public Sortdetail getSortdetailInfo(long detailId) {
		Sortdetail detail = sortdetailDAO.getSortdetailInfo(detailId);
		return detail;
	}

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param id
	 * @return 类别详细分页对象
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	public SortdetailPage getSortdetailInfoList(SortdetailPage page) {
		int count = sortdetailDAO.findSortdetailInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Sortdetail> sortdetailList = sortdetailDAO.findSortdetailInfoList(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setSortdetailList(sortdetailList); // 类别详细信息集合
		return page;
	}

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	@Override
	public SortdetailPage getSortdetailListById(SortdetailPage page) {
		// 取得类别详细信息集合(分页查询)
		List<Sortdetail> detailList = sortdetailDAO.getSortdetailListById(page);
		page.setSortdetailList(detailList); // 类别详细信息集合
		return page;
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
	@Override
	public List<Sortdetail> getSortdetailList(Sortdetail detail) {
		return sortdetailDAO.getSortdetailList(detail);
	}
}