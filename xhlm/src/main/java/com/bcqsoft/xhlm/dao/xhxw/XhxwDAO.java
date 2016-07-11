package com.bcqsoft.xhlm.dao.xhxw;

import java.util.List;

import com.bcqsoft.xhlm.dao.xhxw.dataobject.Xhxw;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.XhxwPage;

/**
 * 新闻库数据库访问层Ibatis接口
 */
public interface XhxwDAO {

	/**
	 * 查找新闻库列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhxws&gt;
	 */
	Integer findXhxwInfoCount(XhxwPage page);

	/**
	 * 查找新闻库列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhxws&gt;
	 */
	List<Xhxw> findXhxwInfoList(XhxwPage page);

	/**
	 * 插入一条新闻库信息至新闻库表(SCOA_TB_NEWS)
	 * 
	 * @param xhxw
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoXhxw(Xhxw xhxw);

	/**
	 * 根据新闻库ID更新新闻库表信息
	 * 
	 * @param xhxw
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer updateXhxwInfoById(Xhxw xhxw);

	/**
	 * 根据新闻库ID删除新闻库表信息
	 * 
	 * @param xhxwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer deleteXhxwInfoById(Long xhxwId);

	/**
	 * 根据新闻库ID查询新闻库表信息
	 * 
	 * @param xhxwId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Xhxw getXhxwInfo(long xhxwId);

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xhxw&gt;
	 */
	List<Xhxw> findXhxwInfoListById(XhxwPage page);

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
	Integer findXhxwInfoCountByHome(XhxwPage page);

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
	List<Xhxw> findXhxwInfoListByHome(XhxwPage page);

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