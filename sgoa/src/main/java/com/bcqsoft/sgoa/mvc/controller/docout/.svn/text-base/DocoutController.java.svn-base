package com.bcqsoft.sgoa.mvc.controller.docout;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;
import static com.bcqsoft.sgoa.core.security.SecurityUtils.getLoginId;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;
import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.docout.dataobject.Docout;
import com.bcqsoft.sgoa.dao.docout.dataobject.DocoutPage;
import com.bcqsoft.sgoa.dao.docouthistory.dataobject.DocoutHistory;
import com.bcqsoft.sgoa.dao.docoutlook.dataobject.DocoutLook;
import com.bcqsoft.sgoa.dao.docoutreview.dataobject.DocoutReviewPage;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.mvc.form.docout.DocoutForm;
import com.bcqsoft.sgoa.service.approval.ApprovalService;
import com.bcqsoft.sgoa.service.approvaldetail.ApprovalDetailService;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.dept.DeptService;
import com.bcqsoft.sgoa.service.docout.DocoutService;
import com.bcqsoft.sgoa.service.docoutlook.DocoutLookService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 信息控制器
 */
@Controller
public class DocoutController {

	/**
	 * 部门模块业务逻辑类接口
	 */
	@Autowired
	private DeptService deptService;

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private DocoutService docoutService;

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
	private DocoutLookService docoutLookService;
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
	@RequestMapping(value = "/docout/add_docout.htm", method = RequestMethod.GET)
	public String addDocout(ModelMap map) {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("Z");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("d_userName", SecurityUtils.getLoginId());
		map.put("d_fileType", "doc");
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "add_docout");
		// 跳转至信息拟稿页面
		return "/docout/add_docout";
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
	@RequestMapping(value = "/docout/add_docout.htm", method = RequestMethod.POST)
	public String addDocout(DocoutForm form, ModelMap map) {
		// 信息临时表中添加数据
		docoutService.addDocoutInfo(setBeans(form));
		// 跳转至信息拟稿页面
		return "/docout/add_success";
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
	@RequestMapping(value = "/docout/draft_docout.htm", method = RequestMethod.POST)
	public String draftDocout(DocoutForm form, boolean edit, ModelMap map) {
		// 根据参数edit判断是否更新
		if (edit) {
			docoutService.updateDocoutDraftInfo(setBeans(form));
		} else {
			docoutService.addDocoutDraftInfo(setBeans(form));
		}
		// 跳转至信息拟稿页面
		return "/docout/draft_success";
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
	@RequestMapping(value = "/docout/my_draft_list.htm", method = RequestMethod.GET)
	public String myDraftList(DocoutForm outForm, ModelMap map) {
		DocoutPage outPage = new DocoutPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置拟稿人为当前用户ID

		// 根据用户ID查找该用户拟稿的信息
		map.put("page", docoutService.getMyDraftDocoutList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_draft_list");
		// 跳转至信息列表页面
		return "/docout/my_draft_list";
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
	@RequestMapping(value = "/docout/list.htm", method = RequestMethod.GET)
	public String docoutList(DocoutForm outForm, ModelMap map) {
		DocoutPage outPage = new DocoutPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docoutService.getApprovedDocoutList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docout_list");
		// 跳转至信息列表页面
		return "/docout/docout_list";
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
	@RequestMapping(value = "/docout/docout_review_list.htm", method = RequestMethod.GET)
	public String docoutReviewList(DocoutForm outForm, ModelMap map) {
		DocoutPage outPage = new DocoutPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID
		// 取得列表页面按钮名称
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_DOCOUT,CommonChar.MODULE_TYPE_LIST));
		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docoutService.getDocoutReviewList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docout_review_list");
		// 跳转至信息列表页面
		return "/docout/docout_review_list";
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
	@RequestMapping(value = "/docout/docout_doinout_list.htm", method = RequestMethod.GET)
	public String docoutDoinoutList(DocoutForm outForm, ModelMap map) {
		DocoutPage outPage = new DocoutPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docoutService.getDocoutDoinoutList(outPage));
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_DOCOUT,CommonChar.MODULE_TYPE_LIST));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docout_doinout_list");
		// 跳转至信息列表页面
		return "/docout/docout_doinout_list";
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
	@RequestMapping(value = "/docout/docout_search.htm", method = RequestMethod.GET)
	public String docoutSearchList(DocoutForm outForm,ModelMap map) {
		DocoutPage outPage = new DocoutPage();
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setTitle(outForm.getTitle());
		outPage.setStatus(CommonChar.STATUS_FF);
		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docoutService.getDocoutSearchList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docout_search");
		return "/docout/docout_search_list";
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
	@RequestMapping(value = "/docout/my_docout_list.htm", method = RequestMethod.GET)
	public String myDocoutReviewList(DocoutForm outForm, ModelMap map) {
		DocoutPage outPage = new DocoutPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docoutService.getMyDocoutReviewList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_docout_list");
		// 跳转至信息列表页面
		return "/docout/my_docout_list";
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
	@RequestMapping(value = "/docout/del_docout.htm", method = RequestMethod.GET)
	public String deleteDocout(Long id) {
		docoutService.removeOneDocoutInfo(id);
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
	@RequestMapping("/docout/delete_docoutArray.htm")
	public String deleteDocout(String idArray) {
		// 删除收件箱信息
		docoutService.removeOneDocoutInfo(toLongArray(idArray));
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
	@RequestMapping(value = "/docout/docout_back.htm", method = RequestMethod.GET)
	public String backDocout(Long id) {
		docoutService.updateOneDocoutInfo(id);
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
	@RequestMapping(value = "/docout/detail.htm", method = RequestMethod.GET)
	public String docoutDetail(Long id, ModelMap map) throws Exception {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("Z");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Docout docout = docoutService.getUserDraftDocoutDetail(id);
		docout.setMainSendName(commonService.getUsersNameByLoginIds(docout.getMainSend()));
		docout.setCopySendName(commonService.getUsersNameByLoginIds(docout.getCopySend()));
		map.put("docout", docout);
		// 取得核稿人名称
		map.put("reviewName",commonService.getUsersNameByLoginIds(docout.getReviewId()));
		// 取得校对人名称
		if(docout.getProofread() == null || "".equals(docout.getProofread())){
			map.put("proofreadName","");
		} else {
			map.put("proofreadName",commonService.getUsersNameByLoginIds(docout.getProofread()));
		}
		DocoutReviewPage page = docoutService.getDocoutReviewListById(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("page", page);
		return "/docout/docout_detail";
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
	@RequestMapping(value = "/docout/edit_docout.htm", method = RequestMethod.GET)
	public String editDocout(Long id, ModelMap map) {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("Z");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Docout docout = docoutService.getUserDraftDocoutDetail(id);
		// 取得页面下拉框数据
		docout.setMainSendName(commonService.getUsersNameByLoginIds(docout.getMainSend()));
		docout.setCopySendName(commonService.getUsersNameByLoginIds(docout.getCopySend()));
		map.put("docout", docout);
		map.put("loginId", getLoginId()); // 当前登录ID
		// 跳转至信息拟稿页面
		return "/docout/edit_docout";
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
	@RequestMapping(value = "/docout/edit_docout.htm", method = RequestMethod.POST)
	public String editDocout(DocoutForm form, ModelMap map) {
		docoutService.updateDocoutInfo(setBeans(form));
		// 跳转至拟稿成功页面
		return "/docout/add_success";
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
	@RequestMapping(value = "/docout/edit_docout_review.htm", method = RequestMethod.GET)
	public String docoutReviewEdit(Long id, ModelMap map) throws Exception {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户
		//审批流程
		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("Z");
		map.put("approvalList", approvalService.getApprovalList(approvalPage).getApprovalList());
		//办事流程
		ApprovalPage approvalPages = new ApprovalPage();
		approvalPages.setApprovalType("W");
		map.put("approvalLists", approvalService.getApprovalList(approvalPages).getApprovalList());

		String loginId = SecurityUtils.getLoginId();
		// Dept dept = deptService.findDeptInfoByLoginId(loginId);
		// map.put("deptId", dept == null ? "" : dept.getId()); // 部门id
		User user = userService.getUserInfoByLoginId(loginId);
		// 用户查看自己的详细信息
		Docout docout = docoutService.getUserDraftDocoutDetail(id);
		// 查出流程ID
		String approvalId = docout.getApprovalId();
		// 实例流程详细表对象
		ApprovalDetail approvalDetail = new ApprovalDetail();
		// 把流程ID赋值给流程详细表的流程ID
		approvalDetail.setDetailId(approvalId);
		// 吧步骤赋值给流程详细表的步骤
		approvalDetail.setPositionId(user.getPositionId());
		// 获取流程详细表的对象
		ApprovalDetail approvalDetailFor = approvalDetailService.getApprovalDetailForList(approvalDetail);
		// 查出流程详细表审批权限
		String approvalDetailForStatus = approvalDetailFor == null ? "N": approvalDetailFor.getStatus();

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
		docout.setMainSendName(commonService.getUsersNameByLoginIds(docout.getMainSend()));
		docout.setCopySendName(commonService.getUsersNameByLoginIds(docout.getCopySend()));
		map.put("docout", docout);
		DocoutReviewPage page = docoutService.getDocoutReviewListById(id);

		map.put("userName", user == null ? "" : user.getUserName()); // 设置拟稿人名称;
		//内容历史
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("page", page);
		map.put("loginId", SecurityUtils.getLoginId());
		map.put("opinionId", "DO" + DateUtil.getDateTimeForYh());
		// 取得核稿人名称
		map.put("reviewName",commonService.getUsersNameByLoginIds(docout.getReviewId()));
		// 取得列表页面按钮名称
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_DOCOUT,CommonChar.MODULE_TYPE_REVIEW));
		
		// 更改状态为已读
		docout.setStatus(CommonChar.STATUS_YD);
		docoutService.updateDocoutStatusById(docout);
		
		DocoutReviewPage onePage = docoutService.getDocoutReviewListByIdOne(id);
		map.put("onePage", onePage);
		
		// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
		Remind remind = new Remind();
		remind.setBusId(docout.getId());
		remind.setModeName(CommonChar.MODE_DOCOUT);
		remind.setLoginId(SecurityUtils.getLoginId());
		remind.setStatus(CommonChar.REMIND_STATUS_BTX);
		commonService.updateRemindInfoByLoginId(remind);
		
		//取得当前登录人LONGIN_ID
		String loginIddq = SecurityUtils.getLoginId();
		map.put("loginIddq", loginIddq);
		
		//局长秘书loginId
		User users = userService.getUserLoginIdjzms();
		String loginIdjzms = users.getLoginId();
		map.put("loginIdjzms", loginIdjzms);
		return "/docout/review_docout";
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
	@RequestMapping(value = "/docout/content_detail.htm", method = RequestMethod.GET)
	public String contentDocout(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/docout/content_docout";
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
	@RequestMapping(value = "/docout/content_history.htm", method = RequestMethod.GET)
	public String contentDocoutHistory(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/docout/content_history";
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
	@RequestMapping("/docout/add_docout_review.htm")
	public String docoutReviewEdit(DocoutForm form, ModelMap map) {
		docoutService.createDocoutReview(setBeans(form));
		// 返回到操作成功页面
		return "/docout/review_success";

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
	@RequestMapping("/docout/docout_reback.htm")
	public String docoutReback(DocoutForm form, ModelMap map) {
		docoutService.createDocoutReback(setBeans(form));
		// 返回到操作成功页面
		return "/docout/review_success";

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
	private void setSearchKey(DocoutForm form, DocoutPage docoutPage) {
		// 设置查询条件
		docoutPage.setCurrentPage(form.getCp()); // 当前页数
		docoutPage.setTitle(form.getTitle()); // 标题
		docoutPage.setDocoutNum(form.getDocoutNum());//发文字号
		docoutPage.setSort(CommonChar.SORT_TZ); // 分类
		docoutPage.setStatus(form.getStatus()); // 当前状态
		docoutPage.setDraftsDeptId(form.getDraftsDeptId()); // 拟稿部门
		docoutPage.setEnabled(form.getEnabled()); // 文件状态
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
	private Docout setBeans(DocoutForm form) {
		Docout docout = new Docout();
		BeanUtils.copyProperties(form, docout); // 设置表单属性
		if(null==docout.getSupervise()){
			docout.setSupervise(2);
		}
		if(null==docout.getOpen()){
			docout.setOpen(2);
		}
		return docout;
	}

	/**
	 * 跳转至历史记录页面
	 * 
	 * @return 历史记录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/docout/docout_history.htm", method = RequestMethod.GET)
	public String grpoDetail(long id, ModelMap map) {
		// 取得分组权限详细页面
		List<DocoutHistory> docoutHistoryList = docoutService
				.getDocoutHistoryInfo(id);
		map.put("docoutId", id);
		map.put("docoutHistoryList", docoutHistoryList);
		return "docout/docout_history";
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
	@RequestMapping(value = "/docout/look_detail.htm", method = RequestMethod.GET)
	public String docoutLookDetail(Long id, ModelMap map) throws Exception {
		
		//获取当前登录ID
		String loginId =SecurityUtils.getLoginId();
		
		DocoutLook docoutForList = new DocoutLook();
		docoutForList.setLoginId(loginId);
		docoutForList.setDocoutId(id);
		List<DocoutLook> docoutLookList = docoutLookService.getAllDocoutLookList(docoutForList);
		Integer count = docoutLookList.size();
		if (count == 0) {
			DocoutLook docoutLook = new DocoutLook();
			docoutLook.setLoginId(loginId);
			docoutLook.setDocoutId(id);
			docoutLookService.addDocoutInfo(docoutLook);
		}
		List<DocoutLook> docoutLookListForAll = docoutLookService.getAllDocoutLookListAll(id);
		map.put("docoutLookListForAll", docoutLookListForAll);
	
		Docout docout = docoutService.getUserDraftDocoutDetail(id);
		docout.setMainSendName(commonService.getUsersNameByLoginIds(docout.getMainSend()));
		docout.setCopySendName(commonService.getUsersNameByLoginIds(docout.getCopySend()));
		map.put("docout", docout);
		DocoutReviewPage page = docoutService.getDocoutReviewListByIdQf(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("page", page);
		// 取得核稿人名称
		map.put("reviewName",commonService.getUsersNameByLoginIds(docout.getReviewId()));
		// 取得校对人名称
		if(docout.getProofread() == null || "".equals(docout.getProofread())){
			map.put("proofreadName","");
		} else {
			map.put("proofreadName",commonService.getUsersNameByLoginIds(docout.getProofread()));
		}
		return "/docout/docout_look_detail";
	}
	
	/**
	 * 跳转到提交办事页面
	 * 
	 * @param id
	 * @param map
	 * @return 提交办事页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/docout/edit_docout_work.htm", method = RequestMethod.GET)
	public String docoutWorkEdit(Long id, ModelMap map) throws Exception {
		//办事流程
		ApprovalPage approvalPages = new ApprovalPage();
		approvalPages.setApprovalType("W");
		map.put("approvalLists", approvalService.getApprovalList(approvalPages).getApprovalList());

		// 用户查看自己的详细信息
		Docout docout = docoutService.getUserDraftDocoutDetail(id);
		// 查出流程ID
		String approvalId = docout.getApprovalIds();
		
		String loginId = SecurityUtils.getLoginId();
		// Dept dept = deptService.findDeptInfoByLoginId(loginId);
		// map.put("deptId", dept == null ? "" : dept.getId()); // 部门id
		User user = userService.getUserInfoByLoginId(loginId);
		// 实例流程详细表对象
		ApprovalDetail approvalDetail = new ApprovalDetail();
		// 把流程ID赋值给流程详细表的流程ID
		approvalDetail.setDetailId(approvalId);
		// 吧步骤赋值给流程详细表的步骤
		approvalDetail.setPositionId(user.getPositionId());
		// 获取流程详细表的对象
		ApprovalDetail approvalDetailFor = approvalDetailService.getApprovalDetailForList(approvalDetail);
		// 查出流程详细表审批权限
		String approvalDetailForStatus = approvalDetailFor == null ? "N": approvalDetailFor.getStatus();
		// 创建一个新的流程详细对象
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
		docout.setMainSendName(commonService.getUsersNameByLoginIds(docout.getMainSend()));
		docout.setCopySendName(commonService.getUsersNameByLoginIds(docout.getCopySend()));
		map.put("docout", docout);
		DocoutReviewPage page = docoutService.getDocoutReviewListById(id);
		
		
		map.put("userName", user == null ? "" : user.getUserName()); // 设置拟稿人名称;
		// 内容历史
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("page", page);
		map.put("loginId", SecurityUtils.getLoginId());
		map.put("opinionId", "DO" + DateUtil.getDateTimeForYh());
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_DOCOUT,CommonChar.MODULE_TYPE_REVIEW));
		// 取得核稿人名称
		map.put("reviewName",commonService.getUsersNameByLoginIds(docout.getReviewId()));
		
		
		DocoutReviewPage onePage = docoutService.getDocoutReviewListByIdOne(id);
		map.put("onePage", onePage);
		// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
		Remind remind = new Remind();
		remind.setBusId(docout.getId());
		remind.setModeName(CommonChar.MODE_DOCOUT);
		remind.setLoginId(SecurityUtils.getLoginId());
		remind.setStatus(CommonChar.REMIND_STATUS_BTX);
		commonService.updateRemindInfoByLoginId(remind);
		return "/docout/work_docout";
	}
	
	/**
	 * 办事修改
	 * 
	 * @param from
	 * @param map
	 * @return 办事修改
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/docout/add_docout_work.htm")
	public String docoutWorkEdit(DocoutForm form, ModelMap map) {
		docoutService.createDocoutWork(setBeans(form));
		// 返回到操作成功页面
		return "/docout/work_success";

	}
	/**
	 * 已收发文查询
	 * 
	 * @param from
	 * @param map
	 * @return 已收发文查询
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/docout/docout_received.htm")
	public String docoutReceived(DocoutForm outForm, ModelMap map) {
		DocoutPage outPage = new DocoutPage();
		setSearchKey(outForm, outPage); // 设置查询条件
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		outPage.setReceivedId(getLoginId()); // 设置拟稿人为当前用户ID
		// 根据用户ID查找该用户拟稿的信息
		map.put("page", docoutService.getMyDocoutList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docout_received");
		// 返回到操作成功页面
		return "/docout/docout_received";


	}

	/**
	 * 返回
	 * 
	 * @param from
	 * @param map
	 * @return 返回
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/docout/dooutin_reback.htm")
	public String dooutinReback(DocoutForm form, ModelMap map) {
		docoutService.createDooutinReback(setBeans(form));
		// 返回到操作成功页面
		return "/docout/work_success";

	}
	
	/**
	 * 点击查看详细
	 * 
	 * @param id
	 * @param map
	 * @return 详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/docout/detail_qf.htm", method = RequestMethod.GET)
	public String docoutDetailQf(Long id, ModelMap map) throws Exception {

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("Z");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Docout docout = docoutService.getUserDraftDocoutDetail(id);
		docout.setMainSendName(commonService.getUsersNameByLoginIds(docout.getMainSend()));
		docout.setCopySendName(commonService.getUsersNameByLoginIds(docout.getCopySend()));
		map.put("docout", docout);

		DocoutReviewPage page = docoutService.getDocoutReviewListByIdQf(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("page", page);
		// 取得核稿人名称
		map.put("reviewName",commonService.getUsersNameByLoginIds(docout.getReviewId()));
		// 取得校对人名称
		if(docout.getProofread() == null || "".equals(docout.getProofread())){
			map.put("proofreadName","");
		} else {
			map.put("proofreadName",commonService.getUsersNameByLoginIds(docout.getProofread()));
		}
		return "/docout/docout_detail_qf";
	}

	/**
	 * 我的督办列表
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/docout/docout_isduban.htm", method = RequestMethod.GET)
	public String myDubanList(DocoutForm outForm, ModelMap map) {
		DocoutPage outPage = new DocoutPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件

		// 根据用户ID查找该用户拟稿的信息
		map.put("page", docoutService.getMyDubanDocoutList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docout_isduban");
		// 跳转至信息列表页面
		return "/docout/docout_isduban";
	}
	
}
