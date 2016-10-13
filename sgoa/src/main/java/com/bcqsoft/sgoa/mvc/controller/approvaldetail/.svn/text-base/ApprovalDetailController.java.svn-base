package com.bcqsoft.sgoa.mvc.controller.approvaldetail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;
import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;
import com.bcqsoft.sgoa.mvc.form.approvaldetail.ApprovalDetailForm;
import com.bcqsoft.sgoa.service.approval.ApprovalService;
import com.bcqsoft.sgoa.service.approvaldetail.ApprovalDetailService;

@Controller
public class ApprovalDetailController {

	@Autowired
	private ApprovalDetailService approvalDetailService;
	
	/**
	 * 流程审批表的业务逻辑层
	 */
	@Autowired
	private ApprovalService approvalService;

	/**
	 * 跳转至添加审批流程页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-1
	 */
	@RequestMapping("/approvalDetail/menu_detail.htm")
	public String menuApprovalDetail(ApprovalDetailForm form,ModelMap map) {
		ApprovalPage approvalPage = new ApprovalPage();
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		map.put("detailIdSel", form.getDetailId());
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "menu_detail");
		return "approvalDetail/menu_detail";
	}

	/**
	 * 取得有效的审批流程列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-1
	 */
	@RequestMapping(value = "/approvalDetail/approvalDetail_list.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> approvalDetailmenuList(ModelMap map,long detailId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ApprovalDetail> approvalDetail = approvalDetailService.getApprovalDetailListByAll(detailId);
		dataMap.put("approvalDetail", approvalDetail);
		return dataMap;

	}

	/**
	 * 删除审批流程
	 * 
	 * @param id
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-1
	 */
	@RequestMapping(value = "/approvalDetail/delete.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> removeApprovalDetail(String id,long detailId) {
		approvalDetailService.deleteApprovalDetailInfo(new Long(id));
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<ApprovalDetail> approvalDetail = approvalDetailService.getApprovalDetailListByAll(detailId);
		dataMap.put("approvalDetail", approvalDetail);
		return dataMap;
	}
	
	/**
	 * 删除审批流程
	 * 
	 * @param id
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2014-4-1
	 */
	@RequestMapping(value = "/approvalDetail/approval_detail.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findApprovalDetail(long id) {
		ApprovalDetail approvalDetail = approvalDetailService.getApprovalDetailForId(id);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("approvalDetailForStatus", approvalDetail);
		return dataMap;
	}
	
	
	/**
	 * 流程审批详细表新增处理
	 * 
	 * @param map
	 * @return 流程审批详细表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2014-4-8
	 */
	@RequestMapping("/approvalDetail/add_approvalDetail.htm")
	public String addApprovalDetail(ApprovalDetailForm form, ModelMap map) {
		approvalDetailService.createApproval(setBeans(form));
		
		ApprovalPage approvalPage = new ApprovalPage();
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		map.put("detailIdSel", form.getDetailId());
		return "approvalDetail/menu_detail";
	}
	
	/**
	 * 流程审批详细表新增根处理
	 * 
	 * @param map
	 * @return 流程审批详细表的添加根页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2014-4-8
	 */
	@RequestMapping("/approvalDetail/add_approvalDetailRoot.htm")
	public String addApprovalDetailRoot(ApprovalDetailForm form, ModelMap map) {
		approvalDetailService.createApproval(setBeans(form));
		
		ApprovalPage approvalPage = new ApprovalPage();
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		map.put("detailIdSel", form.getDetailId());
		return "approvalDetail/menu_detail";
	}
	
	/**
	 * 流程审批更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2014-4-8
	 */
	@RequestMapping("/approvalDetail/edit_approvalDetail.htm")
	public String approvalEdit(ApprovalDetailForm form,ModelMap map) {
		// 修改审批流程
		ApprovalDetail approvalDetail = new ApprovalDetail();
		approvalDetail.setId(form.getpId());
		approvalDetail.setPositionId(form.getPositionId());
		approvalDetail.setStatus(form.getStatus());
		approvalDetailService.editApprovalDetailInfo(approvalDetail);
		
		ApprovalPage approvalPage = new ApprovalPage();
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		map.put("detailIdSel", form.getDetailId());
		return "approvalDetail/menu_detail";
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return ApprovalDetail
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private ApprovalDetail setBeans(ApprovalDetailForm form) {
		ApprovalDetail approvalDetail = new ApprovalDetail();
		BeanUtils.copyProperties(form, approvalDetail); // 复制表单至DO
		approvalDetail.setEnabled(CommonChar.ABLED);
		if(null==approvalDetail.getStatus()){
			approvalDetail.setStatus("N");
		}
		return approvalDetail;
	}

}
