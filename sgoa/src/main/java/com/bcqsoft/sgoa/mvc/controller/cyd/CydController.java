package com.bcqsoft.sgoa.mvc.controller.cyd;

import static com.bcqsoft.sgoa.core.security.SecurityUtils.getLoginId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.cyd.dataobject.Cyd;
import com.bcqsoft.sgoa.dao.cyd.dataobject.CydEntity;
import com.bcqsoft.sgoa.dao.cyd.dataobject.CydPage;
import com.bcqsoft.sgoa.dao.cyddetail.dataobject.CydDetailPage;
import com.bcqsoft.sgoa.mvc.form.cyd.CydForm;
import com.bcqsoft.sgoa.service.cyd.CydService;
import com.bcqsoft.sgoa.dao.user.dataobject.UsersPage;
import com.bcqsoft.sgoa.service.cyddetail.CydDetailService;

@Controller
public class CydController {

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private CydService cydService;
	
	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private CydDetailService cydDetailService;
	
	/**
	 * 传阅单列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	@RequestMapping(value = "/cyd/cyd_list.htm")
	public String cydList(CydForm cydForm, ModelMap map) {		
		CydPage cydPage=new CydPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(cydForm, cydPage); // 设置查询条件
		cydPage.setCreateId(getLoginId()); // 设置当前操作人为当前用户ID
		// 根据用户ID查找该待该用户审批的信息
		map.put("page", cydService.getCydList(cydPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "cyd_list");
		// 跳转至信息列表页面
		return "/cyd/cyd_list";
	}
	
	/**
	 * 我的拟稿列表页面设置查询条件
	 * 
	 * @param form
	 * @param goodsPage
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	private void setSearchKey(CydForm form, CydPage cydPage) {
		// 设置查询条件
		cydPage.setCurrentPage(form.getCp()); // 当前页数		
		cydPage.setNum(form.getNum());
	}
	
	/**
	 * 跳转至信息拟稿页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	@RequestMapping(value = "/cyd/to_add_cyd.htm", method = RequestMethod.GET)
	public String toAddCyd(ModelMap map) {		
		UsersPage page = cydService.getAllUserByDept();
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "to_add_cyd");
		// 跳转至信息拟稿页面
		return "/cyd/add_cyd";
	}
	/**
	 * 信息提交申请
	 * 
	 * @param map
	 * @return 确认是否继续信息页面
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	@RequestMapping(value = "/cyd/add_cyd.htm")
	public String addCyd(CydForm form, ModelMap map) {
		// 信息临时表中添加数据
		cydService.addCydInfo(setAddBean(form));
		// 跳转至信息拟稿页面
		return "/cyd/add_success";
	}
	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Storage
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	private CydEntity setAddBean(CydForm form) {
		CydEntity cyd = new CydEntity();
		BeanUtils.copyProperties(form, cyd); // 设置表单属性
		cyd.setCreateId(SecurityUtils.getLoginId());
		cyd.setEnabled(1);
		return cyd;
	}
	
	/**
	 * 点击查看通知表详细
	 * 
	 * @param id
	 * @param map
	 * @return 通知表详细页面
	 * @throws Exception
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	@RequestMapping(value = "/cyd/detail.htm", method = RequestMethod.GET)
	public String cydDetail(Long id, ModelMap map) throws Exception {

		Cyd cyd = cydService.getCydDetailById(id);		
		map.put("cyd", cyd);
		
		CydDetailPage page = cydDetailService.getCydDetailListById(id);
		map.put("page", page);
		return "/cyd/cyd_detail";
	}
	
	/**
	 * 取得信息草稿数据,并跳转至编辑信息草稿页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * @throws Exception
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	@RequestMapping(value = "/cyd/to_edit_cyd.htm")
	public String toEditCyd(Long id, ModelMap map) {
		
		Cyd cyd = cydService.getCydDetailById(id);		
		map.put("cyd", cyd);
		
		CydDetailPage page = cydDetailService.getCydDetailListById(id);
		map.put("page", page);
		return "/cyd/edit_cyd";
	}
	
	/**
	 * 传阅单表更新处理
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	@RequestMapping("/cyd/edit_cyd.htm")
	public String editCyd(CydForm form, ModelMap map) {
		long id = form.getId();
		// 删除详细表记录
		cydService.deleteCydDetailInfoById(id);
		// 新增详细表记录
		cydService.creatCydDetail(setAddBean(form));
		// 更新主表记录
		cydService.updateCyd(toEditBean(form));
		 //设置操作日志
		return "/cyd/edit_success";
	}
	
	/**
	 * DO设置
	 * 
	 * @param form
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	private Cyd toEditBean(CydForm form) {
		Cyd cyd = new Cyd();
		BeanUtils.copyProperties(form, cyd); // 复制表单至DO
		return cyd;
	}
	
	/**
	 * 传阅单表更新处理
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author lzn
	 * @Date 2015-10-09
	 */
	@RequestMapping("/cyd/delete_cyd.htm")
	public String deleteCyd(CydForm form, ModelMap map) {
		long id = form.getId();
		// 删除详细表记录
		cydService.deleteCydDetailInfoById(id);
		// 更新主表记录
		cydService.deleteCydById(id);
		 //设置操作日志
		return "/cyd/edit_success";
	}
	
}