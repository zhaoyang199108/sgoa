package com.bcqsoft.sgoa.service.docin;


import java.util.List;

import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docin.dataobject.DocinPage;
import com.bcqsoft.sgoa.dao.docinfj.dataobject.DocinFj;
import com.bcqsoft.sgoa.dao.docinhistory.dataobject.DocinHistory;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReview;
import com.bcqsoft.sgoa.dao.docinreview.dataobject.DocinReviewPage;
import com.bcqsoft.sgoa.dao.docinstep.dataobject.DocinStep;
import com.bcqsoft.sgoa.dao.doinoutstep.dataobject.DoinoutStep;

/**
 * 信息发布模块业务逻辑类接口
 */
public interface DocinService {

	/**
	 * 添加信息草稿
	 * 
	 * @param docin
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addDocinDraftInfo(Docin docin);
	
	/**
	 * 更新信息草稿
	 * 
	 * @param docin
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean updateDocinDraftInfo(Docin docin);

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
	boolean addDocinInfo(Docin docin);

	/**
	 * 拟稿信息页面
	 * 
	 * @param DocinPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	DocinPage getMyDraftDocinList(DocinPage outPage);
	
	/**
	 * 我的已收收文信息页面
	 * 
	 * @param DocinPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	DocinPage getMyDocinList(DocinPage outPage);
	/**
	 * 我的申请页面
	 * 
	 * @param DocinPage
	 * @return 分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	DocinPage getApprovedDocinList(DocinPage outPage);
	
	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long 信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	boolean removeOneDocinInfo(Long id);

	/**
	 * 根据信息ID删除该条信息记录
	 * 
	 * <pre>
	 * 更新该条信息记录状态为已删除
	 * </pre>
	 * 
	 * @param Long 信息ID
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	boolean removeOneDocinInfo(long[] longArray);

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @return Docin
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Docin getUserDraftDocinDetail(Long id);

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
	boolean updateDocinInfo(Docin docin);
	
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
	boolean updateDocinStatusById(Docin docin);

	/**
	 * 根据信息ID撤销该条信息记录
	 * 
	 * 
	 * @param Long 信息ID
	 * @return 成功页面
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	boolean updateOneDocinInfo(Long id);

	/**
	 * 查找通知公告审批表详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	DocinReviewPage getDocinReviewListById(Long id);
	
	/**
	 * 查找通知公告审批表一条详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	DocinReviewPage getDocinReviewListByIdOne(Long id);

	/**
	 * 待审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocinPage getDocinReviewList(DocinPage outPage);
	/**
	 * 待审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocinPage getDocinDoinoutList(DocinPage outPage);
	
	/**
	 * 经我审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocinPage getMyDocinReviewList(DocinPage outPage);

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
	boolean createDocinReview(Docin docin);

	/**
	 * 返回
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	List<DocinStep> getDocinStepList(Long id);
	
	/**
	 * 返回
	 * 
	 * @param form
	 * @param map
	 * @return 成功页面
	 * 
	 * @Author cql
	 * @Date 2012-01-12
	 */
	List<DoinoutStep> getDoinoutStepList(Long id);

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
	boolean createDocinReback(Docin docin);

	/**
	 * 跳转至历史记录页面
	 * 
	 * @return 历史记录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	List<DocinHistory> getDocinHistoryInfo(long id);
	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocinPage getDocinSearchList(DocinPage outPage);

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
	boolean createDocinWork(Docin docin);

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
	boolean createDoinoutReback(Docin docin);

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
	DocinReviewPage getDocinReviewListByIdQf(Long id);
	/**
	 * 督办查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocinPage getMyDubanDocinList(DocinPage outPage);
	
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
	boolean createDocinReviewOption(DocinReview docinReview);

	String getDocinList(String reNum);

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
	List<DocinReview> findDocinReviewListByStep(DocinReview docinReview);

	Docin getDocinFileNum(String fileNum);
	
	/**
	 * 流程变更列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2011-12-22
	 */
	DocinPage getDocinLcbgList(DocinPage outPage);

	boolean updateDocinByNextOptId(Docin docin);

	boolean deleteOpinion(List<String> strList, Long id);

	boolean updateDocinByYxOptId(Docin docin);

	List<DocinFj> findDocinFjInfoByDocinId(Long id);

}
