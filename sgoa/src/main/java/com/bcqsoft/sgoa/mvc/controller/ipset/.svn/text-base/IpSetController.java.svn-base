package com.bcqsoft.sgoa.mvc.controller.ipset;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.dao.ipset.dataobject.IpSet;
import com.bcqsoft.sgoa.mvc.form.ipset.IpSetForm;
import com.bcqsoft.sgoa.service.ipset.IpSetService;

@Controller
public class IpSetController {

	/**
	 * IP设置模块业务逻辑类接口
	 */
	@Autowired
	private IpSetService ipSetService;

	/**
	 * 更新添加IP设置获取页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping("/ipset/edit.htm")
	public String editIpmac(ModelMap map) {
		map.put("ipSet", ipSetService.getIpSetListById());
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "edit");
		return "ipset/edit_ipset";
	}

	/**
	 * 更新IP设置页面
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@RequestMapping(value = "/ipset/ipset_edit.htm", method = RequestMethod.POST)
	public String editIpmac(IpSetForm form) {
		ipSetService.updateIpSetInfo(toBean(form));
		return "ipset/edit_success";
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
	private IpSet toBean(IpSetForm form) {
		IpSet ipSet = new IpSet();
		BeanUtils.copyProperties(form, ipSet);
		ipSet.setIsOpen(form.getIsOpen());
		return ipSet;
	}
}
