package com.bcqsoft.xhlm.mvc.controller.xhfw;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;
import com.bcqsoft.xhlm.dao.xhfw.dataobject.Xhfw;
import com.bcqsoft.xhlm.dao.xhfw.dataobject.XhfwPage;
import com.bcqsoft.xhlm.mvc.form.xhfw.XhfwForm;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;
import com.bcqsoft.xhlm.service.xhfw.XhfwService;


@Controller
public class AdminXhfwController {

	
	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private XhfwService xhfwService;	
	
	/**
	 * 分类详细模块业务逻辑类接口
	 */
	@Autowired
	private SortdetailService sortdetailService;	
	
	/**
	 * 查看类别详细信息列表
	 * 
	 * @param map
	 * @return 类别详细列表页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhfw/list.htm")
	public String xhfwList(XhfwForm form, ModelMap map) {
		// 分类详细页对象初始化
		XhfwPage xhfwPage = new XhfwPage();
		// 设置查询条件
		setSearchKey(form, xhfwPage);
		// 取得分类详细列表,分页显示
		XhfwPage page = xhfwService.getXhfwInfoList(xhfwPage);
		String sortId=page.getSortId();
		map.put("page", page);
		map.put("sortId", sortId);
		// 跳转至类别详细列表页面
		return "admin/xhfw/xhfw_list";
	}

	/**
	 * 跳转至新增类别详细页面
	 * 
	 * @return 新增类别详细页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/xhfw/add_xhfw.htm", method = RequestMethod.GET)
	public String addXhfw(ModelMap map,XhfwForm form) {
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		return "admin/xhfw/add_xhfw";
	}

	/**
	 * 类别详细新增处理
	 * 
	 * @param map
	 * @return 新增类别详细成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhfw/add_xhfw.htm")
	public String addXhfw(XhfwForm form, ModelMap map) {
		// 追加类别详细
		xhfwService.createXhfw(setBeans(form));		
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至更新类别详细页面
	 * 
	 * @return 新增类别详细页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/xhfw/edit_xhfw.htm", method = RequestMethod.GET)
	public String editXhfw(long id, ModelMap map) {
		// 取得要更新的仓库信息
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		Xhfw xhfw = xhfwService.getXhfwInfo(id);
		map.put("xhfw", xhfw);
		return "admin/xhfw/edit_xhfw";
	}

	/**
	 * 类别详细更新处理
	 * 
	 * @param map
	 * @return 更新类别详细成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhfw/edit_xhfw.htm")
	public String editXhfw(XhfwForm form, ModelMap map) {
		// 追加类别详细
		xhfwService.modifyXhfw(setBeans(form));
		return "admin/common/action_succ";
	}

	/**
	 * 类别详细删除处理
	 * 
	 * @param map
	 * @return 更新类别详细成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhfw/delete_xhfw.htm")
	public String deleteXhfw(long id) {
		// 删除类别详细
		xhfwService.deleteXhfw(id);
		return "admin/common/action_succ";
	}

	/**
	 * 删除仓库(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhfw/delete_xhfwArray.htm")
	public String removeXhfw(String idArray) {
		// 删除类别详细信息
		xhfwService.deleteXhfws(toLongArray(idArray));
		// 返回到操作成功页面
		return "admin/common/action_succ";
	}

	/**
	 * 类别详细列表页面设置查询条件
	 * 
	 * @param form
	 * @param detailPage
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private void setSearchKey(XhfwForm form, XhfwPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle()); 
		page.setLoginId(SecurityUtils.getLoginId());//获取登录ID
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Xhfw
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private Xhfw setBeans(XhfwForm form) {
		Xhfw xhfw = new Xhfw();
		BeanUtils.copyProperties(form, xhfw); // 设置表单属性
		xhfw.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		xhfw.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return xhfw;
	}
}