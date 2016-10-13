package com.bcqsoft.sgoa.dao.msgoutbox.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.msgoutbox.MsgOutboxDAO;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutbox;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutboxPage;

/**
 * 站内信发件箱表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_MSG_OUTBOX
 * </pre>
 */
@Repository
public class IbatisMsgOutboxDAO extends BaseDAO implements MsgOutboxDAO {
	/**
	 * 写信
	 * 
	 */
	@Override
	public Long addMsgOutbox(MsgOutbox msgOutbox) {
		return (Long) ibatis().insert("msgOutbox.insterMsgOutbox", msgOutbox);
	}

	/**
	 * 根据查询条件查询符合条件的发件箱数量(页面分页使用)
	 * 
	 * @param msgOutboxPage
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@Override
	public Integer findMsgInboxOutfoCount(MsgOutboxPage msgOutboxPage) {
		return (Integer) ibatis().queryForObject("msgOutbox.findMsgOutboxInfoCount", msgOutboxPage);
	}

	/**
	 * 根据查询条件查询符合条件的发件箱
	 * 
	 * @param msgOutboxPage
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MsgOutbox> findMsgOutboxInfoList(MsgOutboxPage msgOutboxPage) {
		return (List<MsgOutbox>) ibatis().queryForList("msgOutbox.findMsgOutboxInfoList", msgOutboxPage);
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
	public Integer updateMsgOutboxStatusToDisabled(long id) {
		return (Integer) ibatis().update("msgOutbox.updateMsgOutboxStatusToDisabled", id);
	}

	/**
	 * 根据ID查询发件箱的详细信息
	 * 
	 * @param id
	 * @return msgOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	@Override
	public MsgOutbox selectMsgOutboxById(long id) {
		return (MsgOutbox) ibatis().queryForObject("msgOutbox.selectMsgOutboxById", id);
	}

	/**
	 * 发件箱更新处理
	 * 
	 * @param msgOutbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@Override
	public Integer updateMsgOutboxInfoById(MsgOutbox msgOutbox) {
		return (Integer) ibatis().update("msgOutbox.updateMsgOutboxInfoById", msgOutbox);
	}

	/**
	 * 草稿箱数量
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 * 
	 */
	@Override
	public Integer findDraftMsgOutboxSendCount(MsgOutboxPage msgOutboxPage) {
		return (Integer) ibatis().queryForObject("msgOutbox.findDraftMsgOutboxCount", msgOutboxPage);
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
	public List<MsgOutbox> findDraftMsgOutboxSendList(MsgOutboxPage msgOutboxPage) {
		return (List<MsgOutbox>) ibatis().queryForList("msgOutbox.findDraftMsgOutboxList", msgOutboxPage);
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
	public Integer updateMsgOutboxById(long id) {
		return (Integer) ibatis().update("msgOutbox.updateMsgOutboxById", id);
	}

}
