package com.bcqsoft.sgoa.dao.netfile;

import java.util.List;

import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFile;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFilePage;




/**
 * 资源(文件)表数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_RES_FILE
 * </pre>
 */
public interface NetFileDAO {
	/**
	 * 插入一条信息至会议表
	 * 
	 * @param netFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Long insertIntoNetFile(NetFile netFile);

	/**
	 * 根据查询条件查询符合条件的会议(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com 
	 * @Date 2011-12-09
	 */
	Integer findNetFileInfoCount(NetFilePage page);
	Integer findNetFileShareInfoCount(NetFilePage page);
	Integer findNetFileDownShareInfoCount(NetFilePage page);
	/**
	 * 根据查询条件查询符合条件的会议
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com 
	 * @Date 2011-12-09
	 */

	List<NetFile> findNetFileInfoList(NetFilePage page);
	List<NetFile> findNetFileShareInfoList(NetFilePage page);
	List<NetFile> findNetFileDownShareInfoList(NetFilePage page);

	/**
	 * 根据ID查询某一条通告通知
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	NetFile findNetFileInfoById(long id);

	/**
	 * 根据ID更新某条施工会议
	 * 
	 * @param netFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Integer updateNetFileInfoById(NetFile netFile);
	/**
	 * 根据ID更新某条施工会议
	 * 
	 * @param netFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Integer editNetFileInfoById(NetFile netFile);
	

	/**
	 * 根据ID删除某条会议信息(物理删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	Integer updateNetFileStatusToDisabled(long id);
	Integer updateNetFileShareToDisabled(long id);
	Integer updateMyNetFileStatusToDisabled(long id,String delId);

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
	Integer findSearchNetFileInfoCount(NetFilePage resFilePage);
	List<NetFile> findSearchNetFileInfoList(NetFilePage resFilePage);
	

}
	
	


