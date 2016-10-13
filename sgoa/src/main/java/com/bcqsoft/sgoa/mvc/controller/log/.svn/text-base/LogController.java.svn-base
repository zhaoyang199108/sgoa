package com.bcqsoft.sgoa.mvc.controller.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcqsoft.sgoa.dao.optlog.dataobject.page.OptLogPage;
import com.bcqsoft.sgoa.mvc.form.optlog.OptLogForm;
import com.bcqsoft.sgoa.service.optlog.OptLogService;

/**
 * 日志模块控制器
 * 
 * @author Bcqsoft.com sbq
 * 
 */
@Controller
public class LogController {
	/**
	 * 日志的业务逻辑层
	 */
	@Autowired
	private OptLogService optLogService;
	
	/**
	 * 取得有效的登录日志列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/log/optLog_list.htm")
	public String selectLogListByPage(OptLogForm form, ModelMap map) {
		OptLogPage optLogPage = new OptLogPage(); // 分页对象
		setSearchKey(form, optLogPage); // 设置页面中的查询条件
		// 取得操作日志列表,分页显示
		OptLogPage page = optLogService.findOptLogList(optLogPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "optLog_list");
		// 跳转至操作日志列表页面
		return "optlog/optLog_list";
	}
	
	
	/**
	 * 通讯录列表页面设置查询条件
	 * 
	 * @param form
	 * @param AddressBookPage
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	private void setSearchKey(OptLogForm form, OptLogPage optLogPage) {
		// 设置查询条件
		optLogPage.setCurrentPage(form.getCp()); // 当前页数		
		optLogPage.setStartTime(form.getStartTime());//开始时间
		optLogPage.setEndTime(form.getEndTime());//结束时间

	}
}
