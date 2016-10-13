package com.bcqsoft.sgoa.dao.sw.dataobject;

import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;

/**
 * 信息表ORM对象
 * 
 * <pre>
 * 表: SCOA_TB_DOCIN
 * </pre>
 */
public class SwPage extends BasePage {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -2600809959357582130L;

	/**
	 * 用户ID
	 */
	private String loginId;
	
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 文件状态(1:正常, 2:草稿, 3:删除)
	 */
	private Integer enabled;

	/**
	 * 类别(1、通知，2、公告)
	 */
	private Integer sort;

	/**
	 * 当前操作人ID
	 */
	private String currentOptId;
	
	/**
	 * 下一步操作人ID(关联SCOA_TB_USER.ID)
	 */
	private String nextOptId;

	/**
	 * 当前状态(1:未读, 2:提交,3:否决, 4:批准, 5:提交申请, 6:归档)
	 */
	private Integer status;

	/**
	 * 通知公告集合
	 */
	private List<Sw> swList;

	/**
	 * 是否已读
	 */
	private String isRead;
	
	/**
	 * 登录人部门ID
	 */
	private String deptId;
	
	/**
	 * 收文字号
	 */
	private String docinNum;
	/**
	 * 收件人
	 */
	private String receivedId;
	
	/**
	 * 成文时间
	 */
	private String textTime;
	/**
	 * Getter And Setter
	 */

	public String getTitle() {
		return title;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCurrentOptId() {
		return currentOptId;
	}

	public void setCurrentOptId(String currentOptId) {
		this.currentOptId = currentOptId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Sw> getSwList() {
		return swList;
	}

	public void setSwList(List<Sw> swList) {
		this.swList = swList;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getNextOptId() {
		return nextOptId;
	}

	public void setNextOptId(String nextOptId) {
		this.nextOptId = nextOptId;
	}

	public String getDocinNum() {
		return docinNum;
	}

	public void setDocinNum(String docinNum) {
		this.docinNum = docinNum;
	}

	public String getReceivedId() {
		return receivedId;
	}

	public void setReceivedId(String receivedId) {
		this.receivedId = receivedId;
	}

	public String getTextTime() {
		return textTime;
	}

	public void setTextTime(String textTime) {
		this.textTime = textTime;
	}
	
}
