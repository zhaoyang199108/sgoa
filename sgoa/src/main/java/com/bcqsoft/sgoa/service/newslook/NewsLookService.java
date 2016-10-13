package com.bcqsoft.sgoa.service.newslook;

import java.util.List;

import com.bcqsoft.sgoa.dao.newslook.dataobject.NewsLook;

/**
 * 信息发布模块业务逻辑类接口
 */
public interface NewsLookService {

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<NewsLook> getAllNewsLookList(NewsLook newsLook);

	/**
	 * 添加信息数据
	 * 
	 * @param News
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addNewsInfo(NewsLook newsLook);

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<NewsLook> getAllNewsLookListAll(long id);
}