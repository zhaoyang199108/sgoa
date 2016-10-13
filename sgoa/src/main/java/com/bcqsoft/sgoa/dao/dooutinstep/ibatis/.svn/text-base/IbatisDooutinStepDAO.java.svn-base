package com.bcqsoft.sgoa.dao.dooutinstep.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.dooutinstep.DooutinStepDAO;
import com.bcqsoft.sgoa.dao.dooutinstep.dataobject.DooutinStep;

/**
 * 信息发布审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT_REVIEW
 * </pre>
 */
@Repository
public class IbatisDooutinStepDAO extends BaseDAO implements DooutinStepDAO {


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
	public Long insertIntoDooutinStep(DooutinStep dooutinStep) {
		return (Long) ibatis().insert("dooutinstep.insertIntoDooutinStep", dooutinStep);
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
	public Integer delectIntoDooutinStep(DooutinStep dooutinStep) {
		return (Integer) ibatis().delete("dooutinstep.delectIntoDooutinStep", dooutinStep);
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
	public List<DooutinStep> findAllDooutinStepById(Long id) {
		return (List<DooutinStep>) ibatis().queryForList("dooutinstep.findAllDooutinStepById", id);
	}


}
