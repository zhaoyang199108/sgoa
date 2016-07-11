package com.bcqsoft.xhlm.mvc.controller.ptfw;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.Ptfw;
import com.bcqsoft.xhlm.dao.ptfw.dataobject.PtfwPage;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;
import com.bcqsoft.xhlm.mvc.form.ptfw.PtfwForm;
import com.bcqsoft.xhlm.service.ptfw.PtfwService;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;


@Controller
public class AdminPtfwController {

	
	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private PtfwService ptfwService;	
	
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
	@RequestMapping("/admin/ptfw/list.htm")
	public String ptfwList(PtfwForm form, ModelMap map) {
		// 分类详细页对象初始化
		PtfwPage ptfwPage = new PtfwPage();
		// 设置查询条件
		setSearchKey(form, ptfwPage);
		// 取得分类详细列表,分页显示
		PtfwPage page = ptfwService.getPtfwInfoList(ptfwPage);
		String sortId=page.getSortId();
		map.put("page", page);
		map.put("sortId", sortId);
		// 跳转至类别详细列表页面
		return "admin/ptfw/ptfw_list";
	}

	/**
	 * 跳转至新增类别详细页面
	 * 
	 * @return 新增类别详细页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/ptfw/add_ptfw.htm", method = RequestMethod.GET)
	public String addPtfw(ModelMap map,PtfwForm form) {
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		return "admin/ptfw/add_ptfw";
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
	@RequestMapping("/admin/ptfw/add_ptfw.htm")
	public String addPtfw(PtfwForm form, ModelMap map) {
		// 追加类别详细
		ptfwService.createPtfw(setBeans(form));		
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
	@RequestMapping(value = "/admin/ptfw/edit_ptfw.htm", method = RequestMethod.GET)
	public String editPtfw(long id, ModelMap map) {
		// 取得要更新的仓库信息
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		Ptfw ptfw = ptfwService.getPtfwInfo(id);
		map.put("ptfw", ptfw);
		return "admin/ptfw/edit_ptfw";
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
	@RequestMapping("/admin/ptfw/edit_ptfw.htm")
	public String editPtfw(PtfwForm form, ModelMap map) {
		// 追加类别详细
		ptfwService.modifyPtfw(setBeans(form));
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
	@RequestMapping("/admin/ptfw/delete_ptfw.htm")
	public String deletePtfw(long id) {
		// 删除类别详细
		ptfwService.deletePtfw(id);
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
	@RequestMapping("/admin/ptfw/delete_ptfwArray.htm")
	public String removePtfw(String idArray) {
		// 删除类别详细信息
		ptfwService.deletePtfws(toLongArray(idArray));
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
	private void setSearchKey(PtfwForm form, PtfwPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle()); 
		page.setLoginId(SecurityUtils.getLoginId());//获取登录ID
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Ptfw
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private Ptfw setBeans(PtfwForm form) {
		Ptfw ptfw = new Ptfw();
		BeanUtils.copyProperties(form, ptfw); // 设置表单属性
		ptfw.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		ptfw.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return ptfw;
	}
}