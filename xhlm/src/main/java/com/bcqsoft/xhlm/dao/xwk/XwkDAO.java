package com.bcqsoft.xhlm.dao.xwk;

import java.util.List;

import com.bcqsoft.xhlm.dao.xwk.dataobject.Xwk;
import com.bcqsoft.xhlm.dao.xwk.dataobject.XwkPage;

/**
 * 新闻库数据库访问层Ibatis接口
 */
public interface XwkDAO {

	/**
	 * 查找新闻库列表数量
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xwks&gt;
	 */
	Integer findXwkInfoCount(XwkPage page);

	/**
	 * 查找新闻库列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xwks&gt;
	 */
	List<Xwk> findXwkInfoList(XwkPage page);

	/**
	 * 插入一条新闻库信息至新闻库表(SCOA_TB_NEWS)
	 * 
	 * @param xwk
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Long insertIntoXwk(Xwk xwk);

	/**
	 * 根据新闻库ID更新新闻库表信息
	 * 
	 * @param xwk
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer updateXwkInfoById(Xwk xwk);

	/**
	 * 根据新闻库ID删除新闻库表信息
	 * 
	 * @param xwkId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Integer deleteXwkInfoById(Long xwkId);

	/**
	 * 根据新闻库ID查询新闻库表信息
	 * 
	 * @param xwkId
	 * @return 更新是否成功
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	Xwk getXwkInfo(long xwkId);

	/**
	 * 根据sortId查找类别分类详细列表
	 * 
	 * @author lzn
	 * @date 2016-01-20
	 * @return List&lt;Xwk&gt;
	 */
	List<Xwk> findXwkInfoListById(XwkPage page);
}