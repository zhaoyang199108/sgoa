package com.bcqsoft.sgoa.dao.docinhistory.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docinhistory.DocinHistoryDAO;
import com.bcqsoft.sgoa.dao.docinhistory.dataobject.DocinHistory;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN_REVIEW
 * </pre>
 */
@Repository
public class IbatisDocinHistoryDAO extends BaseDAO implements DocinHistoryDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocinHistory(DocinHistory docinHistory) {
		return (Long) ibatis().insert("docinhistory.insertIntoDocinHistory", docinHistory);
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
	public List<DocinHistory> findAllDocinHistoryById(Long id) {
		return (List<DocinHistory>) ibatis().queryForList("docinhistory.findAllDocinHistoryById", id);
	}

}
