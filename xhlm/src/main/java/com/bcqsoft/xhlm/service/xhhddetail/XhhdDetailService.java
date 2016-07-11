package com.bcqsoft.xhlm.service.xhhddetail;

import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetail;
import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetailPage;

/**
 * 协会服务详细模块业务逻辑类接口
 */
public interface XhhdDetailService {

	/**
	 * 添加协会服务详细信息
	 * 
	 * @param xhhddetail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean createXhhdDetail(XhhdDetail xhhddetail);

	/**
	 * 修改协会服务详细信息
	 * 
	 * @param xhhddetail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean modifyXhhdDetail(XhhdDetail xhhddetail);

	/**
	 * 删除协会服务详细信息
	 * 
	 * @param xhhddetailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean deleteXhhdDetail(long xhhddetailId);

	/**
	 * 删除协会服务详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean deleteXhhdDetails(long[] idArray);

	/**
	 * 根据ID查找某一协会服务详细的信息
	 * 
	 * @param xhhddetailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	XhhdDetail getXhhdDetailInfo(long xhhddetailId);

	/**
	 * 根据查询条件查找协会服务详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	XhhdDetailPage getXhhdDetailInfoList(XhhdDetailPage page);

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
	XhhdDetailPage getXhhdDetailInfoListByXhhdId(XhhdDetailPage page);
	
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	Integer findXhhdDetailLoginCount(XhhdDetailPage page);
	
	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param xhfwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXhhdDetailByLoginId(XhhdDetailPage page);
}