package com.bcqsoft.sgoa.service.ipmac.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.ipmac.IpmacDAO;
import com.bcqsoft.sgoa.dao.ipmac.dataobject.Ipmac;
import com.bcqsoft.sgoa.dao.ipmac.dataobject.IpmacPage;
import com.bcqsoft.sgoa.service.ipmac.IpmacService;

@Service
public class IpmacServiceImpl extends BaseService implements IpmacService {

	@Autowired
	private IpmacDAO ipmacDAO;

	/**
	 * 创建一条新的IP/MAC
	 * 
	 * @param ipmac
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public boolean createIpmacInfo(Ipmac ipmac) {
		Long pk = ipmacDAO.insertIntoIpmac(ipmac);
		return isInsertSucc(pk);
	}

	/**
	 * 更新IP/MAC信息
	 * 
	 * @param ipmac
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public boolean updateIpmacInfo(Ipmac ipmac) {
		Integer count = ipmacDAO.updateIpmacInfoById(ipmac);
		return isUpdateSucc(count);
	}

	/**
	 * 取得IP/MAC列表(分页)
	 * 
	 * @param page
	 * @return IpmacPage
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public IpmacPage getIpmacListByPage(IpmacPage page) {
		int count = ipmacDAO.findIpmacInfoCount(page);
		if (count == 0) {
			return page;
		}

		// 取得IP/MAC集合(分页查询)
		List<Ipmac> ipmacList = ipmacDAO.findIpmacInfoList(page);

		page.setTotalRow(count); // IP/MAC总数量
		page.setIpmacList(ipmacList); // IP/MAC集合

		return page;
	}

	/**
	 * 删除一条IP/MAC(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public boolean deleteIpmacInfo(Long id) {
		Integer count = ipmacDAO.updateIpmacStatusToDisabled(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除IP/MAC(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author cql
	 * @Date 2013-5-13
	 */
	public boolean deleteIpmacInfos(long[] idArray) {
		// 返回是否操作成功,成功删除一条数据即为操作成功
		boolean returnValue = false;
		// 循环删除仓库记录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long storageId : idArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = deleteIpmacInfo(storageId);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 取得IP/MAC详细信息
	 * 
	 * @param id
	 * @return Ipmac
	 * 
	 * @Author Bcqsoft.com cql
	 * @Date 2013-5-13
	 */
	public Ipmac getIpmacDetailInfo(Long id) {
		return ipmacDAO.findIpmacInfoById(id);
	}

	@Override
	public Integer findIpmacInfoCount(IpmacPage ipmacpage) {
		int count = ipmacDAO.findIpmacInfoCount(ipmacpage);
		return count;
	}

}
