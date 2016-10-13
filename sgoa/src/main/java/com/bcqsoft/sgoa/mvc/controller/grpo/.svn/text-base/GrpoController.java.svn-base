package com.bcqsoft.sgoa.mvc.controller.grpo;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;
import static com.bcqsoft.sgoa.common.util.ArrayUtil.toStringArray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.dao.grpo.dataobject.GrpoPage;
import com.bcqsoft.sgoa.dao.grporole.dataobject.GrpoRole;
import com.bcqsoft.sgoa.dao.role.dataobject.Role;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.dao.userrole.dataobject.UserRole;
import com.bcqsoft.sgoa.mvc.form.grpo.GrpoForm;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.grpo.GrpoService;
import com.bcqsoft.sgoa.service.grporole.GrpoRoleService;

/**
 * 分组权限申领表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class GrpoController {
	
	/**
	 * 共通业务模块业务逻辑接口
	 */
	@Autowired
	private CommonService commonService;
	
	/**
	 * 分组权限表的业务逻辑层
	 */
	@Autowired
	private GrpoService grpoService;
	
	/**
	 * 分组权限表的业务逻辑层
	 */
	@Autowired
	private GrpoRoleService grpoRoleService;

	/**
	 * 取得有效的分组权限申领表列表(提交审核页面)
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/grpo/grpo_list.htm")
	public String selectGrpoListByPage(GrpoForm form, ModelMap map) {
		GrpoPage grpoPage = new GrpoPage(); // 分页对象
		setSearchKey(form, grpoPage); // 设置页面中的查询条件
		GrpoPage page = grpoService.getGrpoInfoList(grpoPage);
		// 跳转至分组权限申领表列表页面
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "grpo_list");
		return "grpo/grpo_list";
	}

	/**
	 * 跳转至新增分组权限页面
	 * 
	 * @return 新增分组权限页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/grpo/add_grpo.htm", method = RequestMethod.GET)
	public String addGrpo() {
		return "grpo/add_grpo";
	}

	/**
	 * 分组权限申领表新增处理
	 * 
	 * @param map
	 * @return 分组权限申领表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/grpo/add_grpo.htm")
	public String addGrpo(GrpoForm form, ModelMap map) {
		grpoService.createGrpoInfo(setBeans(form));
		return "common/action_succ";
	}

	/**
	 * 分组权限表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新分组权限申领表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/grpo/delete_grpo.htm")
	public String delectGrpo(long id) {
		grpoService.deleteGrpoInfo(id);
		return "common/action_succ";

	}

	/**
	 * 删除分组权限表(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/grpo/delete_grpoArray.htm")
	public String removeGrpo(String idArray) {
		grpoService.deleteGrpos(toLongArray(idArray));
		return "common/action_succ";
	}


	/**
	 * 跳转至分组权限详细页面
	 * 
	 * @return 分组权限页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/grpo/grpo_detail.htm", method = RequestMethod.GET)
	public String grpoDetail(long id, ModelMap map) {
		// 取得分组权限详细页面
		Grpo grpo = grpoService.getGrpoDetailInfo(id);
		map.put("grpo", grpo);
		return "grpo/grpo_detail";
	}
	/**
	 * 跳转至分组权限更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/grpo/grpo_edit.htm")
	public String grpoEdit(GrpoForm form, ModelMap map) {
		// 取得分组权限详细页面
		grpoService.updateGrpoInfo(setBean(form));
		return "common/action_succ";
	}

	/**
	 * 分组权限更新
	 * 
	 * @return 分组权限页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/grpo/grpo_edit.htm", method = RequestMethod.GET)
	public String grpoEdit(long id, ModelMap map) {
		// 取得分组权限详细页面
		Grpo grpo = grpoService.getGrpoDetailInfo(id);
		map.put("grpo", grpo);
		return "grpo/grpo_edit";
	}

	/**
	 * 添加设置表单属性
	 * 
	 * @param form
	 * @return Grpo
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private Grpo setBeans(GrpoForm form) {
		Grpo grpo = new Grpo();
		grpo.setGrpoName(form.getGrpoName());//分组名称
		grpo.setCategory(1);//设置成分组权限
		return grpo;
	}
	/**
	 * 更新设置表单属性
	 * 
	 * @param form
	 * @return Grpo
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private Grpo setBean(GrpoForm form) {
		Grpo grpo = new Grpo();
		grpo.setGrpoName(form.getGrpoName());//名称
		grpo.setId(form.getId());//ID
		grpo.setRemark(form.getRemark());//备注
		return grpo;
	}

	/**
	 * 分组权限申领表列表页面设置查询条件
	 * 
	 * @param form
	 * @param GrpoPage
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	private void setSearchKey(GrpoForm form, GrpoPage grpoPage) {
		grpoPage.setGrpoName(form.getGrpoName());//物品名称
		grpoPage.setCurrentPage(form.getCp()); // 当前页数
		grpoPage.setCategory(1);//查询分组权限

	}
	/**
	 * 跳转至添加分组角色页面
	 * 
	 * @return 新增分组角色页面
	 * 
	 * @Author cql
	 * @Date 2013-12-29
	 */
	@RequestMapping(value = "/grpo/grpo_role.htm", method = RequestMethod.GET)
	public String addGrpoRole(long id,ModelMap map) {
		// 取得要分组的基本信息
		Grpo grpo = grpoService.getGrpoDetailInfo(id);
		map.put("grpo", grpo);
		// 取得所有角色信息
		List<Role> roleList = grpoService.getRoleList();
		map.put("roleList", roleList);
		
		return "grpo/grpo_role";
	}
	
	/**
	 * 添加分组角色
	 * 
	 * @return 操作成功页面
	 * 
	 * @Author cql
	 * @Date 2013-12-29
	 */
	@RequestMapping("/grpo/add_grpo_role.htm")
	public String addGrpoRole(GrpoForm grpoForm) {
		// String[]转换long[]数组
		String[] strArray = grpoForm.getRoleIdArray();
		long[] idArray = new long[strArray.length];
		// 转换
		for (int i = 0; i < strArray.length; i++) {
			idArray[i] = NumberUtils.toLong(strArray[i]);
		}
		// 添加分组角色信息
		grpoService.createGrpoRole(grpoForm.getGroupId(),idArray);
		// 返回到操作成功页面
		return "common/action_succ";
	}
	
	/**
	 * 取得所有权限信息
	 * 
	 * @param map
	 * @return 权限信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/grpo/find_grpo_role.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findGrpoLoer(String groupId,ModelMap map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 查找权限列表
		List<Role> roleList = grpoService.getRoleList();
		dataMap.put("roleList", roleList);
		// 取得当前分组的角色信息
		List<GrpoRole> grpoRoleList = grpoRoleService.getGrpoRoleList(groupId);
		dataMap.put("grpoRoleList", grpoRoleList);
		return dataMap;
	}

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
	@RequestMapping("/grpo/group.htm")
	public String menuGroup(ModelMap map) {
		GrpoPage grpoPage = new GrpoPage(); // 分页对象
		grpoPage.setCategory(1);
		GrpoPage grpoPages = grpoService.getGrpoInfoList(grpoPage);
		map.put("grpoPages", grpoPages);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "group");
		return "grpo/menu_group";
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
	@RequestMapping(value = "/grpo/get_dept_user.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<User> getDeptUser(Long deptId) {
		// 根据部门列表查找部门下所有人员
		List<User> userList = commonService.findUserInfoByDeptId(deptId);
		return userList;
	}
	
	/**
	 * 查找人员下分组
	 * 
	 * @param map
	 * @return 发文拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/grpo/get_grpo_user.htm", method = RequestMethod.GET)
	@ResponseBody
	public List<UserRole> getGrpoUser(String loginId) {
		// 根据部门列表查找部门下所有人员
		List<UserRole> userRoleList = commonService.findUserInfoByLoginId(loginId);
		return userRoleList;
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
	@RequestMapping(value = "/grpo/find_dept.htm", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findDept(ModelMap map) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		// 查找部门列表
		dataMap.put("deptList", commonService.getAllDeptInfo());
		return dataMap;
	}
	
	/**
	 * 添加用户分组
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping("/grpo/users_role.htm")
	public String addUsersRole(String idArray,String gropIds,ModelMap map) {
		grpoService.selUserGroup(toStringArray(idArray),toLongArray(gropIds));
		return "common/action_succ";
	}
}
