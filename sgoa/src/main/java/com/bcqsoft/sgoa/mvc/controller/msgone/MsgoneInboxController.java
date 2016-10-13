package com.bcqsoft.sgoa.mvc.controller.msgone;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInbox;
import com.bcqsoft.sgoa.dao.msgoneinbox.dataobject.MsgoneInboxPage;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutbox;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.mvc.form.msgone.MsgoneInboxForm;
import com.bcqsoft.sgoa.mvc.form.msgone.MsgoneOutboxForm;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.msgone.MsgoneInboxService;
import com.bcqsoft.sgoa.service.msgone.MsgoneOutboxService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 收件箱模块控制器
 * 
 * @author Bcqsoft.com sbq
 * 
 */
@Controller
public class MsgoneInboxController {
	/**
	 * 收件箱的业务逻辑层
	 */
	@Autowired
	private MsgoneInboxService msgoneInboxService;
	/**
	 * 发件箱的业务逻辑层
	 */
	@Autowired
	private MsgoneOutboxService msgoneOutboxService;

	/**
	 * 用户的业务逻辑层
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 共通逻辑类接口
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * 转发站内信功能
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@RequestMapping("/msgone/update_add.htm")
	public String addMsgoneOutbox(MsgoneOutboxForm form, ModelMap map) {

		// 表单数据校验
		// 数据库增加一条站内信记录
		msgoneOutboxService.editMsgoneOutbox(setBeans(form));
		// 返回到操作成功页面
		return "common/action_succ";
	}

	/**
	 * 取得有效的收件箱列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/msgone/msgoneInbox_list.htm")
	public String selectMsgoneInboxListByPage(MsgoneInboxForm form, ModelMap map) {
		MsgoneInboxPage msgoneInboxPage = new MsgoneInboxPage(); // 分页对象
		setSearchKey(form, msgoneInboxPage); // 设置页面中的查询条件
		// 取得收件箱列表,分页显示
		MsgoneInboxPage page = msgoneInboxService.getMsgoneInboxListByPage(msgoneInboxPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msgoneInbox_list");
		// 跳转至收件箱列表页面
		return "msgone/msgoneInbox_list";
	}

	/**
	 * 取得有效的垃圾箱列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/msgone/dustbin_list.htm")
	public String selectDustbinListByPage(MsgoneInboxForm form, ModelMap map) {
		MsgoneInboxPage msgoneInboxPage = new MsgoneInboxPage(); // 分页对象
		setSearchKey(form, msgoneInboxPage); // 设置页面中的查询条件
		// 取得垃圾箱列表,分页显示
		MsgoneInboxPage page = msgoneInboxService.getDustbinListByPage(msgoneInboxPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msgone_dustbin_list");
		// 跳转至垃圾箱列表页面
		return "msgone/dustbin_list";
	}

	/**
	 * 跳转至转发收件箱页面
	 * 
	 * @return 新增收件箱页面
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/msgoneInbox/edit_msgoneInbox.htm", method = RequestMethod.GET)
	public String editMsgoneInbox(long id, ModelMap map) {
		MsgoneInbox msgoneInbox = msgoneInboxService.selectMsgoneInboxById(id);
		msgoneInboxService.updateMsgoneInboxInfo(msgoneInbox);
		map.put("msgoneInbox", msgoneInbox);// 保存页面渲染数据
		String loginId = SecurityUtils.getLoginId();
		map.put("loginId", loginId);
		// 跳转至收件箱更新列表页面
		return "msgone/edit_msgoneInbox";
	}

	/**
	 * 跳转至收件箱详细页面
	 * 
	 * @return 收件箱详细页面
	 * 
	 * @Author cql
	 * @Date 2012-02-21
	 */
	@RequestMapping(value = "/msgone/detail_msgoneInbox.htm", method = RequestMethod.GET)
	public String detailMsgoneInbox(long id, ModelMap map) {
		MsgoneInbox msgoneInbox = msgoneInboxService.selectMsgoneInboxById(id);
		String isRead = msgoneInbox.getIsRead();
		// 根据读取状态 判断是否已读
		if ("N".equals(isRead)) {
			msgoneInboxService.updateMsgoneInboxInfo(msgoneInbox);
			// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
			Remind remind = new Remind();
			remind.setBusId(id);
			remind.setModeName(CommonChar.MODE_MSG_ONE);
			remind.setLoginId(SecurityUtils.getLoginId());
			remind.setStatus(CommonChar.REMIND_STATUS_BTX);
			commonService.updateRemindInfoByLoginId(remind);
		}

		map.put("msgoneInbox", msgoneInbox);// 保存页面渲染数据
		// 跳转至收件箱更新列表页面
		return "msgone/detail_msgoneInbox";
	}

	/**
	 * 收件箱删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新收件箱成功页面
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/msgoneInbox/delete.htm")
	public String delectMsgoneInbox(long id) {
		msgoneInboxService.deleteMsgoneInboxInfoById(id);
		// 设置操作日志
		return "common/action_succ";

	}

	/**
	 * 收件箱已读处理(逻辑已读,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新收件箱成功页面
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping("/msgoneInbox/read.htm")
	public String readMsgoneInbox(long id) {
		msgoneInboxService.readMsgoneInboxInfoById(id);
		
		// 更新消息中心提醒为不提醒
		// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
		Remind remind = new Remind();
		remind.setBusId(id);
		remind.setModeName(CommonChar.MODE_MSG);
		remind.setLoginId(SecurityUtils.getLoginId());
		remind.setStatus(CommonChar.REMIND_STATUS_BTX);
		commonService.updateRemindInfoByLoginId(remind);
		return "common/action_succ";

	}

	/**
	 * 已读收件箱(逻辑已读,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	@RequestMapping("/msgone/read_msgoneInboxArray.htm")
	public String readMsgoneInbox(String idArray) {
		// 删除收件箱信息
		msgoneInboxService.readMsgoneInboxs(toLongArray(idArray));
		// 返回到操作成功页面
		return "common/action_succ";
	}

	/**
	 * 删除收件箱(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	@RequestMapping("/msgone/delete_msgoneInboxArray.htm")
	public String removeMsgoneInbox(String idArray) {
		// 删除收件箱信息
		msgoneInboxService.deleteMsgoneInboxs(toLongArray(idArray));
		// 返回到操作成功页面
		return "common/action_succ";
	}

	/**
	 * 跳转至更新发件箱页面
	 * 
	 * @return 新增发件箱页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping("/dustbin/edit_msgoneDustbin.htm")
	public String selectDustbinboxById(MsgoneInboxForm form, ModelMap map) {
		long id = form.getId();
		String msgoneType = form.getMsgType();
		if ("Y".equals(msgoneType)) {

			map.put("msgoneOutbox", msgoneOutboxService.selectMsgoneOutboxById(id));
			return "msgone/detail_msgoneOutbox";
		} else {
			MsgoneInbox msgoneInbox = msgoneInboxService.selectMsgoneInboxById(id);
			map.put("msgoneInbox", msgoneInbox);
			return "msgone/detail_msgoneInbox";
		}

	}

	/**
	 * 发件箱更新处理
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping("/msgone/edit_msgoneDustbin.htm")
	public String editMsgoneInbox(MsgoneInboxForm form, ModelMap map) {
		msgoneInboxService.updateMsgoneInboxInfo(toBean(form));
		return "common/action_succ";

	}

	/**
	 * 查找发件人列表
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/megoneUser/user_list.htm")
	@ResponseBody
	public void searche(String userNamePy, HttpServletResponse response) {
		// Map<String, Object> data = new HashMap<String, Object>();
		// List<User> userList = userService.getUserListByPy(userNamePy);
		// data.put("userList", userList);
		// *********************************************************
		PrintWriter out = null;
		String result = "";
		try {
			// 判断传入的值是否为空
			if (userNamePy == null || "".equals(userNamePy.trim())) {
				// 为空的时候，直接输出[]
				result = "[]";
			} else {
				// 不为空的时候通过调用service方法取得相应的list
				List<User> userList = userService.getUserListByPy(userNamePy);
				result = "[";
				// 当取出值不为空时，循环取出并且输出页面需要格式的数据
				if (userList != null && userList.size() > 0) {
					Iterator it = userList.iterator();
					while (it.hasNext()) {
						User user = (User) it.next();
						result = result + "{id:'" + user.getLoginId()
								+ "',name:'" + user.getUserName() + "'},";
					}
					result = result.substring(0, result.length() - 1);
				}
				result = result + "]";
			}
			// 输出到页面
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 垃圾箱更新处理
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping("/msgone/regain.htm")
	public String regainMsgoneInbox(MsgoneInboxForm form, ModelMap map) {
		long id = form.getId();
		String msgoneType = form.getMsgType();
		if ("Y".equals(msgoneType)) {
			map.put("msgoneInbox", msgoneOutboxService.editMsgoneOutboxById(id));
			// 设置操作日志
			return "common/action_succ";
		} else {
			map.put("msgoneInbox", msgoneInboxService.editMsgoneInboxById(id));
			// 设置操作日志
			return "common/action_succ";
		}

	}

	/**
	 * 查看最新未读站内信
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping("/msgone/load_new_msgone.htm")
	@ResponseBody
	public Integer loadNewsetMsgone() {
		String userId = SecurityUtils.getLoginId(); // 登录用户ID
		// 取得未读的站内信
		List<MsgoneInbox> msgoneList = msgoneOutboxService
				.getUnreadMessageByUserId(userId);
		// 返回未读站内信数量
		return msgoneList.size();
	}

	/**
	 * DO设置
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-11-16
	 */
	private MsgoneInbox toBean(MsgoneInboxForm form) {
		MsgoneInbox msgoneInbox = new MsgoneInbox();
		BeanUtils.copyProperties(form, msgoneInbox); // 复制表单至DO
		return msgoneInbox;
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return MessageEntity
	 * 
	 * @Author sbq
	 * @Date 2011-10-19
	 */
	private MsgoneOutbox setBeans(MsgoneOutboxForm form) {
		MsgoneOutbox msgoneOutbox = new MsgoneOutbox();
		BeanUtils.copyProperties(form, msgoneOutbox); // 设置表单属性
		msgoneOutbox.setSenderId(SecurityUtils.getLoginId()); // 设置登录Id
		return msgoneOutbox;
	}

	/**
	 * 收件箱列表页面设置查询条件
	 * 
	 * @param form
	 * @param MsgoneInboxPage
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	private void setSearchKey(MsgoneInboxForm form, MsgoneInboxPage msgoneInboxPage) {
		msgoneInboxPage.setCurrentPage(form.getCp()); // 当前页数
		msgoneInboxPage.setReceiverId(SecurityUtils.getLoginId());// 获取登录帐号
		msgoneInboxPage.setSenderId(form.getSenderId());// 获取发件人帐号
		msgoneInboxPage.setSenderName(form.getUserNamePy());
		msgoneInboxPage.setTitle(form.getTitle());// 获取标题
		msgoneInboxPage.setCreateDate(form.getCreateDate());// 获取发送时间
		msgoneInboxPage.setIsRead(form.getIsRead());// 获取状态
	}
	
	
	/**
	 * 跳转至转发收件箱页面
	 * 
	 * @return 新增收件箱页面
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/msgone/replay_msgoneInboxInfo.htm", method = RequestMethod.POST)
	public String replayMsgoneInboxInfo(MsgoneInboxForm form, ModelMap map) {
		MsgoneInbox msgoneInbox = msgoneInboxService.selectMsgoneInboxById(form.getId());
		map.put("msgoneInbox", msgoneInbox);// 保存页面渲染数据
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("d_userName", SecurityUtils.getLoginId());
		map.put("d_fileType", "doc");
		// 跳转至收件箱更新列表页面
		return "msgone/replay_msgoneInbox";
	}
	
	/**
	 * 跳转至信息内容页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/msgone/content_detail.htm", method = RequestMethod.GET)
	public String contentMessage(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/msgone/content_message";
	}
	
}
