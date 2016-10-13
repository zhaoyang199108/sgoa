package com.bcqsoft.sgoa.service.ggtxl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.ggtxl.GgtxlDAO;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.Ggtxl;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.GgtxlPage;
import com.bcqsoft.sgoa.service.ggtxl.GgtxlService;

/**
 * 物资设备申领表模块业务逻辑实现类
 */
@Service
public class GgtxlServiceImpl extends BaseService implements GgtxlService {

	/**
	 * 公共通讯录模块DAO实现类
	 */
	@Autowired
	private GgtxlDAO ggtxlDAO;

	/**
	 * 根据查询条件查找公共通讯录信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	@Override
	public GgtxlPage getGgtxlInfoList(GgtxlPage page) {
		int count = ggtxlDAO.findGgtxlInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得公共通讯录信息集合(分页查询)
		List<Ggtxl> ggtxlList = ggtxlDAO.findGgtxlInfoList(page);

		page.setTotalRow(count); // 公共通讯录总数量
		page.setGgtxlList(ggtxlList); // 公共通讯录信息集合
		return page;
	}
	/**
	 * 根据查询条件查找公共通讯录信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	@Override
	public GgtxlPage getGgtxlAllList(GgtxlPage page) {
		int count = ggtxlDAO.findGgtxlAllCount(page);

		if (count == 0) {
			return page;
		}
		// 取得公共通讯录信息集合(分页查询)
		List<Ggtxl> ggtxlList = ggtxlDAO.findGgtxlAllList(page);

		page.setTotalRow(count); // 公共通讯录总数量
		page.setGgtxlList(ggtxlList); // 公共通讯录信息集合
		return page;
	}

	/**
	 * 添加公共通讯录信息
	 * 
	 * @param ggtxl
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean createGgtxl(Ggtxl ggtxl) {
		// 数据库新增一条公共通讯录记录,并返回是否插入成功
		Long pk = ggtxlDAO.insertIntoGgtxl(ggtxl);
		return isInsertSucc(pk);
	}

	/**
	 * 公共通讯录详细信息
	 * 
	 * @param ggtxl
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public Ggtxl getGgtxlInfo(long id) {
		Ggtxl ggtxl = ggtxlDAO.getGgtxlInfo(id);
		return ggtxl;
	}

	/**
	 * 修改公共通讯录信息
	 * 
	 * @param ggtxl
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */

	public boolean editGgtxlInfo(Ggtxl ggtxl) {
		Integer count = ggtxlDAO.updateGgtxlInfoById(ggtxl);
		return isUpdateSucc(count);
	}

	/**
	 * 删除公共通讯录信息
	 * 
	 * @param ggtxlId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean deleteGgtxl(long id) {
		// 根据id取得用户信息
		Integer count = ggtxlDAO.deleteGgtxlInfoById(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除公共通讯录信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean deleteGgtxls(long[] longArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long ggtxlId : longArray) {

			// 删除用户信息
			Integer count = ggtxlDAO.deleteGgtxlInfoById(ggtxlId);

			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	@Override
	public GgtxlPage getGgtxlInfoSearchList(GgtxlPage page) {
		int count = ggtxlDAO.findGgtxlInfoSearchCount(page);

		if (count == 0) {
			return page;
		}
		// 取得公共通讯录信息集合(分页查询)
		List<Ggtxl> ggtxlList = ggtxlDAO.findGgtxlInfoSearchList(page);

		page.setTotalRow(count); // 公共通讯录总数量
		page.setGgtxlList(ggtxlList); // 公共通讯录信息集合
		return page;
	}

}
