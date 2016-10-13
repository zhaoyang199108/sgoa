package com.bcqsoft.sgoa.dao.docout.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docout.DocoutDAO;
import com.bcqsoft.sgoa.dao.docout.dataobject.Docout;
import com.bcqsoft.sgoa.dao.docout.dataobject.DocoutPage;

/**
 * 信息发布表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT
 * </pre>
 */
@Repository
public class IbatisDocoutDAO extends BaseDAO implements DocoutDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param Docout
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocout(Docout docout) {
		return (Long) ibatis().insert("docout.insertIntoDocout", docout);
	}

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findMyDraftDocoutCount(DocoutPage docoutPage) {
		return (Integer) ibatis().queryForObject("docout.findMyDraftDocoutCount", docoutPage);
	}

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Docout> findMyDraftDocoutList(DocoutPage docoutPage) {
		return (List<Docout>) ibatis().queryForList("docout.findMyDraftDocoutList", docoutPage);
	}
	/**
	 * 根据条件查找该用户已收的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findMyDocoutCount(DocoutPage docoutPage) {
		return (Integer) ibatis().queryForObject("docout.findMyDocoutCount", docoutPage);
	}

	/**
	 * 根据条件查找该用户已收的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Docout> findMyDocoutList(DocoutPage docoutPage) {
		return (List<Docout>) ibatis().queryForList("docout.findMyDocoutList", docoutPage);
	}

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findApprovedDocoutCount(DocoutPage docoutPage) {
		return (Integer) ibatis().queryForObject("docout.findApprovedDocoutCount", docoutPage);
	}

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Docout> findApprovedDocoutList(DocoutPage docoutPage) {
		return (List<Docout>) ibatis().queryForList("docout.findApprovedDocoutList", docoutPage);
	}

	/**
	 * 根据信息ID更新该条信息记录状态为已删除
	 * 
	 * @param Long 信息ID
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public int updateDocoutStatusToEnabled(Long id) {
		return ibatis().update("docout.updateDocoutStatusToEnabled", id);
	}

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id 信息ID
	 * @return Docout
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Docout findDocoutDetailInfoById(Long id) {
		return (Docout) ibatis().queryForObject("docout.findDocoutDetailInfoById", id);
	}


	/**
	 * 根据ID更新信息信息
	 * 
	 * @param docout
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Integer updateDocoutInfoById(Docout docout) {
		return ibatis().update("docout.updateDocoutInfoById", docout);
	}

	/**
	 * 根据信息ID更新该条信息记录流程状态
	 * 
	 * @param docout
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public int updateDocoutCurrentStatusById(Docout docout) {
		return ibatis().update("docout.updateDocoutCurrentStatusById", docout);
	}

	/**
	 * 导入至正式表后根据ID清除临时表数据
	 * 
	 * @param docId
	 * @return 删除条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-10
	 */
	public int deleteDocoutInfoById(Long docId) {
		return ibatis().delete("docout.deleteDocoutInfoById", docId);
	}

	/**
	 * 查找最新的信息列表
	 * 
	 * @return
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-2-21
	 */
	@SuppressWarnings("unchecked")
	public List<Docout> findNewestDocoutList() {
		return (List<Docout>) ibatis().queryForList("docout.findNewestDocoutList");
	}

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
	@Override
	public Integer updateOneDocoutInfo(Long id) {
		return ibatis().update("docout.updateOneDocoutInfo", id);
	}

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findDocoutReviewCount(DocoutPage docoutPage) {
		return (Integer) ibatis().queryForObject("docout.findDocoutReviewCount", docoutPage);
	}

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docout> findDocoutReviewList(DocoutPage docoutPage) {
		return (List<Docout>) ibatis().queryForList("docout.findDocoutReviewList", docoutPage);
	}
	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findDocoutDoinoutCount(DocoutPage docoutPage) {
		return (Integer) ibatis().queryForObject("docout.findDocoutDoinoutCount", docoutPage);
	}

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docout> findDocoutDoinoutList(DocoutPage docoutPage) {
		return (List<Docout>) ibatis().queryForList("docout.findDocoutDoinoutList", docoutPage);
	}
	
	/**
	 * 根据条件查找该用户经我审核的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer getMyDocoutReviewCount(DocoutPage docoutPage) {
		return (Integer) ibatis().queryForObject("docout.getMyDocoutReviewCount", docoutPage);
	}

	/**
	 * 根据条件查找该用户经我审核的信息集合
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docout> getMyDocoutReviewList(DocoutPage docoutPage) {
		return (List<Docout>) ibatis().queryForList("docout.getMyDocoutReviewList", docoutPage);
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
	@Override
	public Integer updateDocoutById(Docout docout) {
		return (Integer) ibatis().update("docout.updateDocoutById", docout);
	}
	/**
	 * 通知查询信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findDocoutSeacheCount(DocoutPage outPage) {
		return (Integer) ibatis().queryForObject("docout.findDocoutSeacheCount", outPage);
	}
	/**
	 * 通知查询信息列表
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docout> findDocoutSeacheList(DocoutPage outPage) {
		return (List<Docout>) ibatis().queryForList("docout.findDocoutSeacheList", outPage);
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
	@Override
	public Integer updateDocoutWorkById(Docout docout) {
		return (Integer) ibatis().update("docout.updateDocoutWorkById", docout);
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
	@Override
	public Integer updateDocoutStatusById(Docout docout) {
		return (Integer) ibatis().update("docout.updateDocoutStatusById", docout);
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
	public Integer findDocoutDubanCount(DocoutPage outPage) {
		return (Integer) ibatis().queryForObject("docout.findDocoutDubanCount", outPage);
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Docout> findDocoutDubanList(DocoutPage outPage) {
		return (List<Docout>) ibatis().queryForList("docout.findDocoutDubanList", outPage);
	}
	
	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docout
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findDocoutReviewCountForIndex(DocoutPage docoutPage) {
		return (Integer) ibatis().queryForObject("docout.findDocoutReviewCountForIndex", docoutPage);
	}
}
