package com.bcqsoft.xhlm.dao.ptfwdetail;

import java.util.List;

import com.bcqsoft.xhlm.dao.ptfwdetail.dataobject.PtfwDetail;
import com.bcqsoft.xhlm.dao.ptfwdetail.dataobject.PtfwDetailPage;

/**
 * 协会服务详细数据库访问层Ibatis接口
 */
public interface PtfwDetailDAO {

	/**
	 * 查找协会服务详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-03-21
	 * @return List&lt;PtfwDetails&gt;
	 */
	Integer findPtfwDetailInfoCount(PtfwDetailPage page);

	/**
	 * 查找协会服务详细列表
	 * 
	 * @author lzn
	 * @date 2016-03-21
	 * @return List&lt;PtfwDetails&gt;
	 */
	List<PtfwDetail> findPtfwDetailInfoList(PtfwDetailPage page);

	/**
	 * 插入一条协会服务详细信息至协会服务详细表(SCOA_TB_NEWS)
	 * 
	 * @param ptfwdetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Long insertIntoPtfwDetail(PtfwDetail ptfwdetail);

	/**
	 * 根据协会服务详细ID更新协会服务详细表信息
	 * 
	 * @param ptfwdetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Integer updatePtfwDetailInfoById(PtfwDetail ptfwdetail);

	/**
	 * 根据协会服务详细ID删除协会服务详细表信息
	 * 
	 * @param ptfwdetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	Integer deletePtfwDetailInfoById(Long ptfwdetailId);

	/**
	 * 根据协会服务详细ID查询协会服务详细表信息
	 * 
	 * @param ptfwdetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	PtfwDetail getPtfwDetailInfo(long ptfwdetailId);

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
	Integer findPtfwDetailInfoCountByXhhdId(PtfwDetailPage page);

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
	List<PtfwDetail> findPtfwDetailInfoListByXhhdId(PtfwDetailPage page);
}