package com.bcqsoft.sgoa.dao.docoutlook.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docoutlook.DocoutLookDAO;
import com.bcqsoft.sgoa.dao.docoutlook.dataobject.DocoutLook;

/**
 * 信息发布表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT
 * </pre>
 */
@Repository
public class IbatisDocoutLookDAO extends BaseDAO implements DocoutLookDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<DocoutLook> getAllDocoutLookList(DocoutLook docoutLook) {

		return (List<DocoutLook>) ibatis().queryForList("docoutLook.getAllDocoutLookList", docoutLook);

	}

	@Override
	public Long addDocoutInfo(DocoutLook docoutLook) {
		return (Long) ibatis().insert("docoutLook.addDocoutInfo", docoutLook);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocoutLook> getAllDocoutLookListAll(Long id) {

		return (List<DocoutLook>) ibatis().queryForList("docoutLook.getAllDocoutLookListAll", id);

	}

}
