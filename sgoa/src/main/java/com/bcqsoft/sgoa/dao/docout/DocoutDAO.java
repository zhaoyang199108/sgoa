package com.bcqsoft.sgoa.dao.docout;

import java.util.List;

import com.bcqsoft.sgoa.dao.docout.dataobject.Docout;
import com.bcqsoft.sgoa.dao.docout.dataobject.DocoutPage;

/**
 * 信息发布表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT
 * </pre>
 */
public interface DocoutDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param Docout
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoDocout(Docout docout);

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMyDraftDocoutCount(DocoutPage docoutPage);

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docout> findMyDraftDocoutList(DocoutPage docoutPage);
	/**
	 * 根据条件查找该用户已收的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMyDocoutCount(DocoutPage docoutPage);

	/**
	 * 根据条件查找该用户已收的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docout> findMyDocoutList(DocoutPage docoutPage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findApprovedDocoutCount(DocoutPage docoutPage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docout> findApprovedDocoutList(DocoutPage docoutPage);

	/**
	 * 根据信息ID更新该条信息记录状态为已删除
	 * 
	 * @param Long
	 *            信息ID
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	int updateDocoutStatusToEnabled(Long id);

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id
	 *            信息ID
	 * @return Docout
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Docout findDocoutDetailInfoById(Long id);

	/**
	 * 根据ID更新信息
	 * 
	 * @param docout
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Integer updateDocoutInfoById(Docout docout);

	/**
	 * 根据信息ID更新该条信息记录流程状态
	 * 
	 * @param docout
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	int updateDocoutCurrentStatusById(Docout docout);

	/**
	 * 导入至正式表后根据ID清除临时表数据
	 * 
	 * @param docId
	 * @return 删除条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-10
	 */
	int deleteDocoutInfoById(Long docId);

	/**
	 * 查找最新的信息列表
	 * 
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-2-21
	 */
	List<Docout> findNewestDocoutList();

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
	Integer updateOneDocoutInfo(Long id);

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findDocoutReviewCount(DocoutPage docoutPage);

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docout> findDocoutReviewList(DocoutPage docoutPage);
	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findDocoutDoinoutCount(DocoutPage docoutPage);

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docout> findDocoutDoinoutList(DocoutPage docoutPage);

	/**
	 * 根据条件查找该用户经我审核的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer getMyDocoutReviewCount(DocoutPage docoutPage);

	/**
	 * 根据条件查找该用户经我审核的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docout> getMyDocoutReviewList(DocoutPage docoutPage);

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
	Integer updateDocoutById(Docout docout);

	/**
	 * 通知查询信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findDocoutSeacheCount(DocoutPage outPage);

	/**
	 * 通知查询信息列表
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docout> findDocoutSeacheList(DocoutPage outPage);

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
	Integer updateDocoutWorkById(Docout docout);
	
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
	Integer updateDocoutStatusById(Docout docout);

	/**
	 * 我的督办列表
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	Integer findDocoutDubanCount(DocoutPage outPage);

	/**
	 * 我的督办列表
	 * 
	 * @param map
	 * @return 信息拟稿页面模板
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<Docout> findDocoutDubanList(DocoutPage outPage);
	
	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findDocoutReviewCountForIndex(DocoutPage docoutPage);
}
