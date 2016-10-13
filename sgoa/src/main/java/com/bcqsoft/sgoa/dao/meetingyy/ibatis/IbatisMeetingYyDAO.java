package com.bcqsoft.sgoa.dao.meetingyy.ibatis;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.meetingyy.MeetingYyDAO;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYy;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYyPage;


/**
 * 会议室表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE:SCOA_TB_MEETING_YY
 * </pre>
 */
@Repository
public class IbatisMeetingYyDAO extends BaseDAO implements MeetingYyDAO {

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
	public Long insertIntoMeetingYy(MeetingYy meetingYy) {
		return (Long) ibatis().insert("meetingYy.insertIntoMeetingYy",meetingYy);
	}

	/**
	 *会议预约表列表数量
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	@Override
	public Integer getMeetingYyInfoCount(MeetingYyPage page) {
		return (Integer) ibatis().queryForObject("meetingYy.getMeetingYyInfoCount",page);
	}
	
	

	/**
	 *会议预约表列表集合
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MeetingYy> getMeetingYyInfoList(MeetingYyPage page) {
		return (List<MeetingYy>) ibatis().queryForList("meetingYy.getMeetingYyInfoList",page);
	}
	
	/**
	 *时间比较
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MeetingYy> getMeetingYyTimeCompare(MeetingYyPage page) {
		return (List<MeetingYy>) ibatis().queryForList("meetingYy.getMeetingYyTimeCompare",page);
	}

	/**
	 *待审核表列表数量
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	@Override
	public Integer getMeetingYyReviewInfoCount(MeetingYyPage page) {
		return (Integer) ibatis().queryForObject("meetingYy.getMeetingYyReviewInfoCount",page);
	}
	
	/**
	 *待审核表列表数量
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	@Override
	public Integer getMeetingYyReviewInfoCountForAlert(MeetingYyPage page) {
		return (Integer) ibatis().queryForObject("meetingYy.getMeetingYyReviewInfoCountForAlert",page);
	}

	/**
	 *待审核表列表集合
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MeetingYy> getMeetingYyReviewInfoList(MeetingYyPage page) {
		return (List<MeetingYy>) ibatis().queryForList("meetingYy.getMeetingYyReviewInfoList",page);
	}

	/**
	 *经我审核表列表数量
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	@Override
	public Integer getMyReviewInfoCount(MeetingYyPage page) {
		return (Integer) ibatis().queryForObject("meetingYy.getMyReviewInfoCount",page);
	}

	/**
	 *经我审核表列表集合
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MeetingYy> getMyReviewInfoList(MeetingYyPage page) {
		return (List<MeetingYy>) ibatis().queryForList("meetingYy.getMyReviewInfoList",page);
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
	public MeetingYy selectMeetingYyInfo(Long id) {
		return (MeetingYy) ibatis().queryForObject("meetingYy.selectMeetingYyInfo", id);
	}

	/**
	 * 审批进程修改
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@Override
	public Integer updateMeetingYy(MeetingYy meetingYy) {
		return (Integer) ibatis().update("meetingYy.updateMeetingYy", meetingYy);
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
	public Integer updateMeetingYyById(MeetingYy meetingYy) {
		return (Integer) ibatis().update("meetingYy.updateMeetingYyById", meetingYy);
	}
	
}