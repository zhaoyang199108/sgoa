package com.bcqsoft.sgoa.service.netfile;


import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFile;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFilePage;

public interface NetFileService {

	/**
	 * 新增共享文件
	 * @param netFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean createNetFileInfo(NetFile netFile);

	/**
	 * 更新文件信息
	 * 
	 * @param netFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean updateNetFileInfo(NetFile netFile);
	/**
	 * 更新文件信息
	 * 
	 * @param netFile
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean editNetFileInfo(NetFile netFile);


	/**
	 * 取得上传文件信息列表(分页)
	 * 
	 * @param page
	 * @return NetFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	NetFilePage getNetFileListByPage(NetFilePage page);
	/**
	 * 取得被共享文件列表(只浏览，分页)
	 * 
	 * @param page
	 * @return NetFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	NetFilePage getNetFileShareListByPage(NetFilePage page);
	/**
	 * 取得被共享文件列表(可下载，分页)
	 * 
	 * @param page
	 * @return NetFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	NetFilePage getNetFileDownShareListByPage(NetFilePage page);
	/**
	 * 删除一条文件信息(物理删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean deleteNetFileInfo(Long id);
	/**
	 * 设置文件为不共享
	 * 
	 * @param page
	 * @return NetFilePage
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	boolean setNetNOShare(Long id);
	/**
	 * 删除上传文件(多选框批量删除)
	 * 
	 * @param id
	 * @return 是否修改成功(True:成功, False:失败)
	 * 
	 * @Author lzy
	 * @Date 2011-8-17
	 */
	boolean deleteNetFileInfos(long[] idArray);

	/**
	 * 取得文件详细信息
	 * 
	 * @param id
	 * @return NetFile
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	NetFile getNetFileDetailInfo(Long id);
 
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
	NetFilePage getSearchNetFileListByPage(NetFilePage netFilePage);

	/**
	 * 删除一条共享(逻辑删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	boolean deleteNetFileInfoById(long id);

	/**
	 * 删除一条共享(逻辑批量删除)
	 * 
	 * @param id
	 * @return True:修改成功, Flase:修改失败
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-12-26
	 */
	boolean deleteNetFiles(long[] longArray);

}
