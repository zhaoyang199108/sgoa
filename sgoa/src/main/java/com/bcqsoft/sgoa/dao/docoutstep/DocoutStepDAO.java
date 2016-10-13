package com.bcqsoft.sgoa.dao.docoutstep;

import java.util.List;

import com.bcqsoft.sgoa.dao.docoutstep.dataobject.DocoutStep;

/**
 * 信息发布审核表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT_REVIEW
 * </pre>
 */
public interface DocoutStepDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoDocoutStep(DocoutStep docoutStep);
	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoDocoutStepByDo(DocoutStep docoutStep);


	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<DocoutStep> findAllDocoutStepById(Long docId);

	/**
	 * 根据信息删除信息
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Integer delectIntoDocoutStep(DocoutStep docoutStepByDocout);

	/**
	 * 根据ID信息删除信息
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Integer delectIntoDocoutStepById(Long id);

}
