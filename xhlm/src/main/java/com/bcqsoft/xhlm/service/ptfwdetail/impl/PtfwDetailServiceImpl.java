package com.bcqsoft.xhlm.service.ptfwdetail.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.ptfwdetail.PtfwDetailDAO;
import com.bcqsoft.xhlm.dao.ptfwdetail.dataobject.PtfwDetail;
import com.bcqsoft.xhlm.dao.ptfwdetail.dataobject.PtfwDetailPage;
import com.bcqsoft.xhlm.service.ptfwdetail.PtfwDetailService;

/**
 * 协会服务详细模块业务逻辑类接口
 */
@Service
public class PtfwDetailServiceImpl extends BaseService implements PtfwDetailService {
	/**
	 * 协会服务详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private PtfwDetailDAO ptfwdetailDAO;
	/**
	 * 添加协会服务详细信息
	 * 
	 * @param ptfwdetail
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean createPtfwDetail(PtfwDetail ptfwdetail) {
		// 数据库新增一条协会服务详细记录,并返回是否插入成功
		Long pk = ptfwdetailDAO.insertIntoPtfwDetail(ptfwdetail);
		return isInsertSucc(pk);
	}

	/**
	 * 修改协会服务详细信息
	 * 
	 * @param ptfwdetail
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean modifyPtfwDetail(PtfwDetail ptfwdetail) {
		// 更新该条协会服务详细信息,并返回是更新成功
		Integer count = ptfwdetailDAO.updatePtfwDetailInfoById(ptfwdetail);
		return isUpdateSucc(count);
	}

	/**
	 * 删除协会服务详细信息
	 * 
	 * @param ptfwdetailId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean deletePtfwDetail(long ptfwdetailId) {
		// 删除该条协会服务详细信息,并返回是否删除成功
		Integer count = ptfwdetailDAO.deletePtfwDetailInfoById(ptfwdetailId);
		// 删除该协会服务详细Id的协会服务详细角色信息,并返回是否删除成功
		//ptfwdetailRoleDAO.deletePtfwDetailRoleById(ptfwdetailId);
		return isUpdateSucc(count);
	}

	/**
	 * 删除协会服务详细(多选框批量删除)
	 * 
	 * @param idArray
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean deletePtfwDetails(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long ptfwdetailId : idArray) {
			// 删除协会服务详细信息
			Integer count = ptfwdetailDAO.deletePtfwDetailInfoById(ptfwdetailId);
			// 删除该协会服务详细Id的协会服务详细角色信息,并返回是否删除成功
			//ptfwdetailRoleDAO.deletePtfwDetailRoleById(ptfwdetailId);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID查找某一协会服务详细的信息
	 * 
	 * @param ptfwdetailId
	 * @return PtfwDetail
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public PtfwDetail getPtfwDetailInfo(long ptfwdetailId) {
		PtfwDetail ptfwdetail = ptfwdetailDAO.getPtfwDetailInfo(ptfwdetailId);
		return ptfwdetail;
	}

	/**
	 * 根据查询条件查找协会服务详细信息列表
	 * 
	 * @param id
	 * @return 协会服务详细分页对象
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public PtfwDetailPage getPtfwDetailInfoList(PtfwDetailPage page) {
		int count = ptfwdetailDAO.findPtfwDetailInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得协会服务详细信息集合(分页查询)
		List<PtfwDetail> ptfwDetailList = ptfwdetailDAO.findPtfwDetailInfoList(page);		
		page.setTotalRow(count); // 协会服务详细总数量
		page.setPtfwDetailList(ptfwDetailList); // 协会服务详细信息集合
		return page;
	}

	/**
	 * 服务页接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public PtfwDetailPage getXhwfDetailInfoListByXhhdId(PtfwDetailPage page) {
		int count = ptfwdetailDAO.findPtfwDetailInfoCountByXhhdId(page);

		if (count == 0) {
			return page;
		}
		// 取得协会服务详细信息集合(分页查询)
		List<PtfwDetail> ptfwDetailList = ptfwdetailDAO.findPtfwDetailInfoListByXhhdId(page);		
		page.setTotalRow(count); // 协会服务详细总数量
		page.setPtfwDetailList(ptfwDetailList); // 协会服务详细信息集合
		return page;
	}
}