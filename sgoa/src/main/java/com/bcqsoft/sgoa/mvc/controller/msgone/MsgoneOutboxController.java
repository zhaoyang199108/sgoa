package com.bcqsoft.sgoa.mvc.controller.msgone;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutbox;
import com.bcqsoft.sgoa.dao.msgoneoutbox.dataobject.MsgoneOutboxPage;
import com.bcqsoft.sgoa.mvc.form.msgone.MsgoneOutboxForm;
import com.bcqsoft.sgoa.service.msgone.MsgoneOutboxService;
import com.bcqsoft.sgoa.service.user.UserService;

@Controller
public class MsgoneOutboxController {
	/**
	 * 站内信模块业务逻辑类接口
	 */
	@Autowired
	private MsgoneOutboxService siteMsgoneService;
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
	@RequestMapping(value = "/msgone/write_list.htm", method = RequestMethod.GET)
	public String addMsgoneOutbox(ModelMap map) {

		// 取得查询区域下拉框数据
		map.put("userList", userService.getUserList()); // 用户列表
		String loginId = SecurityUtils.getLoginId();
		map.put("loginId", loginId);
		// 跳转至写信页面
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msgone_write_list");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("d_userName", SecurityUtils.getLoginId());
		map.put("d_fileType", "doc");
		return "msgone/write_list";
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
	@RequestMapping("/msgone/write_add.htm")
	public String addMsgoneOutbox(MsgoneOutboxForm form, ModelMap map) {
		// 表单数据校验
		// 数据库增加一条站内信记录
		siteMsgoneService.addMsgoneOutbox(setBeans(form), form.getSrcUploadFile());
		// 返回到操作成功页面
		return "msgone/write_success";
	}
	
	/**
	 * 回复站内信功能
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@RequestMapping("/msgone/write_review.htm")
	public String reviewMsgoneOutbox(MsgoneOutboxForm form, ModelMap map) {
		// 表单数据校验
		// 数据库增加一条站内信记录
		MsgoneOutbox msgoneOutbox = new MsgoneOutbox();
		msgoneOutbox.setTextId(form.getTextId());
		msgoneOutbox.setMsgStatus(form.getMsgStatus());
		msgoneOutbox.setReceiverIds(form.getReceiverIds());
		msgoneOutbox.setdRecordid(form.getdRecordid());
		msgoneOutbox.setSrcUploadFile(form.getSrcUploadFile());
		msgoneOutbox.setTitle(form.getTitle());
		msgoneOutbox.setSenderId(SecurityUtils.getLoginId()); // 设置登录Id
		siteMsgoneService.addEditMsgoneOutbox(msgoneOutbox, form.getSrcUploadFile());
		// 返回到操作成功页面
		return "msgone/write_success";
	}
	
	/**
	 * 回复站内信功能
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-10
	 */
	@RequestMapping("/msgone/draft_review.htm")
	public String reviewDrftMsgoneOutbox(MsgoneOutboxForm form, ModelMap map) {
		// 表单数据校验
		// 数据库增加一条站内信记录
		MsgoneOutbox msgoneOutbox = new MsgoneOutbox();
		msgoneOutbox.setTextId(form.getTextId());
		msgoneOutbox.setMsgStatus(form.getMsgStatus());
		msgoneOutbox.setReceiverIds(form.getReceiverIds());
		msgoneOutbox.setdRecordid(form.getdRecordid());
		msgoneOutbox.setSrcFileName(form.getSrcFileName());
		msgoneOutbox.setTitle(form.getTitle());
		msgoneOutbox.setSenderId(SecurityUtils.getLoginId()); // 设置登录Id
		siteMsgoneService.addEditMsgoneOutbox(msgoneOutbox, form.getSrcUploadFile());
		// 返回到操作成功页面
		return "msgone/write_success";
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
	@RequestMapping("/msgone/draft_add.htm")
	public String addDraftMsgoneOutbox(MsgoneOutboxForm form, ModelMap map) {

		// 表单数据校验
		// 数据库增加一条站内信记录
		siteMsgoneService.addMsgoneOutbox(setBeans(form), form.getSrcUploadFile());
		// 返回到操作成功页面
		return "msgone/draft_success";
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
	@RequestMapping("/msgone/msgoneOutbox_list.htm")
	public String selectMsgoneOutboxListByPage(MsgoneOutboxForm form, ModelMap map) {
		MsgoneOutboxPage msgoneOutboxPage = new MsgoneOutboxPage(); // 分页对象
		setSearchKey(form, msgoneOutboxPage); // 设置页面中的查询条件
		// 取得发件箱列表,分页显示
		MsgoneOutboxPage page = siteMsgoneService
				.getMsgoneOutboxListByPage(msgoneOutboxPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msgoneOutbox_list");
		// 跳转至发件箱列表页面
		return "msgone/msgoneOutbox_list";
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
	@RequestMapping("/msgone/draft_list.htm")
	public String selectMsgoneOutboxDraftListByPage(MsgoneOutboxForm form,
			ModelMap map) {
		MsgoneOutboxPage msgoneOutboxPage = new MsgoneOutboxPage(); // 分页对象
		setSearchKey(form, msgoneOutboxPage); // 设置页面中的查询条件
		// 取得草稿箱列表,分页显示
		MsgoneOutboxPage page = siteMsgoneService
				.getMsgoneOutboxDraftListByPage(msgoneOutboxPage);
		map.put("page", page); // 保存页面渲染数据
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "msgone_draft_list");
		// 跳转至草稿箱列表页面
		return "msgone/draft_list";
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
	@RequestMapping("/msgone/delete.htm")
	public String delectMsgoneOutbox(long id) {
		siteMsgoneService.deleteMsgoneOutboxInfoById(id);
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
	@RequestMapping("/msgone/delete_msgoneOutboxArray.htm")
	public String removeMsgoneOutbox(String idArray) {
		// 删除发件箱信息
		siteMsgoneService.deleteMsgoneOutboxs(toLongArray(idArray));
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
	@RequestMapping(value = "/msgone/edit_msgoneOutbox.htm", method = RequestMethod.GET)
	public String editMsgoneOutbox(long id, ModelMap map) {
		map.put("msgoneOutbox", siteMsgoneService.selectMsgoneOutboxById(id));
		String loginId = SecurityUtils.getLoginId();
		map.put("loginId", loginId);
		return "msgone/edit_msgoneOutbox";
	}

	/**
	 * 跳转至发件箱详细页面
	 * 
	 * @return 发件箱详细页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@RequestMapping(value = "/msgone/detail_msgoneOutbox.htm", method = RequestMethod.GET)
	public String detailMsgoneOutbox(long id, ModelMap map) {
		map.put("msgoneOutbox", siteMsgoneService.selectMsgoneOutboxById(id));
		return "msgone/detail_msgoneOutbox";
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
	@RequestMapping("/msgone/edit_msgoneOutbox.htm")
	public String editMsgoneOutbox(MsgoneOutboxForm form, ModelMap map) {
		// 根据类型判断 是执行修改操作或者是添加操作
		if (form.getMsgStatus().equals('Y')) {
			siteMsgoneService
					.editMsgoneOutbox(setBeans(form));

		}
		siteMsgoneService.updateMsgoneOutboxInfo(setBeans(form));
		return "msgone/cz_success";
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
	@RequestMapping("/msgone/download_file.htm")
	public void downloadFile(MsgoneOutboxForm form, HttpServletResponse response) {
		// 文件下载工具类
		FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK", "upload", 21);
		ftpUtil.connectServer("upload");
		ftpUtil.downloadFile(form.getSrcFileName(), response);
	}

	/**
	 * 发件箱列表页面设置查询条件
	 * 
	 * @param form
	 * @param MsgoneOutboxPage
	 * 
	 * @Author cql
	 * @Date 2012-01-11
	 */
	private void setSearchKey(MsgoneOutboxForm form, MsgoneOutboxPage msgoneOutboxPage) {
		msgoneOutboxPage.setCurrentPage(form.getCp()); // 当前页数
		msgoneOutboxPage.setReceiverIds(SecurityUtils.getLoginId());// 获取登录帐号
		msgoneOutboxPage.setReceiverIds(form.getReceiverIds());// 获取收件人帐号
		msgoneOutboxPage.setTitle(form.getTitle());// 获取标题
		msgoneOutboxPage.setCreateDate(form.getCreateDate());// 获取发送时间
		msgoneOutboxPage.setSenderId(SecurityUtils.getLoginId()); // 设置登录Id

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
}