package com.bcqsoft.xhlm.service.xhfwdetail;

import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetail;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetailPage;

/**
 * 协会服务详细模块业务逻辑类接口
 */
public interface XhfwDetailService {

	/**
	 * 添加协会服务详细信息
	 * 
	 * @param xhfwdetail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean createXhfwDetail(XhfwDetail xhfwdetail);

	/**
	 * 修改协会服务详细信息
	 * 
	 * @param xhfwdetail
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean modifyXhfwDetail(XhfwDetail xhfwdetail);

	/**
	 * 删除协会服务详细信息
	 * 
	 * @param xhfwdetailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean deleteXhfwDetail(long xhfwdetailId);

	/**
	 * 删除协会服务详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	boolean deleteXhfwDetails(long[] idArray);

	/**
	 * 根据ID查找某一协会服务详细的信息
	 * 
	 * @param xhfwdetailId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	XhfwDetail getXhfwDetailInfo(long xhfwdetailId);

	/**
	 * 根据查询条件查找协会服务详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	XhfwDetailPage getXhfwDetailInfoList(XhfwDetailPage page);

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
	XhfwDetailPage getXhwfDetailInfoListByXhhdId(XhfwDetailPage page);
	
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	Integer findXhfwDetailLoginCount(XhfwDetailPage page);
	
	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param xhfwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXhfwDetailByLoginId(XhfwDetailPage page);
}