package com.bcqsoft.xhlm.service.xwk.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.xhlm.core.base.BaseService;
import com.bcqsoft.xhlm.dao.xwk.XwkDAO;
import com.bcqsoft.xhlm.dao.xwk.dataobject.Xwk;
import com.bcqsoft.xhlm.dao.xwk.dataobject.XwkPage;
import com.bcqsoft.xhlm.service.xwk.XwkService;

/**
 * 类别详细模块业务逻辑类接口
 */
@Service
public class XwkServiceImpl extends BaseService implements XwkService {
	/**
	 * 类别详细数据库访问层Ibatis接口
	 * 
	 */
	@Autowired
	private XwkDAO xwkDAO;
	/**
	 * 添加类别详细信息
	 * 
	 * @param xwk
	 * @return 是否添加成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean createXwk(Xwk xwk) {
		// 数据库新增一条类别详细记录,并返回是否插入成功
		Long pk = xwkDAO.insertIntoXwk(xwk);
		return isInsertSucc(pk);
	}

	/**
	 * 修改类别详细信息
	 * 
	 * @param xwk
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean modifyXwk(Xwk xwk) {
		// 更新该条类别详细信息,并返回是更新成功
		Integer count = xwkDAO.updateXwkInfoById(xwk);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细信息
	 * 
	 * @param xwkId
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean deleteXwk(long xwkId) {
		// 删除该条类别详细信息,并返回是否删除成功
		Integer count = xwkDAO.deleteXwkInfoById(xwkId);
		// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
		//xwkRoleDAO.deleteXwkRoleById(xwkId);
		return isUpdateSucc(count);
	}

	/**
	 * 删除类别详细(多选框批量删除)
	 * 
	 * @param idArray
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public boolean deleteXwks(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long xwkId : idArray) {
			// 删除类别详细信息
			Integer count = xwkDAO.deleteXwkInfoById(xwkId);
			// 删除该类别详细Id的类别详细角色信息,并返回是否删除成功
			//xwkRoleDAO.deleteXwkRoleById(xwkId);
			// 某条更新成功即设置操作成功
			if (count != null && count > 0) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID查找某一类别详细的信息
	 * 
	 * @param xwkId
	 * @return Xwk
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public Xwk getXwkInfo(long xwkId) {
		Xwk xwk = xwkDAO.getXwkInfo(xwkId);
		return xwk;
	}

	/**
	 * 根据查询条件查找类别详细信息列表
	 * 
	 * @param id
	 * @return 类别详细分页对象
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	public XwkPage getXwkInfoList(XwkPage page) {
		int count = xwkDAO.findXwkInfoCount(page);

		if (count == 0) {
			return page;
		}
		// 取得类别详细信息集合(分页查询)
		List<Xwk> xwkList = xwkDAO.findXwkInfoList(page);		
		page.setTotalRow(count); // 类别详细总数量
		page.setXwkList(xwkList); // 类别详细信息集合
		return page;
	}

	/**
	 * 根据sortId查询条件查找类别分类详细信息列表
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author lzn
	 * @Date 2013-06-26
	 */
	@Override
	public XwkPage getAllXwkForList(XwkPage page) {
		// 取得类别详细信息集合(分页查询)
		List<Xwk> xwkList = xwkDAO.findXwkInfoListById(page);
		page.setXwkList(xwkList); // 类别详细信息集合
		return page;
	}
}