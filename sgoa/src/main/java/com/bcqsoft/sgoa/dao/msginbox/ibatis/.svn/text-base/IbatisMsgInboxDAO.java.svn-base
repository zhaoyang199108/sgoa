package com.bcqsoft.sgoa.dao.msginbox.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.msginbox.MsgInboxDAO;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInbox;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInboxPage;

/**
 * 收件箱表表数据库访问DAO实现类
 * 
 * <pre>
 * 表: SCOA_TB_ADDRESS_BOOK
 * </pre>
 */
@Repository
public class IbatisMsgInboxDAO extends BaseDAO implements MsgInboxDAO {
	/**
	 * 根据查询条件查询符合条件的收件箱(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-16
	 */
	public Integer findMsgInboxInfoCount(MsgInboxPage page) {

		return (Integer) ibatis().queryForObject("msgInbox.findMsgInboxInfoCount", page);
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
	public List<MsgInbox> findMsgInboxInfoList(MsgInboxPage page) {

		return (List<MsgInbox>) ibatis().queryForList("msgInbox.findMsgInboxInfoList", page);
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
	public Long insertIntoMsgInbox(MsgInbox addressbook) {
		
		return (Long)ibatis().insert("msgInbox.insertIntoMsgInbox", addressbook);
	}

	/**
	 * 根据ID查询收件箱的详细信息
	 * 
	 * @param id
	 * @return msgInbox
	 * 
	 * @author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	public MsgInbox selectMsgInboxById(long id) {

		return (MsgInbox) ibatis().queryForObject("msgInbox.selectMsgInboxById", id);
	}

	/**
	 * 根据ID更新某条收件箱信息
	 * 
	 * @param msgInbox
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	public Integer updateMsgInboxInfoById(MsgInbox msgInbox) {

		return (Integer) ibatis().update("msgInbox.updateMsgInboxInfoById", msgInbox);
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
	public Integer updateMsgInboxStatusToDisabled(long id) {

		return (Integer) ibatis().update("msgInbox.updateMsgInboxStatusToDisabled", id);
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
	public Integer findDustbinInfoCount(MsgInboxPage msgInboxPage) {
		return (Integer) ibatis().queryForObject("msgInbox.findDustbinInfoCount", msgInboxPage);
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
	public List<MsgInbox> findDustbinInfoList(MsgInboxPage msgInboxPage) {
		return (List<MsgInbox>) ibatis().queryForList("msgInbox.findDustbinInfoList", msgInboxPage);
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
	public Integer updateMsgInboxById(long id) {
		return (Integer) ibatis().update("msgInbox.updateMsgInboxById", id);
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
	public List<MsgInbox> findUnreadMessageByUserId(String userId) {
		return (List<MsgInbox>) ibatis().queryForList("msgInbox.findUnreadMessageByUserId", userId);
	}

}
