package com.bcqsoft.sgoa.dao.newshistory.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.newshistory.NewsHistoryDAO;
import com.bcqsoft.sgoa.dao.newshistory.dataobject.NewsHistory;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_NEWS_REVIEW
 * </pre>
 */
@Repository
public class IbatisNewsHistoryDAO extends BaseDAO implements NewsHistoryDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoNewsHistory(NewsHistory newsHistory) {
		return (Long) ibatis().insert("newshistory.insertIntoNewsHistory", newsHistory);
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
	public List<NewsHistory> findAllNewsHistoryById(Long id) {
		return (List<NewsHistory>) ibatis().queryForList("newshistory.findAllNewsHistoryById", id);
	}

}
