package com.bcqsoft.sgoa.dao.meetingroom;

import java.util.List;

import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoom;
import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoomPage;


/**
 * 会议室表数据库访问DAO接口
 * 
 * <pre>
 * TABLE:SCOA_TB_MEETING_ROOM
 * </pre>
 */
public interface MeetingRoomDAO {

	/**
	 * 插入信息至会议室表
	 * 
	 * @param meetingRoom
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Long insertIntoMeetingRoom(MeetingRoom meetingRoom);

	/**
	 * 根据查询条件查询符合条件的会议室(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Integer findMeetingRoomInfoCount(MeetingRoomPage page);

	/**
	 * 根据查询条件查询符合条件的会议室
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */

	List<MeetingRoom> findMeetingRoomInfoList(MeetingRoomPage page);

	/**
	 * 根据ID查询某一条会议室
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	MeetingRoom findMeetingRoomInfoById(long id);

	/**
	 * 根据ID更新某条会议室信息
	 * 
	 * @param meetingRoom
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Integer updateMeetingRoomInfoById(MeetingRoom meetingRoom);

	/**
	 * 根据ID删除某条会议室信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Integer updateMeetingRoomStatusToDisabled(long id);

	/**
	 * 查找全部会议室名称信息列表
	 * 
	 * @return 会议室名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	List<MeetingRoom> findAllMeetingRoomInfo();

}
