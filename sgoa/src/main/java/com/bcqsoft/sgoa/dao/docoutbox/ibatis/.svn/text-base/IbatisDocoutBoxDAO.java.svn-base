package com.bcqsoft.sgoa.dao.docoutbox.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.docoutbox.DocoutBoxDAO;
import com.bcqsoft.sgoa.dao.docoutbox.dataobject.DocoutBox;

/**
 * 信息发布表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT
 * </pre>
 */
@Repository
public class IbatisDocoutBoxDAO extends BaseDAO implements DocoutBoxDAO {
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
	public List<DocoutBox> getAllDocoutBoxList(DocoutBox docoutBox) {

		return (List<DocoutBox>) ibatis().queryForList("docoutBox.getAllDocoutBoxList", docoutBox);

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
	public Long addDocoutInfo(DocoutBox docoutBox) {
		return (Long) ibatis().insert("docoutBox.addDocoutInfo", docoutBox);

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
	public List<DocoutBox> getAllDocoutBoxListAll(Long id) {

		return (List<DocoutBox>) ibatis().queryForList("docoutBox.getAllDocoutBoxListAll", id);

	}

}
