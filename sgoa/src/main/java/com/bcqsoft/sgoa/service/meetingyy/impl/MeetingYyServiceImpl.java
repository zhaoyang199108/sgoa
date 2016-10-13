package com.bcqsoft.sgoa.service.meetingyy.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.approval.ApprovalDAO;
import com.bcqsoft.sgoa.dao.approval.dataobject.Approval;
import com.bcqsoft.sgoa.dao.meetingroom.MeetingRoomDAO;
import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoom;
import com.bcqsoft.sgoa.dao.meetingyy.MeetingYyDAO;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYy;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYyPage;
import com.bcqsoft.sgoa.dao.meetingyyreview.MeetingYyReviewDAO;
import com.bcqsoft.sgoa.dao.meetingyyreview.dataobject.MeetingYyReview;
import com.bcqsoft.sgoa.dao.meetingyyreview.dataobject.MeetingYyReviewPage;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.service.meetingyy.MeetingYyService;

@Service
public class MeetingYyServiceImpl extends BaseService implements MeetingYyService {

	/**
	 * 会议预约表数据库访问DAO接口
	 */
	@Autowired
	private MeetingYyDAO meetingYyDAO;
	
	/**
	 * 会议审核表数据库访问DAO接口
	 */
	@Autowired
	private MeetingYyReviewDAO meetingYyReviewDAO;
	
	/**
	 * 会议室表数据库访问DAO接口
	 */
	@Autowired
	private MeetingRoomDAO meetingRoomDAO;
	
	/**
	 * 审批名称表数据库访问DAO接口
	 */
	@Autowired
	private ApprovalDAO approvalDAO;
	
	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 查找全部会议室名称信息列表
	 * 
	 * @return 会议室名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	@Override
	public List<MeetingRoom> findAllRoomInfo() {
		return meetingRoomDAO.findAllMeetingRoomInfo();
	}

	/**
	 * 查找全部会议室名称信息列表
	 * 
	 * @return 会议室名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	@Override
	public List<Approval> findAllApprovalInfo() {
		return approvalDAO.findAllApprovalInfo();
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
	@Override
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createMeetingYyInfo(MeetingYy meetingYy) {
		meetingYy.setEnabled(CommonChar.FILE_NORMAL);
		meetingYy.setStatus(CommonChar.STATUS_WD);
		meetingYy.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = meetingYyDAO.insertIntoMeetingYy(meetingYy);
		// 添加消息提醒的信息
		if (meetingYy.getNextOptId() != null && !"".equals(meetingYy.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(pk);
			remind.setLoginId(meetingYy.getNextOptId());
			remind.setModeName(CommonChar.MODE_METTING);
			MeetingRoom meetingRoom = meetingRoomDAO.findMeetingRoomInfoById(new Long(meetingYy.getRoomId()));
			remind.setTitle(meetingYy.getUserName()+"于"+meetingYy.getStartTime()+"~"+meetingYy.getEndTime()+"时间段预约"+meetingRoom.getRoomName());
			remind.setUrl("meetingYy/edit_meetingYy_review.htm?id="+pk);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		return isInsertSucc(pk);
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return MeetingYyReview
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	private MeetingYyReview toInsterCarApproveReview(MeetingYy meetingYy) {
		MeetingYyReview meetingYyReview = new MeetingYyReview();
		meetingYyReview.setYyId(meetingYy.getId());// 获取主表ID
		meetingYyReview.setCurrentOptId(SecurityUtils.getLoginId());// 当前操作人
		meetingYyReview.setOpinion(meetingYy.getOpinion()); //意见
		meetingYyReview.setDoAction(meetingYy.getDoAction());// 设置状态
		return meetingYyReview;
	}

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
	@Override
	public MeetingYyPage getMeetingYyInfoList(MeetingYyPage page) {
		int count = meetingYyDAO.getMeetingYyInfoCount(page);
		if(count == 0){
			return page;
		}
		// 取得会议室预约信息集合(分页查询)
		List<MeetingYy> meetingYyList = meetingYyDAO.getMeetingYyInfoList(page);
		page.setTotalRow(count); //预约总数量
		page.setMeetingYyList(meetingYyList);//预约信息集合
		return page;
	}
	
	/**
	 * 时间比较
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@Override
	public List<MeetingYy> getMeetingYyTimeCompare(MeetingYyPage page) {
		List<MeetingYy> meetingYyList = meetingYyDAO.getMeetingYyInfoList(page);
		return meetingYyList;
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
	@Override
	public MeetingYyPage getMeetingYyReviewInfoList(MeetingYyPage page) {
		int count = meetingYyDAO.getMeetingYyReviewInfoCount(page);
		if(count == 0){
			return page;
		}
		// 取得会议室预约待审核信息集合(分页查询)
		List<MeetingYy> meetingYyList = meetingYyDAO.getMeetingYyReviewInfoList(page);
		page.setTotalRow(count); //待审核总数量
		page.setMeetingYyList(meetingYyList);//待审核信息集合
		return page;
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
	@Override
	public MeetingYyPage getMyReviewInfoList(MeetingYyPage page) {
		int count = meetingYyDAO.getMyReviewInfoCount(page);
		if(count == 0){
			return page;
		}
		// 取得会议室预约待审核信息集合(分页查询)
		List<MeetingYy> meetingYyList = meetingYyDAO.getMyReviewInfoList(page);
		page.setTotalRow(count); //待审核总数量
		page.setMeetingYyList(meetingYyList);//待审核信息集合
		return page;
	}

	/**
	 * 查找会议预约表详细信息根据ID
	 * 
	 * @return 会议预约表表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@Override
	public MeetingYy selectMeetingYyToDetail(Long id) {
		MeetingYy meetingYy = meetingYyDAO.selectMeetingYyInfo(id);
		return meetingYy;
	}

	/**
	 * 修改状态
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@Override
	public boolean updateMeetingYyToStatus(Long id, Integer status) {
		MeetingYy meetingYy = new MeetingYy();
		meetingYy.setId(id);
		meetingYy.setStatus(status);
		meetingYy.setEnabled(CommonChar.FILE_NORMAL);
		meetingYy.setCurrentOptId(SecurityUtils.getLoginId());
		Integer count = meetingYyDAO.updateMeetingYy(meetingYy);
		return isUpdateSucc(count);
	}

	/**
	 * 查找会议审批表详细信息根据ID
	 * 
	 * @return 会议审批表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@Override
	public MeetingYyReviewPage getMeetingYyReviewListById(Long id) {
		MeetingYyReviewPage page = new MeetingYyReviewPage();
		List<MeetingYyReview> meetingYyReviewList = meetingYyReviewDAO.findMeetingYyReviewList(id);
		page.setMeetingYyReviewList(meetingYyReviewList);
		return page;
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
	@Override
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createMeetingYyReview(MeetingYy meetingYy) {
	    // 数据库新增一条审核记录,并返回是否插入成功
		meetingYy.setCurrentOptId(SecurityUtils.getLoginId());
		meetingYy.setEnabled(1);
		meetingYyDAO.updateMeetingYyById(meetingYy);
		Long pk = meetingYyReviewDAO.insertIntoMeetingYyReview(toInsterCarApproveReview(meetingYy));
		
		// 添加消息提醒的信息
		if (meetingYy.getNextOptId() != null && !"".equals(meetingYy.getNextOptId())) {
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(meetingYy.getId());
			remind.setLoginId(meetingYy.getNextOptId());
			remind.setModeName(CommonChar.MODE_METTING);
			MeetingYy meetingYyTemp = meetingYyDAO.selectMeetingYyInfo(meetingYy.getId());
			MeetingRoom meetingRoom = meetingRoomDAO.findMeetingRoomInfoById(new Long(meetingYyTemp.getRoomId()));
			remind.setTitle(meetingYy.getUserName()+"于"+meetingYy.getStartTime()+"~"+meetingYy.getEndTime()+"时间段预约"+meetingRoom.getRoomName());
			remind.setUrl("meetingYy/edit_meetingYy_review.htm?id="+meetingYy.getId());
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		// 此处默认返回操作成功成功
		return isInsertSucc(pk);
	}

}