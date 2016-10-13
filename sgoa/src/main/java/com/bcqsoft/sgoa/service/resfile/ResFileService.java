package com.bcqsoft.sgoa.service.resfile;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bcqsoft.sgoa.dao.dept.dataobject.Dept;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFile;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFilePage;

public interface ResFileService {

	/**
	 * 新增共享文件
	 * @param resFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean createResFileInfo(ResFile resFile,MultipartFile srcUploadFile);

	/**
	 * 更新文件信息
	 * 
	 * @param resFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean updateResFileInfo(ResFile resFile);
	/**
	 * 更新文件信息
	 * 
	 * @param resFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean editResFileInfo(ResFile resFile,MultipartFile srcUploadFile);


	/**
	 * 取得上传文件信息列表(分页)
	 * 
	 * @param page
	 * @return ResFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	ResFilePage getResFileListByPage(ResFilePage page);
	/**
	 * 取得被共享文件列表(只浏览，分页)
	 * 
	 * @param page
	 * @return ResFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	ResFilePage getResFileShareListByPage(ResFilePage page);
	/**
	 * 取得被共享文件列表(可下载，分页)
	 * 
	 * @param page
	 * @return ResFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	ResFilePage getResFileDownShareListByPage(ResFilePage page);
	/**
	 * 删除一条文件信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean deleteResFileInfo(Long id);
	/**
	 * 设置文件为不共享
	 * 
	 * @param page
	 * @return ResFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean setResNOShare(Long id);
	/**
	 * 删除上传文件(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzy
	 * @Date 2011-8-17
	 */
	boolean deleteResFileInfos(long[] idArray);

	/**
	 * 取得文件详细信息
	 * 
	 * @param id
	 * @return ResFile
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	ResFile getResFileDetailInfo(Long id);
 
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
	ResFilePage getSearchResFileListByPage(ResFilePage resFilePage);

	/**
	 * 删除一条共享(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	boolean deleteResFileInfoById(long id);

	/**
	 * 删除一条共享(逻辑批量删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	boolean deleteResFiles(long[] longArray);

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
	List<ResFile> findResFileInfoListByFolder(long folderId);
	
	/**
	 * 根据用户登录ID查询部门信息
	 * 
	 * @param loginId
	 * @return 部门信息
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Dept findDeptInfoByLoginId(String loginId);
}
