package com.bcqsoft.sgoa.dao.docinbox.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docinbox.DocinBoxDAO;
import com.bcqsoft.sgoa.dao.docinbox.dataobject.DocinBox;

/**
 * 信息发布表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN
 * </pre>
 */
@Repository
public class IbatisDocinBoxDAO extends BaseDAO implements DocinBoxDAO {
	/**
	 * 根据条件查询收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DocinBox> getAllDocinBoxList(DocinBox docinBox) {

		return (List<DocinBox>) ibatis().queryForList("docinBox.getAllDocinBoxList", docinBox);

	}

	/**
	 * 添加收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Override
	public Long addDocinInfo(DocinBox docinBox) {
		return (Long) ibatis().insert("docinBox.addDocinInfo", docinBox);

	}

	/**
	 * 根据Id获取该ID下所有的收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DocinBox> getAllDocinBoxListAll(Long id) {

		return (List<DocinBox>) ibatis().queryForList("docinBox.getAllDocinBoxListAll", id);

	}
	/**
	 * 添加收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	@Override
	public Integer updateDocinInfo(DocinBox docinBox) {
		return (Integer) ibatis().update("docinBox.updateDocinInfo", docinBox);

	}

}
