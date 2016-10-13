package com.bcqsoft.sgoa.dao.docoutstep.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docoutstep.DocoutStepDAO;
import com.bcqsoft.sgoa.dao.docoutstep.dataobject.DocoutStep;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT_REVIEW
 * </pre>
 */
@Repository
public class IbatisDocoutStepDAO extends BaseDAO implements DocoutStepDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocoutStep(DocoutStep docoutStep) {
		return (Long) ibatis().insert("docoutstep.insertIntoDocoutStep", docoutStep);
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
	public Long insertIntoDocoutStepByDo(DocoutStep docoutStep) {
		return (Long) ibatis().insert("docoutstep.insertIntoDocoutStepByDo", docoutStep);
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
	public List<DocoutStep> findAllDocoutStepById(Long docId) {
		return (List<DocoutStep>) ibatis().queryForList("docoutstep.findAllDocoutStepById", docId);
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
	public Integer delectIntoDocoutStep(DocoutStep docoutStepByDocout) {
		return (Integer) ibatis().delete("docoutstep.delectIntoDocoutStep", docoutStepByDocout);

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
	public Integer delectIntoDocoutStepById(Long id) {
		return (Integer) ibatis().delete("docoutstep.delectIntoDocoutStepById", id);

	}

}
