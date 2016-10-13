package com.bcqsoft.sgoa.service.messagelook;

import java.util.List;

import com.bcqsoft.sgoa.dao.messagelook.dataobject.MessageLook;

/**
 * 信息发布模块业务逻辑类接口
 */
public interface MessageLookService {

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<MessageLook> getAllMessageLookList(MessageLook messageLook);

	/**
	 * 添加信息数据
	 * 
	 * @param Message
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addMessageInfo(MessageLook messageLook);

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<MessageLook> getAllMessageLookListAll(long id);

}
