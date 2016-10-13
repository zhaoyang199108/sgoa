package com.bcqsoft.sgoa.dao.msgonetext;

import com.bcqsoft.sgoa.dao.msgonetext.dataobject.MsgoneText;

/**
 * 站内信详细内容表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_MSG_TEXT
 * </pre>
 */
public interface MsgoneTextDAO {
	/**
	 * 写信
	 * 
	 */
	Long addMsgoneText(MsgoneText msgoneText);
	/**
	 * 更新内容
	 * 
	 */
	Integer updateMsgoneText(MsgoneText msgoneText);
	
	Integer editMsgoneText(MsgoneText msgoneText);

	

}
