package com.bcqsoft.sgoa.service.swhu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.swhu.SwHuDAO;
import com.bcqsoft.sgoa.dao.swhu.dataobject.SwHu;
import com.bcqsoft.sgoa.service.swhu.SwHuService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class SwHuServiceImpl extends BaseService implements SwHuService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private SwHuDAO swHuDAO;

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public List<SwHu> getAllSwHuList(SwHu swHu) {
		List<SwHu> swHuList = swHuDAO.getAllSwHuList(swHu);
		return swHuList;
	}
	/**
	 * 添加收件人信息
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public boolean addSwInfo(SwHu swHu) {
		// 数据库新增一条收文审核记录,并返回是否插入成功
		Long pk = swHuDAO.addSwInfo(swHu);
		return isInsertSucc(pk);
	}

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public List<SwHu> getAllSwHuListAll(long id) {
		List<SwHu> swHuList = swHuDAO.getAllSwHuListAll(id);
		return swHuList;
	}
	/**
	 *修改收件人信息
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public boolean updateSwInfo(SwHu swHu) {
		Integer count = swHuDAO.updateSwInfo(swHu);
		return isUpdateSucc(count);
	}
	
}
