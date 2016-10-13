package com.bcqsoft.sgoa.dao.resfile.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.resfile.ResFileDAO;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFile;
import com.bcqsoft.sgoa.dao.resfile.dataobject.ResFilePage;

/**
 * 资源(文件)表数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_RES_FILE
 * </pre>
 */
@Repository
public class IbatisResFileDAO extends BaseDAO implements ResFileDAO {
	public Long insertIntoResFile(ResFile resFile) {
		return (Long) ibatis().insert("resfile.insertIntoResFile", resFile);
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

	public Integer findResFileInfoCount(ResFilePage page) {
		return (Integer) ibatis().queryForObject("resfile.findResFileInfoCount", page);
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
	public List<ResFile> findResFileInfoList(ResFilePage page) {
		return (List<ResFile>) ibatis().queryForList("resfile.findResFileInfoList", page);
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
	public ResFile findResFileInfoById(long id) {
		return (ResFile) ibatis().queryForObject("resfile.findResFileInfoById", id);
	}

	/**
	 * 根据ID更新某条共享信息
	 * 
	 * @param resFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public Integer updateResFileInfoById(ResFile resFile) {
		return (Integer) ibatis().update("resfile.updateResFileInfoById", resFile);
	}
	/**
	 * 根据ID更新某条共享信息
	 * 
	 * @param resFile
	 * @return
	 * 
	 * @Author Bcqsoft.com lzy
	 * @Date 2011-11-16
	 */
	public Integer editResFileInfoById(ResFile resFile) {
		return (Integer) ibatis().update("resfile.editResFileInfoById", resFile);
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
	public Integer updateResFileStatusToDisabled(long id) {
		return (Integer) ibatis().delete("resfile.deleteResFileToDisabled", id);
	}

	public Integer updateMyResFileStatusToDisabled(long id ,String delId) {
		return (Integer) ibatis().delete("resfile.deleteMyResFileToDisabled", id);
	}
	@SuppressWarnings("unchecked")
	public List<ResFile> findAllResFileInfo() {
		// TODO Auto-generated method stub
		return (List<ResFile>) ibatis().queryForList("resfile.findAllResFileInfo");
	}

	@Override
	public Integer findResFileShareInfoCount(ResFilePage page) {
		return (Integer) ibatis().queryForObject("resfile.findResFileShareInfoCount", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResFile> findResFileShareInfoList(ResFilePage page) {
		// TODO Auto-generated method stub
		return (List<ResFile>) ibatis().queryForList("resfile.findResFileShareInfoList", page);
	}
	
	@Override
	public Integer findResFileDownShareInfoCount(ResFilePage page) {
		return (Integer) ibatis().queryForObject("resfile.findResFileDownShareInfoCount", page);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResFile> findResFileDownShareInfoList(ResFilePage page) {
		// TODO Auto-generated method stub
		return (List<ResFile>) ibatis().queryForList("resfile.findResFileDownShareInfoList", page);
	}

	@Override
	public Integer updateResFileShareToDisabled(long id) {
		return (Integer) ibatis().update("resfile.updateResFileShareToDisabled", id);
		
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
	public Integer findSearchResFileInfoCount(ResFilePage resFilePage) {
		return (Integer) ibatis().queryForObject("resfile.findSearchResFileInfoCount", resFilePage);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResFile> findSearchResFileInfoList(ResFilePage resFilePage) {
		return (List<ResFile>) ibatis().queryForList("resfile.findSearchResFileInfoList", resFilePage);
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
	@SuppressWarnings("unchecked")
	public List<ResFile> findResFileInfoListByFolder(long folderId){
		return (List<ResFile>) ibatis().queryForList("resfile.findResFileInfoListByFolder", folderId);
	}
}
