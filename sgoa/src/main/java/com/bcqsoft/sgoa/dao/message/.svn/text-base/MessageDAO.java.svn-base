package com.bcqsoft.sgoa.dao.message;

import java.util.List;

import com.bcqsoft.sgoa.dao.message.dataobject.Message;
import com.bcqsoft.sgoa.dao.message.dataobject.MessagePage;

/**
 * 信息发布表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_MESSAGE
 * </pre>
 */
public interface MessageDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param Message
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoMessage(Message message);

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMyDraftMessageCount(MessagePage messagePage);

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Message> findMyDraftMessageList(MessagePage messagePage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findApprovedMessageCount(MessagePage messagePage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Message> findApprovedMessageList(MessagePage messagePage);

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
	int updateMessageStatusToEnabled(Long id);
	
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
	int updateMessageStatusById(Message message);

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id
	 *            信息ID
	 * @return Message
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Message findMessageDetailInfoById(Long id);

	/**
	 * 根据ID更新信息
	 * 
	 * @param message
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Integer updateMessageInfoById(Message message);

	/**
	 * 根据信息ID更新该条信息记录流程状态
	 * 
	 * @param message
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	int updateMessageCurrentStatusById(Message message);

	/**
	 * 导入至正式表后根据ID清除临时表数据
	 * 
	 * @param docId
	 * @return 删除条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-10
	 */
	int deleteMessageInfoById(Long docId);

	/**
	 * 查找最新的信息列表
	 * 
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-2-21
	 */
	List<Message> findNewestMessageList();

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
	Integer updateOneMessageInfo(Long id);

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMessageReviewCount(MessagePage messagePage);

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Message> findMessageReviewList(MessagePage messagePage);

	/**
	 * 根据条件查找该用户经我审核的信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer getMyMessageReviewCount(MessagePage messagePage);
	
	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMessageReviewCountForIndex(MessagePage messagePage);

	/**
	 * 根据条件查找该用户经我审核的信息集合
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Message> getMyMessageReviewList(MessagePage messagePage);

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
	Integer updateMessageById(Message message);

	/**
	 * 通知查询信息数量
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMessageSeacheCount(MessagePage outPage);

	/**
	 * 通知查询信息列表
	 * 
	 * @param message
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Message> findMessageSeacheList(MessagePage outPage);
}
