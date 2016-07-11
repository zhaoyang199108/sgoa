package com.bcqsoft.xhlm.dao.pthd;

import java.util.List;

import com.bcqsoft.xhlm.dao.pthd.dataobject.Pthd;
import com.bcqsoft.xhlm.dao.pthd.dataobject.PthdPage;

/**
 * 类别详细数据库访问层Ibatis接口
 */
public interface PthdDAO {

	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Pthds&gt;
	 */
	Integer findPthdInfoCount(PthdPage page);

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Pthds&gt;
	 */
	List<Pthd> findPthdInfoList(PthdPage page);

	/**
	 * 插入一条类别详细信息至类别详细表(SCOA_TB_NEWS)
	 * 
	 * @param pthd
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoPthd(Pthd pthd);

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param pthd
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer updatePthdInfoById(Pthd pthd);

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param pthdId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer deletePthdInfoById(Long pthdId);

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param pthdId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Pthd getPthdInfo(long pthdId);

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Pthd&gt;
	 */
	List<Pthd> findPthdInfoListById(PthdPage page);

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
	Integer findPthdInfoCountByHome(PthdPage page);

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
	List<Pthd> findPthdInfoListByHome(PthdPage page);

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