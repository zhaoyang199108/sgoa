package com.bcqsoft.sgoa.service.cyddetail;

import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.dao.cyddetail.dataobject.CydDetailPage;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHuPage;

/**
 * 传阅单模块业务逻辑类接口
 */
@Service
public interface CydDetailService {
	
	CydDetailPage getNameListById();
	
	
	CydDetailPage getCydDetailListById(Long id);
}
