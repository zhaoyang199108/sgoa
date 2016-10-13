package com.bcqsoft.sgoa.service.ipset;

import com.bcqsoft.sgoa.dao.ipset.dataobject.IpSet;


public interface IpSetService {
	
	/**
	 * 更新IP设置信息
	 * 
	 * @param ipmac
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	boolean updateIpSetInfo(IpSet ipSet);

	/**
	 * 取得IP设置
	 * 
	 * @param page
	 * @return IpmacPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	IpSet getIpSetListById();
}
