package com.bcqsoft.sgoa.mvc.controller.docin;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;
import static com.bcqsoft.sgoa.core.security.SecurityUtils.getLoginId;
import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;
import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docin.dataobject.DocinPage;
import com.bcqsoft.sgoa.dao.docinbox.dataobject.DocinBox;
import com.bcqsoft.sgoa.dao.docinhistory.dataobject.DocinHistory;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReview;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReviewPage;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.mvc.form.docin.DocinForm;
import com.bcqsoft.sgoa.mvc.form.resfile.ResFileForm;
import com.bcqsoft.sgoa.service.approval.ApprovalService;
import com.bcqsoft.sgoa.service.approvaldetail.ApprovalDetailService;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.dept.DeptService;
import com.bcqsoft.sgoa.service.docin.DocinService;
import com.bcqsoft.sgoa.service.docinbox.DocinBoxService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 信息控制器
 */
@Controller
public class DocinController {

	/**
	 * 部门模块业务逻辑类接口
	 */
	@Autowired
	private DeptService deptService;

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private DocinService docinService;

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
	private DocinBoxService docinBoxService;
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
	@RequestMapping(value = "/docin/add_docin.htm", method = RequestMethod.GET)
	public String addDocin(ModelMap map) {
		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("Y");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("d_userName", SecurityUtils.getLoginId());
		map.put("d_fileType", "doc");
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "add_docin");
		
		//取得当前登录人LONGIN_ID的职务ID
		String loginIddq = SecurityUtils.getLoginId();
		map.put("loginIddq", loginIddq);
		User userzw = userService.getUserLoginIdjyy(loginIddq);
		map.put("userzwjyy", userzw.getPositionId());
		
		//办公室主任loginId
		User user = new User();
		user.setPositionId(Long.valueOf(4));
		user.setDeptId(Long.valueOf(30));
		User users = userService.getUserLoginIdByPByD(user);
		map.put("loginIdbgszr", users.getLoginId());
		map.put("loginIdbgszrname", users.getUserName());
		// 跳转至信息拟稿页面
		return "/docin/add_docin";
	}
	
	@RequestMapping(value = "/docin/max_docin.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> max(String reNum)
			throws UnsupportedEncodingException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//取出最大值
		String docinStr = docinService.getDocinList(reNum);
		dataMap.put("docinStr", docinStr);
		return dataMap;
	}
	
	@RequestMapping(value = "/docin/edit_docnum.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> edit(long id)
			throws UnsupportedEncodingException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Docin docin = docinService.getUserDraftDocinDetail(id);
		dataMap.put("registerNum", docin.getRegisterNum());
		return dataMap;
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
	@RequestMapping(value = "/docin/add_docin.htm", method = RequestMethod.POST)
	public String addDocin(DocinForm form, ModelMap map) {
		// 信息临时表中添加数据
		docinService.addDocinInfo(setBeans(form));
		// 跳转至信息拟稿页面
		return "/docin/add_success";
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
	@RequestMapping(value = "/docin/draft_docin.htm", method = RequestMethod.POST)
	public String draftDocin(DocinForm form, boolean edit, ModelMap map) {
		// 根据参数edit判断是否更新
		if (edit) {
			docinService.updateDocinDraftInfo(setBeans(form));
		} else {
			docinService.addDocinDraftInfo(setBeans(form));
		}
		// 跳转至信息拟稿页面
		return "/docin/draft_success";
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
	@RequestMapping(value = "/docin/my_draft_list.htm", method = RequestMethod.GET)
	public String myDraftList(DocinForm outForm, ModelMap map) {
		DocinPage outPage = new DocinPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setLoginId(getLoginId()); // 设置拟稿人为当前用户ID

		// 根据用户ID查找该用户拟稿的信息
		map.put("page", docinService.getMyDraftDocinList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_draft_list");
		// 跳转至信息列表页面
		return "/docin/my_draft_list";
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
	@RequestMapping(value = "/docin/list.htm", method = RequestMethod.GET)
	public String docinList(DocinForm outForm, ModelMap map) {
		DocinPage outPage = new DocinPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setLoginId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docinService.getApprovedDocinList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docin_list");
		// 跳转至信息列表页面
		return "/docin/docin_list";
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
	@RequestMapping(value = "/docin/docin_review_list.htm", method = RequestMethod.GET)
	public String docinReviewList(DocinForm outForm, ModelMap map) {
		DocinPage outPage = new DocinPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setLoginId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docinService.getDocinReviewList(outPage));
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_DOCIN,CommonChar.MODULE_TYPE_LIST));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docin_review_list");
		// 跳转至信息列表页面
		return "/docin/docin_review_list";
	}
	
	/**
	 * 流程变更列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/docin/docin_lcbg_list.htm", method = RequestMethod.GET)
	public String docinLcbgList(DocinForm outForm, ModelMap map) {
		DocinPage outPage = new DocinPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docinService.getDocinLcbgList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docin_lcbg_list");
		// 跳转至信息列表页面
		return "/docin/docin_lcbg_list";
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
	@RequestMapping(value = "/docin/docin_doinout_list.htm", method = RequestMethod.GET)
	public String docinDoinoutList(DocinForm outForm, ModelMap map) {
		DocinPage outPage = new DocinPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setLoginId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docinService.getDocinDoinoutList(outPage));
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_DOCIN,CommonChar.MODULE_TYPE_LIST));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docin_doinout_list");
		// 跳转至信息列表页面
		return "/docin/docin_doinout_list";
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
	@RequestMapping(value = "/docin/docin_search.htm", method = RequestMethod.GET)
	public String docinSearchList(DocinForm outForm, ModelMap map) {
		DocinPage outPage = new DocinPage();
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setTitle(outForm.getTitle());
		outPage.setStatus(CommonChar.STATUS_FF);
		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docinService.getDocinSearchList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docin_search");
		return "/docin/docin_search_list";
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
	@RequestMapping(value = "/docin/my_docin_list.htm", method = RequestMethod.GET)
	public String myDocinReviewList(DocinForm outForm, ModelMap map) {
		DocinPage outPage = new DocinPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setLoginId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docinService.getMyDocinReviewList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_docin_list");
		// 跳转至信息列表页面
		return "/docin/my_docin_list";
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
	@RequestMapping(value = "/docin/del_docin.htm", method = RequestMethod.GET)
	public String deleteDocin(Long id) {
		docinService.removeOneDocinInfo(id);
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
	@RequestMapping("/docin/delete_docinArray.htm")
	public String deleteDocin(String idArray) {
		// 删除收件箱信息
		docinService.removeOneDocinInfo(toLongArray(idArray));
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
	@RequestMapping(value = "/docin/docin_back.htm", method = RequestMethod.GET)
	public String backDocin(Long id) {
		docinService.updateOneDocinInfo(id);
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
	@RequestMapping(value = "/docin/detail.htm", method = RequestMethod.GET)
	public String docinDetail(Long id, ModelMap map) throws Exception {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("Y");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Docin docin = docinService.getUserDraftDocinDetail(id);
		docin.setReceiverName(commonService.getUsersNameByLoginIds(docin.getReceiverId()));
		map.put("docin", docin);

		DocinReviewPage onePage = docinService.getDocinReviewListByIdOne(id);
		map.put("onePage", onePage);
		// 取得审核意见信息
		List<DocinReview> drList = onePage.getDocinReviewList();
		StringBuffer sBuffer1 = new StringBuffer();
		StringBuffer sBuffer2 = new StringBuffer();
		StringBuffer sBuffer3 = new StringBuffer();
		StringBuffer sBuffer4 = new StringBuffer();
		
		// 记录相等的序号
		for (int i = 0; i < drList.size(); i++) {
			DocinReview dReviewI = drList.get(i);
			if ("1".equals(dReviewI.getSeat())) {
				sBuffer1.append(dReviewI.getOpinion());
				sBuffer1.append("<br>");
				sBuffer1.append(dReviewI.getCurrentOptName());
				sBuffer1.append("[");
				sBuffer1.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer1.append("]<br>");
			} else if ("2".equals(dReviewI.getSeat())) {
				sBuffer2.append(dReviewI.getOpinion());
				sBuffer2.append("<br>");
				sBuffer2.append(dReviewI.getCurrentOptName());
				sBuffer2.append("[");
				sBuffer2.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer2.append("]<br>");
			} else if ("3".equals(dReviewI.getSeat())) {
				sBuffer3.append(dReviewI.getOpinion());
				sBuffer3.append("<br>");
				sBuffer3.append(dReviewI.getCurrentOptName());
				sBuffer3.append("[");
				sBuffer3.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer3.append("]<br>");
			} else if ("4".equals(dReviewI.getSeat())) {
				sBuffer4.append(dReviewI.getOpinion());
				sBuffer4.append("<br>");
				sBuffer4.append(dReviewI.getCurrentOptName());
				sBuffer4.append("[");
				sBuffer4.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer4.append("]<br>");
			}  
		}
		map.put("opinion1", sBuffer1);
		map.put("opinion2", sBuffer2);
		map.put("opinion3", sBuffer3);
		map.put("opinion4", sBuffer4);
		map.put("docinFjPage", docinService.findDocinFjInfoByDocinId(docin.getId()));
		return "/docin/docin_detail";
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
	@RequestMapping(value = "/docin/edit_docin.htm", method = RequestMethod.GET)
	public String editDocin(Long id, ModelMap map) {
		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("Y");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Docin docin = docinService.getUserDraftDocinDetail(id);
		docin.setReceiverName(commonService.getUsersNameByLoginIds(docin.getReceiverId()));

		// 取得页面下拉框数据
		map.put("docin", docin);
		map.put("loginId", getLoginId()); // 当前登录ID
		//取得当前登录人LONGIN_ID的职务ID
		String loginIddq = SecurityUtils.getLoginId();
		map.put("loginIddq", loginIddq);
		User userzw = userService.getUserLoginIdjyy(loginIddq);
		map.put("userzwjyy", userzw.getPositionId());
		
		//办公室主任loginId
		User user = new User();
		user.setPositionId(Long.valueOf(4));
		user.setDeptId(Long.valueOf(30));
		User users = userService.getUserLoginIdByPByD(user);
		map.put("loginIdbgszr", users.getLoginId());
		map.put("loginIdbgszrname", users.getUserName());
		map.put("docinFjPage", docinService.findDocinFjInfoByDocinId(docin.getId()));
		// 跳转至信息拟稿页面
		return "/docin/edit_docin";
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
	@RequestMapping(value = "/docin/edit_docin.htm", method = RequestMethod.POST)
	public String editDocin(DocinForm form, ModelMap map) {
		docinService.updateDocinInfo(setBeans(form));
		// 跳转至拟稿成功页面
		return "/docin/add_success";
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
	@RequestMapping(value = "/docin/edit_docin_review.htm", method = RequestMethod.GET)
	public String docinReviewEdit(Long id, ModelMap map) throws Exception {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户
		// 审批流程
		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("Y");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		// 办事流程
		ApprovalPage approvalPages = new ApprovalPage();
		approvalPages.setApprovalType("V");
		map.put("approvalLists", approvalService.getApprovalList(approvalPages)
				.getApprovalList());

		// 用户查看自己的详细信息
		Docin docin = docinService.getUserDraftDocinDetail(id);
		docin.setReceiverName(commonService.getUsersNameByLoginIds(docin.getReceiverId()));

		String loginId = SecurityUtils.getLoginId();
		// Dept dept = deptService.findDeptInfoByLoginId(loginId);
		// map.put("deptId", dept == null ? "" : dept.getId()); // 部门id
		User user = userService.getUserInfoByLoginId(loginId);
		
		// 查出流程ID
		String approvalId = docin.getApprovalId();
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
//		ApprovalDetail approvalDetailForNext=new ApprovalDetail();
//		approvalDetailForNext.setId(approvalDetailFor.getId());
//		approvalDetailForNext.setDetailId(approvalId);
//		List<ApprovalDetail> approvalDetailList = approvalDetailService.getApprovalDetailForIdByPId(approvalDetailForNext);
		Integer stepNext = null;
		if (docin.getStep() != null) {
			stepNext = docin.getStep() + 1;
		}
		map.put("stepNext", stepNext);
		
		
		map.put("docin", docin);
		DocinReviewPage page = docinService.getDocinReviewListById(id);

		map.put("userName", user == null ? "" : user.getUserName()); // 设置拟稿人名称;
		// 内容历史
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("page", page);
		map.put("loginId", SecurityUtils.getLoginId());
		map.put("opinionId", "DO" + DateUtil.getDateTimeForYh());
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_DOCIN,CommonChar.MODULE_TYPE_REVIEW));

		// 设置状态为已读
		docin.setStatus(CommonChar.STATUS_YD);
		docinService.updateDocinStatusById(docin);
		
		DocinReviewPage onePage = docinService.getDocinReviewListByIdOne(id);
		map.put("onePage", onePage);
		// 取得审核意见信息
		List<DocinReview> drList = onePage.getDocinReviewList();
		StringBuffer sBuffer1 = new StringBuffer();
		StringBuffer sBuffer2 = new StringBuffer();
		StringBuffer sBuffer3 = new StringBuffer();
		StringBuffer sBuffer4 = new StringBuffer();
		
		// 记录相等的序号
		for (int i = 0; i < drList.size(); i++) {
			DocinReview dReviewI = drList.get(i);
			if ("1".equals(dReviewI.getSeat())) {
				sBuffer1.append(dReviewI.getOpinion());
				sBuffer1.append("<br>");
				sBuffer1.append(dReviewI.getCurrentOptName());
				sBuffer1.append("[");
				sBuffer1.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer1.append("]<br>");
			} else if ("2".equals(dReviewI.getSeat())) {
				sBuffer2.append(dReviewI.getOpinion());
				sBuffer2.append("<br>");
				sBuffer2.append(dReviewI.getCurrentOptName());
				sBuffer2.append("[");
				sBuffer2.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer2.append("]<br>");
			} else if ("3".equals(dReviewI.getSeat())) {
				sBuffer3.append(dReviewI.getOpinion());
				sBuffer3.append("<br>");
				sBuffer3.append(dReviewI.getCurrentOptName());
				sBuffer3.append("[");
				sBuffer3.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer3.append("]<br>");
			} else if ("4".equals(dReviewI.getSeat())) {
				sBuffer4.append(dReviewI.getOpinion());
				sBuffer4.append("<br>");
				sBuffer4.append(dReviewI.getCurrentOptName());
				sBuffer4.append("[");
				sBuffer4.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer4.append("]<br>");
			}   
		}
		map.put("opinion1", sBuffer1);
		map.put("opinion2", sBuffer2);
		map.put("opinion3", sBuffer3);
		map.put("opinion4", sBuffer4);
		
		//取得按钮状态
		boolean btnStatus = false;
		boolean submitStatus = false;
		DocinReviewPage reviewPage = docinService.getDocinReviewListById(id);
		List<DocinReview> reviewList = reviewPage.getDocinReviewList();
		String[] optIdStr = docin.getNextOptId().split(",");
		for (DocinReview docinReview : reviewList) {
			if (docinReview.getCurrentOptId().equals(SecurityUtils.getLoginId())) {
				if (Long.valueOf(docin.getStep()).equals(docinReview.getStepId())) {
					btnStatus = true;
				}
			}
		}
		Integer countOptId = 1;
		for (DocinReview docinReview : reviewList) {
			if (Long.valueOf(docin.getStep()).equals(docinReview.getStepId())) {
				for (String str : optIdStr) {
					if (docinReview.getCurrentOptId().equals(str)) {
						countOptId++;
					}
				}
			}
		}
		if (countOptId == optIdStr.length) {
			submitStatus = true;
		}
		map.put("btnStatus", btnStatus);
		map.put("reviewStep", docin.getStep());
		map.put("submitStatus", submitStatus);
		
		// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
		Remind remind = new Remind();
		remind.setBusId(docin.getId());
		remind.setModeName(CommonChar.MODE_DOCIN);
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
		
		//机要员loginId
		User userjyy = userService.getUserLoginIdjyyd();
		String loginIdjyy = userjyy.getLoginId();
		map.put("loginIdjyy", loginIdjyy);
		
		//取得当前登录人LONGIN_ID的职务ID
		//User userzw = userService.getUserLoginIdjyy(loginIddq);
		long zwId = user.getPositionId();
		map.put("zwId", zwId);
		long deptId = user.getDeptId();
		map.put("deptId", deptId);
		map.put("docinFjPage", docinService.findDocinFjInfoByDocinId(docin.getId()));
		return "/docin/review_docin";
	}
	
	/**
	 * 意见添加接口
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/docin/review_option_add.htm", method = RequestMethod.GET)
	@ResponseBody
	public boolean reViewOption(String docInId,String opinion,String reviewStep,String seat, ModelMap map) {
		
		DocinReview docinReview = new DocinReview();
		docinReview.setStepId(Long.valueOf(reviewStep));
		docinReview.setCurrentOptId(SecurityUtils.getLoginId());
		docinReview.setOpinion(opinion);
		docinReview.setDocinId(Long.valueOf(docInId));
		docinReview.setDoAction(2);
		docinReview.setSeat(seat);
		boolean result = docinService.createDocinReviewOption(docinReview);
		// 跳转至信息拟稿页面
		return result;
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
	@RequestMapping(value = "/docin/content_detail.htm", method = RequestMethod.GET)
	public String contentDocin(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/docin/content_docin";
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
	@RequestMapping(value = "/docin/content_history.htm", method = RequestMethod.GET)
	public String contentDocinHistory(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/docin/content_history";
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
	@RequestMapping("/docin/add_docin_review.htm")
	public String docinReviewEdit(DocinForm form, ModelMap map) {
		DocinReview docinReview = new DocinReview();
		docinReview.setStepId(Long.valueOf(form.getReviewStep()));
		docinReview.setCurrentOptId(SecurityUtils.getLoginId());
		docinReview.setOpinion(form.getOpinion());
		docinReview.setDocinId(form.getId());
		docinReview.setDoAction(2);
		docinReview.setSeat(form.getSeat());
		boolean result = docinService.createDocinReviewOption(docinReview);
		// 跳转至信息拟稿页面
		//取得按钮状态
		if (result) {
			boolean btnStatus = false;
			// 用户查看自己的详细信息
			Docin docin = docinService.getUserDraftDocinDetail(form.getId());
			DocinReviewPage reviewPage = docinService.getDocinReviewListById(form.getId());
			List<DocinReview> reviewList = reviewPage.getDocinReviewList();
			String[] optIdStr = docin.getNextOptId().split(",");
			Integer countOptId = 0;
			for (DocinReview docinReviewObj : reviewList) {
				if (Long.valueOf(docin.getStep()).equals(docinReviewObj.getStepId())) {
					for (String str : optIdStr) {
						if (docinReviewObj.getCurrentOptId().equals(str)) {
							countOptId++;
						}
					}
				}
			}
			if (countOptId == optIdStr.length) {
				btnStatus = true;
			}
			if (btnStatus) {
				docinService.createDocinReview(setBeans(form));
			}
			else{
				if(docin.getYxOptId()!=null){
					String yxOptId = docin.getYxOptId()+","+form.getYxOptId();
					Docin docinObj = new Docin();
					docinObj.setId(form.getId());
					docinObj.setYxOptId(yxOptId);
					docinService.updateDocinByYxOptId(docinObj);
				}
				else{
					String yxOptId = form.getYxOptId();
					Docin docinObj = new Docin();
					docinObj.setId(form.getId());
					docinObj.setYxOptId(yxOptId);
					docinService.updateDocinByYxOptId(docinObj);
				}
			}
		}
		// 返回到操作成功页面
		return "/docin/review_success";
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
	@RequestMapping("/docin/add_docin_review_ms.htm")
	public String docinReviewadd(DocinForm form, ModelMap map) {
		// 跳转至信息拟稿页面
		//取得按钮状态
		docinService.createDocinReview(setBeans(form));
		// 当位置为5的时候
		if ("5".equals(form.getSeat())) {
			DocinReview docinReview = new DocinReview();
			docinReview.setStepId(Long.valueOf(form.getReviewStep()));
			docinReview.setCurrentOptId(SecurityUtils.getLoginId());
			docinReview.setOpinion(form.getOpinion());
			docinReview.setDocinId(form.getId());
			docinReview.setDoAction(2);
			docinReview.setSeat(form.getSeat());
			docinService.createDocinReviewOption(docinReview);
		}
		// 返回到操作成功页面
		return "/docin/review_success";
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
	@RequestMapping("/docin/docin_reback.htm")
	public String docinReback(DocinForm form, ModelMap map) {
		docinService.createDocinReback(setBeans(form));
		// 返回到操作成功页面
		return "/docin/review_success";

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
	private void setSearchKey(DocinForm form, DocinPage docinPage) {
		// 设置查询条件
		docinPage.setCurrentPage(form.getCp()); // 当前页数
		docinPage.setTitle(form.getTitle()); // 标题
		docinPage.setTextTime(form.getTextTime()); // 标题
		docinPage.setSort(CommonChar.SORT_TZ); // 分类
		docinPage.setStatus(form.getStatus()); // 当前状态
		docinPage.setEnabled(form.getEnabled()); // 文件状态
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
	private Docin setBeans(DocinForm form) {
		Docin docin = new Docin();
		BeanUtils.copyProperties(form, docin); // 设置表单属性
		docin.setLoginId(SecurityUtils.getLoginId());
		if(null==docin.getSupervise()){
			docin.setSupervise(2);
		}
		return docin;
	}

	/**
	 * 跳转至历史记录页面
	 * 
	 * @return 历史记录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/docin/docin_history.htm", method = RequestMethod.GET)
	public String grpoDetail(long id, ModelMap map) {
		// 取得分组权限详细页面
		List<DocinHistory> docinHistoryList = docinService
				.getDocinHistoryInfo(id);
		map.put("docinId", id);
		map.put("docinHistoryList", docinHistoryList);
		return "docin/docin_history";
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
	@RequestMapping(value = "/docin/look_detail.htm", method = RequestMethod.GET)
	public String docinBoxDetail(Long id, ModelMap map) throws Exception {

		List<DocinBox> docinBoxListForAll = docinBoxService
				.getAllDocinBoxListAll(id);
		map.put("docinBoxListForAll", docinBoxListForAll);

		Docin docin = docinService.getUserDraftDocinDetail(id);
		docin.setReceiverName(commonService.getUsersNameByLoginIds(docin.getReceiverId()));

		map.put("docin", docin);
		DocinReviewPage page = docinService.getDocinReviewListByIdQf(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("page", page);
		// 取得审核意见信息
		// 取得审核意见信息
		List<DocinReview> drList = page.getDocinReviewList();
		StringBuffer sBuffer1 = new StringBuffer();
		StringBuffer sBuffer2 = new StringBuffer();
		StringBuffer sBuffer3 = new StringBuffer();
		StringBuffer sBuffer4 = new StringBuffer();
		
		// 记录相等的序号
		for (int i = 0; i < drList.size(); i++) {
			DocinReview dReviewI = drList.get(i);
			if ("1".equals(dReviewI.getSeat())) {
				sBuffer1.append(dReviewI.getOpinion());
				sBuffer1.append("<br>");
				sBuffer1.append(dReviewI.getCurrentOptName());
				sBuffer1.append("[");
				sBuffer1.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer1.append("]<br>");
			} else if ("2".equals(dReviewI.getSeat())) {
				sBuffer2.append(dReviewI.getOpinion());
				sBuffer2.append("<br>");
				sBuffer2.append(dReviewI.getCurrentOptName());
				sBuffer2.append("[");
				sBuffer2.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer2.append("]<br>");
			} else if ("3".equals(dReviewI.getSeat())) {
				sBuffer3.append(dReviewI.getOpinion());
				sBuffer3.append("<br>");
				sBuffer3.append(dReviewI.getCurrentOptName());
				sBuffer3.append("[");
				sBuffer3.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer3.append("]<br>");
			} else if ("4".equals(dReviewI.getSeat())) {
				sBuffer4.append(dReviewI.getOpinion());
				sBuffer4.append("<br>");
				sBuffer4.append(dReviewI.getCurrentOptName());
				sBuffer4.append("[");
				sBuffer4.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer4.append("]<br>");
			}  
		}
		map.put("opinion1", sBuffer1);
		map.put("opinion2", sBuffer2);
		map.put("opinion3", sBuffer3);
		map.put("opinion4", sBuffer4);
		map.put("docinFjPage", docinService.findDocinFjInfoByDocinId(docin.getId()));
		return "/docin/docin_look_detail";
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
	@RequestMapping(value = "/docin/edit_docin_work.htm", method = RequestMethod.GET)
	public String docinWorkEdit(Long id, ModelMap map) throws Exception {
		// 办事流程
		ApprovalPage approvalPages = new ApprovalPage();
		approvalPages.setApprovalType("V");
		map.put("approvalLists", approvalService.getApprovalList(approvalPages)
				.getApprovalList());

		// 用户查看自己的详细信息
		Docin docin = docinService.getUserDraftDocinDetail(id);
		docin.setReceiverName(commonService.getUsersNameByLoginIds(docin.getReceiverId()));

		String loginId = SecurityUtils.getLoginId();
		// Dept dept = deptService.findDeptInfoByLoginId(loginId);
		// map.put("deptId", dept == null ? "" : dept.getId()); // 部门id
		User user = userService.getUserInfoByLoginId(loginId);
		// 查出流程ID
		String approvalId = docin.getApprovalIds();
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
		
		map.put("docin", docin);
		DocinReviewPage page = docinService.getDocinReviewListById(id);

		map.put("userName", user == null ? "" : user.getUserName()); // 设置拟稿人名称;
		// 内容历史
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("page", page);
		map.put("loginId", SecurityUtils.getLoginId());
		map.put("opinionId", "DO" + DateUtil.getDateTimeForYh());
		map.put("pageButtonName", commonService.getButtonName(CommonChar.MODULE_DOCIN,CommonChar.MODULE_TYPE_REVIEW));
		
		DocinReviewPage onePage = docinService.getDocinReviewListByIdOne(id);
		map.put("onePage", onePage);
		// 取得审核意见信息
		List<DocinReview> drList = onePage.getDocinReviewList();
		StringBuffer sBuffer1 = new StringBuffer();
		StringBuffer sBuffer2 = new StringBuffer();
		StringBuffer sBuffer3 = new StringBuffer();
		StringBuffer sBuffer4 = new StringBuffer();
		
		// 记录相等的序号
		for (int i = 0; i < drList.size(); i++) {
			DocinReview dReviewI = drList.get(i);
			if ("1".equals(dReviewI.getSeat())) {
				sBuffer1.append(dReviewI.getOpinion());
				sBuffer1.append("<br>");
				sBuffer1.append(dReviewI.getCurrentOptName());
				sBuffer1.append("[");
				sBuffer1.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer1.append("]<br>");
			} else if ("2".equals(dReviewI.getSeat())) {
				sBuffer2.append(dReviewI.getOpinion());
				sBuffer2.append("<br>");
				sBuffer2.append(dReviewI.getCurrentOptName());
				sBuffer2.append("[");
				sBuffer2.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer2.append("]<br>");
			} else if ("3".equals(dReviewI.getSeat())) {
				sBuffer3.append(dReviewI.getOpinion());
				sBuffer3.append("<br>");
				sBuffer3.append(dReviewI.getCurrentOptName());
				sBuffer3.append("[");
				sBuffer3.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer3.append("]<br>");
			} else if ("4".equals(dReviewI.getSeat())) {
				sBuffer4.append(dReviewI.getOpinion());
				sBuffer4.append("<br>");
				sBuffer4.append(dReviewI.getCurrentOptName());
				sBuffer4.append("[");
				sBuffer4.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer4.append("]<br>");
			}  
		}
		map.put("opinion1", sBuffer1);
		map.put("opinion2", sBuffer2);
		map.put("opinion3", sBuffer3);
		map.put("opinion4", sBuffer4);
		// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
		Remind remind = new Remind();
		remind.setBusId(docin.getId());
		remind.setModeName(CommonChar.MODE_DOCIN);
		remind.setLoginId(SecurityUtils.getLoginId());
		remind.setStatus(CommonChar.REMIND_STATUS_BTX);
		commonService.updateRemindInfoByLoginId(remind);
		map.put("docinFjPage", docinService.findDocinFjInfoByDocinId(docin.getId()));
		return "/docin/work_docin";
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
	@RequestMapping("/docin/add_docin_work.htm")
	public String docinWorkEdit(DocinForm form, ModelMap map) {
		docinService.createDocinWork(setBeans(form));
		// 返回到操作成功页面
		return "/docin/work_success";

	}

	/**
	 * 已收收文查询
	 * 
	 * @param from
	 * @param map
	 * @return 已收收文查询
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/docin/docin_received.htm")
	public String docinReceived(DocinForm outForm,ModelMap map) {
		DocinPage outPage = new DocinPage();
		setSearchKey(outForm, outPage); // 设置查询条件
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		outPage.setReceivedId(getLoginId()); // 设置拟稿人为当前用户ID
		// 根据用户ID查找该用户拟稿的信息
		map.put("page", docinService.getMyDocinList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docin_received");
		// 返回到操作成功页面
		return "/docin/docin_received";

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
	@RequestMapping("/docin/doinout_reback.htm")
	public String doinoutReback(DocinForm form, ModelMap map) {
		docinService.createDoinoutReback(setBeans(form));
		// 返回到操作成功页面
		return "/docin/work_success";

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
	@RequestMapping(value = "/docin/detail_qf.htm", method = RequestMethod.GET)
	public String docinDetailQf(Long id, ModelMap map) throws Exception {

		ApprovalPage approvalPage = new ApprovalPage();
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Docin docin = docinService.getUserDraftDocinDetail(id);
		docin.setReceiverName(commonService.getUsersNameByLoginIds(docin.getReceiverId()));

		map.put("docin", docin);

		DocinReviewPage page = docinService.getDocinReviewListByIdQf(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("page", page);
		DocinReviewPage onePage = docinService.getDocinReviewListByIdOne(id);
		map.put("onePage", onePage);
		// 取得审核意见信息
		List<DocinReview> drList = onePage.getDocinReviewList();
		StringBuffer sBuffer1 = new StringBuffer();
		StringBuffer sBuffer2 = new StringBuffer();
		StringBuffer sBuffer3 = new StringBuffer();
		StringBuffer sBuffer4 = new StringBuffer();
		
		// 记录相等的序号
		for (int i = 0; i < drList.size(); i++) {
			DocinReview dReviewI = drList.get(i);
			if ("1".equals(dReviewI.getSeat())) {
				sBuffer1.append(dReviewI.getOpinion());
				sBuffer1.append("<br>");
				sBuffer1.append(dReviewI.getCurrentOptName());
				sBuffer1.append("[");
				sBuffer1.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer1.append("]<br>");
			} else if ("2".equals(dReviewI.getSeat())) {
				sBuffer2.append(dReviewI.getOpinion());
				sBuffer2.append("<br>");
				sBuffer2.append(dReviewI.getCurrentOptName());
				sBuffer2.append("[");
				sBuffer2.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer2.append("]<br>");
			} else if ("3".equals(dReviewI.getSeat())) {
				sBuffer3.append(dReviewI.getOpinion());
				sBuffer3.append("<br>");
				sBuffer3.append(dReviewI.getCurrentOptName());
				sBuffer3.append("[");
				sBuffer3.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer3.append("]<br>");
			} else if ("4".equals(dReviewI.getSeat())) {
				sBuffer4.append(dReviewI.getOpinion());
				sBuffer4.append("<br>");
				sBuffer4.append(dReviewI.getCurrentOptName());
				sBuffer4.append("[");
				sBuffer4.append(DateUtil.getDateTimeForYMD(dReviewI.getCreateDate()));
				sBuffer4.append("]<br>");
			}  
		}
		map.put("opinion1", sBuffer1);
		map.put("opinion2", sBuffer2);
		map.put("opinion3", sBuffer3);
		map.put("opinion4", sBuffer4);
		map.put("docinFjPage", docinService.findDocinFjInfoByDocinId(docin.getId()));
		// 取得审核意见信息
		return "/docin/docin_detail_qf";
	}
	/**
	 * 跳转至添加回执页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/docin/docin_receipt.htm", method = RequestMethod.GET)
	public String addDocinReceipt(long  id,ModelMap map) {
		map.put("docinId", id);
		return "/docin/docin_receipt";
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
	@RequestMapping(value = "/docin/docin_receipt.htm", method = RequestMethod.POST)
	public String addDocinReceipt(DocinForm form, ModelMap map) {
		// 信息临时表中添加数据
		DocinBox docinBox = new DocinBox();
		docinBox.setReceiverId(SecurityUtils.getLoginId());
		docinBox.setDocinId(form.getDocinId());
		docinBox.setStatus(1);
		docinBox.setStituation(form.getStituation());
		docinBoxService.updateDocinInfo(docinBox);
	
		// 跳转至信息拟稿页面
		return "/common/action_succ";
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
	@RequestMapping(value = "/docin/docin_isduban.htm", method = RequestMethod.GET)
	public String myDubanList(DocinForm outForm, ModelMap map) {
		DocinPage outPage = new DocinPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件

		// 根据用户ID查找该用户拟稿的信息
		map.put("page", docinService.getMyDubanDocinList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "docin_isduban");
		// 跳转至信息列表页面
		return "/docin/docin_isduban";
	}
	
	@RequestMapping(value = "/docin/fileNum_docin.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> fileNum(String fileNum)
			throws UnsupportedEncodingException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//取出最大值
		Docin docin = docinService.getDocinFileNum(fileNum);
		dataMap.put("docin", docin);
		return dataMap;
	}
	
	/**
	 * 取得流程变更数据,并跳转至变更页面
	 * 
	 * @param map
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/docin/lcbg.htm", method = RequestMethod.GET)
	public String lcbgDocin(Long id, ModelMap map) {
		Docin docin = docinService.getUserDraftDocinDetail(id);
		map.put("id", id);
		String userLoginId = docin.getCurrentOptId();
		// 取得当前操作人的相应信息
		User user = userService.getUserInfoByLoginId(userLoginId);
		// 取得当前职务下在流程里的主键ID
		// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
		ApprovalDetail approvalDetail = new ApprovalDetail();
		approvalDetail.setPositionId(user.getPositionId());
		approvalDetail.setDetailId(docin.getApprovalId());
		List<ApprovalDetail> approvalDetailList = approvalDetailService
				.getApprovalDetailForPositionId(approvalDetail);
		// 判断当前职务下有没有在流程里如果没有在流程里
		if (approvalDetailList == null || approvalDetailList.size() == 0) {
			// 通过取得的主键ID作为父ID为条件查询出所有的子ID信息
			ApprovalDetail approvalDetailForPid = new ApprovalDetail();
			approvalDetailForPid.setpId(new Long(0));
			approvalDetailForPid.setDetailId(docin.getApprovalId());
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
		
		//取得下一步操作人
		String[] strId = docin.getNextOptId().split(",");
		List<String> strList = new ArrayList<String>();
		for(String strObj:strId){
			User userObj = userService.getUserInfoByLoginId(strObj);
			if(userObj.getLevelName()!=null && userObj.getNcName()==null){
				strList.add(userObj.getUserName()+"("+userObj.getLevelName()+")");
				map.put("strList", strList);
			}
			if(userObj.getNcName()!=null && userObj.getLevelName()==null){
				strList.add(userObj.getUserName()+"("+userObj.getNcName()+")");
				map.put("strList", strList);
			}
			if(userObj.getNcName()!=null && userObj.getLevelName()!=null){
				strList.add(userObj.getUserName()+"("+userObj.getLevelName()+")"+"("+userObj.getNcName()+")");
				map.put("strList", strList);
			}
			if(userObj.getNcName()==null && userObj.getLevelName()==null){
				strList.add(userObj.getUserName());
				map.put("strList", strList);
			}
		}
		// 跳转至信息拟稿页面
		return "/docin/lcbg";
	}

	/**
	 * 取得流程变更数据,并跳转至变更页面
	 * 
	 * @param map
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping("/docin/lcbg.htm")
	public String lcbgDocin(DocinForm form, ModelMap map) {
		Docin docin = docinService.getUserDraftDocinDetail(form.getId());
		// 表中未修改之前的下一步操作人
		String[] strId = docin.getNextOptId().split(",");
		// 定义存放已修改的人的list
		List<String> strList = new ArrayList<String>();
		// 将页面中已修改的人转出list
		List<String> list = Arrays.asList(form.getNextOptId());
		// 循环判断哪个被更改
		for(String str : strId){
			boolean result = false;
			if (!list.contains(str)){
				// 将变更的人存入list
				strList.add(str);
				docinService.deleteOpinion(strList,form.getId());
				break;
			}
		}
		Docin docinObj = new Docin();
		docinObj.setId(form.getId());
		docinObj.setNextOptId(form.getNextOptId());
		docinService.updateDocinByNextOptId(docinObj);
		// 跳转至拟稿成功页面
		return "common/action_succ";
	}
	
	/**
	 * 改派
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/docin/gp.htm", method = RequestMethod.GET)
	public String gp(String id, String nextOptIds,ModelMap map) {
		User userObj = new User();
		userObj.setPositionId(Long.valueOf(12));
		map.put("userList", userService.getUserListByPositionId(userObj));
		
		// 如果存在登录ID, 查询用户信息
		if (isNotBlank(nextOptIds)) {
			map.put("nextOptId", nextOptIds);
		}
		map.put("id",id);
		// 跳转选择用户页面
		return "/docin/gp";
	}
	
	/**
	 * 改派提交页面
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping("/docin/gp.htm")
	public String gp(DocinForm form,ModelMap map) {
		Docin docin = new Docin();
		docin.setId(form.getId());
		docin.setNextOptId(form.getLoginId());
		docinService.updateDocinByNextOptId(docin);
		return "common/action_succ";
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
	@RequestMapping(value = "/docin/jl.htm", method = RequestMethod.GET)
	public String docinJlList(DocinForm outForm, ModelMap map) {
		DocinPage outPage = new DocinPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		outPage.setStartTime(outForm.getStartTime());
		outPage.setEndTime(outForm.getEndTime());
		outPage.setPageSize(10000);
		outPage.setLoginId(getLoginId()); // 设置当前操作人为当前用户ID
		// 根据用户ID查找该待该用户审批的信息
		map.put("page", docinService.getApprovedDocinList(outPage));
		User user = userService.getUserInfoByLoginId(getLoginId());
		map.put("userName",user.getUserName());
		// 跳转至信息列表页面
		return "/docin/jl";
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
	@RequestMapping("/docinShareDown/download_file.htm")
	public void downloadFile(ResFileForm form, HttpServletResponse response) {
		String srcFileNameOnes[] = form.getSrcFileNameOne().split(",");
		// 文件下载工具类
		FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK", "upload", 21);
		ftpUtil.connectServer("upload");
		ftpUtil.downloadFile(srcFileNameOnes[0], response);
		
	}
}
