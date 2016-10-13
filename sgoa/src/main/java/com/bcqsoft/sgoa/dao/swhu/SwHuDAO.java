package com.bcqsoft.sgoa.dao.swhu;

import java.util.List;

import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHu;

/**
 * 信息发布表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DOCIN
 * </pre>
 */
public interface SwHuDAO {
	/**
	 * 根据条件查询收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<SwHu> getAllSwHuList(SwHu swHu);
	/**
	 * 添加收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Long addSwInfo(SwHu swHu);
	/**
	 * 根据Id获取该ID下所有的收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	List<SwHu> getAllSwHuListAll(Long id);
	/**
	 * 修改收件人
	 * 
	 * @param DocumentOutHistory
	 * @return Long 当前数据ID
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-26
	 */
	Integer updateSwInfo(SwHu swHu);
	List<SwHu> findSwHuList(Long id);

}
