package com.bcqsoft.sgoa.service.meetingyy;

import java.util.List;

import com.bcqsoft.sgoa.dao.approval.dataobject.Approval;
import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoom;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYy;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYyPage;
import com.bcqsoft.sgoa.dao.meetingyyreview.dataobject.MeetingYyReviewPage;

public interface MeetingYyService {

	/**
	 * 查找全部会议室名称信息列表
	 * 
	 * @return 会议室名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	List<MeetingRoom> findAllRoomInfo();

	/**
	 * 查找全部审批名称信息列表
	 * 
	 * @return 审批名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	List<Approval> findAllApprovalInfo();

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
    boolean createMeetingYyInfo(MeetingYy meetingYy);

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
	MeetingYyPage getMeetingYyInfoList(MeetingYyPage meetingYyPage);

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
	List<MeetingYy> getMeetingYyTimeCompare(MeetingYyPage meetingYyPage);
	
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
	MeetingYyPage getMeetingYyReviewInfoList(MeetingYyPage meetingYyPage);

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
	MeetingYyPage getMyReviewInfoList(MeetingYyPage meetingYyPage);

	/**
	 * 查找会议预约表详细信息根据ID
	 * 
	 * @return 会议预约表表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	MeetingYy selectMeetingYyToDetail(Long id);

	boolean updateMeetingYyToStatus(Long id, Integer status);

	/**
	 * 查找会议审批表详细信息根据ID
	 * 
	 * @return 会议审批表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	MeetingYyReviewPage getMeetingYyReviewListById(Long id);

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
	boolean createMeetingYyReview(MeetingYy meetingYy);
	
}