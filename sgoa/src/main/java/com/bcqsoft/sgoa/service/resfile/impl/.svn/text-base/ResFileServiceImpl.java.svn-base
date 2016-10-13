package com.bcqsoft.sgoa.service.resfile.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.sgoa.common.util.DateUtil;
import com.bcqsoft.sgoa.common.util.FtpFileUtil;
import com.bcqsoft.sgoa.core.base.BaseService;
import com.bcqsoft.sgoa.dao.dept.DeptDAO;
import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.resfile.ResFileDAO;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFile;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFilePage;
import com.bcqsoft.sgoa.dao.resshare.ResShareDAO;
import com.bcqsoft.sgoa.service.resfile.ResFileService;

@Service
public class ResFileServiceImpl extends BaseService implements ResFileService {

	@Autowired
	private ResFileDAO resFileDAO;

	@Autowired
	private ResShareDAO resShareDAO;
	
	/**
	 * 用户模块DAO实现类
	 */
	@Autowired
	private DeptDAO deptDAO;

	/**
	 * 创建一条新的文件
	 * 
	 * @param resFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	@Transactional(readOnly = false, rollbackFor = DataAccessException.class)
	public boolean createResFileInfo(ResFile resFile,
			MultipartFile srcUploadFile) {
		if (srcUploadFile != null && srcUploadFile.getSize() != 0) {
			String dateStr = DateUtil.getDateTimeForYh();
			// 文件上传
			try {
				InputStream input = srcUploadFile.getInputStream();
				FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK",
						"upload", 21);
				ftpUtil.connectServer("upload");
				ftpUtil.uploadFile(input,
						dateStr + "_" + srcUploadFile.getOriginalFilename());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resFile.setSrcFileName(dateStr + "_"
					+ srcUploadFile.getOriginalFilename());
		}

		Long pk = resFileDAO.insertIntoResFile(resFile);
		return isInsertSucc(pk);
	}

	/**
	 * 更新文件信息
	 * 
	 * @param resFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean updateResFileInfo(ResFile resFile) {
		Integer count = resFileDAO.updateResFileInfoById(resFile);
		return isUpdateSucc(count);
	}

	/**
	 * 更新文件信息
	 * 
	 * @param resFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public boolean editResFileInfo(ResFile resFile,MultipartFile srcUploadFile) {
		if (srcUploadFile != null && srcUploadFile.getSize() != 0) {
			String dateStr = DateUtil.getDateTimeForYh();
			// 文件上传
			try {
				InputStream input = srcUploadFile.getInputStream();
				FtpFileUtil ftpUtil = new FtpFileUtil("", "", "", "GBK",
						"upload", 21);
				ftpUtil.connectServer("upload");
				ftpUtil.uploadFile(input,
						dateStr + "_" + srcUploadFile.getOriginalFilename());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resFile.setSrcFileName(dateStr + "_"
					+ srcUploadFile.getOriginalFilename());
		}
		Integer count = resFileDAO.editResFileInfoById(resFile);
		return isUpdateSucc(count);
	}

	/**
	 * 取得上传文件列表(分页)
	 * 
	 * @param page
	 * @return ResFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public ResFilePage getResFileListByPage(ResFilePage page) {
		int count = resFileDAO.findResFileInfoCount(page);
		if (count == 0) {
			return page;
		}

		// 取得文件集合(分页查询)
		List<ResFile> resFileList = resFileDAO.findResFileInfoList(page);
		page.setTotalRow(count); // 文件总数量
		page.setResFileList(resFileList); // 文件集合
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
	public boolean deleteResFileInfo(Long id) {
		Integer count = resFileDAO.updateResFileStatusToDisabled(id);
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
	public boolean deleteResFileInfos(long[] idArray) {
		// 返回是否操作成功,成功删除数据即为操作成功
		boolean returnValue = false;
		int i = 0;
		// 循环删除文件记录
		// 先判断是否有已共享文件
		for (i = 0; i < idArray.length; i++) {
			ResFile resFile = new ResFile();
			resFile = getResFileDetailInfo(idArray[i]);
			if (("Y").equals(resFile.getIsShore())) {
				break;
			}
		}
		// 如果所有文件都没共享
		if (i == idArray.length) {
			for (long storageId : idArray) {
				// 物理删除,更新状态为不可用
				boolean isUpdate = deleteResFileInfo(storageId);
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
	 * @return ResFile
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public ResFile getResFileDetailInfo(Long id) {
		return resFileDAO.findResFileInfoById(id);
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
	public ResFilePage getResFileShareListByPage(ResFilePage page) {
		int count = resFileDAO.findResFileShareInfoCount(page);
		if (count == 0) {
			return page;
		}

		// 取得只浏览页面集合(分页查询)
		List<ResFile> resFileList = resFileDAO.findResFileShareInfoList(page);
		page.setTotalRow(count); // 文件总数量
		page.setResFileList(resFileList); // 文件集合
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
	public ResFilePage getResFileDownShareListByPage(ResFilePage page) {
		int count = resFileDAO.findResFileDownShareInfoCount(page);
		if (count == 0) {
			return page;
		}
		// 取得可下载集合(分页查询)
		List<ResFile> resFileList = resFileDAO
				.findResFileDownShareInfoList(page);
		page.setTotalRow(count); // 文件总数量
		page.setResFileList(resFileList); // 文件集合
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
	public boolean setResNOShare(Long id) {
		Integer count = resFileDAO.updateResFileShareToDisabled(id);
		resShareDAO.updateResShareStatusToDisabled(id);
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
	public ResFilePage getSearchResFileListByPage(ResFilePage resFilePage) {
		int count = resFileDAO.findSearchResFileInfoCount(resFilePage);
		if (count == 0) {
			return resFilePage;
		}

		// 取得文件集合(分页查询)
		List<ResFile> resFileList = resFileDAO
				.findSearchResFileInfoList(resFilePage);
		resFilePage.setTotalRow(count); // 文件总数量
		resFilePage.setResFileList(resFileList); // 文件集合
		return resFilePage;
	}

	@Override
	public boolean deleteResFileInfoById(long id) {
		Integer count = resFileDAO.updateResFileStatusToDisabled(id);
		return isUpdateSucc(count);
	}

	@Override
	public boolean deleteResFiles(long[] longArray) {
		boolean returnValue = false;
		// 循环删除通讯录
		// 如记录数量较多时,可以采用Ibatis中的Batch处理
		for (long id : longArray) {
			// 逻辑删除,更新状态为不可用
			boolean isUpdate = deleteResFileInfoById(id);
			// 某条更新成功即设置操作成功
			if (isUpdate) {
				returnValue = true;
			}
		}
		return returnValue;
	}

	/**
	 * 根据文件夹ID查找所有文件
	 * 
	 * @param
	 * @param
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-23
	 */
	public List<ResFile> findResFileInfoListByFolder(long folderId) {
		List<ResFile> resFileList = resFileDAO
				.findResFileInfoListByFolder(folderId);
		return resFileList;
	}
	
	/**
	 * 根据用户登录ID查询部门信息
	 * 
	 * @param loginId
	 * @return 部门信息
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public Dept findDeptInfoByLoginId(String loginId) {
		return deptDAO.findDeptInfoByLoginId(loginId);
	}
}
