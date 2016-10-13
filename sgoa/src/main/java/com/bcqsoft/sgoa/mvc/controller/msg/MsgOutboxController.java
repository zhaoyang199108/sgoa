package com.bcqsoft.sgoa.mvc.controller.msg;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutbox;
import com.bcqsoft.sgoa.dao.msgoutbox.dataobject.MsgOutboxPage;
import com.bcqsoft.sgoa.mvc.form.msg.MsgOutboxForm;
import com.bcqsoft.sgoa.service.msg.MsgOutboxService;
import com.bcqsoft.sgoa.service.user.UserService;

@Controller
public class MsgOutboxController {
	/**
	 * 站内信模块业务逻辑类接口
	 */
	@Autowired
	private MsgOutboxService siteMsgService;
	/**
	 * 用户模块业务逻辑类接口
	 */
	@Autowired
	private UserService userService;

	/**
	 * 跳转至写信页面
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@RequestMapping(value = "/msg/write_list.htm", method = RequestMethod.GET)
	public String addMsgOutbox(ModelMap map) {

		// 取得查询区域下拉框数据
		map.put("userList", userService.getUserList()); // 用户列表
		String loginId = SecurityUtils.getLoginId();
		map.put("loginId", loginId);
		// 跳转至写信页面
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msg_write_list");
		return "msg/write_list";
	}

	/**
	 * 增加站内信功能
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@RequestMapping("/msg/write_add.htm")
	public String addMsgOutbox(MsgOutboxForm form, ModelMap map) {
		// 表单数据校验
		// 数据库增加一条站内信记录
		siteMsgService.addMsgOutbox(setBeans(form), form.getSrcUploadFile());
		// 返回到操作成功页面
		return "msg/write_success";
	}

	/**
	 * 增加站内信功能
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@RequestMapping("/msg/draft_add.htm")
	public String addDraftMsgOutbox(MsgOutboxForm form, ModelMap map) {

		// 表单数据校验
		// 数据库增加一条站内信记录
		siteMsgService.addMsgOutbox(setBeans(form), form.getSrcUploadFile());
		// 返回到操作成功页面
		return "msg/draft_success";
	}

	/**
	 * 取得有效的发件箱列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@RequestMapping("/msg/msgOutbox_list.htm")
	public String selectMsgOutboxListByPage(MsgOutboxForm form, ModelMap map) {
		MsgOutboxPage msgOutboxPage = new MsgOutboxPage(); // 分页对象
		setSearchKey(form, msgOutboxPage); // 设置页面中的查询条件
		// 取得发件箱列表,分页显示
		MsgOutboxPage page = siteMsgService
				.getMsgOutboxListByPage(msgOutboxPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msgOutbox_list");
		// 跳转至发件箱列表页面
		return "msg/msgOutbox_list";
	}

	/**
	 * 取得有效的草稿箱列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-01-11
	 */
	@RequestMapping("/msg/draft_list.htm")
	public String selectMsgOutboxDraftListByPage(MsgOutboxForm form,
			ModelMap map) {
		MsgOutboxPage msgOutboxPage = new MsgOutboxPage(); // 分页对象
		setSearchKey(form, msgOutboxPage); // 设置页面中的查询条件
		// 取得草稿箱列表,分页显示
		MsgOutboxPage page = siteMsgService
				.getMsgOutboxDraftListByPage(msgOutboxPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msg_draft_list");
		// 跳转至草稿箱列表页面
		return "msg/draft_list";
	}

	/**
	 * 发件箱删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新发件箱成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-11
	 */
	@RequestMapping("/msg/delete.htm")
	public String delectMsgOutbox(long id) {
		siteMsgService.deleteMsgOutboxInfoById(id);
		// 设置操作日志
		return "common/action_succ";

	}

	/**
	 * 删除发件箱(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-01-11
	 */
	@RequestMapping("/msg/delete_msgOutboxArray.htm")
	public String removeMsgOutbox(String idArray) {
		// 删除发件箱信息
		siteMsgService.deleteMsgOutboxs(toLongArray(idArray));
		// 返回到操作成功页面
		// 设置操作日志
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
	@RequestMapping(value = "/msg/edit_msgOutbox.htm", method = RequestMethod.GET)
	public String editMsgOutbox(long id, ModelMap map) {
		map.put("msgOutbox", siteMsgService.selectMsgOutboxById(id));
		String loginId = SecurityUtils.getLoginId();
		map.put("loginId", loginId);
		return "msg/edit_msgOutbox";
	}

	/**
	 * 跳转至发件箱详细页面
	 * 
	 * @return 发件箱详细页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/msg/detail_msgOutbox.htm", method = RequestMethod.GET)
	public String detailMsgOutbox(long id, ModelMap map) {
		map.put("msgOutbox", siteMsgService.selectMsgOutboxById(id));
		return "msg/detail_msgOutbox";
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
	@RequestMapping("/msg/edit_msgOutbox.htm")
	public String editMsgOutbox(MsgOutboxForm form, ModelMap map) {
		// 根据类型判断 是执行修改操作或者是添加操作
		if (form.getMsgStatus().equals('Y')) {
			siteMsgService
					.editMsgOutbox(setBeans(form));

		}
		siteMsgService.updateMsgOutboxInfo(setBeans(form));
		return "msg/cz_success";
	}

	/**
	 * 下载点击事件
	 * 
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com ly
	 * @Date 2011-12-22
	 */
	@RequestMapping("/msg/download_file.htm")
	public void downloadFile(MsgOutboxForm form, HttpServletResponse response) {
		// 文件下载工具类
		FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK", "upload", 21);
		ftpUtil.connectServer("upload");
		ftpUtil.downloadFile(form.getSrcFileName(), response);
	}

	/**
	 * 发件箱列表页面设置查询条件
	 * 
	 * @param form
	 * @param MsgOutboxPage
	 * 
	 * @Author cql
	 * @Date 2012-01-11
	 */
	private void setSearchKey(MsgOutboxForm form, MsgOutboxPage msgOutboxPage) {
		msgOutboxPage.setCurrentPage(form.getCp()); // 当前页数
		msgOutboxPage.setReceiverIds(SecurityUtils.getLoginId());// 获取登录帐号
		msgOutboxPage.setReceiverIds(form.getReceiverIds());// 获取收件人帐号
		msgOutboxPage.setTitle(form.getTitle());// 获取标题
		msgOutboxPage.setCreateDate(form.getCreateDate());// 获取发送时间
		msgOutboxPage.setSenderId(SecurityUtils.getLoginId()); // 设置登录Id

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
}