package com.bcqsoft.xhlm.mvc.controller.xhtm;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.xhtm.dataobject.Xhtm;
import com.bcqsoft.xhlm.dao.xhtm.dataobject.XhtmPage;
import com.bcqsoft.xhlm.mvc.form.xhtm.XhtmForm;
import com.bcqsoft.xhlm.service.xhtm.XhtmService;

@Controller
public class AdminXhtmController {

	/**
	 * 协会条目模块业务逻辑类接口
	 */
	@Autowired
	private XhtmService xhtmService;
	
	/**
	 * 查看协会条目信息列表
	 * 
	 * @param map
	 * @return 协会条目列表页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/xhtm/list.htm")
	public String xhtmList(XhtmForm form, ModelMap map) {
		// 协会条目分页对象初始化
		XhtmPage xhtmsPage = new XhtmPage();
		xhtmsPage.setLoginId(SecurityUtils.getLoginId());
		// 设置查询条件
		setSearchKey(form, xhtmsPage);
		// 取得协会条目列表,分页显示
		XhtmPage page = xhtmService.getXhtmInfoList(xhtmsPage);
		map.put("page", page);
		// 跳转至协会条目列表页面
		return "admin/xhtm/xhtm_list";
	}

	/**
	 * 跳转至新增协会条目页面
	 * 
	 * @return 新增协会条目页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping(value = "/admin/xhtm/add_xhtm.htm", method = RequestMethod.GET)
	public String addXhtm(ModelMap map) {
		return "admin/xhtm/add_xhtm";
	}

	/**
	 * 协会条目新增处理
	 * 
	 * @param map
	 * @return 新增协会条目成功页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/xhtm/add_xhtm.htm")
	public String addXhtm(XhtmForm form, ModelMap map) {
		// 追加协会条目
		xhtmService.createXhtm(setBeans(form));
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至更新协会条目页面
	 * 
	 * @return 新增协会条目页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping(value = "/admin/xhtm/edit_xhtm.htm", method = RequestMethod.GET)
	public String editXhtm(long id, ModelMap map) {
		// 取得要更新的仓库信息
		Xhtm xhtm = xhtmService.getXhtmInfo(id);
		map.put("xhtm", xhtm);
		return "admin/xhtm/edit_xhtm";
	}

	/**
	 * 协会条目更新处理
	 * 
	 * @param map
	 * @return 更新协会条目成功页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/xhtm/edit_xhtm.htm")
	public String editXhtm(XhtmForm form, ModelMap map) {
		// 追加协会条目
		xhtmService.modifyXhtm(setBean(form));
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至协会条目详细页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-9-12
	 */
	@RequestMapping(value = "/admin/xhtm/detail.htm", method = RequestMethod.GET)
	public String detailOrgan(Long id, ModelMap map) {
		map.put("xhtm", xhtmService.getXhtmInfo(id));
		return "admin/xhtm/detail_xhtm";
	}

	/**
	 * 协会条目删除处理
	 * 
	 * @param map
	 * @return 更新协会条目成功页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/xhtm/delete_xhtm.htm")
	public String deleteXhtm(long id) {
		// 删除协会条目
		xhtmService.deleteXhtm(id);
		return "admin/common/action_succ";
	}

	/**
	 * 删除仓库(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/xhtm/delete_xhtmArray.htm")
	public String removeXhtm(String idArray) {
		// 删除协会条目信息
		xhtmService.deleteXhtms(toLongArray(idArray));
		// 返回到操作成功页面
		return "admin/common/action_succ";
	}

	/**
	 * 协会条目列表页面设置查询条件
	 * 
	 * @param form
	 * @param xhtmPage
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	private void setSearchKey(XhtmForm form, XhtmPage xhtmPage) {
		// 设置查询条件
		xhtmPage.setCurrentPage(form.getCp()); // 当前页数
		xhtmPage.setTmname(form.getTmname()); // 条目
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Xhtm
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	private Xhtm setBeans(XhtmForm form) {
		Xhtm xhtm = new Xhtm();
		BeanUtils.copyProperties(form, xhtm); // 设置表单属性
		xhtm.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		xhtm.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return xhtm;
	}
	
	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Xhtm
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	private Xhtm setBean(XhtmForm form) {
		Xhtm xhtm = new Xhtm();
		BeanUtils.copyProperties(form, xhtm); // 设置表单属性
		xhtm.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		return xhtm;
	}
}
