package com.bcqsoft.sgoa.service.msg;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInbox;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutbox;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutboxPage;

/**
 * 站内信模块业务逻辑类接口
 */
public interface MsgOutboxService {

	/**
	 * 写信的接口
	 * 
	 * @param messageEntity
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	boolean addMsgOutbox(MsgOutbox msgOutbox, MultipartFile srcUploadFile);
	/**
	 * 转发信的接口
	 * 
	 * @param messageEntity
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	boolean editMsgOutbox(MsgOutbox msgOutbox);

	/**
	 * 取得有效的发件箱列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	MsgOutboxPage getMsgOutboxListByPage(MsgOutboxPage msgOutboxPage);

	/**
	 * 删除一条发信(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	boolean deleteMsgOutboxInfoById(long id);

	/**
	 * 删除多条发信(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	boolean deleteMsgOutboxs(long[] longArray);

	/**
	 * 根据ID查询发件箱的详细信息
	 * 
	 * @param id
	 * @return msgOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	MsgOutbox selectMsgOutboxById(long id);

	/**
	 * 查看未读的站内信
	 * 
	 * @param userId 当前登录ID
	 * @return 未读站内信列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-15
	 */
	List<MsgInbox> getUnreadMessageByUserId(String userId);

	/**
	 * 发件箱更新处理
	 * 
	 * @param msgOutbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	boolean updateMsgOutboxInfo(MsgOutbox msgOutbox);

	/**
	 * 草稿箱接口
	 * 
	 * @param msgOutboxPage
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	MsgOutboxPage getMsgOutboxDraftListByPage(MsgOutboxPage msgOutboxPage);

	/**
	 * 根据ID恢复垃圾箱的详细信息
	 * 
	 * @param id
	 * @return msgOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	boolean editMsgOutboxById(long id);

}
