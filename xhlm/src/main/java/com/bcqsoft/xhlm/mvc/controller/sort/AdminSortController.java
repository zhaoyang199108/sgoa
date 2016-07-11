package com.bcqsoft.xhlm.mvc.controller.sort;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.sort.dataobject.Sort;
import com.bcqsoft.xhlm.dao.sort.dataobject.SortPage;
import com.bcqsoft.xhlm.mvc.form.sort.SortForm;
import com.bcqsoft.xhlm.service.sort.SortService;


@Controller
public class AdminSortController {

	/**
	 * 类别分类模块业务逻辑类接口
	 */
	@Autowired
	private SortService sortService;

	/**
	 * 查看类别分类信息列表
	 * 
	 * @param map
	 * @return 类别分类列表页面
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	@RequestMapping("/admin/sort/list.htm")
	public String sortList(SortForm form, ModelMap map) {
		// 类别分类分页对象初始化
		SortPage sortsPage = new SortPage();
		// 设置查询条件
		setSearchKey(form, sortsPage);
		// 取得类别分类列表,分页显示
		SortPage page = sortService.getSortInfoList(sortsPage);
		map.put("page", page);
		// 跳转至类别分类列表页面
		return "admin/sort/sort_list";
	}

	/**
	 * 跳转至新增类别分类页面
	 * 
	 * @return 新增类别分类页面
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	@RequestMapping(value = "/admin/sort/add_sort.htm", method = RequestMethod.GET)
	public String addSort() {
		return "admin/sort/add_sort";
	}

	/**
	 * 类别分类新增处理
	 * 
	 * @param map
	 * @return 新增类别分类成功页面
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	@RequestMapping("/admin/sort/add_sort.htm")
	public String addSort(SortForm form, ModelMap map) {
		// 追加类别分类
		sortService.createSort(setBeans(form));
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至更新类别分类页面
	 * 
	 * @return 新增类别分类页面
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	@RequestMapping(value = "/admin/sort/edit_sort.htm", method = RequestMethod.GET)
	public String editSort(long id, ModelMap map) {
		// 取得要更新的仓库信息
		Sort sort = sortService.getSortInfo(id);
		map.put("sort", sort);
		return "admin/sort/edit_sort";
	}

	/**
	 * 类别分类更新处理
	 * 
	 * @param map
	 * @return 更新类别分类成功页面
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	@RequestMapping("/admin/sort/edit_sort.htm")
	public String editSort(SortForm form, ModelMap map) {
		// 追加类别分类
		sortService.modifySort(setBeans(form));
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至类别分类详细页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-06-26
	 */
	@RequestMapping(value = "/admin/sort/detail.htm", method = RequestMethod.GET)
	public String detailOrgan(Long id, ModelMap map) {
		map.put("sort", sortService.getSortInfo(id));
		return "admin/sort/detail_sort";
	}

	/**
	 * 类别分类删除处理
	 * 
	 * @param map
	 * @return 更新类别分类成功页面
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	@RequestMapping("/admin/sort/delete_sort.htm")
	public String deleteSort(long id) {
		// 删除类别分类
		sortService.deleteSort(id);
		return "admin/common/action_succ";
	}

	/**
	 * 删除仓库(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	@RequestMapping("/admin/sort/delete_sortArray.htm")
	public String removeSort(String idArray) {
		// 删除类别分类信息
		sortService.deleteSorts(toLongArray(idArray));
		// 返回到操作成功页面
		return "admin/common/action_succ";
	}

	/**
	 * 类别分类列表页面设置查询条件
	 * 
	 * @param form
	 * @param sortPage
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	private void setSearchKey(SortForm form, SortPage sortPage) {
		// 设置查询条件
		sortPage.setCurrentPage(form.getCp()); // 当前页数
		sortPage.setName(form.getName());
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Sort
	 * 
	 * @Author cql
	 * @Date 2013-06-26
	 */
	private Sort setBeans(SortForm form) {
		Sort sort = new Sort();
		BeanUtils.copyProperties(form, sort); // 设置表单属性
		sort.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		sort.setName(form.getName());		
		sort.setLoginId(SecurityUtils.getLoginId());
		return sort;
	}
}