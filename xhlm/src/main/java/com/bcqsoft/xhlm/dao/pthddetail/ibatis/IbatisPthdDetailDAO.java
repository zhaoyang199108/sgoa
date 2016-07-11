package com.bcqsoft.xhlm.dao.pthddetail.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.pthddetail.PthdDetailDAO;
import com.bcqsoft.xhlm.dao.pthddetail.dataobject.PthdDetail;
import com.bcqsoft.xhlm.dao.pthddetail.dataobject.PthdDetailPage;

@Repository
/**
 *协会服务详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisPthdDetailDAO extends BaseDAO implements PthdDetailDAO {
	/**
	 * 查找协会服务详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findPthdDetailInfoCount(PthdDetailPage page) {
		return (Integer) ibatis().queryForObject("pthddetail.findPthdDetailInfoCount", page);
	}

	/**
	 * 查找协会服务详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;PthdDetails&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<PthdDetail> findPthdDetailInfoList(PthdDetailPage page) {
		return (List<PthdDetail>) ibatis().queryForList("pthddetail.findPthdDetailInfoList", page);
	}

	/**
	 * 插入一条协会服务详细信息至协会服务详细表
	 * 
	 * @param pthddetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoPthdDetail(PthdDetail pthddetail) {
		return (Long) ibatis().insert("pthddetail.insertIntoPthdDetail", pthddetail);
	}

	/**
	 * 根据协会服务详细ID更新协会服务详细表信息
	 * 
	 * @param pthddetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updatePthdDetailInfoById(PthdDetail pthddetail) {
		return (Integer) ibatis().update("pthddetail.updatePthdDetailInfoById", pthddetail);
	}

	/**
	 * 根据协会服务详细ID删除协会服务详细表信息
	 * 
	 * @param pthddetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deletePthdDetailInfoById(Long pthddetailId) {
		return (Integer) ibatis().update("pthddetail.deletePthdDetailInfoById", pthddetailId);
	}

	/**
	 * 根据协会服务详细ID查询协会服务详细表信息
	 * 
	 * @param pthddetailId
	 * @return PthdDetail
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public PthdDetail getPthdDetailInfo(long pthddetailId) {
		return (PthdDetail) ibatis().queryForObject("pthddetail.getPthdDetailInfo", pthddetailId);
	}

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
	@Override
	public Integer findPthdDetailInfoCountByPthdId(PthdDetailPage page) {
		return (Integer) ibatis().queryForObject("pthddetail.findPthdDetailInfoCountByPthdId", page);
	}
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
	@SuppressWarnings("unchecked")
	@Override
	public List<PthdDetail> findPthdDetailInfoListByPthdId(PthdDetailPage page) {
		return (List<PthdDetail>) ibatis().queryForList("pthddetail.findPthdDetailInfoListByPthdId", page);
	}
}