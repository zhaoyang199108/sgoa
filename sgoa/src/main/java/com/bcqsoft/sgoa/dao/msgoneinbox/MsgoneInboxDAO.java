package com.bcqsoft.sgoa.dao.msgoneinbox;

import java.util.List;

import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInbox;
import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInboxPage;

/**
 * 收件箱表表数据库访问DAO接口
 * 
 * <pre>
 * 表: SCOA_TB_ADDRESS_BOOK
 * </pre>
 */
public interface MsgoneInboxDAO {
	/**
	 * 根据查询条件查询符合条件的收件箱数量(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	Integer findMsgoneInboxInfoCount(MsgoneInboxPage page);

	/**
	 * 根据查询条件查询符合条件的收件箱
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	List<MsgoneInbox> findMsgoneInboxInfoList(MsgoneInboxPage page);

	/**
	 * 插入一条信息至收件箱表
	 * 
	 * @param MsgoneInbox
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */

	Long insertIntoMsgoneInbox(MsgoneInbox addressbook);

	/**
	 * 根据ID查询收件箱的详细信息
	 * 
	 * @param id
	 * @return msgoneInbox
	 * 
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	MsgoneInbox selectMsgoneInboxById(long id);

	/**
	 * 根据ID更新某条收件箱信息
	 * 
	 * @param msgoneInbox
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	Integer updateMsgoneInboxInfoById(MsgoneInbox msgoneInbox);

	/**
	 * 根据ID删除某条工作动态信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */

	Integer updateMsgoneInboxStatusToDisabled(long id);

	/**
	 * 根据查询条件查询符合条件的垃圾箱数量(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	Integer findDustbinInfoCount(MsgoneInboxPage msgoneInboxPage);

	/**
	 * 根据查询条件查询符合条件的垃圾箱
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	List<MsgoneInbox> findDustbinInfoList(MsgoneInboxPage msgoneInboxPage);

	/**
	 * 恢复一条发信
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	Integer updateMsgoneInboxById(long id);

	/**
	 * 查看未读的站内信
	 * 
	 * @param userId 当前登录ID
	 * @return 未读站内信列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-15
	 */
	List<MsgoneInbox> findUnreadMessageByUserId(String userId);

}
