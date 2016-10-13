package com.bcqsoft.sgoa.service.message;


import java.util.List;

import com.bcqsoft.sgoa.dao.message.dataobject.Message;
import com.bcqsoft.sgoa.dao.message.dataobject.MessagePage;
import com.bcqsoft.sgoa.dao.messagehistory.dataobject.MessageHistory;
import com.bcqsoft.sgoa.dao.messagereview.dataobject.MessageReviewPage;
import com.bcqsoft.sgoa.dao.messagestep.dataobject.MessageStep;

/**
 * 信息发布模块业务逻辑类接口
 */
public interface MessageService {

	/**
	 * 添加信息草稿
	 * 
	 * @param message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addMessageDraftInfo(Message message);
	
	/**
	 * 更新信息草稿
	 * 
	 * @param message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean updateMessageDraftInfo(Message message);

	/**
	 * 添加信息数据
	 * 
	 * <pre>
	 * <li>1.将信息信息添加至信息临时表</li>
	 * <li>2.将本次提交信息添加至信息审核表</li>
	 * </pre>
	 * 
	 * @param Message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addMessageInfo(Message message);

	/**
	 * 拟稿信息页面
	 * 
	 * @param MessagePage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	MessagePage getMyDraftMessageList(MessagePage outPage);
	
	/**
	 * 我的申请页面
	 * 
	 * @param MessagePage
	 * @return 分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	MessagePage getApprovedMessageList(MessagePage outPage);
	
	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long 信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	boolean removeOneMessageInfo(Long id);

	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long 信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	boolean removeOneMessageInfo(long[] longArray);

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @return Message
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Message getUserDraftMessageDetail(Long id);

	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean updateMessageInfo(Message message);

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
	boolean updateOneMessageInfo(Long id);

	/**
	 * 查找通知公告审批表详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	MessageReviewPage getMessageReviewListById(Long id);
	
	
	/**
	 * 查找通知公告审批表一条详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	MessageReviewPage getMessageReviewListByIdOne(Long id);

	/**
	 * 待审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	MessagePage getMessageReviewList(MessagePage outPage);
	
	/**
	 * 经我审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	MessagePage getMyMessageReviewList(MessagePage outPage);

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
	boolean createMessageReview(Message message);

	/**
	 * 返回
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	List<MessageStep> getMessageStepList(Long id);

	/**
	 * 通知公告表返回
	 * 
	 * @param from
	 * @param map
	 * @return 通知公告
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	boolean createMessageReback(Message message);

	/**
	 * 跳转至历史记录页面
	 * 
	 * @return 历史记录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	List<MessageHistory> getMessageHistoryInfo(long id);
	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	MessagePage getMessageSearchList(MessagePage outPage);
	
	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean updateMessageStatusById(Message message);
	
}
