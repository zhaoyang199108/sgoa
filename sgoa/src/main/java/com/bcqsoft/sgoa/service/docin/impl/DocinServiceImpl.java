package com.bcqsoft.sgoa.service.docin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcqsoft.sgoa.common.charactor.CommonChar;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.core.security.SecurityUtils;
import com.bcqsoft.sgoa.dao.docin.DocinDAO;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docin.dataobject.DocinPage;
import com.bcqsoft.sgoa.dao.docinbox.DocinBoxDAO;
import com.bcqsoft.sgoa.dao.docinbox.dataobject.DocinBox;
import com.bcqsoft.sgoa.dao.docinfj.DocinFjDAO;
import com.bcqsoft.sgoa.dao.docinfj.dataobject.DocinFj;
import com.bcqsoft.sgoa.dao.docinhistory.DocinHistoryDAO;
import com.bcqsoft.sgoa.dao.docinhistory.dataobject.DocinHistory;
import com.bcqsoft.sgoa.dao.docinreview.DocinReviewDAO;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReview;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReviewPage;
import com.bcqsoft.sgoa.dao.docinstep.DocinStepDAO;
import com.bcqsoft.sgoa.dao.docinstep.dataobject.DocinStep;
import com.bcqsoft.sgoa.dao.doinoutstep.DoinoutStepDAO;
import com.bcqsoft.sgoa.dao.doinoutstep.dataobject.DoinoutStep;
import com.bcqsoft.sgoa.dao.remind.RemindDAO;
import com.bcqsoft.sgoa.dao.remind.dataobject.Remind;
import com.bcqsoft.sgoa.service.docin.DocinService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class DocinServiceImpl extends BaseService implements DocinService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocinDAO docinDAO;
	
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocinFjDAO docinFjDAO;
	
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocinHistoryDAO docinHistoryDAO;
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocinStepDAO docinStepDAO;
	/**
	 * 信息审核表数据库访问DAO接口
	 */
	@Autowired
	private DocinReviewDAO docinReviewDAO;

	/**
	 * 办事步骤表数据库访问DAO接口
	 */
	@Autowired
	private DoinoutStepDAO doinoutStepDAO;
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocinBoxDAO docinBoxDAO;
	
	/**
	 * 信息提醒数据库访问DAO接口
	 */
	@Autowired
	private RemindDAO remindDAO;
	
	/**
	 * 添加信息草稿
	 * 
	 * @param docin
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addDocinDraftInfo(Docin docin) {
		// 设置信息状态为草稿状态
		docin.setEnabled(CommonChar.FILE_DRAFT);
		docin.setSort(CommonChar.SORT_TZ);
		docin.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = docinDAO.insertIntoDocin(docin);
		return isInsertSucc(pk);
	}

	/**
	 * 添加信息草稿
	 * 
	 * @param docin
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateDocinDraftInfo(Docin docin) {
		docin.setEnabled(CommonChar.FILE_DRAFT); // 设置状态为草稿
		// 更新信息信息
		Integer count = docinDAO.updateDocinInfoById(docin);
		return isUpdateSucc(count);
	}
	
	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Docin
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public boolean updateDocinStatusById(Docin docin) {
		// 更新信息信息
		Integer count = docinDAO.updateDocinStatusById(docin);
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
	 * @param Docin
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean addDocinInfo(Docin docin) {
		// 设置信息状态为正常状态
		docin.setEnabled(CommonChar.FILE_NORMAL);
		docin.setSort(CommonChar.SORT_TZ);
		docin.setStatus(CommonChar.STATUS_WD);
		docin.setCurrentOptId(SecurityUtils.getLoginId());
		Long pk = docinDAO.insertIntoDocin(docin);
		// 添加这条数据的历史记录
		docinHistoryDAO.insertIntoDocinHistory(getDocinHistoryByDocin(
				docin, pk));
		docinStepDAO.insertIntoDocinStep(getDocinStepByDocin(docin, pk));
		// 添加消息提醒的信息
		if (docin.getNextOptId() != null && !"".equals(docin.getNextOptId())) {
			
			String[] nextOptIds = docin.getNextOptId().split(",");
			for (String nextOptIdStr : nextOptIds) {
				Remind remind = new Remind();
				remind.setBusId(pk);
				remind.setLoginId(nextOptIdStr);
				remind.setModeName(CommonChar.MODE_DOCIN);
				remind.setTitle(docin.getTitle());
				remind.setUrl("docin/edit_docin_review.htm?id="+pk);
				remind.setStatus(CommonChar.REMIND_STATUS_TX);
				remindDAO.insertIntoRemind(remind);
			}
		}
		
		String srcFileNames[] = docin.getSrcFileName().split(",");
		String fileDirs[] = docin.getFileDir().split(",");
		for (int i = 0; i < srcFileNames.length; i++) {
			DocinFj docinFj= new DocinFj();
			docinFj.setDocinId(docin.getId());
			docinFj.setSrcFileName(srcFileNames[i]);
			docinFj.setFileDir(fileDirs[i]);
			docinFjDAO.insertIntoDocinFj(docinFj);
		}
		return isInsertSucc(pk);
	}

	/**
	 * 拟稿的信息
	 * 
	 * @param DocinPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public DocinPage getMyDraftDocinList(DocinPage docinPage) {
		// 根据条件查找用户信息拟稿数量
		int count = docinDAO.findMyDraftDocinCount(docinPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docinPage;
		}

		// 根据条件查找用户信息拟稿集合
		List<Docin> docinList = docinDAO.findMyDraftDocinList(docinPage);
		docinPage.setTotalRow(count); // 拟稿总数量
		docinPage.setDocinList(docinList); // 拟稿信息集合

		// 返回分页对象
		return docinPage;
	}
	
	/**
	 * 我的已收收文信息
	 * 
	 * @param DocinPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public DocinPage getMyDocinList(DocinPage docinPage) {
		// 根据条件查找用户信息拟稿数量
		int count = docinDAO.findMyDocinCount(docinPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docinPage;
		}

		// 根据条件查找用户信息拟稿集合
		List<Docin> docinList = docinDAO.findMyDocinList(docinPage);
		docinPage.setTotalRow(count); // 拟稿总数量
		docinPage.setDocinList(docinList); // 拟稿信息集合

		// 返回分页对象
		return docinPage;
	}
	/**
	 * 我的申请页面
	 * 
	 * @param DocinPage
	 * @return 分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public DocinPage getApprovedDocinList(DocinPage docinPage) {
		// 根据条件查找用户待审核信息数量
		int count = docinDAO.findApprovedDocinCount(docinPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docinPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docin> docinList = docinDAO.findApprovedDocinList(docinPage);
		docinPage.setTotalRow(count); // 待审核总数量
		docinPage.setDocinList(docinList); // 待审核信息集合

		// 返回分页对象
		return docinPage;
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
	public boolean removeOneDocinInfo(Long id) {
		int count = docinDAO.updateDocinStatusToEnabled(id);
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
	public boolean removeOneDocinInfo(long[] longArray) {
		boolean returnValue = false;
		// 循环删除收件箱
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = removeOneDocinInfo(storageId);
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
	 * @return Docin
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Docin getUserDraftDocinDetail(Long id) {
		Docin out = docinDAO.findDocinDetailInfoById(id);
		return out;
	}

	/**
	 * 更新信息数据
	 * 
	 * 
	 * @param Docin
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean updateDocinInfo(Docin docin) {
		// 更新信息信息
		Integer count = docinDAO.updateDocinInfoById(docin);
		// 添加这条数据的历史记录

		docinHistoryDAO.insertIntoDocinHistory(getDocinHistoryByDocin(
				docin, docin.getId()));
		docinStepDAO.insertIntoDocinStep(getDocinStepByDocin(docin,
				docin.getId()));
		
		String srcFileNames[] = docin.getSrcFileName().split(",");
		String fileDirs[] = docin.getFileDir().split(",");
		for (int i = 0; i < srcFileNames.length; i++) {
			DocinFj docinFj= new DocinFj();
			docinFj.setDocinId(docin.getId());
			docinFj.setSrcFileName(srcFileNames[i]);
			docinFj.setFileDir(fileDirs[i]);
			docinFjDAO.insertIntoDocinFj(docinFj);
		}
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
	public boolean updateOneDocinInfo(Long id) {
		Integer count = docinDAO.updateOneDocinInfo(id);

		// 添加步骤记录
		docinStepDAO.delectIntoDocinStepById(id);
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
	public DocinReviewPage getDocinReviewListById(Long id) {
		DocinReviewPage page = new DocinReviewPage();
		List<DocinReview> docinReviewList = docinReviewDAO
				.findDocinReviewList(id);
		page.setDocinReviewList(docinReviewList);
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
	public DocinReviewPage getDocinReviewListByIdOne(Long id) {
		DocinReviewPage page = new DocinReviewPage();
		List<DocinReview> docinReviewList = docinReviewDAO
				.findDocinReviewListByOne(id);
		page.setDocinReviewList(docinReviewList);
		return page;
	}

	/**
	 * 历史表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public DocinHistory getDocinHistoryByDocin(Docin docin, long pk) {
		DocinHistory docinHistory = new DocinHistory();
		docinHistory.setCurrentOptId(docin.getCurrentOptId());
		docinHistory.setNextOptId(docin.getNextOptId());
		docinHistory.setDocinId(pk);
		docinHistory.setRecordID(docin.getdRecordid());
		return docinHistory;
	}

	/**
	 * 步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public DocinStep getDocinStepByDocin(Docin docin, long pk) {
		DocinStep docinStep = new DocinStep();
		docinStep.setCurrentOptId(SecurityUtils.getLoginId());
		docinStep.setDocinId(pk);
		docinStep.setStep(docin.getStep() - 1);
		return docinStep;
	}

	/**
	 * 步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public DocinStep getDocinStepByDocinByStep(Docin docin, Integer step,
			long pk) {
		DocinStep docinStep = new DocinStep();
		docinStep.setCurrentOptId(docin.getCurrentOptId());
		docinStep.setDocinId(pk);
		docinStep.setStep(step);
		return docinStep;
	}

	/**
	 * 办事流程步骤表字段的生成
	 * 
	 * @Author Bcqsoft.com sbq
	 */
	public DocinStep getDocinStepByDocinByDo(Docin docin, long pk) {
		DocinStep docinStep = new DocinStep();
		docinStep.setCurrentOptId(docin.getCurrentOptId());
		docinStep.setDocinId(pk);
		docinStep.setStep(0);
		return docinStep;
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
	public DocinPage getDocinReviewList(DocinPage docinPage) {
		// 根据条件查找用户待审核信息数量
		int count = docinDAO.findDocinReviewCount(docinPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docinPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docin> docinList = docinDAO.findDocinReviewList(docinPage);
		docinPage.setTotalRow(count); // 待审核总数量
		docinPage.setDocinList(docinList); // 待审核信息集合

		// 返回分页对象
		return docinPage;
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
	public DocinPage getDocinDoinoutList(DocinPage docinPage) {
		// 根据条件查找用户待审核信息数量
		int count = docinDAO.findDocinDoinoutCount(docinPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docinPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docin> docinList = docinDAO.findDocinDoinoutList(docinPage);
		docinPage.setTotalRow(count); // 待审核总数量
		docinPage.setDocinList(docinList); // 待审核信息集合

		// 返回分页对象
		return docinPage;
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
	public DocinPage getMyDocinReviewList(DocinPage docinPage) {
		// 根据条件查找用户待审核信息数量
		int count = docinDAO.getMyDocinReviewCount(docinPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docinPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docin> docinList = docinDAO.getMyDocinReviewList(docinPage);
		docinPage.setTotalRow(count); // 待审核总数量
		docinPage.setDocinList(docinList); // 待审核信息集合

		// 返回分页对象
		return docinPage;
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
	public boolean createDocinReview(Docin docin) {

		Integer stepInt = 0;
		// 取得当前信息步骤表里的最大步骤
		List<DocinStep> docinStepList = docinStepDAO.findAllDocinStepById(docin.getId());
		if (docinStepList == null || docinStepList.size() == 0) {
			stepInt = 0;
		} else {
			Integer setpIntTemp = 0;
			for (int i = 0; i < docinStepList.size(); i++) {
				DocinStep docinStep = docinStepList.get(i);
				// 把列表中的大的值赋值给临时变量
				if (docinStep.getStep() > setpIntTemp) {
					setpIntTemp = docinStep.getStep();
				}
			}
			stepInt = setpIntTemp + 1;
		}
		// 数据库新增一条审核记录,并返回是否插入成功
		docin.setCurrentOptId(SecurityUtils.getLoginId());
		docin.setEnabled(1);
		docinDAO.updateDocinById(docin);
		
		// 添加历史记录
		docinHistoryDAO.insertIntoDocinHistory(getDocinHistoryByDocin(
				docin, docin.getId()));
		// 添加步骤记录
		Long pkStep = docinStepDAO.insertIntoDocinStep(getDocinStepByDocinByStep(docin,
				stepInt, docin.getId()));
		//添加收件人表
		if (5 == docin.getDoAction()) {
			String mainSend[] = docin.getReceiverId().split(",");
			for (int i = 0; i < mainSend.length; i++) {
				DocinBox docinBox=new DocinBox();
				docinBox.setReceiverId(mainSend[i]);
				docinBox.setDocinId(docin.getId());
				docinBoxDAO.addDocinInfo(docinBox);
			}
		}
		// 批准的时候 对办事流程经行添加
		if (4 == docin.getStatus()) {
			// 转换成办事流程
			docin.setSort(2);
			docin.setSteps(1);
			// docin.setApprovalIds(approvalIds);
			docinDAO.updateDocinById(docin);
			docinHistoryDAO.insertIntoDocinHistory(getDocinHistoryByDocin(
					docin, docin.getId()));
			docinStepDAO.insertIntoDocinStepByDo(getDocinStepByDocinByDo(
					docin, docin.getId()));

		}
		// 添加消息提醒的信息
		if (docin.getNextOptId() != null && !"".equals(docin.getNextOptId())) {
			// 添加消息提醒的信息
			String[] optIdStr = docin.getNextOptId().split(",");
			for (String str : optIdStr) {
				Remind remind = new Remind();
				remind.setBusId(docin.getId());
				remind.setLoginId(str);
				remind.setModeName(CommonChar.MODE_DOCIN);
				remind.setTitle(docin.getTitle());
				// 如果是办事流程时候
				if (4 == docin.getStatus()) {
					remind.setUrl("docin/edit_docin_work.htm?id="+docin.getId());
				} else {
					remind.setUrl("docin/edit_docin_review.htm?id="+docin.getId());
				}
				remind.setStatus(CommonChar.REMIND_STATUS_TX);
				remindDAO.insertIntoRemind(remind);
			}
		}
		// 此处默认返回操作成功成功
		return isInsertSucc(pkStep);
	}

	/**
	 * 设置表单属性
	 * 
	 * @param form
	 * @return DocinReview
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	private DocinReview toInsterDocinReview(Docin docin) {
		DocinReview docinReview = new DocinReview();
		docinReview.setDocinId(docin.getId());// 获取主表ID
		docinReview.setCurrentOptId(SecurityUtils.getLoginId());// 当前操作人
		docinReview.setOpinion(docin.getOpinion()); // 意见
		docinReview.setDoAction(docin.getDoAction());// 设置状态
		return docinReview;
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
	public List<DocinStep> getDocinStepList(Long id) {
		List<DocinStep> docinStepList = docinStepDAO
				.findAllDocinStepById(id);
		return docinStepList;
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
	public List<DoinoutStep> getDoinoutStepList(Long id) {
		List<DoinoutStep> doinoutStepList = doinoutStepDAO
				.findAllDoinoutStepById(id);
		return doinoutStepList;
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
	public boolean createDocinReback(Docin docin) {
		// 数据库新增一条审核记录,并返回是否插入成功
		docin.setCurrentOptId(SecurityUtils.getLoginId());
		docin.setEnabled(1);

		docinDAO.updateDocinById(docin);
		Long pk = docinReviewDAO
				.insertIntoDocinReview(toInsterDocinReview(docin));
		// 添加历史记录
		docinHistoryDAO.insertIntoDocinHistory(getDocinHistoryByDocin(
				docin, docin.getId()));
		// 添加步骤记录
		docinStepDAO.delectIntoDocinStep(getDocinStepByDocinByStep(docin,
				docin.getStep(), docin.getId()));
		// 添加消息提醒的信息
		// 添加消息提醒的信息
		if (docin.getNextOptId() != null && !"".equals(docin.getNextOptId())) {
			Remind remind = new Remind();
			remind.setBusId(docin.getId());
			remind.setLoginId(docin.getNextOptId());
			remind.setModeName(CommonChar.MODE_DOCIN);
			remind.setTitle(docin.getTitle());
			remind.setUrl("docin/edit_docin_review.htm?id="+docin.getId());
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
	public List<DocinHistory> getDocinHistoryInfo(long id) {
		List<DocinHistory> docinHistoryList = docinHistoryDAO
				.findAllDocinHistoryById(id);
		return docinHistoryList;
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
	public DocinPage getDocinSearchList(DocinPage outPage) {
		int count = docinDAO.findDocinSeacheCount(outPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return outPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docin> docinList = docinDAO.findDocinSeacheList(outPage);
		outPage.setTotalRow(count); // 待审核总数量
		outPage.setDocinList(docinList); // 待审核信息
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
	public boolean createDocinWork(Docin docin) {

		Integer stepInt = 0;
		// 取得当前信息步骤表里的最大步骤
		List<DoinoutStep> doinoutStepList = doinoutStepDAO.findAllDoinoutStepById(docin.getId());
		if (doinoutStepList == null || doinoutStepList.size() == 0) {
			stepInt = 0;
		} else {
			Integer setpIntTemp = 0;
			for (int i = 0; i < doinoutStepList.size(); i++) {
				DoinoutStep doinoutStep = doinoutStepList.get(i);
				// 把列表中的大的值赋值给临时变量
				if (doinoutStep.getStep() > setpIntTemp) {
					setpIntTemp = doinoutStep.getStep();
				}
			}
			stepInt = setpIntTemp + 1;
		}
		// 数据库新增一条审核记录,并返回是否插入成功
		docin.setCurrentOptId(SecurityUtils.getLoginId());
		docin.setEnabled(1);
		docinDAO.updateDocinWorkById(docin);
		Long pk = docinReviewDAO
				.insertIntoDocinReview(toInsterDocinReview(docin));
		// 添加历史记录
		docinHistoryDAO.insertIntoDocinHistory(getDocinHistoryByDocin(
				docin, docin.getId()));
		// 添加步骤记录
		doinoutStepDAO.insertIntoDoinoutStep(getDoinoutStepByDoinoutByStep(
				docin, stepInt, docin.getId()));
		// 批准的时候 对办事流程经行添加

		if (5 == docin.getDoAction()) {
			String mainSend[] = docin.getReceiverId().split(",");
			for (int i = 0; i < mainSend.length; i++) {
				DocinBox docinBox=new DocinBox();
				docinBox.setReceiverId(mainSend[i]);
				docinBox.setDocinId(docin.getId());
				docinBoxDAO.addDocinInfo(docinBox);
			}
		}
		// 添加消息提醒的信息
		if (docin.getNextOptId() != null && !"".equals(docin.getNextOptId())) {
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(docin.getId());
			remind.setLoginId(docin.getNextOptId());
			remind.setModeName(CommonChar.MODE_DOCIN);
			remind.setTitle(docin.getTitle());
			remind.setUrl("docin/edit_docin_work.htm?id="+docin.getId());
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
	public DoinoutStep getDoinoutStepByDoinoutByStep(Docin docin,
			Integer step, long pk) {
		DoinoutStep doinoutStep = new DoinoutStep();
		doinoutStep.setCurrentOptId(docin.getCurrentOptId());
		doinoutStep.setDocinId(pk);
		doinoutStep.setStep(step);
		return doinoutStep;
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
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createDoinoutReback(Docin docin) {
		// 数据库新增一条审核记录,并返回是否插入成功
		docin.setCurrentOptId(SecurityUtils.getLoginId());
		docin.setEnabled(1);

		docinDAO.updateDocinById(docin);
		Long pk = docinReviewDAO
				.insertIntoDocinReview(toInsterDocinReview(docin));
		// 添加历史记录
		docinHistoryDAO.insertIntoDocinHistory(getDocinHistoryByDocin(
				docin, docin.getId()));
		// 添加步骤记录
		doinoutStepDAO.delectIntoDoinoutStep(getDoinoutStepByDoinoutByStep(docin,
				docin.getSteps(), docin.getId()));
		// 添加消息提醒的信息
		if (docin.getNextOptId() != null && !"".equals(docin.getNextOptId())) {
			// 添加消息提醒的信息
			Remind remind = new Remind();
			remind.setBusId(docin.getId());
			remind.setLoginId(docin.getNextOptId());
			remind.setModeName(CommonChar.MODE_DOCIN);
			remind.setTitle(docin.getTitle());
			remind.setUrl("docin/edit_docin_work.htm?id="+docin.getId());
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
	public DocinReviewPage getDocinReviewListByIdQf(Long id) {
		DocinReviewPage page = new DocinReviewPage();
		List<DocinReview> docinReviewList = docinReviewDAO
				.findDocinReviewListQf(id);
		page.setDocinReviewList(docinReviewList);
		return page;
	}
	/**
	 * 督办查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@Override
	public DocinPage getMyDubanDocinList(DocinPage outPage) {
		int count = docinDAO.findDocinDubanCount(outPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return outPage;
		}

		// 根据条件查找用户待审核信息集合
		List<Docin> docinList = docinDAO.findDocinDubanList(outPage);
		outPage.setTotalRow(count); // 待审核总数量
		outPage.setDocinList(docinList); // 待审核信息
		return outPage;
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
	public boolean createDocinReviewOption(DocinReview docinReview){
		Long pk = docinReviewDAO.insertIntoDocinReview(docinReview);
		return isInsertSucc(pk);
	}

	@Override
	public String getDocinList(String reNum) {
		return docinDAO.getDocinList(reNum);
	}
	
	/**
	 * 根据步骤审核列表
	 * 
	 * @param id
	 * @param map
	 * @return 详细页面
	 * @throws Exception
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-05-14
	 */
	public List<DocinReview> findDocinReviewListByStep(DocinReview docinReview){
		// 根据条件查找用户待审核信息集合
		List<DocinReview> docinReviewList = docinReviewDAO.findDocinReviewListByStep(docinReview);
		return docinReviewList;
	}

	@Override
	public Docin getDocinFileNum(String fileNum) {
		return docinDAO.getDocinFileNum(fileNum);
	}

	/**
	 * 流程变更列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-22
	 */
	@Override
	public DocinPage getDocinLcbgList(DocinPage docinPage) {
		// 根据条件查找流程变更列表数量
		int count = docinDAO.findDocinLcbgCount(docinPage);
		// 没有符合条件的数据不继续查询
		if (count == 0) {
			return docinPage;
		}
		// 根据条件查找流程变更列表信息集合
		List<Docin> docinList = docinDAO.findDocinLcbgList(docinPage);
		docinPage.setTotalRow(count); // 流程变更列表总数量
		docinPage.setDocinList(docinList); // 流程变更列表信息集合
		// 返回分页对象
		return docinPage;
	}

	@Override
	public boolean updateDocinByNextOptId(Docin docin) {
		Integer count = docinDAO.updateDocinByNextOptId(docin);
		return isUpdateSucc(count);
	}

	
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean deleteOpinion(List<String> strList, Long id) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (String nextOptId : strList) {
			DocinReview docinReviewObj = docinReviewDAO.getDocinReviewByDocinIdByMax(id);
			// 删除用户信息
			DocinReview docinReview = new DocinReview();
			docinReview.setDocinId(id);
			docinReview.setCurrentOptId(nextOptId);
			docinReview.setStepId(docinReviewObj.getStepId());
			Integer count = docinReviewDAO.deleteOpinion(docinReview);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	@Override
	public boolean updateDocinByYxOptId(Docin docin) {
		Integer count = docinDAO.updateDocinByYxOptId(docin);
		return isUpdateSucc(count);
	}

	@Override
	public List<DocinFj> findDocinFjInfoByDocinId(Long id) {
		return docinFjDAO.findDocinFjInfoByDocinId(id);
	}

}
