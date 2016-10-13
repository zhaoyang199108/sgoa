package com.bcqsoft.sgoa.dao.msgoneoutbox;

import java.util.List;

import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutbox;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutboxPage;

/**
 * 站内信发件箱表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_MSG_OUTBOX
 * </pre>
 */
public interface MsgoneOutboxDAO {
	/**
	 * 写信
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	Long addMsgoneOutbox(MsgoneOutbox msgoneOutbox);

	/**
	 * 根据查询条件查询符合条件的发件箱数量(页面分页使用)
	 * 
	 * @param msgoneOutboxPage
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	Integer findMsgoneInboxOutfoCount(MsgoneOutboxPage msgoneOutboxPage);

	/**
	 * 根据查询条件查询符合条件的发件箱
	 * 
	 * @param msgoneOutboxPage
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	List<MsgoneOutbox> findMsgoneOutboxInfoList(MsgoneOutboxPage msgoneOutboxPage);

	/**
	 * 删除一条发信(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	Integer updateMsgoneOutboxStatusToDisabled(long id);

	/**
	 * 根据ID查询发件箱的详细信息
	 * 
	 * @param id
	 * @return msgoneOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	MsgoneOutbox selectMsgoneOutboxById(long id);

	/**
	 * 发件箱更新处理
	 * 
	 * @param msgoneOutbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	Integer updateMsgoneOutboxInfoById(MsgoneOutbox msgoneOutbox);

	/**
	 * 草稿箱数量
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 * 
	 */
	Integer findDraftMsgoneOutboxSendCount(MsgoneOutboxPage msgoneOutboxPage);

	/**
	 * 取得草稿箱内容列表
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 * 
	 */
	List<MsgoneOutbox> findDraftMsgoneOutboxSendList(MsgoneOutboxPage msgoneOutboxPage);
	/**
	 *恢复一条发信
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	Integer updateMsgoneOutboxById(long id);

}
