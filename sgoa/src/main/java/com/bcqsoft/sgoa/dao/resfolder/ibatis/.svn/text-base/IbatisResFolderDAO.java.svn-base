package com.bcqsoft.sgoa.dao.resfolder.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bcqsoft.sgoa.core.base.BaseDAO;
import com.bcqsoft.sgoa.dao.resfolder.ResFolderDAO;
import com.bcqsoft.sgoa.dao.resfolder.dataobject.ResFolder;

/**
 * 部门科室表(记录当前单位科室及下属单位科室)数据库访问DAO实现类
 * 
 * <pre>
 * TABLE: SCOA_TB_DEPT
 * </pre>
 */
@Repository
public class IbatisResFolderDAO extends BaseDAO implements ResFolderDAO {

	/**
	 * 查找全部文件夹名称信息列表
	 * 
	 * @return 文件夹名称信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<ResFolder> findAllResFolderInfo() {
		return (List<ResFolder>) ibatis().queryForList("resfolder.findAllResFolderInfo");
	}
	
	/**
	 * 查找全部文件夹名称信息列表
	 * 
	 * @return 文件夹名称信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	@SuppressWarnings("unchecked")
	public List<ResFolder> findResFolderInfoByLogin(String loginId) {
		return (List<ResFolder>) ibatis().queryForList("resfolder.findResFolderInfoByLogin",loginId);
	}

	/**
	 * 插入信息至文件夹名称表
	 * 
	 * @param resFolder
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Long insertIntoResFolder(ResFolder resFolder) {
		return (Long) ibatis().insert("resfolder.insertIntoResFolder",
				resFolder);
	}

	/**
	 * 根据ID查询某一条文件夹名称
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public ResFolder findResFolderInfoById(long id) {
		return (ResFolder) ibatis().queryForObject(
				"resfolder.findResFolderInfoById", id);
	}

	/**
	 * 根据ID更新某条文件夹名称信息
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Integer updateResFolderInfoById(ResFolder resFolder) {
		return (Integer) ibatis().update("resfolder.updateResFolderInfoById",
				resFolder);
	}

	/**
	 * 根据ID删除某条文件夹名称信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	public Integer updateResFolderStatusToDisabled(Map<String, Object> data) {
		return (Integer) ibatis().update(
				"resfolder.updateResFolderStatusToDisabled", data);
	}
}
