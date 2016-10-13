package com.bcqsoft.sgoa.mvc.controller.alert;

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
import com.bcqsoft.sgoa.dao.alert.dataobject.Alert;
import com.bcqsoft.sgoa.dao.alert.dataobject.AlertPage;
import com.bcqsoft.sgoa.mvc.form.alert.AlertForm;
import com.bcqsoft.sgoa.service.alert.AlertService;

/**
 * 物资设备申领表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class AlertController {
	/**
	 * 物资设备申领表的业务逻辑层
	 */
	@Autowired
	private AlertService alertService;

	/**
	 * 审批流程查询页面
	 * 
	 * @return 审批流程查询页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/alert/alert_list.htm")
	public String selectAlertListByPage(AlertForm form, ModelMap map) {
		AlertPage alertPage = new AlertPage();
		// 设置查询条件
		setSearchKey(form, alertPage);
		AlertPage page = alertService.getAlertList(alertPage);
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "alert_list");
		return "alert/alert_list";
	}

	/**
	 * 跳转至新增流程审批页面
	 * 
	 * @return 新增流程审批页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/alert/add_alert.htm", method = RequestMethod.GET)
	public String addAlert(ModelMap map,String title,String modeName,String busId) {
		map.put("busId", busId);
		try {
			map.put("title", URLDecoder.decode(title, "UTF-8"));
			map.put("modeName", URLDecoder.decode(modeName, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
		return "alert/add_alert";
	}

	/**
	 * 流程审批申领表新增处理
	 * 
	 * @param map
	 * @return 流程审批申领表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/alert/add_alert.htm")
	public String addAlert(AlertForm form, ModelMap map) {
		alertService.createAlert(setBeans(form));
		return "common/action_succ";
	}

	/**
	 * 审批流程表页面设置查询条件
	 * 
	 * @param form
	 * @param AlertPage
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	private AlertPage setSearchKey(AlertForm form,
			AlertPage alertPage) {
		// 设置查询条件
		alertPage.setCurrentPage(form.getCp()); // 当前页数
		alertPage.setTitle(form.getTitle());// 审批流程名称
		alertPage.setStatus(form.getStatus());// 审批流程分类
		alertPage.setAlertTime(form.getAlertTime());// 审批流程分类
		return alertPage;

	}

	/**
	 * 流程审批表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新流程审批申领表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/alert/delete_alert.htm")
	public String delectAlert(long id) {
		alertService.deleteAlert(id);
		return "common/action_succ";

	}

	/**
	 * 删除流程审批表(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/alert/delete_alertArray.htm")
	public String removeAlert(String idArray) {
		alertService.deleteAlerts(toLongArray(idArray));
		return "common/action_succ";
	}

	/**
	 * 跳转至流程审批详细页面
	 * 
	 * @return 流程审批页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/alert/alert_detail.htm", method = RequestMethod.GET)
	public String alertDetail(long id, ModelMap map) {
		// 取得流程审批详细页面
		Alert alert = alertService.getAlertInfo(id);
		map.put("alert", alert);
		return "alert/alert_detail";
	}

	/**
	 * 跳转至流程审批更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/alert/alert_edit.htm")
	public String alertEdit(AlertForm form, ModelMap map) {
		// 修改审批流程
		alertService.editAlertInfo(setBeanEdit(form));
		return "common/action_succ";
	}

	/**
	 * 流程审批更新
	 * 
	 * @return 流程审批页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/alert/alert_edit.htm", method = RequestMethod.GET)
	public String alertEdit(long id, ModelMap map) {
		// 取得流程审批详细页面
		Alert alert = alertService.getAlertInfo(id);
		map.put("alert", alert);
		return "alert/alert_edit";
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Alert
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private Alert setBeans(AlertForm form) {
		Alert alert = new Alert();
		BeanUtils.copyProperties(form, alert); // 复制表单至DO
		alert.setLoginId(SecurityUtils.getLoginId());
		alert.setStatus(CommonChar.STATUS_WD);
		return alert;
	}
	
	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Alert
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private Alert setBeanEdit(AlertForm form) {
		Alert alert = new Alert();
		BeanUtils.copyProperties(form, alert); // 复制表单至DO
		return alert;
	}
}
