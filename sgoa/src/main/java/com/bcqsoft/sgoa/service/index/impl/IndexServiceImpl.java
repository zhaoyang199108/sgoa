package com.bcqsoft.sgoa.service.index.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.alert.AlertDAO;
import com.bcqsoft.sgoa.dao.alert.dataobject.AlertPage;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.remind.dataobject.RemindPage;
import com.bcqsoft.sgoa.service.index.IndexService;

/**
 * 首页模块业务逻辑类实现类
 */
@Service
public class IndexServiceImpl extends BaseService implements IndexService {

	/**
	 * 首页显示数据默认数量
	 */
	public static final Integer DF_COUNT = 14;
	public static final Integer ET_COUNT = 8;
	public static final Integer FI_COUNT = 5;

	/**
	 * 消息提醒数据库访问DAO接口
	 */
	@Autowired
	private AlertDAO alertDAO;

	/**
	 * 消息中心数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 取得主页面中提示信息
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	public Map<String, Object> getAlertMessageForIndex() {
		Map<String, Object> dataMap = new HashMap<String, Object>();

		// 取得所有需要题型的消息
		RemindPage remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);

		// 取得符合条件的发文待审核信息
		remindPage.setModeName(CommonChar.MODE_DOCOUT);
		// 根据条件查找用户待审核信息数量
		int countDocout = remindDAO.findRemindInfoForIndex(remindPage);

		// 取得符合条件的收文待审核信息
		remindPage.setModeName(CommonChar.MODE_DOCIN);
		// 根据条件查找用户待审核信息数量
		int countDocin = remindDAO.findRemindInfoForIndex(remindPage);

		// 取得符合的会议预约
		remindPage.setModeName(CommonChar.MODE_METTING);
		int countMeeting = remindDAO.findRemindInfoForIndex(remindPage);

		// 设置查询条件
		AlertPage alertPage = new AlertPage();
		alertPage.setLoginId(SecurityUtils.getLoginId());
		alertPage.setAlertTime(DateUtil.getDateTimeForYMD(new Date()));
		alertPage.setStatus(CommonChar.STATUS_WD);
		int countAlert = alertDAO.findAlertInfoForIndex(alertPage);

		// 设置查询条件
		remindPage.setModeName(CommonChar.MODE_MESSAGE);
		int countMessage = remindDAO.findRemindInfoForIndex(remindPage);

		// 设置查询条件
		remindPage.setModeName(CommonChar.MODE_NOTICE);
		int countNotice = remindDAO.findRemindInfoForIndex(remindPage);

		// 设置查询条件
		remindPage.setModeName(CommonChar.MODE_NEWS);
		int countNews = remindDAO.findRemindInfoForIndex(remindPage);

		// 设置查询条件
		remindPage.setModeName(CommonChar.MODE_BRIEF);
		int countBrief = remindDAO.findRemindInfoForIndex(remindPage);

		remindPage.setModeName(CommonChar.MODE_MSG);
		int countMsg = remindDAO.findRemindInfoForIndex(remindPage);

		// 初始化page对象
		remindPage.setModeName(CommonChar.MODE_SCHEDULER);
		remindPage.setStartTime(DateUtil.getDateTime());
		Integer countScheduler = remindDAO.findRemindInfoForIndex(remindPage);

		// 初始化page对象
		remindPage.setModeName(CommonChar.MODE_WORK_SCHEDULER);
		remindPage.setStartTime(DateUtil.getDateTime());
		Integer countWorkScheduler = remindDAO
				.findRemindInfoForIndex(remindPage);

		// 初始化page对象
		remindPage.setModeName(CommonChar.MODE_LEADER_SCHEDULER);
		remindPage.setStartTime(DateUtil.getDateTime());
		Integer countLeaderScheduler = remindDAO
				.findRemindInfoForIndex(remindPage);

		Integer countAll = countDocout + countDocin + countMeeting + countAlert
				+ countMessage + countNotice + countNews + countBrief
				+ countMsg + countScheduler + countWorkScheduler
				+ countLeaderScheduler;

		if (countAll > 0) {
			dataMap.put("amInfoCount", countAll);
		}

		return dataMap;
	}

	/**
	 * 取得主页面中提示信息
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	public Map<String, Integer> getAlertMessageForIndexCount() {

		Map<String, Integer> dataMap = new HashMap<String, Integer>();

		// 取得所有需要题型的消息
		RemindPage remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);

		// 取得符合条件的发文待审核信息
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_DOCOUT);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		// 根据条件查找用户待审核信息数量
		int countDocout = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoDocout", countDocout);

		// 取得符合条件的收文待审核信息
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_DOCIN);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		// 根据条件查找用户待审核信息数量
		int countDocin = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoDocin", countDocin);

		// 取得符合的会议预约
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_METTING);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		int countMeeting = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoMeeting", countMeeting);

		// 设置查询条件
		AlertPage alertPage = new AlertPage();
		alertPage.setLoginId(SecurityUtils.getLoginId());
		alertPage.setAlertTime(DateUtil.getDateTimeForYMD(new Date()));
		alertPage.setStatus(CommonChar.STATUS_WD);
		int countAlert = alertDAO.findAlertInfoForIndex(alertPage);
		dataMap.put("amInfoAlert", countAlert);

		// 设置查询条件
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_MESSAGE);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		int countMessage = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoMessage", countMessage);

		// 设置查询条件
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_NOTICE);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		int countNotice = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoNotice", countNotice);

		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_MSG);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		int countMsg = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoMsg", countMsg);

		// 初始化page对象
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_MSG_ONE);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		Integer countMsgOne = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoMsgOne", countMsgOne);

		// 初始化page对象
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_SCHEDULER);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		remindPage.setStartTime(DateUtil.getDateTime());
		Integer countScheduler = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoScheduler", countScheduler);

		// 初始化page对象
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_WORK_SCHEDULER);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		remindPage.setStartTime(DateUtil.getDateTime());
		Integer countWorkScheduler = remindDAO
				.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoWorkScheduler", countWorkScheduler);

		// 初始化page对象
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_LEADER_SCHEDULER);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		remindPage.setStartTime(DateUtil.getDateTime());
		Integer countLeaderScheduler = remindDAO
				.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoLeaderScheduler", countLeaderScheduler);

		// 初始化page对象
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_SW);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		remindPage.setStartTime(DateUtil.getDateTime());
		Integer countSw = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoSw", countSw);

		// 设置查询条件
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_NEWS);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		int countNews = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoNews", countNews);

		// 设置查询条件
		remindPage = new RemindPage();
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setModeName(CommonChar.MODE_BRIEF);
		remindPage.setStatus(CommonChar.REMIND_STATUS_TX);
		int countBrief = remindDAO.findRemindInfoForIndex(remindPage);
		dataMap.put("amInfoBrief", countBrief);

		return dataMap;
	}

	/**
	 * 取得主页面中提示信息
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public void alertInfoEditZbtx(String[] idArray) {

		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (String modeName : idArray) {
			// 将消息标记为暂不提醒
			Remind remind = new Remind();
			remind.setModeName(modeName);
			remind.setStatus(CommonChar.REMIND_STATUS_ZBTX);
			remind.setLoginId(SecurityUtils.getLoginId());
			remind.setStatusTemp(CommonChar.REMIND_STATUS_TX);
			remindDAO.updateRemindInfoByModeName(remind);
		}
	}

	/**
	 * 取得主页面中提示信息
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public void alertInfoEditBtx(String[] idArray) {

		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (String modeName : idArray) {
			// 将消息标记为已读
			Remind remind = new Remind();
			remind.setModeName(modeName);
			remind.setStatus(CommonChar.REMIND_STATUS_BTX);
			remind.setLoginId(SecurityUtils.getLoginId());
			remind.setStatusTemp(CommonChar.REMIND_STATUS_TX);
			remindDAO.updateRemindInfoByModeName(remind);
		}
	}

	/**
	 * 取得主页面中提示信息
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public void alertInfoEditHftx(String[] idArray) {

		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (String modeName : idArray) {
			// 将消息标记为已读
			Remind remind = new Remind();
			remind.setModeName(modeName);
			remind.setStatus(CommonChar.REMIND_STATUS_ZBTX);
			remind.setLoginId(SecurityUtils.getLoginId());
			remind.setStatusTemp(CommonChar.REMIND_STATUS_TX);
			remindDAO.updateRemindInfoByModeName(remind);
		}
	}

	/**
	 * 取得主页面中提示信息
	 * 
	 * @return 当前提示信息
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-12
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public void alertInfoEditTx() {

		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		// 将消息标记为已读
		Remind remind = new Remind();
		remind.setStatus(CommonChar.REMIND_STATUS_TX);
		remind.setStatusTemp(CommonChar.REMIND_STATUS_ZBTX);
		remind.setLoginId(SecurityUtils.getLoginId());
		remindDAO.updateRemindInfoByModeName(remind);
	}
}
