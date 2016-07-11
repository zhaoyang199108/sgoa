package com.bcqsoft.xhlm.service.xhxw.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.xhxw.XhxwDAO;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.Xhxw;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.XhxwPage;
import com.bcqsoft.xhlm.service.xhxw.XhxwService;

/**
 * 类别详细模块业务逻辑类接口
 */
@Service
public class XhxwServiceImpl extends BaseService implements XhxwService {
	/**
	 * 类别详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private XhxwDAO xhxwDAO;
	/**
	 * 添加类别详细信息
	 * 
	 * @param xhxw
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean createXhxw(Xhxw xhxw) {
		// 数据库新增一条类别详细记录,并返回是否插入成功
		Long pk = xhxwDAO.insertIntoXhxw(xhxw);
		return isInsertSucc(pk);
	}

	/**
	 * 修改类别详细信息
	 * 
	 * @param xhxw
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean modifyXhxw(Xhxw xhxw) {
		// 更新该条类别详细信息,并返回是更新成功
		Integer count = xhxwDAO.updateXhxwInfoById(xhxw);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细信息
	 * 
	 * @param xhxwId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean deleteXhxw(long xhxwId) {
		// 删除该条类别详细信息,并返回是否删除成功
		Integer count = xhxwDAO.deleteXhxwInfoById(xhxwId);
		// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
		//xhxwRoleDAO.deleteXhxwRoleById(xhxwId);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细(多选框批量删除)
	 * 
	 * @param idArray
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean deleteXhxws(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long xhxwId : idArray) {
			// 删除类别详细信息
			Integer count = xhxwDAO.deleteXhxwInfoById(xhxwId);
			// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
			//xhxwRoleDAO.deleteXhxwRoleById(xhxwId);
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
	 * @param xhxwId
	 * @return Xhxw
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public Xhxw getXhxwInfo(long xhxwId) {
		Xhxw xhxw = xhxwDAO.getXhxwInfo(xhxwId);
		return xhxw;
	}

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param id
	 * @return 类别详细分页对象
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public XhxwPage getXhxwInfoList(XhxwPage page) {
		int count = xhxwDAO.findXhxwInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Xhxw> xhxwList = xhxwDAO.findXhxwInfoList(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setXhxwList(xhxwList); // 类别详细信息集合
		return page;
	}

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	@Override
	public XhxwPage getAllXhxwForList(XhxwPage page) {
		// 取得类别详细信息集合(分页查询)
		List<Xhxw> xhxwList = xhxwDAO.findXhxwInfoListById(page);
		page.setXhxwList(xhxwList); // 类别详细信息集合
		return page;
	}

	/**
	 * 行业新闻（协会新闻）接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public XhxwPage getXhxwInfoListByHome(XhxwPage page) {
		int count = xhxwDAO.findXhxwInfoCountByHome(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Xhxw> xhxwList = xhxwDAO.findXhxwInfoListByHome(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setXhxwList(xhxwList); // 类别详细信息集合
		return page;
	}

	/**
	 * 根据LOGIN_ID查询协会的行业新闻列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public List<Xhxw> getXhxwInfoListByLoginId(String loginId) {
		return xhxwDAO.getXhxwInfoListByLoginId(loginId);
	}
}