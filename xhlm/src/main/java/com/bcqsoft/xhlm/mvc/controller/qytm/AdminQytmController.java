package com.bcqsoft.xhlm.mvc.controller.qytm;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.qytm.dataobject.Qytm;
import com.bcqsoft.xhlm.dao.qytm.dataobject.QytmPage;
import com.bcqsoft.xhlm.mvc.form.qytm.QytmForm;
import com.bcqsoft.xhlm.service.qytm.QytmService;

@Controller
public class AdminQytmController {

	/**
	 * 企业条目模块业务逻辑类接口
	 */
	@Autowired
	private QytmService qytmService;
	
	/**
	 * 查看企业条目信息列表
	 * 
	 * @param map
	 * @return 企业条目列表页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/qytm/list.htm")
	public String qytmList(QytmForm form, ModelMap map) {
		// 企业条目分页对象初始化
		QytmPage qytmsPage = new QytmPage();
		qytmsPage.setLoginId(SecurityUtils.getLoginId());
		// 设置查询条件
		setSearchKey(form, qytmsPage);
		// 取得企业条目列表,分页显示
		QytmPage page = qytmService.getQytmInfoList(qytmsPage);
		map.put("page", page);
		// 跳转至企业条目列表页面
		return "admin/qytm/qytm_list";
	}

	/**
	 * 跳转至新增企业条目页面
	 * 
	 * @return 新增企业条目页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping(value = "/admin/qytm/add_qytm.htm", method = RequestMethod.GET)
	public String addQytm(ModelMap map) {
		return "admin/qytm/add_qytm";
	}

	/**
	 * 企业条目新增处理
	 * 
	 * @param map
	 * @return 新增企业条目成功页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/qytm/add_qytm.htm")
	public String addQytm(QytmForm form, ModelMap map) {
		// 追加企业条目
		qytmService.createQytm(setBeans(form));
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至更新企业条目页面
	 * 
	 * @return 新增企业条目页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping(value = "/admin/qytm/edit_qytm.htm", method = RequestMethod.GET)
	public String editQytm(long id, ModelMap map) {
		// 取得要更新的仓库信息
		Qytm qytm = qytmService.getQytmInfo(id);
		map.put("qytm", qytm);
		return "admin/qytm/edit_qytm";
	}

	/**
	 * 企业条目更新处理
	 * 
	 * @param map
	 * @return 更新企业条目成功页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/qytm/edit_qytm.htm")
	public String editQytm(QytmForm form, ModelMap map) {
		// 追加企业条目
		qytmService.modifyQytm(setBean(form));
		return "admin/common/action_succ";
	}

	/**
	 * 跳转至企业条目详细页面
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-9-12
	 */
	@RequestMapping(value = "/admin/qytm/detail.htm", method = RequestMethod.GET)
	public String detailOrgan(Long id, ModelMap map) {
		map.put("qytm", qytmService.getQytmInfo(id));
		return "admin/qytm/detail_qytm";
	}

	/**
	 * 企业条目删除处理
	 * 
	 * @param map
	 * @return 更新企业条目成功页面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/qytm/delete_qytm.htm")
	public String deleteQytm(long id) {
		// 删除企业条目
		qytmService.deleteQytm(id);
		return "admin/common/action_succ";
	}

	/**
	 * 删除仓库(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	@RequestMapping("/admin/qytm/delete_qytmArray.htm")
	public String removeQytm(String idArray) {
		// 删除企业条目信息
		qytmService.deleteQytms(toLongArray(idArray));
		// 返回到操作成功页面
		return "admin/common/action_succ";
	}

	/**
	 * 企业条目列表页面设置查询条件
	 * 
	 * @param form
	 * @param qytmPage
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	private void setSearchKey(QytmForm form, QytmPage qytmPage) {
		// 设置查询条件
		qytmPage.setCurrentPage(form.getCp()); // 当前页数
		qytmPage.setTmname(form.getTmname()); // 条目
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Qytm
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	private Qytm setBeans(QytmForm form) {
		Qytm qytm = new Qytm();
		BeanUtils.copyProperties(form, qytm); // 设置表单属性
		qytm.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		qytm.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return qytm;
	}
	
	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Qytm
	 * 
	 * @Author cql
	 * @Date 2013-9-12
	 */
	private Qytm setBean(QytmForm form) {
		Qytm qytm = new Qytm();
		BeanUtils.copyProperties(form, qytm); // 设置表单属性
		qytm.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		return qytm;
	}
}
