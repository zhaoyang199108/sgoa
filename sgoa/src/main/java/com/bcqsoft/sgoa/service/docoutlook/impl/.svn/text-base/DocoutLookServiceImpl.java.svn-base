package com.bcqsoft.sgoa.service.docoutlook.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.docoutlook.DocoutLookDAO;
import com.bcqsoft.sgoa.dao.docoutlook.dataobject.DocoutLook;
import com.bcqsoft.sgoa.service.docoutlook.DocoutLookService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class DocoutLookServiceImpl extends BaseService implements DocoutLookService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocoutLookDAO docoutLookDAO;

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public List<DocoutLook> getAllDocoutLookList(DocoutLook docoutLook) {
		List<DocoutLook> docoutLookList = docoutLookDAO.getAllDocoutLookList(docoutLook);
		return docoutLookList;
	}

	@Override
	public boolean addDocoutInfo(DocoutLook docoutLook) {
		// 数据库新增一条收文审核记录,并返回是否插入成功
		Long pk = docoutLookDAO.addDocoutInfo(docoutLook);
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
	public List<DocoutLook> getAllDocoutLookListAll(long id) {
		List<DocoutLook> docoutLookList = docoutLookDAO.getAllDocoutLookListAll(id);
		return docoutLookList;
	}
}
