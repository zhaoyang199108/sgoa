package com.bcqsoft.xhlm.dao.xwk.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.xwk.XwkDAO;
import com.bcqsoft.xhlm.dao.xwk.dataobject.Xwk;
import com.bcqsoft.xhlm.dao.xwk.dataobject.XwkPage;

@Repository
/**
 *类别详细数据库访问层Ibatis实现类
 * 
 */
public class IbatisXwkDAO extends BaseDAO implements XwkDAO {
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return
	 */
	public Integer findXwkInfoCount(XwkPage page) {
		return (Integer) ibatis().queryForObject("xwk.findXwkInfoCount", page);
	}

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xwks&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Xwk> findXwkInfoList(XwkPage page) {
		return (List<Xwk>) ibatis().queryForList("xwk.findXwkInfoList", page);
	}

	/**
	 * 插入一条类别详细信息至类别详细表
	 * 
	 * @param xwk
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Long insertIntoXwk(Xwk xwk) {
		return (Long) ibatis().insert("xwk.insertIntoXwk", xwk);
	}

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param xwk
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer updateXwkInfoById(Xwk xwk) {
		return (Integer) ibatis().update("xwk.updateXwkInfoById", xwk);
	}

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param xwkId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Integer deleteXwkInfoById(Long xwkId) {
		return (Integer) ibatis().update("xwk.deleteXwkInfoById", xwkId);
	}

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param xwkId
	 * @return Xwk
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	public Xwk getXwkInfo(long xwkId) {
		return (Xwk) ibatis().queryForObject("xwk.getXwkInfo", xwkId);
	}

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xwks&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Xwk> findXwkInfoListById(XwkPage page) {
		return (List<Xwk>) ibatis().queryForList("xwk.findXwkSortInfoList", page);
	}
}