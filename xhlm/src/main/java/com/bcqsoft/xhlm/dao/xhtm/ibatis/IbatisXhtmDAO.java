package com.bcqsoft.xhlm.dao.xhtm.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.xhlm.core.base.BaseDAO;
import com.bcqsoft.xhlm.dao.xhtm.XhtmDAO;
import com.bcqsoft.xhlm.dao.xhtm.dataobject.Xhtm;
import com.bcqsoft.xhlm.dao.xhtm.dataobject.XhtmPage;

@Repository
/**
 *协会条目数据库访问层Ibatis实现类
 * 
 */
public class IbatisXhtmDAO extends BaseDAO implements XhtmDAO {
	/**
	 * 查找协会条目列表数量
	 * 
	 * @author cql2109
	 * @date 2013-9-12
	 * @return List&lt;Xhtms&gt;
	 */
	public Integer findXhtmInfoCount(XhtmPage page) {
		return (Integer) ibatis().queryForObject("xhtm.findXhtmInfoCount", page);
	}

	/**
	 * 查找协会条目列表
	 * 
	 * @author cql2109
	 * @date 2013-9-12
	 * @return List&lt;Xhtms&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Xhtm> findXhtmInfoList(XhtmPage page) {
		return (List<Xhtm>) ibatis().queryForList("xhtm.findXhtmInfoList", page);
	}

	/**
	 * 插入一条协会条目信息至协会条目表(SCZY_TB_USER)
	 * 
	 * @param xhtm
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Long insertIntoXhtm(Xhtm xhtm) {
		return (Long) ibatis().insert("xhtm.insertIntoXhtm", xhtm);
	}

	/**
	 * 根据协会条目ID更新协会条目表信息
	 * 
	 * @param xhtm
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Integer updateXhtmInfoById(Xhtm xhtm) {
		return (Integer) ibatis().update("xhtm.updateXhtmInfoById", xhtm);
	}

	/**
	 * 根据协会条目ID删除协会条目表信息
	 * 
	 * @param xhtmId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Integer deleteXhtmInfoById(Long xhtmId) {
		return (Integer) ibatis().update("xhtm.deleteXhtmInfoById", xhtmId);
	}

	/**
	 * 根据协会条目ID查询协会条目表信息
	 * 
	 * @param xhtmId
	 * @return Xhtm
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	public Xhtm getXhtmInfo(long xhtmId) {
		return (Xhtm) ibatis().queryForObject("xhtm.getXhtmInfo", xhtmId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Xhtm> getCagegoryList(Xhtm xhtm) {
		return (List<Xhtm>) ibatis().queryForList("xhtm.getXhtmList", xhtm);
	}

}
