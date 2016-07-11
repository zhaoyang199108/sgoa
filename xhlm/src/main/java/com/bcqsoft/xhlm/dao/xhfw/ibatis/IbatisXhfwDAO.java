package com.bcqsoft.xhlm.dao.xhfw.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.xhfw.XhfwDAO;
import com.bcqsoft.xhlm.dao.xhfw.dataobject.Xhfw;
import com.bcqsoft.xhlm.dao.xhfw.dataobject.XhfwPage;

@Repository
/**
 *类别详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisXhfwDAO extends BaseDAO implements XhfwDAO {
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findXhfwInfoCount(XhfwPage page) {
		return (Integer) ibatis().queryForObject("xhfw.findXhfwInfoCount", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Xhfw> findXhfwInfoList(XhfwPage page) {
		return (List<Xhfw>) ibatis().queryForList("xhfw.findXhfwInfoList", page);
	}
	
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findXhfwInfoCountQy(XhfwPage page) {
		return (Integer) ibatis().queryForObject("xhfw.findXhfwInfoCountQy", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Xhfw> findXhfwInfoListQy(XhfwPage page) {
		return (List<Xhfw>) ibatis().queryForList("xhfw.findXhfwInfoListQy", page);
	}

	/**
	 * 插入一条类别详细信息至类别详细表
	 * 
	 * @param xhfw
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoXhfw(Xhfw xhfw) {
		return (Long) ibatis().insert("xhfw.insertIntoXhfw", xhfw);
	}

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param xhfw
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updateXhfwInfoById(Xhfw xhfw) {
		return (Integer) ibatis().update("xhfw.updateXhfwInfoById", xhfw);
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
	public Integer deleteXhfwInfoById(Long xhfwId) {
		return (Integer) ibatis().update("xhfw.deleteXhfwInfoById", xhfwId);
	}

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param xhfwId
	 * @return Xhfw
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Xhfw getXhfwInfo(long xhfwId) {
		return (Xhfw) ibatis().queryForObject("xhfw.getXhfwInfo", xhfwId);
	}

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Xhfw> findXhfwInfoListById(XhfwPage page) {
		return (List<Xhfw>) ibatis().queryForList("xhfw.findXhfwSortInfoList", page);
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
	public List<Xhfw> getXhfwInfoListByLoginId(String loginId) {
		return (List<Xhfw>) ibatis().queryForList("xhfw.getXhfwInfoListByLoginId", loginId);
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
	public List<Xhfw> getXhfwInfoListAll(){
		return (List<Xhfw>) ibatis().queryForList("xhfw.getXhfwInfoListAll");
	}
}