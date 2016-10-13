package com.bcqsoft.sgoa.mvc.controller.msg;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInbox;
import com.bcqsoft.sgoa.dao.msginbox.dataobject.MsgInboxPage;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutbox;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.mvc.form.msg.MsgInboxForm;
import com.bcqsoft.sgoa.mvc.form.msg.MsgOutboxForm;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.msg.MsgInboxService;
import com.bcqsoft.sgoa.service.msg.MsgOutboxService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 收件箱模块控制器
 * 
 * @author Bcqsoft.com sbq
 * 
 */
@Controller
public class MsgInboxController {
	/**
	 * 收件箱的业务逻辑层
	 */
	@Autowired
	private MsgInboxService msgInboxService;
	/**
	 * 发件箱的业务逻辑层
	 */
	@Autowired
	private MsgOutboxService msgOutboxService;

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
	@RequestMapping("/msg/update_add.htm")
	public String addMsgOutbox(MsgOutboxForm form, ModelMap map) {

		// 表单数据校验
		// 数据库增加一条站内信记录
		msgOutboxService.editMsgOutbox(setBeans(form));
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
	@RequestMapping("/msg/msgInbox_list.htm")
	public String selectMsgInboxListByPage(MsgInboxForm form, ModelMap map) {
		MsgInboxPage msgInboxPage = new MsgInboxPage(); // 分页对象
		setSearchKey(form, msgInboxPage); // 设置页面中的查询条件
		// 取得收件箱列表,分页显示
		MsgInboxPage page = msgInboxService.getMsgInboxListByPage(msgInboxPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msgInbox_list");
		// 跳转至收件箱列表页面
		return "msg/msgInbox_list";
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
	@RequestMapping("/msg/dustbin_list.htm")
	public String selectDustbinListByPage(MsgInboxForm form, ModelMap map) {
		MsgInboxPage msgInboxPage = new MsgInboxPage(); // 分页对象
		setSearchKey(form, msgInboxPage); // 设置页面中的查询条件
		// 取得垃圾箱列表,分页显示
		MsgInboxPage page = msgInboxService.getDustbinListByPage(msgInboxPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msg_dustbin_list");
		// 跳转至垃圾箱列表页面
		return "msg/dustbin_list";
	}

	/**
	 * 跳转至转发收件箱页面
	 * 
	 * @return 新增收件箱页面
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/msgInbox/edit_msgInbox.htm", method = RequestMethod.GET)
	public String editMsgInbox(long id, ModelMap map) {
		MsgInbox msgInbox = msgInboxService.selectMsgInboxById(id);
		msgInboxService.updateMsgInboxInfo(msgInbox);
		map.put("msgInbox", msgInbox);// 保存页面渲染数据
		String loginId = SecurityUtils.getLoginId();
		map.put("loginId", loginId);
		// 跳转至收件箱更新列表页面
		return "msg/edit_msgInbox";
	}

	/**
	 * 跳转至收件箱详细页面
	 * 
	 * @return 收件箱详细页面
	 * 
	 * @Author cql
	 * @Date 2012-02-21
	 */
	@RequestMapping(value = "/msg/detail_msgInbox.htm", method = RequestMethod.GET)
	public String detailMsgInbox(long id, ModelMap map) {
		MsgInbox msgInbox = msgInboxService.selectMsgInboxById(id);
		String isRead = msgInbox.getIsRead();
		// 根据读取状态 判断是否已读
		if ("N".equals(isRead)) {
			msgInboxService.updateMsgInboxInfo(msgInbox);
			// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
			Remind remind = new Remind();
			remind.setBusId(id);
			remind.setModeName(CommonChar.MODE_MSG);
			remind.setLoginId(SecurityUtils.getLoginId());
			remind.setStatus(CommonChar.REMIND_STATUS_BTX);
			commonService.updateRemindInfoByLoginId(remind);
		}

		map.put("msgInbox", msgInbox);// 保存页面渲染数据
		// 跳转至收件箱更新列表页面
		return "msg/detail_msgInbox";
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
	@RequestMapping("/msgInbox/delete.htm")
	public String delectMsgInbox(long id) {
		msgInboxService.deleteMsgInboxInfoById(id);
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
	@RequestMapping("/msgInbox/read.htm")
	public String readMsgInbox(long id) {
		msgInboxService.readMsgInboxInfoById(id);
		
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
	@RequestMapping("/msg/read_msgInboxArray.htm")
	public String readMsgInbox(String idArray) {
		// 删除收件箱信息
		msgInboxService.readMsgInboxs(toLongArray(idArray));
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
	@RequestMapping("/msg/delete_msgInboxArray.htm")
	public String removeMsgInbox(String idArray) {
		// 删除收件箱信息
		msgInboxService.deleteMsgInboxs(toLongArray(idArray));
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
	@RequestMapping("/dustbin/edit_msgDustbin.htm")
	public String selectDustbinboxById(MsgInboxForm form, ModelMap map) {
		long id = form.getId();
		String msgType = form.getMsgType();
		if ("Y".equals(msgType)) {

			map.put("msgOutbox", msgOutboxService.selectMsgOutboxById(id));
			return "msg/detail_msgOutbox";
		} else {
			MsgInbox msgInbox = msgInboxService.selectMsgInboxById(id);
			map.put("msgInbox", msgInbox);
			return "msg/detail_msgInbox";
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
	@RequestMapping("/msg/edit_msgDustbin.htm")
	public String editMsgInbox(MsgInboxForm form, ModelMap map) {
		msgInboxService.updateMsgInboxInfo(toBean(form));
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
	@RequestMapping(value = "/megUser/user_list.htm")
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
	@RequestMapping("/msg/regain.htm")
	public String regainMsgInbox(MsgInboxForm form, ModelMap map) {
		long id = form.getId();
		String msgType = form.getMsgType();
		if ("Y".equals(msgType)) {
			map.put("msgInbox", msgOutboxService.editMsgOutboxById(id));
			// 设置操作日志
			return "common/action_succ";
		} else {
			map.put("msgInbox", msgInboxService.editMsgInboxById(id));
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
	@RequestMapping("/msg/load_new_msg.htm")
	@ResponseBody
	public Integer loadNewsetMsg() {
		String userId = SecurityUtils.getLoginId(); // 登录用户ID
		// 取得未读的站内信
		List<MsgInbox> msgList = msgOutboxService
				.getUnreadMessageByUserId(userId);
		// 返回未读站内信数量
		return msgList.size();
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
	private MsgInbox toBean(MsgInboxForm form) {
		MsgInbox msgInbox = new MsgInbox();
		BeanUtils.copyProperties(form, msgInbox); // 复制表单至DO
		return msgInbox;
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
	private MsgOutbox setBeans(MsgOutboxForm form) {
		MsgOutbox msgOutbox = new MsgOutbox();
		BeanUtils.copyProperties(form, msgOutbox); // 设置表单属性
		msgOutbox.setSenderId(SecurityUtils.getLoginId()); // 设置登录Id
		return msgOutbox;
	}

	/**
	 * 收件箱列表页面设置查询条件
	 * 
	 * @param form
	 * @param MsgInboxPage
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	private void setSearchKey(MsgInboxForm form, MsgInboxPage msgInboxPage) {
		msgInboxPage.setCurrentPage(form.getCp()); // 当前页数
		msgInboxPage.setReceiverId(SecurityUtils.getLoginId());// 获取登录帐号
		msgInboxPage.setSenderId(form.getSenderId());// 获取发件人帐号
		msgInboxPage.setSenderName(form.getUserNamePy());
		msgInboxPage.setTitle(form.getTitle());// 获取标题
		msgInboxPage.setCreateDate(form.getCreateDate());// 获取发送时间
		msgInboxPage.setIsRead(form.getIsRead());// 获取状态
	}
	
	
	/**
	 * 跳转至转发收件箱页面
	 * 
	 * @return 新增收件箱页面
	 * 
	 * @Author sbq
	 * @Date 2011-12-23
	 */
	@RequestMapping(value = "/msg/replay_msgInboxInfo.htm", method = RequestMethod.POST)
	public String replayMsgInboxInfo(MsgInboxForm form, ModelMap map) {
		MsgInbox msgInbox = msgInboxService.selectMsgInboxById(form.getId());
		map.put("msgInbox", msgInbox);// 保存页面渲染数据
		
		// 跳转至收件箱更新列表页面
		return "msg/replay_msgInbox";
	}
	
}
