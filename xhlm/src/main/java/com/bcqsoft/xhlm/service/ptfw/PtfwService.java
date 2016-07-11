package com.bcqsoft.xhlm.service.ptfw;

import java.util.List;

import com.bcqsoft.xhlm.dao.ptfw.dataobject.Ptfw;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.PtfwPage;


/**
 * 类别详细模块业务逻辑类接口
 */
public interface PtfwService {
	
	/**
	 * 添加类别详细信息
	 * 
	 * @param ptfw
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean createPtfw(Ptfw ptfw);

	/**
	 * 修改类别详细信息
	 * 
	 * @param ptfw
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean modifyPtfw(Ptfw ptfw);

	/**
	 * 删除类别详细信息
	 * 
	 * @param ptfwId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deletePtfw(long ptfwId);

	/**
	 * 删除类别详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deletePtfws(long[] idArray);

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param ptfwId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Ptfw getPtfwInfo(long ptfwId);

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	PtfwPage getPtfwInfoList(PtfwPage page);

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	PtfwPage getAllPtfwForList(PtfwPage page);

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
	List<Ptfw> getPtfwInfoListByLoginId(String loginId);
}