package com.bcqsoft.sgoa.mvc.controller.buttonname;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonName;
import com.bcqsoft.sgoa.dao.buttonname.dataobject.ButtonNamePage;
import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.mvc.form.buttonname.ButtonNameForm;
import com.bcqsoft.sgoa.service.buttonname.ButtonNameService;

/**
 * 按钮名称申领表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class ButtonNameController {
	
	/**
	 * 按钮名称表的业务逻辑层
	 */
	@Autowired
	private ButtonNameService buttonNameService;
	
	/**
	 * 取得有效的按钮名称申领表列表(提交审核页面)
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/buttonname/buttonname_list.htm")
	public String selectButtonNameListByPage(ButtonNameForm form, ModelMap map) {
		ButtonNamePage buttonNamePage = new ButtonNamePage(); // 分页对象
		setSearchKey(form, buttonNamePage); // 设置页面中的查询条件
		ButtonNamePage page = buttonNameService.findButtonNameInfo(buttonNamePage);
		// 跳转至按钮名称申领表列表页面
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "buttonname_list");
		return "buttonname/buttonname_list";
	}

	/**
	 * 跳转至新增按钮名称页面
	 * 
	 * @return 新增按钮名称页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/buttonname/add_buttonname.htm", method = RequestMethod.GET)
	public String addButtonName(ModelMap map) {
		List<Grpo> grpoList = buttonNameService.getGrpoListByAll(2);
		map.put("grpoList", grpoList);
		return "buttonname/add_buttonname";
	}

	/**
	 * 按钮名称申领表新增处理
	 * 
	 * @param map
	 * @return 按钮名称申领表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/buttonname/add_buttonname.htm")
	public String addButtonName(ButtonNameForm form, ModelMap map) {
		buttonNameService.createButtonNameInfo(setBean(form));
		return "common/action_succ";
	}

	/**
	 * 按钮名称表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新按钮名称申领表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/buttonname/delete_buttonname.htm")
	public String delectButtonName(long id) {
		buttonNameService.deleteButtonNameInfo(id);
		return "common/action_succ";

	}

	/**
	 * 删除按钮名称表(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/buttonname/delete_buttonnameArray.htm")
	public String removeButtonName(String idArray) {
		buttonNameService.deleteButtonNames(toLongArray(idArray));
		return "common/action_succ";
	}


	/**
	 * 跳转至按钮名称详细页面
	 * 
	 * @return 按钮名称页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/buttonname/buttonname_detail.htm", method = RequestMethod.GET)
	public String ButtonNameDetail(long id, ModelMap map) {
		// 取得按钮名称详细页面
		ButtonName buttonName = buttonNameService.getButtonNameDetailInfo(id);
		map.put("buttonName", buttonName);
		List<Grpo> grpoList = buttonNameService.getGrpoListByAll(2);
		map.put("grpoList", grpoList);
		return "buttonname/buttonname_detail";
	}
	/**
	 * 跳转至按钮名称更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/buttonname/buttonname_edit.htm")
	public String ButtonNameEdit(ButtonNameForm form, ModelMap map) {
		// 取得按钮名称详细页面
		buttonNameService.updateButtonNameInfo(setBean(form));
		return "common/action_succ";
	}

	/**
	 * 按钮名称更新
	 * 
	 * @return 按钮名称页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/buttonname/buttonname_edit.htm", method = RequestMethod.GET)
	public String ButtonNameEdit(long id, ModelMap map) {
		// 取得按钮名称详细页面
		ButtonName buttonName = buttonNameService.getButtonNameDetailInfo(id);
		map.put("buttonName", buttonName);
		List<Grpo> grpoList = buttonNameService.getGrpoListByAll(2);
		map.put("grpoList", grpoList);
		return "buttonname/buttonname_edit";
	}

	/**
	 * 更新设置表单属性
	 * 
	 * @param form
	 * @return ButtonName
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private ButtonName setBean(ButtonNameForm form) {
		ButtonName buttonName = new ButtonName();
		buttonName.setId(form.getId());//职务ID
		buttonName.setBtnName(form.getBtnName());//名称
		buttonName.setPositionId(form.getPositionId());//职务ID
		buttonName.setModule(form.getModule());//职务ID
		buttonName.setModuleType(form.getModuleType());//职务ID
		return buttonName;
	}

	/**
	 * 按钮名称申领表列表页面设置查询条件
	 * 
	 * @param form
	 * @param ButtonNamePage
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	private void setSearchKey(ButtonNameForm form, ButtonNamePage buttonNamePage) {
		buttonNamePage.setBtnName(form.getBtnName());//物品名称
		buttonNamePage.setCurrentPage(form.getCp());
	}
}
