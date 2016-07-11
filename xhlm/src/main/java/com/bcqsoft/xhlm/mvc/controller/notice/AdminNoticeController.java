package com.bcqsoft.xhlm.mvc.controller.notice;

import static com.bcqsoft.xhlm.common.util.ArrayUtil.toLongArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.xhlm.common.charactor.CommonChar;
import com.bcqsoft.xhlm.core.security.SecurityUtils;
import com.bcqsoft.xhlm.dao.notice.dataobject.Notice;
import com.bcqsoft.xhlm.dao.notice.dataobject.NoticePage;
import com.bcqsoft.xhlm.dao.sortdetail.dataobject.SortdetailPage;
import com.bcqsoft.xhlm.mvc.form.notice.NoticeForm;
import com.bcqsoft.xhlm.service.notice.NoticeService;
import com.bcqsoft.xhlm.service.sortdetail.SortdetailService;


@Controller
public class AdminNoticeController {

	
	/**
	 * 通知模块业务逻辑类接口
	 */
	@Autowired
	private NoticeService noticeService;	
	
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
	@RequestMapping("/admin/notice/list.htm")
	public String noticeList(NoticeForm form, ModelMap map) {
		// 分类详细页对象初始化
		NoticePage noticePage = new NoticePage();
		// 设置查询条件
		setSearchKey(form, noticePage);
		// 取得分类详细列表,分页显示
		NoticePage page = noticeService.getNoticeInfoList(noticePage);
		String sortId=page.getSortId();
		map.put("page", page);
		map.put("sortId", sortId);
		// 跳转至类别详细列表页面
		return "admin/notice/notice_list";
	}

	/**
	 * 跳转至新增类别详细页面
	 * 
	 * @return 新增类别详细页面
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	@RequestMapping(value = "/admin/notice/add_notice.htm", method = RequestMethod.GET)
	public String addNotice(ModelMap map,NoticeForm form) {
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		return "admin/notice/add_notice";
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
	@RequestMapping("/admin/notice/add_notice.htm")
	public String addNotice(NoticeForm form, ModelMap map) {
		// 追加类别详细
		noticeService.createNotice(setBeans(form));
		
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
	@RequestMapping(value = "/admin/notice/edit_notice.htm", method = RequestMethod.GET)
	public String editNotice(long id, ModelMap map) {
		// 取得要更新的仓库信息
		SortdetailPage detailPage = new SortdetailPage();
		detailPage.setSortId("2");
		map.put("sortdetailList", sortdetailService.getSortdetailListById(detailPage).getSortdetailList()); //取得分类列表
		Notice notice = noticeService.getNoticeInfo(id);
		map.put("notice", notice);
		return "admin/notice/edit_notice";
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
	@RequestMapping("/admin/notice/edit_notice.htm")
	public String editNotice(NoticeForm form, ModelMap map) {
		// 追加类别详细
		noticeService.modifyNotice(setBeans(form));
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
	@RequestMapping("/admin/notice/delete_notice.htm")
	public String deleteNotice(long id) {
		// 删除类别详细
		noticeService.deleteNotice(id);
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
	@RequestMapping("/admin/notice/delete_noticeArray.htm")
	public String removeNotice(String idArray) {
		// 删除类别详细信息
		noticeService.deleteNotices(toLongArray(idArray));
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
	private void setSearchKey(NoticeForm form, NoticePage page) {
		// 设置查询条件
		page.setCurrentPage(form.getCp()); // 当前页数
		page.setTitle(form.getTitle()); 
		page.setLoginId(SecurityUtils.getLoginId());//获取登录ID
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return Notice
	 * 
	 * @Author lzn
	 * @Date 2016-01-20
	 */
	private Notice setBeans(NoticeForm form) {
		Notice notice = new Notice();
		BeanUtils.copyProperties(form, notice); // 设置表单属性
		notice.setEnabled(CommonChar.ABLED); // 设置记录有有效记录
		notice.setLoginId(SecurityUtils.getLoginId());//获取登录ID
		return notice;
	}
}