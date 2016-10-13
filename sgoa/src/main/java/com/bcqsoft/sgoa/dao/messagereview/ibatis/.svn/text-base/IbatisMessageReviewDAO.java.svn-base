package com.bcqsoft.sgoa.dao.messagereview.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.messagereview.MessageReviewDAO;
import com.bcqsoft.sgoa.dao.messagereview.dataobject.MessageReview;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_MESSAGE_REVIEW
 * </pre>
 */
@Repository
public class IbatisMessageReviewDAO extends BaseDAO implements MessageReviewDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutReview
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoMessageReview(MessageReview messageReview) {
		return (Long) ibatis().insert("messagereview.insertIntoMessageReview", messageReview);
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
	public List<MessageReview> findAllMessageReviewById(Long docId) {
		return (List<MessageReview>) ibatis().queryForList("messagereview.findAllMessageReviewById", docId);
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
	public List<MessageReview> findMessageReviewList(Long id) {
		return (List<MessageReview>) ibatis().queryForList("messagereview.findMessageReviewList", id);
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
	public List<MessageReview> findMessageReviewListByOne(Long id) {
		return (List<MessageReview>) ibatis().queryForList("messagereview.findMessageReviewListByOne", id);
	}

}
