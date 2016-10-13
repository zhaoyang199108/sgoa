package com.bcqsoft.sgoa.service.newslook.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.newslook.NewsLookDAO;
import com.bcqsoft.sgoa.dao.newslook.dataobject.NewsLook;
import com.bcqsoft.sgoa.service.newslook.NewsLookService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class NewsLookServiceImpl extends BaseService implements NewsLookService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private NewsLookDAO newsLookDAO;

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public List<NewsLook> getAllNewsLookList(NewsLook newsLook) {
		List<NewsLook> newsLookList = newsLookDAO.getAllNewsLookList(newsLook);
		return newsLookList;
	}

	@Override
	public boolean addNewsInfo(NewsLook newsLook) {
		// 数据库新增一条收文审核记录,并返回是否插入成功
		Long pk = newsLookDAO.addNewsInfo(newsLook);
		return isInsertSucc(pk);
	}

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public List<NewsLook> getAllNewsLookListAll(long id) {
		List<NewsLook> newsLookList = newsLookDAO.getAllNewsLookListAll(id);
		return newsLookList;
	}
}