package com.bcqsoft.sgoa.mvc.controller.template;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.template.dataobject.Template;
import com.bcqsoft.sgoa.dao.template.dataobject.TemplatePage;
import com.bcqsoft.sgoa.mvc.form.template.TemplateForm;
import com.bcqsoft.sgoa.service.template.TemplateService;

/**
 * 签章模块申领表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class TemplateController {
	/**
	 * 签章模块申领表的业务逻辑层
	 */
	@Autowired
	private TemplateService templateService;

	/**
	 * 取得有效的签章模块申领表列表(提交审核页面)
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/template/template_list.htm")
	public String selectTemplateListByPage(TemplateForm form, ModelMap map) {
		TemplatePage templatePage = new TemplatePage(); // 分页对象
		setSearchKey(form, templatePage); // 设置页面中的查询条件
		TemplatePage page = templateService.getTemplateInfoList(templatePage);
		// 跳转至签章模块申领表列表页面
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "template_list");
		return "template/template_list";
	}

	/**
	 * 跳转至新增签章模块页面
	 * 
	 * @return 新增签章模块页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/template/add_template.htm", method = RequestMethod.GET)
	public String addTemplate(ModelMap map) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_templateId", formatter.format(cal.getTime()));
		map.put("d_userName", SecurityUtils.getLoginId());
		map.put("d_fileType", "doc");
		return "template/add_template";
	}

	/**
	 * 签章模块申领表新增处理
	 * 
	 * @param map
	 * @return 签章模块申领表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/template/add_template.htm")
	public String addTemplate(TemplateForm form, ModelMap map) {
		return "common/action_succ";
	}

	/**
	 * 签章模块表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新签章模块申领表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/template/delete_template.htm")
	public String delectTemplate(long id) {
		templateService.deleteTemplate(id);
		return "common/action_succ";

	}

	/**
	 * 删除签章模块表(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/template/delete_templateArray.htm")
	public String removeTemplate(String idArray) {
		templateService.deleteTemplates(toLongArray(idArray));
		return "common/action_succ";
	}

	/**
	 * 跳转至签章模块详细页面
	 * 
	 * @return 签章模块页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/template/template_detail.htm", method = RequestMethod.GET)
	public String templateDetail(long id, ModelMap map) {
		// 取得签章模块详细页面
		Template template = templateService.getTemplateInfo(id);
		map.put("template", template);
		return "template/template_detail";
	}

	/**
	 * 跳转至签章模块更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/template/template_edit.htm")
	public String templateEdit(TemplateForm form, ModelMap map) {
		// 取得签章模块详细页面
		return "common/action_succ";
	}

	/**
	 * 根据ID查询所要更新的记录
	 * 
	 * @return 签章模块页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/template/template_edit.htm", method = RequestMethod.GET)
	public String templateEdit(long id, ModelMap map) {
		// 取得签章模块详细页面
		Template template = templateService.getTemplateInfo(id);
		map.put("template", template);
		return "template/template_edit";
	}

	/**
	 * 签章模块申领表列表页面设置查询条件
	 * 
	 * @param form
	 * @param TemplatePage
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	private void setSearchKey(TemplateForm form, TemplatePage templatePage) {
		templatePage.setFileName(form.getFileName());// 模版名称
		templatePage.setCurrentPage(form.getCp()); // 当前页数

	}
	
	
	
	
	
	/**
	 * 跳转至签章模块更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/template/test_sign.htm")
	public String testSign(TemplateForm form, ModelMap map) {
		// 取得签章模块详细页面
		map.put("loginId", SecurityUtils.getLoginId());
		map.put("recordId", "SX"+DateUtil.getDateTimeForYh());
		return "template/test_sign";
	}

}
