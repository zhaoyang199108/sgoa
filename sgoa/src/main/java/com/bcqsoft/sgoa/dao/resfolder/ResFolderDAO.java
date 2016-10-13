package com.bcqsoft.sgoa.dao.resfolder;

import java.util.List;
import java.util.Map;

import com.bcqsoft.sgoa.dao.resfolder.dataobject.ResFolder;

/**
 * 文件夹名称科室表(记录当前单位科室及下属单位科室)数据库访问DAO接口
 * 
 * <pre>
 * TABLE: SCOA_TB_DEPT
 * </pre>
 */
public interface ResFolderDAO {

	/**
	 * 查找全部文件夹名称信息列表
	 * 
	 * @return 文件夹名称信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<ResFolder> findAllResFolderInfo();
	
	/**
	 * 查找全部文件夹名称信息列表
	 * 
	 * @return 文件夹名称信息列表
	 * 
	 * @Author Bcqsoft.com zbq
	 * @Date 2011-12-22
	 */
	List<ResFolder> findResFolderInfoByLogin(String loginId);

	/**
	 * 插入信息至文件夹名称表
	 * 
	 * @param resFolder
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Long insertIntoResFolder(ResFolder resFolder);

	/**
	 * 根据ID查询某一条文件夹名称
	 * 
	 * @param id
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	ResFolder findResFolderInfoById(long id);

	/**
	 * 根据ID更新某条文件夹名称信息
	 * 
	 * @param dept
	 * @return
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Integer updateResFolderInfoById(ResFolder resFolder);

	/**
	 * 根据ID删除某条文件夹名称信息(逻辑删除,将该条信息状态变为不可用)
	 * 
	 * @param id
	 * @return 更新成功记录数
	 * 
	 * @Author Bcqsoft.com sbq
	 * @Date 2011-11-16
	 */
	Integer updateResFolderStatusToDisabled(Map<String, Object> map);
}
