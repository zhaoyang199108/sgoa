package com.bcqsoft.sgoa.mvc.controller.remind;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.remind.dataobject.RemindPage;
import com.bcqsoft.sgoa.mvc.form.remind.RemindForm;
import com.bcqsoft.sgoa.service.remind.RemindService;

/**
 * 消息中心表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class RemindController {
	/**
	 * 消息中心表的业务逻辑层
	 */
	@Autowired
	private RemindService remindService;

	/**
	 * 审批流程查询页面
	 * 
	 * @return 审批流程查询页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/remind/remind_list.htm")
	public String selectRemindListByPage(RemindForm form, ModelMap map) {
		RemindPage remindPage = new RemindPage();
		// 设置查询条件
		setSearchKey(form, remindPage);
		RemindPage page = remindService.getRemindList(remindPage);
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "remind_list");
		return "remind/remind_list";

	}

	/**
	 * 审批流程表页面设置查询条件
	 * 
	 * @param form
	 * @param RemindPage
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	private RemindPage setSearchKey(RemindForm form,
			RemindPage remindPage) {
		// 设置查询条件
		remindPage.setCurrentPage(form.getCp()); // 当前页数
		remindPage.setLoginId(SecurityUtils.getLoginId());
		remindPage.setTitle(form.getTitle());// 标题
		remindPage.setStatus(form.getStatus());// 状态
		remindPage.setModeName(form.getModeName());// 模块名称
		return remindPage;

	}

	/**
	 * 消息中心表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新消息中心表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/remind/delete_remind.htm")
	public String delectRemind(long id) {
		remindService.deleteRemind(id);
		return "common/action_succ";

	}

	/**
	 * 删除消息中心表(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/remind/delete_remindArray.htm")
	public String removeRemind(String idArray) {
		remindService.deleteReminds(toLongArray(idArray));
		return "common/action_succ";
	}

	/**
	 * 跳转至消息中心详细页面
	 * 
	 * @return 消息中心页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/remind/remind_detail.htm", method = RequestMethod.GET)
	public String remindDetail(long id, ModelMap map) {
		// 取得消息中心详细页面
		Remind remind = remindService.getRemindInfo(id);
		map.put("remind", remind);
		return "remind/remind_detail";
	}

	/**
	 * 跳转至消息中心更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/remind/remind_edit.htm")
	public String remindEdit(RemindForm form, ModelMap map) {
		// 修改审批流程
		remindService.editRemindInfo(setBeanEdit(form));
		return "common/action_succ";
	}

	/**
	 * 消息中心更新
	 * 
	 * @return 消息中心页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/remind/remind_edit.htm", method = RequestMethod.GET)
	public String remindEdit(long id, ModelMap map) {
		// 取得消息中心详细页面
		Remind remind = remindService.getRemindInfo(id);
		map.put("remind", remind);
		return "remind/remind_edit";
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Remind
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private Remind setBeanEdit(RemindForm form) {
		Remind remind = new Remind();
		BeanUtils.copyProperties(form, remind); // 复制表单至DO
		return remind;
	}
}
