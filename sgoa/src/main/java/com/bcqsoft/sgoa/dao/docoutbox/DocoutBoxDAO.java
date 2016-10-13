package com.bcqsoft.sgoa.dao.docoutbox;

import java.util.List;

import com.bcqsoft.sgoa.dao.docoutbox.dataobject.DocoutBox;

/**
 * 信息发布表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCOUT
 * </pre>
 */
public interface DocoutBoxDAO {
	/**
	 * 根据条件查询收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<DocoutBox> getAllDocoutBoxList(DocoutBox docoutBox);
	/**
	 * 添加收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long addDocoutInfo(DocoutBox docoutBox);
	/**
	 * 根据Id获取该ID下所有的收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<DocoutBox> getAllDocoutBoxListAll(Long id);

}
