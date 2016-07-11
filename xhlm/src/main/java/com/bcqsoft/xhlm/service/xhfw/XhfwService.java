package com.bcqsoft.xhlm.service.xhfw;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhfw.dataobject.Xhfw;
import com.bcqsoft.xhlm.dao.xhfw.dataobject.XhfwPage;


/**
 * 类别详细模块业务逻辑类接口
 */
public interface XhfwService {
	
	/**
	 * 添加类别详细信息
	 * 
	 * @param xhfw
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean createXhfw(Xhfw xhfw);

	/**
	 * 修改类别详细信息
	 * 
	 * @param xhfw
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean modifyXhfw(Xhfw xhfw);

	/**
	 * 删除类别详细信息
	 * 
	 * @param xhfwId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXhfw(long xhfwId);

	/**
	 * 删除类别详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXhfws(long[] idArray);

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param xhfwId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Xhfw getXhfwInfo(long xhfwId);

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XhfwPage getXhfwInfoList(XhfwPage page);
	
	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XhfwPage getXhfwInfoListQy(XhfwPage page);

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XhfwPage getAllXhfwForList(XhfwPage page);

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
	List<Xhfw> getXhfwInfoListByLoginId(String loginId);
	
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
	List<Xhfw> getXhfwInfoListAll();
}