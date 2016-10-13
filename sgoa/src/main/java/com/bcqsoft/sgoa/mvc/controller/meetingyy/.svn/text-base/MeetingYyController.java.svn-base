package com.bcqsoft.sgoa.mvc.controller.meetingyy;

import static com.bcqsoft.sgoa.core.security.SecurityUtils.getLoginId;

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
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYy;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYyPage;
import com.bcqsoft.sgoa.dao.meetingyyreview.dataobject.MeetingYyReviewPage;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.mvc.form.meetingyy.MeetingYyForm;
import com.bcqsoft.sgoa.service.approvaldetail.ApprovalDetailService;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.meetingyy.MeetingYyService;
import com.bcqsoft.sgoa.service.user.UserService;

@Controller
public class MeetingYyController {

	/**
	 * 会议室预约模块业务逻辑类接口
	 */
	@Autowired
	private MeetingYyService meetingYyService;

	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 流程详细模块业务逻辑类接口
	 */
	@Autowired
	private ApprovalDetailService approvalDetailService;
	
	/**
	 * 共通逻辑类接口
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * 取得有效的会议室预约列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("/meetingYy/meetingYy_list.htm")
	public String meetingYyList(MeetingYyForm form, ModelMap map) {
		// 会议预约表分页对象初始化
		MeetingYyPage meetingYyPage = new MeetingYyPage();
		// 设置查询条件
		setSearchKey(form, meetingYyPage);
		meetingYyPage.setRoomId(form.getRoomId());//会议室查询
		meetingYyPage.setLoginId(getLoginId()); // 设置当前操作人为当前用户ID
		// 取得汽车保养维修报告表列表,分页显示
		MeetingYyPage page = meetingYyService.getMeetingYyInfoList(meetingYyPage);
		
		map.put("meetingRoomPage", meetingYyService.findAllRoomInfo()); //会议室列表
		map.put("approvalPage", meetingYyService.findAllApprovalInfo());//审批名称表
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "meetingYy_list");
		// 跳转至会议室列表页面
		return "meetingyy/meetingYy_list";
	}
	
	/**
	 * 取得有效的会议室预约待审核列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("/meetingYy/meetingYy_review_list.htm")
	public String meetingYyReviewList(MeetingYyForm form, ModelMap map) {
		// 会议预约表分页对象初始化
		MeetingYyPage meetingYyPage = new MeetingYyPage();
		// 设置查询条件
		meetingYyPage.setCurrentPage(form.getCp()); // 当前页数
		meetingYyPage.setRoomId(form.getRoomId());//会议室查询
		meetingYyPage.setLoginId(getLoginId()); // 设置当前操作人为当前用户ID
		// 取得汽车保养维修报告表列表,分页显示
		MeetingYyPage page = meetingYyService.getMeetingYyReviewInfoList(meetingYyPage);
		
		map.put("meetingRoomPage", meetingYyService.findAllRoomInfo()); //会议室列表
		map.put("approvalPage", meetingYyService.findAllApprovalInfo());//审批名称表
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "meetingYy_review_list");
		// 跳转至会议室列表页面
		return "meetingyy/meetingYy_review_list";
	}
	
	/**
	 * 取得有效的会议室预约经我审核列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("/meetingYy/my_review_list.htm")
	public String myReviewList(MeetingYyForm form, ModelMap map) {
		// 会议预约表分页对象初始化
		MeetingYyPage meetingYyPage = new MeetingYyPage();
		// 设置查询条件
		meetingYyPage.setCurrentPage(form.getCp()); // 当前页数
		meetingYyPage.setRoomId(form.getRoomId());//会议室查询
		meetingYyPage.setLoginId(getLoginId()); // 设置当前操作人为当前用户ID
		// 取得汽车保养维修报告表列表,分页显示
		MeetingYyPage page = meetingYyService.getMyReviewInfoList(meetingYyPage);
		
		map.put("meetingRoomPage", meetingYyService.findAllRoomInfo()); //会议室列表
		map.put("approvalPage", meetingYyService.findAllApprovalInfo());//审批名称表
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_review_list");
		// 跳转至会议室列表页面
		return "meetingyy/my_review_list";
	}

	/**
	 * 会议预约表列表页面设置查询条件
	 * 
	 * @param form
	 * @param meetingYyPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	private void setSearchKey(MeetingYyForm form, MeetingYyPage meetingYyPage) {
		// 设置查询条件
		meetingYyPage.setCurrentPage(form.getCp()); // 当前页数
		meetingYyPage.setLoginId(SecurityUtils.getLoginId()); // 设置登录人Id
		meetingYyPage.setRoomId(form.getRoomId());//会议室查询
		
	}

	/**
	 * 跳转至添加会议室预约页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/meetingYy/add_meetingYy.htm", method = RequestMethod.GET)
	public String addMeetingYy(ModelMap map) {
		// 取得会议室列表，下拉菜单选项框
		String loginId = SecurityUtils.getLoginId();
		map.put("loginId", loginId); // 设置预约人Id
		// 根据登录的Id取得用户名称
		User user = userService.getUserInfoByLoginId(loginId);
		map.put("userName", user == null ? "" : user.getUserName()); // 设置预约人名称

		map.put("meetingRoomPage", meetingYyService.findAllRoomInfo());//会议室列表
		map.put("approvalPage", meetingYyService.findAllApprovalInfo());//审批名称表
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "add_meetingYy");
		return "meetingyy/add_meetingYy";
	}

	/**
	 * 添加会议室预约页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/meetingYy/add_meetingYy.htm", method = RequestMethod.POST)
	public String addMeetingYy(MeetingYyForm form) {
		meetingYyService.createMeetingYyInfo(toBean(form));
		return "meetingyy/add_success";
	}
	
	/**
	 * 点击查看会议预约表详细
	 * 
	 * @param id
	 * @param map
	 * @return 会议预约表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/meetingYy/detail_meetingYy.htm", method = RequestMethod.GET)
	public String meetingYyDetail(Long id, ModelMap map) throws Exception {
		MeetingYy meetingYy = meetingYyService.selectMeetingYyToDetail(id);
		// 非申请登录时 当前状态是未读改成已读待审批
		if (meetingYy.getStatus() != null) {
			if (1 == meetingYy.getStatus() && !meetingYy.getLoginId().equals(SecurityUtils.getLoginId())) {
				meetingYyService.updateMeetingYyToStatus(id, 2);
			}
		}
		MeetingYyReviewPage page = meetingYyService.getMeetingYyReviewListById(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("meetingYy", meetingYy);
		map.put("page", page);
		map.put("meetingRoomPage", meetingYyService.findAllRoomInfo());//会议室列表
		map.put("approvalPage", meetingYyService.findAllApprovalInfo());//审批名称表
		return "/meetingyy/detail_meetingYy";
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
	@RequestMapping(value = "/meetingYy/edit_meetingYy_review.htm", method = RequestMethod.GET)
	public String meetingYyReviewEdit(Long id, ModelMap map) throws Exception {
		// 用户查看自己的详细信息
		MeetingYy meetingYy = meetingYyService.selectMeetingYyToDetail(id);
		//查出流程ID
		String approvalId=meetingYy.getApprovalId();
		String loginId = SecurityUtils.getLoginId();
		//Dept dept = deptService.findDeptInfoByLoginId(loginId);
		//map.put("deptId", dept == null ? "" : dept.getId()); // 部门id
		User user = userService.getUserInfoByLoginId(loginId);
		//实例流程详细表对象
		ApprovalDetail approvalDetail = new ApprovalDetail();
		//把流程ID赋值给流程详细表的流程ID
		approvalDetail.setDetailId(approvalId);
		//吧步骤赋值给流程详细表的步骤
		approvalDetail.setPositionId(user.getPositionId());
		//获取流程详细表的对象
		ApprovalDetail approvalDetailFor=approvalDetailService.getApprovalDetailForList(approvalDetail);
		//查出流程详细表审批权限
		String approvalDetailForStatus=approvalDetailFor.getStatus();
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
		map.put("meetingYy", meetingYy);
		MeetingYyReviewPage page = meetingYyService.getMeetingYyReviewListById(id);
		
		map.put("userName", user == null ? "" : user.getUserName()); // 设置拟稿人名称;
		map.put("page", page);
		map.put("meetingRoomPage", meetingYyService.findAllRoomInfo());//会议室列表
		map.put("approvalPage", meetingYyService.findAllApprovalInfo());//审批名称表
		// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
		Remind remind = new Remind();
		remind.setBusId(meetingYy.getId());
		remind.setModeName(CommonChar.MODE_METTING);
		remind.setLoginId(SecurityUtils.getLoginId());
		remind.setStatus(CommonChar.REMIND_STATUS_BTX);
		commonService.updateRemindInfoByLoginId(remind);
		
		return "/meetingyy/edit_meetingYy_review";
	}
	
	/**
	 * 会议预约表审批修改
	 * 
	 * @param from
	 * @param map
	 * @return 会议预约表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/meetingYy/add_meetingYy_review.htm")
	public String meetingYyReviewEdit(MeetingYyForm form, ModelMap map) {
		MeetingYy meetingYy = setBeans(form);
		meetingYyService.createMeetingYyReview(meetingYy);
		// 返回到操作成功页面
		return "/meetingyy/edit_success";

	}
	
	/**
	 * 时间比较
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-06-03
	 */
	@RequestMapping(value = "/meetingYy/time_compare.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deptmenuList(ModelMap map,String roomId,String startTime,String endTime) {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		// 把字符串型日期转化为long型比较大小
		boolean result = true;
		long longstr1 = Long.valueOf(startTime.replaceAll("[-\\s:]", ""));
		long longstr2 = Long.valueOf(endTime.replaceAll("[-\\s:]", ""));
		int i;
		// 如果开始时间大于结束时间返回添加失败
		if (longstr1 > longstr2){
			result=false;
			dataMap.put("isNormal", result);
			return dataMap;
		}
			
		// 寻找与新增会议同一个会议室的所有会议
		MeetingYyPage page = new MeetingYyPage();
		page.setRoomId(roomId);
		page.setLoginId(SecurityUtils.getLoginId());
		List<MeetingYy> meetingYyList = meetingYyService.getMeetingYyTimeCompare(page);
		// 同同一会议室的所有会议时间比较 如果无时间冲突继续遍历 如果有冲突则跳出循环
		for (i = 0; i < meetingYyList.size(); i++) {
			if (longstr1 >= Long.valueOf(meetingYyList.get(i).getEndTime().replaceAll("[-\\s:]", ""))
					|| longstr2 <= Long.valueOf(meetingYyList.get(i).getStartTime().replaceAll("[-\\s:]", ""))) {
				continue;
			}
			else{
				result=false;
				
				break;
			}
		}
	
		dataMap.put("isNormal", result);
		return dataMap;
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return MeetingYy
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	private MeetingYy setBeans(MeetingYyForm form) {
		MeetingYy meetingYy = new MeetingYy();
		BeanUtils.copyProperties(form, meetingYy); // 设置表单属性
		return meetingYy;
	}
	
	/**
	 * DO设置
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	private MeetingYy toBean(MeetingYyForm form) {
		MeetingYy meetingYy = new MeetingYy();
		BeanUtils.copyProperties(form, meetingYy);
		return meetingYy;
	}

}