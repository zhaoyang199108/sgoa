package com.bcqsoft.sgoa.service.ipset.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.ipset.IpSetDAO;
import com.bcqsoft.sgoa.dao.ipset.dataobject.IpSet;
import com.bcqsoft.sgoa.service.ipset.IpSetService;

@Service
public class IpSetServiceImpl extends BaseService implements IpSetService {

	@Autowired
	private IpSetDAO ipSetDAO;

	/**
	 * 更新IP/MAC信息
	 * 
	 * @param ipmac
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public boolean updateIpSetInfo(IpSet ipSet) {
		Integer count = ipSetDAO.updateIpSetInfoById(ipSet);
		return isUpdateSucc(count);
	}

	/**
	 * 取得IP/MAC详细信息
	 * 
	 * @param id
	 * @return IpSet
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public IpSet getIpSetListById() {
		return ipSetDAO.findIpSetInfoById();
	}
}
