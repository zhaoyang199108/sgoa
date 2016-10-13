package com.bcqsoft.sgoa.dao.newsstep;

import java.util.List;

import com.bcqsoft.sgoa.dao.newsstep.dataobject.NewsStep;

/**
 * 信息发布审核表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_NEWS_REVIEW
 * </pre>
 */
public interface NewsStepDAO {

	/**
	 * 信息审核表中添加数据
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoNewsStep(NewsStep newsStep);

	/**
	 * 根据信息ID读取信息的全部审核记录
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<NewsStep> findAllNewsStepById(Long docId);

	/**
	 * 根据信息删除信息
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Integer delectIntoNewsStep(NewsStep newsStepByNews);

	/**
	 * 根据ID信息删除信息
	 * 
	 * @param DocumentOutStep
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Integer delectIntoNewsStepById(Long id);

}
