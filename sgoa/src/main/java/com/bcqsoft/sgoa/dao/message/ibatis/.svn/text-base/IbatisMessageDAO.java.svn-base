package com.bcqsoft.sgoa.dao.message.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.message.MessageDAO;
import com.bcqsoft.sgoa.dao.message.dataobject.Message;
import com.bcqsoft.sgoa.dao.message.dataobject.MessagePage;

/**
 * 信息发布表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_MESSAGE
 * </pre>
 */
@Repository
public class IbatisMessageDAO extends BaseDAO implements MessageDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param Message
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoMessage(Message message) {
		return (Long) ibatis().insert("message.insertIntoMessage", message);
	}

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findMyDraftMessageCount(MessagePage messagePage) {
		return (Integer) ibatis().queryForObject("message.findMyDraftMessageCount", messagePage);
	}

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Message> findMyDraftMessageList(MessagePage messagePage) {
		return (List<Message>) ibatis().queryForList("message.findMyDraftMessageList", messagePage);
	}


	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findApprovedMessageCount(MessagePage messagePage) {
		return (Integer) ibatis().queryForObject("message.findApprovedMessageCount", messagePage);
	}

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Message> findApprovedMessageList(MessagePage messagePage) {
		return (List<Message>) ibatis().queryForList("message.findApprovedMessageList", messagePage);
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
	public int updateMessageStatusToEnabled(Long id) {
		return ibatis().update("message.updateMessageStatusToEnabled", id);
	}

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id 信息ID
	 * @return Message
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Message findMessageDetailInfoById(Long id) {
		return (Message) ibatis().queryForObject("message.findMessageDetailInfoById", id);
	}


	/**
	 * 根据ID更新信息信息
	 * 
	 * @param message
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Integer updateMessageInfoById(Message message) {
		return ibatis().update("message.updateMessageInfoById", message);
	}

	/**
	 * 根据信息ID更新该条信息记录流程状态
	 * 
	 * @param message
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public int updateMessageCurrentStatusById(Message message) {
		return ibatis().update("message.updateMessageCurrentStatusById", message);
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
	public int deleteMessageInfoById(Long docId) {
		return ibatis().delete("message.deleteMessageInfoById", docId);
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
	public List<Message> findNewestMessageList() {
		return (List<Message>) ibatis().queryForList("message.findNewestMessageList");
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
	public Integer updateOneMessageInfo(Long id) {
		return ibatis().update("message.updateOneMessageInfo", id);
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
	public int updateMessageStatusById(Message message){
		return ibatis().update("message.updateMessageStatusById", message);
	}

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findMessageReviewCount(MessagePage messagePage) {
		return (Integer) ibatis().queryForObject("message.findMessageReviewCount", messagePage);
	}
	
	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findMessageReviewCountForIndex(MessagePage messagePage) {
		return (Integer) ibatis().queryForObject("message.findMessageReviewCountForIndex", messagePage);
	}

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> findMessageReviewList(MessagePage messagePage) {
		return (List<Message>) ibatis().queryForList("message.findMessageReviewList", messagePage);
	}
	
	/**
	 * 根据条件查找该用户经我审核的信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer getMyMessageReviewCount(MessagePage messagePage) {
		return (Integer) ibatis().queryForObject("message.getMyMessageReviewCount", messagePage);
	}

	/**
	 * 根据条件查找该用户经我审核的信息集合
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> getMyMessageReviewList(MessagePage messagePage) {
		return (List<Message>) ibatis().queryForList("message.getMyMessageReviewList", messagePage);
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
	public Integer updateMessageById(Message message) {
		return (Integer) ibatis().update("message.updateMessageById", message);
	}
	/**
	 * 通知查询信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findMessageSeacheCount(MessagePage outPage) {
		return (Integer) ibatis().queryForObject("message.findMessageSeacheCount", outPage);
	}
	/**
	 * 通知查询信息列表
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Message> findMessageSeacheList(MessagePage outPage) {
		return (List<Message>) ibatis().queryForList("message.findMessageSeacheList", outPage);
	}
}
