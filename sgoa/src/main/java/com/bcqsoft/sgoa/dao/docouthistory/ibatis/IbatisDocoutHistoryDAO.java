package com.bcqsoft.sgoa.dao.docouthistory.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docouthistory.DocoutHistoryDAO;
import com.bcqsoft.sgoa.dao.docouthistory.dataobject.DocoutHistory;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT_REVIEW
 * </pre>
 */
@Repository
public class IbatisDocoutHistoryDAO extends BaseDAO implements DocoutHistoryDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocoutHistory(DocoutHistory docoutHistory) {
		return (Long) ibatis().insert("docouthistory.insertIntoDocoutHistory", docoutHistory);
	}

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@SuppressWarnings("unchecked")
	public List<DocoutHistory> findAllDocoutHistoryById(Long id) {
		return (List<DocoutHistory>) ibatis().queryForList("docouthistory.findAllDocoutHistoryById", id);
	}

}
