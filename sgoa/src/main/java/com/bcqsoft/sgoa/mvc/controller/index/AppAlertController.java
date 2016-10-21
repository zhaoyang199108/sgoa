package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.dao.alert.dataobject.Alert;
import com.bcqsoft.sgoa.dao.alert.dataobject.AlertPage;
import com.bcqsoft.sgoa.service.alert.AlertService;
/*
 * App备忘录控制器
 * */
@Controller
public class AppAlertController {
	@Autowired
	private AlertService alertService;

	/**
	 * 备忘录
	 * 
	 * @return 审批流程查询页面
	 * 
	 * 
	 * @author zy
	 * @Date 20161021
	 */
	@RequestMapping("/home/alert/alert_list.htm")
	@ResponseBody
	public Map<String,Object> selectAlertListByPage(HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String loginId = request.getParameter("loginId");
		String title = request.getParameter("title");
		String retCode = "";
		String message = "";
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "20";
		}
		AlertPage alertPage = new AlertPage();
		alertPage.setCurrentPage(Integer.parseInt(currentPage));
		alertPage.setPageSize(Integer.parseInt(pageSize));
		alertPage.setTitle(title);
		alertPage.setLoginId(loginId);
		AlertPage page = alertService.getAlertList(alertPage);
		List<Alert> list = page.getAlertList();
		retCode = list==null?"0":"0";
		message = list==null?"取得成功":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", list);
		return resMap;
	}
}
