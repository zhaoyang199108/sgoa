package com.bcqsoft.sgoa.dao.msginbox;

import java.util.List;

import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInbox;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInboxPage;

/**
 * 收件箱表表数据库访问DAO接口
 * 
 * <pre>
 * 表: SCOA_TB_ADDRESS_BOOK
 * </pre>
 */
public interface MsgInboxDAO {
	/**
	 * 根据查询条件查询符合条件的收件箱数量(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	Integer findMsgInboxInfoCount(MsgInboxPage page);

	/**
	 * 根据查询条件查询符合条件的收件箱
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	List<MsgInbox> findMsgInboxInfoList(MsgInboxPage page);

	/**
	 * 插入一条信息至收件箱表
	 * 
	 * @param MsgInbox
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */

	Long insertIntoMsgInbox(MsgInbox addressbook);

	/**
	 * 根据ID查询收件箱的详细信息
	 * 
	 * @param id
	 * @return msgInbox
	 * 
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	MsgInbox selectMsgInboxById(long id);

	/**
	 * 根据ID更新某条收件箱信息
	 * 
	 * @param msgInbox
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	Integer updateMsgInboxInfoById(MsgInbox msgInbox);

	/**
	 * 根据ID删除某条工作动态信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */

	Integer updateMsgInboxStatusToDisabled(long id);

	/**
	 * 根据查询条件查询符合条件的垃圾箱数量(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	Integer findDustbinInfoCount(MsgInboxPage msgInboxPage);

	/**
	 * 根据查询条件查询符合条件的垃圾箱
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	List<MsgInbox> findDustbinInfoList(MsgInboxPage msgInboxPage);

	/**
	 * 恢复一条发信
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	Integer updateMsgInboxById(long id);

	/**
	 * 查看未读的站内信
	 * 
	 * @param userId 当前登录ID
	 * @return 未读站内信列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-15
	 */
	List<MsgInbox> findUnreadMessageByUserId(String userId);

}
