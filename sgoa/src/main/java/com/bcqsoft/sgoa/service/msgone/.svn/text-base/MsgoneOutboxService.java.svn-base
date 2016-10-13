package com.bcqsoft.sgoa.service.msgone;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInbox;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutbox;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutboxPage;

/**
 * 站内信模块业务逻辑类接口
 */
public interface MsgoneOutboxService {

	/**
	 * 写信的接口
	 * 
	 * @param messageEntity
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	boolean addMsgoneOutbox(MsgoneOutbox msgoneOutbox, MultipartFile srcUploadFile);
	/**
	 * 转发信的接口
	 * 
	 * @param messageEntity
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	boolean editMsgoneOutbox(MsgoneOutbox msgoneOutbox);

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
	MsgoneOutboxPage getMsgoneOutboxListByPage(MsgoneOutboxPage msgoneOutboxPage);

	/**
	 * 删除一条发信(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	boolean deleteMsgoneOutboxInfoById(long id);

	/**
	 * 删除多条发信(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	boolean deleteMsgoneOutboxs(long[] longArray);

	/**
	 * 根据ID查询发件箱的详细信息
	 * 
	 * @param id
	 * @return msgoneOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	MsgoneOutbox selectMsgoneOutboxById(long id);

	/**
	 * 查看未读的站内信
	 * 
	 * @param userId 当前登录ID
	 * @return 未读站内信列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-15
	 */
	List<MsgoneInbox> getUnreadMessageByUserId(String userId);

	/**
	 * 发件箱更新处理
	 * 
	 * @param msgoneOutbox
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	boolean updateMsgoneOutboxInfo(MsgoneOutbox msgoneOutbox);

	/**
	 * 草稿箱接口
	 * 
	 * @param msgoneOutboxPage
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	MsgoneOutboxPage getMsgoneOutboxDraftListByPage(MsgoneOutboxPage msgoneOutboxPage);

	/**
	 * 根据ID恢复垃圾箱的详细信息
	 * 
	 * @param id
	 * @return msgoneOutbox
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-01-12
	 */
	boolean editMsgoneOutboxById(long id);
	
	boolean addEditMsgoneOutbox(MsgoneOutbox msgoneOutbox, MultipartFile srcUploadFile);

}
