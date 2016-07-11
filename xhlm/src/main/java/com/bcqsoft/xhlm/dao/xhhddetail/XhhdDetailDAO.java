package com.bcqsoft.xhlm.dao.xhhddetail;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetail;
import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetailPage;

/**
 * 协会服务详细数据库访问层Ibatis接口
 */
public interface XhhdDetailDAO {

	/**
	 * 查找协会服务详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-03-21
	 * @return List&lt;XhhdDetails&gt;
	 */
	Integer findXhhdDetailInfoCount(XhhdDetailPage page);

	/**
	 * 查找协会服务详细列表
	 * 
	 * @author lzn
	 * @date 2016-03-21
	 * @return List&lt;XhhdDetails&gt;
	 */
	List<XhhdDetail> findXhhdDetailInfoList(XhhdDetailPage page);

	/**
	 * 插入一条协会服务详细信息至协会服务详细表(SCOA_TB_NEWS)
	 * 
	 * @param xhhddetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Long insertIntoXhhdDetail(XhhdDetail xhhddetail);

	/**
	 * 根据协会服务详细ID更新协会服务详细表信息
	 * 
	 * @param xhhddetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Integer updateXhhdDetailInfoById(XhhdDetail xhhddetail);

	/**
	 * 根据协会服务详细ID删除协会服务详细表信息
	 * 
	 * @param xhhddetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Integer deleteXhhdDetailInfoById(Long xhhddetailId);

	/**
	 * 根据协会服务详细ID查询协会服务详细表信息
	 * 
	 * @param xhhddetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	XhhdDetail getXhhdDetailInfo(long xhhddetailId);

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
	Integer findXhhdDetailInfoCountByXhhdId(XhhdDetailPage page);

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
	List<XhhdDetail> findXhhdDetailInfoListByXhhdId(XhhdDetailPage page);
	
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
	Integer deleteXhhdDetailByLoginId(XhhdDetailPage page);
}