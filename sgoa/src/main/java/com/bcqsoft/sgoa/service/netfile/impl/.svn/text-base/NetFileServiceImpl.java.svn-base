package com.bcqsoft.sgoa.service.netfile.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.netfile.NetFileDAO;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFile;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFilePage;
import com.bcqsoft.sgoa.dao.netshare.NetShareDAO;
import com.bcqsoft.sgoa.service.netfile.NetFileService;

@Service
public class NetFileServiceImpl extends BaseService implements NetFileService {

	@Autowired
	private NetFileDAO netFileDAO;

	@Autowired
	private NetShareDAO netShareDAO;

	/**
	 * 创建一条新的文件
	 * 
	 * @param netFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean createNetFileInfo(NetFile netFile) {
		Long pk = netFileDAO.insertIntoNetFile(netFile);
		return isInsertSucc(pk);
	}

	/**
	 * 更新文件信息
	 * 
	 * @param netFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean updateNetFileInfo(NetFile netFile) {
		Integer count = netFileDAO.updateNetFileInfoById(netFile);
		return isUpdateSucc(count);
	}

	/**
	 * 更新文件信息
	 * 
	 * @param netFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean editNetFileInfo(NetFile netFile) {
		Integer count = netFileDAO.editNetFileInfoById(netFile);
		return isUpdateSucc(count);
	}

	/**
	 * 取得上传文件列表(分页)
	 * 
	 * @param page
	 * @return NetFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public NetFilePage getNetFileListByPage(NetFilePage page) {
		int count = netFileDAO.findNetFileInfoCount(page);
		if (count == 0) {
			return page;
		}

		// 取得文件集合(分页查询)
		List<NetFile> netFileList = netFileDAO.findNetFileInfoList(page);
		page.setTotalRow(count); // 文件总数量
		page.setNetFileList(netFileList); // 文件集合
		return page;
	}

	/**
	 * 删除一条文件记录（物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean deleteNetFileInfo(Long id) {
		Integer count = netFileDAO.updateNetFileStatusToDisabled(id);
		return isUpdateSucc(count);
	}

	/**
	 * 删除上传文件(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzy
	 * @Date 2011-8-17
	 */
	public boolean deleteNetFileInfos(long[] idArray) {
		// 返回是否操作成功,成功删除数据即为操作成功
		boolean returnValue = false;
		int i = 0;
		// 循环删除文件记录
		// 先判断是否有已共享文件
		for (i = 0; i < idArray.length; i++) {
			NetFile netFile = new NetFile();
			netFile = getNetFileDetailInfo(idArray[i]);
			if (("Y").equals(netFile.getIsShore())) {
				break;
			}
		}
		// 如果所有文件都没共享
		if (i == idArray.length) {
			for (long storageId : idArray) {
				// 物理删除,更新状态为不可用
				boolean isUpdate = deleteNetFileInfo(storageId);
				if (isUpdate) {
					returnValue = true;
				}
			}
		}
		return returnValue;
	}

	/**
	 * 根据ID取得文件详细信息
	 * 
	 * @param id
	 * @return NetFile
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public NetFile getNetFileDetailInfo(Long id) {
		return netFileDAO.findNetFileInfoById(id);
	}

	/**
	 * 取得只浏览的页面（分页）
	 * 
	 * @param
	 * @return page
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public NetFilePage getNetFileShareListByPage(NetFilePage page) {
		int count = netFileDAO.findNetFileShareInfoCount(page);
		if (count == 0) {
			return page;
		}

		// 取得只浏览页面集合(分页查询)
		List<NetFile> netFileList = netFileDAO.findNetFileShareInfoList(page);
		page.setTotalRow(count); // 文件总数量
		page.setNetFileList(netFileList); // 文件集合
		return page;
	}

	/**
	 * 取得可下载页面（分页）
	 * 
	 * @param
	 * @return page
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public NetFilePage getNetFileDownShareListByPage(NetFilePage page) {
		int count = netFileDAO.findNetFileDownShareInfoCount(page);
		if (count == 0) {
			return page;
		}
		// 取得可下载集合(分页查询)
		List<NetFile> netFileList = netFileDAO
				.findNetFileDownShareInfoList(page);
		page.setTotalRow(count); // 文件总数量
		page.setNetFileList(netFileList); // 文件集合
		return page;
	}

	/**
	 * 根据ID设置文件为不共享
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean setNetNOShare(Long id) {
		Integer count = netFileDAO.updateNetFileShareToDisabled(id);
		netShareDAO.updateNetShareStatusToDisabled(id);
		return isUpdateSucc(count);
	}

	/**
	 * 所有查询共享的列表页面
	 * 
	 * @param
	 * @param
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	@Override
	public NetFilePage getSearchNetFileListByPage(NetFilePage netFilePage) {
		int count = netFileDAO.findSearchNetFileInfoCount(netFilePage);
		if (count == 0) {
			return netFilePage;
		}

		// 取得文件集合(分页查询)
		List<NetFile> netFileList = netFileDAO
				.findSearchNetFileInfoList(netFilePage);
		netFilePage.setTotalRow(count); // 文件总数量
		netFilePage.setNetFileList(netFileList); // 文件集合
		return netFilePage;
	}

	@Override
	public boolean deleteNetFileInfoById(long id) {
		Integer count = netFileDAO.updateNetFileStatusToDisabled(id);
		return isUpdateSucc(count);
	}

	@Override
	public boolean deleteNetFiles(long[] longArray) {
		boolean returnValue = false;
		// 循环删除通讯录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long id : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = deleteNetFileInfoById(id);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}
}
