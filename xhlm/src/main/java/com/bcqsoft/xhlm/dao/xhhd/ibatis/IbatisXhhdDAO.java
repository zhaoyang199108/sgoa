package com.bcqsoft.xhlm.dao.xhhd.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.xhhd.XhhdDAO;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.Xhhd;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.XhhdPage;

@Repository
/**
 *类别详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisXhhdDAO extends BaseDAO implements XhhdDAO {
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findXhhdInfoCount(XhhdPage page) {
		return (Integer) ibatis().queryForObject("xhhd.findXhhdInfoCount", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhhds&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Xhhd> findXhhdInfoList(XhhdPage page) {
		return (List<Xhhd>) ibatis().queryForList("xhhd.findXhhdInfoList", page);
	}
	
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findXhhdInfoCountQy(XhhdPage page) {
		return (Integer) ibatis().queryForObject("xhhd.findXhhdInfoCountQy", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhhds&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Xhhd> findXhhdInfoListQy(XhhdPage page) {
		return (List<Xhhd>) ibatis().queryForList("xhhd.findXhhdInfoListQy", page);
	}

	/**
	 * 插入一条类别详细信息至类别详细表
	 * 
	 * @param xhhd
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoXhhd(Xhhd xhhd) {
		return (Long) ibatis().insert("xhhd.insertIntoXhhd", xhhd);
	}

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param xhhd
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updateXhhdInfoById(Xhhd xhhd) {
		return (Integer) ibatis().update("xhhd.updateXhhdInfoById", xhhd);
	}

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param xhhdId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deleteXhhdInfoById(Long xhhdId) {
		return (Integer) ibatis().update("xhhd.deleteXhhdInfoById", xhhdId);
	}

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param xhhdId
	 * @return Xhhd
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Xhhd getXhhdInfo(long xhhdId) {
		return (Xhhd) ibatis().queryForObject("xhhd.getXhhdInfo", xhhdId);
	}

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhhds&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Xhhd> findXhhdInfoListById(XhhdPage page) {
		return (List<Xhhd>) ibatis().queryForList("xhhd.findXhhdSortInfoList", page);
	}

	/**
	 * 推荐活动（协会活动）接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public Integer findXhhdInfoCountByHome(XhhdPage page) {
		return (Integer) ibatis().queryForObject("xhhd.findXhhdInfoCountByHome", page);
	}

	/**
	 * 推荐活动（协会活动）接口
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
	public List<Xhhd> findXhhdInfoListByHome(XhhdPage page) {
		return (List<Xhhd>) ibatis().queryForList("xhhd.findXhhdInfoListByHome", page);
	}

	/**
	 * 根据LOGIN_ID查询协会的协会活动列表接口
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
	public List<Xhhd> getXhhdInfoListByLoginId(String loginId) {
		return (List<Xhhd>) ibatis().queryForList("xhhd.getXhhdInfoListByLoginId", loginId);
	}
	
	/**
	 * 根据LOGIN_ID查询协会的协会活动列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@SuppressWarnings("unchecked")
	public List<Xhhd> getXhhdInfoListAll() {
		return (List<Xhhd>) ibatis().queryForList("xhhd.getXhhdInfoListAll");
	}
}