package com.bcqsoft.xhlm.dao.xhhddetail.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.xhhddetail.XhhdDetailDAO;
import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetail;
import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetailPage;

@Repository
/**
 *协会服务详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisXhhdDetailDAO extends BaseDAO implements XhhdDetailDAO {
	/**
	 * 查找协会服务详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findXhhdDetailInfoCount(XhhdDetailPage page) {
		return (Integer) ibatis().queryForObject("xhhddetail.findXhhdDetailInfoCount", page);
	}

	/**
	 * 查找协会服务详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;XhhdDetails&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<XhhdDetail> findXhhdDetailInfoList(XhhdDetailPage page) {
		return (List<XhhdDetail>) ibatis().queryForList("xhhddetail.findXhhdDetailInfoList", page);
	}

	/**
	 * 插入一条协会服务详细信息至协会服务详细表
	 * 
	 * @param xhhddetail
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoXhhdDetail(XhhdDetail xhhddetail) {
		return (Long) ibatis().insert("xhhddetail.insertIntoXhhdDetail", xhhddetail);
	}

	/**
	 * 根据协会服务详细ID更新协会服务详细表信息
	 * 
	 * @param xhhddetail
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updateXhhdDetailInfoById(XhhdDetail xhhddetail) {
		return (Integer) ibatis().update("xhhddetail.updateXhhdDetailInfoById", xhhddetail);
	}

	/**
	 * 根据协会服务详细ID删除协会服务详细表信息
	 * 
	 * @param xhhddetailId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deleteXhhdDetailInfoById(Long xhhddetailId) {
		return (Integer) ibatis().update("xhhddetail.deleteXhhdDetailInfoById", xhhddetailId);
	}

	/**
	 * 根据协会服务详细ID查询协会服务详细表信息
	 * 
	 * @param xhhddetailId
	 * @return XhhdDetail
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public XhhdDetail getXhhdDetailInfo(long xhhddetailId) {
		return (XhhdDetail) ibatis().queryForObject("xhhddetail.getXhhdDetailInfo", xhhddetailId);
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
	public Integer findXhhdDetailInfoCountByXhhdId(XhhdDetailPage page) {
		return (Integer) ibatis().queryForObject("xhhddetail.findXhhdDetailInfoCountByXhhdId", page);
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
	public List<XhhdDetail> findXhhdDetailInfoListByXhhdId(XhhdDetailPage page) {
		return (List<XhhdDetail>) ibatis().queryForList("xhhddetail.findXhhdDetailInfoListByXhhdId", page);
	}
	
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	public Integer findXhhdDetailLoginCount(XhhdDetailPage page) {
		return (Integer) ibatis().queryForObject("xhhddetail.findXhhdDetailLoginCount", page);
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
	public Integer deleteXhhdDetailByLoginId(XhhdDetailPage page) {
		return (Integer) ibatis().delete("xhhddetail.deleteXhhdDetailByLoginId", page);
	}
}