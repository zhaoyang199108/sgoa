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

import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFile;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFilePage;
import com.bcqsoft.sgoa.service.resfile.ResFileService;
/*
 * APP知识库接口
 * */
@Controller
public class AppResFileController {
	private @Autowired ResFileService resFileService;
	/**
	 * 所有上传文件的列表页面
	 * 
	 * @param
	 * @param
	 * @return
	 * 
	 * @Author zy
	 * @Date 20161024
	 */
	@RequestMapping("/home/resFile/list.htm")
	@ResponseBody
	public Map<String,Object> resFileList(HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String loginId = request.getParameter("loginId");
		String retCode = "";
		String message = "";
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "1";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		ResFilePage resFilePage = new ResFilePage();
		resFilePage.setCurrentPage(Integer.parseInt(currentPage));
		resFilePage.setPageSize(Integer.parseInt(pageSize));
		resFilePage.setLoginId(loginId);
	//	setSearchKey(form, resFilePage); // 设置页面中的查询条件
		// 取得上传页面列表,分页显示
		ResFilePage page = resFileService.getResFileListByPage(resFilePage);
		List<ResFile> list = page.getResFileList();
		retCode = list==null?"1":"0";
		message = list==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data",list);
		return map;
	}

}
