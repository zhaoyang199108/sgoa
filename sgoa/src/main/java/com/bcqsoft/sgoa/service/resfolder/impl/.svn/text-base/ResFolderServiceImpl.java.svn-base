package com.bcqsoft.sgoa.service.resfolder.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.resfolder.ResFolderDAO;
import com.bcqsoft.sgoa.dao.resfolder.dataobject.ResFolder;
import com.bcqsoft.sgoa.service.resfolder.ResFolderService;

@Service
public class ResFolderServiceImpl extends BaseService implements ResFolderService {
	
	/**
	 * 文件夹名称模块的DAO实现类
	 */
	@Autowired
	private ResFolderDAO resFolderDAO;
	
	/**
	 * 文件夹名称列表ID
	 * 
	 */
	private List<Long> strList = null;

	/**
	 * 创建一条新的文件夹名称
	 * 
	 * @param resFolder
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public boolean createResFolderInfo(ResFolder resFolder) {
		Long pk = resFolderDAO.insertIntoResFolder(resFolder);
		return isInsertSucc(pk);
	}

	/**
	 * 更新文件夹名称信息
	 * 
	 * @param resFolder
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public boolean updateResFolderInfo(ResFolder resFolder) {
		Integer count = resFolderDAO.updateResFolderInfoById(resFolder);
		return isUpdateSucc(count);
	}

	/**
	 * 取得文件夹名称列表(分页)
	 * 
	 * @param page
	 * @return DeptPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public List<ResFolder> getResFolderListByAll() {
		// 取得文件夹名称集合(分页查询)
		List<ResFolder> resFolderList = resFolderDAO.findAllResFolderInfo();
		return resFolderList;
	}
	
	/**
	 * 取得登录ID下的文件夹名称列表
	 * 
	 * @param page
	 * @return DeptPage
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public List<ResFolder> getResFolderListByLoginId(String loginId) {
		// 取得文件夹名称集合(分页查询)
		List<ResFolder> resFolderList = resFolderDAO.findResFolderInfoByLogin(loginId);
		return resFolderList;
	}

	/**
	 * 删除一条文件夹名称(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public void deleteResFolderInfo(Long id,String loginId) {
		// 取得所有文件夹名称列表
		List<ResFolder> resFolderList = resFolderDAO.findResFolderInfoByLogin(loginId);
		strList = new ArrayList<Long>();
		// 取得登录人文件夹名称下的所有文件夹名称ID
		getNodeString(resFolderList, id);
		// 对文件夹名称下的所有文件夹名称进行删除
		resFolderDAO.updateResFolderStatusToDisabled(toMap("idList", strList));
		// 删除文件夹名称下的所有用户
		// userDAO.deleteUserInfoByIds(toMap("idList", strList));

	}

	/**
	 * 取得文件夹名称详细信息
	 * 
	 * @param id
	 * @return resFolder
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public ResFolder getResFolderDetailInfo(Long id) {
		return resFolderDAO.findResFolderInfoById(id);
	}

	/**
	 * 取得所有登录人下的所有文件夹名称节点
	 */
	private void getNodeString(List<ResFolder> resFolderList, Long unitId) {
		strList.add(unitId);
		for (ResFolder resFolder : resFolderList) {

			if (unitId.equals(resFolder.getUnitId())) {
				strList.add(resFolder.getId());
				getNodeString(resFolderList, resFolder.getId());
			}
		}
	}
}
