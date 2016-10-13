package com.bcqsoft.sgoa.dao.news;

import java.util.List;

import com.bcqsoft.sgoa.dao.news.dataobject.News;
import com.bcqsoft.sgoa.dao.news.dataobject.NewsPage;

/**
 * 信息发布表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_NEWS
 * </pre>
 */
public interface NewsDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param News
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoNews(News news);

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMyDraftNewsCount(NewsPage newsPage);

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<News> findMyDraftNewsList(NewsPage newsPage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findApprovedNewsCount(NewsPage newsPage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<News> findApprovedNewsList(NewsPage newsPage);

	/**
	 * 根据信息ID更新该条信息记录状态为已删除
	 * 
	 * @param Long
	 *            信息ID
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	int updateNewsStatusToEnabled(Long id);

	/**
	 * 根据信息ID更新该条信息记录状态为已删除
	 * 
	 * @param Long
	 *            信息ID
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	int updateNewsStatusById(News news);

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id
	 *            信息ID
	 * @return News
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	News findNewsDetailInfoById(Long id);

	/**
	 * 根据ID更新信息
	 * 
	 * @param news
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Integer updateNewsInfoById(News news);

	/**
	 * 根据信息ID更新该条信息记录流程状态
	 * 
	 * @param news
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	int updateNewsCurrentStatusById(News news);

	/**
	 * 导入至正式表后根据ID清除临时表数据
	 * 
	 * @param docId
	 * @return 删除条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-10
	 */
	int deleteNewsInfoById(Long docId);

	/**
	 * 查找最新的信息列表
	 * 
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-2-21
	 */
	List<News> findNewestNewsList();

	/**
	 * 根据信息ID撤销该条信息记录
	 * 
	 * 
	 * @param Long
	 *            信息ID
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer updateOneNewsInfo(Long id);

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findNewsReviewCount(NewsPage newsPage);

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<News> findNewsReviewList(NewsPage newsPage);

	/**
	 * 根据条件查找该用户经我审核的信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer getMyNewsReviewCount(NewsPage newsPage);

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findNewsReviewCountForIndex(NewsPage newsPage);

	/**
	 * 根据条件查找该用户经我审核的信息集合
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<News> getMyNewsReviewList(NewsPage newsPage);

	/**
	 * 通知公告表审批修改
	 * 
	 * @param from
	 * @param map
	 * @return 通知公告表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	Integer updateNewsById(News news);

	/**
	 * 通知查询信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findNewsSeacheCount(NewsPage outPage);

	/**
	 * 通知查询信息列表
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<News> findNewsSeacheList(NewsPage outPage);
}