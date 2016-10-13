package com.bcqsoft.sgoa.dao.msgoneinbox.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.msgoneinbox.MsgoneInboxDAO;
import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInbox;
import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInboxPage;

/**
 * 收件箱表表数据库访问DAO实现类
 * 
 * <pre>
 * 表: SCOA_TB_ADDRESS_BOOK
 * </pre>
 */
@Repository
public class IbatisMsgoneInboxDAO extends BaseDAO implements MsgoneInboxDAO {
	/**
	 * 根据查询条件查询符合条件的收件箱(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-16
	 */
	public Integer findMsgoneInboxInfoCount(MsgoneInboxPage page) {

		return (Integer) ibatis().queryForObject("msgoneInbox.findMsgoneInboxInfoCount", page);
	}

	/**
	 * 根据查询条件查询符合条件的收件箱
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-16
	 */
	@SuppressWarnings("unchecked")
	public List<MsgoneInbox> findMsgoneInboxInfoList(MsgoneInboxPage page) {

		return (List<MsgoneInbox>) ibatis().queryForList("msgoneInbox.findMsgoneInboxInfoList", page);
	}

	/**
	 * 插入一条信息至收件箱表
	 * 
	 * @param addressbook
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoMsgoneInbox(MsgoneInbox addressbook) {
		
		return (Long)ibatis().insert("msgoneInbox.insertIntoMsgoneInbox", addressbook);
	}

	/**
	 * 根据ID查询收件箱的详细信息
	 * 
	 * @param id
	 * @return msgoneInbox
	 * 
	 * @author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	public MsgoneInbox selectMsgoneInboxById(long id) {

		return (MsgoneInbox) ibatis().queryForObject("msgoneInbox.selectMsgoneInboxById", id);
	}

	/**
	 * 根据ID更新某条收件箱信息
	 * 
	 * @param msgoneInbox
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	public Integer updateMsgoneInboxInfoById(MsgoneInbox msgoneInbox) {

		return (Integer) ibatis().update("msgoneInbox.updateMsgoneInboxInfoById", msgoneInbox);
	}

	/**
	 * 根据ID删除某条收件箱信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	public Integer updateMsgoneInboxStatusToDisabled(long id) {

		return (Integer) ibatis().update("msgoneInbox.updateMsgoneInboxStatusToDisabled", id);
	}

	/**
	 * 根据查询条件查询符合条件的垃圾箱(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-16
	 */
	@Override
	public Integer findDustbinInfoCount(MsgoneInboxPage msgoneInboxPage) {
		return (Integer) ibatis().queryForObject("msgoneInbox.findDustbinInfoCount", msgoneInboxPage);
	}

	/**
	 * 根据查询条件查询符合条件的垃圾箱
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-16
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MsgoneInbox> findDustbinInfoList(MsgoneInboxPage msgoneInboxPage) {
		return (List<MsgoneInbox>) ibatis().queryForList("msgoneInbox.findDustbinInfoList", msgoneInboxPage);
	}

	/**
	 * 恢复一条发信
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@Override
	public Integer updateMsgoneInboxById(long id) {
		return (Integer) ibatis().update("msgoneInbox.updateMsgoneInboxById", id);
	}

	/**
	 * 查看未读的站内信
	 * 
	 * @param userId 当前登录ID
	 * @return 未读站内信列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-15
	 */
	@SuppressWarnings("unchecked")
	public List<MsgoneInbox> findUnreadMessageByUserId(String userId) {
		return (List<MsgoneInbox>) ibatis().queryForList("msgoneInbox.findUnreadMessageByUserId", userId);
	}

}
