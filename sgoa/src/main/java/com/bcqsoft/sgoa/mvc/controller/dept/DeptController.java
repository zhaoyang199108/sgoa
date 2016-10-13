package com.bcqsoft.sgoa.mvc.controller.dept;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.mvc.form.dept.DeptForm;
import com.bcqsoft.sgoa.service.dept.DeptService;

@Controller
public class DeptController {

	@Autowired
	private DeptService deptService;

	/**
	 * 跳转至添加部门页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping("/dept/menu.htm")
	public String menuDept(ModelMap map) {
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "menu");
		return "dept/menu_dept";
	}

	/**
	 * 取得有效的部门列表
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/dept/dept_list.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deptmenuList(ModelMap map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Dept> deptList = deptService.getDeptListByAll();
		dataMap.put("deptList", deptList);
		return dataMap;

	}

	/**
	 * 添加部门页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * @throws UnsupportedEncodingException
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/dept/add_dept.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> addDept(String deptName, String pId)
			throws UnsupportedEncodingException {
		Dept dept = new Dept();
		dept.setDeptName(URLDecoder.decode(deptName, "UTF-8"));
		dept.setUnitId(new Long(pId));
		dept.setEnabled("Y");
		deptService.createDeptInfo(dept);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Dept> deptList = deptService.getDeptListByAll();
		dataMap.put("deptList", deptList);
		return dataMap;
	}

	/**
	 * 更新部门页面
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * @throws UnsupportedEncodingException
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/dept/dept_uptate.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> editDept(String id, String deptName, String pId)
			throws UnsupportedEncodingException {
		DeptForm form = new DeptForm();
		form.setId(new Long(id));
		form.setDeptName(URLDecoder.decode(deptName, "UTF-8"));
		deptService.updateDeptInfo(toBean(form));
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Dept> deptList = deptService.getDeptListByAll();
		dataMap.put("deptList", deptList);
		return dataMap;
	}

	/**
	 * 删除部门
	 * 
	 * @param id
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	@RequestMapping(value = "/dept/delete.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> removeDept(String id) {
		deptService.deleteDeptInfo(new Long(id));
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Dept> deptList = deptService.getDeptListByAll();
		dataMap.put("deptList", deptList);
		return dataMap;
	}
	/**
	 * DO设置
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	private Dept toBean(DeptForm form) {
		Dept dept = new Dept();
		BeanUtils.copyProperties(form, dept);
		dept.setDeptName(form.getDeptName());
		dept.setUnitId(form.getUnitId());
		dept.setEnabled("Y");
		return dept;
	}

}
