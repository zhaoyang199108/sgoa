package com.bcqsoft.xhlm.dao.xhfwdetail;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetail;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetailPage;

/**
 * 协会服务详细数据库访问层Ibatis接口
 */
public interface XhfwDetailDAO {

	/**
	 * 查找协会服务详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-03-21
	 * @return List&lt;XhfwDetails&gt;
	 */
	Integer findXhfwDetailInfoCount(XhfwDetailPage page);

	/**
	 * 查找协会服务详细列表
	 * 
	 * @author lzn
	 * @date 2016-03-21
	 * @return List&lt;XhfwDetails&gt;
	 */
	List<XhfwDetail> findXhfwDetailInfoList(XhfwDetailPage page);

	/**
	 * 插入一条协会服务详细信息至协会服务详细表(SCOA_TB_NEWS)
	 * 
	 * @param xhfwdetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Long insertIntoXhfwDetail(XhfwDetail xhfwdetail);

	/**
	 * 根据协会服务详细ID更新协会服务详细表信息
	 * 
	 * @param xhfwdetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Integer updateXhfwDetailInfoById(XhfwDetail xhfwdetail);

	/**
	 * 根据协会服务详细ID删除协会服务详细表信息
	 * 
	 * @param xhfwdetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Integer deleteXhfwDetailInfoById(Long xhfwdetailId);

	/**
	 * 根据协会服务详细ID查询协会服务详细表信息
	 * 
	 * @param xhfwdetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	XhfwDetail getXhfwDetailInfo(long xhfwdetailId);

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
	Integer findXhfwDetailInfoCountByXhhdId(XhfwDetailPage page);

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
	List<XhfwDetail> findXhfwDetailInfoListByXhhdId(XhfwDetailPage page);
	
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
	Integer deleteXhfwDetailByLoginId(XhfwDetailPage page);
}