package com.bcqsoft.sgoa.service.msgone;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInbox;
import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInboxPage;

/**
 * 收件箱模块业务逻辑类接口
 */
@Service
public interface MsgoneInboxService {

	/**
	 * 根据查询条件查找用户信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	MsgoneInboxPage getMsgoneInboxListByPage(MsgoneInboxPage msgoneInboxPage);

	boolean deleteMsgoneInboxs(long[] longArray);

	/**
	 * 根据ID查询收件箱的详细信息
	 * 
	 * @param id
	 * @return msgoneInbox
	 * 
	 * @author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	MsgoneInbox selectMsgoneInboxById(long id);

	/**
	 * 收件箱更新处理
	 * 
	 * @param MsgoneInbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */

	boolean updateMsgoneInboxInfo(MsgoneInbox msgoneInbox);

	/**
	 * 删除一条工作动态(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */

	boolean deleteMsgoneInboxInfoById(long id);

	/**
	 * 根据查询条件查找垃圾箱列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	MsgoneInboxPage getDustbinListByPage(MsgoneInboxPage msgoneInboxPage);
	/**
	 * 根据ID恢复垃圾箱的详细信息
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */	

	boolean editMsgoneInboxById(long id);
	/**
	 * 已读一条收件箱(逻辑已读)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	boolean readMsgoneInboxInfoById(long id);
	/**
	 * 已读一条收件箱(逻辑已读)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	boolean readMsgoneInboxs(long[] longArray);

}
