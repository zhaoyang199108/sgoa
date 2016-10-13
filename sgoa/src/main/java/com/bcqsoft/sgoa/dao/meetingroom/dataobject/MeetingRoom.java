package com.bcqsoft.sgoa.dao.meetingroom.dataobject;

/**
 * 会议室表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_MEETING_ROOM
 * </pre>
 */
public class MeetingRoom {

	/**
	 * 自增型主键
	 */
	private Long id;

	/**
	 * 创建日期
	 */
	private String createDate;

	/**
	 * 更新日期
	 */
	private String updateDate;

	/**
	 * 会议室名称
	 */
	private String roomName;

	/**
	 * 会议室地点
	 */
	private String roomAddress;

	/**
	 * Y: 有效, N无效
	 */
	private String enabled;

	/**
	 * 取得自增型主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置自增型主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 取得创建日期
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * 取得更新日期
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置更新日期
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 取得会议室名称
	 */
	public String getRoomName() {
		return roomName;
	}

	/**
	 * 设置会议室名称
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	/**
	 * 取得会议室地点
	 */
	public String getRoomAddress() {
		return roomAddress;
	}

	/**
	 * 设置会议室地点
	 */
	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	/**
	 * 取得Y: 有效, N无效
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * 设置Y: 有效, N无效
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
