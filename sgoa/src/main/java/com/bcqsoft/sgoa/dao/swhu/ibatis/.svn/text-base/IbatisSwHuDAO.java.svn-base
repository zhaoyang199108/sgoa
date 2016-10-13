package com.bcqsoft.sgoa.dao.swhu.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.swhu.SwHuDAO;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHu;

/**
 * 信息发布表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN
 * </pre>
 */
@Repository
public class IbatisSwHuDAO extends BaseDAO implements SwHuDAO {
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
	public List<SwHu> getAllSwHuList(SwHu swHu) {

		return (List<SwHu>) ibatis().queryForList("swHu.getAllSwHuList", swHu);

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
	public Long addSwInfo(SwHu swHu) {
		return (Long) ibatis().insert("swHu.addSwInfo", swHu);

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
	public List<SwHu> getAllSwHuListAll(Long id) {

		return (List<SwHu>) ibatis().queryForList("swHu.getAllSwHuListAll", id);

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
	public Integer updateSwInfo(SwHu swHu) {
		return (Integer) ibatis().update("swHu.updateSwInfo", swHu);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SwHu> findSwHuList(Long id) {
		return (List<SwHu>) ibatis().queryForList("swHu.findSwHuList", id);
	}
	
}
