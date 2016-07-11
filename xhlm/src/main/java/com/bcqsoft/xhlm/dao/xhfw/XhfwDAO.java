package com.bcqsoft.xhlm.dao.xhfw;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhfw.dataobject.Xhfw;
import com.bcqsoft.xhlm.dao.xhfw.dataobject.XhfwPage;

/**
 * 类别详细数据库访问层Ibatis接口
 */
public interface XhfwDAO {

	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	Integer findXhfwInfoCount(XhfwPage page);

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	List<Xhfw> findXhfwInfoList(XhfwPage page);
	
	/**
	 * 查找类别详细列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	Integer findXhfwInfoCountQy(XhfwPage page);

	/**
	 * 查找类别详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfws&gt;
	 */
	List<Xhfw> findXhfwInfoListQy(XhfwPage page);

	/**
	 * 插入一条类别详细信息至类别详细表(SCOA_TB_NEWS)
	 * 
	 * @param xhfw
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoXhfw(Xhfw xhfw);

	/**
	 * 根据类别详细ID更新类别详细表信息
	 * 
	 * @param xhfw
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer updateXhfwInfoById(Xhfw xhfw);

	/**
	 * 根据类别详细ID删除类别详细表信息
	 * 
	 * @param xhfwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer deleteXhfwInfoById(Long xhfwId);

	/**
	 * 根据类别详细ID查询类别详细表信息
	 * 
	 * @param xhfwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Xhfw getXhfwInfo(long xhfwId);

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhfw&gt;
	 */
	List<Xhfw> findXhfwInfoListById(XhfwPage page);

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