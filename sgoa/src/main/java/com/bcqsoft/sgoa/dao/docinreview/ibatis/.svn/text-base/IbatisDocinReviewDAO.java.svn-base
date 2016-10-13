package com.bcqsoft.sgoa.dao.docinreview.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docinreview.DocinReviewDAO;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReview;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN_REVIEW
 * </pre>
 */
@Repository
public class IbatisDocinReviewDAO extends BaseDAO implements DocinReviewDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutReview
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocinReview(DocinReview docinReview) {
		return (Long) ibatis().insert("docinreview.insertIntoDocinReview", docinReview);
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
	public List<DocinReview> findAllDocinReviewById(Long docId) {
		return (List<DocinReview>) ibatis().queryForList("docinreview.findAllDocinReviewById", docId);
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
	public List<DocinReview> findDocinReviewList(Long id) {
		return (List<DocinReview>) ibatis().queryForList("docinreview.findDocinReviewList", id);
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
	public List<DocinReview> findDocinReviewListByOne(Long id) {
		return (List<DocinReview>) ibatis().queryForList("docinreview.findDocinReviewListByOne", id);
	}

	/**
	 * 点击查看详细
	 * 
	 * @param id
	 * @param map
	 * @return 详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DocinReview> findDocinReviewListQf(Long id) {
		return (List<DocinReview>) ibatis().queryForList("docinreview.findDocinReviewListQf", id);
	}

	/**
	 * 根据步骤审核列表
	 * 
	 * @param id
	 * @param map
	 * @return 详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@SuppressWarnings("unchecked")
	public List<DocinReview> findDocinReviewListByStep(DocinReview docinReview) {
		return (List<DocinReview>) ibatis().queryForList("docinreview.findDocinReviewListByStep", docinReview);
	}

	@Override
	public Integer deleteOpinion(DocinReview docinReview) {
		return (Integer) ibatis().update("docinreview.deleteOpinion", docinReview);
	}

	@Override
	public DocinReview getDocinReviewByDocinIdByMax(Long id) {
		return (DocinReview) ibatis().queryForObject("docinreview.getDocinReviewByDocinIdByMax", id);
	}
}
