package com.bcqsoft.xhlm.dao.ptfwdetail.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.ptfwdetail.PtfwDetailDAO;
import com.bcqsoft.xhlm.dao.ptfwdetail.dataobject.PtfwDetail;
import com.bcqsoft.xhlm.dao.ptfwdetail.dataobject.PtfwDetailPage;

@Repository
/**
 *协会服务详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisPtfwDetailDAO extends BaseDAO implements PtfwDetailDAO {
	/**
	 * 查找协会服务详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findPtfwDetailInfoCount(PtfwDetailPage page) {
		return (Integer) ibatis().queryForObject("ptfwdetail.findPtfwDetailInfoCount", page);
	}

	/**
	 * 查找协会服务详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;PtfwDetails&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<PtfwDetail> findPtfwDetailInfoList(PtfwDetailPage page) {
		return (List<PtfwDetail>) ibatis().queryForList("ptfwdetail.findPtfwDetailInfoList", page);
	}

	/**
	 * 插入一条协会服务详细信息至协会服务详细表
	 * 
	 * @param ptfwdetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoPtfwDetail(PtfwDetail ptfwdetail) {
		return (Long) ibatis().insert("ptfwdetail.insertIntoPtfwDetail", ptfwdetail);
	}

	/**
	 * 根据协会服务详细ID更新协会服务详细表信息
	 * 
	 * @param ptfwdetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updatePtfwDetailInfoById(PtfwDetail ptfwdetail) {
		return (Integer) ibatis().update("ptfwdetail.updatePtfwDetailInfoById", ptfwdetail);
	}

	/**
	 * 根据协会服务详细ID删除协会服务详细表信息
	 * 
	 * @param ptfwdetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deletePtfwDetailInfoById(Long ptfwdetailId) {
		return (Integer) ibatis().update("ptfwdetail.deletePtfwDetailInfoById", ptfwdetailId);
	}

	/**
	 * 根据协会服务详细ID查询协会服务详细表信息
	 * 
	 * @param ptfwdetailId
	 * @return PtfwDetail
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public PtfwDetail getPtfwDetailInfo(long ptfwdetailId) {
		return (PtfwDetail) ibatis().queryForObject("ptfwdetail.getPtfwDetailInfo", ptfwdetailId);
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
	public Integer findPtfwDetailInfoCountByXhhdId(PtfwDetailPage page) {
		return (Integer) ibatis().queryForObject("ptfwdetail.findPtfwDetailInfoCountByXhhdId", page);
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
	@SuppressWarnings("unchecked")
	@Override
	public List<PtfwDetail> findPtfwDetailInfoListByXhhdId(PtfwDetailPage page) {
		return (List<PtfwDetail>) ibatis().queryForList("ptfwdetail.findPtfwDetailInfoListByXhhdId", page);
	}
}