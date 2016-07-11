package com.bcqsoft.xhlm.dao.xhhd;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhhd.dataobject.Xhhd;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.XhhdPage;

/**
 * 类别详细数据库访问层Ibatis接口
 */
public interface XhhdDAO {

	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhhds&gt;
	 */
	Integer findXhhdInfoCount(XhhdPage page);

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhhds&gt;
	 */
	List<Xhhd> findXhhdInfoList(XhhdPage page);
	
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhhds&gt;
	 */
	Integer findXhhdInfoCountQy(XhhdPage page);

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhhds&gt;
	 */
	List<Xhhd> findXhhdInfoListQy(XhhdPage page);

	/**
	 * 插入一条类别详细信息至类别详细表(SCOA_TB_NEWS)
	 * 
	 * @param xhhd
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoXhhd(Xhhd xhhd);

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param xhhd
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer updateXhhdInfoById(Xhhd xhhd);

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param xhhdId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer deleteXhhdInfoById(Long xhhdId);

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param xhhdId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Xhhd getXhhdInfo(long xhhdId);

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhhd&gt;
	 */
	List<Xhhd> findXhhdInfoListById(XhhdPage page);

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
	Integer findXhhdInfoCountByHome(XhhdPage page);

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
	List<Xhhd> findXhhdInfoListByHome(XhhdPage page);

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