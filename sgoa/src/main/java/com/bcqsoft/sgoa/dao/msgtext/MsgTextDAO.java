package com.bcqsoft.sgoa.dao.msgtext;

import com.bcqsoft.sgoa.dao.msgtext.dataobject.MsgText;

/**
 * 站内信详细内容表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_MSG_TEXT
 * </pre>
 */
public interface MsgTextDAO {
	/**
	 * 写信
	 * 
	 */
	Long addMsgText(MsgText msgText);
	/**
	 * 更新内容
	 * 
	 */
	Integer updateMsgText(MsgText msgText);

	

}
