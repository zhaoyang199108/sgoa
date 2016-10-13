package com.bcqsoft.sgoa.service.ipmac;

import com.bcqsoft.sgoa.dao.ipmac.dataobject.Ipmac;
import com.bcqsoft.sgoa.dao.ipmac.dataobject.IpmacPage;


public interface IpmacService {
	
	/**
	 * 添加IP/MAC信息
	 * 
	 * @param ipmac
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	boolean createIpmacInfo(Ipmac ipmac);

	/**
	 * 更新IP/MAC信息
	 * 
	 * @param ipmac
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	boolean updateIpmacInfo(Ipmac ipmac);

	/**
	 * 取得IP/MAC列表(分页)
	 * 
	 * @param page
	 * @return IpmacPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	IpmacPage getIpmacListByPage(IpmacPage page);

	/**
	 * 删除一条IP/MAC(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	boolean deleteIpmacInfo(Long id);

	/**
	 * 删除IP/MAC(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-5-13
	 */
	boolean deleteIpmacInfos(long[] idArray);

	/**
	 * 取得IP/MAC详细信息
	 * 
	 * @param id
	 * @return Ipmac
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Ipmac getIpmacDetailInfo(Long id);

	Integer findIpmacInfoCount(IpmacPage page);

}
