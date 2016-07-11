package com.bcqsoft.xhlm.mvc.controller.pthddetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.pthddetail.dataobject.PthdDetailPage;
import com.bcqsoft.xhlm.mvc.form.pthddetail.PthdDetailForm;
import com.bcqsoft.xhlm.service.pthddetail.PthdDetailService;


@Controller
public class AdminPthdDetailController {

	/**
	 * 活动报名模块业务逻辑类接口
	 */
	@Autowired
	private PthdDetailService pthddetailService;

	/**
	 * 查看活动报名详细信息列表
	 * 
	 * @param map
	 * @return 活动报名详细列表页面
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	@RequestMapping("/admin/pthddetail/list.htm")
	public String pthddetailList(PthdDetailForm form, ModelMap map) {
		// 分类详细页对象初始化
		PthdDetailPage pthddetailPage = new PthdDetailPage();
		// 设置查询条件
		setSearchKey(form, pthddetailPage);
		// 取得分类详细列表,分页显示
		PthdDetailPage page = pthddetailService.getPthdDetailInfoList(pthddetailPage);		
		map.put("page", page);		
		// 跳转至活动报名详细列表页面
		return "admin/pthddetail/pthdDetail_list";
	}

	/**
	 * 活动报名详细列表页面设置查询条件
	 * 
	 * @param form
	 * @param detailPage
	 * 
	 * @Author lzn
	 * @Date 2016-03-21
	 */
	private void setSearchKey(PthdDetailForm form, PthdDetailPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle());
		page.setLoginId(SecurityUtils.getLoginId());// 获取登录ID
	}
}