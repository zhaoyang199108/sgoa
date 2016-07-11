package com.bcqsoft.xhlm.mvc.controller.xhfwdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetailPage;
import com.bcqsoft.xhlm.mvc.form.xhfwdetail.XhfwDetailForm;
import com.bcqsoft.xhlm.service.xhfwdetail.XhfwDetailService;


@Controller
public class AdminXhfwDetailController {

	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private XhfwDetailService xhfwdetailService;

	/**
	 * 查看类别详细信息列表
	 * 
	 * @param map
	 * @return 类别详细列表页面
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	@RequestMapping("/admin/xhfwdetail/list.htm")
	public String xhfwdetailList(XhfwDetailForm form, ModelMap map) {
		// 分类详细页对象初始化
		XhfwDetailPage xhfwdetailPage = new XhfwDetailPage();
		// 设置查询条件
		setSearchKey(form, xhfwdetailPage);
		// 取得分类详细列表,分页显示
		XhfwDetailPage page = xhfwdetailService.getXhfwDetailInfoList(xhfwdetailPage);		
		map.put("page", page);		
		// 跳转至类别详细列表页面
		return "admin/xhfwdetail/xhfwDetail_list";
	}

	/**
	 * 类别详细列表页面设置查询条件
	 * 
	 * @param form
	 * @param detailPage
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	private void setSearchKey(XhfwDetailForm form, XhfwDetailPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle());
		page.setLoginId(SecurityUtils.getLoginId());// 获取登录ID
	}
}