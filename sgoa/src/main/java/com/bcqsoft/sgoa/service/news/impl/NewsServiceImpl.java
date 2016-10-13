package com.bcqsoft.sgoa.service.news.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.news.NewsDAO;
import com.bcqsoft.sgoa.dao.news.dataobject.News;
import com.bcqsoft.sgoa.dao.news.dataobject.NewsPage;
import com.bcqsoft.sgoa.dao.newshistory.NewsHistoryDAO;
import com.bcqsoft.sgoa.dao.newshistory.dataobject.NewsHistory;
import com.bcqsoft.sgoa.dao.newsreview.NewsReviewDAO;
import com.bcqsoft.sgoa.dao.newsreview.dataobject.NewsReview;
import com.bcqsoft.sgoa.dao.newsreview.dataobject.NewsReviewPage;
import com.bcqsoft.sgoa.dao.newsstep.NewsStepDAO;
import com.bcqsoft.sgoa.dao.newsstep.dataobject.NewsStep;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.service.news.NewsService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class NewsServiceImpl extends BaseService implements NewsService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private NewsDAO newsDAO;
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private NewsHistoryDAO newsHistoryDAO;
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private NewsStepDAO newsStepDAO;
	/**
	 * 信息审核表数据库访问DAO接口
	 */
	@Autowired
	private NewsReviewDAO newsReviewDAO;

	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;

	/**
	 * 添加信息草稿
	 * 
	 * @param news
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addNewsDraftInfo(News news) {
		// 设置信息状态为草稿状态
		news.setEnabled(CommonChar.FILE_DRAFT);
		news.setSort(CommonChar.SORT_YQ);
		news.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = newsDAO.insertIntoNews(news);
		return isInsertSucc(pk);
	}

	/**
	 * 添加信息草稿
	 * 
	 * @param news
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateNewsDraftInfo(News news) {
		news.setEnabled(CommonChar.FILE_DRAFT); // 设置状态为草稿
		// 更新信息信息
		Integer count = newsDAO.updateNewsInfoById(news);
		return isUpdateSucc(count);
	}

	/**
	 * 添加信息数据
	 * 
	 * <pre>
	 * <li>1.将信息信息添加至信息临时表</li>
	 * <li>2.将本次提交信息添加至信息审核表</li>
	 * </pre>
	 * 
	 * @param News
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addNewsInfo(News news) {
		// 设置信息状态为正常状态
		news.setEnabled(CommonChar.FILE_NORMAL);
		news.setSort(CommonChar.SORT_YQ);
		news.setStatus(CommonChar.STATUS_WD);
		news.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = newsDAO.insertIntoNews(news);
		// 添加这条数据的历史记录
		newsHistoryDAO.insertIntoNewsHistory(getNewsHistoryByNews(news, pk));
		newsStepDAO.insertIntoNewsStep(getNewsStepByNews(news, pk));
		// 添加消息提醒的信息
		if (news.getNextOptId() != null && !"".equals(news.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(pk);
			remind.setLoginId(news.getNextOptId());
			remind.setModeName(CommonChar.MODE_NEWS);
			remind.setTitle(news.getTitle());
			remind.setUrl("news/edit_news_review.htm?id=" + pk);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		return isInsertSucc(pk);
	}

	/**
	 * 拟稿的信息
	 * 
	 * @param NewsPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public NewsPage getMyDraftNewsList(NewsPage newsPage) {
		// 根据条件查找用户信息拟稿数量
		int count = newsDAO.findMyDraftNewsCount(newsPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return newsPage;
		}

		// 根据条件查找用户信息拟稿集合
		List<News> newsList = newsDAO.findMyDraftNewsList(newsPage);
		newsPage.setTotalRow(count); // 拟稿总数量
		newsPage.setNewsList(newsList); // 拟稿信息集合

		// 返回分页对象
		return newsPage;
	}

	/**
	 * 我的申请页面
	 * 
	 * @param NewsPage
	 * @return 分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public NewsPage getApprovedNewsList(NewsPage newsPage) {
		// 根据条件查找用户待审核信息数量
		int count = newsDAO.findApprovedNewsCount(newsPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return newsPage;
		}

		// 根据条件查找用户待审核信息集合
		List<News> newsList = newsDAO.findApprovedNewsList(newsPage);
		newsPage.setTotalRow(count); // 待审核总数量
		newsPage.setNewsList(newsList); // 待审核信息集合

		// 返回分页对象
		return newsPage;
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
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean removeOneNewsInfo(Long id) {
		int count = newsDAO.updateNewsStatusToEnabled(id);
		return isUpdateSucc(count);
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
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean removeOneNewsInfo(long[] longArray) {
		boolean returnValue = false;
		// 循环删除收件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = removeOneNewsInfo(storageId);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * 
	 * @param id
	 *            信息ID
	 * @return News
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public News getUserDraftNewsDetail(Long id) {
		News out = newsDAO.findNewsDetailInfoById(id);
		return out;
	}

	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param News
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateNewsInfo(News news) {
		// 更新信息信息
		Integer count = newsDAO.updateNewsInfoById(news);
		// 添加这条数据的历史记录

		newsHistoryDAO.insertIntoNewsHistory(getNewsHistoryByNews(news,
				news.getId()));
		newsStepDAO.insertIntoNewsStep(getNewsStepByNews(news, news.getId()));
		return isUpdateSucc(count);
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
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateOneNewsInfo(Long id) {
		Integer count = newsDAO.updateOneNewsInfo(id);

		// 添加步骤记录
		newsStepDAO.delectIntoNewsStepById(id);
		return isUpdateSucc(count);
	}

	/**
	 * 查找通知公告审批表详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@Override
	public NewsReviewPage getNewsReviewListById(Long id) {
		NewsReviewPage page = new NewsReviewPage();
		List<NewsReview> newsReviewList = newsReviewDAO.findNewsReviewList(id);
		page.setNewsReviewList(newsReviewList);
		return page;
	}

	/**
	 * 查找通知公告审批表一条详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	@Override
	public NewsReviewPage getNewsReviewListByIdOne(Long id) {
		NewsReviewPage page = new NewsReviewPage();
		List<NewsReview> newsReviewList = newsReviewDAO
				.findNewsReviewListByOne(id);
		page.setNewsReviewList(newsReviewList);
		return page;
	}

	/**
	 * 历史表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public NewsHistory getNewsHistoryByNews(News news, long pk) {
		NewsHistory newsHistory = new NewsHistory();
		newsHistory.setCurrentOptId(news.getCurrentOptId());
		newsHistory.setNextOptId(news.getNextOptId());
		newsHistory.setNewsId(pk);
		newsHistory.setRecordID(news.getdRecordid());
		return newsHistory;
	}

	/**
	 * 步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public NewsStep getNewsStepByNews(News news, long pk) {
		NewsStep newsStep = new NewsStep();
		newsStep.setCurrentOptId(SecurityUtils.getLoginId());
		newsStep.setNewsId(pk);
		newsStep.setStep(news.getStep() - 1);
		return newsStep;
	}

	/**
	 * 步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public NewsStep getNewsStepByNewsByStep(News news, Integer step, long pk) {
		NewsStep newsStep = new NewsStep();
		newsStep.setCurrentOptId(news.getCurrentOptId());
		newsStep.setNewsId(pk);
		newsStep.setStep(step);
		return newsStep;
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
	@Override
	public NewsPage getNewsReviewList(NewsPage newsPage) {
		// 根据条件查找用户待审核信息数量
		int count = newsDAO.findNewsReviewCount(newsPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return newsPage;
		}

		// 根据条件查找用户待审核信息集合
		List<News> newsList = newsDAO.findNewsReviewList(newsPage);
		newsPage.setTotalRow(count); // 待审核总数量
		newsPage.setNewsList(newsList); // 待审核信息集合

		// 返回分页对象
		return newsPage;
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
	@Override
	public NewsPage getMyNewsReviewList(NewsPage newsPage) {
		// 根据条件查找用户待审核信息数量
		int count = newsDAO.getMyNewsReviewCount(newsPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return newsPage;
		}

		// 根据条件查找用户待审核信息集合
		List<News> newsList = newsDAO.getMyNewsReviewList(newsPage);
		newsPage.setTotalRow(count); // 待审核总数量
		newsPage.setNewsList(newsList); // 待审核信息集合

		// 返回分页对象
		return newsPage;
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
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createNewsReview(News news) {

		Integer stepInt = 0;
		// 取得当前信息步骤表里的最大步骤
		List<NewsStep> newsStepList = newsStepDAO.findAllNewsStepById(news
				.getId());
		if (newsStepList == null || newsStepList.size() == 0) {
			stepInt = 0;
		} else {
			Integer setpIntTemp = 0;
			for (int i = 0; i < newsStepList.size(); i++) {
				NewsStep newsStep = newsStepList.get(i);
				// 把列表中的大的值赋值给临时变量
				if (newsStep.getStep() > setpIntTemp) {
					setpIntTemp = newsStep.getStep();
				}
			}
			stepInt = setpIntTemp + 1;
		}
		// 数据库新增一条审核记录,并返回是否插入成功
		news.setCurrentOptId(SecurityUtils.getLoginId());
		news.setEnabled(1);
		newsDAO.updateNewsById(news);
		Long pk = newsReviewDAO.insertIntoNewsReview(toInsterNewsReview(news));
		// 添加历史记录
		newsHistoryDAO.insertIntoNewsHistory(getNewsHistoryByNews(news,
				news.getId()));
		// 添加步骤记录
		newsStepDAO.insertIntoNewsStep(getNewsStepByNewsByStep(news, stepInt,
				news.getId()));

		// 添加消息提醒的信息
		if (news.getNextOptId() != null && !"".equals(news.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(news.getId());
			remind.setLoginId(news.getNextOptId());
			remind.setModeName(CommonChar.MODE_NEWS);
			remind.setTitle(news.getTitle());
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remind.setUrl("news/edit_news_review.htm?id=" + news.getId());
			remindDAO.insertIntoRemind(remind);
		}
		// 此处默认返回操作成功成功
		return isInsertSucc(pk);
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return NewsReview
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	private NewsReview toInsterNewsReview(News news) {
		NewsReview newsReview = new NewsReview();
		newsReview.setNewsId(news.getId());// 获取主表ID
		newsReview.setCurrentOptId(SecurityUtils.getLoginId());// 当前操作人
		newsReview.setOpinion(news.getOpinion()); // 意见
		newsReview.setDoAction(news.getDoAction());// 设置状态
		return newsReview;
	}

	/**
	 * 返回跳转
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	@Override
	public List<NewsStep> getNewsStepList(Long id) {
		List<NewsStep> newsStepList = newsStepDAO.findAllNewsStepById(id);
		return newsStepList;
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
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createNewsReback(News news) {
		// 数据库新增一条审核记录,并返回是否插入成功
		news.setCurrentOptId(SecurityUtils.getLoginId());
		news.setEnabled(1);

		newsDAO.updateNewsById(news);
		Long pk = newsReviewDAO.insertIntoNewsReview(toInsterNewsReview(news));
		// 添加历史记录
		newsHistoryDAO.insertIntoNewsHistory(getNewsHistoryByNews(news,
				news.getId()));
		// 添加步骤记录
		newsStepDAO.delectIntoNewsStep(getNewsStepByNewsByStep(news,
				news.getStep(), news.getId()));

		// 添加消息提醒的信息
		if (news.getNextOptId() != null && !"".equals(news.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(news.getId());
			remind.setLoginId(news.getNextOptId());
			remind.setModeName(CommonChar.MODE_NEWS);
			remind.setTitle(news.getTitle());
			remind.setUrl("news/edit_news_review.htm?id=" + news.getId());
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		// 此处默认返回操作成功成功
		return isInsertSucc(pk);
	}

	/**
	 * 跳转至历史记录页面
	 * 
	 * @return 历史记录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@Override
	public List<NewsHistory> getNewsHistoryInfo(long id) {
		List<NewsHistory> newsHistoryList = newsHistoryDAO
				.findAllNewsHistoryById(id);
		return newsHistoryList;
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
	public NewsPage getNewsSearchList(NewsPage outPage) {
		int count = newsDAO.findNewsSeacheCount(outPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return outPage;
		}

		// 根据条件查找用户待审核信息集合
		List<News> newsList = newsDAO.findNewsSeacheList(outPage);
		outPage.setTotalRow(count); // 待审核总数量
		outPage.setNewsList(newsList); // 待审核信息
		return outPage;
	}

	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param News
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public boolean updateNewsStatusById(News news) {
		int count = newsDAO.updateNewsStatusById(news);
		return isUpdateSucc(count);
	}
}