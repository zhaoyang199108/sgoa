package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.Ggtxl;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.GgtxlPage;
import com.bcqsoft.sgoa.mvc.form.ggtxl.GgtxlForm;
import com.bcqsoft.sgoa.service.ggtxl.GgtxlService;

/**
 * App 公共通讯录申领表模块控制器
 * 
 * @author zy
 * 
 */
@Controller
public class AppGgtxlController {

	/**
	 * 公共通讯录申领表的业务逻辑层
	 */
	@Autowired
	private GgtxlService ggtxlService;

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
	@RequestMapping(value = "/home/ggtxl/txlgg_list.htm", method = RequestMethod.GET)
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
