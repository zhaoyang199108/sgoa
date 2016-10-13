package com.bcqsoft.sgoa.dao.meetingroom.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.meetingroom.MeetingRoomDAO;
import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoom;
import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoomPage;


/**
 * 会议室表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE:SCOA_TB_MEETING_ROOM
 * </pre>
 */
@Repository
public class IbatisMeetingRoomDAO extends BaseDAO implements MeetingRoomDAO {
	/**
	 * 插入一条信息至会议室表
	 * 
	 * @param meetingRoom
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public Long insertIntoMeetingRoom(MeetingRoom meetingRoom) {
		return (Long) ibatis().insert("meetingroom.insertIntoMeetingRoom", meetingRoom);
	}

	/**
	 * 根据查询条件查询符合条件的会议室(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */

	public Integer findMeetingRoomInfoCount(MeetingRoomPage page) {
		return (Integer) ibatis().queryForObject("meetingroom.findMeetingRoomInfoCount", page);
	}

	/**
	 * 根据查询条件查询符合条件的会议室
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */

	@SuppressWarnings("unchecked")
	public List<MeetingRoom> findMeetingRoomInfoList(MeetingRoomPage page) {
		return (List<MeetingRoom>) ibatis().queryForList("meetingroom.findMeetingRoomInfoList", page);
	}

	/**
	 * 根据ID查询某一条会议室
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public MeetingRoom findMeetingRoomInfoById(long id) {
		return (MeetingRoom) ibatis().queryForObject("meetingroom.findMeetingRoomInfoById", id);
	}

	/**
	 * 根据ID更新某条会议室信息
	 * 
	 * @param meetingRoom
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public Integer updateMeetingRoomInfoById(MeetingRoom meetingRoom) {
		return (Integer) ibatis().update("meetingroom.updateMeetingRoomInfoById", meetingRoom);
	}

	/**
	 * 根据ID删除某条会议室信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public Integer updateMeetingRoomStatusToDisabled(long id) {
		return (Integer) ibatis().update("meetingroom.updateMeetingRoomStatusToDisabled", id);
	}

	/**
	 * 查找全部会议室名称信息列表
	 * 
	 * @return 会议室名称列表
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	@SuppressWarnings("unchecked")
	public List<MeetingRoom> findAllMeetingRoomInfo() {
		return (List<MeetingRoom>) ibatis().queryForList("meetingroom.findAllMeetingRoomInfo");
	}

}
