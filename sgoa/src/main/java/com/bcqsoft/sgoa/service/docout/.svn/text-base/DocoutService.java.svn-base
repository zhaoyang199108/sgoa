package com.bcqsoft.sgoa.service.docout;


import java.util.List;

import com.bcqsoft.sgoa.dao.docout.dataobject.Docout;
import com.bcqsoft.sgoa.dao.docout.dataobject.DocoutPage;
import com.bcqsoft.sgoa.dao.docouthistory.dataobject.DocoutHistory;
import com.bcqsoft.sgoa.dao.docoutreview.dataobject.DocoutReviewPage;
import com.bcqsoft.sgoa.dao.docoutstep.dataobject.DocoutStep;
import com.bcqsoft.sgoa.dao.dooutinstep.dataobject.DooutinStep;

/**
 * 信息发布模块业务逻辑类接口
 */
public interface DocoutService {

	/**
	 * 添加信息草稿
	 * 
	 * @param docout
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean addDocoutDraftInfo(Docout docout);
	
	/**
	 * 更新信息草稿
	 * 
	 * @param docout
	 * @return 是否成功(True:成功, False:失败)
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	boolean updateDocoutDraftInfo(Docout docout);

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
	boolean addDocoutInfo(Docout docout);

	/**
	 * 拟稿信息页面
	 * 
	 * @param DocoutPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	DocoutPage getMyDraftDocoutList(DocoutPage outPage);
	
	/**
	 * 我的已收发文信息页面
	 * 
	 * @param DocoutPage
	 * @return 拟稿分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	DocoutPage getMyDocoutList(DocoutPage outPage);
	/**
	 * 我的申请页面
	 * 
	 * @param DocoutPage
	 * @return 分页对象
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	DocoutPage getApprovedDocoutList(DocoutPage outPage);
	
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
	boolean removeOneDocoutInfo(Long id);

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
	boolean removeOneDocoutInfo(long[] longArray);

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @return Docout
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Docout getUserDraftDocoutDetail(Long id);

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
	boolean updateDocoutInfo(Docout docout);
	
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
	boolean updateDocoutStatusById(Docout docout);

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
	boolean updateOneDocoutInfo(Long id);

	/**
	 * 查找通知公告审批表详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	DocoutReviewPage getDocoutReviewListById(Long id);

	/**
	 * 查找通知公告审批表一条详细信息根据ID
	 * 
	 * @return 通知公告表详细信息
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-14
	 */
	DocoutReviewPage getDocoutReviewListByIdOne(Long id);
	
	/**
	 * 待审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocoutPage getDocoutReviewList(DocoutPage outPage);
	/**
	 * 待审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocoutPage getDocoutDoinoutList(DocoutPage outPage);
	
	/**
	 * 经我审核信息列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocoutPage getMyDocoutReviewList(DocoutPage outPage);

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
	boolean createDocoutReview(Docout docout);

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
	List<DocoutStep> getDocoutStepList(Long id);
	
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
	List<DooutinStep> getDooutinStepList(Long id);

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
	boolean createDocoutReback(Docout docout);

	/**
	 * 跳转至历史记录页面
	 * 
	 * @return 历史记录页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	List<DocoutHistory> getDocoutHistoryInfo(long id);
	/**
	 * 通知查询列表
	 * 
	 * @param map
	 * @return 信息页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocoutPage getDocoutSearchList(DocoutPage outPage);

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
	boolean createDocoutWork(Docout docout);

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
	boolean createDooutinReback(Docout docout);

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
	DocoutReviewPage getDocoutReviewListByIdQf(Long id);

	/**
	 * 我的督办列表
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	DocoutPage getMyDubanDocoutList(DocoutPage outPage);

}
