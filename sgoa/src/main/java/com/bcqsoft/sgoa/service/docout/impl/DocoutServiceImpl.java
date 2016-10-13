package com.bcqsoft.sgoa.service.docout.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.docout.DocoutDAO;
import com.bcqsoft.sgoa.dao.docout.dataobject.Docout;
import com.bcqsoft.sgoa.dao.docout.dataobject.DocoutPage;
import com.bcqsoft.sgoa.dao.docoutbox.DocoutBoxDAO;
import com.bcqsoft.sgoa.dao.docoutbox.dataobject.DocoutBox;
import com.bcqsoft.sgoa.dao.docouthistory.DocoutHistoryDAO;
import com.bcqsoft.sgoa.dao.docouthistory.dataobject.DocoutHistory;
import com.bcqsoft.sgoa.dao.docoutreview.DocoutReviewDAO;
import com.bcqsoft.sgoa.dao.docoutreview.dataobject.DocoutReview;
import com.bcqsoft.sgoa.dao.docoutreview.dataobject.DocoutReviewPage;
import com.bcqsoft.sgoa.dao.docoutstep.DocoutStepDAO;
import com.bcqsoft.sgoa.dao.docoutstep.dataobject.DocoutStep;
import com.bcqsoft.sgoa.dao.dooutinstep.DooutinStepDAO;
import com.bcqsoft.sgoa.dao.dooutinstep.dataobject.DooutinStep;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.service.docout.DocoutService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class DocoutServiceImpl extends BaseService implements DocoutService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocoutDAO docoutDAO;
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocoutHistoryDAO docoutHistoryDAO;
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocoutStepDAO docoutStepDAO;
	/**
	 * 信息审核表数据库访问DAO接口
	 */
	@Autowired
	private DocoutReviewDAO docoutReviewDAO;

	/**
	 * 办事步骤表数据库访问DAO接口
	 */
	@Autowired
	private DooutinStepDAO dooutinStepDAO;
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocoutBoxDAO docoutBoxDAO;
	
	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;
	
	/**
	 * 添加信息草稿
	 * 
	 * @param docout
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addDocoutDraftInfo(Docout docout) {
		// 设置信息状态为草稿状态
		docout.setEnabled(CommonChar.FILE_DRAFT);
		docout.setSort(CommonChar.SORT_TZ);
		docout.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = docoutDAO.insertIntoDocout(docout);
		return isInsertSucc(pk);
	}

	/**
	 * 添加信息草稿
	 * 
	 * @param docout
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateDocoutDraftInfo(Docout docout) {
		docout.setEnabled(CommonChar.FILE_DRAFT); // 设置状态为草稿
		// 更新信息信息
		Integer count = docoutDAO.updateDocoutInfoById(docout);
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
	 * @param Docout
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addDocoutInfo(Docout docout) {
		// 设置信息状态为正常状态
		docout.setEnabled(CommonChar.FILE_NORMAL);
		docout.setSort(CommonChar.SORT_TZ);
		docout.setStatus(CommonChar.STATUS_WD);
		docout.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = docoutDAO.insertIntoDocout(docout);
		// 添加这条数据的历史记录
		docoutHistoryDAO.insertIntoDocoutHistory(getDocoutHistoryByDocout(
				docout, pk));
		docoutStepDAO.insertIntoDocoutStep(getDocoutStepByDocout(docout, pk));
		
		// 添加消息提醒的信息
		if (docout.getNextOptId() != null && !"".equals(docout.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(pk);
			remind.setLoginId(docout.getNextOptId());
			remind.setModeName(CommonChar.MODE_DOCOUT);
			remind.setTitle(docout.getTitle());
			remind.setUrl("docout/edit_docout_review.htm?id="+pk);
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		return isInsertSucc(pk);
	}

	/**
	 * 拟稿的信息
	 * 
	 * @param DocoutPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public DocoutPage getMyDraftDocoutList(DocoutPage docoutPage) {
		// 根据条件查找用户信息拟稿数量
		int count = docoutDAO.findMyDraftDocoutCount(docoutPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docoutPage;
		}

		// 根据条件查找用户信息拟稿集合
		List<Docout> docoutList = docoutDAO.findMyDraftDocoutList(docoutPage);
		docoutPage.setTotalRow(count); // 拟稿总数量
		docoutPage.setDocoutList(docoutList); // 拟稿信息集合

		// 返回分页对象
		return docoutPage;
	}
	
	/**
	 * 我的已收发文信息
	 * 
	 * @param DocoutPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public DocoutPage getMyDocoutList(DocoutPage docoutPage) {
		// 根据条件查找用户信息拟稿数量
		int count = docoutDAO.findMyDocoutCount(docoutPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docoutPage;
		}

		// 根据条件查找用户信息拟稿集合
		List<Docout> docoutList = docoutDAO.findMyDocoutList(docoutPage);
		docoutPage.setTotalRow(count); // 拟稿总数量
		docoutPage.setDocoutList(docoutList); // 拟稿信息集合

		// 返回分页对象
		return docoutPage;
	}
	/**
	 * 我的申请页面
	 * 
	 * @param DocoutPage
	 * @return 分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public DocoutPage getApprovedDocoutList(DocoutPage docoutPage) {
		// 根据条件查找用户待审核信息数量
		int count = docoutDAO.findApprovedDocoutCount(docoutPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docoutPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docout> docoutList = docoutDAO.findApprovedDocoutList(docoutPage);
		docoutPage.setTotalRow(count); // 待审核总数量
		docoutPage.setDocoutList(docoutList); // 待审核信息集合

		// 返回分页对象
		return docoutPage;
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
	public boolean removeOneDocoutInfo(Long id) {
		int count = docoutDAO.updateDocoutStatusToEnabled(id);
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
	public boolean removeOneDocoutInfo(long[] longArray) {
		boolean returnValue = false;
		// 循环删除收件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = removeOneDocoutInfo(storageId);
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
	 * @return Docout
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Docout getUserDraftDocoutDetail(Long id) {
		Docout out = docoutDAO.findDocoutDetailInfoById(id);
		return out;
	}

	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Docout
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateDocoutInfo(Docout docout) {
		// 更新信息信息
		Integer count = docoutDAO.updateDocoutInfoById(docout);
		// 添加这条数据的历史记录

		docoutHistoryDAO.insertIntoDocoutHistory(getDocoutHistoryByDocout(
				docout, docout.getId()));
		docoutStepDAO.insertIntoDocoutStep(getDocoutStepByDocout(docout,
				docout.getId()));
		return isUpdateSucc(count);
	}
	
	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Docout
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public boolean updateDocoutStatusById(Docout docout){
		// 更新信息信息
		Integer count = docoutDAO.updateDocoutInfoById(docout);
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
	public boolean updateOneDocoutInfo(Long id) {
		Integer count = docoutDAO.updateOneDocoutInfo(id);

		// 添加步骤记录
		docoutStepDAO.delectIntoDocoutStepById(id);
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
	public DocoutReviewPage getDocoutReviewListById(Long id) {
		DocoutReviewPage page = new DocoutReviewPage();
		List<DocoutReview> docoutReviewList = docoutReviewDAO
				.findDocoutReviewList(id);
		page.setDocoutReviewList(docoutReviewList);
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
	public DocoutReviewPage getDocoutReviewListByIdOne(Long id) {
		DocoutReviewPage page = new DocoutReviewPage();
		List<DocoutReview> docoutReviewList = docoutReviewDAO
				.findDocoutReviewListByOne(id);
		page.setDocoutReviewList(docoutReviewList);
		return page;
	}

	/**
	 * 历史表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public DocoutHistory getDocoutHistoryByDocout(Docout docout, long pk) {
		DocoutHistory docoutHistory = new DocoutHistory();
		docoutHistory.setCurrentOptId(docout.getCurrentOptId());
		docoutHistory.setNextOptId(docout.getNextOptId());
		docoutHistory.setDocoutId(pk);
		docoutHistory.setRecordID(docout.getdRecordid());
		return docoutHistory;
	}

	/**
	 * 步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public DocoutStep getDocoutStepByDocout(Docout docout, long pk) {
		DocoutStep docoutStep = new DocoutStep();
		docoutStep.setCurrentOptId(SecurityUtils.getLoginId());
		docoutStep.setDocoutId(pk);
		docoutStep.setStep(docout.getStep() - 1);
		return docoutStep;
	}

	/**
	 * 步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public DocoutStep getDocoutStepByDocoutByStep(Docout docout, Integer step,
			long pk) {
		DocoutStep docoutStep = new DocoutStep();
		docoutStep.setCurrentOptId(docout.getCurrentOptId());
		docoutStep.setDocoutId(pk);
		docoutStep.setStep(step);
		return docoutStep;
	}

	/**
	 * 办事流程步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public DocoutStep getDocoutStepByDocoutByDo(Docout docout, long pk) {
		DocoutStep docoutStep = new DocoutStep();
		docoutStep.setCurrentOptId(docout.getCurrentOptId());
		docoutStep.setDocoutId(pk);
		docoutStep.setStep(0);
		return docoutStep;
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
	public DocoutPage getDocoutReviewList(DocoutPage docoutPage) {
		// 根据条件查找用户待审核信息数量
		int count = docoutDAO.findDocoutReviewCount(docoutPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docoutPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docout> docoutList = docoutDAO.findDocoutReviewList(docoutPage);
		docoutPage.setTotalRow(count); // 待审核总数量
		docoutPage.setDocoutList(docoutList); // 待审核信息集合

		// 返回分页对象
		return docoutPage;
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
	public DocoutPage getDocoutDoinoutList(DocoutPage docoutPage) {
		// 根据条件查找用户待审核信息数量
		int count = docoutDAO.findDocoutDoinoutCount(docoutPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docoutPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docout> docoutList = docoutDAO.findDocoutDoinoutList(docoutPage);
		docoutPage.setTotalRow(count); // 待审核总数量
		docoutPage.setDocoutList(docoutList); // 待审核信息集合

		// 返回分页对象
		return docoutPage;
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
	public DocoutPage getMyDocoutReviewList(DocoutPage docoutPage) {
		// 根据条件查找用户待审核信息数量
		int count = docoutDAO.getMyDocoutReviewCount(docoutPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docoutPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docout> docoutList = docoutDAO.getMyDocoutReviewList(docoutPage);
		docoutPage.setTotalRow(count); // 待审核总数量
		docoutPage.setDocoutList(docoutList); // 待审核信息集合

		// 返回分页对象
		return docoutPage;
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
	public boolean createDocoutReview(Docout docout) {

		Integer stepInt = 0;
		// 取得当前信息步骤表里的最大步骤
		List<DocoutStep> docoutStepList = docoutStepDAO.findAllDocoutStepById(docout.getId());
		if (docoutStepList == null || docoutStepList.size() == 0) {
			stepInt = 0;
		} else {
			Integer setpIntTemp = 0;
			for (int i = 0; i < docoutStepList.size(); i++) {
				DocoutStep docoutStep = docoutStepList.get(i);
				// 把列表中的大的值赋值给临时变量
				if (docoutStep.getStep() > setpIntTemp) {
					setpIntTemp = docoutStep.getStep();
				}
			}
			stepInt = setpIntTemp + 1;
		}
		// 数据库新增一条审核记录,并返回是否插入成功
		docout.setCurrentOptId(SecurityUtils.getLoginId());
		docout.setEnabled(1);
		docoutDAO.updateDocoutById(docout);
		Long pk = docoutReviewDAO
				.insertIntoDocoutReview(toInsterDocoutReview(docout));
		// 添加历史记录
		docoutHistoryDAO.insertIntoDocoutHistory(getDocoutHistoryByDocout(
				docout, docout.getId()));
		// 添加步骤记录
		docoutStepDAO.insertIntoDocoutStep(getDocoutStepByDocoutByStep(docout,
				stepInt, docout.getId()));
		// 批准的时候 对办事流程经行添加
		if (4 == docout.getStatus()) {
			// 转换成办事流程
			docout.setSort(2);
			docout.setSteps(1);
			// docout.setApprovalIds(approvalIds);
			docoutDAO.updateDocoutById(docout);
			docoutHistoryDAO.insertIntoDocoutHistory(getDocoutHistoryByDocout(
					docout, docout.getId()));
			docoutStepDAO.insertIntoDocoutStepByDo(getDocoutStepByDocoutByDo(
					docout, docout.getId()));

		}
		
		// 添加消息提醒的信息
		if (docout.getNextOptId() != null && !"".equals(docout.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(docout.getId());
			remind.setLoginId(docout.getNextOptId());
			remind.setModeName(CommonChar.MODE_DOCOUT);
			remind.setTitle(docout.getTitle());
			// 如果是办事流程时候
			if (4 == docout.getStatus()) {
				remind.setUrl("docout/edit_docout_work.htm?id="+docout.getId());
			} else {
				remind.setUrl("docout/edit_docout_review.htm?id="+docout.getId());
			}
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		// 此处默认返回操作成功成功
		return isInsertSucc(pk);
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return DocoutReview
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	private DocoutReview toInsterDocoutReview(Docout docout) {
		DocoutReview docoutReview = new DocoutReview();
		docoutReview.setDocoutId(docout.getId());// 获取主表ID
		docoutReview.setCurrentOptId(SecurityUtils.getLoginId());// 当前操作人
		docoutReview.setOpinion(docout.getOpinion()); // 意见
		docoutReview.setDoAction(docout.getDoAction());// 设置状态
		return docoutReview;
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
	public List<DocoutStep> getDocoutStepList(Long id) {
		List<DocoutStep> docoutStepList = docoutStepDAO
				.findAllDocoutStepById(id);
		return docoutStepList;
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
	public List<DooutinStep> getDooutinStepList(Long id) {
		List<DooutinStep> dooutinStepList = dooutinStepDAO
				.findAllDooutinStepById(id);
		return dooutinStepList;
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
	public boolean createDocoutReback(Docout docout) {
		// 数据库新增一条审核记录,并返回是否插入成功
		docout.setCurrentOptId(SecurityUtils.getLoginId());
		docout.setEnabled(1);

		docoutDAO.updateDocoutById(docout);
		Long pk = docoutReviewDAO
				.insertIntoDocoutReview(toInsterDocoutReview(docout));
		// 添加历史记录
		docoutHistoryDAO.insertIntoDocoutHistory(getDocoutHistoryByDocout(
				docout, docout.getId()));
		// 添加步骤记录
		docoutStepDAO.delectIntoDocoutStep(getDocoutStepByDocoutByStep(docout,
				docout.getStep(), docout.getId()));

		// 添加消息提醒的信息
		if (docout.getNextOptId() != null && !"".equals(docout.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(docout.getId());
			remind.setLoginId(docout.getNextOptId());
			remind.setModeName(CommonChar.MODE_DOCOUT);
			remind.setTitle(docout.getTitle());
			remind.setUrl("docout/edit_docout_review.htm?id="+docout.getId());
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
	public List<DocoutHistory> getDocoutHistoryInfo(long id) {
		List<DocoutHistory> docoutHistoryList = docoutHistoryDAO
				.findAllDocoutHistoryById(id);
		return docoutHistoryList;
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
	public DocoutPage getDocoutSearchList(DocoutPage outPage) {
		int count = docoutDAO.findDocoutSeacheCount(outPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return outPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docout> docoutList = docoutDAO.findDocoutSeacheList(outPage);
		outPage.setTotalRow(count); // 待审核总数量
		outPage.setDocoutList(docoutList); // 待审核信息
		return outPage;
	}

	/**
	 * 办事修改
	 * 
	 * @param from
	 * @param map
	 * @return 办事修改
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createDocoutWork(Docout docout) {

		Integer stepInt = 0;
		// 取得当前信息步骤表里的最大步骤
		List<DooutinStep> dooutinStepStepList = dooutinStepDAO.findAllDooutinStepById(docout.getId());
		if (dooutinStepStepList == null || dooutinStepStepList.size() == 0) {
			stepInt = 0;
		} else {
			Integer setpIntTemp = 0;
			for (int i = 0; i < dooutinStepStepList.size(); i++) {
				DooutinStep dooutinStep = dooutinStepStepList.get(i);
				// 把列表中的大的值赋值给临时变量
				if (dooutinStep.getStep() > setpIntTemp) {
					setpIntTemp = dooutinStep.getStep();
				}
			}
			stepInt = setpIntTemp + 1;
		}
		// 数据库新增一条审核记录,并返回是否插入成功
		docout.setCurrentOptId(SecurityUtils.getLoginId());
		docout.setEnabled(1);
		docoutDAO.updateDocoutWorkById(docout);
		Long pk = docoutReviewDAO
				.insertIntoDocoutReview(toInsterDocoutReview(docout));
		// 添加历史记录
		docoutHistoryDAO.insertIntoDocoutHistory(getDocoutHistoryByDocout(
				docout, docout.getId()));
		// 添加步骤记录
		dooutinStepDAO.insertIntoDooutinStep(getDooutinStepByDooutinByStep(
				docout, stepInt, docout.getId()));
		// 批准的时候 对办事流程经行添加

		if (5 == docout.getDoAction()) {
			String mainSend[] = docout.getMainSend().split(",");
			for (int i = 0; i < mainSend.length; i++) {
				DocoutBox docoutBox=new DocoutBox();
				docoutBox.setReceiverId(mainSend[i]);
				docoutBox.setDocoutId(docout.getId());
				docoutBoxDAO.addDocoutInfo(docoutBox);
			}
			String copySend[] = docout.getCopySend().split(",");
			for (int i = 0; i < copySend.length; i++) {
				DocoutBox docoutBox=new DocoutBox();
				docoutBox.setReceiverId(copySend[i]);
				docoutBox.setDocoutId(docout.getId());
				docoutBoxDAO.addDocoutInfo(docoutBox);
			}
		}
		
		// 添加消息提醒的信息
		if (docout.getNextOptId() != null && !"".equals(docout.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(docout.getId());
			remind.setLoginId(docout.getNextOptId());
			remind.setModeName(CommonChar.MODE_DOCOUT);
			remind.setTitle(docout.getTitle());
			remind.setUrl("docout/edit_docout_work.htm?id="+docout.getId());
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		// 此处默认返回操作成功成功
		return isInsertSucc(pk);
	}

	/**
	 * 步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public DooutinStep getDooutinStepByDooutinByStep(Docout docout,
			Integer step, long pk) {
		DooutinStep dooutinStep = new DooutinStep();
		dooutinStep.setCurrentOptId(docout.getCurrentOptId());
		dooutinStep.setDocoutId(pk);
		dooutinStep.setStep(step);
		return dooutinStep;
	}

	/**
	 * 返回
	 * 
	 * @param from
	 * @param map
	 * @return 返回
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	@Override
	public boolean createDooutinReback(Docout docout) {
		// 数据库新增一条审核记录,并返回是否插入成功
		docout.setCurrentOptId(SecurityUtils.getLoginId());
		// 判断当返回给拟稿人的场合设置状态为拟稿
		if (docout.getStep() == 0) {
			docout.setEnabled(2);
			docout.setNextOptId("");
		} else {
			docout.setEnabled(1);
		}

		docoutDAO.updateDocoutById(docout);
		Long pk = docoutReviewDAO
				.insertIntoDocoutReview(toInsterDocoutReview(docout));
		// 添加历史记录
		docoutHistoryDAO.insertIntoDocoutHistory(getDocoutHistoryByDocout(
				docout, docout.getId()));
		// 添加步骤记录
		dooutinStepDAO.delectIntoDooutinStep(getDooutinStepByDooutinByStep(docout,
				docout.getSteps(), docout.getId()));
		// 添加消息提醒的信息
		if (docout.getNextOptId() != null && !"".equals(docout.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(docout.getId());
			remind.setLoginId(docout.getNextOptId());
			remind.setModeName(CommonChar.MODE_DOCOUT);
			remind.setTitle(docout.getTitle());
			remind.setUrl("docout/edit_docout_work.htm?id="+docout.getId());
			remind.setStatus(CommonChar.REMIND_STATUS_TX);
			remindDAO.insertIntoRemind(remind);
		}
		// 此处默认返回操作成功成功
		return isInsertSucc(pk);
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
	@Override
	public DocoutReviewPage getDocoutReviewListByIdQf(Long id) {
		DocoutReviewPage page = new DocoutReviewPage();
		List<DocoutReview> docoutReviewList = docoutReviewDAO
				.findDocoutReviewListQf(id);
		page.setDocoutReviewList(docoutReviewList);
		return page;
	}

	/**
	 * 我的督办列表
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@Override
	public DocoutPage getMyDubanDocoutList(DocoutPage outPage) {
		int count = docoutDAO.findDocoutDubanCount(outPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return outPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docout> docoutList = docoutDAO.findDocoutDubanList(outPage);
		outPage.setTotalRow(count); // 待审核总数量
		outPage.setDocoutList(docoutList); // 待审核信息
		return outPage;
	}
	
}
