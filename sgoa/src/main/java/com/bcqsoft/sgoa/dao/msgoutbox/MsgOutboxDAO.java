package com.bcqsoft.sgoa.dao.msgoutbox;

import java.util.List;

import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutbox;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutboxPage;

/**
 * 站内信发件箱表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_MSG_OUTBOX
 * </pre>
 */
public interface MsgOutboxDAO {
	/**
	 * 写信
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	Long addMsgOutbox(MsgOutbox msgOutbox);

	/**
	 * 根据查询条件查询符合条件的发件箱数量(页面分页使用)
	 * 
	 * @param msgOutboxPage
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	Integer findMsgInboxOutfoCount(MsgOutboxPage msgOutboxPage);

	/**
	 * 根据查询条件查询符合条件的发件箱
	 * 
	 * @param msgOutboxPage
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	List<MsgOutbox> findMsgOutboxInfoList(MsgOutboxPage msgOutboxPage);

	/**
	 * 删除一条发信(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	Integer updateMsgOutboxStatusToDisabled(long id);

	/**
	 * 根据ID查询发件箱的详细信息
	 * 
	 * @param id
	 * @return msgOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	MsgOutbox selectMsgOutboxById(long id);

	/**
	 * 发件箱更新处理
	 * 
	 * @param msgOutbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	Integer updateMsgOutboxInfoById(MsgOutbox msgOutbox);

	/**
	 * 草稿箱数量
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 * 
	 */
	Integer findDraftMsgOutboxSendCount(MsgOutboxPage msgOutboxPage);

	/**
	 * 取得草稿箱内容列表
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 * 
	 */
	List<MsgOutbox> findDraftMsgOutboxSendList(MsgOutboxPage msgOutboxPage);
	/**
	 *恢复一条发信
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	Integer updateMsgOutboxById(long id);

}
