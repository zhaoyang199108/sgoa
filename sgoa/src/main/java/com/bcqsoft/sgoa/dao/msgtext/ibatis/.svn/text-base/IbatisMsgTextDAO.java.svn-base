package com.bcqsoft.sgoa.dao.msgtext.ibatis;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.msgtext.MsgTextDAO;
import com.bcqsoft.sgoa.dao.msgtext.dataobject.MsgText;

/**
 * 站内信详细内容表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_MSG_TEXT
 * </pre>
 */
@Repository
public class IbatisMsgTextDAO extends BaseDAO implements MsgTextDAO {
	/**
	 * 写信
	 * 
	 */
	@Override
	public Long addMsgText(MsgText msgText) {
		return (Long) ibatis().insert("msgText.insterMsgText",msgText);
	}
	/**
	 * 更新内容
	 * 
	 */
	@Override
	public Integer updateMsgText(MsgText msgText) {
		return (Integer) ibatis().update("msgText.updateMsgTextInfoById", msgText);
	}

}
