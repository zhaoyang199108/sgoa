package com.bcqsoft.sgoa.dao.docin.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docin.DocinDAO;
import com.bcqsoft.sgoa.dao.docin.dataobject.Docin;
import com.bcqsoft.sgoa.dao.docin.dataobject.DocinPage;

/**
 * 信息接收表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN
 * </pre>
 */
@Repository
public class IbatisDocinDAO extends BaseDAO implements DocinDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param Docin
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoDocin(Docin docin) {
		return (Long) ibatis().insert("docin.insertIntoDocin", docin);
	}

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findMyDraftDocinCount(DocinPage docinPage) {
		return (Integer) ibatis().queryForObject("docin.findMyDraftDocinCount", docinPage);
	}

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Docin> findMyDraftDocinList(DocinPage docinPage) {
		return (List<Docin>) ibatis().queryForList("docin.findMyDraftDocinList", docinPage);
	}
	/**
	 * 根据条件查找该用户已收的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findMyDocinCount(DocinPage docinPage) {
		return (Integer) ibatis().queryForObject("docin.findMyDocinCount", docinPage);
	}

	/**
	 * 根据条件查找该用户已收的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Docin> findMyDocinList(DocinPage docinPage) {
		return (List<Docin>) ibatis().queryForList("docin.findMyDocinList", docinPage);
	}

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findApprovedDocinCount(DocinPage docinPage) {
		return (Integer) ibatis().queryForObject("docin.findApprovedDocinCount", docinPage);
	}

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Docin> findApprovedDocinList(DocinPage docinPage) {
		return (List<Docin>) ibatis().queryForList("docin.findApprovedDocinList", docinPage);
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
	public int updateDocinStatusToEnabled(Long id) {
		return ibatis().update("docin.updateDocinStatusToEnabled", id);
	}

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id 信息ID
	 * @return Docin
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Docin findDocinDetailInfoById(Long id) {
		return (Docin) ibatis().queryForObject("docin.findDocinDetailInfoById", id);
	}


	/**
	 * 根据ID更新信息信息
	 * 
	 * @param docin
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Integer updateDocinInfoById(Docin docin) {
		return ibatis().update("docin.updateDocinInfoById", docin);
	}

	/**
	 * 根据信息ID更新该条信息记录流程状态
	 * 
	 * @param docin
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public int updateDocinCurrentStatusById(Docin docin) {
		return ibatis().update("docin.updateDocinCurrentStatusById", docin);
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
	public int deleteDocinInfoById(Long docId) {
		return ibatis().delete("docin.deleteDocinInfoById", docId);
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
	public List<Docin> findNewestDocinList() {
		return (List<Docin>) ibatis().queryForList("docin.findNewestDocinList");
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
	public Integer updateOneDocinInfo(Long id) {
		return ibatis().update("docin.updateOneDocinInfo", id);
	}

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findDocinReviewCount(DocinPage docinPage) {
		return (Integer) ibatis().queryForObject("docin.findDocinReviewCount", docinPage);
	}

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docin> findDocinReviewList(DocinPage docinPage) {
		return (List<Docin>) ibatis().queryForList("docin.findDocinReviewList", docinPage);
	}
	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findDocinDoinoutCount(DocinPage docinPage) {
		return (Integer) ibatis().queryForObject("docin.findDocinDoinoutCount", docinPage);
	}

	/**
	 * 根据条件查找该用户待审核的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docin> findDocinDoinoutList(DocinPage docinPage) {
		return (List<Docin>) ibatis().queryForList("docin.findDocinDoinoutList", docinPage);
	}
	
	/**
	 * 根据条件查找该用户经我审核的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer getMyDocinReviewCount(DocinPage docinPage) {
		return (Integer) ibatis().queryForObject("docin.getMyDocinReviewCount", docinPage);
	}

	/**
	 * 根据条件查找该用户经我审核的信息集合
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docin> getMyDocinReviewList(DocinPage docinPage) {
		return (List<Docin>) ibatis().queryForList("docin.getMyDocinReviewList", docinPage);
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
	public Integer updateDocinById(Docin docin) {
		return (Integer) ibatis().update("docin.updateDocinById", docin);
	}
	/**
	 * 通知查询信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findDocinSeacheCount(DocinPage outPage) {
		return (Integer) ibatis().queryForObject("docin.findDocinSeacheCount", outPage);
	}
	/**
	 * 通知查询信息列表
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docin> findDocinSeacheList(DocinPage outPage) {
		return (List<Docin>) ibatis().queryForList("docin.findDocinSeacheList", outPage);
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
	public Integer updateDocinWorkById(Docin docin) {
		return (Integer) ibatis().update("docin.updateDocinWorkById", docin);
	}
	/**
	 * 督办查询信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findDocinDubanCount(DocinPage outPage) {
		return (Integer) ibatis().queryForObject("docin.findDocinDubanCount", outPage);
	}
	/**
	 * 督办查询信息列表
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docin> findDocinDubanList(DocinPage outPage) {
		return (List<Docin>) ibatis().queryForList("docin.findDocinDubanList", outPage);
	}

	/**
	 * 根据条件查找该用户待审核的信息数量
	 * 
	 * @param docin
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findDocinReviewCountForIndex(DocinPage docinPage) {
		return (Integer) ibatis().queryForObject("docin.findDocinReviewCountForIndex", docinPage);
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
	public Integer updateDocinStatusById(Docin docin) {
		return (Integer) ibatis().update("docin.updateDocinStatusById", docin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getDocinList(String reNum) {
		return (String) ibatis().queryForObject("docin.getDocinList",reNum);
	}

	/**
	 * 文件编号查询
	 * 
	 * @return 文件编号查询页面
	 * 
	 * @Author cql
	 * @Date 2012-01-17
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Docin> getDocinListByFileNum(String fileNum) {
		return (List<Docin>) ibatis().queryForList("docin.getDocinListByFileNum", fileNum);
	}

	@Override
	public Docin getDocinFileNum(String fileNum) {
		return (Docin) ibatis().queryForObject("docin.getDocinFileNum",fileNum);
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
	public Integer findDocinLcbgCount(DocinPage docinPage) {
		return (Integer) ibatis().queryForObject("docin.findDocinLcbgCount", docinPage);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Docin> findDocinLcbgList(DocinPage docinPage) {
		return (List<Docin>) ibatis().queryForList("docin.findDocinLcbgList", docinPage);
	}

	@Override
	public Integer updateDocinByNextOptId(Docin docin) {
		return (Integer) ibatis().update("docin.updateDocinByNextOptId",docin);
	}

	@Override
	public Integer updateDocinByYxOptId(Docin docin) {
		return (Integer) ibatis().update("docin.updateDocinByYxOptId",docin);
	}

}
