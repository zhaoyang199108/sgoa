package com.bcqsoft.sgoa.dao.docinfj.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docinfj.DocinFjDAO;
import com.bcqsoft.sgoa.dao.docinfj.dataobject.DocinFj;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN_REVIEW
 * </pre>
 */
@Repository
public class IbatisDocinFjDAO extends BaseDAO implements DocinFjDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutReview
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocinFj(DocinFj docinFj) {
		return (Long) ibatis().insert("docinfj.insertIntoDocinFj", docinFj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocinFj> findDocinFjInfoByDocinId(Long id) {
		return (List<DocinFj>) ibatis().queryForList("docinfj.findDocinFjInfoByDocinId",id);
	}
}
