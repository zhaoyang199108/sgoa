package com.bcqsoft.sgoa.dao.docinhistory;

import java.util.List;

import com.bcqsoft.sgoa.dao.docinhistory.dataobject.DocinHistory;

/**
 * 信息发布审核表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN_REVIEW
 * </pre>
 */
public interface DocinHistoryDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoDocinHistory(DocinHistory docinHistory);

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<DocinHistory> findAllDocinHistoryById(Long id);

}
