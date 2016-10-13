package com.bcqsoft.sgoa.dao.meetingyy;

import java.util.List;

import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYy;
import com.bcqsoft.sgoa.dao.meetingyy.dataobject.MeetingYyPage;


/**
 * 会议室预约表数据库访问DAO接口
 * 
 * <pre>
 * TABLE:SCOA_TB_MEETING_YY
 * </pre>
 */
public interface MeetingYyDAO {

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
	Long insertIntoMeetingYy(MeetingYy meetingYy);
	
	/**
	 *会议预约表列表数量
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	Integer getMeetingYyInfoCount(MeetingYyPage page);

	/**
	 *会议预约表列表集合
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	List<MeetingYy> getMeetingYyInfoList(MeetingYyPage page);
	
	/**
	 *时间比较
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	List<MeetingYy> getMeetingYyTimeCompare(MeetingYyPage page);

	/**
	 *待审核表列表数量
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	Integer getMeetingYyReviewInfoCount(MeetingYyPage page);

	/**
	 *待审核表列表集合
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	List<MeetingYy> getMeetingYyReviewInfoList(MeetingYyPage page);
	
	/**
	 *待审核表列表数量
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	Integer getMeetingYyReviewInfoCountForAlert(MeetingYyPage page);

	/**
	 *经我审核表列表数量
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	Integer getMyReviewInfoCount(MeetingYyPage page);

	/**
	 *经我审核表列表集合
	 * 
	 * @author cql
	 * @date 2013-5-14
	 * @return List&lt;page&gt;
	 */
	List<MeetingYy> getMyReviewInfoList(MeetingYyPage page);

	/**
	 * 查找会议预约表详细信息根据ID
	 * 
	 * @return 会议预约表表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	MeetingYy selectMeetingYyInfo(Long id);

	/**
	 * 修改状态
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	Integer updateMeetingYy(MeetingYy meetingYy);

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
	Integer updateMeetingYyById(MeetingYy meetingYy);
	
}