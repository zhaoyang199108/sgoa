package com.bcqsoft.xhlm.dao.xhfwdetail.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.xhfwdetail.XhfwDetailDAO;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetail;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetailPage;

@Repository
/**
 *协会服务详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisXhfwDetailDAO extends BaseDAO implements XhfwDetailDAO {
	/**
	 * 查找协会服务详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findXhfwDetailInfoCount(XhfwDetailPage page) {
		return (Integer) ibatis().queryForObject("xhfwdetail.findXhfwDetailInfoCount", page);
	}

	/**
	 * 查找协会服务详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;XhfwDetails&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<XhfwDetail> findXhfwDetailInfoList(XhfwDetailPage page) {
		return (List<XhfwDetail>) ibatis().queryForList("xhfwdetail.findXhfwDetailInfoList", page);
	}

	/**
	 * 插入一条协会服务详细信息至协会服务详细表
	 * 
	 * @param xhfwdetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoXhfwDetail(XhfwDetail xhfwdetail) {
		return (Long) ibatis().insert("xhfwdetail.insertIntoXhfwDetail", xhfwdetail);
	}

	/**
	 * 根据协会服务详细ID更新协会服务详细表信息
	 * 
	 * @param xhfwdetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updateXhfwDetailInfoById(XhfwDetail xhfwdetail) {
		return (Integer) ibatis().update("xhfwdetail.updateXhfwDetailInfoById", xhfwdetail);
	}

	/**
	 * 根据协会服务详细ID删除协会服务详细表信息
	 * 
	 * @param xhfwdetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deleteXhfwDetailInfoById(Long xhfwdetailId) {
		return (Integer) ibatis().update("xhfwdetail.deleteXhfwDetailInfoById", xhfwdetailId);
	}

	/**
	 * 根据协会服务详细ID查询协会服务详细表信息
	 * 
	 * @param xhfwdetailId
	 * @return XhfwDetail
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public XhfwDetail getXhfwDetailInfo(long xhfwdetailId) {
		return (XhfwDetail) ibatis().queryForObject("xhfwdetail.getXhfwDetailInfo", xhfwdetailId);
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
	public Integer findXhfwDetailInfoCountByXhhdId(XhfwDetailPage page) {
		return (Integer) ibatis().queryForObject("xhfwdetail.findXhfwDetailInfoCountByXhhdId", page);
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
	public List<XhfwDetail> findXhfwDetailInfoListByXhhdId(XhfwDetailPage page) {
		return (List<XhfwDetail>) ibatis().queryForList("xhfwdetail.findXhfwDetailInfoListByXhhdId", page);
	}
	
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	public Integer findXhfwDetailLoginCount(XhfwDetailPage page) {
		return (Integer) ibatis().queryForObject("xhfwdetail.findXhfwDetailLoginCount", page);
	}
	
	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param xhfwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deleteXhfwDetailByLoginId(XhfwDetailPage page) {
		return (Integer) ibatis().delete("xhfwdetail.deleteXhfwDetailByLoginId", page);
	}
}