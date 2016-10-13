package com.bcqsoft.sgoa.dao.cyddetail;

import java.util.List;

import com.bcqsoft.sgoa.dao.cyddetail.dataobject.CydDetail;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHu;


/**
 * 传阅单表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_CYD
 * </pre>
 */

public interface CydDetailDAO {
	List<CydDetail> findCydDetailList(Long id);
	
	/**
	 * 插入一条用户角色信息至用户职务表(SCOA_TB_USER_ROLE)
	 * 
	 * @param agentPrice
	 * @return 插入记录的ID
	 * 
	 * @Author lzn
	 * @Date 2015-07-30
	 */
	Long insertIntoCydDetail(CydDetail cydDetail);
	
	/**
	 * 删除详细表记录
	 * @param id
	 * @return
	 */
	Integer deleteCydDetailInfoById(long id);
}