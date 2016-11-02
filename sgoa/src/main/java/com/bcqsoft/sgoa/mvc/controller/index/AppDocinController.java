package com.bcqsoft.sgoa.mvc.controller.index;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.common.util.WorkFlowColorUtil;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docin.dataobject.DocinPage;
import com.bcqsoft.sgoa.dao.docinbox.dataobject.DocinBox;
import com.bcqsoft.sgoa.dao.docinfj.dataobject.DocinFj;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReview;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReviewPage;
import com.bcqsoft.sgoa.dao.docinstep.dataobject.DocinStep;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.mvc.result.DocinRes;
import com.bcqsoft.sgoa.mvc.result.WorkFlow;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.docin.DocinService;
import com.bcqsoft.sgoa.service.docinbox.DocinBoxService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * App收文控制器
 * Author zy
 */
@Controller
public class AppDocinController {
	
	@Autowired private DocinService docinService;
	
	@Autowired private UserService  userService;
	@Autowired private DocinBoxService docinBoxService;
	
	@Autowired private CommonService commonService;
	/**
	 * 通知查询列表
	 * @param map
	 * @return 信息页面模板
	 * @Author zy
	 * @Date 2016-10-17
	 */
	@ResponseBody
	@RequestMapping("/home/docin_search.htm")
	public Map<String,Object> bsReviewMyList(Map<String,String> regParams,HttpServletRequest request,HttpServletResponse response) {
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		String title = request.getParameter("title") ;
		try {
			if(title!=null){
				title = new String(title.getBytes("iso-8859-1"),"utf-8");
				}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(currentPage == null||"".equals(currentPage)){
			currentPage = "1";
		}
		if(pageSize == null||"".equals(pageSize)){
			pageSize = "20";
		}
		String retCode = "";
		String message = "";
		DocinPage docin = new DocinPage();
		docin.setCurrentPage(Integer.parseInt(currentPage));
		docin.setPageSize(Integer.parseInt(pageSize));
		docin.setTitle(title);
		docin.setStatus(CommonChar.STATUS_FF);
		DocinPage docinPage = docinService.getDocinSearchList(docin);
		List<Docin> docinList = docinPage.getDocinList();
		retCode = docinList==null?"1":"0";
		message = docinList==null?"取得失败":"取得成功";
		// 输出json格式数据
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ret_code", retCode);
		map.put("message", message);
		// 输出json格式数据
		map.put("data",docinList);
		return map;
	}

	/**
	 * 点击查看通知表
	 * 
	 * @param id
	 * @param map
	 * @return 通知表详细页面
	 * @throws Exception
	 * 
	 * @Author zy
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/home/docin/look_detail.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> docinBoxDetail(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// 获取当前登录ID
		String loginId = request.getParameter("loginId");
		Long id =Long.parseLong(request.getParameter("id"));
		Map<String,Object> resMap = new HashMap<String, Object>();
		String retCode = "";
		String message = "";
		if(id==null||id.equals("")){
			resMap.put("message", "请求id不能为空");
			resMap.put("retCode", "1");
			resMap.put("data", null);
		}

		List<DocinBox> docinBoxListForAll = docinBoxService
				.getAllDocinBoxListAll(id);
		//resMap.put("look", docinBoxListForAll);

		Docin docin = docinService.getUserDraftDocinDetail(id);
		if(docin == null){
			resMap.put("message", "没有数据");
			resMap.put("retCode", "0");
			resMap.put("data", null);
			return resMap;
		}
		docin.setReceiverName(commonService.getUsersNameByLoginIds(docin.getReceiverId()));

		
		DocinReviewPage  page= docinService.getDocinReviewListByIdQf(id);
		List<DocinReview> drList = page.getDocinReviewList();
		List<DocinReview> list1 = new ArrayList<DocinReview>();
		List<DocinReview> list2 = new ArrayList<DocinReview>();
		List<DocinReview> list3 = new ArrayList<DocinReview>();
		List<DocinReview> list4 = new ArrayList<DocinReview>();
		DocinRes dr1 = new DocinRes();
		DocinRes dr2 = new DocinRes();
		DocinRes dr3 = new DocinRes();
		DocinRes dr4 = new DocinRes();
		List<DocinRes> listRes = new ArrayList<DocinRes>();
		for(DocinReview i : drList){
			if("1".equals(i.getSeat())){
				dr1.seat = i.getSeat();
				list1.add(i);
			}
		}
		dr1.opinions = list1;
		listRes.add(dr1);
		for(DocinReview i : drList){
			if("2".equals(i.getSeat())){
				dr2.seat = i.getSeat();
				list2.add(i);
			}
		}
		dr2.opinions = list2;
		listRes.add(dr2);
		for(DocinReview i : drList){
			if("3".equals(i.getSeat())){
				dr3.seat = i.getSeat();
				list3.add(i);
			}
		}
		dr3.opinions = list3;
		listRes.add(dr3);
		for(DocinReview i : drList){
			if("4".equals(i.getSeat())){
				dr4.seat = i.getSeat();
				list4.add(i);
			}
		}
		dr4.opinions = list4;
		listRes.add(dr4);
		Collections.sort(listRes,new SortBySeat());
		Docin docin1 = docinService.getUserDraftDocinDetail(id);
		Integer steps = docin1.getStep();
		List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
		workFlows = getDocinWorkFlow(id, Long.parseLong(docin1.getApprovalId()), steps);
		resMap.put("workFlows", workFlows);
		resMap.put("opinons", listRes);
		resMap.put("data", docin);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		retCode = docin==null?"0":"0";
		message = docin==null?"取得成功":"取得成功";
		resMap.put("message", message);
		resMap.put("retCode", retCode);
		List<DocinFj>  l = docinService.findDocinFjInfoByDocinId(docin.getId());
		resMap.put("docinFjPage", docinService.findDocinFjInfoByDocinId(docin.getId()));
		return resMap;

	}
	  class SortBySeat implements Comparator {  
	        public int compare(Object object1, Object object2) {// 实现接口中的方法  
	        	DocinRes p1 = ((DocinRes) object1); // 强制转换  
	        	DocinRes p2 = ((DocinRes) object2);  
	            return p1.seat.compareTo(p2.seat);  
	        }  
	    } 
	  /**
		 * 收文流程图显示数据
		 * 
		 * @param map
		 * @return 报告审批流程
		 * 
		 * @Author Bcqsoft.com cql
		 * @Date 2012-5-29
		 */
		private List<WorkFlow> getDocinWorkFlow(Long busId, Long approvalId,
				Integer steps) {
			// 根据部门列表查找部门下所有人员
			List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
			Docin docin = docinService.getUserDraftDocinDetail(busId);
			List<DocinStep> docinStepList = docinService.getDocinStepList(busId);
			String nextNameOne = "";
			for (int i = 0; i < docinStepList.size(); i++) {
				DocinStep docinStep = docinStepList.get(i);
				WorkFlow workFlow = new WorkFlow();
				DocinReview docinReview = new DocinReview();
				docinReview.setStepId(Long.valueOf(docinStep.getStep()));
				docinReview.setDocinId(docin.getId());
				List<DocinReview> reviewList = docinService.findDocinReviewListByStep(docinReview);
				StringBuffer sb = new StringBuffer();
				if (reviewList != null && reviewList.size() > 0) {
					for (DocinReview dr : reviewList) {
						sb.append(dr.getCurrentOptName()+DateUtil.getDateString(dr.getCreateDate())+","); 
					}
					sb.delete(sb.lastIndexOf(","),sb.length());
					workFlow.setDraftsName(sb.toString());
				} else {
					workFlow.setDraftsName(docinStep.getCurrentOptName()+DateUtil.getDateString(docinStep.getCreateDate()));
				}
				// 判断是否有下一步
				if (i != docinStepList.size()-1){
					// 如果有下一步的场合，设置动作为已处理
					workFlow.setDoAction(2);
					workFlow.setColor(WorkFlowColorUtil.color_default);
				} else {
					workFlow.setDoAction(docin.getStatus());
					// 状态为否决
					if (docin.getStatus() == 3) {
						workFlow.setColor(WorkFlowColorUtil.color_cancle);
					} else if (docin.getStatus() == 4) {
						// 状态为批准
						workFlow.setColor(WorkFlowColorUtil.color_passed);
					} else if (docin.getStatus() == 5) {
						// 状态为批准
						workFlow.setColor(WorkFlowColorUtil.color_passed);
					} else if (docin.getStatus() == 6) {
						// 状态为批准
						workFlow.setColor(WorkFlowColorUtil.color_passed);
					}  else {
						// 判断是否有下一步审批人
						if (docin.getNextOptId() != null && !"".equals(docin.getNextOptId())) {
							String[] optIdStr = docin.getNextOptId().split(",");
							StringBuffer sBuffer = new StringBuffer();
							for (int j = 0; j < optIdStr.length; j++) {
								User user = userService.getUserInfoByLoginId(optIdStr[j]);
								DocinReview docinReviewNext = new DocinReview();
								docinReviewNext.setStepId(Long.valueOf(docinStep.getStep()+1));
								docinReviewNext.setDocinId(docin.getId());
								docinReviewNext.setCurrentOptId(optIdStr[j]);
								List<DocinReview> reviewNextList = docinService.findDocinReviewListByStep(docinReviewNext);
								if (reviewNextList != null && reviewNextList.size() > 0) {
									sBuffer.append(user.getUserName()+DateUtil.getDateString(reviewNextList.get(0).getCreateDate())); 
								} else {
									sBuffer.append(user.getUserName()); 
								}
								if (j != optIdStr.length -1) {
									sBuffer.append(","); 
								}
							}
							nextNameOne = sBuffer.toString();
							workFlow.setColor(WorkFlowColorUtil.color_default);
						} else {
							workFlow.setColor(WorkFlowColorUtil.color_default);
						}
					}
				}
				workFlows.add(workFlow);
			}
			// 如果有下一步审批人的时候，记录当前操作状态
			if(!"".equals(nextNameOne)){
				WorkFlow workFlowNext = new WorkFlow();
				workFlowNext.setDraftsName(nextNameOne);
				workFlowNext.setDoAction(docin.getStatus());
				if (docin.getStatus() == 2) {
					workFlowNext.setColor(WorkFlowColorUtil.color_waitting);
				} else {
					workFlowNext.setColor(WorkFlowColorUtil.color_untreated);
				}
				workFlows.add(workFlowNext);
			}
			
			return workFlows;
		}
}
