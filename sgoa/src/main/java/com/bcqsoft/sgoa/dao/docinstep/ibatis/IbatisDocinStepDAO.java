package com.bcqsoft.sgoa.dao.docinstep.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docinstep.DocinStepDAO;
import com.bcqsoft.sgoa.dao.docinstep.dataobject.DocinStep;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN_REVIEW
 * </pre>
 */
@Repository
public class IbatisDocinStepDAO extends BaseDAO implements DocinStepDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocinStep(DocinStep docinStep) {
		return (Long) ibatis().insert("docinstep.insertIntoDocinStep", docinStep);
	}
	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocinStepByDo(DocinStep docinStep) {
		return (Long) ibatis().insert("docinstep.insertIntoDocinStepByDo", docinStep);
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
	public List<DocinStep> findAllDocinStepById(Long docId) {
		return (List<DocinStep>) ibatis().queryForList("docinstep.findAllDocinStepById", docId);
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
	public Integer delectIntoDocinStep(DocinStep docinStepByDocin) {
		return (Integer) ibatis().delete("docinstep.delectIntoDocinStep", docinStepByDocin);

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
	public Integer delectIntoDocinStepById(Long id) {
		return (Integer) ibatis().delete("docinstep.delectIntoDocinStepById", id);

	}

}
