package com.bcqsoft.sgoa.service.messagelook.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.messagelook.MessageLookDAO;
import com.bcqsoft.sgoa.dao.messagelook.dataobject.MessageLook;
import com.bcqsoft.sgoa.service.messagelook.MessageLookService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class MessageLookServiceImpl extends BaseService implements MessageLookService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private MessageLookDAO messageLookDAO;

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public List<MessageLook> getAllMessageLookList(MessageLook messageLook) {
		List<MessageLook> messageLookList = messageLookDAO.getAllMessageLookList(messageLook);
		return messageLookList;
	}

	@Override
	public boolean addMessageInfo(MessageLook messageLook) {
		// 数据库新增一条收文审核记录,并返回是否插入成功
		Long pk = messageLookDAO.addMessageInfo(messageLook);
		return isInsertSucc(pk);
	}

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public List<MessageLook> getAllMessageLookListAll(long id) {
		List<MessageLook> messageLookList = messageLookDAO.getAllMessageLookListAll(id);
		return messageLookList;
	}
}
