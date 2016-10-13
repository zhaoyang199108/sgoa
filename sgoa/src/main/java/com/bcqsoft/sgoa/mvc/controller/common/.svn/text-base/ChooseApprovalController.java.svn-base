package com.bcqsoft.sgoa.mvc.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;
import com.bcqsoft.sgoa.dao.docoutstep.dataobject.DocoutStep;
import com.bcqsoft.sgoa.dao.dooutinstep.dataobject.DooutinStep;
import com.bcqsoft.sgoa.dao.messagestep.dataobject.MessageStep;
import com.bcqsoft.sgoa.dao.newsstep.dataobject.NewsStep;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.service.approvaldetail.ApprovalDetailService;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.docout.DocoutService;
import com.bcqsoft.sgoa.service.message.MessageService;
import com.bcqsoft.sgoa.service.news.NewsService;
import com.bcqsoft.sgoa.service.notice.NoticeService;
import com.bcqsoft.sgoa.service.user.UserService;
import com.bcqsoft.sgoa.service.brief.BriefService;

/**
 * 通用选择用户控制器
 */
@Controller
public class ChooseApprovalController {

	/**
	 * 共通业务模块业务逻辑接口
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * 物资设备申领表的业务逻辑层
	 */
	@Autowired
	private ApprovalDetailService approvalDetailService;

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
	 * 发文模块业务逻辑类接口
	 */
	@Autowired
	private DocoutService docoutService;

	/**
	 * 发文模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private NewsService newsService;

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private BriefService briefService;

	/**
	 * 审批流程
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_approval_user.htm", method = RequestMethod.GET)
	public String chooseAllUser(String step, String approvalId, ModelMap map) {
		String userLoginId = SecurityUtils.getLoginId();
		// 取得当前登录人的相应信息
		User user = userService.getUserInfoByLoginId(userLoginId);
		// 取得当前职务下在流程里的主键ID
		// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
		ApprovalDetail approvalDetail = new ApprovalDetail();
		approvalDetail.setPositionId(user.getPositionId());
		approvalDetail.setDetailId(approvalId);
		List<ApprovalDetail> approvalDetailList = approvalDetailService
				.getApprovalDetailForPositionId(approvalDetail);
		// 判断当前职务下有没有在流程里如果没有在流程里
		if (approvalDetailList == null || approvalDetailList.size() == 0) {
			// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
			ApprovalDetail approvalDetailForPid = new ApprovalDetail();
			approvalDetailForPid.setpId(new Long(0));
			approvalDetailForPid.setDetailId(approvalId);
			List<ApprovalDetail> approvalDetailListForPid = approvalDetailService
					.getApprovalDetailForPIdList(approvalDetailForPid);
			StringBuffer positionIds = new StringBuffer();
			// 取得所有职务的集合
			for (int i = 0; i < approvalDetailListForPid.size(); i++) {
				ApprovalDetail approvalDetailObj = approvalDetailListForPid
						.get(i);
				positionIds.append(approvalDetailObj.getPositionId());
				if (i < approvalDetailListForPid.size() - 1) {
					positionIds.append(",");
				}
			}
			if (positionIds.length() == 0) {
				map.put("selUserList", null);
			} else {
				map.put("selUserList", commonService
						.getAppUsersInfoByLoginId(positionIds.toString()));
			}

		} else {
			// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
			StringBuffer positionIds = new StringBuffer();
			// 取得所有职务的集合
			for (int i = 0; i < approvalDetailList.size(); i++) {
				ApprovalDetail approvalDetailObj = approvalDetailList.get(i);
				positionIds.append(approvalDetailObj.getPositionId());
				if (i < approvalDetailList.size() - 1) {
					positionIds.append(",");
				}
			}
			if (positionIds.length() == 0) {
				map.put("selUserList", null);
			} else {
				map.put("selUserList", commonService
						.getAppUsersInfoByLoginId(positionIds.toString()));
			}
		}

		// 取得登录人的部门ID
		map.put("deptId", user.getDeptId());
		// 跳转选择用户页面
		return "/common/choose_approval_user";
	}
	
	/**
	 * 审批流程
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_approval_user_all.htm", method = RequestMethod.GET)
	public String chooseApprovalUserAll(String step, String approvalId,String yxOptId, ModelMap map) {
		String userLoginId = SecurityUtils.getLoginId();
		// 取得当前登录人的相应信息
		User user = userService.getUserInfoByLoginId(userLoginId);
		// 取得当前职务下在流程里的主键ID
		// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
		ApprovalDetail approvalDetail = new ApprovalDetail();
		approvalDetail.setPositionId(user.getPositionId());
		approvalDetail.setDetailId(approvalId);
		List<ApprovalDetail> approvalDetailList = approvalDetailService
				.getApprovalDetailForPositionId(approvalDetail);
		// 判断当前职务下有没有在流程里如果没有在流程里
		if (approvalDetailList == null || approvalDetailList.size() == 0) {
			// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
			ApprovalDetail approvalDetailForPid = new ApprovalDetail();
			approvalDetailForPid.setpId(new Long(0));
			approvalDetailForPid.setDetailId(approvalId);
			List<ApprovalDetail> approvalDetailListForPid = approvalDetailService
					.getApprovalDetailForPIdList(approvalDetailForPid);
			StringBuffer positionIds = new StringBuffer();
			// 取得所有职务的集合
			for (int i = 0; i < approvalDetailListForPid.size(); i++) {
				ApprovalDetail approvalDetailObj = approvalDetailListForPid
						.get(i);
				positionIds.append(approvalDetailObj.getPositionId());
				if (i < approvalDetailListForPid.size() - 1) {
					positionIds.append(",");
				}
			}
			if (positionIds.length() == 0) {
				map.put("selUserList", null);
			} else {
				map.put("selUserList", commonService
						.getAppUsersInfoByLoginId(positionIds.toString()));
			}

		} else {
			// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
			StringBuffer positionIds = new StringBuffer();
			// 取得所有职务的集合
			for (int i = 0; i < approvalDetailList.size(); i++) {
				ApprovalDetail approvalDetailObj = approvalDetailList.get(i);
				positionIds.append(approvalDetailObj.getPositionId());
				if (i < approvalDetailList.size() - 1) {
					positionIds.append(",");
				}
			}
			if (positionIds.length() == 0) {
				map.put("selUserList", null);
			} else {
				map.put("selUserList", commonService
						.getAppUsersInfoByLoginId(positionIds.toString()));
			}
		}
		if (yxOptId != null && !"".equals(yxOptId)) {
			map.put("yxOptId", yxOptId);
		}

		// 取得登录人的部门ID
		map.put("deptId", user.getDeptId());
		// 跳转选择用户页面
		return "/common/choose_approval_user_all";
	}

	/**
	 * 办事流程
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_approval_users.htm", method = RequestMethod.GET)
	public String chooseAllUsers(String steps, String approvalIds, ModelMap map) {
		String userLoginId = SecurityUtils.getLoginId();
		// 取得当前登录人的相应信息
		User user = userService.getUserInfoByLoginId(userLoginId);
		// 取得当前职务下在流程里的主键ID
		// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
		ApprovalDetail approvalDetail = new ApprovalDetail();
		approvalDetail.setPositionId(user.getPositionId());
		approvalDetail.setDetailId(approvalIds);
		List<ApprovalDetail> approvalDetailList = approvalDetailService
				.getApprovalDetailForPositionId(approvalDetail);
		// 判断当前职务下有没有在流程里如果没有在流程里
		if (approvalDetailList == null || approvalDetailList.size() == 0) {
			// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
			ApprovalDetail approvalDetailForPid = new ApprovalDetail();
			approvalDetailForPid.setpId(new Long(0));
			approvalDetailForPid.setDetailId(approvalIds);
			List<ApprovalDetail> approvalDetailListForPid = approvalDetailService
					.getApprovalDetailForPIdList(approvalDetailForPid);
			StringBuffer positionIds = new StringBuffer();
			// 取得所有职务的集合
			for (int i = 0; i < approvalDetailListForPid.size(); i++) {
				ApprovalDetail approvalDetailObj = approvalDetailListForPid
						.get(i);
				positionIds.append(approvalDetailObj.getPositionId());
				if (i < approvalDetailListForPid.size() - 1) {
					positionIds.append(",");
				}
			}
			if (positionIds.length() == 0) {
				map.put("selUserList", null);
			} else {
				map.put("selUserList", commonService
						.getAppUsersInfoByLoginId(positionIds.toString()));
			}

		} else {
			// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
			StringBuffer positionIds = new StringBuffer();
			// 取得所有职务的集合
			for (int i = 0; i < approvalDetailList.size(); i++) {
				ApprovalDetail approvalDetailObj = approvalDetailList.get(i);
				positionIds.append(approvalDetailObj.getPositionId());
				if (i < approvalDetailList.size() - 1) {
					positionIds.append(",");
				}
			}
			if (positionIds.length() == 0) {
				map.put("selUserList", null);
			} else {
				map.put("selUserList", commonService
						.getAppUsersInfoByLoginId(positionIds.toString()));
			}
		}

		// 取得登录人的部门ID
		map.put("deptId", user.getDeptId());
		// 跳转选择用户页面
		return "/common/choose_approval_user";
	}

	/**
	 * 返回
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_reback_user.htm", method = RequestMethod.GET)
	public String chooseAllUserBack(Long id, ModelMap map) {
		List<MessageStep> messageStepList = messageService
				.getMessageStepList(id);
		map.put("messageStepList", messageStepList);
		// 跳转选择用户页面
		return "/common/choose_reback_user";
	}

	/**
	 * 返回
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_reback_user1.htm", method = RequestMethod.GET)
	public String chooseAllUserBack1(Long id, ModelMap map) {
		List<MessageStep> noticeStepList = noticeService.getNoticeStepList(id);
		map.put("noticeStepList", noticeStepList);
		// 跳转选择用户页面
		return "/common/choose_reback_user1";
	}

	/**
	 * 返回
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_reback_user2.htm", method = RequestMethod.GET)
	public String chooseAllUserBack2(Long id, ModelMap map) {
		List<DocoutStep> docoutStepList = docoutService.getDocoutStepList(id);
		map.put("docoutStepList", docoutStepList);
		// 跳转选择用户页面
		return "/common/choose_reback_user2";
	}

	/**
	 * 返回
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_reback_user3.htm", method = RequestMethod.GET)
	public String chooseAllUserBack3(Long id, ModelMap map) {
		List<DooutinStep> dooutinStepList = docoutService
				.getDooutinStepList(id);
		map.put("dooutinStepList", dooutinStepList);
		// 跳转选择用户页面
		return "/common/choose_reback_user3";
	}

	/**
	 * 返回
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_reback_user4.htm", method = RequestMethod.GET)
	public String chooseAllUserBack4(Long id, ModelMap map) {
		List<NewsStep> newsStepList = newsService.getNewsStepList(id);
		map.put("newsStepList", newsStepList);
		// 跳转选择用户页面
		return "/common/choose_reback_user4";
	}

	/**
	 * 返回
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_reback_user5.htm", method = RequestMethod.GET)
	public String chooseAllUserBack5(Long id, ModelMap map) {
		List<NewsStep> briefStepList = briefService.getBriefStepList(id);
		map.put("briefStepList", briefStepList);
		// 跳转选择用户页面
		return "/common/choose_reback_user4";
	}
	
	/**
	 * 预选
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/common/choose_dept_user_all.htm", method = RequestMethod.GET)
	public String chooseDeptUserAll(String yxOptId,ModelMap map) {
		String userLoginId = SecurityUtils.getLoginId();
		// 取得当前登录人的相应信息
		User user = userService.getUserInfoByLoginId(userLoginId);
		User userObj = new User();
		userObj.setDeptId(user.getDeptId());
		userObj.setPositionId(Long.valueOf(12));
		map.put("selDeptUserList", commonService
				.getUserListByDP(userObj));
		
		if (yxOptId != null && !"".equals(yxOptId)) {
			map.put("yxOptId", yxOptId);
		}
		// 跳转选择用户页面
		return "/common/choose_dept_user_all";
	}
}
