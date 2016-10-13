package com.bcqsoft.sgoa.mvc.controller.meetingroom;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoom;
import com.bcqsoft.sgoa.dao.meetingroom.dataobject.MeetingRoomPage;
import com.bcqsoft.sgoa.mvc.form.meetingroom.MeetingRoomForm;
import com.bcqsoft.sgoa.service.meetingroom.MeetingRoomService;

@Controller
public class MeetingRoomController {

	/**
	 * 会议室模块业务逻辑类接口
	 */
	@Autowired
	private MeetingRoomService meetingRoomService;

	/**
	 * 取得有效的会议室列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("/meetingRoom/list.htm")
	public String meetingRoomList(MeetingRoomForm form, ModelMap map) {
		MeetingRoomPage meetingRoomPage = new MeetingRoomPage(); // 分页对象
		setSearchKey(form, meetingRoomPage); // 设置页面中的查询条件
		// 取得会议室列表,分页显示
		MeetingRoomPage page =new MeetingRoomPage();
		page=meetingRoomService.getMeetingRoomListByPage(meetingRoomPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "meetingRoom_list");
		// 跳转至会议室列表页面
		return "meetingroom/meetingroom_list";
	}

	/**
	 * 跳转至添加会议室页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/meetingRoom/add.htm", method = RequestMethod.GET)
	public String addMeetingRoom() {
		return "meetingroom/add_meetingroom";
	}

	/**
	 * 添加会议室页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/meetingRoom/add.htm", method = RequestMethod.POST)
	public String addMeetingRoom(MeetingRoomForm form) {
		meetingRoomService.createMeetingRoomInfo(toBean(form));
		return "common/action_succ";
	}

	/**
	 * 更新添加会议室获取页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/meetingRoom/edit.htm", method = RequestMethod.GET)
	public String editMeetingRoom(Long id, ModelMap map) {
		map.put("meetingRoom", meetingRoomService.getMeetingRoomDetailInfo(id));
		return "meetingroom/edit_meetingroom";
	}

	/**
	 * 详细会议室获取页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/meetingRoom/detail.htm", method = RequestMethod.GET)
	public String detailMeetingRoom(Long id, ModelMap map) {
		map.put("meetingRoom", meetingRoomService.getMeetingRoomDetailInfo(id));
		return "meetingroom/detail_meetingroom";
	}
	
	/**
	 * 更新会议室页面
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/meetingRoom/edit.htm", method = RequestMethod.POST)
	public String editMeetingRoom(MeetingRoomForm form) {
		meetingRoomService.updateMeetingRoomInfo(toBean(form));
		return "common/action_succ";
	}

	/**
	 * 删除会议室
	 * 
	 * @param id
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("/meetingRoom/delete.htm")
	public String removeMeetingRoom(Long id) {
		meetingRoomService.deleteMeetingRoomInfo(id);
		return "common/action_succ";
	}

	/**
	 * 删除会议室(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("meetingRoom/delete_batch.htm")
	public String removeMeetingRooms(String idArray) {
		meetingRoomService.deleteMeetingRoomInfos(toLongArray(idArray));
		return "common/action_succ";
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
	private MeetingRoom toBean(MeetingRoomForm form) {
		MeetingRoom meetingRoom = new MeetingRoom();
		BeanUtils.copyProperties(form, meetingRoom);
		meetingRoom.setRoomAddress(form.getRoomAddress());// 会议室名称
		meetingRoom.setRoomName(form.getRoomName()); //
		meetingRoom.setEnabled("Y");
		return meetingRoom;
	}

	/**
	 * 会议室列表页面设置查询条件
	 * 
	 * @param form
	 * @param storagePage
	 * 
	 * @Author cql
	 * @Date 2013-5-14
	 */
	private void setSearchKey(MeetingRoomForm form, MeetingRoomPage meetingRoomPage) {
		meetingRoomPage.setCurrentPage(form.getCp()); // 当前页数
		meetingRoomPage.setRoomAddress(form.getRoomAddress());// 会议室地址
		meetingRoomPage.setRoomName(form.getRoomName()); 
		meetingRoomPage.setCreateDate(form.getCreateDate());
	}
}
