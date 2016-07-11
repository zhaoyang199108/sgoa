package com.bcqsoft.xhlm.mvc.controller.sortdetail;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.Sortdetail;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;
import com.bcqsoft.xhlm.mvc.form.sortdetail.SortdetailForm;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;


@Controller
public class AdminSortdetailController {
	
	/**
	 * 分类详细模块业务逻辑类接口
	 */
	@Autowired
	private SortdetailService sortdetailService;	
	
	/**
	 * 查看类别详细信息列表
	 * 
	 * @param map
	 * @return 类别详细列表页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/sortdetail/list.htm")
	public String sortdetailList(SortdetailForm form, ModelMap map) {
		// 分类详细页对象初始化
		SortdetailPage sortdetailPage = new SortdetailPage();
		// 设置查询条件
		setSearchKey(form, sortdetailPage);
		// 取得分类详细列表,分页显示
		SortdetailPage page = sortdetailService.getSortdetailInfoList(sortdetailPage);
		String sortId=page.getSortId();
		map.put("page", page);
		map.put("sortId", sortId);
		// 跳转至类别详细列表页面
		return "admin/sortdetail/sortdetail_list";
	}

	/**
	 * 跳转至新增类别详细页面
	 * 
	 * @return 新增类别详细页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/sortdetail/add_sortdetail.htm", method = RequestMethod.GET)
	public String addSortdetail(ModelMap map,SortdetailForm form) {
		SortdetailPage sortdetailPage = new SortdetailPage();
		setSearchKey(form, sortdetailPage);		
		map.put("sortId", form.getSortId());
		return "admin/sortdetail/add_sortdetail";
	}

	/**
	 * 类别详细新增处理
	 * 
	 * @param map
	 * @return 新增类别详细成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/sortdetail/add_sortdetail.htm")
	public String addSortdetail(SortdetailForm form, ModelMap map) {
		// 追加类别详细
		sortdetailService.createSortdetail(setBeans(form));
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至更新类别详细页面
	 * 
	 * @return 新增类别详细页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/sortdetail/edit_sortdetail.htm", method = RequestMethod.GET)
	public String editSortdetail(long id, ModelMap map) {
		// 取得要更新的仓库信息
		Sortdetail sortdetail = sortdetailService.getSortdetailInfo(id);
		map.put("sortdetail", sortdetail);		
		return "admin/sortdetail/edit_sortdetail";
	}

	/**
	 * 类别详细更新处理
	 * 
	 * @param map
	 * @return 更新类别详细成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/sortdetail/edit_sortdetail.htm")
	public String editSortdetail(SortdetailForm form, ModelMap map) {
		// 追加类别详细
		sortdetailService.modifySortdetail(setBeans(form));
		return "admin/common/action_succ";
	}

	/**
	 * 类别详细删除处理
	 * 
	 * @param map
	 * @return 更新类别详细成功页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/sortdetail/delete_sortdetail.htm")
	public String deleteSortdetail(long id) {
		// 删除类别详细
		sortdetailService.deleteSortdetail(id);
		return "admin/common/action_succ";
	}

	/**
	 * 删除仓库(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping("/admin/sortdetail/delete_sortdetailArray.htm")
	public String removeSortdetail(String idArray) {
		// 删除类别详细信息
		sortdetailService.deleteSortdetails(toLongArray(idArray));
		// 返回到操作成功页面
		return "admin/common/action_succ";
	}

	/**
	 * 类别详细列表页面设置查询条件
	 * 
	 * @param form
	 * @param detailPage
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private void setSearchKey(SortdetailForm form, SortdetailPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setName(form.getName());
		page.setSortId(form.getSortId());
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Sortdetail
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private Sortdetail setBeans(SortdetailForm form) {
		Sortdetail detail = new Sortdetail();
		BeanUtils.copyProperties(form, detail); // 设置表单属性
		detail.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		detail.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return detail;
	}
}