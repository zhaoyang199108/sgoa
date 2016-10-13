package com.bcqsoft.sgoa.dao.optlog.dataobject.page;

import java.util.List;

import com.bcqsoft.sgoa.core.base.BasePage;
import com.bcqsoft.sgoa.dao.optlog.dataobject.OptLog;

/**
 * 操作日志表数据库访问ORM_DO对象
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCUMENT_IN
 * </pre>
 */
public class OptLogPage extends BasePage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2559972632628886571L;

	/**
	 * 操作日志集合
	 */
	private List<OptLog> optLogList;

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
	 * 操作人ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	private String optId;
	
	/**
	 * 操作人名称(关联SCOA_TB_USER.USER_NAME)
	 */
	private String optName;

	/**
	 * IP地址
	 */
	private String optIp;

	/**
	 * MAC地址
	 */
	private String optMac;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	
	/**
	 * 结束时间
	 */
	private String endTime;

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
	 * 取得操作人ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	public String getOptId() {
		return optId;
	}

	/**
	 * 设置操作人ID(关联SCOA_TB_USER.LOGIN_ID)
	 */
	public void setOptId(String optId) {
		this.optId = optId;
	}
	
	/**
	 * 取得操作人名称
	 */
	public String getOptName() {
		return optName;
	}

	/**
	 * 设置操作人名称
	 */
	public void setOptName(String optName) {
		this.optName = optName;
	}

	public List<OptLog> getOptLogList() {
		return optLogList;
	}

	public void setOptLogList(List<OptLog> optLogList) {
		this.optLogList = optLogList;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOptIp() {
		return optIp;
	}

	public void setOptIp(String optIp) {
		this.optIp = optIp;
	}

	public String getOptMac() {
		return optMac;
	}

	public void setOptMac(String optMac) {
		this.optMac = optMac;
	}
}
