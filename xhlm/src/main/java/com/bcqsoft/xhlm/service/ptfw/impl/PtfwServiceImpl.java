package com.bcqsoft.xhlm.service.ptfw.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.ptfw.PtfwDAO;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.Ptfw;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.PtfwPage;
import com.bcqsoft.xhlm.service.ptfw.PtfwService;

/**
 * 类别详细模块业务逻辑类接口
 */
@Service
public class PtfwServiceImpl extends BaseService implements PtfwService {
	/**
	 * 类别详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private PtfwDAO ptfwDAO;
	/**
	 * 添加类别详细信息
	 * 
	 * @param ptfw
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean createPtfw(Ptfw ptfw) {
		// 数据库新增一条类别详细记录,并返回是否插入成功
		Long pk = ptfwDAO.insertIntoPtfw(ptfw);
		return isInsertSucc(pk);
	}

	/**
	 * 修改类别详细信息
	 * 
	 * @param ptfw
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean modifyPtfw(Ptfw ptfw) {
		// 更新该条类别详细信息,并返回是更新成功
		Integer count = ptfwDAO.updatePtfwInfoById(ptfw);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细信息
	 * 
	 * @param ptfwId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean deletePtfw(long ptfwId) {
		// 删除该条类别详细信息,并返回是否删除成功
		Integer count = ptfwDAO.deletePtfwInfoById(ptfwId);
		// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
		//ptfwRoleDAO.deletePtfwRoleById(ptfwId);
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
	public boolean deletePtfws(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long ptfwId : idArray) {
			// 删除类别详细信息
			Integer count = ptfwDAO.deletePtfwInfoById(ptfwId);
			// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
			//ptfwRoleDAO.deletePtfwRoleById(ptfwId);
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
	 * @param ptfwId
	 * @return Ptfw
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public Ptfw getPtfwInfo(long ptfwId) {
		Ptfw ptfw = ptfwDAO.getPtfwInfo(ptfwId);
		return ptfw;
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
	public PtfwPage getPtfwInfoList(PtfwPage page) {
		int count = ptfwDAO.findPtfwInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Ptfw> ptfwList = ptfwDAO.findPtfwInfoList(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setPtfwList(ptfwList); // 类别详细信息集合
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
	public PtfwPage getAllPtfwForList(PtfwPage page) {
		// 取得类别详细信息集合(分页查询)
		List<Ptfw> ptfwList = ptfwDAO.findPtfwInfoListById(page);
		page.setPtfwList(ptfwList); // 类别详细信息集合
		return page;
	}

	/**
	 * 根据LOGIN_ID查询协会的协会服务列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public List<Ptfw> getPtfwInfoListByLoginId(String loginId) {
		return ptfwDAO.getPtfwInfoListByLoginId(loginId);
	}
}