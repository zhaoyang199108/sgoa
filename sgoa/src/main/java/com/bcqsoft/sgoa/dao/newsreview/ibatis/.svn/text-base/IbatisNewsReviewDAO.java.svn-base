package com.bcqsoft.sgoa.dao.newsreview.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.newsreview.NewsReviewDAO;
import com.bcqsoft.sgoa.dao.newsreview.dataobject.NewsReview;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_NEWS_REVIEW
 * </pre>
 */
@Repository
public class IbatisNewsReviewDAO extends BaseDAO implements NewsReviewDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutReview
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoNewsReview(NewsReview newsReview) {
		return (Long) ibatis().insert("newsreview.insertIntoNewsReview", newsReview);
	}

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutReview
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@SuppressWarnings("unchecked")
	public List<NewsReview> findAllNewsReviewById(Long docId) {
		return (List<NewsReview>) ibatis().queryForList("newsreview.findAllNewsReviewById", docId);
	}
	
	/**
	 * 查找通知公告审批表详细信息根据ID
	 * 
	 * @return 通知公告审批表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NewsReview> findNewsReviewList(Long id) {
		return (List<NewsReview>) ibatis().queryForList("newsreview.findNewsReviewList", id);
	}
	
	/**
	 * 查找通知公告审批表一条详细信息根据ID
	 * 
	 * @return 通知公告审批表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<NewsReview> findNewsReviewListByOne(Long id) {
		return (List<NewsReview>) ibatis().queryForList("newsreview.findNewsReviewListByOne", id);
	}

}
