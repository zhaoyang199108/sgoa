package com.bcqsoft.sgoa.dao.sw;

import java.util.List;

import com.bcqsoft.sgoa.dao.sw.dataobject.Sw;
import com.bcqsoft.sgoa.dao.sw.dataobject.SwPage;

/**
 * 信息发布表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN
 * </pre>
 */
public interface SwDAO {

	/**
	 * 信息临时表中添加数据
	 * 
	 * @param Sw
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long insertIntoSw(Sw sw);

	/**
	 * 根据条件查找该用户拟稿的信息数量
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMyDraftSwCount(SwPage swPage);

	/**
	 * 根据条件查找该用户拟稿的信息集合
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Sw> findMyDraftSwList(SwPage swPage);

	/**
	 * 根据条件查找该用户已收的信息数量
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findMySwCount(SwPage swPage);

	/**
	 * 根据条件查找该用户已收的信息集合
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Sw> findMySwList(SwPage swPage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findApprovedSwCount(SwPage swPage);

	/**
	 * 根据条件查找已批准通过或待归档的信息
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Sw> findApprovedSwList(SwPage swPage);

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
	int updateSwStatusToEnabled(Long id);

	/**
	 * 根据ID取得信息草稿数据
	 * 
	 * @param id
	 *            信息ID
	 * @return Sw
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Sw findSwDetailInfoById(Long id);

	/**
	 * 根据ID更新信息
	 * 
	 * @param sw
	 * @return 更新条数
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2012-1-6
	 */
	Integer updateSwInfoById(Sw sw);

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
	Integer updateOneSwInfo(Long id);

	/**
	 * 通知查询信息数量
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	Integer findSwSeacheCount(SwPage outPage);

	/**
	 * 通知查询信息列表
	 * 
	 * @param sw
	 * @return 信息集合
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-29
	 */
	List<Sw> findSwSeacheList(SwPage outPage);
	
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
	Integer updateSwStatusById(Sw sw);
}
