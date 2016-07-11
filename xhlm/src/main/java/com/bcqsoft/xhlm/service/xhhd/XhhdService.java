package com.bcqsoft.xhlm.service.xhhd;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhhd.dataobject.Xhhd;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.XhhdPage;


/**
 * 类别详细模块业务逻辑类接口
 */
public interface XhhdService {
	
	/**
	 * 添加类别详细信息
	 * 
	 * @param xhhd
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean createXhhd(Xhhd xhhd);

	/**
	 * 修改类别详细信息
	 * 
	 * @param xhhd
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean modifyXhhd(Xhhd xhhd);

	/**
	 * 删除类别详细信息
	 * 
	 * @param xhhdId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXhhd(long xhhdId);

	/**
	 * 删除类别详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXhhds(long[] idArray);

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param xhhdId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Xhhd getXhhdInfo(long xhhdId);

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XhhdPage getXhhdInfoList(XhhdPage page);
	
	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XhhdPage getXhhdInfoListQy(XhhdPage page);

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XhhdPage getAllXhhdForList(XhhdPage page);

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
	XhhdPage getXhhdInfoListByHome(XhhdPage page);

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
	List<Xhhd> getXhhdInfoListByLoginId(String loginId);
	
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
	List<Xhhd> getXhhdInfoListAll();
}