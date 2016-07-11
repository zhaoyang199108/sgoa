package com.bcqsoft.xhlm.service.pthddetail.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.pthddetail.PthdDetailDAO;
import com.bcqsoft.xhlm.dao.pthddetail.dataobject.PthdDetail;
import com.bcqsoft.xhlm.dao.pthddetail.dataobject.PthdDetailPage;
import com.bcqsoft.xhlm.service.pthddetail.PthdDetailService;

/**
 * 协会服务详细模块业务逻辑类接口
 */
@Service
public class PthdDetailServiceImpl extends BaseService implements PthdDetailService {
	/**
	 * 协会服务详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private PthdDetailDAO pthddetailDAO;
	/**
	 * 添加协会服务详细信息
	 * 
	 * @param pthddetail
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean createPthdDetail(PthdDetail pthddetail) {
		// 数据库新增一条协会服务详细记录,并返回是否插入成功
		Long pk = pthddetailDAO.insertIntoPthdDetail(pthddetail);
		return isInsertSucc(pk);
	}

	/**
	 * 修改协会服务详细信息
	 * 
	 * @param pthddetail
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean modifyPthdDetail(PthdDetail pthddetail) {
		// 更新该条协会服务详细信息,并返回是更新成功
		Integer count = pthddetailDAO.updatePthdDetailInfoById(pthddetail);
		return isUpdateSucc(count);
	}

	/**
	 * 删除协会服务详细信息
	 * 
	 * @param pthddetailId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean deletePthdDetail(long pthddetailId) {
		// 删除该条协会服务详细信息,并返回是否删除成功
		Integer count = pthddetailDAO.deletePthdDetailInfoById(pthddetailId);
		// 删除该协会服务详细Id的协会服务详细角色信息,并返回是否删除成功
		//pthddetailRoleDAO.deletePthdDetailRoleById(pthddetailId);
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
	public boolean deletePthdDetails(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long pthddetailId : idArray) {
			// 删除协会服务详细信息
			Integer count = pthddetailDAO.deletePthdDetailInfoById(pthddetailId);
			// 删除该协会服务详细Id的协会服务详细角色信息,并返回是否删除成功
			//pthddetailRoleDAO.deletePthdDetailRoleById(pthddetailId);
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
	 * @param pthddetailId
	 * @return PthdDetail
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public PthdDetail getPthdDetailInfo(long pthddetailId) {
		PthdDetail pthddetail = pthddetailDAO.getPthdDetailInfo(pthddetailId);
		return pthddetail;
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
	public PthdDetailPage getPthdDetailInfoList(PthdDetailPage page) {
		int count = pthddetailDAO.findPthdDetailInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得协会服务详细信息集合(分页查询)
		List<PthdDetail> pthdDetailList = pthddetailDAO.findPthdDetailInfoList(page);		
		page.setTotalRow(count); // 协会服务详细总数量
		page.setPthdDetailList(pthdDetailList); // 协会服务详细信息集合
		return page;
	}
	
	/**
	 * 活动页接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public PthdDetailPage getPthdDetailInfoListByPthdId(PthdDetailPage page) {
		int count = pthddetailDAO.findPthdDetailInfoCountByPthdId(page);

		if (count == 0) {
			return page;
		}
		// 取得协会服务详细信息集合(分页查询)
		List<PthdDetail> pthdDetailList = pthddetailDAO.findPthdDetailInfoListByPthdId(page);		
		page.setTotalRow(count); // 协会服务详细总数量
		page.setPthdDetailList(pthdDetailList); // 协会服务详细信息集合
		return page;
	}
}