package com.bcqsoft.xhlm.service.pthd.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.pthd.PthdDAO;
import com.bcqsoft.xhlm.dao.pthd.dataobject.Pthd;
import com.bcqsoft.xhlm.dao.pthd.dataobject.PthdPage;
import com.bcqsoft.xhlm.service.pthd.PthdService;

/**
 * 类别详细模块业务逻辑类接口
 */
@Service
public class PthdServiceImpl extends BaseService implements PthdService {
	/**
	 * 类别详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private PthdDAO pthdDAO;
	/**
	 * 添加类别详细信息
	 * 
	 * @param pthd
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean createPthd(Pthd pthd) {
		// 数据库新增一条类别详细记录,并返回是否插入成功
		Long pk = pthdDAO.insertIntoPthd(pthd);
		return isInsertSucc(pk);
	}

	/**
	 * 修改类别详细信息
	 * 
	 * @param pthd
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean modifyPthd(Pthd pthd) {
		// 更新该条类别详细信息,并返回是更新成功
		Integer count = pthdDAO.updatePthdInfoById(pthd);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细信息
	 * 
	 * @param pthdId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean deletePthd(long pthdId) {
		// 删除该条类别详细信息,并返回是否删除成功
		Integer count = pthdDAO.deletePthdInfoById(pthdId);
		// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
		//pthdRoleDAO.deletePthdRoleById(pthdId);
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
	public boolean deletePthds(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long pthdId : idArray) {
			// 删除类别详细信息
			Integer count = pthdDAO.deletePthdInfoById(pthdId);
			// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
			//pthdRoleDAO.deletePthdRoleById(pthdId);
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
	 * @param pthdId
	 * @return Pthd
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public Pthd getPthdInfo(long pthdId) {
		Pthd pthd = pthdDAO.getPthdInfo(pthdId);
		return pthd;
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
	public PthdPage getPthdInfoList(PthdPage page) {
		int count = pthdDAO.findPthdInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Pthd> pthdList = pthdDAO.findPthdInfoList(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setPthdList(pthdList); // 类别详细信息集合
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
	public PthdPage getAllPthdForList(PthdPage page) {
		// 取得类别详细信息集合(分页查询)
		List<Pthd> pthdList = pthdDAO.findPthdInfoListById(page);
		page.setPthdList(pthdList); // 类别详细信息集合
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
	public PthdPage getPthdInfoListByHome(PthdPage page) {
		int count = pthdDAO.findPthdInfoCountByHome(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Pthd> pthdList = pthdDAO.findPthdInfoListByHome(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setPthdList(pthdList); // 类别详细信息集合
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
	public List<Pthd> getPthdInfoListByLoginId(String loginId) {
		return pthdDAO.getPthdInfoListByLoginId(loginId);
	}
}