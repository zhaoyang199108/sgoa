package com.bcqsoft.sgoa.service.docoutlook;

import java.util.List;

import com.bcqsoft.sgoa.dao.docoutlook.dataobject.DocoutLook;

/**
 * 信息发布模块业务逻辑类接口
 */
public interface DocoutLookService {

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<DocoutLook> getAllDocoutLookList(DocoutLook docoutLook);

	/**
	 * 添加信息数据
	 * 
	 * @param Docout
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addDocoutInfo(DocoutLook docoutLook);

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<DocoutLook> getAllDocoutLookListAll(long id);

}
