package com.bcqsoft.sgoa.dao.ipset;

import com.bcqsoft.sgoa.dao.ipset.dataobject.IpSet;


/**
 * IP/MAC表数据库访问DAO接口
 * 
 * <pre>
 * TABLE:SCOA_TB_MEETING_ROOM
 * </pre>
 */
public interface IpSetDAO {

	/**
	 * 根据ID查询某一条IP开关设置C
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	IpSet findIpSetInfoById();

	/**
	 * 根据ID更新某条IP开关设置C信息
	 * 
	 * @param ipmac
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	Integer updateIpSetInfoById(IpSet ipSet);

}
