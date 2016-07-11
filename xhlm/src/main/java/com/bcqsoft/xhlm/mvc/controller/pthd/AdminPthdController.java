package com.bcqsoft.xhlm.mvc.controller.pthd;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.pthd.dataobject.Pthd;
import com.bcqsoft.xhlm.dao.pthd.dataobject.PthdPage;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;
import com.bcqsoft.xhlm.mvc.form.pthd.PthdForm;
import com.bcqsoft.xhlm.service.pthd.PthdService;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;


@Controller
public class AdminPthdController {

	
	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private PthdService pthdService;	
	
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
	@RequestMapping("/admin/pthd/list.htm")
	public String pthdList(PthdForm form, ModelMap map) {
		// 分类详细页对象初始化
		PthdPage pthdPage = new PthdPage();
		// 设置查询条件
		setSearchKey(form, pthdPage);
		// 取得分类详细列表,分页显示
		PthdPage page = pthdService.getPthdInfoList(pthdPage);
		String sortId=page.getSortId();
		map.put("page", page);
		map.put("sortId", sortId);
		// 跳转至类别详细列表页面
		return "admin/pthd/pthd_list";
	}

	/**
	 * 跳转至新增类别详细页面
	 * 
	 * @return 新增类别详细页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/pthd/add_pthd.htm", method = RequestMethod.GET)
	public String addPthd(ModelMap map,PthdForm form) {
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		return "admin/pthd/add_pthd";
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
	@RequestMapping("/admin/pthd/add_pthd.htm")
	public String addPthd(PthdForm form, ModelMap map) {
		// 追加类别详细
		pthdService.createPthd(setBeans(form));		
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
	@RequestMapping(value = "/admin/pthd/edit_pthd.htm", method = RequestMethod.GET)
	public String editPthd(long id, ModelMap map) {
		// 取得要更新的仓库信息
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		Pthd pthd = pthdService.getPthdInfo(id);
		map.put("pthd", pthd);
		return "admin/pthd/edit_pthd";
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
	@RequestMapping("/admin/pthd/edit_pthd.htm")
	public String editPthd(PthdForm form, ModelMap map) {
		// 追加类别详细
		pthdService.modifyPthd(setBeans(form));
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
	@RequestMapping("/admin/pthd/delete_pthd.htm")
	public String deletePthd(long id) {
		// 删除类别详细
		pthdService.deletePthd(id);
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
	@RequestMapping("/admin/pthd/delete_pthdArray.htm")
	public String removePthd(String idArray) {
		// 删除类别详细信息
		pthdService.deletePthds(toLongArray(idArray));
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
	private void setSearchKey(PthdForm form, PthdPage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle()); 
		page.setLoginId(SecurityUtils.getLoginId());//获取登录ID
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Pthd
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private Pthd setBeans(PthdForm form) {
		Pthd pthd = new Pthd();
		BeanUtils.copyProperties(form, pthd); // 设置表单属性
		pthd.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		pthd.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return pthd;
	}
}