package com.bcqsoft.xhlm.mvc.controller.xwk;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.xwk.dataobject.Xwk;
import com.bcqsoft.xhlm.dao.xwk.dataobject.XwkPage;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.mvc.form.xwk.XwkForm;
import com.bcqsoft.xhlm.service.xwk.XwkService;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;
import com.bcqsoft.xhlm.service.user.UserService;


@Controller
public class AdminXwkController {

	
	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private XwkService xwkService;	
	
	/**
	 * 分类详细模块业务逻辑类接口
	 */
	@Autowired
	private SortdetailService sortdetailService;
	
	/**
	 * 分类详细模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 查看新闻库信息列表
	 * 
	 * @param map
	 * @return 新闻库列表页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xwk/list.htm")
	public String xwkList(XwkForm form, ModelMap map) {
		// 分类详细页对象初始化
		XwkPage xwkPage = new XwkPage();
		// 设置查询条件
		setSearchKey(form, xwkPage);
		// 取得分类详细列表,分页显示
		XwkPage page = xwkService.getXwkInfoList(xwkPage);
		String sortId=page.getSortId();
		User user= new User();
		user = userService.getUserInfoByLoginId(SecurityUtils.getLoginId());
		map.put("page", page);
		map.put("sortId", sortId);
		map.put("user", user);
		// 跳转至新闻库列表页面
		return "admin/xwk/xwk_list";
	}

	/**
	 * 跳转至新增新闻库页面
	 * 
	 * @return 新增新闻库页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/xwk/add_xwk.htm", method = RequestMethod.GET)
	public String addXwk(ModelMap map,XwkForm form) {
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		return "admin/xwk/add_xwk";
	}

	/**
	 * 新闻库新增处理
	 * 
	 * @param map
	 * @return 新增新闻库成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xwk/add_xwk.htm")
	public String addXwk(XwkForm form, ModelMap map) {
		// 追加新闻库
		xwkService.createXwk(setBeans(form));		
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至更新新闻库页面
	 * 
	 * @return 新增新闻库页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/xwk/edit_xwk.htm", method = RequestMethod.GET)
	public String editXwk(long id, ModelMap map) {
		// 取得要更新的仓库信息
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		Xwk xwk = xwkService.getXwkInfo(id);
		map.put("xwk", xwk);
		return "admin/xwk/edit_xwk";
	}

	/**
	 * 新闻库更新处理
	 * 
	 * @param map
	 * @return 更新新闻库成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xwk/edit_xwk.htm")
	public String editXwk(XwkForm form, ModelMap map) {
		// 追加新闻库
		xwkService.modifyXwk(setBeans(form));
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至查看新闻库页面
	 * 
	 * @return 查看新闻库页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/xwk/detail_xwk.htm", method = RequestMethod.GET)
	public String detailXwk(long id, ModelMap map) {
		// 取得要更新的仓库信息
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		Xwk xwk = xwkService.getXwkInfo(id);
		map.put("xwk", xwk);
		return "admin/xwk/detail_xwk";
	}
	
	/**
	 * 新闻库删除处理
	 * 
	 * @param map
	 * @return 更新新闻库成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/xwk/delete_xwk.htm")
	public String deleteXwk(long id) {
		// 删除新闻库
		xwkService.deleteXwk(id);
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
	@RequestMapping("/admin/xwk/delete_xwkArray.htm")
	public String removeXwk(String idArray) {
		// 删除新闻库信息
		xwkService.deleteXwks(toLongArray(idArray));
		// 返回到操作成功页面
		return "admin/common/action_succ";
	}

	/**
	 * 新闻库列表页面设置查询条件
	 * 
	 * @param form
	 * @param detailPage
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private void setSearchKey(XwkForm form, XwkPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle()); 
		//page.setLoginId(SecurityUtils.getLoginId());//获取登录ID
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Xwk
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private Xwk setBeans(XwkForm form) {
		Xwk xwk = new Xwk();
		BeanUtils.copyProperties(form, xwk); // 设置表单属性
		xwk.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		xwk.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return xwk;
	}
}