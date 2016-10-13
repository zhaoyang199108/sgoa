package com.bcqsoft.sgoa.service.seal;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.seal.dataobject.Seal;
import com.bcqsoft.sgoa.dao.seal.dataobject.SealPage;

/**
 * 签章模块设备申领表模块业务逻辑类接口
 */
@Service
public interface SealService {
	/**
	 * 根据查询条件查找签章模块信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	SealPage getSealInfoList(SealPage page);

	/**
	 * 添加签章模块信息
	 * 
	 * @param seal
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	boolean createSeal(Seal seal);

	/**
	 * 签章模块详细信息
	 * 
	 * @param seal
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	Seal getSealInfo(long id);
	
	/**
	 * 签章模块详细信息和输出流
	 * 
	 * @param seal
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	Seal getSealInfoToOut(Seal seal);
	
	/**
	 * 修改签章模块信息
	 * 
	 * @param seal
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean editSealInfo(Seal seal);
	/**
	 * 删除签章模块信息
	 * 
	 * @param sealId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteSeal(long id);
	/**
	 * 删除签章模块信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteSeals(long[] longArray);

}
