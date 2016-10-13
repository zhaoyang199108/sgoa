package com.bcqsoft.sgoa.mvc.controller.sw;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;
import static com.bcqsoft.sgoa.core.security.SecurityUtils.getLoginId;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.sw.dataobject.Sw;
import com.bcqsoft.sgoa.dao.sw.dataobject.SwPage;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHu;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHuPage;
import com.bcqsoft.sgoa.mvc.form.sw.SwForm;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.dept.DeptService;
import com.bcqsoft.sgoa.service.sw.SwService;
import com.bcqsoft.sgoa.service.swhu.SwHuService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 信息控制器
 */
@Controller
public class SwController {

	/**
	 * 部门模块业务逻辑类接口
	 */
	@Autowired
	private DeptService deptService;

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private SwService swService;

	/**
	 * 共通逻辑类接口
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private SwHuService swHuService;
	/**
	 * 用户表的业务逻辑层
	 */
	@Autowired
	private UserService userService;

	/**
	 * 跳转至信息拟稿页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/add_sw.htm", method = RequestMethod.GET)
	public String addSw(ModelMap map) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("d_userName", SecurityUtils.getLoginId());
		map.put("d_fileType", "doc");
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "add_sw");
		// 跳转至信息拟稿页面
		return "/sw/add_sw";
	}

	/**
	 * 信息提交申请
	 * 
	 * @param map
	 * @return 确认是否继续信息页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/add_sw.htm", method = RequestMethod.POST)
	public String addSw(SwForm form, ModelMap map) {
		// 信息临时表中添加数据
		swService.addSwInfo(setBeans(form));
		// 跳转至信息拟稿页面
		return "/sw/add_success";
	}

	/**
	 * 信息保存至草稿
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/draft_sw.htm", method = RequestMethod.POST)
	public String draftSw(SwForm form, boolean edit, ModelMap map) {
		// 根据参数edit判断是否更新
		if (edit) {
			swService.updateSwDraftInfo(setBeans(form));
		} else {
			swService.addSwDraftInfo(setBeans(form));
		}
		// 跳转至信息拟稿页面
		return "/sw/draft_success";
	}

	/**
	 * 我的拟稿列表
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/my_draft_list.htm", method = RequestMethod.GET)
	public String myDraftList(SwForm outForm, ModelMap map) {
		SwPage outPage = new SwPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setLoginId(getLoginId()); // 设置拟稿人为当前用户ID

		// 根据用户ID查找该用户拟稿的信息
		map.put("page", swService.getMyDraftSwList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_draft_list");
		// 跳转至信息列表页面
		return "/sw/my_draft_list";
	}

	/**
	 * 我的信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/list.htm", method = RequestMethod.GET)
	public String swList(SwForm outForm, ModelMap map) {
		SwPage swPage = new SwPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, swPage); // 设置查询条件
		swPage.setLoginId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", swService.getApprovedSwList(swPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "sw_list");
		// 跳转至信息列表页面
		return "/sw/sw_list";
	}

	/**
	 * 已收收文查询
	 * 
	 * @param from
	 * @param map
	 * @return 已收收文查询
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/sw/sw_received.htm")
	public String docinReceived(SwForm outForm,ModelMap map) {
		SwPage swPage = new SwPage();
		setSearchKey(outForm, swPage); // 设置查询条件
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		swPage.setReceivedId(getLoginId()); // 设置拟稿人为当前用户ID
		// 根据用户ID查找该用户拟稿的信息
		map.put("page", swService.getMySwList(swPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "sw_received");
		// 返回到操作成功页面
		return "/sw/sw_received";

	}

	
	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long
	 *            信息ID
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@RequestMapping(value = "/sw/del_sw.htm", method = RequestMethod.GET)
	public String deleteSw(Long id) {
		swService.removeOneSwInfo(id);
		return "/common/action_succ";
	}

	/**
	 * 删除收件箱(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	@RequestMapping("/sw/delete_swArray.htm")
	public String deleteSw(String idArray) {
		// 删除收件箱信息
		swService.removeOneSwInfo(toLongArray(idArray));
		// 返回到操作成功页面
		return "common/action_succ";
	}

	/**
	 * 取得信息草稿数据,并跳转至编辑信息草稿页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/edit_sw.htm", method = RequestMethod.GET)
	public String editSw(Long id, ModelMap map) {
		Sw sw = swService.getUserDraftSwDetail(id);
		sw.setReceiverName(commonService.getUsersNameByLoginIds(sw.getReceiverId()));

		// 取得页面下拉框数据
		map.put("sw", sw);
		map.put("loginId", getLoginId()); // 当前登录ID
		// 跳转至信息拟稿页面
		return "/sw/edit_sw";
	}

	/**
	 * 取得信息草稿数据,并跳转至编辑信息草稿页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/edit_sw.htm", method = RequestMethod.POST)
	public String editSw(SwForm form, ModelMap map) {
		swService.updateSwInfo(setBeans(form));
		// 跳转至拟稿成功页面
		return "/sw/add_success";
	}

	/**
	 * 跳转至信息内容页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/content_detail.htm", method = RequestMethod.GET)
	public String contentSw(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/sw/content_sw";
	}

	/**
	 * 跳转至信息内容页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/content_history.htm", method = RequestMethod.GET)
	public String contentSwHistory(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/sw/content_history";
	}

	/**
	 * 我的拟稿列表页面设置查询条件
	 * 
	 * @param form
	 * @param goodsPage
	 * 
	 * @Author zbq
	 * @Date 2011-8-25
	 */
	private void setSearchKey(SwForm form, SwPage swPage) {
		// 设置查询条件
		swPage.setCurrentPage(form.getCp()); // 当前页数
		swPage.setTitle(form.getTitle()); // 标题
		swPage.setTextTime(form.getTextTime()); // 标题
		swPage.setStatus(form.getStatus()); // 当前状态
		swPage.setEnabled(form.getEnabled()); // 文件状态
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Storage
	 * 
	 * @Author zbq
	 * @Date 2011-8-19
	 */
	private Sw setBeans(SwForm form) {
		Sw sw = new Sw();
		BeanUtils.copyProperties(form, sw); // 设置表单属性
		sw.setLoginId(SecurityUtils.getLoginId());
		if(null==sw.getSupervise()){
			sw.setSupervise(2);
		}
		return sw;
	}
	
	/**
	 * 跳转至添加回执页面
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/sw_receipt.htm", method = RequestMethod.GET)
	public String addDocinReceipt(long  id,ModelMap map) {
		map.put("docinId", id);
		return "/sw/sw_receipt";
	}
	
	/**
	 * 信息提交申请
	 * 
	 * @param map
	 * @return 确认是否继续信息页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/sw/sw_receipt.htm", method = RequestMethod.POST)
	public String addSwReceipt(SwForm form, ModelMap map) {
		// 信息临时表中添加数据
		SwHu swHu = new SwHu();
		swHu.setReceiverId(SecurityUtils.getLoginId());
		swHu.setDocinId(form.getDocinId());
		swHu.setStatus(1);
		swHu.setStituation(form.getStituation());
		swHu.setBljg(form.getBljg());
		swHu.setIsqs(1);
		swHuService.updateSwInfo(swHu);
	
		// 跳转至信息拟稿页面
		return "/common/action_succ";
	}
	
	/**
	 * 点击查看详细
	 * 
	 * @param id
	 * @param map
	 * @return 详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/sw/detail_qf.htm", method = RequestMethod.GET)
	public String swDetailQf(Long id, ModelMap map) throws Exception {
		Sw sw = swService.getUserDraftSwDetail(id);
		sw.setReceiverName(commonService.getUsersNameByLoginIds(sw.getReceiverId()));
		map.put("sw", sw);
		
		SwHu swHu = new SwHu();
		swHu.setReceiverId(SecurityUtils.getLoginId());
		swHu.setDocinId(id);
		swHu.setIsqs(1);
		swHuService.updateSwInfo(swHu);
		return "/sw/sw_detail_qf";
	}
	
	/**
	 * 点击查看通知表详细
	 * 
	 * @param id
	 * @param map
	 * @return 通知表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/sw/detail.htm", method = RequestMethod.GET)
	public String docinDetail(Long id, ModelMap map) throws Exception {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		Sw sw = swService.getUserDraftSwDetail(id);
		sw.setReceiverName(commonService.getUsersNameByLoginIds(sw.getReceiverId()));
		map.put("sw", sw);
		
		SwHuPage page = swService.getSwHuListById(id);
		map.put("page", page);
		return "/sw/sw_detail";
	}

}
