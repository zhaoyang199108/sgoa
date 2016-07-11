package com.bcqsoft.xhlm.mvc.controller.ptfwdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.ptfwdetail.dataobject.PtfwDetailPage;
import com.bcqsoft.xhlm.mvc.form.ptfwdetail.PtfwDetailForm;
import com.bcqsoft.xhlm.service.ptfwdetail.PtfwDetailService;


@Controller
public class AdminPtfwDetailController {

	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private PtfwDetailService ptfwdetailService;

	/**
	 * 查看类别详细信息列表
	 * 
	 * @param map
	 * @return 类别详细列表页面
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	@RequestMapping("/admin/ptfwdetail/list.htm")
	public String ptfwdetailList(PtfwDetailForm form, ModelMap map) {
		// 分类详细页对象初始化
		PtfwDetailPage ptfwdetailPage = new PtfwDetailPage();
		// 设置查询条件
		setSearchKey(form, ptfwdetailPage);
		// 取得分类详细列表,分页显示
		PtfwDetailPage page = ptfwdetailService.getPtfwDetailInfoList(ptfwdetailPage);		
		map.put("page", page);		
		// 跳转至类别详细列表页面
		return "admin/ptfwdetail/ptfwDetail_list";
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
	private void setSearchKey(PtfwDetailForm form, PtfwDetailPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle());
		page.setLoginId(SecurityUtils.getLoginId());// 获取登录ID
	}
}