package com.bcqsoft.sgoa.dao.meetingyyreview.ibatis;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.meetingyyreview.MeetingYyReviewDAO;
import com.bcqsoft.sgoa.dao.meetingyyreview.dataobject.MeetingYyReview;


/**
 * 会议室审核表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE:SCOA_TB_MEETING_YY_REVIEW
 * </pre>
 */
@Repository
public class IbatisMeetingYyReviewDAO extends BaseDAO implements MeetingYyReviewDAO {

	/**
	 * 添加会议室审核页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@Override
	public Long insertIntoMeetingYyReview(MeetingYyReview meetingYyReview) {
		return (Long) ibatis().insert("meetingYyReview.insertIntoMeetingYyReview",meetingYyReview);
	}

	/**
	 * 查找会议审批表详细信息根据ID
	 * 
	 * @return 会议审批表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MeetingYyReview> findMeetingYyReviewList(Long id) {
		return (List<MeetingYyReview>) ibatis().queryForList("meetingYyReview.findMeetingYyReviewList", id);
	}
}