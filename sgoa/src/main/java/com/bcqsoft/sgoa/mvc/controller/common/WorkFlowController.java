package com.bcqsoft.sgoa.mvc.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.common.util.WorkFlowColorUtil;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReview;
import com.bcqsoft.sgoa.dao.docinstep.dataobject.DocinStep;
import com.bcqsoft.sgoa.dao.docout.dataobject.Docout;
import com.bcqsoft.sgoa.dao.docoutstep.dataobject.DocoutStep;
import com.bcqsoft.sgoa.dao.dooutinstep.dataobject.DooutinStep;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYy;
import com.bcqsoft.sgoa.dao.meetingyyreview.dataobject.MeetingYyReview;
import com.bcqsoft.sgoa.dao.meetingyyreview.dataobject.MeetingYyReviewPage;
import com.bcqsoft.sgoa.dao.message.dataobject.Message;
import com.bcqsoft.sgoa.dao.messagestep.dataobject.MessageStep;
import com.bcqsoft.sgoa.dao.news.dataobject.News;
import com.bcqsoft.sgoa.dao.newsstep.dataobject.NewsStep;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.mvc.result.WorkFlow;
import com.bcqsoft.sgoa.service.brief.BriefService;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.docin.DocinService;
import com.bcqsoft.sgoa.service.docout.DocoutService;
import com.bcqsoft.sgoa.service.meetingyy.MeetingYyService;
import com.bcqsoft.sgoa.service.message.MessageService;
import com.bcqsoft.sgoa.service.news.NewsService;
import com.bcqsoft.sgoa.service.notice.NoticeService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 通用选择用户控制器
 */
@Controller
public class WorkFlowController {

	/**
	 * 共通业务模块业务逻辑接口
	 */
	@SuppressWarnings("unused")
	@Autowired
	private CommonService commonService;

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
	private DocoutService docoutService;
	
	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private DocinService docinService;
	
	/**
	 * 会议室预约模块业务逻辑类接口
	 */
	@Autowired
	private MeetingYyService meetingYyService;
	
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
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;

	/**
	 * 跳转至发文拟稿页面
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/work_flow.htm", method = RequestMethod.GET)
	public String workFlow(String type, long id, ModelMap map) {

		if (("message").equals(type)) {
			Message message = messageService.getUserDraftMessageDetail(id);
			Integer steps = message.getStep();

			map.put("busId", id);
			map.put("approvalId", message.getApprovalId());
			map.put("steps", steps == null ? "" : steps);
			map.put("type", type);
		} else if (("notice").equals(type)) {
			Message message = noticeService.getUserDraftNoticeDetail(id);
			Integer steps = message.getStep();

			map.put("busId", id);
			map.put("approvalId", message.getApprovalId());
			map.put("steps", steps == null ? "" : steps);
			map.put("type", type);

		} else if (("docout").equals(type)) {
			Docout docout = docoutService.getUserDraftDocoutDetail(id);
			Integer steps = docout.getStep();

			map.put("busId", id);
			map.put("approvalId", docout.getApprovalId());
			map.put("steps", steps == null ? "" : steps);
			map.put("type", type);

		} else if (("docin").equals(type)) {
			Docin docin = docinService.getUserDraftDocinDetail(id);
			Integer steps = docin.getStep();

			map.put("busId", id);
			map.put("approvalId", docin.getApprovalId());
			map.put("steps", steps == null ? "" : steps);
			map.put("type", type);

		} else if (("meetingyy").equals(type)) {
			MeetingYy meetingYy = meetingYyService.selectMeetingYyToDetail(id);
			Integer steps = meetingYy.getStep();

			map.put("busId", id);
			map.put("approvalId", meetingYy.getApprovalId());
			map.put("steps", steps == null ? "" : steps);
			map.put("type", type);

		} else if (("news").equals(type)) {
			News news = newsService.getUserDraftNewsDetail(id);
			Integer steps = news.getStep();

			map.put("busId", id);
			map.put("approvalId", news.getApprovalId());
			map.put("steps", steps == null ? "" : steps);
			map.put("type", type);
		} else if (("brief").equals(type)) {
			News brief = briefService.getUserDraftBriefDetail(id);
			Integer steps = brief.getStep();

			map.put("busId", id);
			map.put("approvalId", brief.getApprovalId());
			map.put("steps", steps == null ? "" : steps);
			map.put("type", type);

		} 
		// 跳转选择用户页面
		return "/common/work_flow";
	}

	/**
	 * 查找部门人员
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/get_work_flow.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getWorkFlow(String type, Long busId,
			Long approvalId, Integer steps) {
		List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
		if (("message").equals(type)) {

			workFlows = getMessageWorkFlow(busId, approvalId, steps);
		} else if (("notice").equals(type)) {

			workFlows = getNoticeWorkFlow(busId, approvalId, steps);
		} else if (("docout").equals(type)) {

			workFlows = getDocoutWorkFlow(busId, approvalId, steps);
		} else if (("docin").equals(type)) {

			workFlows = getDocinWorkFlow(busId, approvalId, steps);
		} else if (("meetingyy").equals(type)) {

			workFlows = getMeetingyyWorkFlow(busId, approvalId, steps);
		} else if (("news").equals(type)) {

			workFlows = getNewsWorkFlow(busId, approvalId, steps);
		} else if (("brief").equals(type)) {

			workFlows = getBriefWorkFlow(busId, approvalId, steps);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 查找部门列表
		dataMap.put("workFlowList", workFlows);
		return dataMap;
	}

	/**
	 * 通知流程图显示数据
	 * 
	 * @param map
	 * @return 报告审批流程
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-5-29
	 */
	private List<WorkFlow> getMessageWorkFlow(Long busId, Long approvalId,
			Integer steps) {
		// 根据部门列表查找部门下所有人员
		List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
		Message message = messageService.getUserDraftMessageDetail(busId);
		List<MessageStep> messageStepList = messageService.getMessageStepList(busId);
		String nextName = "";
		for (int i = 0; i < messageStepList.size(); i++) {
			MessageStep messageStep = messageStepList.get(i);
			WorkFlow workFlow = new WorkFlow();
			workFlow.setDraftsName(messageStep.getCurrentOptName()+DateUtil.getDateString(messageStep.getCreateDate()));
			// 判断是否有下一步
			if (i != messageStepList.size()-1){
				// 如果有下一步的场合，设置动作为已处理
				workFlow.setDoAction(2);
				workFlow.setColor(WorkFlowColorUtil.color_default);
			} else {
				workFlow.setDoAction(message.getStatus());
				// 状态为否决
				if (message.getStatus() == 3) {
					workFlow.setColor(WorkFlowColorUtil.color_cancle);
				} else if (message.getStatus() == 4) {
					// 状态为批准
					workFlow.setColor(WorkFlowColorUtil.color_passed);
				} else {
					// 判断是否有下一步审批人
					if (message.getNextOptId() != null && !"".equals(message.getNextOptId())) {
						nextName = message.getNextOptName();
						workFlow.setColor(WorkFlowColorUtil.color_default);
					} else {
						workFlow.setColor(WorkFlowColorUtil.color_default);
					}
				}
			}
			workFlows.add(workFlow);
		}
		// 如果有下一步审批人的时候，记录当前操作状态
		if(!"".equals(nextName)){
			WorkFlow workFlowNext = new WorkFlow();
			workFlowNext.setDraftsName(nextName);
			workFlowNext.setDoAction(message.getStatus());
			if (message.getStatus() == 2) {
				workFlowNext.setColor(WorkFlowColorUtil.color_waitting);
			} else {
				workFlowNext.setColor(WorkFlowColorUtil.color_untreated);
			}
			workFlows.add(workFlowNext);
		}
		return workFlows;
	}
	
	
	/**
	 * 每日要情流程图显示数据
	 * 
	 * @param map
	 * @return 报告审批流程
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-5-29
	 */
	private List<WorkFlow> getNewsWorkFlow(Long busId, Long approvalId,
			Integer steps) {
		// 根据部门列表查找部门下所有人员
		List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
		News news= newsService.getUserDraftNewsDetail(busId);
		List<NewsStep> newsStepList = newsService.getNewsStepList(busId);
		String nextName = "";
		for (int i = 0; i < newsStepList.size(); i++) {
			NewsStep newsStep = newsStepList.get(i);
			WorkFlow workFlow = new WorkFlow();
			workFlow.setDraftsName(newsStep.getCurrentOptName()+DateUtil.getDateString(newsStep.getCreateDate()));
			// 判断是否有下一步
			if (i != newsStepList.size()-1){
				// 如果有下一步的场合，设置动作为已处理
				workFlow.setDoAction(2);
				workFlow.setColor(WorkFlowColorUtil.color_default);
			} else {
				workFlow.setDoAction(news.getStatus());
				// 状态为否决
				if (news.getStatus() == 3) {
					workFlow.setColor(WorkFlowColorUtil.color_cancle);
				} else if (news.getStatus() == 4) {
					// 状态为批准
					workFlow.setColor(WorkFlowColorUtil.color_passed);
				} else {
					// 判断是否有下一步审批人
					if (news.getNextOptId() != null && !"".equals(news.getNextOptId())) {
						nextName = news.getNextOptName();
						workFlow.setColor(WorkFlowColorUtil.color_default);
					} else {
						workFlow.setColor(WorkFlowColorUtil.color_default);
					}
				}
			}
			workFlows.add(workFlow);
		}
		// 如果有下一步审批人的时候，记录当前操作状态
		if(!"".equals(nextName)){
			WorkFlow workFlowNext = new WorkFlow();
			workFlowNext.setDraftsName(nextName);
			workFlowNext.setDoAction(news.getStatus());
			if (news.getStatus() == 2) {
				workFlowNext.setColor(WorkFlowColorUtil.color_waitting);
			} else {
				workFlowNext.setColor(WorkFlowColorUtil.color_untreated);
			}
			workFlows.add(workFlowNext);
		}
		return workFlows;
	}
	
	/**
	 * 简报流程图显示数据
	 * 
	 * @param map
	 * @return 报告审批流程
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-5-29
	 */
	private List<WorkFlow> getBriefWorkFlow(Long busId, Long approvalId,
			Integer steps) {
		// 根据部门列表查找部门下所有人员
		List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
		News news = briefService.getUserDraftBriefDetail(busId);
		List<NewsStep> newsStepList = briefService.getBriefStepList(busId);
		String nextName = "";
		for (int i = 0; i < newsStepList.size(); i++) {
			NewsStep newsStep = newsStepList.get(i);
			WorkFlow workFlow = new WorkFlow();
			workFlow.setDraftsName(newsStep.getCurrentOptName()+DateUtil.getDateString(newsStep.getCreateDate()));
			// 判断是否有下一步
			if (i != newsStepList.size()-1){
				// 如果有下一步的场合，设置动作为已处理
				workFlow.setDoAction(2);
				workFlow.setColor(WorkFlowColorUtil.color_default);
			} else {
				workFlow.setDoAction(news.getStatus());
				// 状态为否决
				if (news.getStatus() == 3) {
					workFlow.setColor(WorkFlowColorUtil.color_cancle);
				} else if (news.getStatus() == 4) {
					// 状态为批准
					workFlow.setColor(WorkFlowColorUtil.color_passed);
				} else {
					// 判断是否有下一步审批人
					if (news.getNextOptId() != null && !"".equals(news.getNextOptId())) {
						nextName = news.getNextOptName();
						workFlow.setColor(WorkFlowColorUtil.color_default);
					} else {
						workFlow.setColor(WorkFlowColorUtil.color_default);
					}
				}
			}
			workFlows.add(workFlow);
		}
		// 如果有下一步审批人的时候，记录当前操作状态
		if(!"".equals(nextName)){
			WorkFlow workFlowNext = new WorkFlow();
			workFlowNext.setDraftsName(nextName);
			workFlowNext.setDoAction(news.getStatus());
			if (news.getStatus() == 2) {
				workFlowNext.setColor(WorkFlowColorUtil.color_waitting);
			} else {
				workFlowNext.setColor(WorkFlowColorUtil.color_untreated);
			}
			workFlows.add(workFlowNext);
		}
		return workFlows;
	}
	
	/**
	 * 通知流程图显示数据
	 * 
	 * @param map
	 * @return 报告审批流程
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-5-29
	 */
	private List<WorkFlow> getNoticeWorkFlow(Long busId, Long approvalId,
			Integer steps) {
		// 根据部门列表查找部门下所有人员
		List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
		Message message = noticeService.getUserDraftNoticeDetail(busId);
		List<MessageStep> messageStepList = noticeService.getNoticeStepList(busId);
		String nextName = "";
		for (int i = 0; i < messageStepList.size(); i++) {
			MessageStep messageStep = messageStepList.get(i);
			WorkFlow workFlow = new WorkFlow();
			workFlow.setDraftsName(messageStep.getCurrentOptName()+DateUtil.getDateString(messageStep.getCreateDate()));
			// 判断是否有下一步
			if (i != messageStepList.size()-1){
				// 如果有下一步的场合，设置动作为已处理
				workFlow.setDoAction(2);
				workFlow.setColor(WorkFlowColorUtil.color_default);
			} else {
				workFlow.setDoAction(message.getStatus());
				// 状态为否决
				if (message.getStatus() == 3) {
					workFlow.setColor(WorkFlowColorUtil.color_cancle);
				} else if (message.getStatus() == 4) {
					// 状态为批准
					workFlow.setColor(WorkFlowColorUtil.color_passed);
				} else {
					// 判断是否有下一步审批人
					if (message.getNextOptId() != null && !"".equals(message.getNextOptId())) {
						nextName = message.getNextOptName();
						workFlow.setColor(WorkFlowColorUtil.color_default);
					} else {
						workFlow.setColor(WorkFlowColorUtil.color_default);
					}
				}
			}
			workFlows.add(workFlow);
		}
		// 如果有下一步审批人的时候，记录当前操作状态
		if(!"".equals(nextName)){
			WorkFlow workFlowNext = new WorkFlow();
			workFlowNext.setDraftsName(nextName);
			workFlowNext.setDoAction(message.getStatus());
			if (message.getStatus() == 2) {
				workFlowNext.setColor(WorkFlowColorUtil.color_waitting);
			} else {
				workFlowNext.setColor(WorkFlowColorUtil.color_untreated);
			}
			workFlows.add(workFlowNext);
		}
		return workFlows;
	}
	
	/**
	 * 发文流程图显示数据
	 * 
	 * @param map
	 * @return 报告审批流程
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-5-29
	 */
	private List<WorkFlow> getDocoutWorkFlow(Long busId, Long approvalId,
			Integer steps) {
		// 根据部门列表查找部门下所有人员
		List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
		Docout docout = docoutService.getUserDraftDocoutDetail(busId);
		List<DocoutStep> docoutStepList = docoutService.getDocoutStepList(busId);
		String nextNameOne = "";
		for (int i = 0; i < docoutStepList.size(); i++) {
			DocoutStep docoutStep = docoutStepList.get(i);
			WorkFlow workFlow = new WorkFlow();
			workFlow.setDraftsName(docoutStep.getCurrentOptName()+DateUtil.getDateString(docoutStep.getCreateDate()));
			// 判断是否有下一步
			if (i != docoutStepList.size()-1){
				// 如果有下一步的场合，设置动作为已处理
				workFlow.setDoAction(2);
				workFlow.setColor(WorkFlowColorUtil.color_default);
			} else {
				workFlow.setDoAction(docout.getStatus());
				// 状态为否决
				if (docout.getStatus() == 3) {
					workFlow.setColor(WorkFlowColorUtil.color_cancle);
				} else if (docout.getStatus() == 4) {
					// 状态为批准
					workFlow.setColor(WorkFlowColorUtil.color_passed);
				} else if (docout.getStatus() == 5) {
					// 状态为批准
					workFlow.setColor(WorkFlowColorUtil.color_passed);
				} else {
					// 判断是否有下一步审批人
					if (docout.getNextOptId() != null && !"".equals(docout.getNextOptId())) {
						nextNameOne = docout.getNextOptName();
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
			workFlowNext.setDoAction(docout.getStatus());
			if (docout.getStatus() == 2) {
				workFlowNext.setColor(WorkFlowColorUtil.color_waitting);
			} else {
				workFlowNext.setColor(WorkFlowColorUtil.color_untreated);
			}
			workFlows.add(workFlowNext);
		}
		
		if (docout.getStatus() == 4 || docout.getStatus() == 5 || docout.getStatus() == 6) {
			String nextInName = "";
			List<DooutinStep> dooutinStepList = docoutService.getDooutinStepList(busId);
			if(dooutinStepList.size() == 1){
				WorkFlow workFlowBs = new WorkFlow();
				workFlowBs.setDraftsName(docout.getNextOptName());
				workFlowBs.setColor(WorkFlowColorUtil.color_untreated);
				workFlows.add(workFlowBs);
			}
			// 循环取出所有办事人员
			for (int i = 1; i < dooutinStepList.size(); i++) {
				DooutinStep dooutinStep = dooutinStepList.get(i);
				WorkFlow workFlow = new WorkFlow();
				workFlow.setDraftsName(dooutinStep.getCurrentOptName()+DateUtil.getDateString(dooutinStep.getCreateDate()));
				// 判断是否有下一步
				if (i != dooutinStepList.size()-1){
					// 如果有下一步的场合，设置动作为已处理
					workFlow.setDoAction(2);
					workFlow.setColor(WorkFlowColorUtil.color_default);
				} else {
					workFlow.setDoAction(docout.getStatus());
					// 状态为否决
					if (docout.getStatus() == 4) {
						workFlow.setColor(WorkFlowColorUtil.color_default);
						// 判断是否有下一步审批人
						if (docout.getNextOptId() != null && !"".equals(docout.getNextOptId())) {
							nextInName = docout.getNextOptName();
						}
					} else if (docout.getStatus() == 5) {
						// 状态为批准
						workFlow.setColor(WorkFlowColorUtil.color_passed);
					}
				}
				workFlows.add(workFlow);
			}
			// 如果有下一步审批人的时候，记录当前操作状态
			if(!"".equals(nextInName)){
				WorkFlow workFlowInNext = new WorkFlow();
				workFlowInNext.setDraftsName(nextInName);
				workFlowInNext.setDoAction(docout.getStatus());
				if (docout.getStatus() == 4) {
					workFlowInNext.setColor(WorkFlowColorUtil.color_waitting);
				} else {
					workFlowInNext.setColor(WorkFlowColorUtil.color_untreated);
				}
				workFlows.add(workFlowInNext);
			}
			
		}
		return workFlows;
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
	
	/**
	 * 通知流程图显示数据
	 * 
	 * @param map
	 * @return 报告审批流程
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-5-29
	 */
	private List<WorkFlow> getMeetingyyWorkFlow(Long busId, Long approvalId,
			Integer steps) {
		// 根据部门列表查找部门下所有人员
		List<WorkFlow> workFlows = new ArrayList<WorkFlow>();
		MeetingYy mettingYy = meetingYyService.selectMeetingYyToDetail(busId);
		MeetingYyReviewPage meetingYyReviewPage  = meetingYyService.getMeetingYyReviewListById(busId);
		List<MeetingYyReview> meetingYyReviewList = meetingYyReviewPage.getMeetingYyReviewList();
		String nextName = "";
		for (int i = 0; i < meetingYyReviewList.size(); i++) {
			MeetingYyReview meetingYyReview = meetingYyReviewList.get(i);
			WorkFlow workFlow = new WorkFlow();
			workFlow.setDraftsName(meetingYyReview.getCurrentOptName()+DateUtil.getDateString(meetingYyReview.getCreateDate()));
			// 判断是否有下一步
			if (i != meetingYyReviewList.size()-1){
				// 如果有下一步的场合，设置动作为已处理
				workFlow.setDoAction(2);
				workFlow.setColor(WorkFlowColorUtil.color_default);
			} else {
				workFlow.setDoAction(mettingYy.getStatus());
				// 状态为否决
				if (mettingYy.getStatus() == 3) {
					workFlow.setColor(WorkFlowColorUtil.color_cancle);
				} else if (mettingYy.getStatus() == 4) {
					// 状态为批准
					workFlow.setColor(WorkFlowColorUtil.color_passed);
				} else {
					// 判断是否有下一步审批人
					if (mettingYy.getNextOptId() != null && !"".equals(mettingYy.getNextOptId())) {
						nextName = mettingYy.getNextOptName();
						workFlow.setColor(WorkFlowColorUtil.color_default);
					} else {
						workFlow.setColor(WorkFlowColorUtil.color_default);
					}
				}
			}
			workFlows.add(workFlow);
		}
		// 如果有下一步审批人的时候，记录当前操作状态
		if(!"".equals(nextName)){
			WorkFlow workFlowNext = new WorkFlow();
			workFlowNext.setDraftsName(nextName);
			workFlowNext.setDoAction(mettingYy.getStatus());
			if (mettingYy.getStatus() == 2) {
				workFlowNext.setColor(WorkFlowColorUtil.color_waitting);
			} else {
				workFlowNext.setColor(WorkFlowColorUtil.color_untreated);
			}
			workFlows.add(workFlowNext);
		}
		return workFlows;
	}
}
