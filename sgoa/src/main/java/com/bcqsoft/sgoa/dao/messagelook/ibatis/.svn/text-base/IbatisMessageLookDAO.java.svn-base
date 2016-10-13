package com.bcqsoft.sgoa.dao.messagelook.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.messagelook.MessageLookDAO;
import com.bcqsoft.sgoa.dao.messagelook.dataobject.MessageLook;

/**
 * 信息发布表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_MESSAGE
 * </pre>
 */
@Repository
public class IbatisMessageLookDAO extends BaseDAO implements MessageLookDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageLook> getAllMessageLookList(MessageLook messageLook) {

		return (List<MessageLook>) ibatis().queryForList("messageLook.getAllMessageLookList", messageLook);

	}

	@Override
	public Long addMessageInfo(MessageLook messageLook) {
		return (Long) ibatis().insert("messageLook.addMessageInfo", messageLook);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MessageLook> getAllMessageLookListAll(Long id) {

		return (List<MessageLook>) ibatis().queryForList("messageLook.getAllMessageLookListAll", id);

	}

}
