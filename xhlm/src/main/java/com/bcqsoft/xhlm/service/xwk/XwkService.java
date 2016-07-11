package com.bcqsoft.xhlm.service.xwk;

import com.bcqsoft.xhlm.dao.xwk.dataobject.Xwk;
import com.bcqsoft.xhlm.dao.xwk.dataobject.XwkPage;


/**
 * 类别详细模块业务逻辑类接口
 */
public interface XwkService {
	
	/**
	 * 添加类别详细信息
	 * 
	 * @param xwk
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean createXwk(Xwk xwk);

	/**
	 * 修改类别详细信息
	 * 
	 * @param xwk
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean modifyXwk(Xwk xwk);

	/**
	 * 删除类别详细信息
	 * 
	 * @param xwkId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXwk(long xwkId);

	/**
	 * 删除类别详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deleteXwks(long[] idArray);

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param xwkId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Xwk getXwkInfo(long xwkId);

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XwkPage getXwkInfoList(XwkPage page);

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	XwkPage getAllXwkForList(XwkPage page);
}