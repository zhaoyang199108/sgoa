package com.bcqsoft.xhlm.service.ptfwdetail;

import com.bcqsoft.xhlm.dao.ptfwdetail.dataobject.PtfwDetail;
import com.bcqsoft.xhlm.dao.ptfwdetail.dataobject.PtfwDetailPage;

/**
 * 协会服务详细模块业务逻辑类接口
 */
public interface PtfwDetailService {

	/**
	 * 添加协会服务详细信息
	 * 
	 * @param ptfwdetail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean createPtfwDetail(PtfwDetail ptfwdetail);

	/**
	 * 修改协会服务详细信息
	 * 
	 * @param ptfwdetail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean modifyPtfwDetail(PtfwDetail ptfwdetail);

	/**
	 * 删除协会服务详细信息
	 * 
	 * @param ptfwdetailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean deletePtfwDetail(long ptfwdetailId);

	/**
	 * 删除协会服务详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean deletePtfwDetails(long[] idArray);

	/**
	 * 根据ID查找某一协会服务详细的信息
	 * 
	 * @param ptfwdetailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	PtfwDetail getPtfwDetailInfo(long ptfwdetailId);

	/**
	 * 根据查询条件查找协会服务详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	PtfwDetailPage getPtfwDetailInfoList(PtfwDetailPage page);

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
	PtfwDetailPage getXhwfDetailInfoListByXhhdId(PtfwDetailPage page);
}