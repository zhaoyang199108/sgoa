package com.bcqsoft.sgoa.dao.resfile;

import java.util.List;

import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFile;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFilePage;



/**
 * 资源(文件)表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_RES_FILE
 * </pre>
 */
public interface ResFileDAO {
	/**
	 * 插入一条信息至会议表
	 * 
	 * @param resFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Long insertIntoResFile(ResFile resFile);

	/**
	 * 根据查询条件查询符合条件的会议(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com 
	 * @Date 2011-12-09
	 */
	Integer findResFileInfoCount(ResFilePage page);
	Integer findResFileShareInfoCount(ResFilePage page);
	Integer findResFileDownShareInfoCount(ResFilePage page);
	/**
	 * 根据查询条件查询符合条件的会议
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com 
	 * @Date 2011-12-09
	 */

	List<ResFile> findResFileInfoList(ResFilePage page);
	List<ResFile> findResFileShareInfoList(ResFilePage page);
	List<ResFile> findResFileDownShareInfoList(ResFilePage page);

	/**
	 * 根据ID查询某一条通告通知
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	ResFile findResFileInfoById(long id);

	/**
	 * 根据ID更新某条施工会议
	 * 
	 * @param resFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Integer updateResFileInfoById(ResFile resFile);
	/**
	 * 根据ID更新某条施工会议
	 * 
	 * @param resFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Integer editResFileInfoById(ResFile resFile);
	

	/**
	 * 根据ID删除某条会议信息(物理删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Integer updateResFileStatusToDisabled(long id);
	Integer updateResFileShareToDisabled(long id);
	Integer updateMyResFileStatusToDisabled(long id,String delId);

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
	Integer findSearchResFileInfoCount(ResFilePage resFilePage);
	List<ResFile> findSearchResFileInfoList(ResFilePage resFilePage);
	
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
}
	
	


