package com.bcqsoft.sgoa.mvc.controller.grpo;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.dao.grpo.dataobject.Grpo;
import com.bcqsoft.sgoa.dao.grpo.dataobject.GrpoPage;
import com.bcqsoft.sgoa.mvc.form.grpo.GrpoForm;
import com.bcqsoft.sgoa.service.grpo.GrpoService;

/**
 * 职务权限申领表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class PosiController {
	/**
	 * 职务权限申领表的业务逻辑层
	 */
	@Autowired
	private GrpoService grpoService;

	/**
	 * 取得有效的职务权限申领表列表(提交审核页面)
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/posi/posi_list.htm")
	public String selectGrpoListByPage(GrpoForm form, ModelMap map) {
		GrpoPage grpoPage = new GrpoPage(); // 分页对象
		setSearchKey(form, grpoPage); // 设置页面中的查询条件
		GrpoPage page = grpoService.getGrpoInfoList(grpoPage);
		// 跳转至职务权限申领表列表页面
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "posi_list");
		return "posi/posi_list";
	}

	/**
	 * 跳转至新增职务权限页面
	 * 
	 * @return 新增职务权限页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/posi/add_posi.htm", method = RequestMethod.GET)
	public String addGrpo() {
		return "posi/add_posi";
	}

	/**
	 * 职务权限申领表新增处理
	 * 
	 * @param map
	 * @return 职务权限申领表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/posi/add_posi.htm")
	public String addGrpo(GrpoForm form, ModelMap map) {
		grpoService.createGrpoInfo(setBeans(form));
		return "common/action_succ";
	}

	/**
	 * 职务权限表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新职务权限申领表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/posi/delete_posi.htm")
	public String delectGrpo(long id) {
		grpoService.deleteGrpoInfo(id);
		return "common/action_succ";

	}

	/**
	 * 删除职务权限表(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/posi/delete_posiArray.htm")
	public String removeGrpo(String idArray) {
		grpoService.deleteGrpos(toLongArray(idArray));
		return "common/action_succ";
	}


	/**
	 * 跳转至职务权限详细页面
	 * 
	 * @return 职务权限页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/posi/posi_detail.htm", method = RequestMethod.GET)
	public String grpoDetail(long id, ModelMap map) {
		// 取得职务权限详细页面
		Grpo grpo = grpoService.getGrpoDetailInfo(id);
		map.put("grpo", grpo);
		return "posi/posi_detail";
	}
	/**
	 * 跳转至职务权限更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/posi/posi_edit.htm")
	public String grpoEdit(GrpoForm form, ModelMap map) {
		// 取得职务权限详细页面
		grpoService.updateGrpoInfo(setBean(form));
		return "common/action_succ";
	}

	/**
	 * 职务权限更新
	 * 
	 * @return 职务权限页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/posi/posi_edit.htm", method = RequestMethod.GET)
	public String grpoEdit(long id, ModelMap map) {
		// 取得职务权限详细页面
		Grpo grpo = grpoService.getGrpoDetailInfo(id);
		map.put("grpo", grpo);
		return "posi/posi_edit";
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
		grpo.setGrpoName(form.getGrpoName());//职务名称
		grpo.setCategory(2);//设置成职务权限
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
	 * 职务权限申领表列表页面设置查询条件
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
		grpoPage.setCategory(2);//查询职务权限
	}

}
