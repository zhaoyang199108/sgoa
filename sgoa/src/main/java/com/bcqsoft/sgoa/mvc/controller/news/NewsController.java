package com.bcqsoft.sgoa.mvc.controller.news;

import static com.bcqsoft.sgoa.common.util.ArrayUtil.toLongArray;
import static com.bcqsoft.sgoa.core.security.SecurityUtils.getLoginId;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.approval.dataobject.ApprovalPage;
import com.bcqsoft.sgoa.dao.approvaldetail.dataobject.ApprovalDetail;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.news.dataobject.News;
import com.bcqsoft.sgoa.dao.news.dataobject.NewsPage;
import com.bcqsoft.sgoa.dao.newshistory.dataobject.NewsHistory;
import com.bcqsoft.sgoa.dao.newslook.dataobject.NewsLook;
import com.bcqsoft.sgoa.dao.newsreview.dataobject.NewsReviewPage;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.dao.user.dataobject.User;
import com.bcqsoft.sgoa.mvc.form.news.NewsForm;
import com.bcqsoft.sgoa.service.approval.ApprovalService;
import com.bcqsoft.sgoa.service.approvaldetail.ApprovalDetailService;
import com.bcqsoft.sgoa.service.common.CommonService;
import com.bcqsoft.sgoa.service.dept.DeptService;
import com.bcqsoft.sgoa.service.news.NewsService;
import com.bcqsoft.sgoa.service.newslook.NewsLookService;
import com.bcqsoft.sgoa.service.user.UserService;

/**
 * 信息控制器
 */
@Controller
public class NewsController {

	/**
	 * 部门模块业务逻辑类接口
	 */
	@Autowired
	private DeptService deptService;

	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private NewsService newsService;

	/**
	 * 共通逻辑类接口
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * 流程审批表的业务逻辑层
	 */
	@Autowired
	private ApprovalService approvalService;

	/**
	 * 流程审批详细表的业务逻辑层
	 */
	@Autowired
	private ApprovalDetailService approvalDetailService;
	/**
	 * 信息模块业务逻辑类接口
	 */
	@Autowired
	private NewsLookService newsLookService;
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
	@RequestMapping(value = "/news/add_news.htm", method = RequestMethod.GET)
	public String addNews(ModelMap map) {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("J");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("d_userName", SecurityUtils.getLoginId());
		map.put("d_fileType", "doc");
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "add_news");
		// 跳转至信息拟稿页面
		return "/news/add_news";
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
	@RequestMapping(value = "/news/add_news.htm", method = RequestMethod.POST)
	public String addNews(NewsForm form, ModelMap map) {
		// 信息临时表中添加数据
		newsService.addNewsInfo(setBeans(form));
		map.put("sort", CommonChar.SORT_YQ); // 分类

		// 跳转至信息拟稿页面
		return "/news/add_success";
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
	@RequestMapping(value = "/news/draft_news.htm", method = RequestMethod.POST)
	public String draftNews(NewsForm form, boolean edit, ModelMap map) {
		// 根据参数edit判断是否更新
		if (edit) {
			newsService.updateNewsDraftInfo(setBeans(form));
		} else {
			newsService.addNewsDraftInfo(setBeans(form));
		}
		map.put("sort", CommonChar.SORT_YQ); // 分类
		// 跳转至信息拟稿页面
		return "/news/draft_success";
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
	@RequestMapping(value = "/news/my_draft_list.htm", method = RequestMethod.GET)
	public String myDraftList(NewsForm outForm,int sort, ModelMap map) {
		NewsPage outPage = new NewsPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage,sort); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置拟稿人为当前用户ID

		// 根据用户ID查找该用户拟稿的信息
		map.put("page", newsService.getMyDraftNewsList(outPage));
		map.put("sort", sort); // 分类
		
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_draft_list");
		// 跳转至信息列表页面
		return "/news/my_draft_list";
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
	@RequestMapping(value = "/news/list.htm", method = RequestMethod.GET)
	public String newsList(NewsForm outForm, int sort,ModelMap map) {
		NewsPage outPage = new NewsPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage, sort); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", newsService.getApprovedNewsList(outPage));
		map.put("sort", sort); // 分类
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "list");
		// 跳转至信息列表页面
		return "/news/news_list";
	}

	/**
	 * 待审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/news/news_review_list.htm", method = RequestMethod.GET)
	public String newsReviewList(NewsForm outForm, int sort,ModelMap map) {
		NewsPage outPage = new NewsPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage, sort); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", newsService.getNewsReviewList(outPage));

		map.put("pageButtonName", commonService.getButtonName(
				CommonChar.MODULE_NEWS, CommonChar.MODULE_TYPE_LIST));
		map.put("sort", sort); // 分类
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "news_review_list");
		// 跳转至信息列表页面
		return "/news/news_review_list";
	}

	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/news/news_search.htm", method = RequestMethod.GET)
	public String newsSearchList(NewsForm outForm, ModelMap map) {
		NewsPage outPage = new NewsPage();
		setSearchKey(outForm, outPage); // 设置查询条件
		outPage.setTitle(outForm.getTitle());
		outPage.setSort(CommonChar.SORT_YQ);
		outPage.setStatus(CommonChar.ACTION_PZ);
		// 根据用户ID查找该待该用户审批的信息
		map.put("page", newsService.getNewsSearchList(outPage));
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "news_search");
		return "/news/news_search_list";
	}

	/**
	 * 经我审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@RequestMapping(value = "/news/my_news_list.htm", method = RequestMethod.GET)
	public String myNewsReviewList(NewsForm outForm, int sort, ModelMap map) {
		NewsPage outPage = new NewsPage();
		// 根据页面输入的查询条件进行查询, 初次访问全部查询
		setSearchKey(outForm, outPage, sort); // 设置查询条件
		outPage.setDraftsId(getLoginId()); // 设置当前操作人为当前用户ID

		// 根据用户ID查找该待该用户审批的信息
		map.put("page", newsService.getMyNewsReviewList(outPage));
		map.put("sort", sort); // 分类
		// 左侧菜单点击后高亮显示
		map.put("menuHighLight", "my_news_list");
		// 跳转至信息列表页面
		return "/news/my_news_list";
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
	@RequestMapping(value = "/news/del_news.htm", method = RequestMethod.GET)
	public String deleteNews(Long id) {
		newsService.removeOneNewsInfo(id);
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
	@RequestMapping("/news/delete_newsArray.htm")
	public String deleteNews(String idArray) {
		// 删除收件箱信息
		newsService.removeOneNewsInfo(toLongArray(idArray));
		// 返回到操作成功页面
		return "common/action_succ";
	}

	/**
	 * 根据信息ID撤销该条信息记录
	 * 
	 * 
	 * @param Long
	 *            信息ID
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@RequestMapping(value = "/news/news_back.htm", method = RequestMethod.GET)
	public String backNews(Long id) {
		newsService.updateOneNewsInfo(id);
		return "/common/action_succ";
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
	@RequestMapping(value = "/news/detail.htm", method = RequestMethod.GET)
	public String newsDetail(Long id, ModelMap map) throws Exception {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("J");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		News news = newsService.getUserDraftNewsDetail(id);
		map.put("news", news);

		NewsReviewPage page = newsService.getNewsReviewListById(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("page", page);
		return "/news/news_detail";
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
	@RequestMapping(value = "/news/edit_news.htm", method = RequestMethod.GET)
	public String editNews(Long id, ModelMap map) {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("J");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());
		News news = newsService.getUserDraftNewsDetail(id);
		// 取得页面下拉框数据
		map.put("news", news);
		map.put("loginId", getLoginId()); // 当前登录ID
		// 跳转至信息拟稿页面
		return "/news/edit_news";
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
	@RequestMapping(value = "/news/edit_news.htm", method = RequestMethod.POST)
	public String editNews(NewsForm form, ModelMap map) {
		newsService.updateNewsInfo(setBeans(form));
		map.put("sort", CommonChar.SORT_YQ); // 分类
		// 跳转至拟稿成功页面
		return "/news/add_success";
	}

	/**
	 * 跳转到提交审核页面
	 * 
	 * @param id
	 * @param map
	 * @return 提交审核页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/news/edit_news_review.htm", method = RequestMethod.GET)
	public String newsReviewEdit(Long id, ModelMap map) throws Exception {
		String department = SecurityUtils.getLoginId();
		Dept dept = new Dept();
		dept = deptService.findDeptInfoByLoginId(department);
		map.put("dept", dept);
		map.put("user", commonService.getCurrentUserInfo()); // 当前登录用户

		ApprovalPage approvalPage = new ApprovalPage();
		approvalPage.setApprovalType("J");
		map.put("approvalList", approvalService.getApprovalList(approvalPage)
				.getApprovalList());

		// 用户查看自己的详细信息
		News news = newsService.getUserDraftNewsDetail(id);

		User user = userService.getUserInfoByLoginId(department);
		// 查出流程ID
		String approvalId = news.getApprovalId();
		// 实例流程详细表对象
		ApprovalDetail approvalDetail = new ApprovalDetail();
		// 把流程ID赋值给流程详细表的流程ID
		approvalDetail.setDetailId(approvalId);
		// 吧步骤赋值给流程详细表的步骤
		approvalDetail.setPositionId(user.getPositionId());
		// 获取流程详细表的对象
		ApprovalDetail approvalDetailFor = approvalDetailService
				.getApprovalDetailForList(approvalDetail);
		// 查出流程详细表审批权限
		String approvalDetailForStatus = approvalDetailFor == null ? "N"
				: approvalDetailFor.getStatus();
		map.put("approvalDetailForStatus", approvalDetailForStatus);
		// 判断是否有下一步
		ApprovalDetail approvalDetailForNext = new ApprovalDetail();
		approvalDetailForNext.setId(approvalDetailFor.getId());
		approvalDetailForNext.setDetailId(approvalId);
		List<ApprovalDetail> approvalDetailList = approvalDetailService
				.getApprovalDetailForIdByPId(approvalDetailForNext);
		Integer stepNext = null;
		if (approvalDetailList != null && approvalDetailList.size() != 0) {
			stepNext = approvalDetailList.size();
		}
		map.put("stepNext", stepNext);

		map.put("approvalDetailId", approvalDetailFor.getId());

		map.put("news", news);
		NewsReviewPage page = newsService.getNewsReviewListById(id);

		// Dept dept = deptService.findDeptInfoByLoginId(loginId);
		// map.put("deptId", dept == null ? "" : dept.getId()); // 部门id
		map.put("userName", user == null ? "" : user.getUserName()); // 设置拟稿人名称;
		// 设置历史表文件的唯一ID
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		map.put("d_recordId", formatter.format(cal.getTime()));
		map.put("page", page);
		map.put("loginId", SecurityUtils.getLoginId());
		map.put("opinionId", "MS" + DateUtil.getDateTimeForYh());
		map.put("pageButtonName", commonService.getButtonName(
				CommonChar.MODULE_NEWS, CommonChar.MODULE_TYPE_REVIEW));
		// 更新状态为已读
		news.setStatus(CommonChar.STATUS_YD);
		newsService.updateNewsStatusById(news);

		NewsReviewPage onePage = newsService.getNewsReviewListByIdOne(id);
		map.put("onePage", onePage);

		// 消息提醒更新、当点击审核按钮时更新消息提醒状态为不提醒
		Remind remind = new Remind();
		remind.setBusId(news.getId());
		remind.setModeName(CommonChar.MODE_NEWS);
		remind.setLoginId(SecurityUtils.getLoginId());
		remind.setStatus(CommonChar.REMIND_STATUS_BTX);
		commonService.updateRemindInfoByLoginId(remind);

		return "/news/review_news";
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
	@RequestMapping(value = "/news/content_detail.htm", method = RequestMethod.GET)
	public String contentNews(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/news/content_news";
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
	@RequestMapping(value = "/news/content_history.htm", method = RequestMethod.GET)
	public String contentNewsHistory(String dRecordid, ModelMap map) {
		map.put("d_recordId", dRecordid);
		// 跳转至信息拟稿页面
		return "/news/content_history";
	}

	/**
	 * 通知公告表审批修改
	 * 
	 * @param from
	 * @param map
	 * @return 通知公告表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/news/add_news_review.htm")
	public String newsReviewEdit(NewsForm form, ModelMap map) {
		newsService.createNewsReview(setBeans(form));
		map.put("sort", CommonChar.SORT_YQ); // 分类
		// 返回到操作成功页面
		return "/news/review_success";

	}

	/**
	 * 通知公告表返回
	 * 
	 * @param from
	 * @param map
	 * @return 通知公告
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping("/news/news_reback.htm")
	public String newsReback(NewsForm form, ModelMap map) {
		newsService.createNewsReback(setBeans(form));
		map.put("sort", CommonChar.SORT_YQ); // 分类
		// 返回到操作成功页面
		return "/news/review_success";

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
	private void setSearchKey(NewsForm form, NewsPage newsPage,int sort) {
		// 设置查询条件
		newsPage.setCurrentPage(form.getCp()); // 当前页数
		newsPage.setTitle(form.getTitle()); // 标题
		newsPage.setSort(CommonChar.SORT_YQ); // 分类
		newsPage.setStatus(form.getStatus()); // 当前状态
		newsPage.setDraftsDeptId(form.getDraftsDeptId()); // 拟稿部门
		newsPage.setEnabled(form.getEnabled()); // 文件状态
	}

	private void setSearchKey(NewsForm form, NewsPage newsPage) {
		// 设置查询条件
		newsPage.setCurrentPage(form.getCp()); // 当前页数
		newsPage.setTitle(form.getTitle()); // 标题
		newsPage.setSort(CommonChar.SORT_YQ); // 分类
		newsPage.setStatus(form.getStatus()); // 当前状态
		newsPage.setDraftsDeptId(form.getDraftsDeptId()); // 拟稿部门
		newsPage.setEnabled(form.getEnabled()); // 文件状态
		
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
	private News setBeans(NewsForm form) {
		News news = new News();
		BeanUtils.copyProperties(form, news); // 设置表单属性
		return news;
	}

	/**
	 * 跳转至历史记录页面
	 * 
	 * @return 历史记录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@RequestMapping(value = "/news/news_history.htm", method = RequestMethod.GET)
	public String grpoDetail(long id, ModelMap map) {
		// 取得分组权限详细页面
		List<NewsHistory> newsHistoryList = newsService.getNewsHistoryInfo(id);
		map.put("newsId", id);
		map.put("newsHistoryList", newsHistoryList);
		return "news/news_history";
	}

	/**
	 * 点击查看通知表
	 * 
	 * @param id
	 * @param map
	 * @return 通知表详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@RequestMapping(value = "/news/look_detail.htm", method = RequestMethod.GET)
	public String newsLookDetail(Long id, ModelMap map) throws Exception {

		// 获取当前登录ID
		String loginId = SecurityUtils.getLoginId();
		if (loginId == null || "".equals(loginId)
				|| "anonymousUser".equals(loginId)) {
			return "/common/no_auth";
		}
		NewsLook newsForList = new NewsLook();
		newsForList.setLoginId(loginId);
		newsForList.setNewsId(id);
		List<NewsLook> newsLookList = newsLookService
				.getAllNewsLookList(newsForList);
		Integer count = newsLookList.size();
		if (count == 0) {
			NewsLook newsLook = new NewsLook();
			newsLook.setLoginId(loginId);
			newsLook.setNewsId(id);
			newsLookService.addNewsInfo(newsLook);
		}
		List<NewsLook> newsLookListForAll = newsLookService
				.getAllNewsLookListAll(id);
		map.put("newsLookListForAll", newsLookListForAll);

		News news = newsService.getUserDraftNewsDetail(id);
		map.put("news", news);
		NewsReviewPage page = newsService.getNewsReviewListById(id);
		// 获取申请的状态 ，如果是草稿箱就直接查看， 如果是申请就进入流程
		map.put("page", page);
		return "/news/news_look_detail";
	}
}