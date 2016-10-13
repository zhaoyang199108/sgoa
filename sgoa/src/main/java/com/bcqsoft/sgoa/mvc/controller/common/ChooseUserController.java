package com.bcqsoft.sgoa.mvc.controller.common;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.service.common.CommonService;

/**
 * 通用选择用户控制器
 */
@Controller
public class ChooseUserController {

	/**
	 * 共通业务模块业务逻辑接口
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * 跳转至发文拟稿页面
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/choose_all_user.htm", method = RequestMethod.GET)
	public String chooseAllUser(String ids, ModelMap map) {
		// 查找部门列表
		map.put("deptList", commonService.getAllDeptInfo());
		// 如果存在登录ID, 查询用户信息
		if (isNotBlank(ids)) {
			map.put("selUserList", commonService.getUsersInfoByLoginId(ids));
		}
		// 跳转选择用户页面
		return "/common/choose_all_user";
	}
	
	/**
	 * 跳转至发文拟稿页面
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/choose_all_user_nc.htm", method = RequestMethod.GET)
	public String chooseAllUserNc(String ids, ModelMap map) {
		// 查找部门列表
		map.put("deptList", commonService.getAllDeptInfo());
		// 如果存在登录ID, 查询用户信息
		if (isNotBlank(ids)) {
			map.put("selUserList", commonService.getUsersInfoByLoginId(ids));
		}
		// 跳转选择用户页面
		return "/common/choose_all_user_nc";
	}

	/**
	 * 跳转至发文拟稿页面
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/choose_one_user.htm", method = RequestMethod.GET)
	public String chooseOneUser(String ids, ModelMap map) {
		// 查找部门列表
		map.put("deptList", commonService.getAllDeptInfo());
		// 如果存在登录ID, 查询用户信息
		if (isNotBlank(ids)) {
			map.put("selUserList", commonService.getUsersInfoByLoginId(ids));
		}
		// 跳转选择用户页面
		return "/common/choose_one_user";
	}
	
	/**
	 * 跳转至选择下一步审批人页面
	 * 
	 * @param map
	 * @return 选择用户页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/choose_user.htm", method = RequestMethod.GET)
	public String chooseUser(Long level, ModelMap map) {

		// 查找符合条件的部门列表
		map.put("deptList",
				commonService.findDeptInfoForLevel(String.valueOf(level)));
		// 跳转选择用户页面
		return "/common/choose_all_user";
	}

	/**
	 * 查找部门人员
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/get_dept_user.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getDeptUser(Long deptId) {
		// 根据部门列表查找部门下所有人员
		List<User> userList = commonService.findUserInfoByDeptId(deptId);
		return userList;
	}

	/**
	 * 查找部门人员
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/choose_dept_user.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<User> chooseDeptUser(Long deptId) {
		// 根据部门列表查找部门下所有人员
		List<User> userList = commonService.findUserInfoByDeptId(deptId);
		return userList;
	}
	
	/**
	 * 取得所有部门信息
	 * 
	 * @param map
	 * @return 部门信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/find_dept.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findDept(ModelMap map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 查找部门列表
		dataMap.put("deptList", commonService.getAllDeptInfo());
		return dataMap;
	}
	
	/**
	 * 跳转至部门选择页面
	 * 
	 * @param map
	 * @return 部门选择页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/choose_dept.htm", method = RequestMethod.GET)
	public String chooseAllDept(ModelMap map) {
		// 跳转选择用户页面
		return "/common/choose_dept";
	}
	
	/**
	 * 跳转至职务单选择页面
	 * 
	 * @param map
	 * @return 职务选择页面模板
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	@RequestMapping(value = "/common/choose_grpo.htm", method = RequestMethod.GET)
	public String chooseAllGrpo(String id, ModelMap map) {
		Grpo grpo = new Grpo();
		grpo.setCategory(2);
		map.put("grpoList", commonService.getGrpoListByAll(grpo)); //取得 职务列表
		if(id != null) {
			map.put("grpoIdMap", id);
		}
		// 跳转选择用户页面
		return "/common/choose_grpo";
	}
	
	/**
	 * 跳转至职务多选择页面
	 * 
	 * @param map
	 * @return 职务选择页面模板
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-12-19
	 */
	@RequestMapping(value = "/common/choose_grpos.htm", method = RequestMethod.GET)
	public String chooseAllGrpos(String ids, ModelMap map) {
		Grpo grpo = new Grpo();
		grpo.setCategory(2);
		map.put("grpoList", commonService.getGrpoListByAll(grpo)); //取得 职务列表
		if(ids != null) {
			// 取得所有职务ID
			map.put("grpoIdMap", ids);
		}
		// 跳转选择用户页面
		return "/common/choose_grpos";
	}
	
	/**
	 * 跳转至发文拟稿页面
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/choose_scheduler_user.htm", method = RequestMethod.GET)
	public String chooseSchedulerUser(String id, ModelMap map) {
		// 如果存在登录ID, 查询用户信息
		map.put("selUserList", commonService.findSchedulerUser());
		map.put("selLoginId", id);
		// 跳转选择用户页面
		return "/common/choose_scheduler_user";
	}
	
	/**
	 * 跳转至发文拟稿页面
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/common/choose_leader_user.htm", method = RequestMethod.GET)
	public String chooseLeaderSchedulerUser(String id, ModelMap map) {
		// 如果存在登录ID, 查询用户信息
		map.put("selUserList", commonService.findLeaderSchedulerUser());
		map.put("selLoginId", id);
		// 跳转选择用户页面
		return "/common/choose_leader_user";
	}
}
