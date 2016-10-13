package com.bcqsoft.sgoa.dao.news.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.news.NewsDAO;
import com.bcqsoft.sgoa.dao.news.dataobject.News;
import com.bcqsoft.sgoa.dao.news.dataobject.NewsPage;

/**
 * 信息发布表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_NEWS
 * </pre>
 */
@Repository
public class IbatisNewsDAO extends BaseDAO implements NewsDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param News
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoNews(News news) {
		return (Long) ibatis().insert("news.insertIntoNews", news);
	}

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findMyDraftNewsCount(NewsPage newsPage) {
		return (Integer) ibatis().queryForObject("news.findMyDraftNewsCount", newsPage);
	}

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<News> findMyDraftNewsList(NewsPage newsPage) {
		return (List<News>) ibatis().queryForList("news.findMyDraftNewsList", newsPage);
	}


	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findApprovedNewsCount(NewsPage newsPage) {
		return (Integer) ibatis().queryForObject("news.findApprovedNewsCount", newsPage);
	}

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<News> findApprovedNewsList(NewsPage newsPage) {
		return (List<News>) ibatis().queryForList("news.findApprovedNewsList", newsPage);
	}

	/**
	 * 根据信息ID更新该条信息记录状态为已删除
	 * 
	 * @param Long 信息ID
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public int updateNewsStatusToEnabled(Long id) {
		return ibatis().update("news.updateNewsStatusToEnabled", id);
	}

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id 信息ID
	 * @return News
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public News findNewsDetailInfoById(Long id) {
		return (News) ibatis().queryForObject("news.findNewsDetailInfoById", id);
	}


	/**
	 * 根据ID更新信息信息
	 * 
	 * @param news
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Integer updateNewsInfoById(News news) {
		return ibatis().update("news.updateNewsInfoById", news);
	}

	/**
	 * 根据信息ID更新该条信息记录流程状态
	 * 
	 * @param news
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public int updateNewsCurrentStatusById(News news) {
		return ibatis().update("news.updateNewsCurrentStatusById", news);
	}

	/**
	 * 导入至正式表后根据ID清除临时表数据
	 * 
	 * @param docId
	 * @return 删除条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-10
	 */
	public int deleteNewsInfoById(Long docId) {
		return ibatis().delete("news.deleteNewsInfoById", docId);
	}

	/**
	 * 查找最新的信息列表
	 * 
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-2-21
	 */
	@SuppressWarnings("unchecked")
	public List<News> findNewestNewsList() {
		return (List<News>) ibatis().queryForList("news.findNewestNewsList");
	}

	/**
	 * 根据信息ID撤销该条信息记录
	 * 
	 * 
	 * @param Long 信息ID
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer updateOneNewsInfo(Long id) {
		return ibatis().update("news.updateOneNewsInfo", id);
	}
	
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
	@Override
	public int updateNewsStatusById(News news){
		return ibatis().update("news.updateNewsStatusById", news);
	}

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findNewsReviewCount(NewsPage newsPage) {
		return (Integer) ibatis().queryForObject("news.findNewsReviewCount", newsPage);
	}
	
	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findNewsReviewCountForIndex(NewsPage newsPage) {
		return (Integer) ibatis().queryForObject("news.findNewsReviewCountForIndex", newsPage);
	}

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<News> findNewsReviewList(NewsPage newsPage) {
		return (List<News>) ibatis().queryForList("news.findNewsReviewList", newsPage);
	}
	
	/**
	 * 根据条件查找该用户经我审核的信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer getMyNewsReviewCount(NewsPage newsPage) {
		return (Integer) ibatis().queryForObject("news.getMyNewsReviewCount", newsPage);
	}

	/**
	 * 根据条件查找该用户经我审核的信息集合
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<News> getMyNewsReviewList(NewsPage newsPage) {
		return (List<News>) ibatis().queryForList("news.getMyNewsReviewList", newsPage);
	}

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
	@Override
	public Integer updateNewsById(News news) {
		return (Integer) ibatis().update("news.updateNewsById", news);
	}
	/**
	 * 通知查询信息数量
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findNewsSeacheCount(NewsPage outPage) {
		return (Integer) ibatis().queryForObject("news.findNewsSeacheCount", outPage);
	}
	/**
	 * 通知查询信息列表
	 * 
	 * @param news
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<News> findNewsSeacheList(NewsPage outPage) {
		return (List<News>) ibatis().queryForList("news.findNewsSeacheList", outPage);
	}
}