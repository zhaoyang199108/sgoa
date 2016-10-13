package com.bcqsoft.sgoa.dao.newshistory;

import java.util.List;

import com.bcqsoft.sgoa.dao.newshistory.dataobject.NewsHistory;

/**
 * 信息发布审核表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_NEWS_REVIEW
 * </pre>
 */
public interface NewsHistoryDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoNewsHistory(NewsHistory newsHistory);

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<NewsHistory> findAllNewsHistoryById(Long id);

}
