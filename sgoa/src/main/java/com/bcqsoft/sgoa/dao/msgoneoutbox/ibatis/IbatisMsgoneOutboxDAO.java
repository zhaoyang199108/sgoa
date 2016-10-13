package com.bcqsoft.sgoa.dao.msgoneoutbox.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.msgoneoutbox.MsgoneOutboxDAO;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutbox;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutboxPage;

/**
 * 站内信发件箱表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_MSG_OUTBOX
 * </pre>
 */
@Repository
public class IbatisMsgoneOutboxDAO extends BaseDAO implements MsgoneOutboxDAO {
	/**
	 * 写信
	 * 
	 */
	@Override
	public Long addMsgoneOutbox(MsgoneOutbox msgoneOutbox) {
		return (Long) ibatis().insert("msgoneOutbox.insterMsgoneOutbox", msgoneOutbox);
	}

	/**
	 * 根据查询条件查询符合条件的发件箱数量(页面分页使用)
	 * 
	 * @param msgoneOutboxPage
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@Override
	public Integer findMsgoneInboxOutfoCount(MsgoneOutboxPage msgoneOutboxPage) {
		return (Integer) ibatis().queryForObject("msgoneOutbox.findMsgoneOutboxInfoCount", msgoneOutboxPage);
	}

	/**
	 * 根据查询条件查询符合条件的发件箱
	 * 
	 * @param msgoneOutboxPage
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MsgoneOutbox> findMsgoneOutboxInfoList(MsgoneOutboxPage msgoneOutboxPage) {
		return (List<MsgoneOutbox>) ibatis().queryForList("msgoneOutbox.findMsgoneOutboxInfoList", msgoneOutboxPage);
	}

	/**
	 * 删除一条发信(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@Override
	public Integer updateMsgoneOutboxStatusToDisabled(long id) {
		return (Integer) ibatis().update("msgoneOutbox.updateMsgoneOutboxStatusToDisabled", id);
	}

	/**
	 * 根据ID查询发件箱的详细信息
	 * 
	 * @param id
	 * @return msgoneOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	@Override
	public MsgoneOutbox selectMsgoneOutboxById(long id) {
		return (MsgoneOutbox) ibatis().queryForObject("msgoneOutbox.selectMsgoneOutboxById", id);
	}

	/**
	 * 发件箱更新处理
	 * 
	 * @param msgoneOutbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@Override
	public Integer updateMsgoneOutboxInfoById(MsgoneOutbox msgoneOutbox) {
		return (Integer) ibatis().update("msgoneOutbox.updateMsgoneOutboxInfoById", msgoneOutbox);
	}

	/**
	 * 草稿箱数量
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 * 
	 */
	@Override
	public Integer findDraftMsgoneOutboxSendCount(MsgoneOutboxPage msgoneOutboxPage) {
		return (Integer) ibatis().queryForObject("msgoneOutbox.findDraftMsgoneOutboxCount", msgoneOutboxPage);
	}

	/**
	 * 取得草稿箱内容列表
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MsgoneOutbox> findDraftMsgoneOutboxSendList(MsgoneOutboxPage msgoneOutboxPage) {
		return (List<MsgoneOutbox>) ibatis().queryForList("msgoneOutbox.findDraftMsgoneOutboxList", msgoneOutboxPage);
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
	public Integer updateMsgoneOutboxById(long id) {
		return (Integer) ibatis().update("msgoneOutbox.updateMsgoneOutboxById", id);
	}

}
