package com.bcqsoft.sgoa.mvc.controller.seal;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.dao.seal.dataobject.Seal;
import com.bcqsoft.sgoa.dao.seal.dataobject.SealPage;
import com.bcqsoft.sgoa.mvc.form.seal.SealForm;
import com.bcqsoft.sgoa.service.seal.SealService;

/**
 * 签章模块申领表模块控制器
 * 
 * @author Bcqsoft.com cql
 * 
 */
@Controller
public class SealController {
	/**
	 * 签章模块申领表的业务逻辑层
	 */
	@Autowired
	private SealService sealService;
	
	/**
	 * 取得有效的签章模块申领表列表(提交审核页面)
	 * 
	 * @param form
	 * @param map
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/seal/seal_list.htm")
	public String selectSealListByPage(SealForm form, ModelMap map) {
		SealPage sealPage = new SealPage(); // 分页对象
		setSearchKey(form, sealPage); // 设置页面中的查询条件
		SealPage page = sealService.getSealInfoList(sealPage);
		// 跳转至签章模块申领表列表页面
		map.put("page", page);
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "seal_list");
		return "seal/seal_list";
	}

	/**
	 * 跳转至新增签章模块页面
	 * 
	 * @return 新增签章模块页面
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	@RequestMapping(value = "/seal/add_seal.htm", method = RequestMethod.GET)
	public String addSeal() {
		return "seal/add_seal";
	}

	/**
	 * 签章模块申领表新增处理
	 * 
	 * @param map
	 * @return 签章模块申领表的添加页面
	 * 
	 * 
	 * @author Bcqsoft.com cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/seal/add_seal.htm")
	public String addSeal(SealForm form, ModelMap map) {
		sealService.createSeal(setBeans(form));
		return "common/action_succ";
	}

	/**
	 * 签章模块表删除处理(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param id
	 * @return 更新签章模块申领表成功页面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/seal/delete_seal.htm")
	public String delectSeal(long id) {
		sealService.deleteSeal(id);
		return "common/action_succ";

	}

	/**
	 * 删除签章模块表(逻辑删除,更新数据库状态为不可用)
	 * 
	 * @param ArrayList
	 * @return 操作成功頁面
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	@RequestMapping("/seal/delete_sealArray.htm")
	public String removeSeal(String idArray) {
		sealService.deleteSeals(toLongArray(idArray));
		return "common/action_succ";
	}

	/**
	 * 跳转至签章模块详细页面
	 * 
	 * @return 签章模块页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/seal/seal_detail.htm", method = RequestMethod.GET)
	public String sealDetail(long id, ModelMap map) {
		// 取得签章模块详细页面
		Seal seal = sealService.getSealInfo(id);
		sealService.getSealInfoToOut(seal);
		map.put("seal", seal);
		return "seal/seal_detail";
	}


	/**
	 * 跳转至签章模块更新页面
	 * 
	 * @return id
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping("/seal/seal_edit.htm")
	public String sealEdit(SealForm form, ModelMap map) {
		// 取得签章模块详细页面
		sealService.editSealInfo(setBeans(form));
		return "common/action_succ";
	}

	/**
	 * 签章模块更新
	 * 
	 * @return 签章模块页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/seal/seal_edit.htm", method = RequestMethod.GET)
	public String sealEdit(long id, ModelMap map) {
		// 取得签章模块详细页面
		Seal seal = sealService.getSealInfo(id);
		map.put("seal", seal);
		return "seal/seal_edit";
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Seal
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	private Seal setBeans(SealForm form) {
		Seal seal = new Seal();
		seal.setId(form.getId());
		try {
			seal.setFileBody(form.getMarkFile().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		seal.setSealName(form.getSealName());
		seal.setFileSize((int) form.getMarkFile().getSize());
		seal.setUserName(form.getUserName());
		seal.setPassWord(form.getPassWord());
		// 取得文件后缀名
		String filter = form.getMarkFile().getOriginalFilename().substring(form.getMarkFile().getOriginalFilename().lastIndexOf(".")+1);
		
		seal.setFileType(filter);
		return seal;
	}

	/**
	 * 签章模块申领表列表页面设置查询条件
	 * 
	 * @param form
	 * @param SealPage
	 * 
	 * @Author cql
	 * @Date 2012-05-02
	 */
	private void setSearchKey(SealForm form, SealPage sealPage) {
		sealPage.setSealName(form.getSealName());// 签章名称
		sealPage.setUserName(form.getUserName());// 用户名称
		sealPage.setCurrentPage(form.getCp()); // 当前页数

	}
	
}
