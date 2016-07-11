package com.bcqsoft.xhlm.service.pthddetail;

import com.bcqsoft.xhlm.dao.pthddetail.dataobject.PthdDetail;
import com.bcqsoft.xhlm.dao.pthddetail.dataobject.PthdDetailPage;

/**
 * 协会服务详细模块业务逻辑类接口
 */
public interface PthdDetailService {

	/**
	 * 添加协会服务详细信息
	 * 
	 * @param pthddetail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean createPthdDetail(PthdDetail pthddetail);

	/**
	 * 修改协会服务详细信息
	 * 
	 * @param pthddetail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean modifyPthdDetail(PthdDetail pthddetail);

	/**
	 * 删除协会服务详细信息
	 * 
	 * @param pthddetailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean deletePthdDetail(long pthddetailId);

	/**
	 * 删除协会服务详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean deletePthdDetails(long[] idArray);

	/**
	 * 根据ID查找某一协会服务详细的信息
	 * 
	 * @param pthddetailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	PthdDetail getPthdDetailInfo(long pthddetailId);

	/**
	 * 根据查询条件查找协会服务详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	PthdDetailPage getPthdDetailInfoList(PthdDetailPage page);

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
	PthdDetailPage getPthdDetailInfoListByPthdId(PthdDetailPage page);
}