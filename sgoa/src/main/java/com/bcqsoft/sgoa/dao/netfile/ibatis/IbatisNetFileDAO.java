package com.bcqsoft.sgoa.dao.netfile.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.netfile.NetFileDAO;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFile;
import com.bcqsoft.sgoa.dao.netfile.dataobject.NetFilePage;


/**
 * 资源(文件)表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_RES_FILE
 * </pre>
 */
@Repository
public class IbatisNetFileDAO extends BaseDAO implements NetFileDAO {
	
	public Long insertIntoNetFile(NetFile netFile) {
		return (Long) ibatis().insert("netfile.insertIntoNetFile", netFile);
	}

	/**
	 * 根据查询条件查询符合条件的共享(页面分页使用)
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */

	public Integer findNetFileInfoCount(NetFilePage page) {
		return (Integer) ibatis().queryForObject("netfile.findNetFileInfoCount", page);
	}

	/**
	 * 根据查询条件查询符合条件的共享
	 * 
	 * @param page
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */

	@SuppressWarnings("unchecked")
	public List<NetFile> findNetFileInfoList(NetFilePage page) {
		return (List<NetFile>) ibatis().queryForList("netfile.findNetFileInfoList", page);
	}

	/**
	 * 根据ID查询某一条通告通知
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public NetFile findNetFileInfoById(long id) {
		return (NetFile) ibatis().queryForObject("netfile.findNetFileInfoById", id);
	}

	/**
	 * 根据ID更新某条共享信息
	 * 
	 * @param netFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public Integer updateNetFileInfoById(NetFile netFile) {
		return (Integer) ibatis().update("netfile.updateNetFileInfoById", netFile);
	}
	/**
	 * 根据ID更新某条共享信息
	 * 
	 * @param netFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public Integer editNetFileInfoById(NetFile netFile) {
		return (Integer) ibatis().update("netfile.editNetFileInfoById", netFile);
	}
	/**
	 * 根据ID删除某条共享信息(物理删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public Integer updateNetFileStatusToDisabled(long id) {
		return (Integer) ibatis().delete("netfile.deleteNetFileToDisabled", id);
	}

	public Integer updateMyNetFileStatusToDisabled(long id ,String delId) {
		return (Integer) ibatis().delete("netfile.deleteMyNetFileToDisabled", id);
	}
	@SuppressWarnings("unchecked")
	public List<NetFile> findAllNetFileInfo() {
		// TODO Auto-generated method stub
		return (List<NetFile>) ibatis().queryForList("netfile.findAllNetFileInfo");
	}

	@Override
	public Integer findNetFileShareInfoCount(NetFilePage page) {
		return (Integer) ibatis().queryForObject("netfile.findNetFileShareInfoCount", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NetFile> findNetFileShareInfoList(NetFilePage page) {
		// TODO Auto-generated method stub
		return (List<NetFile>) ibatis().queryForList("netfile.findNetFileShareInfoList", page);
	}
	
	@Override
	public Integer findNetFileDownShareInfoCount(NetFilePage page) {
		return (Integer) ibatis().queryForObject("netfile.findNetFileDownShareInfoCount", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NetFile> findNetFileDownShareInfoList(NetFilePage page) {
		// TODO Auto-generated method stub
		return (List<NetFile>) ibatis().queryForList("netfile.findNetFileDownShareInfoList", page);
	}

	@Override
	public Integer updateNetFileShareToDisabled(long id) {
		return (Integer) ibatis().update("netfile.updateNetFileShareToDisabled", id);
		
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
	public Integer findSearchNetFileInfoCount(NetFilePage resFilePage) {
		return (Integer) ibatis().queryForObject("netfile.findSearchNetFileInfoCount", resFilePage);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NetFile> findSearchNetFileInfoList(NetFilePage resFilePage) {
		return (List<NetFile>) ibatis().queryForList("netfile.findSearchNetFileInfoList", resFilePage);
	}
}
