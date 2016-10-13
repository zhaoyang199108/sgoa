package com.bcqsoft.sgoa.dao.sw.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.sw.SwDAO;
import com.bcqsoft.sgoa.dao.sw.dataobject.Sw;
import com.bcqsoft.sgoa.dao.sw.dataobject.SwPage;

/**
 * 信息接收表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN
 * </pre>
 */
@Repository
public class IbatisSwDAO extends BaseDAO implements SwDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param Sw
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	public Long insertIntoSw(Sw sw) {
		return (Long) ibatis().insert("sw.insertIntoSw", sw);
	}

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findMyDraftSwCount(SwPage swPage) {
		return (Integer) ibatis().queryForObject("sw.findMyDraftSwCount", swPage);
	}

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Sw> findMyDraftSwList(SwPage swPage) {
		return (List<Sw>) ibatis().queryForList("sw.findMyDraftSwList", swPage);
	}
	/**
	 * 根据条件查找该用户已收的信息数量
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findMySwCount(SwPage swPage) {
		return (Integer) ibatis().queryForObject("sw.findMySwCount", swPage);
	}

	/**
	 * 根据条件查找该用户已收的信息集合
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Sw> findMySwList(SwPage swPage) {
		return (List<Sw>) ibatis().queryForList("sw.findMySwList", swPage);
	}

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	public Integer findApprovedSwCount(SwPage swPage) {
		return (Integer) ibatis().queryForObject("sw.findApprovedSwCount", swPage);
	}

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	public List<Sw> findApprovedSwList(SwPage swPage) {
		return (List<Sw>) ibatis().queryForList("sw.findApprovedSwList", swPage);
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
	public int updateSwStatusToEnabled(Long id) {
		return ibatis().update("sw.updateSwStatusToEnabled", id);
	}

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id 信息ID
	 * @return Sw
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Sw findSwDetailInfoById(Long id) {
		return (Sw) ibatis().queryForObject("sw.findSwDetailInfoById", id);
	}


	/**
	 * 根据ID更新信息信息
	 * 
	 * @param sw
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public Integer updateSwInfoById(Sw sw) {
		return ibatis().update("sw.updateSwInfoById", sw);
	}

	/**
	 * 根据信息ID更新该条信息记录流程状态
	 * 
	 * @param sw
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	public int updateSwCurrentStatusById(Sw sw) {
		return ibatis().update("sw.updateSwCurrentStatusById", sw);
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
	public int deleteSwInfoById(Long docId) {
		return ibatis().delete("sw.deleteSwInfoById", docId);
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
	public List<Sw> findNewestSwList() {
		return (List<Sw>) ibatis().queryForList("sw.findNewestSwList");
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
	public Integer updateOneSwInfo(Long id) {
		return ibatis().update("sw.updateOneSwInfo", id);
	}

	/**
	 * 通知查询信息数量
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@Override
	public Integer findSwSeacheCount(SwPage outPage) {
		return (Integer) ibatis().queryForObject("sw.findSwSeacheCount", outPage);
	}
	/**
	 * 通知查询信息列表
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Sw> findSwSeacheList(SwPage outPage) {
		return (List<Sw>) ibatis().queryForList("sw.findSwSeacheList", outPage);
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
	public Integer updateSwStatusById(Sw sw) {
		return (Integer) ibatis().update("sw.updateSwStatusById", sw);
	}
}
