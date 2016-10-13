package com.bcqsoft.sgoa.dao.doinoutstep;

import java.util.List;

import com.bcqsoft.sgoa.dao.doinoutstep.dataobject.DoinoutStep;

/**
 * 信息发布审核表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN_REVIEW
 * </pre>
 */
public interface DoinoutStepDAO {

	/**
	 * 步骤表添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoDoinoutStep(DoinoutStep doinoutStep);

	/**
	 * 根据信息删除信息
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Integer delectIntoDoinoutStep(DoinoutStep doinoutStep);

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<DoinoutStep> findAllDoinoutStepById(Long id);


}
