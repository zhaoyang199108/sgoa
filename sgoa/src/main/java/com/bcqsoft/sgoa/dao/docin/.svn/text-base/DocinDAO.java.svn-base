package com.bcqsoft.sgoa.dao.docin;

import java.util.List;

import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docin.dataobject.DocinPage;

/**
 * 信息发布表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN
 * </pre>
 */
public interface DocinDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param Docin
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoDocin(Docin docin);

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMyDraftDocinCount(DocinPage docinPage);

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docin> findMyDraftDocinList(DocinPage docinPage);

	/**
	 * 根据条件查找该用户已收的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMyDocinCount(DocinPage docinPage);

	/**
	 * 根据条件查找该用户已收的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docin> findMyDocinList(DocinPage docinPage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findApprovedDocinCount(DocinPage docinPage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docin> findApprovedDocinList(DocinPage docinPage);

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
	int updateDocinStatusToEnabled(Long id);

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id
	 *            信息ID
	 * @return Docin
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Docin findDocinDetailInfoById(Long id);

	/**
	 * 根据ID更新信息
	 * 
	 * @param docin
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Integer updateDocinInfoById(Docin docin);

	/**
	 * 根据信息ID更新该条信息记录流程状态
	 * 
	 * @param docin
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	int updateDocinCurrentStatusById(Docin docin);

	/**
	 * 导入至正式表后根据ID清除临时表数据
	 * 
	 * @param docId
	 * @return 删除条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-10
	 */
	int deleteDocinInfoById(Long docId);

	/**
	 * 查找最新的信息列表
	 * 
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-2-21
	 */
	List<Docin> findNewestDocinList();

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
	Integer updateOneDocinInfo(Long id);

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findDocinReviewCount(DocinPage docinPage);

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docin> findDocinReviewList(DocinPage docinPage);

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findDocinDoinoutCount(DocinPage docinPage);

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docin> findDocinDoinoutList(DocinPage docinPage);

	/**
	 * 根据条件查找该用户经我审核的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer getMyDocinReviewCount(DocinPage docinPage);

	/**
	 * 根据条件查找该用户经我审核的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docin> getMyDocinReviewList(DocinPage docinPage);

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
	Integer updateDocinById(Docin docin);

	/**
	 * 通知查询信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findDocinSeacheCount(DocinPage outPage);

	/**
	 * 通知查询信息列表
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docin> findDocinSeacheList(DocinPage outPage);

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
	Integer updateDocinWorkById(Docin docin);

	/**
	 * 通知查询信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findDocinDubanCount(DocinPage outPage);

	/**
	 * 通知查询信息列表
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Docin> findDocinDubanList(DocinPage outPage);
	
	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findDocinReviewCountForIndex(DocinPage docinPage);
	
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
	Integer updateDocinStatusById(Docin docin);

	String getDocinList(String reNum);

	/**
	 * 文件编号查询
	 * 
	 * @return 文件编号查询页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	List<Docin> getDocinListByFileNum(String fileNum);

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
	Integer findDocinLcbgCount(DocinPage docinPage);
	List<Docin> findDocinLcbgList(DocinPage docinPage);

	Integer updateDocinByNextOptId(Docin docin);

	Integer updateDocinByYxOptId(Docin docin);
}
