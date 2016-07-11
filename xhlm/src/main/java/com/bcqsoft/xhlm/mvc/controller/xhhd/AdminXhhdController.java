package com.bcqsoft.xhlm.mvc.controller.xhhd;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.Xhhd;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.XhhdPage;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;
import com.bcqsoft.xhlm.mvc.form.xhhd.XhhdForm;
import com.bcqsoft.xhlm.service.xhhd.XhhdService;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;


@Controller
public class AdminXhhdController {

	
	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private XhhdService xhhdService;	
	
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
	@RequestMapping("/admin/xhhd/list.htm")
	public String xhhdList(XhhdForm form, ModelMap map) {
		// 分类详细页对象初始化
		XhhdPage xhhdPage = new XhhdPage();
		// 设置查询条件
		setSearchKey(form, xhhdPage);
		// 取得分类详细列表,分页显示
		XhhdPage page = xhhdService.getXhhdInfoList(xhhdPage);
		String sortId=page.getSortId();
		map.put("page", page);
		map.put("sortId", sortId);
		// 跳转至类别详细列表页面
		return "admin/xhhd/xhhd_list";
	}

	/**
	 * 跳转至新增类别详细页面
	 * 
	 * @return 新增类别详细页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/xhhd/add_xhhd.htm", method = RequestMethod.GET)
	public String addXhhd(ModelMap map,XhhdForm form) {
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		return "admin/xhhd/add_xhhd";
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
	@RequestMapping("/admin/xhhd/add_xhhd.htm")
	public String addXhhd(XhhdForm form, ModelMap map) {
		// 追加类别详细
		xhhdService.createXhhd(setBeans(form));		
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
	@RequestMapping(value = "/admin/xhhd/edit_xhhd.htm", method = RequestMethod.GET)
	public String editXhhd(long id, ModelMap map) {
		// 取得要更新的仓库信息
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		Xhhd xhhd = xhhdService.getXhhdInfo(id);
		map.put("xhhd", xhhd);
		return "admin/xhhd/edit_xhhd";
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
	@RequestMapping("/admin/xhhd/edit_xhhd.htm")
	public String editXhhd(XhhdForm form, ModelMap map) {
		// 追加类别详细
		xhhdService.modifyXhhd(setBeans(form));
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
	@RequestMapping("/admin/xhhd/delete_xhhd.htm")
	public String deleteXhhd(long id) {
		// 删除类别详细
		xhhdService.deleteXhhd(id);
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
	@RequestMapping("/admin/xhhd/delete_xhhdArray.htm")
	public String removeXhhd(String idArray) {
		// 删除类别详细信息
		xhhdService.deleteXhhds(toLongArray(idArray));
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
	private void setSearchKey(XhhdForm form, XhhdPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle()); 
		page.setLoginId(SecurityUtils.getLoginId());//获取登录ID
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Xhhd
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private Xhhd setBeans(XhhdForm form) {
		Xhhd xhhd = new Xhhd();
		BeanUtils.copyProperties(form, xhhd); // 设置表单属性
		xhhd.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		xhhd.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return xhhd;
	}
}