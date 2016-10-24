package com.bcqsoft.sgoa.mvc.controller.index;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docin.dataobject.DocinPage;
import com.bcqsoft.sgoa.dao.docinbox.dataobject.DocinBox;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReview;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReviewPage;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.docin.DocinService;
import com.bcqsoft.sgoa.service.docinbox.DocinBoxService;

/**
 * App收文控制器
 * Author zy
 */
@Controller
public class AppDocinController {
	
	@Autowired private DocinService docinService;
	
	
	@Autowired private DocinBoxService docinBoxService;
	
	@Autowired private CommonService commonService;
	/**
	 * 通知查询列表
	 * @param map
	 * @return 信息页面模板
	 * @Author zy
	 * @Date 2016-10-17
	 */
	@ResponseBody
	@RequestMapping("/home/docin_search.htm")
	public Map<String,Object> bsReviewMyList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String title = request.getParameter("title") ;
		try {
			title = new String(title.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "1";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		DocinPage docin = new DocinPage();
		docin.setCurrentPage(Integer.parseInt(currentPage));
		docin.setPageSize(Integer.parseInt(pageSize));
		docin.setTitle(title);
		docin.setStatus(CommonChar.STATUS_FF);
		DocinPage docinPage = docinService.getDocinSearchList(docin);
		List<Docin> docinList = docinPage.getDocinList();
		retCode = docinList==null?"1":"0";
		message = docinList==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data",docinList);
		return map;
	}

	/**
	 * 点击查看通知表
	 * 
	 * @param id
	 * @param map
	 * @return 通知表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/home/docin/look_detail.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> docinBoxDetail(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// 获取当前登录ID
		String loginId = request.getParameter("loginId");
		Long id =Long.parseLong(request.getParameter("id"));
		Map<String,Object> resMap = new HashMap<String, Object>();
		List<DocinBox> docinBoxListForAll = docinBoxService
				.getAllDocinBoxListAll(id);
		resMap.put("docinBoxListForAll", docinBoxListForAll);

		Docin docin = docinService.getUserDraftDocinDetail(id);
		docin.setReceiverName(commonService.getUsersNameByLoginIds(docin.getReceiverId()));

		resMap.put("docin", docin);
		DocinReviewPage page = docinService.getDocinReviewListByIdQf(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		resMap.put("page", page);
		
		return resMap;

	}

}
