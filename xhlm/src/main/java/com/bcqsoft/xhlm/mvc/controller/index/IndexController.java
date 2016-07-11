package com.bcqsoft.xhlm.mvc.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.dao.user.dataobject.UsersPage;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.Xhhd;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.XhhdPage;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.Xhxw;
import com.bcqsoft.xhlm.dao.xhxw.dataobject.XhxwPage;
import com.bcqsoft.xhlm.service.user.UserService;
import com.bcqsoft.xhlm.service.xhhd.XhhdService;
import com.bcqsoft.xhlm.service.xhxw.XhxwService;


/**
 * 前台首页模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class IndexController {
	
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
	 * 首页显示3条数
	 */
	public static final Integer TWO_NUMBER = 2;
	
	/**
	 * 首页显示3条数
	 */
	public static final Integer THREE_NUMBER = 3;
	
	/**
	 * 首页显示5条数
	 */
	public static final Integer FIVE_NUMBER = 5;
	
	/**
	 * 首页显示12条数
	 */
	public static final Integer TWELVE_NUMBER = 12;
	
	/**
	 * 推荐协会banner图接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/tj_banner.htm")
	public Map<String,Object> tjBanner(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		UsersPage page = new UsersPage();
		page.setPageSize(THREE_NUMBER);
		page.setTj(1);
		page.setType(1);
		UsersPage usersPage = userService.getHomeUserInfoListByXh(page);
		List<User> userList = usersPage.getUserList();
		String retCode = userList==null?"1":"0";
		String message = userList==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data", userList);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 首页列表数据接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/data_list.htm")
	public Map<String,Object> dataList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		XhxwPage page = new XhxwPage();
		page.setPageSize(FIVE_NUMBER);
		XhxwPage xhxwPage = xhxwService.getXhxwInfoListByHome(page);
		List<Xhxw> xhxwList = xhxwPage.getXhxwList();
		String retCode = xhxwList==null?"1":"0";
		String message = xhxwList==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		
		// 设置列表数据
		Map<String,Object> mapList = new HashMap<String,Object>();
		mapList.put("news", xhxwList);
		XhhdPage xhpage = new XhhdPage();
		xhpage.setPageSize(TWO_NUMBER);
		XhhdPage xhhdPage = xhhdService.getXhhdInfoListByHome(xhpage);
		List<Xhhd> xhhdList = xhhdPage.getXhhdList();
		mapList.put("union", xhhdList);
		
		UsersPage tjxhpage = new UsersPage();
		tjxhpage.setPageSize(TWELVE_NUMBER);
		tjxhpage.setType(1);
		tjxhpage.setTj(1);
		UsersPage usersPagetjxh = userService.getHomeUserInfoListByXh(tjxhpage);
		List<User> userListTjxh = usersPagetjxh.getUserList();
		mapList.put("activity", userListTjxh);
		
		UsersPage xrxhpage = new UsersPage();
		xrxhpage.setPageSize(FIVE_NUMBER);
		xrxhpage.setType(1);
		UsersPage usersPagexrxh = userService.getHomeUserInfoListByXhNew(xrxhpage);
		List<User> userList = usersPagexrxh.getUserList();
		mapList.put("newunion", userList);
		
		map.put("data", mapList);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 行业新闻（协会新闻）接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xhxw_list.htm")
	public Map<String,Object> xhxwList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		XhxwPage page = new XhxwPage();
		String cPage = request.getParameter("cp");
		page.setPageSize(FIVE_NUMBER);
		page.setCurrentPage(Integer.valueOf(cPage == null ? "1" : cPage));
		XhxwPage xhxwPage = xhxwService.getXhxwInfoListByHome(page);
		List<Xhxw> xhxwList = xhxwPage.getXhxwList();
		String retCode = xhxwList==null?"1":"0";
		String message = xhxwList==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data", xhxwList);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 推荐协会接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/tjxh_list.htm")
	public Map<String,Object> tjxhList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		UsersPage tjxhpage = new UsersPage();
		String cPage = request.getParameter("cp");
		tjxhpage.setCurrentPage(Integer.valueOf(cPage == null ? "1" : cPage));
		tjxhpage.setPageSize(FIVE_NUMBER);
		tjxhpage.setType(1);
		tjxhpage.setTj(1);
		UsersPage usersPagetjxh = userService.getHomeUserInfoListByXh(tjxhpage);
		List<User> userListTjxh = usersPagetjxh.getUserList();
		String retCode = userListTjxh==null?"1":"0";
		String message = userListTjxh==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data", userListTjxh);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 协会活动接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xhhd_list.htm")
	public Map<String,Object> xhhdList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		
		XhhdPage xhpage = new XhhdPage();
		xhpage.setPageSize(TWO_NUMBER);
		String cPage = request.getParameter("cp");
		xhpage.setCurrentPage(Integer.valueOf(cPage == null ? "1" : cPage));
		XhhdPage xhhdPage = xhhdService.getXhhdInfoListByHome(xhpage);
		List<Xhhd> xhhdList = xhhdPage.getXhhdList();
		String retCode = xhhdList==null?"1":"0";
		String message = xhhdList==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data", xhhdList);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 新入协会接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xrxh_list.htm")
	public Map<String,Object> xrxhList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		
		UsersPage xrxhpage = new UsersPage();
		xrxhpage.setPageSize(FIVE_NUMBER);
		xrxhpage.setType(1);
		String cPage = request.getParameter("cp");
		xrxhpage.setCurrentPage(Integer.valueOf(cPage == null ? "1" : cPage));
		UsersPage usersPagexrxh = userService.getHomeUserInfoListByXhNew(xrxhpage);
		List<User> userList = usersPagexrxh.getUserList();
		String retCode = userList==null?"1":"0";
		String message = userList==null?"取得失败":"取得成功";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data", userList);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
}
