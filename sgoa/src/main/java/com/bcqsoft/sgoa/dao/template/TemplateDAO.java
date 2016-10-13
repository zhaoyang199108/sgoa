package com.bcqsoft.sgoa.dao.template;

import java.util.List;

import com.bcqsoft.sgoa.dao.template.dataobject.Template;
import com.bcqsoft.sgoa.dao.template.dataobject.TemplatePage;

/**
 * 签章模块数据库访问DAO接口
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
public interface TemplateDAO {
	/**
	 * 查找签章模块列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Templates&gt;
	 */
	Integer findTemplateInfoCount(TemplatePage page);

	/**
	 * 查找签章模块列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Templates&gt;
	 */
	List<Template> findTemplateInfoList(TemplatePage page);
	

	/**
	 * 根据签章模块ID查询签章模块表信息
	 * 
	 * @param templateId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Template getTemplateInfo(long id);
	/**
	/**
	 * 根据签章模块ID删除签章模块表信息
	 * 
	 * @param templateId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	Integer deleteTemplateInfoById(long id);

}
