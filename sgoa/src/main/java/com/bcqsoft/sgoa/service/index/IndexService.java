package com.bcqsoft.sgoa.service.index;

import java.util.Map;


/**
 * 首页模块业务逻辑类接口
 */
public interface IndexService {


	/**
	 * 取得主页面中提示信息
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	public Map<String, Object> getAlertMessageForIndex();
	
	/**
	 * 取得主页面中提示信息
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	public Map<String, Integer> getAlertMessageForIndexCount();
	
	/**
	 * 更新为暂不提醒状态
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	void alertInfoEditZbtx(String[] idArray);
	
	/**
	 * 更新为不提醒状态
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	void alertInfoEditBtx(String[] idArray);
	
	/**
	 * 取得主页面中提示信息
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	void alertInfoEditHftx(String[] idArray);
	
	/**
	 * 更新为提醒状态
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	void alertInfoEditTx();
}
