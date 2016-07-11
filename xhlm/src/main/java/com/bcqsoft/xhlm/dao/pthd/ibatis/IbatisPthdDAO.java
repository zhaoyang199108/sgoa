package com.bcqsoft.xhlm.dao.pthd.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.pthd.PthdDAO;
import com.bcqsoft.xhlm.dao.pthd.dataobject.Pthd;
import com.bcqsoft.xhlm.dao.pthd.dataobject.PthdPage;

@Repository
/**
 *类别详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisPthdDAO extends BaseDAO implements PthdDAO {
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findPthdInfoCount(PthdPage page) {
		return (Integer) ibatis().queryForObject("pthd.findPthdInfoCount", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Pthds&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Pthd> findPthdInfoList(PthdPage page) {
		return (List<Pthd>) ibatis().queryForList("pthd.findPthdInfoList", page);
	}

	/**
	 * 插入一条类别详细信息至类别详细表
	 * 
	 * @param pthd
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoPthd(Pthd pthd) {
		return (Long) ibatis().insert("pthd.insertIntoPthd", pthd);
	}

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param pthd
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updatePthdInfoById(Pthd pthd) {
		return (Integer) ibatis().update("pthd.updatePthdInfoById", pthd);
	}

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param pthdId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deletePthdInfoById(Long pthdId) {
		return (Integer) ibatis().update("pthd.deletePthdInfoById", pthdId);
	}

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param pthdId
	 * @return Pthd
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Pthd getPthdInfo(long pthdId) {
		return (Pthd) ibatis().queryForObject("pthd.getPthdInfo", pthdId);
	}

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Pthds&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Pthd> findPthdInfoListById(PthdPage page) {
		return (List<Pthd>) ibatis().queryForList("pthd.findPthdSortInfoList", page);
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
	public Integer findPthdInfoCountByHome(PthdPage page) {
		return (Integer) ibatis().queryForObject("pthd.findPthdInfoCountByHome", page);
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
	public List<Pthd> findPthdInfoListByHome(PthdPage page) {
		return (List<Pthd>) ibatis().queryForList("pthd.findPthdInfoListByHome", page);
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
	public List<Pthd> getPthdInfoListByLoginId(String loginId) {
		return (List<Pthd>) ibatis().queryForList("pthd.getPthdInfoListByLoginId", loginId);
	}
}