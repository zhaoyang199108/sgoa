package com.bcqsoft.sgoa.dao.docoutreview.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docoutreview.DocoutReviewDAO;
import com.bcqsoft.sgoa.dao.docoutreview.dataobject.DocoutReview;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT_REVIEW
 * </pre>
 */
@Repository
public class IbatisDocoutReviewDAO extends BaseDAO implements DocoutReviewDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutReview
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocoutReview(DocoutReview docoutReview) {
		return (Long) ibatis().insert("docoutreview.insertIntoDocoutReview", docoutReview);
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
	public List<DocoutReview> findAllDocoutReviewById(Long docId) {
		return (List<DocoutReview>) ibatis().queryForList("docoutreview.findAllDocoutReviewById", docId);
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
	public List<DocoutReview> findDocoutReviewList(Long id) {
		return (List<DocoutReview>) ibatis().queryForList("docoutreview.findDocoutReviewList", id);
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
	public List<DocoutReview> findDocoutReviewListByOne(Long id) {
		return (List<DocoutReview>) ibatis().queryForList("docoutreview.findDocoutReviewListByOne", id);
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
	public List<DocoutReview> findDocoutReviewListQf(Long id) {
		return (List<DocoutReview>) ibatis().queryForList("docoutreview.findDocoutReviewListQf", id);
	}

}
