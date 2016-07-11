package com.bcqsoft.xhlm.dao.xhxw.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.xhxw.XhxwDAO;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.Xhxw;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.XhxwPage;

@Repository
/**
 *类别详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisXhxwDAO extends BaseDAO implements XhxwDAO {
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findXhxwInfoCount(XhxwPage page) {
		return (Integer) ibatis().queryForObject("xhxw.findXhxwInfoCount", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhxws&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Xhxw> findXhxwInfoList(XhxwPage page) {
		return (List<Xhxw>) ibatis().queryForList("xhxw.findXhxwInfoList", page);
	}

	/**
	 * 插入一条类别详细信息至类别详细表
	 * 
	 * @param xhxw
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoXhxw(Xhxw xhxw) {
		return (Long) ibatis().insert("xhxw.insertIntoXhxw", xhxw);
	}

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param xhxw
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updateXhxwInfoById(Xhxw xhxw) {
		return (Integer) ibatis().update("xhxw.updateXhxwInfoById", xhxw);
	}

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param xhxwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deleteXhxwInfoById(Long xhxwId) {
		return (Integer) ibatis().update("xhxw.deleteXhxwInfoById", xhxwId);
	}

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param xhxwId
	 * @return Xhxw
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Xhxw getXhxwInfo(long xhxwId) {
		return (Xhxw) ibatis().queryForObject("xhxw.getXhxwInfo", xhxwId);
	}

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhxws&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Xhxw> findXhxwInfoListById(XhxwPage page) {
		return (List<Xhxw>) ibatis().queryForList("xhxw.findXhxwSortInfoList", page);
	}

	/**
	 * 行业新闻（协会新闻）接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@Override
	public Integer findXhxwInfoCountByHome(XhxwPage page) {
		return (Integer) ibatis().queryForObject("xhxw.findXhxwInfoCountByHome", page);
	}

	/**
	 * 行业新闻（协会新闻）接口
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
	public List<Xhxw> findXhxwInfoListByHome(XhxwPage page) {
		return (List<Xhxw>) ibatis().queryForList("xhxw.findXhxwInfoListByHome", page);
	}

	/**
	 * 根据LOGIN_ID查询协会的行业新闻列表接口
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
	public List<Xhxw> getXhxwInfoListByLoginId(String loginId) {
		return (List<Xhxw>) ibatis().queryForList("xhxw.getXhxwInfoListByLoginId", loginId);
	}
}