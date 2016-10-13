package com.bcqsoft.sgoa.mvc.controller.ggtxl;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.util.PinyinUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.addressbook.dataobject.AddressBook;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.Ggtxl;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.GgtxlPage;
import com.bcqsoft.sgoa.mvc.form.ggtxl.GgtxlForm;
import com.bcqsoft.sgoa.service.ggtxl.GgtxlService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 公共通讯录申领表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class GgtxlController {
	/**
	 * 公共通讯录申领表的业务逻辑层
	 */
	@Autowired
	private GgtxlService ggtxlService;
	
	/**
	 *用户表的业务逻辑层
	 */
	@Autowired
	private UserService userService;
	/**
	 * 取得有效的公共通讯录申领表列表(提交审核页面)
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/ggtxl/ggtxl_list.htm")
	public String selectGgtxlListByPage(GgtxlForm form, ModelMap map) {
		GgtxlPage ggtxlPage = new GgtxlPage(); // 分页对象
		setSearchKey(form, ggtxlPage); // 设置页面中的查询条件
		GgtxlPage page = ggtxlService.getGgtxlInfoList(ggtxlPage);
		// 跳转至公共通讯录申领表列表页面
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "ggtxl_list");
		return "ggtxl/ggtxl_list";
	}
	
	/**
	 * 取得有效的公共通讯录列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/ggtxl/ggtxl_search_list.htm")
	public String selectGgtxlSearchList(GgtxlForm form, ModelMap map) {
		GgtxlPage ggtxlPage = new GgtxlPage(); // 分页对象
		setSearchKey(form, ggtxlPage); // 设置页面中的查询条件
		GgtxlPage page = ggtxlService.getGgtxlInfoSearchList(ggtxlPage);
		// 跳转至公共通讯录申领表列表页面
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "ggtxl_search_list");
		return "ggtxl/ggtxl_search_list";
	}

	/**
	 * 跳转至新增公共通讯录页面
	 * 
	 * @return 新增公共通讯录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/ggtxl/add_ggtxl.htm", method = RequestMethod.GET)
	public String addGgtxl() {
		return "ggtxl/add_ggtxl";
	}

	/**
	 * 公共通讯录申领表新增处理
	 * 
	 * @param map
	 * @return 公共通讯录申领表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/ggtxl/add_ggtxl.htm")
	public String addGgtxl(GgtxlForm form, ModelMap map) {
		ggtxlService.createGgtxl(setBeans(form));
		return "common/action_succ";
	}

	/**
	 * 公共通讯录表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新公共通讯录申领表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/ggtxl/delete_ggtxl.htm")
	public String delectGgtxl(long id) {
		ggtxlService.deleteGgtxl(id);
		return "common/action_succ";

	}

	/**
	 * 删除公共通讯录表(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/ggtxl/delete_ggtxlArray.htm")
	public String removeGgtxl(String idArray) {
		ggtxlService.deleteGgtxls(toLongArray(idArray));
		return "common/action_succ";
	}


	/**
	 * 跳转至公共通讯录详细页面
	 * 
	 * @return 公共通讯录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/ggtxl/ggtxl_detail.htm", method = RequestMethod.GET)
	public String ggtxlDetail(long id, ModelMap map) {
		// 取得公共通讯录详细页面
		Ggtxl ggtxl = ggtxlService.getGgtxlInfo(id);
		map.put("ggtxl", ggtxl);
		return "ggtxl/ggtxl_detail";
	}
	/**
	 * 获取ggtxl对象
	 * 
	 * @return 
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/ggtxl/get_ggtxl.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getGgtxlDetail(long id, ModelMap map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 取得公共通讯录详细页面
		Ggtxl ggtxl = ggtxlService.getGgtxlInfo(id);
		return dataMap;
	}
	/**
	 * 跳转至公共通讯录更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/ggtxl/ggtxl_edit.htm")
	public String ggtxlEdit(GgtxlForm form, ModelMap map) {
		// 取得公共通讯录详细页面
		ggtxlService.editGgtxlInfo(setBeans(form));
		return "common/action_succ";
	}

	/**
	 * 公共通讯录更新
	 * 
	 * @return 公共通讯录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/ggtxl/ggtxl_edit.htm", method = RequestMethod.GET)
	public String ggtxlEdit(long id, ModelMap map) {
		// 取得公共通讯录详细页面
		Ggtxl ggtxl = ggtxlService.getGgtxlInfo(id);
		map.put("ggtxl", ggtxl);
		return "ggtxl/ggtxl_edit";
	}
	/**
	 * 查询公共通讯录
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/ggtxl/ggtxl_menu.htm")
	public String selectTxlggListByPage(GgtxlForm form, ModelMap map) {
		GgtxlPage ggtxlPage = new GgtxlPage(); // 分页对象
		setSearchKey(form, ggtxlPage); // 设置页面中的查询条件
		ggtxlPage.setIsmm("Y");
		GgtxlPage page = ggtxlService.getGgtxlAllList(ggtxlPage);
		// 跳转至公共通讯录申领表列表页面
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "ggtxl_menu");
		return "ggtxl/ggtxl_menu";
	}
	
	/**
	 * 查询紧急联系人
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/ggtxl/jjlxr_menu.htm")
	public String selectJjlxrListByPage(GgtxlForm form, ModelMap map) {
		GgtxlPage ggtxlPage = new GgtxlPage(); // 分页对象
		setSearchKey(form, ggtxlPage); // 设置页面中的查询条件
		ggtxlPage.setIsmm("N");
		GgtxlPage page = ggtxlService.getGgtxlAllList(ggtxlPage);
		// 跳转至公共通讯录申领表列表页面
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "jjlxr_menu");
		return "ggtxl/jjlxr_menu";
	}
	/**
	 * 查询公共通讯录
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping(value = "/ggtxl/txlgg_list.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<Ggtxl> selectTxlggListByPage(GgtxlForm form,String deptId) {
		GgtxlPage ggtxlPage = new GgtxlPage(); // 分页对象
		setSearchKey(form, ggtxlPage); // 设置页面中的查询条件
		ggtxlPage.setIsmm("Y");
		ggtxlPage.setTypeId(deptId);
		List<Ggtxl> ggtxlList = ggtxlService.getGgtxlAllList(ggtxlPage).getGgtxlList();
		// 跳转至公共通讯录申领表列表页面
		return ggtxlList;
	}
	/**
	 * 查询紧急联系人
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping(value = "/ggtxl/jjlxr_list.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<Ggtxl> selectJjlxrListByPage(GgtxlForm form,String deptId) {
		GgtxlPage ggtxlPage = new GgtxlPage(); // 分页对象
		setSearchKey(form, ggtxlPage); // 设置页面中的查询条件
		ggtxlPage.setIsmm("N");
		ggtxlPage.setTypeId(deptId);
		List<Ggtxl> ggtxlList = ggtxlService.getGgtxlAllList(ggtxlPage).getGgtxlList();
		// 跳转至公共通讯录申领表列表页面
		return ggtxlList;
	}
	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Ggtxl
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private Ggtxl setBeans(GgtxlForm form) {
		Ggtxl ggtxl = new Ggtxl();
		BeanUtils.copyProperties(form, ggtxl); // 复制表单至DO
		ggtxl.setEnabled(AddressBook.ABLED);// 设置记录为有效记录
		ggtxl.setLoginId(SecurityUtils.getLoginId()); // 设置登录通讯录Id
		ggtxl.setTypeId(userService.getUserInfoByLoginId(SecurityUtils.getLoginId()).getDeptId().toString());//根据登录ID查询部门ID
		ggtxl.setAddNamePy(PinyinUtil.toAbbLowPinyin(ggtxl.getAddName()));// 用户名转换成拼音
		return ggtxl;
	}

	/**
	 * 公共通讯录申领表列表页面设置查询条件
	 * 
	 * @param form
	 * @param GgtxlPage
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	private void setSearchKey(GgtxlForm form, GgtxlPage ggtxlPage) {
		ggtxlPage.setLoginId(SecurityUtils.getLoginId()); // 设置登录通讯录Id
		ggtxlPage.setAddName(form.getAddName());
		ggtxlPage.setUnitTel(form.getUnitTel());
		ggtxlPage.setCurrentPage(form.getCp()); // 当前页数

	}

}
