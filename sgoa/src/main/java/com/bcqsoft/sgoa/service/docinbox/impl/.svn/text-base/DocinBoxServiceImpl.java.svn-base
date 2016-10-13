package com.bcqsoft.sgoa.service.docinbox.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.docinbox.DocinBoxDAO;
import com.bcqsoft.sgoa.dao.docinbox.dataobject.DocinBox;
import com.bcqsoft.sgoa.service.docinbox.DocinBoxService;

/**
 * 信息发布模块业务逻辑类实现类
 */
@Service
public class DocinBoxServiceImpl extends BaseService implements DocinBoxService {

	/**
	 * 信息正式表数据库访问DAO接口
	 */
	@Autowired
	private DocinBoxDAO docinBoxDAO;

	/**
	 * 查找全部信息分类
	 * 
	 * @return 信息分类列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */

	@Override
	public List<DocinBox> getAllDocinBoxList(DocinBox docinBox) {
		List<DocinBox> docinBoxList = docinBoxDAO.getAllDocinBoxList(docinBox);
		return docinBoxList;
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
	public boolean addDocinInfo(DocinBox docinBox) {
		// 数据库新增一条收文审核记录,并返回是否插入成功
		Long pk = docinBoxDAO.addDocinInfo(docinBox);
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
	public List<DocinBox> getAllDocinBoxListAll(long id) {
		List<DocinBox> docinBoxList = docinBoxDAO.getAllDocinBoxListAll(id);
		return docinBoxList;
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
	public boolean updateDocinInfo(DocinBox docinBox) {
		Integer count = docinBoxDAO.updateDocinInfo(docinBox);
		return isUpdateSucc(count);
	}
}
