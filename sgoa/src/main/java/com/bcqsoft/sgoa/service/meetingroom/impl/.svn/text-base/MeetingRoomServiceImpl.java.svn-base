package com.bcqsoft.sgoa.service.meetingroom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.meetingroom.MeetingRoomDAO;
import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoom;
import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoomPage;
import com.bcqsoft.sgoa.service.meetingroom.MeetingRoomService;

@Service
public class MeetingRoomServiceImpl extends BaseService implements MeetingRoomService {

	@Autowired
	private MeetingRoomDAO meetingRoomDAO;

	/**
	 * 创建一条新的会议室
	 * 
	 * @param meetingRoom
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public boolean createMeetingRoomInfo(MeetingRoom meetingRoom) {
		Long pk = meetingRoomDAO.insertIntoMeetingRoom(meetingRoom);
		return isInsertSucc(pk);
	}

	/**
	 * 更新会议室信息
	 * 
	 * @param meetingRoom
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public boolean updateMeetingRoomInfo(MeetingRoom meetingRoom) {
		Integer count = meetingRoomDAO.updateMeetingRoomInfoById(meetingRoom);
		return isUpdateSucc(count);
	}

	/**
	 * 取得会议室列表(分页)
	 * 
	 * @param page
	 * @return MeetingRoomPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public MeetingRoomPage getMeetingRoomListByPage(MeetingRoomPage page) {
		int count = meetingRoomDAO.findMeetingRoomInfoCount(page);
		if (count == 0) {
			return page;
		}

		// 取得会议室集合(分页查询)
		List<MeetingRoom> meetingRoomList = meetingRoomDAO.findMeetingRoomInfoList(page);

		page.setTotalRow(count); // 会议室总数量
		page.setMeetingRoomList(meetingRoomList); // 会议室集合

		return page;
	}

	/**
	 * 删除一条会议室(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public boolean deleteMeetingRoomInfo(Long id) {
		Integer count = meetingRoomDAO.updateMeetingRoomStatusToDisabled(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除会议室(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-5-13
	 */
	public boolean deleteMeetingRoomInfos(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : idArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = deleteMeetingRoomInfo(storageId);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 取得会议室详细信息
	 * 
	 * @param id
	 * @return MeetingRoom
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public MeetingRoom getMeetingRoomDetailInfo(Long id) {
		return meetingRoomDAO.findMeetingRoomInfoById(id);
	}

}
