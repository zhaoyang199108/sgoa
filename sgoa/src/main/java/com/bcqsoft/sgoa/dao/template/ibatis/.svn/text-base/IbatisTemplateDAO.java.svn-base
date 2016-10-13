package com.bcqsoft.sgoa.dao.template.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.template.TemplateDAO;
import com.bcqsoft.sgoa.dao.template.dataobject.Template;
import com.bcqsoft.sgoa.dao.template.dataobject.TemplatePage;

/**
 * 签章模块数据库访问DAO实现类
 * 
 * <pre>
 * 表: sgoa_TB_APPLY_GET
 * </pre>
 */
@Repository
public class IbatisTemplateDAO extends BaseDAO implements TemplateDAO {

	/**
	 * 查找签章模块列表数量
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Templates&gt;
	 */
	public Integer findTemplateInfoCount(TemplatePage page) {
		return (Integer) ibatis()
				.queryForObject("template.findTemplateInfoCount", page);
	}


	/**
	 * 查找签章模块列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Templates&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Template> findTemplateInfoList(TemplatePage page) {
		return (List<Template>) ibatis()
				.queryForList("template.findTemplateInfoList", page);
	}

	/**
	 * 查找签章模块列表
	 * 
	 * @author cql2109
	 * @date 2012-01-04
	 * @return List&lt;Templates&gt;
	 */
	@SuppressWarnings("unchecked")
	public List<Template> findTemplateInfoAllList() {
		return (List<Template>) ibatis()
				.queryForList("template.findTemplateInfoAllList");
	}
	


	/**
	 * 根据签章模块ID查询签章模块表信息
	 * 
	 * @param templateId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Template getTemplateInfo(long id) {
		return (Template) ibatis().queryForObject("template.getTemplateInfo", id);
	}



	/**
	 * 根据签章模块ID删除签章模块表信息
	 * 
	 * @param templateId
	 * @return 更新是否成功
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	public Integer deleteTemplateInfoById(long id) {
		return (Integer) ibatis().update("template.deleteTemplateInfoById", id);
	}


}
