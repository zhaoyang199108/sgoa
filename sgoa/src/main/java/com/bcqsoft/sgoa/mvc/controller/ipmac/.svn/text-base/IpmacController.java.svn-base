package com.bcqsoft.sgoa.mvc.controller.ipmac;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.dao.ipmac.dataobject.Ipmac;
import com.bcqsoft.sgoa.dao.ipmac.dataobject.IpmacPage;
import com.bcqsoft.sgoa.mvc.form.ipmac.IpmacForm;
import com.bcqsoft.sgoa.service.ipmac.IpmacService;

@Controller
public class IpmacController {

	/**
	 * IP/MAC模块业务逻辑类接口
	 */
	@Autowired
	private IpmacService ipmacService;

	/**
	 * 取得有效的IP/MAC列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("/ipmac/list.htm")
	public String ipmacList(IpmacForm form, ModelMap map) {
		IpmacPage ipmacPage = new IpmacPage(); // 分页对象
		setSearchKey(form, ipmacPage); // 设置页面中的查询条件
		// 取得IP/MAC列表,分页显示
		IpmacPage page =new IpmacPage();
		page=ipmacService.getIpmacListByPage(ipmacPage);
		map.put("page", page); // 保存页面渲染数据
		
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "ipmac_list");
		// 跳转至IP/MAC列表页面
		return "ipmac/ipmac_list";
	}

	/**
	 * 跳转至添加IP/MAC页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/ipmac/add.htm", method = RequestMethod.GET)
	public String addIpmac() {
		return "ipmac/add_ipmac";
	}

	/**
	 * 添加IP/MAC页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/ipmac/add.htm", method = RequestMethod.POST)
	public String addIpmac(IpmacForm form) {
		ipmacService.createIpmacInfo(toBean(form));
		return "common/action_succ";
	}

	/**
	 * 更新添加IP/MAC获取页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/ipmac/edit.htm", method = RequestMethod.GET)
	public String editIpmac(Long id, ModelMap map) {
		map.put("ipmac", ipmacService.getIpmacDetailInfo(id));
		return "ipmac/edit_ipmac";
	}

	/**
	 * 详细IP/MAC获取页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/ipmac/detail.htm", method = RequestMethod.GET)
	public String detailIpmac(Long id, ModelMap map) {
		map.put("ipmac", ipmacService.getIpmacDetailInfo(id));
		return "ipmac/detail_ipmac";
	}
	
	/**
	 * 更新IP/MAC页面
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/ipmac/edit.htm", method = RequestMethod.POST)
	public String editIpmac(IpmacForm form) {
		ipmacService.updateIpmacInfo(toBean(form));
		return "common/action_succ";
	}

	/**
	 * 删除IP/MAC
	 * 
	 * @param id
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("/ipmac/delete.htm")
	public String removeIpmac(Long id) {
		ipmacService.deleteIpmacInfo(id);
		return "common/action_succ";
	}

	/**
	 * 删除IP/MAC(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("ipmac/delete_batch.htm")
	public String removeIpmacs(String idArray) {
		ipmacService.deleteIpmacInfos(toLongArray(idArray));
		return "common/action_succ";
	}

	/**
	 * DO设置
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	private Ipmac toBean(IpmacForm form) {
		Ipmac ipmac = new Ipmac();
		BeanUtils.copyProperties(form, ipmac);
		ipmac.setOptIp(form.getOptIp());// IP/MAC名称
		ipmac.setOptMac(form.getOptMac()); //
		ipmac.setEnabled("Y");
		return ipmac;
	}

	/**
	 * IP/MAC列表页面设置查询条件
	 * 
	 * @param form
	 * @param storagePage
	 * 
	 * @Author cql
	 * @Date 2013-5-14
	 */
	private void setSearchKey(IpmacForm form, IpmacPage ipmacPage) {
		ipmacPage.setCurrentPage(form.getCp()); // 当前页数
		ipmacPage.setOptIp(form.getOptIp());// IP/MAC名称
		ipmacPage.setOptMac(form.getOptMac()); //
	}
}
