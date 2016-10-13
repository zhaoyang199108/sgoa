package com.bcqsoft.sgoa.dao.messagehistory.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.messagehistory.MessageHistoryDAO;
import com.bcqsoft.sgoa.dao.messagehistory.dataobject.MessageHistory;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_MESSAGE_REVIEW
 * </pre>
 */
@Repository
public class IbatisMessageHistoryDAO extends BaseDAO implements MessageHistoryDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoMessageHistory(MessageHistory messageHistory) {
		return (Long) ibatis().insert("messagehistory.insertIntoMessageHistory", messageHistory);
	}

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@SuppressWarnings("unchecked")
	public List<MessageHistory> findAllMessageHistoryById(Long id) {
		return (List<MessageHistory>) ibatis().queryForList("messagehistory.findAllMessageHistoryById", id);
	}

}
