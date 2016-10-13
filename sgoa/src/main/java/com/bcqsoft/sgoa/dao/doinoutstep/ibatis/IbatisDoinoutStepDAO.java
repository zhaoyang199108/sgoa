package com.bcqsoft.sgoa.dao.doinoutstep.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.doinoutstep.DoinoutStepDAO;
import com.bcqsoft.sgoa.dao.doinoutstep.dataobject.DoinoutStep;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN_REVIEW
 * </pre>
 */
@Repository
public class IbatisDoinoutStepDAO extends BaseDAO implements DoinoutStepDAO {


	/**
	 * 步骤表添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Override
	public Long insertIntoDoinoutStep(DoinoutStep doinoutStep) {
		return (Long) ibatis().insert("doinoutstep.insertIntoDoinoutStep", doinoutStep);
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
	public Integer delectIntoDoinoutStep(DoinoutStep doinoutStep) {
		return (Integer) ibatis().delete("doinoutstep.delectIntoDoinoutStep", doinoutStep);
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
	public List<DoinoutStep> findAllDoinoutStepById(Long id) {
		return (List<DoinoutStep>) ibatis().queryForList("doinoutstep.findAllDoinoutStepById", id);
	}


}
