package com.bcqsoft.xhlm.mvc.controller.xhxw;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.Xhxw;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.XhxwPage;
import com.bcqsoft.xhlm.dao.xwk.dataobject.Xwk;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.mvc.form.xhxw.XhxwForm;
import com.bcqsoft.xhlm.service.xhxw.XhxwService;
import com.bcqsoft.xhlm.service.xwk.XwkService;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;
import com.bcqsoft.xhlm.service.user.UserService;


@Controller
public class AdminXhxwController {

	
	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private XhxwService xhxwService;	
	
	/**
	 * 分类详细模块业务逻辑类接口
	 */
	@Autowired
	private SortdetailService sortdetailService;
	
	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private XwkService xwkService;	
	/**
	 * 分类详细模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 查看协会新闻信息列表
	 * 
	 * @param map
	 * @return 协会新闻列表页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhxw/list.htm")
	public String xhxwList(XhxwForm form, ModelMap map) {
		// 分类详细页对象初始化
		XhxwPage xhxwPage = new XhxwPage();
		// 设置查询条件
		setSearchKey(form, xhxwPage);
		// 取得分类详细列表,分页显示
		XhxwPage page = xhxwService.getXhxwInfoList(xhxwPage);
		String sortId=page.getSortId();		
		User user= new User();
		user = userService.getUserInfoByLoginId(SecurityUtils.getLoginId());
		map.put("page", page);
		map.put("sortId", sortId);
		map.put("user", user);
		// 跳转至协会新闻列表页面
		return "admin/xhxw/xhxw_list";
	}

	/**
	 * 跳转至新增协会新闻页面
	 * 
	 * @return 新增协会新闻页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/xhxw/add_xhxw.htm", method = RequestMethod.GET)
	public String addXhxw(ModelMap map,XhxwForm form) {
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		return "admin/xhxw/add_xhxw";
	}

	/**
	 * 协会新闻新增处理
	 * 
	 * @param map
	 * @return 新增协会新闻成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhxw/add_xhxw.htm")
	public String addXhxw(XhxwForm form, ModelMap map) {
		// 追加协会新闻
		xhxwService.createXhxw(setBeans(form));		
		return "admin/common/action_succ";
	}

	/**
	 * 发布协会新闻处理
	 * 
	 * @param map
	 * @return 新增协会新闻成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhxw/release_xhxw.htm")
	public String releaseXhxw(long id, ModelMap map) {
		Xwk xwk = xwkService.getXwkInfo(id);
		xhxwService.createXhxw(setBean(xwk));		
		return "admin/common/action_succ";
	}
	
	/**
	 * 跳转至更新协会新闻页面
	 * 
	 * @return 新增协会新闻页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/xhxw/edit_xhxw.htm", method = RequestMethod.GET)
	public String editXhxw(long id, ModelMap map) {
		// 取得要更新的仓库信息
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		Xhxw xhxw = xhxwService.getXhxwInfo(id);
		map.put("xhxw", xhxw);
		return "admin/xhxw/edit_xhxw";
	}

	/**
	 * 协会新闻更新处理
	 * 
	 * @param map
	 * @return 更新协会新闻成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhxw/edit_xhxw.htm")
	public String editXhxw(XhxwForm form, ModelMap map) {
		// 追加协会新闻
		xhxwService.modifyXhxw(setBeans(form));
		return "admin/common/action_succ";
	}

	/**
	 * 协会新闻删除处理
	 * 
	 * @param map
	 * @return 更新协会新闻成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xhxw/delete_xhxw.htm")
	public String deleteXhxw(long id) {
		// 删除协会新闻
		xhxwService.deleteXhxw(id);
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
	@RequestMapping("/admin/xhxw/delete_xhxwArray.htm")
	public String removeXhxw(String idArray) {
		// 删除协会新闻信息
		xhxwService.deleteXhxws(toLongArray(idArray));
		// 返回到操作成功页面
		return "admin/common/action_succ";
	}

	/**
	 * 协会新闻列表页面设置查询条件
	 * 
	 * @param form
	 * @param detailPage
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private void setSearchKey(XhxwForm form, XhxwPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle()); 
		page.setLoginId(SecurityUtils.getLoginId());//获取登录ID
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Xhxw
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private Xhxw setBeans(XhxwForm form) {
		Xhxw xhxw = new Xhxw();
		BeanUtils.copyProperties(form, xhxw); // 设置表单属性
		xhxw.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		xhxw.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return xhxw;
	}
	
	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Xhxw
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private Xhxw setBean(Xwk xwk) {
		Xhxw xhxw = new Xhxw();
		BeanUtils.copyProperties(xwk, xhxw); // 设置表单属性
		xhxw.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		xhxw.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return xhxw;
	}
}