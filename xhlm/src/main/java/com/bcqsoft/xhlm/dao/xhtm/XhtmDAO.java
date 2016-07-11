package com.bcqsoft.xhlm.dao.xhtm;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhtm.dataobject.Xhtm;
import com.bcqsoft.xhlm.dao.xhtm.dataobject.XhtmPage;

/**
 * 协会条目数据库访问层Ibatis接口
 * 
 */
public interface XhtmDAO {
	
	/**
	 * 查找协会条目列表数量
	 * 
	 * @author cql2109
	 * @date 2013-9-12
	 * @return List&lt;Xhtms&gt;
	 */
	Integer findXhtmInfoCount(XhtmPage page);

	/**
	 * 查找协会条目列表
	 * 
	 * @author cql2109
	 * @date 2013-9-12
	 * @return List&lt;Xhtms&gt;
	 */
	List<Xhtm> findXhtmInfoList(XhtmPage page);
	
	/**
	 * 插入一条协会条目信息至协会条目表(SCZY_TB_USER)
	 * 
	 * @param xhtm
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Long insertIntoXhtm(Xhtm xhtm);

	/**
	 * 根据协会条目ID更新协会条目表信息
	 * 
	 * @param xhtm
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Integer updateXhtmInfoById(Xhtm xhtm);
	
	/**
	 * 根据协会条目ID删除协会条目表信息
	 * 
	 * @param xhtmId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Integer deleteXhtmInfoById(Long xhtmId);
	
	/**
	 * 根据协会条目ID查询协会条目表信息
	 * 
	 * @param xhtmId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Xhtm getXhtmInfo(long xhtmId);

	List<Xhtm> getCagegoryList(Xhtm xhtm);
	
}
