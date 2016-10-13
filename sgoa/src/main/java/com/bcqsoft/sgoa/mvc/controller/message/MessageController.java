package com.bcqsoft.sgoa.mvc.controller.message;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;
import static com.bcqsoft.sgoa.core.security.SecurityUtils.getLoginId;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;
import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.message.dataobject.Message;
import com.bcqsoft.sgoa.dao.message.dataobject.MessagePage;
import com.bcqsoft.sgoa.dao.messagehistory.dataobject.MessageHistory;
import com.bcqsoft.sgoa.dao.messagelook.dataobject.MessageLook;
import com.bcqsoft.sgoa.dao.messagereview.dataobject.MessageReviewPage;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.mvc.form.message.MessageForm;
import com.bcqsoft.sgoa.service.approval.ApprovalService;
import com.bcqsoft.sgoa.service.approvaldetail.ApprovalDetailService;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.dept.DeptService;
import com.bcqsoft.sgoa.service.message.MessageService;
import com.bcqsoft.sgoa.service.messagelook.MessageLookService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 信息控制器
 */
@Controller
public class MessageController {

	/**
	 * 部门模块业务逻辑类接口
	 */
	@Autowired
	private DeptService deptService;

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private MessageService messageService;

	/**
	 * 共通逻辑类接口
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * 流程审批表的业务逻辑层
	 */
	@Autowired
	private ApprovalService approvalService;

	/**
	 * 流程审批详细表的业务逻辑层
	 */
	@Autowired
	private ApprovalDetailService approvalDetailService;
	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private MessageLookService messageLookService;
	/**
	 * 用户表的业务逻辑层
	 */
	@Autowired
	private UserService userService;

	/**
	 * 跳转至信息拟稿页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/add_message.htm", method = RequestMethod.GET)
	public String addMessage(ModelMap map) {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("X");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("d_userName", SecurityUtils.getLoginId());
		map.put("d_fileType", "doc");
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "add_message");
		// 跳转至信息拟稿页面
		return "/message/add_message";
	}

	/**
	 * 信息提交申请
	 * 
	 * @param map
	 * @return 确认是否继续信息页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/add_message.htm", method = RequestMethod.POST)
	public String addMessage(MessageForm form, ModelMap map) {
		// 信息临时表中添加数据
		messageService.addMessageInfo(setBeans(form));
		map.put("sort", CommonChar.SORT_TZ); // 分类
		
		// 跳转至信息拟稿页面
		return "/message/add_success";
	}

	/**
	 * 信息保存至草稿
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/draft_message.htm", method = RequestMethod.POST)
	public String draftMessage(MessageForm form, boolean edit, ModelMap map) {
		// 根据参数edit判断是否更新
		if (edit) {
			messageService.updateMessageDraftInfo(setBeans(form));
		} else {
			messageService.addMessageDraftInfo(setBeans(form));
		}
		map.put("sort", CommonChar.SORT_TZ); // 分类
		// 跳转至信息拟稿页面
		return "/message/draft_success";
	}

	/**
	 * 我的拟稿列表
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/my_draft_list.htm", method = RequestMethod.GET)
	public String myDraftList(MessageForm outForm, int sort, ModelMap map) {
		MessagePage outPage = new MessagePage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage, sort); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置拟稿人为当前用户ID

		// 根据用户ID查找该用户拟稿的信息
		map.put("page", messageService.getMyDraftMessageList(outPage));
		map.put("sort", sort); // 分类
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_draft_list");
		// 跳转至信息列表页面
		return "/message/my_draft_list";
	}

	/**
	 * 我的信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/list.htm", method = RequestMethod.GET)
	public String messageList(MessageForm outForm, int sort, ModelMap map) {
		MessagePage outPage = new MessagePage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage, sort); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", messageService.getApprovedMessageList(outPage));
		map.put("sort", sort); // 分类
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "list");
		// 跳转至信息列表页面
		return "/message/message_list";
	}

	/**
	 * 待审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/message_review_list.htm", method = RequestMethod.GET)
	public String messageReviewList(MessageForm outForm, int sort, ModelMap map) {
		MessagePage outPage = new MessagePage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage, sort); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", messageService.getMessageReviewList(outPage));
		
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_MESSAGE,CommonChar.MODULE_TYPE_LIST));
		
		map.put("sort", sort); // 分类
		
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "message_review_list");
		// 跳转至信息列表页面
		return "/message/message_review_list";
	}

	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/message_search.htm", method = RequestMethod.GET)
	public String messageSearchList(MessageForm outForm,ModelMap map) {
		MessagePage outPage = new MessagePage();
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setTitle(outForm.getTitle());
		outPage.setSort(CommonChar.SORT_TZ);
		outPage.setStatus(CommonChar.ACTION_PZ);
		// 根据用户ID查找该待该用户审批的信息
		map.put("page", messageService.getMessageSearchList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "message_search");
		return "/message/message_search_list";
	}

	private void setSearchKey(MessageForm form, MessagePage messagePage) {
		// 设置查询条件
		messagePage.setCurrentPage(form.getCp()); // 当前页数
		messagePage.setTitle(form.getTitle()); // 标题
		messagePage.setSort(CommonChar.SORT_TZ); // 分类
		messagePage.setStatus(form.getStatus()); // 当前状态
		messagePage.setDraftsDeptId(form.getDraftsDeptId()); // 拟稿部门
		messagePage.setEnabled(form.getEnabled()); // 文件状态
		
	}

	/**
	 * 经我审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/my_message_list.htm", method = RequestMethod.GET)
	public String myMessageReviewList(MessageForm outForm, int sort,
			ModelMap map) {
		MessagePage outPage = new MessagePage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage, sort); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", messageService.getMyMessageReviewList(outPage));
		map.put("sort", sort); // 分类
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_message_list");
		// 跳转至信息列表页面
		return "/message/my_message_list";
	}

	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long
	 *            信息ID
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@RequestMapping(value = "/message/del_message.htm", method = RequestMethod.GET)
	public String deleteMessage(Long id) {
		messageService.removeOneMessageInfo(id);
		return "/common/action_succ";
	}

	/**
	 * 删除收件箱(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	@RequestMapping("/message/delete_messageArray.htm")
	public String deleteMessage(String idArray) {
		// 删除收件箱信息
		messageService.removeOneMessageInfo(toLongArray(idArray));
		// 返回到操作成功页面
		return "common/action_succ";
	}

	/**
	 * 根据信息ID撤销该条信息记录
	 * 
	 * 
	 * @param Long
	 *            信息ID
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@RequestMapping(value = "/message/message_back.htm", method = RequestMethod.GET)
	public String backMessage(Long id) {
		messageService.updateOneMessageInfo(id);
		return "/common/action_succ";
	}

	/**
	 * 点击查看通知表详细
	 * 
	 * @param id
	 * @param map
	 * @return 通知表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/message/detail.htm", method = RequestMethod.GET)
	public String messageDetail(Long id, ModelMap map) throws Exception {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("X");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Message message = messageService.getUserDraftMessageDetail(id);
		map.put("message", message);

		MessageReviewPage page = messageService.getMessageReviewListById(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("page", page);
		return "/message/message_detail";
	}

	/**
	 * 取得信息草稿数据,并跳转至编辑信息草稿页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/edit_message.htm", method = RequestMethod.GET)
	public String editMessage(Long id, ModelMap map) {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("X");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Message message = messageService.getUserDraftMessageDetail(id);
		// 取得页面下拉框数据
		map.put("message", message);
		map.put("loginId", getLoginId()); // 当前登录ID
		// 跳转至信息拟稿页面
		return "/message/edit_message";
	}

	/**
	 * 取得信息草稿数据,并跳转至编辑信息草稿页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/edit_message.htm", method = RequestMethod.POST)
	public String editMessage(MessageForm form, ModelMap map) {
		messageService.updateMessageInfo(setBeans(form));
		map.put("sort", CommonChar.SORT_TZ); // 分类
		// 跳转至拟稿成功页面
		return "/message/add_success";
	}

	/**
	 * 跳转到提交审核页面
	 * 
	 * @param id
	 * @param map
	 * @return 提交审核页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/message/edit_message_review.htm", method = RequestMethod.GET)
	public String messageReviewEdit(Long id, ModelMap map) throws Exception {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("X");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());

		// 用户查看自己的详细信息
		Message message = messageService.getUserDraftMessageDetail(id);
		
		User user = userService.getUserInfoByLoginId(department);
		// 查出流程ID
		String approvalId = message.getApprovalId();
		// 实例流程详细表对象
		ApprovalDetail approvalDetail = new ApprovalDetail();
		// 把流程ID赋值给流程详细表的流程ID
		approvalDetail.setDetailId(approvalId);
		// 吧步骤赋值给流程详细表的步骤
		approvalDetail.setPositionId(user.getPositionId());
		// 获取流程详细表的对象
		ApprovalDetail approvalDetailFor = approvalDetailService
				.getApprovalDetailForList(approvalDetail);
		// 查出流程详细表审批权限
		String approvalDetailForStatus = approvalDetailFor == null ? "N"
				: approvalDetailFor.getStatus();
		map.put("approvalDetailForStatus", approvalDetailForStatus);
		// 判断是否有下一步
		ApprovalDetail approvalDetailForNext=new ApprovalDetail();
		approvalDetailForNext.setId(approvalDetailFor.getId());
		approvalDetailForNext.setDetailId(approvalId);
		List<ApprovalDetail> approvalDetailList = approvalDetailService.getApprovalDetailForIdByPId(approvalDetailForNext);
		Integer stepNext = null;
		if (approvalDetailList != null && approvalDetailList.size() != 0) {
			stepNext = approvalDetailList.size();
		}
		map.put("stepNext", stepNext);
		
		map.put("approvalDetailId", approvalDetailFor.getId());

		map.put("message", message);
		MessageReviewPage page = messageService.getMessageReviewListById(id);

		// Dept dept = deptService.findDeptInfoByLoginId(loginId);
		// map.put("deptId", dept == null ? "" : dept.getId()); // 部门id
		map.put("userName", user == null ? "" : user.getUserName()); // 设置拟稿人名称;
		// 设置历史表文件的唯一ID
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("page", page);
		map.put("loginId", SecurityUtils.getLoginId());
		map.put("opinionId", "MS" + DateUtil.getDateTimeForYh());
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_MESSAGE,CommonChar.MODULE_TYPE_REVIEW));
		// 更新状态为已读
		message.setStatus(CommonChar.STATUS_YD);
		messageService.updateMessageStatusById(message);
		
		MessageReviewPage onePage = messageService.getMessageReviewListByIdOne(id);
		map.put("onePage", onePage);
		
		// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
		Remind remind = new Remind();
		remind.setBusId(message.getId());
		remind.setModeName(CommonChar.MODE_MESSAGE);
		remind.setLoginId(SecurityUtils.getLoginId());
		remind.setStatus(CommonChar.REMIND_STATUS_BTX);
		commonService.updateRemindInfoByLoginId(remind);
		
		return "/message/review_message";
	}

	/**
	 * 跳转至信息内容页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/content_detail.htm", method = RequestMethod.GET)
	public String contentMessage(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/message/content_message";
	}

	/**
	 * 跳转至信息内容页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/message/content_history.htm", method = RequestMethod.GET)
	public String contentMessageHistory(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/message/content_history";
	}

	/**
	 * 通知公告表审批修改
	 * 
	 * @param from
	 * @param map
	 * @return 通知公告表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/message/add_message_review.htm")
	public String messageReviewEdit(MessageForm form, ModelMap map) {
		messageService.createMessageReview(setBeans(form));
		map.put("sort", CommonChar.SORT_TZ); // 分类
		// 返回到操作成功页面
		return "/message/review_success";

	}

	/**
	 * 通知公告表返回
	 * 
	 * @param from
	 * @param map
	 * @return 通知公告
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/message/message_reback.htm")
	public String messageReback(MessageForm form, ModelMap map) {
		messageService.createMessageReback(setBeans(form));
		map.put("sort", CommonChar.SORT_TZ); // 分类
		// 返回到操作成功页面
		return "/message/review_success";

	}

	/**
	 * 我的拟稿列表页面设置查询条件
	 * 
	 * @param form
	 * @param goodsPage
	 * 
	 * @Author zbq
	 * @Date 2011-8-25
	 */
	private void setSearchKey(MessageForm form, MessagePage messagePage,
			int sort) {
		// 设置查询条件
		messagePage.setCurrentPage(form.getCp()); // 当前页数
		messagePage.setTitle(form.getTitle()); // 标题
		messagePage.setSort(CommonChar.SORT_TZ); // 分类
		messagePage.setStatus(form.getStatus()); // 当前状态
		messagePage.setDraftsDeptId(form.getDraftsDeptId()); // 拟稿部门
		messagePage.setEnabled(form.getEnabled()); // 文件状态
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Storage
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	private Message setBeans(MessageForm form) {
		Message message = new Message();
		BeanUtils.copyProperties(form, message); // 设置表单属性
		return message;
	}

	/**
	 * 跳转至历史记录页面
	 * 
	 * @return 历史记录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/message/message_history.htm", method = RequestMethod.GET)
	public String grpoDetail(long id, ModelMap map) {
		// 取得分组权限详细页面
		List<MessageHistory> messageHistoryList = messageService
				.getMessageHistoryInfo(id);
		map.put("messageId", id);
		map.put("messageHistoryList", messageHistoryList);
		return "message/message_history";
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
	@RequestMapping(value = "/message/look_detail.htm", method = RequestMethod.GET)
	public String messageLookDetail(Long id, ModelMap map) throws Exception {
		
		//获取当前登录ID
		String loginId =SecurityUtils.getLoginId();
		if(loginId == null || "".equals(loginId) || "anonymousUser".equals(loginId)){
			return "/common/no_auth";
		}
		MessageLook messageForList = new MessageLook();
		messageForList.setLoginId(loginId);
		messageForList.setMessageId(id);
		List<MessageLook> messageLookList = messageLookService.getAllMessageLookList(messageForList);
		Integer count = messageLookList.size();
		if (count == 0) {
			MessageLook messageLook = new MessageLook();
			messageLook.setLoginId(loginId);
			messageLook.setMessageId(id);
			messageLookService.addMessageInfo(messageLook);
		}
		List<MessageLook> messageLookListForAll = messageLookService.getAllMessageLookListAll(id);
		map.put("messageLookListForAll", messageLookListForAll);
	
		Message message = messageService.getUserDraftMessageDetail(id);
		map.put("message", message);
		MessageReviewPage page = messageService.getMessageReviewListById(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("page", page);
		return "/message/message_look_detail";
	}
	
	/**
	 * 下载点击事件
	 * 
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	@RequestMapping("/messageDown/download_file.htm")
	public void downloadFile(MessageForm form, HttpServletResponse response) {
		// 文件下载工具类
		FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK", "upload", 21);
		ftpUtil.connectServer("upload");
		ftpUtil.downloadFile(form.getSrcFileName(), response);
	}

}
