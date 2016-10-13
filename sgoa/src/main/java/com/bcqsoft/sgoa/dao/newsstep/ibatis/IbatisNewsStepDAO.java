package com.bcqsoft.sgoa.dao.newsstep.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.newsstep.NewsStepDAO;
import com.bcqsoft.sgoa.dao.newsstep.dataobject.NewsStep;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_NEWS_REVIEW
 * </pre>
 */
@Repository
public class IbatisNewsStepDAO extends BaseDAO implements NewsStepDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoNewsStep(NewsStep newsStep) {
		return (Long) ibatis().insert("newsstep.insertIntoNewsStep", newsStep);
	}

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@SuppressWarnings("unchecked")
	public List<NewsStep> findAllNewsStepById(Long docId) {
		return (List<NewsStep>) ibatis().queryForList("newsstep.findAllNewsStepById", docId);
	}
	/**
	 * 根据信息删除信息
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Override
	public Integer delectIntoNewsStep(NewsStep newsStepByNews) {
		return (Integer) ibatis().delete("newsstep.delectIntoNewsStep", newsStepByNews);

	}
	/**
	 * 根据ID信息删除信息
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Override
	public Integer delectIntoNewsStepById(Long id) {
		return (Integer) ibatis().delete("newsstep.delectIntoNewsStepById", id);

	}

}
