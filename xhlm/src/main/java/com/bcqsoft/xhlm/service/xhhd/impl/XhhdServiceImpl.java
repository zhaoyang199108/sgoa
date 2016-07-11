package com.bcqsoft.xhlm.service.xhhd.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.xhhd.XhhdDAO;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.Xhhd;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.XhhdPage;
import com.bcqsoft.xhlm.service.xhhd.XhhdService;

/**
 * 类别详细模块业务逻辑类接口
 */
@Service
public class XhhdServiceImpl extends BaseService implements XhhdService {
	/**
	 * 类别详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private XhhdDAO xhhdDAO;
	/**
	 * 添加类别详细信息
	 * 
	 * @param xhhd
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean createXhhd(Xhhd xhhd) {
		// 数据库新增一条类别详细记录,并返回是否插入成功
		Long pk = xhhdDAO.insertIntoXhhd(xhhd);
		return isInsertSucc(pk);
	}

	/**
	 * 修改类别详细信息
	 * 
	 * @param xhhd
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean modifyXhhd(Xhhd xhhd) {
		// 更新该条类别详细信息,并返回是更新成功
		Integer count = xhhdDAO.updateXhhdInfoById(xhhd);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细信息
	 * 
	 * @param xhhdId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean deleteXhhd(long xhhdId) {
		// 删除该条类别详细信息,并返回是否删除成功
		Integer count = xhhdDAO.deleteXhhdInfoById(xhhdId);
		// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
		//xhhdRoleDAO.deleteXhhdRoleById(xhhdId);
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
	public boolean deleteXhhds(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long xhhdId : idArray) {
			// 删除类别详细信息
			Integer count = xhhdDAO.deleteXhhdInfoById(xhhdId);
			// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
			//xhhdRoleDAO.deleteXhhdRoleById(xhhdId);
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
	 * @param xhhdId
	 * @return Xhhd
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public Xhhd getXhhdInfo(long xhhdId) {
		Xhhd xhhd = xhhdDAO.getXhhdInfo(xhhdId);
		return xhhd;
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
	public XhhdPage getXhhdInfoList(XhhdPage page) {
		int count = xhhdDAO.findXhhdInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Xhhd> xhhdList = xhhdDAO.findXhhdInfoList(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setXhhdList(xhhdList); // 类别详细信息集合
		return page;
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
	public XhhdPage getXhhdInfoListQy(XhhdPage page) {
		int count = xhhdDAO.findXhhdInfoCountQy(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Xhhd> xhhdList = xhhdDAO.findXhhdInfoListQy(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setXhhdList(xhhdList); // 类别详细信息集合
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
	public XhhdPage getAllXhhdForList(XhhdPage page) {
		// 取得类别详细信息集合(分页查询)
		List<Xhhd> xhhdList = xhhdDAO.findXhhdInfoListById(page);
		page.setXhhdList(xhhdList); // 类别详细信息集合
		return page;
	}

	/**
	 * 推荐活动（协会活动）接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public XhhdPage getXhhdInfoListByHome(XhhdPage page) {
		int count = xhhdDAO.findXhhdInfoCountByHome(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Xhhd> xhhdList = xhhdDAO.findXhhdInfoListByHome(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setXhhdList(xhhdList); // 类别详细信息集合
		return page;
	}

	/**
	 * 根据LOGIN_ID查询协会的协会活动列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public List<Xhhd> getXhhdInfoListByLoginId(String loginId) {
		return xhhdDAO.getXhhdInfoListByLoginId(loginId);
	}
	
	/**
	 * 根据LOGIN_ID查询协会的协会活动列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public List<Xhhd> getXhhdInfoListAll() {
		return xhhdDAO.getXhhdInfoListAll();
	}
}