package com.bcqsoft.sgoa.dao.messagestep.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.messagestep.MessageStepDAO;
import com.bcqsoft.sgoa.dao.messagestep.dataobject.MessageStep;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_MESSAGE_REVIEW
 * </pre>
 */
@Repository
public class IbatisMessageStepDAO extends BaseDAO implements MessageStepDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoMessageStep(MessageStep messageStep) {
		return (Long) ibatis().insert("messagestep.insertIntoMessageStep", messageStep);
	}

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@SuppressWarnings("unchecked")
	public List<MessageStep> findAllMessageStepById(Long docId) {
		return (List<MessageStep>) ibatis().queryForList("messagestep.findAllMessageStepById", docId);
	}
	/**
	 * 根据信息删除信息
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Override
	public Integer delectIntoMessageStep(MessageStep messageStepByMessage) {
		return (Integer) ibatis().delete("messagestep.delectIntoMessageStep", messageStepByMessage);

	}
	/**
	 * 根据ID信息删除信息
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Override
	public Integer delectIntoMessageStepById(Long id) {
		return (Integer) ibatis().delete("messagestep.delectIntoMessageStepById", id);

	}

}
