package com.bcqsoft.xhlm.mvc.controller.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.xhlm.common.util.MapDistanceUtil;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.Sortdetail;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.dao.user.dataobject.UsersPage;
import com.bcqsoft.xhlm.dao.xhfw.dataobject.Xhfw;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetail;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetailPage;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.Xhhd;
import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetail;
import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetailPage;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.Xhxw;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;
import com.bcqsoft.xhlm.service.user.UserService;
import com.bcqsoft.xhlm.service.xhfw.XhfwService;
import com.bcqsoft.xhlm.service.xhfwdetail.XhfwDetailService;
import com.bcqsoft.xhlm.service.xhhd.XhhdService;
import com.bcqsoft.xhlm.service.xhhddetail.XhhdDetailService;
import com.bcqsoft.xhlm.service.xhxw.XhxwService;


/**
 * 前台首页模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class XhIndexController {
	
	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 协会新闻业务逻辑类接口
	 */
	@Autowired
	private XhxwService xhxwService;	
	
	/**
	 * 协会活动模块业务逻辑类接口
	 */
	@Autowired
	private XhhdService xhhdService;	
	
	/**
	 * 协会服务模块业务逻辑类接口
	 */
	@Autowired
	private XhfwService xhfwService;	
	
	/**
	 * 活动报名模块业务逻辑类接口
	 */
	@Autowired
	private XhhdDetailService xhhddetailService;
	
	/**
	 * 服务报名模块业务逻辑类接口
	 */
	@Autowired
	private XhfwDetailService xhfwdetailService;
	
	/**
	 * 服务报名模块业务逻辑类接口
	 */
	@Autowired
	private SortdetailService sortdetailService;
	
	/**
	 * 协会主页（标题）接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_zy_title.htm")
	public Map<String,Object> xhzytitleInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		String retCode = loginUser==null?"1":"0";
		String message = loginUser==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("title", loginUser.getUserName());
		map.put("data", data);
		return map;
	}
	
	/**
	 * 协会主页（banner）接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_zy_banner.htm")
	public Map<String,Object> xhzybannerInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		String retCode = loginUser==null?"1":"0";
		String message = loginUser==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("banner", loginUser.getBanner());
		map.put("data", data);
		return map;
	}
	
	/**
	 * 协会主页根据LOGIN_ID查询协会的行业新闻列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_data_list.htm")
	public Map<String,Object> oneXhxw(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String loginId = request.getParameter("loginId");
		List<Xhxw> xhxwList = xhxwService.getXhxwInfoListByLoginId(loginId);
		String retCode = xhxwList==null?"1":"0";
		String message = xhxwList==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		
		// 协会活动
		List<Xhhd> xhhdList = xhhdService.getXhhdInfoListByLoginId(loginId);
		// 协会服务
		List<Xhfw> xhfwList = xhfwService.getXhfwInfoListByLoginId(loginId);
		// 设置列表数据
		Map<String,Object> mapList = new HashMap<String,Object>();
		mapList.put("news", xhxwList);
		mapList.put("union", xhhdList);
		mapList.put("service", xhfwList);
		map.put("data", mapList);
		return map;
	}
	
	/**
	 * 协会主页根据LOGIN_ID查询协会的行业新闻列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_xhxw_list.htm")
	public Map<String,Object> xhXhxw(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String loginId = request.getParameter("loginId");
		List<Xhxw> xhxwList = xhxwService.getXhxwInfoListByLoginId(loginId);
		String retCode = xhxwList==null?"1":"0";
		String message = xhxwList==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data", xhxwList);
		return map;
	}
	
	/**
	 * 协会主页根据LOGIN_ID查询协会的协会活动列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_xhhd_list.htm")
	public Map<String,Object> oneXhdd(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会活动列表
		String loginId = request.getParameter("loginId");
		List<Xhhd> xhhdList = xhhdService.getXhhdInfoListByLoginId(loginId);
		String retCode = xhhdList==null?"1":"0";
		String message = xhhdList==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data", xhhdList);
		return map;
	}
	
	/**
	 * 协会主页根据LOGIN_ID查询协会的协会服务列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_xhfw_list.htm")
	public Map<String,Object> oneXhfw(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会服务列表
		String loginId = request.getParameter("loginId");
		List<Xhfw> xhfwList = xhfwService.getXhfwInfoListByLoginId(loginId);
		String retCode = xhfwList==null?"1":"0";
		String message = xhfwList==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data", xhfwList);
		return map;
	}
	
	/**
	 * 协会详情页接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_detail.htm")
	public Map<String,Object> xhdetailInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会详情列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		String retCode = loginUser==null?"1":"0";
		String message = loginUser==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data", loginUser);
		return map;
	}
	
	/**
	 * 协会会员页（标题）接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_hy_list.htm")
	public Map<String,Object> xhhytitleInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		UsersPage page = new UsersPage();
		page.setDeptId(String.valueOf(loginUser.getId()));
		String cPage = request.getParameter("cp");
		page.setPageSize(10);
		page.setCurrentPage(Integer.valueOf(cPage == null ? "1" : cPage));
		UsersPage usersPage = userService.getHomeUserInfoListByXhNew(page);
		String retCode = usersPage.getUserList()==null?"1":"0";
		String message = usersPage.getUserList()==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data", usersPage.getUserList());
		return map;
	}
	
	/**
	 * 协会会员页详情接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_hy_info.htm")
	public Map<String,Object> xhhybannerInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		String retCode = loginUser==null?"1":"0";
		String message = loginUser==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data", loginUser);
		return map;
	}
	
	/**
	 * 协会会员页协会会员接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xhhy.htm")
	public Map<String,Object> xhhy(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		UsersPage page = new UsersPage();
		page.setPageSize(100);
		page.setDeptId(String.valueOf(loginUser.getId()));
		UsersPage usersPage = userService.getHomeUserInfoListByXhNew(page);
		List<User> userList = usersPage.getUserList();
		String retCode = userList==null?"1":"0";
		String message = userList==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data", userList);
		return map;
	}
	
	/**
	 * 企业详情页接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/qy_detail.htm")
	public Map<String,Object> qydetailInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会详情列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		String retCode = loginUser==null?"1":"0";
		String message = loginUser==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data", loginUser);
		return map;
	}
	
	/**
	 * 活动页接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/bmxhhd_list.htm")
	public Map<String,Object> xhdd(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会活动列表
		String xhhdId = request.getParameter("id");
		Xhhd xhhd = xhhdService.getXhhdInfo(Long.valueOf(xhhdId));
		XhhdDetailPage page = new XhhdDetailPage();
		page.setPageSize(100);
		page.setXhhdId(Long.valueOf(xhhdId));
		XhhdDetailPage xhhddetailPage = xhhddetailService.getXhhdDetailInfoListByXhhdId(page);
		List<XhhdDetail> xhhdDetailList = xhhddetailPage.getXhhdDetailList();
		String retCode = xhhd==null?"1":"0";
		String message = xhhd==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data1", xhhd);
		map.put("data2", xhhdDetailList);
		map.put("totalRow", xhhddetailPage.getTotalRow());
		return map;
	}
	
	/**
	 * 服务页接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/bmxhfw_list.htm")
	public Map<String,Object> xhfw(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会服务列表
		String xhfwId = request.getParameter("xhfwId");
		Xhfw xhfw = xhfwService.getXhfwInfo(Long.valueOf(xhfwId));
		XhfwDetailPage page = new XhfwDetailPage();
		page.setPageSize(100);
		page.setXhfwId(Long.valueOf(xhfwId));
		XhfwDetailPage xhfwdetailPage = xhfwdetailService.getXhwfDetailInfoListByXhhdId(page);
		List<XhfwDetail> xhfwDetailList = xhfwdetailPage.getXhfwDetailList();
		String retCode = xhfw==null?"1":"0";
		String message = xhfw==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data1", xhfw);
		map.put("data2", xhfwDetailList);
		map.put("totalRow", xhfwdetailPage.getTotalRow());
		return map;
	}
	
	/**
	 * 分类页（各分类子类）接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xhfl_list.htm")
	public Map<String,Object> fl(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		String type = request.getParameter("type");
		// 按类别区分分类查询 1、定位。2、行业。3、地区
		List<User> userList = new ArrayList<User>();
		List<User> userListRes = new ArrayList<User>();
		if ("1".equals(type)) {
			String jdObj = request.getParameter("jd");
			String wdObj = request.getParameter("wd");
			UsersPage page = new UsersPage();
			page.setPageSize(100);
			UsersPage usersPage = userService.getHomeUserInfoListByFl(page);
			List<User> userObjList = usersPage.getUserList();
			for (User userObj : userObjList) {
				userObj.setDistance(MapDistanceUtil.getDistance(jdObj, wdObj, userObj.getJd(), userObj.getWd()));
				userList.add(userObj);
			}
		} else if ("2".equals(type)) {
			String sortId = request.getParameter("sortId");
			UsersPage page = new UsersPage();
			page.setPageSize(100);
			page.setSortId(sortId);
			UsersPage usersPage = userService.getHomeUserInfoListByFl(page);
			userList = usersPage.getUserList();
		} else if ("3".equals(type)) {
			String s_province = request.getParameter("s_province");
			String s_city = request.getParameter("s_city");
			String s_county = request.getParameter("s_county");
			UsersPage page = new UsersPage();
			page.setPageSize(100);
			if (s_province != null && "".equals(s_province)) {
				page.setS_province(s_province);
			}
			if (s_city != null && "".equals(s_city)) {
				page.setS_county(s_county);
			}
			if (s_county != null && "".equals(s_county)) {
				page.setS_city(s_city);
			}
			UsersPage usersPage = userService.getHomeUserInfoListByFl(page);
			userList = usersPage.getUserList();
		} else if ("4".equals(type)) {
			String productId = request.getParameter("productId");
			UsersPage page = new UsersPage();
			page.setPageSize(100);
			page.setProductId(productId);
			UsersPage usersPage = userService.getHomeUserInfoListByFl(page);
			userList = usersPage.getUserList();
		} else if ("5".equals(type)) {
			String userName = request.getParameter("userName");
			UsersPage page = new UsersPage();
			page.setPageSize(100);
			page.setUserName(userName);
			UsersPage usersPage = userService.getHomeUserInfoListByFl(page);
			userList = usersPage.getUserList();
		}
		//查询协会下企业数量
		for (User user : userList) {
			UsersPage qypage = new UsersPage();
			qypage.setDeptId(String.valueOf(user.getId()));
			UsersPage qyPages = userService.getHomeUserInfoListByXhNew(qypage);
			user.setDeptCount(qyPages.getTotalRow());
			userListRes.add(user);
		}
		String retCode = userListRes==null?"1":"0";
		String message = userListRes==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data", userListRes);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 行业与产品分类接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_sort_list.htm")
	public Map<String,Object> xhSortList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会服务列表
		String type = request.getParameter("type");
		Sortdetail sortdetail = new Sortdetail();
		if ("1".equals(type)) {
			sortdetail.setSortId("2");
		} else if ("2".equals(type)) {
			sortdetail.setSortId("3");
		}
		
		List<Sortdetail> sortDetailList = sortdetailService.getSortdetailList(sortdetail);
		String retCode = sortDetailList == null?"1":"0";
		String message = sortDetailList == null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data", sortDetailList);
		return map;
	}
	
}
