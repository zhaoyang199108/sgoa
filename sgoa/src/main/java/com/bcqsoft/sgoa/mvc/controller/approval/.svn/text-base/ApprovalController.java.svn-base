package com.bcqsoft.sgoa.mvc.controller.approval;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.dao.approval.dataobject.Approval;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;
import com.bcqsoft.sgoa.mvc.form.approval.ApprovalForm;
import com.bcqsoft.sgoa.service.approval.ApprovalService;
import com.bcqsoft.sgoa.service.common.CommonService;

/**
 * 物资设备申领表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class ApprovalController {
	/**
	 * 物资设备申领表的业务逻辑层
	 */
	@Autowired
	private ApprovalService approvalService;
	
	/**
	 * 共通逻辑类接口
	 */
	@Autowired
	private CommonService commonService;
	
	/**
	 * 审批流程查询页面
	 * 
	 * @return 审批流程查询页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/approval/approval_list")
	public String selectApprovalListByPage(ApprovalForm form, ModelMap map) {
		ApprovalPage approvalPage = new ApprovalPage();
		// 设置查询条件
		setSearchKey(form, approvalPage);
		ApprovalPage page = approvalService.getApprovalList(approvalPage);
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "approval_list");
		return "approval/approval_list";

	}

	/**
	 * 跳转至新增流程审批页面
	 * 
	 * @return 新增流程审批页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/approval/add_approval.htm", method = RequestMethod.GET)
	public String addApproval(ModelMap map) {
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户
		return "approval/add_approval";
	}

	/**
	 * 流程审批申领表新增处理
	 * 
	 * @param map
	 * @return 流程审批申领表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/approval/add_approval.htm")
	public String addApproval(ApprovalForm form, ModelMap map) {
		approvalService.createApproval(setBeans(form));
		return "common/action_succ";
	}

	/**
	 * 审批流程表页面设置查询条件
	 * 
	 * @param form
	 * @param ApprovalPage
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	private ApprovalPage setSearchKey(ApprovalForm form,
			ApprovalPage approvalPage) {
		// 设置查询条件
		approvalPage.setCurrentPage(form.getCp()); // 当前页数
		approvalPage.setApprovalName(form.getApprovalName());// 审批流程名称
		approvalPage.setApprovalType(form.getApprovalType());// 审批流程分类
		return approvalPage;

	}

	/**
	 * 流程审批表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新流程审批申领表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/approval/delete_approval.htm")
	public String delectApproval(long id) {
		approvalService.deleteApproval(id);
		return "common/action_succ";

	}

	/**
	 * 删除流程审批表(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/approval/delete_approvalArray.htm")
	public String removeApproval(String idArray) {
		approvalService.deleteApprovals(toLongArray(idArray));
		return "common/action_succ";
	}

	/**
	 * 跳转至流程审批详细页面
	 * 
	 * @return 流程审批页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/approval/approval_detail.htm", method = RequestMethod.GET)
	public String approvalDetail(long id, ModelMap map) {
		// 取得流程审批详细页面
		Approval approval = approvalService.getApprovalInfo(id);
		map.put("approval", approval);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户
		return "approval/approval_detail";
	}

	/**
	 * 跳转至流程审批更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/approval/approval_edit.htm")
	public String approvalEdit(ApprovalForm form, ModelMap map) {
		// 修改审批流程
		approvalService.editApprovalInfo(setBeans(form));
		return "common/action_succ";
	}

	/**
	 * 流程审批更新
	 * 
	 * @return 流程审批页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/approval/approval_edit.htm", method = RequestMethod.GET)
	public String approvalEdit(long id, ModelMap map) {
		// 取得流程审批详细页面
		Approval approval = approvalService.getApprovalInfo(id);
		map.put("approval", approval);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户
		return "approval/approval_edit";
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Approval
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private Approval setBeans(ApprovalForm form) {
		Approval approval = new Approval();
		BeanUtils.copyProperties(form, approval); // 复制表单至DO
		approval.setEnabled(CommonChar.ABLED);
		return approval;
	}

}
