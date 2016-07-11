package com.bcqsoft.xhlm.service.xhfwdetail.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.xhfwdetail.XhfwDetailDAO;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetail;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetailPage;
import com.bcqsoft.xhlm.service.xhfwdetail.XhfwDetailService;

/**
 * 协会服务详细模块业务逻辑类接口
 */
@Service
public class XhfwDetailServiceImpl extends BaseService implements XhfwDetailService {
	/**
	 * 协会服务详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private XhfwDetailDAO xhfwdetailDAO;
	/**
	 * 添加协会服务详细信息
	 * 
	 * @param xhfwdetail
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean createXhfwDetail(XhfwDetail xhfwdetail) {
		// 数据库新增一条协会服务详细记录,并返回是否插入成功
		Long pk = xhfwdetailDAO.insertIntoXhfwDetail(xhfwdetail);
		return isInsertSucc(pk);
	}

	/**
	 * 修改协会服务详细信息
	 * 
	 * @param xhfwdetail
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean modifyXhfwDetail(XhfwDetail xhfwdetail) {
		// 更新该条协会服务详细信息,并返回是更新成功
		Integer count = xhfwdetailDAO.updateXhfwDetailInfoById(xhfwdetail);
		return isUpdateSucc(count);
	}

	/**
	 * 删除协会服务详细信息
	 * 
	 * @param xhfwdetailId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public boolean deleteXhfwDetail(long xhfwdetailId) {
		// 删除该条协会服务详细信息,并返回是否删除成功
		Integer count = xhfwdetailDAO.deleteXhfwDetailInfoById(xhfwdetailId);
		// 删除该协会服务详细Id的协会服务详细角色信息,并返回是否删除成功
		//xhfwdetailRoleDAO.deleteXhfwDetailRoleById(xhfwdetailId);
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
	public boolean deleteXhfwDetails(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long xhfwdetailId : idArray) {
			// 删除协会服务详细信息
			Integer count = xhfwdetailDAO.deleteXhfwDetailInfoById(xhfwdetailId);
			// 删除该协会服务详细Id的协会服务详细角色信息,并返回是否删除成功
			//xhfwdetailRoleDAO.deleteXhfwDetailRoleById(xhfwdetailId);
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
	 * @param xhfwdetailId
	 * @return XhfwDetail
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	public XhfwDetail getXhfwDetailInfo(long xhfwdetailId) {
		XhfwDetail xhfwdetail = xhfwdetailDAO.getXhfwDetailInfo(xhfwdetailId);
		return xhfwdetail;
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
	public XhfwDetailPage getXhfwDetailInfoList(XhfwDetailPage page) {
		int count = xhfwdetailDAO.findXhfwDetailInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得协会服务详细信息集合(分页查询)
		List<XhfwDetail> xhfwDetailList = xhfwdetailDAO.findXhfwDetailInfoList(page);		
		page.setTotalRow(count); // 协会服务详细总数量
		page.setXhfwDetailList(xhfwDetailList); // 协会服务详细信息集合
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
	public XhfwDetailPage getXhwfDetailInfoListByXhhdId(XhfwDetailPage page) {
		int count = xhfwdetailDAO.findXhfwDetailInfoCountByXhhdId(page);

		if (count == 0) {
			return page;
		}
		// 取得协会服务详细信息集合(分页查询)
		List<XhfwDetail> xhfwDetailList = xhfwdetailDAO.findXhfwDetailInfoListByXhhdId(page);		
		page.setTotalRow(count); // 协会服务详细总数量
		page.setXhfwDetailList(xhfwDetailList); // 协会服务详细信息集合
		return page;
	}
	
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	public Integer findXhfwDetailLoginCount(XhfwDetailPage page){
		int count = xhfwdetailDAO.findXhfwDetailLoginCount(page);
		return count;
	}
	
	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param xhfwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public boolean deleteXhfwDetailByLoginId(XhfwDetailPage page){
		boolean returnValue = false;
		Integer count = xhfwdetailDAO.deleteXhfwDetailByLoginId(page);
		if (count != null && count > 0) {
			returnValue = true;
		}
		return returnValue;
	}
}