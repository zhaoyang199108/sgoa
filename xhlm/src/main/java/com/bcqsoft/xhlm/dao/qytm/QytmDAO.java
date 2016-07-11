package com.bcqsoft.xhlm.dao.qytm;

import java.util.List;

import com.bcqsoft.xhlm.dao.qytm.dataobject.Qytm;
import com.bcqsoft.xhlm.dao.qytm.dataobject.QytmPage;

/**
 * 企业条目数据库访问层Ibatis接口
 * 
 */
public interface QytmDAO {
	
	/**
	 * 查找企业条目列表数量
	 * 
	 * @author cql2109
	 * @date 2013-9-12
	 * @return List&lt;Qytms&gt;
	 */
	Integer findQytmInfoCount(QytmPage page);

	/**
	 * 查找企业条目列表
	 * 
	 * @author cql2109
	 * @date 2013-9-12
	 * @return List&lt;Qytms&gt;
	 */
	List<Qytm> findQytmInfoList(QytmPage page);
	
	/**
	 * 插入一条企业条目信息至企业条目表(SCZY_TB_USER)
	 * 
	 * @param qytm
	 * @return 插入记录的ID
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Long insertIntoQytm(Qytm qytm);

	/**
	 * 根据企业条目ID更新企业条目表信息
	 * 
	 * @param qytm
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Integer updateQytmInfoById(Qytm qytm);
	
	/**
	 * 根据企业条目ID删除企业条目表信息
	 * 
	 * @param qytmId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Integer deleteQytmInfoById(Long qytmId);
	
	/**
	 * 根据企业条目ID查询企业条目表信息
	 * 
	 * @param qytmId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	Qytm getQytmInfo(long qytmId);

	List<Qytm> getCagegoryList(Qytm qytm);
	
}
