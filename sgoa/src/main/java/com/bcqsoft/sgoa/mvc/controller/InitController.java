package com.bcqsoft.sgoa.mvc.controller;

import static com.bcqsoft.sgoa.common.util.DateUtil.getTodays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.ArrayUtil;
import com.bcqsoft.sgoa.common.util.Base64;
import com.bcqsoft.sgoa.common.util.MD5Util;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.message.dataobject.MessagePage;
import com.bcqsoft.sgoa.dao.news.dataobject.NewsPage;
import com.bcqsoft.sgoa.dao.optlog.dataobject.OptLog;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.userkey.dataobject.UserKey;
import com.bcqsoft.sgoa.mvc.form.user.UserForm;
import com.bcqsoft.sgoa.mvc.form.userkey.UserKeyForm;
import com.bcqsoft.sgoa.service.index.IndexService;
import com.bcqsoft.sgoa.service.message.MessageService;
import com.bcqsoft.sgoa.service.news.NewsService;
import com.bcqsoft.sgoa.service.notice.NoticeService;
import com.bcqsoft.sgoa.service.optlog.OptLogService;
import com.bcqsoft.sgoa.service.remind.RemindService;
import com.bcqsoft.sgoa.service.user.UserService;
import com.bcqsoft.sgoa.service.userkey.UserKeyService;

/**
 * 页面框架初始化控制器
 */
@Controller
public class InitController {

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private MessageService messageService;

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private NoticeService noticeService;
	
	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private NewsService newsService;
	
	/**
	 * 用户业务逻辑层
	 */
	@Autowired
	private UserService userService;

	/**
	 * 用户业务逻辑层
	 */
	@Autowired
	private IndexService indexService;
	
	/**
	 * 登录日志业务逻辑层
	 */
	@Autowired
	private OptLogService optLogService;
	
	/**
	 * 登录日志业务逻辑层
	 */
	@Autowired
	private RemindService remindService;
	
	/**
	 * 用户KEY申领表的业务逻辑层
	 */
	@Autowired
	private UserKeyService userKeyService;

	/**
	 * 初始化页面框架
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("/main.htm")
	@Secured({ "ROLE_SYSTRM", "ROLE_ADMIN", "ROLE_MESSAGE", "ROLE_MESSAGE_LOOK", "ROLE_MESSAGE_EDIT",
			"ROLE_MESSAGE_DEL", "ROLE_MESSAGE_REW", "ROLE_DOCOUT", "ROLE_DOCOUT_LOOK", "ROLE_DOCOUT_EDIT",
			"ROLE_DOCOUT_REW", "ROLE_DOCOUT_DEL", "ROLE_DOCOUT_DUBAN", "ROLE_DOCOUT_DO", "ROLE_DOCIN",
			"ROLE_DOCIN_LOOK", "ROLE_DOCIN_EDIT", "ROLE_DOCIN_REW", "ROLE_DOCIN_DEL", "ROLE_DOCIN_DUBAN",
			"ROLE_DOCIN_DO", "ROLE_MEETING", "ROLE_MEETING_NEW", "ROLE_MEETING_REW", "ROLE_GGTXL", "ROLE_GGTXL_LOOK",
			"ROLE_GGTXL_EDIT", "ROLE_GGTXL_JJ", "ROLE_WORKSCHEDULER", "ROLE_WORKSCHEDULER_EDIT",
			"ROLE_WORKSCHEDULER_CHECK", "ROLE_RESFILE", "ROLE_RESFILE_UPLOAD", "ROLE_RESFILE_LOOK",
			"ROLE_ADDRESS_BOOK", "ROLE_ADDRESS_BOOK_EDIT", "ROLE_MSG", "ROLE_MSG_LOOK", "ROLE_MSG_EDIT",
			"ROLE_MSG_DEL", "ROLE_SCHEDULER", "ROLE_SCHEDULER_EDIT", "ROLE_NET_FILE", "ROLE_NET_FILE_UPLOAD",
			"ROLE_NET_FILE_DOWN" })
	public String initMain(HttpServletRequest request,UserKeyForm form) {
		
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			// windows下的命令，显示信息中包含有mac地址信息
			process = Runtime.getRuntime().exec("ipconfig /all");
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				// 寻找标示字符串[physical
				index = line.toLowerCase().indexOf("physical address");

				if (index >= 0) {// 找到了
					index = line.indexOf(":");// 寻找":"的位置
					if (index >= 0) {
						// 取出mac地址并去除2边空格
						mac = line.substring(index + 1).trim();
					}
					break;
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		OptLog optLog = new OptLog();
		optLog.setOptId(SecurityUtils.getLoginId());
		optLog.setOptIp(ip);
		optLog.setOptMac(mac);
		optLogService.creatOptLogInfo(optLog);
		
		// 将所有暂不提醒的消息更改称为提醒状态
		indexService.alertInfoEditTx();
		return "main";
	}

	/**
	 * 初始化页面框架
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping("/main_mobile.htm")
	@Secured({ "ROLE_ADMIN", "ROLE_MOBILE" })
	public String initMainMobile(ModelMap map) {
		String loginId = SecurityUtils.getLoginId(); // 登录ID
		// 取得红头文件信息
		map.put("date", getTodays()); // 取得当前日期
		map.put("loginId", loginId); // 取得登录用户名
		// 根据loginId取得用户信息
		User user = userService.getUserInfoByLoginId(loginId);
		map.put("userName", user == null ? "" : user.getUserName());
		return "main_mobile";
	}

	/**
	 * 初始化页面顶部
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/init.htm", params = "frame=top")
	public String initTop(ModelMap map) {
		String loginId = SecurityUtils.getLoginId(); // 登录ID
		// 取得红头文件信息
		map.put("date", getTodays()); // 取得当前日期
		map.put("loginId", loginId); // 取得登录用户名
		// 根据loginId取得用户信息
		User user = userService.getUserInfoByLoginId(loginId);
		map.put("userName", user == null ? "" : user.getUserName());// 取得登录用户名
		return "body/top";
	}

	/**
	 * 视频教学跳转
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/video.htm")
	public String video() {

		return "video";
	}

	/**
	 * 初始化页面主要区域
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/init.htm", params = "frame=index")
	public String initIndex(ModelMap map) {
		MessagePage outPage = new MessagePage();
		outPage.setSort(CommonChar.SORT_TZ);
		outPage.setStatus(CommonChar.ACTION_PZ);
		outPage.setStatus(4); // 当前状态
		outPage.setDraftsId(SecurityUtils.getLoginId());
		// 根据用户ID查找该待该用户审批的信息
		MessagePage messagePage = messageService.getMessageSearchList(outPage);
		map.put("messagePage", messagePage);
		
		MessagePage outPages = new MessagePage();
		outPages.setSort(CommonChar.SORT_GG);
		outPages.setDraftsId(SecurityUtils.getLoginId());
		outPages.setStatus(4); // 当前状态
		outPages.setStatus(CommonChar.ACTION_PZ);
		// 根据用户ID查找该待该用户审批的信息
		MessagePage noticePage = messageService.getMessageSearchList(outPages);		
		map.put("noticePage", noticePage);
		
		NewsPage indexNewsPage = new NewsPage();
		indexNewsPage.setSort(CommonChar.SORT_YQ);
		indexNewsPage.setDraftsId(SecurityUtils.getLoginId());
		indexNewsPage.setPageSize(6);
		indexNewsPage.setStatus(CommonChar.ACTION_PZ);// 当前状态
		// 根据用户ID查找该待该用户审批的信息
		NewsPage newsPage = newsService.getNewsSearchList(indexNewsPage);
		map.put("newsPage", newsPage);
		
		NewsPage indexBriefPage = new NewsPage();
		indexBriefPage.setSort(CommonChar.SORT_JB);
		indexBriefPage.setDraftsId(SecurityUtils.getLoginId());
		indexBriefPage.setPageSize(6);
		indexBriefPage.setStatus(CommonChar.ACTION_PZ);// 当前状态
		// 根据用户ID查找该待该用户审批的信息
		NewsPage briefPage = newsService.getNewsSearchList(indexBriefPage);
		map.put("briefPage", briefPage);
		
		return "index";
	}

	/**
	 * 查看提示信息信息列表
	 * 
	 * @param map
	 * @return 提示信息列表页面
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	@RequestMapping("/message/message_info.htm")
	@ResponseBody
	public Map<String, Object> messageInfo() {
		// 取得符合條件的公文信息和日程信息
		Map<String, Object> dataMap = indexService.getAlertMessageForIndex();
		// 返回数据至Response
		return dataMap;
	}
	
	/**
	 * 查看提示信息信息列表
	 * 
	 * @param map
	 * @return 提示信息列表页面
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	@RequestMapping("/message/alert_info.htm")
	public String alertInfo(ModelMap map) {
		// 取得符合條件的公文信息和日程信息
		Map<String, Integer> dataMap = indexService.getAlertMessageForIndexCount();
		map.put("amInfoScheduler",dataMap.get("amInfoScheduler"));
		map.put("amInfoDocout",dataMap.get("amInfoDocout"));
		map.put("amInfoDocin",dataMap.get("amInfoDocin"));
		map.put("amInfoMeeting",dataMap.get("amInfoMeeting"));
		map.put("amInfoAlert",dataMap.get("amInfoAlert"));
		map.put("amInfoMessage",dataMap.get("amInfoMessage"));
		map.put("amInfoNotice",dataMap.get("amInfoNotice"));
		map.put("amInfoMsgOne",dataMap.get("amInfoMsgOne"));
		
		map.put("amInfoMsg",dataMap.get("amInfoMsg"));
		
		map.put("amInfoWorkScheduler",dataMap.get("amInfoWorkScheduler"));
		map.put("amInfoLeaderScheduler",dataMap.get("amInfoLeaderScheduler"));
		
		map.put("amInfoSw",dataMap.get("amInfoSw"));
		map.put("amInfoNews",dataMap.get("amInfoNews"));
		map.put("amInfoBrief",dataMap.get("amInfoBrief"));
		// 返回数据至Response
		return "common/alert_info";
	}
	
	/**
	 * 更新状态为暂不提醒
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/common/alert_info_zbtx.htm")
	public String alertInfoEditZbtx(String idArray) {
		
		// 更新状态为暂不提醒
		indexService.alertInfoEditZbtx(ArrayUtil.toStringArray(idArray));
		// 返回到操作成功页面
		return "common/alert_info";
	}
	
	/**
	 * 更新状态为已读
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/common/alert_info_btx.htm")
	public String alertInfoEditBtx(String idArray) {
		
		// 更新状态为暂不提醒
		indexService.alertInfoEditBtx(ArrayUtil.toStringArray(idArray));
		// 返回到操作成功页面
		return "common/alert_info";
	}
	
	/**
	 * 更新状态为已读
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/common/alert_info_hftx.htm")
	public String alertInfoEditHftx(String idArray) {
		
		// 更新状态为暂不提醒
		indexService.alertInfoEditHftx(ArrayUtil.toStringArray(idArray));
		// 返回到操作成功页面
		return "common/alert_info";
	}

	/**
	 * 初始化页面主要区域
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/init.htm", params = "frame=bottom")
	public String initBottom() {
		return "body/bottom";
	}

	/**
	 * 用户更密码
	 * 
	 * @return 新增用户页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/user/edit_password.htm", method = RequestMethod.GET)
	public String editUserPassWord() {
		return "user/edit_password";
	}

	/**
	 * 用户更密码
	 * 
	 * @param map
	 * @return 更新用户成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/user/edit_password.htm")
	public String editUserPassWord(UserForm form, ModelMap map) {
		// 追加用户
		String loginId = SecurityUtils.getLoginId();
		User user = userService.getUserInfoByLoginId(loginId);
		if (user.getPassword().equals(MD5Util.toMd5(form.getOldPassword()))) {
			map.put("loginId", loginId);
			map.put("password", MD5Util.toMd5(form.getPassword()));
			userService.modifyUserPassword(map);
		}
		return "common/action_succ";
	}

	/**
	 * 万事通
	 * 
	 * @author zbq2109
	 * @date 2011-5-3
	 * @return String
	 */
	@RequestMapping(value = "/all_know.htm")
	public String allKnow() {
		return "allknow/all_know";
	}
}
