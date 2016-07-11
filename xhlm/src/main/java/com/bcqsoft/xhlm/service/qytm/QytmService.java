package com.bcqsoft.xhlm.service.qytm;

import java.util.List;

import com.bcqsoft.xhlm.dao.qytm.dataobject.Qytm;
import com.bcqsoft.xhlm.dao.qytm.dataobject.QytmPage;

/**
 * 企业条目模块业务逻辑类接口
 */

public interface QytmService {
	/**
	 * 添加企业条目信息
	 * 
	 * @param qytm
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	boolean createQytm(Qytm qytm);

	/**
	 * 修改企业条目信息
	 * 
	 * @param qytm
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	boolean modifyQytm(Qytm qytm);

	/**
	 * 删除企业条目信息
	 * 
	 * @param qytmId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	boolean deleteQytm(long qytmId);

	/**
	 * 删除企业条目信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	boolean deleteQytms(long[] idArray);

	/**
	 * 根据ID查找某一企业条目的信息
	 * 
	 * @param qytmId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Qytm getQytmInfo(long qytmId);

	/**
	 * 根据查询条件查找企业条目信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	QytmPage getQytmInfoList(QytmPage page);

	List<Qytm> getCagegoryList(Qytm qytm);
}
