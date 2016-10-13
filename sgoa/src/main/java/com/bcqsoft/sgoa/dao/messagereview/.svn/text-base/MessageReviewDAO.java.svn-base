package com.bcqsoft.sgoa.dao.messagereview;

import java.util.List;

import com.bcqsoft.sgoa.dao.messagereview.dataobject.MessageReview;

/**
 * 信息发布审核表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_MESSAGE_REVIEW
 * </pre>
 */
public interface MessageReviewDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutReview
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoMessageReview(MessageReview messageReview);

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutReview
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<MessageReview> findAllMessageReviewById(Long docId);

	/**
	 * 查找通知公告审批表详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	List<MessageReview> findMessageReviewList(Long id);
	
	/**
	 * 查找通知公告审批表一条详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	List<MessageReview> findMessageReviewListByOne(Long id);

}
