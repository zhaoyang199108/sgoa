package com.bcqsoft.xhlm.service.xhxw;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhxw.dataobject.Xhxw;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.XhxwPage;


/**
 * 类别详细模块业务逻辑类接口
 */
public interface XhxwService {
	
	/**
	 * 添加类别详细信息
	 * 
	 * @param xhxw
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean createXhxw(Xhxw xhxw);

	/**
	 * 修改类别详细信息
	 * 
	 * @param xhxw
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean modifyXhxw(Xhxw xhxw);

	/**
	 * 删除类别详细信息
	 * 
	 * @param xhxwId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXhxw(long xhxwId);

	/**
	 * 删除类别详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXhxws(long[] idArray);

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param xhxwId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Xhxw getXhxwInfo(long xhxwId);

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XhxwPage getXhxwInfoList(XhxwPage page);

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XhxwPage getAllXhxwForList(XhxwPage page);

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
	XhxwPage getXhxwInfoListByHome(XhxwPage page);

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
	List<Xhxw> getXhxwInfoListByLoginId(String loginId);
}