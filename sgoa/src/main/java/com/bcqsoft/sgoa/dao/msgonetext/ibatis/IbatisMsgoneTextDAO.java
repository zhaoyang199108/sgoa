package com.bcqsoft.sgoa.dao.msgonetext.ibatis;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.msgonetext.MsgoneTextDAO;
import com.bcqsoft.sgoa.dao.msgonetext.dataobject.MsgoneText;

/**
 * 站内信详细内容表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_MSG_TEXT
 * </pre>
 */
@Repository
public class IbatisMsgoneTextDAO extends BaseDAO implements MsgoneTextDAO {
	/**
	 * 写信
	 * 
	 */
	@Override
	public Long addMsgoneText(MsgoneText msgoneText) {
		return (Long) ibatis().insert("msgoneText.insterMsgoneText",msgoneText);
	}
	/**
	 * 更新内容
	 * 
	 */
	@Override
	public Integer updateMsgoneText(MsgoneText msgoneText) {
		return (Integer) ibatis().update("msgoneText.updateMsgoneTextInfoById", msgoneText);
	}
	
	@Override
	public Integer editMsgoneText(MsgoneText msgoneText) {
		return (Integer) ibatis().update("msgoneText.editMsgoneText",msgoneText);
	}

}
