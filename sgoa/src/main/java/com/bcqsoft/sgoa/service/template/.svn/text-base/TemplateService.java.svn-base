package com.bcqsoft.sgoa.service.template;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.template.dataobject.Template;
import com.bcqsoft.sgoa.dao.template.dataobject.TemplatePage;

/**
 * 签章模块设备申领表模块业务逻辑类接口
 */
@Service
public interface TemplateService {
	/**
	 * 根据查询条件查找签章模块信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	TemplatePage getTemplateInfoList(TemplatePage page);

	/**
	 * 签章模块详细信息
	 * 
	 * @param template
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	Template getTemplateInfo(long id);

	/**
	 * 删除签章模块信息
	 * 
	 * @param templateId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteTemplate(long id);

	/**
	 * 删除签章模块信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteTemplates(long[] longArray);

}
