package com.bcqsoft.sgoa.service.ggtxl;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.ggtxl.dataobject.Ggtxl;
import com.bcqsoft.sgoa.dao.ggtxl.dataobject.GgtxlPage;

/**
 * 公共通讯录设备申领表模块业务逻辑类接口
 */
@Service
public interface GgtxlService {
	/**
	 * 根据查询条件查找公共通讯录信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	GgtxlPage getGgtxlInfoList(GgtxlPage page);

	/**
	 * 添加公共通讯录信息
	 * 
	 * @param ggtxl
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	boolean createGgtxl(Ggtxl ggtxl);

	/**
	 * 公共通讯录详细信息
	 * 
	 * @param ggtxl
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	Ggtxl getGgtxlInfo(long id);

	/**
	 * 公共通讯录详细信息
	 * 
	 * @param ggtxl
	 * @return
	 * 
	 * @Author sbq
	 * @Date 2013-05-07
	 */
	GgtxlPage getGgtxlAllList(GgtxlPage page);
	/**
	 * 修改公共通讯录信息
	 * 
	 * @param ggtxl
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean editGgtxlInfo(Ggtxl ggtxl);
	/**
	 * 删除公共通讯录信息
	 * 
	 * @param ggtxlId
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteGgtxl(long id);
	/**
	 * 删除公共通讯录信息(多选框批量删除)
	 * 
	 * @param idArray
	 * @return
	 * 
	 * @Author cql
	 * @Date 2012-01-04
	 */
	boolean deleteGgtxls(long[] longArray);

	GgtxlPage getGgtxlInfoSearchList(GgtxlPage ggtxlPage);

}
