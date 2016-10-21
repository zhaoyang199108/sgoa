package com.bcqsoft.sgoa.mvc.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFile;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFilePage;
import com.bcqsoft.sgoa.mvc.form.netfile.NetFileForm;
import com.bcqsoft.sgoa.service.netfile.NetFileService;
@Controller
public class AppNetFileController {
	private @Autowired NetFileService netFileService;
	/**
	 * 所有上传文件的列表页面
	 * 
	 * @param
	 * @param
	 * @return
	 * 
	 * @Author zy
	 * @Date 20161020
	 */
	@RequestMapping("/home/netFile/list.htm")
	@ResponseBody
	public Map<String,Object> netFileList(HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String title = request.getParameter("title");
		String loginId = request.getParameter("loginId");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		NetFilePage netFilePage = new NetFilePage();
		netFilePage.setCurrentPage(Integer.parseInt(currentPage));
		netFilePage.setPageSize(Integer.parseInt(pageSize));
		netFilePage.setTitle(title);
		netFilePage.setLoginId(loginId);
		NetFilePage page = netFileService.getNetFileListByPage(netFilePage);
		List<NetFile> list = page.getNetFileList();
		retCode = list==null?"0":"0";
		message = list==null?"取得成功":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", list);
		return resMap;
	}
	/**
	 * 被共享的页面（可下载）
	 * 
	 * @param
	 * @param
	 * @return 被共享的页面列表页面
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/home/netFile/shareDownList.htm")
	@ResponseBody
	public Map<String,Object> netShareDownList(HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String title = request.getParameter("title");
		String loginId = request.getParameter("loginId");
		if (currentPage == null || "".equals(currentPage)) {
			currentPage = "1";
		}
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		NetFilePage netFilePage = new NetFilePage(); // 分页对象
		netFilePage.setCurrentPage(Integer.parseInt(currentPage));
		netFilePage.setPageSize(Integer.parseInt(pageSize));
		netFilePage.setTitle(title);
		netFilePage.setLoginId(loginId);
		// 取得列表,分页显示
		NetFilePage page = netFileService
				.getNetFileDownShareListByPage(netFilePage);
		List<NetFile> list = page.getNetFileList();
		retCode = list==null?"0":"0";
		message = list==null?"取得成功":"取得成功";
		Map<String,Object>  resMap = new HashMap<String, Object>();
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		resMap.put("data", list);
		return resMap;
	}

}
