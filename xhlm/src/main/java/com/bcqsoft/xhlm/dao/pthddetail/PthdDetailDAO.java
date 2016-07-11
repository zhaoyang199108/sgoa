package com.bcqsoft.xhlm.dao.pthddetail;

import java.util.List;

import com.bcqsoft.xhlm.dao.pthddetail.dataobject.PthdDetail;
import com.bcqsoft.xhlm.dao.pthddetail.dataobject.PthdDetailPage;

/**
 * 协会服务详细数据库访问层Ibatis接口
 */
public interface PthdDetailDAO {

	/**
	 * 查找协会服务详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-03-21
	 * @return List&lt;PthdDetails&gt;
	 */
	Integer findPthdDetailInfoCount(PthdDetailPage page);

	/**
	 * 查找协会服务详细列表
	 * 
	 * @author lzn
	 * @date 2016-03-21
	 * @return List&lt;PthdDetails&gt;
	 */
	List<PthdDetail> findPthdDetailInfoList(PthdDetailPage page);

	/**
	 * 插入一条协会服务详细信息至协会服务详细表(SCOA_TB_NEWS)
	 * 
	 * @param pthddetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Long insertIntoPthdDetail(PthdDetail pthddetail);

	/**
	 * 根据协会服务详细ID更新协会服务详细表信息
	 * 
	 * @param pthddetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Integer updatePthdDetailInfoById(PthdDetail pthddetail);

	/**
	 * 根据协会服务详细ID删除协会服务详细表信息
	 * 
	 * @param pthddetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Integer deletePthdDetailInfoById(Long pthddetailId);

	/**
	 * 根据协会服务详细ID查询协会服务详细表信息
	 * 
	 * @param pthddetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	PthdDetail getPthdDetailInfo(long pthddetailId);

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
	Integer findPthdDetailInfoCountByPthdId(PthdDetailPage page);

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
	List<PthdDetail> findPthdDetailInfoListByPthdId(PthdDetailPage page);
}