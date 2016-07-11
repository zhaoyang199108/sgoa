package com.bcqsoft.xhlm.service.pthd;

import java.util.List;

import com.bcqsoft.xhlm.dao.pthd.dataobject.Pthd;
import com.bcqsoft.xhlm.dao.pthd.dataobject.PthdPage;


/**
 * 类别详细模块业务逻辑类接口
 */
public interface PthdService {
	
	/**
	 * 添加类别详细信息
	 * 
	 * @param pthd
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean createPthd(Pthd pthd);

	/**
	 * 修改类别详细信息
	 * 
	 * @param pthd
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean modifyPthd(Pthd pthd);

	/**
	 * 删除类别详细信息
	 * 
	 * @param pthdId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deletePthd(long pthdId);

	/**
	 * 删除类别详细信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	boolean deletePthds(long[] idArray);

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param pthdId
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Pthd getPthdInfo(long pthdId);

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	PthdPage getPthdInfoList(PthdPage page);

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	PthdPage getAllPthdForList(PthdPage page);

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
	PthdPage getPthdInfoListByHome(PthdPage page);

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
	List<Pthd> getPthdInfoListByLoginId(String loginId);
}