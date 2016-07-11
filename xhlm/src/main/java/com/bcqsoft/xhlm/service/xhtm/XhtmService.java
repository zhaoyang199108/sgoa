package com.bcqsoft.xhlm.service.xhtm;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhtm.dataobject.Xhtm;
import com.bcqsoft.xhlm.dao.xhtm.dataobject.XhtmPage;

/**
 * 协会条目模块业务逻辑类接口
 */

public interface XhtmService {
	/**
	 * 添加协会条目信息
	 * 
	 * @param xhtm
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	boolean createXhtm(Xhtm xhtm);

	/**
	 * 修改协会条目信息
	 * 
	 * @param xhtm
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	boolean modifyXhtm(Xhtm xhtm);

	/**
	 * 删除协会条目信息
	 * 
	 * @param xhtmId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	boolean deleteXhtm(long xhtmId);

	/**
	 * 删除协会条目信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	boolean deleteXhtms(long[] idArray);

	/**
	 * 根据ID查找某一协会条目的信息
	 * 
	 * @param xhtmId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Xhtm getXhtmInfo(long xhtmId);

	/**
	 * 根据查询条件查找协会条目信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	XhtmPage getXhtmInfoList(XhtmPage page);

	List<Xhtm> getCagegoryList(Xhtm xhtm);
}
