package com.bcqsoft.sgoa.service.cyddetail.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.cyddetail.CydDetailDAO;
import com.bcqsoft.sgoa.dao.cyddetail.dataobject.CydDetail;
import com.bcqsoft.sgoa.dao.cyddetail.dataobject.CydDetailPage;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHu;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHuPage;

import com.bcqsoft.sgoa.service.cyddetail.CydDetailService;

@Service
public class CydDetailServiceImpl extends BaseService implements CydDetailService{
	
	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private CydDetailDAO cydDetailDAO;
	
	@Override
	public CydDetailPage getNameListById() {
		CydDetailPage page = new CydDetailPage();
//		List<CydDetail> CydDetailList = cydDetailDAO.findCydDetailList();
//		page.setCydDetailList(CydDetailList);
		return page;
	}
	
	@Override
	public CydDetailPage getCydDetailListById(Long id) {
		CydDetailPage page = new CydDetailPage();
		List<CydDetail> cydDetailList = cydDetailDAO.findCydDetailList(id);
		page.setCydDetailList(cydDetailList);
		return page;
	}
}