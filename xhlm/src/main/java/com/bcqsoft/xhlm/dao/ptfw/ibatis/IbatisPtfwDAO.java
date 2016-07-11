package com.bcqsoft.xhlm.dao.ptfw.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.ptfw.PtfwDAO;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.Ptfw;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.PtfwPage;

@Repository
/**
 *类别详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisPtfwDAO extends BaseDAO implements PtfwDAO {
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findPtfwInfoCount(PtfwPage page) {
		return (Integer) ibatis().queryForObject("ptfw.findPtfwInfoCount", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Ptfws&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Ptfw> findPtfwInfoList(PtfwPage page) {
		return (List<Ptfw>) ibatis().queryForList("ptfw.findPtfwInfoList", page);
	}

	/**
	 * 插入一条类别详细信息至类别详细表
	 * 
	 * @param ptfw
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoPtfw(Ptfw ptfw) {
		return (Long) ibatis().insert("ptfw.insertIntoPtfw", ptfw);
	}

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param ptfw
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updatePtfwInfoById(Ptfw ptfw) {
		return (Integer) ibatis().update("ptfw.updatePtfwInfoById", ptfw);
	}

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param ptfwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deletePtfwInfoById(Long ptfwId) {
		return (Integer) ibatis().update("ptfw.deletePtfwInfoById", ptfwId);
	}

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param ptfwId
	 * @return Ptfw
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Ptfw getPtfwInfo(long ptfwId) {
		return (Ptfw) ibatis().queryForObject("ptfw.getPtfwInfo", ptfwId);
	}

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Ptfws&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Ptfw> findPtfwInfoListById(PtfwPage page) {
		return (List<Ptfw>) ibatis().queryForList("ptfw.findPtfwSortInfoList", page);
	}

	/**
	 * 根据LOGIN_ID查询协会的协会服务列表接口
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
	public List<Ptfw> getPtfwInfoListByLoginId(String loginId) {
		return (List<Ptfw>) ibatis().queryForList("ptfw.getPtfwInfoListByLoginId", loginId);
	}
}