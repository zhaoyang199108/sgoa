package com.bcqsoft.sgoa.dao.ipset.ibatis;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.ipset.IpSetDAO;
import com.bcqsoft.sgoa.dao.ipset.dataobject.IpSet;


/**
 * IP控制开关设置表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE:SCOA_TB_IP_SET
 * </pre>
 */
@Repository
public class IbatisIpSetDAO extends BaseDAO implements IpSetDAO {
	
	/**
	 * 根据ID查询某一条IP开关设置C
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public IpSet findIpSetInfoById() {
		return (IpSet) ibatis().queryForObject("ipSet.findipSetInfoById");
	}

	/**
	 * 根据ID更新某条IP开关设置C信息
	 * 
	 * @param ipmac
	 * @return
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public Integer updateIpSetInfoById(IpSet ipSet) {
		return (Integer) ibatis().update("ipSet.updateIpSetInfoById", ipSet);
	}
}
