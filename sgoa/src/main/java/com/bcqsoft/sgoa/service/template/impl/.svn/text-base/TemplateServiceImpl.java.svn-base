package com.bcqsoft.sgoa.service.template.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.template.TemplateDAO;
import com.bcqsoft.sgoa.dao.template.dataobject.Template;
import com.bcqsoft.sgoa.dao.template.dataobject.TemplatePage;
import com.bcqsoft.sgoa.service.template.TemplateService;

/**
 * 物资设备申领表模块业务逻辑实现类
 */
@Service
public class TemplateServiceImpl extends BaseService implements TemplateService {

	/**
	 * 签章模块模块DAO实现类
	 */
	@Autowired
	private TemplateDAO templateDAO;

	/**
	 * 根据查询条件查找签章模块信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	@Override
	public TemplatePage getTemplateInfoList(TemplatePage page) {
		int count = templateDAO.findTemplateInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得签章模块信息集合(分页查询)
		List<Template> templateList = templateDAO.findTemplateInfoList(page);

		page.setTotalRow(count); // 签章模块总数量
		page.setTemplateList(templateList); // 签章模块信息集合
		return page;
	}

	/**
	 * 签章模块详细信息
	 * 
	 * @param template
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	public Template getTemplateInfo(long id) {
		Template template = templateDAO.getTemplateInfo(id);
		return template;
	}

	/**
	 * 删除签章模块信息
	 * 
	 * @param templateId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean deleteTemplate(long id) {
		// 根据id取得用户信息
		Integer count = templateDAO.deleteTemplateInfoById(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除签章模块信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public boolean deleteTemplates(long[] longArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long templateId : longArray) {

			// 删除用户信息
			Integer count = templateDAO.deleteTemplateInfoById(templateId);

			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

}
