package com.bcqsoft.sgoa.service.meetingroom;

import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoom;
import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoomPage;


public interface MeetingRoomService {
	
	/**
	 * 添加会议室信息
	 * 
	 * @param meetingRoom
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	boolean createMeetingRoomInfo(MeetingRoom meetingRoom);

	/**
	 * 更新会议室信息
	 * 
	 * @param meetingRoom
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	boolean updateMeetingRoomInfo(MeetingRoom meetingRoom);

	/**
	 * 取得会议室列表(分页)
	 * 
	 * @param page
	 * @return MeetingRoomPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	MeetingRoomPage getMeetingRoomListByPage(MeetingRoomPage page);

	/**
	 * 删除一条会议室(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	boolean deleteMeetingRoomInfo(Long id);

	/**
	 * 删除会议室(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-5-13
	 */
	boolean deleteMeetingRoomInfos(long[] idArray);

	/**
	 * 取得会议室详细信息
	 * 
	 * @param id
	 * @return MeetingRoom
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	MeetingRoom getMeetingRoomDetailInfo(Long id);

}
