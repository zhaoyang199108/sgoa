package com.bcqsoft.sgoa.service.msg;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInbox;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInboxPage;

/**
 * 收件箱模块业务逻辑类接口
 */
@Service
public interface MsgInboxService {

	/**
	 * 根据查询条件查找用户信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	MsgInboxPage getMsgInboxListByPage(MsgInboxPage msgInboxPage);

	boolean deleteMsgInboxs(long[] longArray);

	/**
	 * 根据ID查询收件箱的详细信息
	 * 
	 * @param id
	 * @return msgInbox
	 * 
	 * @author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	MsgInbox selectMsgInboxById(long id);

	/**
	 * 收件箱更新处理
	 * 
	 * @param MsgInbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */

	boolean updateMsgInboxInfo(MsgInbox msgInbox);

	/**
	 * 删除一条工作动态(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */

	boolean deleteMsgInboxInfoById(long id);

	/**
	 * 根据查询条件查找垃圾箱列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	MsgInboxPage getDustbinListByPage(MsgInboxPage msgInboxPage);
	/**
	 * 根据ID恢复垃圾箱的详细信息
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */	

	boolean editMsgInboxById(long id);
	/**
	 * 已读一条收件箱(逻辑已读)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	boolean readMsgInboxInfoById(long id);
	/**
	 * 已读一条收件箱(逻辑已读)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	boolean readMsgInboxs(long[] longArray);

}
