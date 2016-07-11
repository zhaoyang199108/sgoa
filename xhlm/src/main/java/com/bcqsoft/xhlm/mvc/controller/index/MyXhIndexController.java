package com.bcqsoft.xhlm.mvc.controller.index;

import java.util.ArrayList;
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

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.common.util.MD5Util;
import com.bcqsoft.xhlm.common.util.PinyinUtil;
import com.bcqsoft.xhlm.dao.notice.dataobject.Notice;
import com.bcqsoft.xhlm.dao.notice.dataobject.NoticePage;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.Ptfw;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.PtfwPage;
import com.bcqsoft.xhlm.dao.pthd.dataobject.Pthd;
import com.bcqsoft.xhlm.dao.pthd.dataobject.PthdPage;
import com.bcqsoft.xhlm.dao.user.dataobject.User;
import com.bcqsoft.xhlm.dao.userxh.dataobject.UserXh;
import com.bcqsoft.xhlm.dao.userzzt.dataobject.Userzzt;
import com.bcqsoft.xhlm.dao.xhfw.dataobject.Xhfw;
import com.bcqsoft.xhlm.dao.xhfw.dataobject.XhfwPage;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetail;
import com.bcqsoft.xhlm.dao.xhfwdetail.dataobject.XhfwDetailPage;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.Xhhd;
import com.bcqsoft.xhlm.dao.xhhd.dataobject.XhhdPage;
import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetail;
import com.bcqsoft.xhlm.dao.xhhddetail.dataobject.XhhdDetailPage;
import com.bcqsoft.xhlm.mvc.result.ProductBean;
import com.bcqsoft.xhlm.service.notice.NoticeService;
import com.bcqsoft.xhlm.service.ptfw.PtfwService;
import com.bcqsoft.xhlm.service.pthd.PthdService;
import com.bcqsoft.xhlm.service.user.UserService;
import com.bcqsoft.xhlm.service.xhfw.XhfwService;
import com.bcqsoft.xhlm.service.xhfwdetail.XhfwDetailService;
import com.bcqsoft.xhlm.service.xhhd.XhhdService;
import com.bcqsoft.xhlm.service.xhhddetail.XhhdDetailService;


/**
 * 前台首页模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class MyXhIndexController {
	
	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 消息模块业务逻辑类接口
	 */
	@Autowired
	private NoticeService noticeService;
	
	/**
	 * 协会活动模块业务逻辑类接口
	 */
	@Autowired
	private XhhdService xhhdService;	
	
	/**
	 * 协会服务模块业务逻辑类接口
	 */
	@Autowired
	private XhhdDetailService xhhdDetailService;
	
	/**
	 * 协会服务模块业务逻辑类接口
	 */
	@Autowired
	private XhfwService xhfwService;
	
	/**
	 * 协会服务模块业务逻辑类接口
	 */
	@Autowired
	private XhfwDetailService xhfwDetailService;
	
	/**
	 * 协会服务模块业务逻辑类接口
	 */
	@Autowired
	private PtfwService ptfwService;
	
	/**
	 * 协会服务模块业务逻辑类接口
	 */
	@Autowired
	private PthdService pthdService;
	
	/**
	 * 我的协会接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_xh_info.htm")
	public Map<String,Object> myXhInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
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
		map.put("data", loginUser);
		return map;
	}
	
	
	/**
	 * 协会资质图提交接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_xh_zz_save.htm")
	public Map<String,Object> myXhZzSave(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		// 判断该用户名是否注册
		User userObj = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		if (userObj != null) {
			String zzDir = request.getParameter("zzDir");
			if (zzDir != null && !"".equals(zzDir)) {
				String[] zzDirs = zzDir.split(",");
				for (String zzObj : zzDirs) {
					Userzzt userzzt = new Userzzt();
					userzzt.setAptitude(zzObj);
					userzzt.setUserId(userObj.getId());
					boolean result = userService.createUserZzt(userzzt);
					if (result) {
						retCode = "0";
						message = "更新成功";
					} else {
						retCode = "2";
						message = "更新失败";
					}
				}
			}
		} else {
			retCode = "1";
			message = "更新失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", loginId);
		return map;
	}
	
	/**
	 * 协会资料提交接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_xh_save.htm")
	public Map<String,Object> myXhInfoSave(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		// 判断该用户名是否注册
		User userObj = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		if (userObj != null) {
			String userName = request.getParameter("userName");
			String logo = request.getParameter("logo");
			String banner = request.getParameter("banner");
			String sortId = request.getParameter("sortId");
			String qyStr = request.getParameter("qyStr");
			String s_province = "";
		    String s_city = "";
			String s_county = "";
			if (qyStr != null && !"".equals(qyStr)) {
				String[] qyStrs = qyStr.split(" ");
				s_province = qyStrs[0];
				if (qyStrs.length > 1) {
					s_city = qyStrs[1];
				}
				if (qyStrs.length > 2) {
					s_county = qyStrs[2];
				}
			}
			String address = request.getParameter("address");
			String introduce = request.getParameter("introduce");
			String productId = request.getParameter("productId");
			
			// 输入用户名
			userObj.setUserName(userName);
			userObj.setUserNamePy(PinyinUtil.toAbbLowPinyin(userName));
			userObj.setLogo(logo);
			userObj.setBanner(banner);
			userObj.setSortId(sortId);
			userObj.setS_province(s_province);
			userObj.setS_city(s_city);
			userObj.setS_county(s_county);
			userObj.setAddress(address);
			userObj.setIntroduce(introduce);
			userObj.setProductId(productId);
			userObj.setType(2);
			boolean result = userService.modifyUserHome(userObj);
			if (result) {
				retCode = "0";
				message = "更新成功";
			} else {
				retCode = "2";
				message = "更新失败";
			}
		} else {
			retCode = "1";
			message = "更新失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", loginId);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("type", 2);
		map.put("data", data);
		return map;
	}
	
	/**
	 * 我的消息列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_notice_list.htm")
	public Map<String,Object> myXhNoticeList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String loginId = request.getParameter("loginId");
		// 判断该用户名是否注册
		User userObj = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		List<Notice> noticeList = null;
		if (userObj != null) {
			NoticePage noticePage = new NoticePage();
			noticePage.setType(String.valueOf(userObj.getType()));
			String cPage = request.getParameter("cp");
			noticePage.setPageSize(7);
			noticePage.setCurrentPage(Integer.valueOf(cPage == null ? "1" : cPage));
			NoticePage page = noticeService.getNoticeInfoList(noticePage);
			noticeList = page.getNoticeList();
			retCode = noticeList ==null?"1":"0";
			message = noticeList ==null?"取得失败":"取得成功";
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("data", noticeList);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 我的消息详情接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_notice_info.htm")
	public Map<String,Object> myXhNoticeInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String noticeId = request.getParameter("noticeId");
		// 取得当前消息
		String retCode = "";
		String message = "";
		Notice notice = null;
		if (noticeId != null && !"".equals(noticeId)) {
			notice = noticeService.getNoticeInfo(Long.valueOf(noticeId));
			if (notice != null) {
				retCode = "0";
				message = "取得成功";
			} else {
				retCode = "1";
				message = "取得失败";
			}
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("data", notice);
		return map;
	}
	
	/**
	 * 我的会员列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_vip_list.htm")
	public Map<String,Object> myXhVipList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String loginId = request.getParameter("loginId");
		// 判断该用户名是否注册
		User userObj = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		List<User> userList = null;
		if (userObj != null) {
			userList = userService.findUserInfoByXhVipId(userObj.getId());
			retCode = userList ==null?"1":"0";
			message = userList ==null?"取得失败":"取得成功";
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("data", userList);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 我的会员列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_vip_info.htm")
	public Map<String,Object> myXhVipInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String userId = request.getParameter("userId");
		String retCode = "";
		String message = "";
		User userObj = null;
		if (userId != null) {
			// 判断该用户名是否注册
			userObj = userService.getUserInfo(Long.valueOf(userId));
		} else {
			retCode = "1";
			message = "取得失败";
		}
		if (userObj != null) {
			retCode = "0";
			message = "取得成功";
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("data", userObj);
		return map;
	}
	
	/**
	 * 我的服务列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_fw_list.htm")
	public Map<String,Object> myFwList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String loginId = request.getParameter("loginId");
		User userObj = userService.getUserInfoByLoginId(loginId);
		// 判断该用户名是否注册
		String retCode = "";
		String message = "";
		List<Xhfw> xhfwList = null;
		if (userObj != null) {
			XhfwPage xhfwPage = new XhfwPage();
			xhfwPage.setLoginId(loginId);
			String cPage = request.getParameter("cp");
			xhfwPage.setPageSize(7);
			xhfwPage.setCurrentPage(Integer.valueOf(cPage == null ? "1" : cPage));
			XhfwPage page = new XhfwPage();
			if (userObj.getType()==1) {
				page = xhfwService.getXhfwInfoList(xhfwPage);
			} else if (userObj.getType()==2) {
				page = xhfwService.getXhfwInfoListQy(xhfwPage);
			}
			xhfwList = page.getXhfwList();
			retCode = xhfwList ==null?"1":"0";
			message = xhfwList ==null?"取得失败":"取得成功";
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("data", xhfwList);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 服务详情接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_fw_info.htm")
	public Map<String,Object> myFwInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String fwId = request.getParameter("fwId");
		String loginId = request.getParameter("loginId");
		String type = request.getParameter("type");
		String retCode = "";
		String message = "";
		Xhfw xhfwObj = null;
		Xhhd xhhdObj = null;
		List<XhfwDetail> xhfwDetailList = null;
		List<XhhdDetail> xhhdDetailList = null;
		if (fwId != null) {
			if ("1".equals(type)) {
				XhfwDetailPage page = new XhfwDetailPage();
				page.setXhfwId(Long.valueOf(fwId));
				page.setPageSize(1000);
				XhfwDetailPage xhfwDetailPageObj = xhfwDetailService.getXhwfDetailInfoListByXhhdId(page);
				xhfwDetailList = xhfwDetailPageObj.getXhfwDetailList();
				// 判断该用户名是否注册
				xhfwObj = xhfwService.getXhfwInfo(Long.valueOf(fwId));
				if (xhfwObj != null) {
					XhfwDetailPage xhfwDetailPage = new XhfwDetailPage();
					xhfwDetailPage.setXhfwId(xhfwObj.getId());
					xhfwDetailPage.setLoginId(loginId);
					Integer count = xhfwDetailService.findXhfwDetailLoginCount(xhfwDetailPage);
					if (count == 0) {
						xhfwObj.setIsSignUp(true);
					} else {
						xhfwObj.setIsSignUp(false);
					}
					retCode = "0";
					message = "取得成功";
				} else {
					retCode = "1";
					message = "取得失败";
				}
			} else if ("2".equals(type)){
				// 判断该用户名是否注册
				XhhdDetailPage page = new XhhdDetailPage();
				page.setXhhdId(Long.valueOf(fwId));
				page.setPageSize(1000);
				XhhdDetailPage xhhdDetailPageObj = xhhdDetailService.getXhhdDetailInfoListByXhhdId(page);
				xhhdDetailList = xhhdDetailPageObj.getXhhdDetailList();
				xhhdObj = xhhdService.getXhhdInfo(Long.valueOf(fwId));
				if (xhhdObj != null) {
					XhhdDetailPage xhhdDetailPage = new XhhdDetailPage();
					xhhdDetailPage.setXhhdId(xhhdObj.getId());
					xhhdDetailPage.setLoginId(loginId);
					Integer count = xhhdDetailService.findXhhdDetailLoginCount(xhhdDetailPage);
					if (count == 0) {
						xhhdObj.setIsSignUp(true);
					} else {
						xhhdObj.setIsSignUp(false);
					}
					retCode = "0";
					message = "取得成功";
				} else {
					retCode = "1";
					message = "取得失败";
				}
			}
			
		} else {
			retCode = "1";
			message = "取得失败";
		}
		
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if ("1".equals(type)) {
			dataMap.put("xhList", xhfwDetailList);
			dataMap.put("info", xhfwObj);
			map.put("data", dataMap);
			xhfwDetailList = null;
		} else {
			dataMap.put("xhList", xhhdDetailList);
			dataMap.put("info", xhhdObj);
			map.put("data", dataMap);
		}
		
		return map;
	}
	
	/**
	 * 服务详情报名接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_fw_signup.htm")
	public Map<String,Object> myFwInfoSignUp(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String fwId = request.getParameter("fwId");
		String loginId = request.getParameter("loginId");
		String retCode = "";
		String message = "";
		if (fwId != null) {
			boolean resultIn = false;
			User userObj = userService.getUserInfoByLoginId(loginId);
			Xhfw xhfw = xhfwService.getXhfwInfo(Long.valueOf(fwId));
			if (xhfw != null && userObj != null) {
				List<User> userList = userService.findUserInfoByXhId(userObj.getId());
				for (User userRes : userList) {
					if (xhfw.getLoginId().equals(userRes.getLoginId())) {
						resultIn = true;
					}
				}
			}
			if (resultIn) {
				// 判断该用户名是否注册
				XhfwDetail xhfwdetail = new XhfwDetail();
				xhfwdetail.setLoginId(loginId);
				xhfwdetail.setXhfwId(fwId);
				xhfwdetail.setEnabled(CommonChar.ABLED);
				boolean result = xhfwDetailService.createXhfwDetail(xhfwdetail);
				if (result) {
					retCode = "0";
					message = "报名成功";
				} else {
					retCode = "1";
					message = "报名失败";
				}
			} else {
				retCode = "1";
				message = "不是会员，无法报名";
			}
			
			
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 服务取消报名接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_fw_signup_close.htm")
	public Map<String,Object> myFwInfoSignUpClose(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String fwId = request.getParameter("fwId");
		String loginId = request.getParameter("loginId");
		String retCode = "";
		String message = "";
		if (fwId != null) {
			// 判断该用户名是否注册
			XhfwDetailPage xhfwDetailPage = new XhfwDetailPage();
			xhfwDetailPage.setLoginId(loginId);
			xhfwDetailPage.setXhfwId(Long.valueOf(fwId));
			boolean result = xhfwDetailService.deleteXhfwDetailByLoginId(xhfwDetailPage);
			if (result) {
				retCode = "0";
				message = "取消报名成功";
			} else {
				retCode = "1";
				message = "取消报名失败";
			}
		} else {
			retCode = "1";
			message = "取消报名失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 我的活动列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_hd_list.htm")
	public Map<String,Object> myHdList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String loginId = request.getParameter("loginId");
		User userObj = userService.getUserInfoByLoginId(loginId);
		// 判断该用户名是否注册
		String retCode = "";
		String message = "";
		List<Xhhd> xhhdList = null;
		if (userObj != null) {
			XhhdPage xhhdPage = new XhhdPage();
			xhhdPage.setLoginId(loginId);
			String cPage = request.getParameter("cp");
			xhhdPage.setPageSize(7);
			xhhdPage.setCurrentPage(Integer.valueOf(cPage == null ? "1" : cPage));
			XhhdPage page = new XhhdPage();
			if (userObj.getType()==1) {
				page = xhhdService.getXhhdInfoList(xhhdPage);
			} else if (userObj.getType()==2) {
				page = xhhdService.getXhhdInfoListQy(xhhdPage);
			}
			xhhdList = page.getXhhdList();
			retCode = xhhdList ==null?"1":"0";
			message = xhhdList ==null?"取得失败":"取得成功";
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("data", xhhdList);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 活动详情报名接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_hd_signup.htm")
	public Map<String,Object> myHdInfoSignUp(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String hdId = request.getParameter("hdId");
		String loginId = request.getParameter("loginId");
		String retCode = "";
		String message = "";
		if (hdId != null) {
			boolean resultIn = false;
			User userObj = userService.getUserInfoByLoginId(loginId);
			Xhhd xhhd = xhhdService.getXhhdInfo(Long.valueOf(hdId));
			if (xhhd != null && userObj != null) {
				List<User> userList = userService.findUserInfoByXhId(userObj.getId());
				for (User userRes : userList) {
					if (xhhd.getLoginId().equals(userRes.getLoginId())) {
						resultIn = true;
					}
				}
			}
			if (resultIn) {
				// 判断该用户名是否注册
				XhhdDetail xhhddetail = new XhhdDetail();
				xhhddetail.setLoginId(loginId);
				xhhddetail.setXhhdId(Long.valueOf(hdId));
				xhhddetail.setEnabled(CommonChar.ABLED);
				boolean result = xhhdDetailService.createXhhdDetail(xhhddetail);
				if (result) {
					retCode = "0";
					message = "报名成功";
				} else {
					retCode = "1";
					message = "报名失败";
				}
			} else {
				retCode = "1";
				message = "不是会员，无法报名";
			}
			
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 活动取消报名接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_hd_signup_close.htm")
	public Map<String,Object> myHdInfoSignUpClose(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String hdId = request.getParameter("hdId");
		String loginId = request.getParameter("loginId");
		String retCode = "";
		String message = "";
		if (hdId != null) {
			// 判断该用户名是否注册
			XhhdDetailPage xhhdDetailPage = new XhhdDetailPage();
			xhhdDetailPage.setLoginId(loginId);
			xhhdDetailPage.setXhhdId(Long.valueOf(hdId));
			boolean result = xhhdDetailService.deleteXhhdDetailByLoginId(xhhdDetailPage);
			if (result) {
				retCode = "0";
				message = "取消报名成功";
			} else {
				retCode = "1";
				message = "取消报名失败";
			}
		} else {
			retCode = "1";
			message = "取消报名失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 我的入住协会列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_xh_list.htm")
	public Map<String,Object> myHhList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		// 取得协会信息
		String retCode = "";
		String message = "";
		List<User> userList = null;
		if (loginUser != null) {
			// 判断该用户名是否注册
			userList = userService.findUserInfoByXhId(loginUser.getId());
			if (userList != null) {
				retCode = "0";
				message = "取得成功";
			} else {
				retCode = "1";
				message = "取得失败";
			}
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		map.put("data", userList);
		return map;
	}
	
	/**
	 * 协会详情接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_info.htm")
	public Map<String,Object> xhInfo(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		String xhId = request.getParameter("xhId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		User userXhRes = userService.getUserInfo(Long.valueOf(xhId));
		UserXh userXhObj = new UserXh();
		UserXh userXh = null;
		if (loginUser != null) {
			userXhObj.setUserId(loginUser.getId());
			userXhObj.setpId(Long.valueOf(xhId));
			userXh = userService.getUserXhInfo(userXhObj);
		}
		
		Integer status = 0;
		if (userXh != null) {
			status = userXh.getStatus();
		}
		userXhRes.setInStatus(status);
		String retCode = loginUser==null?"1":"0";
		String message = loginUser==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		map.put("data", userXhRes);
		return map;
	}
	
	/**
	 * 入住协会接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_xh_in.htm")
	public Map<String,Object> myHhIn(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String loginId = request.getParameter("loginId");
		String xhId = request.getParameter("xhId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		// 取得协会信息
		String retCode = "";
		String message = "";
		if (loginUser != null) {
			// 判断该用户名是否注册
			UserXh userXh = new UserXh();
			userXh.setUserId(loginUser.getId());
			userXh.setpId(Long.valueOf(xhId));
			userXh.setStatus(2);
			boolean result = userService.createUserXh(userXh);
			if (result) {
				retCode = "0";
				message = "入住申请成功";
			} else {
				retCode = "1";
				message = "入住申请失败";
			}
		} else {
			retCode = "1";
			message = "入住失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 退出协会接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/my_xh_out.htm")
	public Map<String,Object> myHhOut(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		String loginId = request.getParameter("loginId");
		String xhId = request.getParameter("xhId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		// 取得协会信息
		String retCode = "";
		String message = "";
		if (loginUser != null) {
			// 判断该用户名是否注册
			UserXh userXh = new UserXh();
			userXh.setUserId(loginUser.getId());
			userXh.setpId(Long.valueOf(xhId));
			boolean result = userService.deleteUserXh(userXh);
			if (result) {
				retCode = "0";
				message = "退出成功";
			} else {
				retCode = "1";
				message = "退出失败";
			}
		} else {
			retCode = "1";
			message = "退出失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		return map;
	}
	
	/**
	 * 密码更改接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/pwd_edit.htm")
	public Map<String,Object> workPwdEdit(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response, ModelMap map) {
		// 取得原密码
		String loginId = request.getParameter("loginId");
		String pwdOld = request.getParameter("pwdOld");
		String pwdNew = request.getParameter("pwdNew");
		User user = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		if (user != null) {
			if (MD5Util.toMd5(pwdOld).equals(user.getPassword())) {
				map.put("loginId", loginId);
				map.put("password", MD5Util.toMd5(pwdNew));
				boolean result = userService.modifyUserPassword(map);
				if (result) {
					retCode = "0";
					message = "更新成功";
					// 更新成功的时候，同时更新环信密码
				} else {
					retCode = "2";
					message = "更新失败";
				}
			} else {
				retCode = "1";
				message = "旧密码错误,请重新输入";
			}
		} else {
			retCode = "1";
			message = "没有此用户,请联系管理员";
		}
		// 输出json格式数据
		Map<String,Object> mapData = new HashMap<String,Object>();
		mapData.put("ret_code", retCode);
		mapData.put("message", message);
		mapData.put("token", loginId);
		return mapData;
	}
	
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
	@RequestMapping("/home/my_product_list.htm")
	public Map<String,Object> myProductList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		List<ProductBean> productList = new ArrayList<ProductBean>();
		if (loginUser != null) {
			if (loginUser.getProduct() != null && !"".equals(loginUser.getProduct())) {
				String[] strSplit = loginUser.getProduct().split(",");
				for (String strRe : strSplit) {
					ProductBean productBean = new ProductBean();
					productBean.setProduct(strRe);
					productList.add(productBean);
				}
				retCode = "0";
				message = "取得成功";
			} else {
				retCode = "2";
				message = "企业没有产品信息";
			}
		} else {
			retCode = "1";
			message = "取得失败";
		}
		
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
		map.put("data", productList);
		return map;
	}
	
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
	@RequestMapping("/home/my_product_save.htm")
	public Map<String,Object> myProductSave(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会列表
		String loginId = request.getParameter("loginId");
		User loginUser = userService.getUserInfoByLoginId(loginId);
		String retCode = "";
		String message = "";
		if (loginUser != null) {
			String productName = request.getParameter("productName");
			if (!"".equals(productName)) {
				StringBuffer sBuffer = new StringBuffer();
				sBuffer.append(loginUser.getProduct());
				if (loginUser.getProduct() != null && !"".equals(loginUser.getProduct())) {
					sBuffer.append(",");
				}
				sBuffer.append(productName);
				loginUser.setProduct(sBuffer.toString());
				boolean result = userService.updateUserProductByHome(loginUser);
				if (result) {
					retCode = "0";
					message = "更新成功";
				} else {
					retCode = "1";
					message = "更新失败";
				}
			}
		} else {
			retCode = "1";
			message = "更新失败";
		}
		
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("token", request.getParameter("loginId"));
		// 输出json格式数据
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
	@RequestMapping("/home/xhhd_all_list.htm")
	public Map<String,Object> oneXhdd(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有协会活动列表
		String type = request.getParameter("type");
		List<Xhhd> xhhdList = null;
		List<Pthd> pthdList = null;
		String retCode = "";
		String message = "";
		if ("1".equals(type)) {
			PthdPage page = new PthdPage();
			page.setPageSize(1000);
			pthdList = pthdService.getPthdInfoListByHome(page).getPthdList();
			retCode = pthdList==null?"1":"0";
			message = pthdList==null?"取得失败":"取得成功";
		} else if ("2".equals(type)) {
			xhhdList = xhhdService.getXhhdInfoListAll();
			retCode = xhhdList==null?"1":"0";
			message = xhhdList==null?"取得失败":"取得成功";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		if ("1".equals(type)) {
			map.put("data", pthdList);
		} else if ("2".equals(type)) {
			map.put("data", xhhdList);
		}
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
	@RequestMapping("/home/xhfw_all_list.htm")
	public Map<String,Object> oneXhfw(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		
		// 取得所有协会活动列表
		String type = request.getParameter("type");
		List<Xhfw> xhfwList = null;
		List<Ptfw> ptfwList = null;
		String retCode = "";
		String message = "";
		if ("1".equals(type)) {
			PtfwPage page = new PtfwPage();
			page.setPageSize(1000);
			ptfwList = ptfwService.getAllPtfwForList(page).getPtfwList();
			retCode = ptfwList==null?"1":"0";
			message = ptfwList==null?"取得失败":"取得成功";
		} else if ("2".equals(type)) {
			xhfwList = xhfwService.getXhfwInfoListAll();
			retCode = xhfwList==null?"1":"0";
			message = xhfwList==null?"取得失败":"取得成功";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		if ("1".equals(type)) {
			map.put("data", ptfwList);
		} else if ("2".equals(type)) {
			map.put("data", xhfwList);
		}
		return map;
	}
	
	/**
	 * 我的入住协会列表接口
	 * 
	 * @param retuest
	 * @param response
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2015-12-14
	 */
	@ResponseBody
	@RequestMapping("/home/xh_all_list.htm")
	public Map<String,Object> xHhList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		// 取得所有行业新闻列表
		// 取得协会信息
		String retCode = "";
		String message = "";
		User user = new User();
		user.setType(1);
		List<User> userList = userService.getUserListAll(user);
		// 判断该用户名是否注册
		if (userList != null) {
			retCode = "0";
			message = "取得成功";
		} else {
			retCode = "1";
			message = "取得失败";
		}
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		map.put("data", userList);
		return map;
	}
}
